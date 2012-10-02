package net.connectedcaching.jgeotools;

public class Projection {

	public Projection(GeoPoint from, Distance distance, Bearing heading) {
		this.from = from;
		this.distance = distance;
		this.bearing = heading;
	}

	protected GeoPoint from;
	protected Distance distance;
	protected Bearing bearing;

	public GeoPoint project() {

		Double d = distance.in(MetricUnit.meters);
		Double dR = d / GeoConstants.EARTH_RADIUS;

		Double latitude = Math.asin(Math.sin(from.getLatitudeRadians()) *
				Math.cos(dR) + Math.cos(from.getLatitudeRadians()) *
				Math.sin(dR) * Math.cos(bearing.radians()));

		Double longitude = from.getLongitudeRadians() + Math.atan2(Math.sin(bearing.radians()) *
				Math.sin(dR) * Math.cos(from.getLatitudeRadians()),
				Math.cos(dR) - Math.sin(from.getLatitudeRadians()) *
						Math.sin(latitude));

		longitude = (longitude + 3 * Math.PI) % (2 * Math.PI) - Math.PI;

		return GeoPoint.parse(Math.toDegrees(latitude), Math.toDegrees(longitude), from.getReferenceEllipsoid());

	}

}
