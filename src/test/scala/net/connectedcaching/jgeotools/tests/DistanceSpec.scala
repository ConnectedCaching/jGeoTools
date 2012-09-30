package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{FixedDistance, PointToPointDistance, Distance, GeoPoint}

class DistanceSpec extends Specification {

	"Distance" should {

		"return a PointToPointDistance for between" in {
			val d = Distance.between(GeoPoint.parse(0, 0), GeoPoint.parse(1, 1))
			d must beAnInstanceOf[PointToPointDistance]
		}

		"return a FixedDistance when using the fixed distance factory methods" in {
			Distance.meters(5) must beAnInstanceOf[FixedDistance]
			Distance.kilometers(42) must beAnInstanceOf[FixedDistance]
		}

	}

}
