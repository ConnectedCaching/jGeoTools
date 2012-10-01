package net.connectedcaching.jgeotools;

public class Bearing {

	public static Bearing decimalDegrees(Double degrees) {
		return new Bearing(degrees);
	}

	public static Bearing radians(Double radians) {
		return new Bearing(Math.toDegrees(radians));
	}

	public Bearing(Double decimalDegrees) {
		this.degrees = decimalDegrees;
	}

	protected Double degrees;

	public Double decimalDegrees() {
		return degrees;
	}

	public Double radians() {
		return Math.toRadians(degrees);
	}

}
