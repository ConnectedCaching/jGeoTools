package net.connectedcaching.jgeotools.vincenty;

public class EllipsoidParameters {

	public EllipsoidParameters(Double a, Double b, Double f) {
		this.equatorialAxis = a;
		this.polarAxis = b;
		this.inverseFlattening = f;
	}

	public Double equatorialAxis;
	public Double polarAxis;
	public Double inverseFlattening;

}
