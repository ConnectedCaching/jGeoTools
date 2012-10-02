package net.connectedcaching.jgeotools;

public class Projection {

	public static Projection from(GeoPoint from) {
		Projection p = new Projection();
		p.from = from;
		return p;
	}

	private Projection() {}

	protected GeoPoint from;
	protected Distance distance = Distance.meters(0.0);
	protected Bearing bearing;

	public Projection go(Distance distance)	 {
		this.distance = distance;
		return this;
	}

	public GeoPoint heading(Bearing bearing) {
		this.bearing = bearing;
		return project();
	}

	private GeoPoint project() {
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

		return GeoPoint.parse(Math.toDegrees(latitude), Math.toDegrees(longitude));
	}

}
