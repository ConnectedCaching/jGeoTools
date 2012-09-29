package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.GeoPoint
import java.util.Locale

class GeoPointSpec extends Specification with BeforeAfter {

	val defaultLocale = Locale.getDefault

	def before {
		Locale.setDefault(Locale.ENGLISH)
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

	}

	def after {
		Locale.setDefault(defaultLocale)
	}

}
