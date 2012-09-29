package net.connectedcaching.jgeotools;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class GeoPoint {

	protected Double latitude;
	protected Double longitude;

	private GeoPoint() {}

	public static GeoPoint parse(Double latitude, Double longitude) {
		GeoPoint point = new GeoPoint();
		point.latitude = latitude;
		point.longitude = longitude;
		return point;
	}

	public String as(GeoPointFormat format) {
		return as(format, Locale.getDefault());
	}

	public String as(GeoPointFormat format, Locale locale) {
		switch (format) {
			case DegreesMinutesSeconds: return asDms(locale);
		}
		return "";
	}

	private String decimalToDms(Double coordinate, Locale locale) {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(locale);
		df.applyPattern("#.###");
		coordinate = Math.abs(coordinate);
		Double fractionalPart = coordinate % 1;
		String degrees = String.valueOf(coordinate.intValue());
		coordinate = fractionalPart * 60;
		fractionalPart = coordinate % 1;
		String minutes = String.valueOf(coordinate.intValue());
		coordinate = fractionalPart * 60;
		return String.format("%s° %s' %s\"", degrees, minutes, df.format(coordinate));
	}

	public String asDms() {
		return asDms(Locale.getDefault());
	}

	public String asDms(Locale locale) {
		String latitudeDirection = latitude > 0 ? "N" : "S";
		String longitudeDirection = longitude > 0 ? "E" : "W";
		return String.format("%s%s %s%s",
			latitude != 0 ? latitudeDirection : "", decimalToDms(latitude, locale),
			longitude != 0 ? longitudeDirection : "", decimalToDms(longitude, locale));
	}

}
