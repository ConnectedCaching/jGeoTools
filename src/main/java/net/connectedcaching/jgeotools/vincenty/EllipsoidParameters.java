package net.connectedcaching.jgeotools.vincenty;

public class EllipsoidParameters {

	public EllipsoidParameters(Double a, Double b, Double f) {
		this.equatorialAxis = a;
		this.polarAxis = b;
		this.inverseFlattening = f;
	}

	private Double equatorialAxis;
	private Double polarAxis;
	private Double inverseFlattening;

	public Double getEquatorialAxis() {
		return equatorialAxis;
	}

	public Double getPolarAxis() {
		return polarAxis;
	}

	public Double getInverseFlattening() {
		return inverseFlattening;
	}

	public Double getFlattening() {
		return 1 / inverseFlattening;
	}

}
