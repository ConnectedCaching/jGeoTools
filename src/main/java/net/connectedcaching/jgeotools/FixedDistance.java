package net.connectedcaching.jgeotools;

public class FixedDistance extends Distance {

	protected Double meters;

	public FixedDistance(Double meters) {
		this.meters = meters;
	}

	@Override
	protected Double getDistanceInMeters() {
		return meters;
	}

}
