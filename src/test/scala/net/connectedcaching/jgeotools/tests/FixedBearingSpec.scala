package net.connectedcaching.jgeotools.tests

import org.specs2.mutable._
import net.connectedcaching.jgeotools.Bearing

class FixedBearingSpec extends Specification {

	"A fixed bearing" should {

		"return whatever you put in when using degrees" in {
			Bearing.decimalDegrees(90.5).decimalDegrees must be equalTo(90.5)
		}

		"be suitable for conversion between decimal degrees and radians" in {
			Bearing.decimalDegrees(90).radians must be equalTo(1.5707963267948966)
			Bearing.radians(1).decimalDegrees must be equalTo(57.29577951308232)
		}

		"not allow degrees out of range" in {
			Bearing.decimalDegrees(370).decimalDegrees must be equalTo(10.0)
			Bearing.decimalDegrees(-10).decimalDegrees must be equalTo(350.0)
			Bearing.decimalDegrees(-370).decimalDegrees must be equalTo(350.0)
		}

	}

}
