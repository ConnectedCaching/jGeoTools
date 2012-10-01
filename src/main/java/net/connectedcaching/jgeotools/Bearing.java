package net.connectedcaching.jgeotools;

public abstract class Bearing {

	public static Bearing degrees(Double degrees) {
		return decimalDegrees(degrees);
	}

	public static Bearing decimalDegrees(Double degrees) {
		return new FixedBearing(degrees);
	}

	public static Bearing radians(Double radians) {
		return new FixedBearing(Math.toDegrees(radians));
	}

	public static Bearing between(GeoPoint p1, GeoPoint p2) {
		return new PointToPointBearing(p1, p2);
	}

	protected abstract Double getBearingInDecimalDegrees();

	public Double degrees() {
		return decimalDegrees();
	}

	public Double decimalDegrees() {
		return getBearingInDecimalDegrees();
	}

	public Double radians() {
		return Math.toRadians(getBearingInDecimalDegrees());
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) { return true; }
		if (!(other instanceof Bearing)) { return false; }
		return this.getBearingInDecimalDegrees().equals(((Bearing) other).getBearingInDecimalDegrees());
	}

}
