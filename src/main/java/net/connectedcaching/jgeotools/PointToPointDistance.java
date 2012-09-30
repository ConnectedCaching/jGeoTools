package net.connectedcaching.jgeotools;

import java.util.HashMap;
import java.util.Map;

public class PointToPointDistance extends Distance {

	// base unit for all computations is meters
	protected static final Double EARTH_RADIUS = 6371009.0;

	public PointToPointDistance(GeoPoint p1, GeoPoint p2) {
		this.p1 = p1;
		this.p2 = p2;
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
				Math.cos(Math.toRadians(p1.getLatitude())) * Math.cos(Math.toRadians(p2.getLatitude()));
		Double angularDistance = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));
		return EARTH_RADIUS * angularDistance;
	}

	@Override
	protected Double getDistanceInMeters() {
		return getHaversineDistance();
	}

}
