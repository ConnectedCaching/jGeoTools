package net.connectedcaching.jgeotools;

import net.connectedcaching.jgeotools.vincenty.Ellipsoid;
import net.connectedcaching.jgeotools.vincenty.EllipsoidParameters;

import java.util.HashMap;
import java.util.Map;

public class GeoConstants {

	// base unit for all computations is meters
	public static final Double EARTH_RADIUS = 6371009.0;

	public static final Map<Ellipsoid, EllipsoidParameters> REFERENCE_ELLIPSOIDS = new HashMap<Ellipsoid, EllipsoidParameters>();
	static {
		REFERENCE_ELLIPSOIDS.put(Ellipsoid.GRS80, new EllipsoidParameters(6378137.0, 6356752.314140, 298.257222101));
		REFERENCE_ELLIPSOIDS.put(Ellipsoid.WGS84, new EllipsoidParameters(6378137.0, 6356752.3142, 298.257223563));
	}

}
