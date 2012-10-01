package net.connectedcaching.jgeotools;

public class FixedBearing extends Bearing {

	protected Double degrees;

	public FixedBearing(Double decimalDegrees) {
		this.degrees = decimalDegrees % 360;
		if (this.degrees < 0) {
			this.degrees += 360;
		}
	}

	@Override
	protected Double getBearingInDecimalDegrees() {
		return degrees;
	}

}
