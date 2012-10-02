package net.connectedcaching.jgeotools;

import java.util.HashMap;
import java.util.Map;

public abstract class Distance {

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

	public static Distance between(GeoPoint p1, GeoPoint p2) {
		return new PointToPointDistance(p1, p2);
	}

	public static Distance meters(Double meters) {
		return new FixedDistance(meters);
	}

	public static Distance kilometers(Double kilometers) {
		return Distance.of(kilometers, MetricUnit.kilometers);
	}

	public static Distance feet(Double feet) {
		return Distance.of(feet, ImperialUnit.feet);
	}

	public static Distance yards(Double yards) {
		return Distance.of(yards, ImperialUnit.yards);
	}

	public static Distance miles(Double miles) {
		return Distance.of(miles, ImperialUnit.miles);
	}

	public static Distance of(Double amount, MetricUnit unit) {
		return new FixedDistance(amount / metricFactors.get(unit));
	}

	public static Distance of(Double amount, ImperialUnit unit) {
		return new FixedDistance(amount / imperialFactors.get(unit));
	}

	protected abstract Double getDistanceInMeters();

	public Distance add(Distance that) {
		return Distance.meters(this.getDistanceInMeters() + that.getDistanceInMeters());
	}

	public Distance subtract(Distance that) {
		return Distance.meters(this.getDistanceInMeters() - that.getDistanceInMeters());
	}

	public Double in(MetricUnit unit) {
		return getDistanceInMeters() * metricFactors.get(unit);
	}

	public Double in(ImperialUnit unit) {
		return getDistanceInMeters() * imperialFactors.get(unit);
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) { return true; }
		if (!(other instanceof Distance)) { return false; }
		return this.getDistanceInMeters().equals(((Distance) other).getDistanceInMeters());
	}

}
