package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.{ImperialUnit, MetricUnit, FixedDistance, Distance}

class FixedDistanceSpec extends Specification {

	"A fixed distance" should {

		"return whatever you put in when using meters" in {
			val d = new FixedDistance(12367)
			d.in(MetricUnit.meters) must be equalTo(12367)
		}

		"be suitable for conversion between metric units" in {
			val d = new FixedDistance(10000)
			d.in(MetricUnit.kilometers) must be equalTo(10.0)
		}

		"be suitable for conversion between metric and imperial units" in {
			val d = new FixedDistance(10000)
			math.round(d.in(ImperialUnit.feet)) must be equalTo(32808)
		}

	}

}
