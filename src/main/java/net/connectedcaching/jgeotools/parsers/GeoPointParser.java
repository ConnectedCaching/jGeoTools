package net.connectedcaching.jgeotools.parsers;

import net.connectedcaching.jgeotools.vincenty.Ellipsoid;
import net.connectedcaching.jgeotools.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public abstract class GeoPointParser {

	private static List<GeoPointParser> registeredParsers = new ArrayList<GeoPointParser>();
	static {
		registeredParsers.add(new DecimalDegreeParser());
	}

	public static GeoPointParser getParserFor(String coordinates) {
		for (GeoPointParser parser : registeredParsers) {
			if (parser.canParse(coordinates)) {
				return parser;
			}
		}
		throw new RuntimeException("Could not find a parser for the given input");
	}

	public abstract boolean canParse(String input);

	public abstract GeoPoint parse(String input, Ellipsoid referenceEllipsoid);

}
