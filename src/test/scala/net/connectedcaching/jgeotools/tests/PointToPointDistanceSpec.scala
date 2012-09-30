package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{Distance, MetricUnit, GeoPoint}

class PointToPointDistanceSpec extends Specification {

	"Distance computation" should {

		val p1 = GeoPoint.parse(50.117111, -5.477593)
		val p2 = GeoPoint.parse(51.129552, 1.321179)

		"be reflexive" in {
			val distance = Distance.between(p1, p2)
			distance must be equalTo(distance)
		}

		"be commutative" in {
			p1.distanceTo(p2) must be equalTo(p2.distanceTo(p1))
		}

		"deliver correct results" in {
			math.round(Distance.between(p1, p2).in(MetricUnit.meters)) must be equalTo(492451)
		}

		"be consistent accross different metric units" in {
			val meters = Distance.between(p1, p2).in(MetricUnit.meters)
			val kilometers = Distance.between(p1, p2).in(MetricUnit.kilometers)
			kilometers must be equalTo(meters / 1000)
		}

	}

}
