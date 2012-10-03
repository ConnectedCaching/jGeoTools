package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{Distance, MetricUnit, GeoPoint}
import net.connectedcaching.jgeotools.vincenty.Ellipsoid

class PointToPointDistanceSpec extends Specification {

	val p1 = GeoPoint.parse(50.117111, -5.477593)
	val p2 = GeoPoint.parse(51.129552, 1.321179)

	"Distance computation" should {

		"be reflexive" in {
			val distance = Distance.between(p1, p2)
			distance must be equalTo(distance)
		}

		"work with zero distance" in {
			p1.distanceTo(p1) must be equalTo(Distance.meters(0))
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

		"fail if the two GeoPoints have different reference ellipsoids" in {
			val p3 = GeoPoint.parse(0.0, 0.0, Ellipsoid.GRS80)
			p3.distanceTo(p1) must throwAn[UnsupportedOperationException]
			p2.distanceTo(p3) must throwAn[UnsupportedOperationException]
		}

	}

	"Midpoint computation" should {

		"be callable from GeoPoint" in {
			val midpoint = p1.midpointTo(p2)
			midpoint must beAnInstanceOf[GeoPoint]
			midpoint.getReferenceEllipsoid must be equalTo(p1.getReferenceEllipsoid)
			midpoint must not beTheSameAs(p1)
			midpoint must not beTheSameAs(p2)
		}

		"return the correct result" in {
			// accuracy of reference point ~11.1m
			p1.midpointTo(p2).distanceTo(GeoPoint.parse(50.6728, -2.1148)).in(MetricUnit.meters) must be lessThan(10)
		}

	}

}
