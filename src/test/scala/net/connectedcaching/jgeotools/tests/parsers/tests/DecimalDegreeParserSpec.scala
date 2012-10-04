package net.connectedcaching.jgeotools.tests.parsers.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.parsers.DecimalDegreeParser
import net.connectedcaching.jgeotools.{GeoPoint, GeoConstants}

class DecimalDegreeParserSpec extends Specification {

	val parser = new DecimalDegreeParser();

	"A DecimalDegreeParser" should {

		"match all standard formats for decimal degrees" in {
			parser.canParse("46.414167, -6.927500") must beTrue
			parser.canParse("46.414167°, 6.927500°") must beTrue
			parser.canParse("46.414167 6.927500") must beTrue
			parser.canParse("-46.414167 , 6.927500") must beTrue
			parser.canParse("38.889722°, -77.008889°") must beTrue
		}

		"not match garbage input" in {
			parser.canParse("LOL KITTENZ 1.1, 2.2") must beFalse
			parser.canParse("1.0 1.0, 1.0") must beFalse
			parser.canParse("") must beFalse
			parser.canParse(" ") must beFalse
		}

		"not match localized input" in {
			parser.canParse("38,889722°, -77,008889°") must beFalse
		}

		"parse the correct numbers for NE coordinates" in {
			val geoPoint = parser.parse("46.414167°, 6.927500°", GeoConstants.DEFAULT_ELLIPSOID)
			geoPoint.getLatitude must be equalTo(46.414167)
			geoPoint.getLongitude must be equalTo(6.927500)
		}

		"parse the correct numbers for SE coordinates" in {
			val geoPoint = parser.parse("-33.855270°, 151.209725°", GeoConstants.DEFAULT_ELLIPSOID)
			geoPoint.getLatitude must be equalTo(-33.855270)
			geoPoint.getLongitude must be equalTo(151.209725)
		}

		"parse the correct numbers for NW coordinates" in {
			val geoPoint = parser.parse("50.116973°, -122.945424°", GeoConstants.DEFAULT_ELLIPSOID)
			geoPoint.getLatitude must be equalTo(50.116973)
			geoPoint.getLongitude must be equalTo(-122.945424)
		}

		"parse the correct numbers for SW coordinates" in {
			val geoPoint = parser.parse("-14.170074°, -141.236336°", GeoConstants.DEFAULT_ELLIPSOID)
			geoPoint.getLatitude must be equalTo(-14.170074)
			geoPoint.getLongitude must be equalTo(-141.236336)
		}

		"work for zero latitude and longitude" in {
			val geoPoint = parser.parse("0.0°, 0.0°", GeoConstants.DEFAULT_ELLIPSOID)
			geoPoint.getLatitude must be equalTo(0.0)
			geoPoint.getLongitude must be equalTo(0.0)
		}

	}

}
