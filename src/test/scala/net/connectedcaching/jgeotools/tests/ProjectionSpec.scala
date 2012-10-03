package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{MetricUnit, Bearing, Distance, GeoPoint}

class ProjectionSpec extends Specification {

	val geoPoint = GeoPoint.parse(-33.636292, 151.331842)

	"A Projection" should {


		"return a new GeoPoint" in {
			geoPoint.project(Distance.meters(100), Bearing.decimalDegrees(90)) must beAnInstanceOf[GeoPoint]
		}

		"be chainable" in {
			val p2 = geoPoint
					.project(Distance.meters(100), Bearing.decimalDegrees(0))
					.project(Distance.meters(100), Bearing.decimalDegrees(90))
					.project(Distance.meters(100), Bearing.decimalDegrees(180))
					.project(Distance.meters(100), Bearing.decimalDegrees(270))
			// delta comparison of the two GeoPoints - accuracy 1.5mm
			p2.distanceTo(geoPoint).in(MetricUnit.meters) must be lessThan(0.0015)
		}

		"have the expected distance" in {
			val p2 = geoPoint.project(Distance.meters(587), Bearing.decimalDegrees(237))
			math.round(Distance.between(geoPoint, p2).in(MetricUnit.meters)) must be equalTo(587)
		}

		"have the expected bearing" in {
			val p2 = geoPoint.project(Distance.kilometers(1), Bearing.degrees(90))
			math.round(geoPoint.bearingTo(p2).decimalDegrees) must be equalTo(90)
		}

		"return the a correctly projected GeoPoint" in {
			val p2 = geoPoint.project(Distance.meters(300), Bearing.decimalDegrees(10))
			p2.asDms must be equalTo("S33° 38' 1.086\" E151° 19' 56.657\"")
		}

	}

}
