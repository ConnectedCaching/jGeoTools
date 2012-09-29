package net.connectedcaching.jgeotools;

import java.util.HashMap;
import java.util.Map;

public class Distance {

	// base unit for all computations is meters
	protected static final Double EARTH_RADIUS = 6371009.0;
	protected static final Map<MetricUnit, Double> metricFactors = new HashMap<MetricUnit, Double>();
	protected static final Map<ImperialUnit, Double> imperialFactors = new HashMap<ImperialUnit, Double>();
	static
	{
		metricFactors.put(MetricUnit.meters, 1.0);
		metricFactors.put(MetricUnit.kilometers, 0.001);
		imperialFactors.put(ImperialUnit.feet, 3.2808399);
		imperialFactors.put(ImperialUnit.yards, 1.0936133);
		imperialFactors.put(ImperialUnit.miles, 0.000621371192);
	}

	private Distance() {}

	public static Distance between(GeoPoint p1, GeoPoint p2) {
		Distance distance = new Distance();
		distance.p1 = p1;
		distance.p2 = p2;
		return distance;
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

	public Double in(MetricUnit unit) {
		Double factor = metricFactors.get(unit);
		return getHaversineDistance() * factor;
	}

	public Double in(ImperialUnit unit) {
		Double factor = imperialFactors.get(unit);
		return getHaversineDistance() * factor;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) { return true; }
		if (!(other instanceof Distance)) { return false; }
		Distance d = (Distance) other;
		return (this.p1.equals(d.p1) && this.p2.equals(d.p2)) || (this.p1.equals(d.p2) && this.p2.equals(d.p1));
	}

}
