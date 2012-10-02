package net.connectedcaching.jgeotools.parsers;

import net.connectedcaching.jgeotools.GeoPoint;
import net.connectedcaching.jgeotools.ReferenceEllipsoid;

public abstract class GeoPointParser {

	public abstract boolean canParse(String input);

	public GeoPoint parse(String input) {
		return parse(input, ReferenceEllipsoid.WGS84);
	}

	public abstract GeoPoint parse(String input, ReferenceEllipsoid ellipsoid);

}
