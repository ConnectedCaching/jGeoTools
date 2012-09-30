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
		return new FixedDistance(kilometers * 1 / metricFactors.get(MetricUnit.kilometers));
	}

	protected abstract Double getDistanceInMeters();

	public Double in(MetricUnit unit) {
		Double factor = metricFactors.get(unit);
		return getDistanceInMeters() * factor;
	}

	public Double in(ImperialUnit unit) {
		Double factor = imperialFactors.get(unit);
		return getDistanceInMeters() * factor;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) { return true; }
		if (!(other instanceof Distance)) { return false; }
		return this.getDistanceInMeters().equals(((Distance) other).getDistanceInMeters());
	}

}
