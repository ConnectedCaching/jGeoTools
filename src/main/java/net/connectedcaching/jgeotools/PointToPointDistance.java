package net.connectedcaching.jgeotools;

public class PointToPointDistance extends Distance {

	public PointToPointDistance(GeoPoint p1, GeoPoint p2) {
		this.p1 = p1;
		this.p2 = p2.convertTo(p1.getReferenceEllipsoid());
	}

	protected GeoPoint p1;
	protected GeoPoint p2;

	protected Double getLatitudeDistance() {
		return Math.toRadians(p2.getLatitude() - p1.getLatitude());
	}

	protected Double getLongitudeDistance() {
		return Math.toRadians(p2.getLongitude() - p1.getLongitude());
	}

	protected Double getHaversineDistance() {
		Double a = Math.pow(Math.sin(getLatitudeDistance() / 2.0), 2) +
				Math.pow(Math.sin(getLongitudeDistance() / 2.0), 2) *
				Math.cos(p1.getLatitudeRadians()) * Math.cos(p2.getLatitudeRadians());
		Double angularDistance = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));
		return GeoConstants.EARTH_RADIUS * angularDistance;
	}

	@Override
	protected Double getDistanceInMeters() {
		return getHaversineDistance();
	}

}
