package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools._
import java.util.Locale
import vincenty.Ellipsoid

class GeoPointSpec extends Specification with BeforeAfter {

	val defaultLocale = Locale.getDefault

	def before {
		Locale.setDefault(Locale.ENGLISH)
	}

	"GeoPoint to DD (decimal degree) conversion" should {

		"return whatever you put in" in {
			val geoPoint = GeoPoint.parse(46.414167, 6.927500)
			geoPoint.asDd must be equalTo("46.414167, 6.9275")
		}

		"truncate trailing zeros" in {
			val geoPoint = GeoPoint.parse(46.41400, 6.927500)
			geoPoint.asDd must be equalTo("46.414, 6.9275")
		}

		"have a maximum precision of 6 decimal places" in {
			val geoPoint = GeoPoint.parse(46.414167123, 6.927500123)
			geoPoint.asDd must be equalTo("46.414167, 6.9275")
		}

		"be able to output localized results" in {
			val geoPoint = GeoPoint.parse(-33.855270, 151.209725)
			geoPoint.asDd(Locale.GERMAN) must be equalTo("-33,85527, 151,209725")
		}

		"work correctly when using the parameterized as" in {
			val geoPoint = GeoPoint.parse(46.414167, 6.927500)
			geoPoint.as(GeoPointFormat.DD) must be equalTo(geoPoint.asDd)
			geoPoint.as(GeoPointFormat.DecimalDegrees) must be equalTo(geoPoint.as(GeoPointFormat.DD))
		}

		"work correctly when using the parameterized as and a specific locale" in {
			val geoPoint = GeoPoint.parse(-14.170074, -141.236336)
			geoPoint.as(GeoPointFormat.DecimalDegrees, Locale.GERMAN) must be equalTo("-14,170074, -141,236336")
		}

	}

	"GeoPoint to DM (decimal minutes) conversion" should {

		"work correctly for NE coordinates" in {
			val geoPoint = GeoPoint.parse(46.414167, 6.927500)
			geoPoint.asDm must be equalTo("N46° 24.850 E006° 55.650")
		}

		"work correctly for SE coordinates" in {
			val geoPoint = GeoPoint.parse(-33.855270, 151.209725)
			geoPoint.asDm must be equalTo("S33° 51.316 E151° 12.583")
		}

		"work correctly for NW coordinates" in {
			val geoPoint = GeoPoint.parse(50.116973, -122.945424)
			geoPoint.asDm must be equalTo("N50° 07.018 W122° 56.725")
		}

		"work correctly for SW coordinates" in {
			val geoPoint = GeoPoint.parse(-14.170074, -141.236336)
			geoPoint.asDm must be equalTo("S14° 10.204 W141° 14.180")
		}

	}

	"GeoPoint to DMS (degrees, minutes, seconds) conversion" should {

		"work correctly for NE coordinates" in {
			val geoPoint = GeoPoint.parse(46.414167, 6.927500)
			geoPoint.asDms must be equalTo("N46° 24' 51.001\" E6° 55' 39\"")
		}

		"work correctly for SE coordinates" in {
			val geoPoint = GeoPoint.parse(-33.855270, 151.209725)
			geoPoint.asDms must be equalTo("S33° 51' 18.972\" E151° 12' 35.01\"")
		}

		"work correctly for NW coordinates" in {
			val geoPoint = GeoPoint.parse(50.116973, -122.945424)
			geoPoint.asDms must be equalTo("N50° 7' 1.103\" W122° 56' 43.526\"")
		}

		"work correctly for SW coordinates" in {
			val geoPoint = GeoPoint.parse(-14.170074, -141.236336)
			geoPoint.asDms must be equalTo("S14° 10' 12.266\" W141° 14' 10.81\"")
		}

		"work correctly for zero latitude and longitude" in {
			val geoPoint = GeoPoint.parse(0, 0)
			geoPoint.asDms must be equalTo("0° 0' 0\" 0° 0' 0\"")
		}

		"be able to output localized results" in {
			val geoPoint = GeoPoint.parse(-33.855270, 151.209725)
			geoPoint.asDms(Locale.GERMAN) must be equalTo("S33° 51' 18,972\" E151° 12' 35,01\"")
		}

		"work correctly when using the parameterized as" in {
			val geoPoint = GeoPoint.parse(46.414167, 6.927500)
			geoPoint.as(GeoPointFormat.DMS) must be equalTo(geoPoint.asDms)
			geoPoint.as(GeoPointFormat.DegreesMinutesSeconds) must be equalTo(geoPoint.as(GeoPointFormat.DMS))
		}

		"work correctly when using the parameterized as and a specific locale" in {
			val geoPoint = GeoPoint.parse(46.414167, 6.927500)
			geoPoint.as(GeoPointFormat.DegreesMinutesSeconds, Locale.GERMAN) must be equalTo(geoPoint.asDms(Locale.GERMAN))
		}

	}

	"GeoPoint projection" should {

		val geoPoint = GeoPoint.parse(0.0, 0.0)

		"return a new GeoPoint" in {
			val p2 = geoPoint.project(Distance.kilometers(5), Bearing.decimalDegrees(90))
			p2 must beAnInstanceOf[GeoPoint]
			p2 must not beTheSameAs(geoPoint)
		}

	}

	"Conversion between reference ellipsoids" should {

		"work if no true conversion has to be done" in {
			val geoPoint = GeoPoint.parse(0.0, 0.0, Ellipsoid.WGS84)
			geoPoint.convertTo(GeoConstants.DEFAULT_ELLIPSOID) must beAnInstanceOf[GeoPoint]
			geoPoint.convertTo(GeoConstants.DEFAULT_ELLIPSOID).getReferenceEllipsoid must be equalTo(GeoConstants.DEFAULT_ELLIPSOID)
		}

		"throw an exception for true conversions since they are not yet supported" in {
			GeoPoint.parse(0.0, 0.0).convertTo(Ellipsoid.GRS80) must throwAn[UnsupportedOperationException]
		}

	}

	"GeoPoint parsing" should {

		"return a GeoPoint for valid decimal degree input" in {
			GeoPoint.parse("-33.855270°, 151.209725°") must beAnInstanceOf[GeoPoint]
			GeoPoint.parse("-33.855270 151.209725") must beAnInstanceOf[GeoPoint]
		}

		"throw a RuntimeException for garbage input" in {
			GeoPoint.parse("Foobaz") must throwA[RuntimeException]
		}

	}

	def after {
		Locale.setDefault(defaultLocale)
	}

}
