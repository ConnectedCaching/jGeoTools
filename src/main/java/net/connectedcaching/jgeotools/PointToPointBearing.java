package net.connectedcaching.jgeotools;

public class PointToPointBearing extends Bearing {

	public PointToPointBearing(GeoPoint from, GeoPoint to) {
		this.from = from;
		this.to = to;
	}

	protected GeoPoint from;
	protected GeoPoint to;

	private Double getBearing() {
		Double longitudeDistance = Math.toRadians(to.getLongitude() - from.getLongitude());
		Double x = Math.cos(from.getLatitudeRadians()) * Math.sin(to.getLatitudeRadians()) -
				Math.sin(from.getLatitudeRadians()) * Math.cos(to.getLatitudeRadians()) * Math.cos(longitudeDistance);
		Double y = Math.sin(longitudeDistance) * Math.cos(to.getLatitudeRadians());
		Double bearing = Math.atan2(y, x);
		return (Math.toDegrees(bearing) + 360) % 360;
	}

	@Override
	protected Double getBearingInDecimalDegrees() {
		return getBearing();
	}

}
