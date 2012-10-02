package net.connectedcaching.jgeotools.parsers;

import net.connectedcaching.jgeotools.Ellipsoid;
import net.connectedcaching.jgeotools.GeoPoint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalDegreeParser extends GeoPointParser {

	protected Pattern coordinatePattern = Pattern.compile("^(-?\\d+?[.,]\\d+)°? ?,? ?(-?\\d+?[.,]\\d+)°?$");

	@Override
	public boolean canParse(String input) {
		Matcher matcher = coordinatePattern.matcher(input);
		return matcher.matches();
	}

	@Override
	public GeoPoint parse(String input, Ellipsoid ellipsoid) {
		Matcher matcher = coordinatePattern.matcher(input);
		matcher.find();
		Double latitude = Double.parseDouble(matcher.group(1)) % 90;
		Double longitude = Double.parseDouble(matcher.group(2)) % 180;
		return GeoPoint.parse(latitude, longitude, ellipsoid);
	}

}
