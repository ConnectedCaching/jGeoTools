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

	public GeoPoint midpoint() {
		Double bx = Math.cos(p2.getLatitudeRadians()) * Math.cos(getLongitudeDistance());
		Double by = Math.cos(p2.getLatitudeRadians()) * Math.sin(getLongitudeDistance());
		Double latitude = Math.atan2(Math.sin(p1.getLatitudeRadians()) + Math.sin(p2.getLatitudeRadians()),
				Math.sqrt(Math.pow(Math.cos(p1.getLatitudeRadians()) + bx, 2) + Math.pow(by, 2)));
		Double longitude = p1.getLongitudeRadians() + Math.atan2(by, Math.cos(p1.getLatitudeRadians()) + bx);
		longitude = (longitude + 3 * Math.PI) % (2 * Math.PI) - Math.PI;
		return GeoPoint.parse(Math.toDegrees(latitude), Math.toDegrees(longitude), p1.getReferenceEllipsoid());
	}

}
