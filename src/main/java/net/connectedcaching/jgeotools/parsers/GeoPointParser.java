package net.connectedcaching.jgeotools.parsers;

import net.connectedcaching.jgeotools.vincenty.Ellipsoid;
import net.connectedcaching.jgeotools.GeoPoint;

public abstract class GeoPointParser {

	public abstract boolean canParse(String input);

	public GeoPoint parse(String input) {
		return parse(input, Ellipsoid.WGS84);
	}

	public abstract GeoPoint parse(String input, Ellipsoid referenceEllipsoid);

}
