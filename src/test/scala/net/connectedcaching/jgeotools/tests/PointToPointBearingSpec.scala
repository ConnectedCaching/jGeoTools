package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{Bearing, GeoPoint}

class PointToPointBearingSpec extends Specification {

	"Bearing computation" should {

		val p1 = GeoPoint.parse(51.129552, 1.321179)
		val p2 = GeoPoint.parse(50.117111, -5.477593)

		"work with zero bearing" in {
			p1.bearingTo(p1) must be equalTo(Bearing.degrees(0))
		}

		"deliver correct results" in {
			p1.bearingTo(p2) must be equalTo(p1.initialBearingTo(p2))
			p1.bearingTo(p2).decimalDegrees must be equalTo(259.4343762289729)
			p1.finalBearingTo(p2).decimalDegrees must be equalTo(254.17629278737843)
		}

	}

}
