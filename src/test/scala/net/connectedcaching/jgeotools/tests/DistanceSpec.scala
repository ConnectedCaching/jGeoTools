package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools._

class DistanceSpec extends Specification {

	val p1 = GeoPoint.parse(0, 0)
	val p2 = GeoPoint.parse(1, 1)

	"Distance" should {

		"return a PointToPointDistance for between" in {
			val d = Distance.between(p1, p2)
			d must beAnInstanceOf[PointToPointDistance]
		}

		"return a FixedDistance when using the fixed distance factory methods" in {
			Distance.meters(5) must beAnInstanceOf[FixedDistance]
			Distance.kilometers(42) must beAnInstanceOf[FixedDistance]
		}

	}

	"Calculation with distances" should {

		"return a FixedDistance" in {
			Distance.between(p1, p2).add(Distance.meters(100)) must beAnInstanceOf[FixedDistance]
			Distance.between(p1, p2).subtract(Distance.meters(100)) must beAnInstanceOf[FixedDistance]
		}

		"work as expected from basic math" in {
			Distance.meters(50).add(Distance.kilometers(1)) must be equalTo(Distance.kilometers(1.05))
			Distance.meters(500).subtract(Distance.meters(250)) must be equalTo(Distance.meters(250))
		}

		"work accross metric and imperial units" in {
			math.round(Distance.meters(100).add(Distance.yards(50)).in(MetricUnit.meters)) must be equalTo(146)
		}

	}

}
