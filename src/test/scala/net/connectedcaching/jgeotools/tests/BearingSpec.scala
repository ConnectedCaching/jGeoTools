package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{FixedBearing, PointToPointBearing, Bearing, GeoPoint}

class BearingSpec extends Specification {

	val p1 = GeoPoint.parse(0, 0)
	val p2 = GeoPoint.parse(1, 1)

	"The Bearing class" should {

		"return a PointToPointBearing for between" in {
			Bearing.between(p1, p2) must beAnInstanceOf[PointToPointBearing]
		}

		"return a FixedBearing for degrees and radians" in {
			Bearing.decimalDegrees(90) must beAnInstanceOf[FixedBearing]
			Bearing.radians(90) must beAnInstanceOf[FixedBearing]
		}

	}

}
