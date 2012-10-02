package net.connectedcaching.jgeotools;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class GeoPoint {

	protected Double latitude;
	protected Double longitude;
	protected ReferenceEllipsoid ellipsoid;

	private GeoPoint() {}

	public static GeoPoint parse(Double latitude, Double longitude) {
		return parse(latitude, longitude, ReferenceEllipsoid.WGS84);
	}

	public static GeoPoint parse(Double latitude, Double longitude, ReferenceEllipsoid ellipsoid) {
		GeoPoint point = new GeoPoint();
		point.latitude = latitude;
		point.longitude = longitude;
		point.ellipsoid = ellipsoid;
		return point;
	}

	public String as(GeoPointFormat format) {
		return as(format, Locale.getDefault());
	}

	public String as(GeoPointFormat format, Locale locale) {
		switch (format) {
			case DD: return asDd(locale);
			case DecimalDegrees: return asDd(locale);
			case DM: return asDm(locale);
			case DecimalMinutes: return asDm(locale);
			case DMS: return asDms(locale);
			case DegreesMinutesSeconds: return asDms(locale);
		}
		return "";
	}

	public String asDd() {
		return asDd(Locale.getDefault());
	}

	public String asDd(Locale locale) {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(locale);
		// 6 decimal places = ~11cm precision
		df.applyPattern("#.######");
		return String.format("%s, %s", df.format(latitude), df.format(longitude));
	}

	private String decimalToDm(Double coordinate, String degreeFormatPattern, Locale locale) {
		DecimalFormat degreeFormat = (DecimalFormat) NumberFormat.getInstance(locale);
		degreeFormat.applyPattern(degreeFormatPattern);
		DecimalFormat minuteFormat = (DecimalFormat) NumberFormat.getInstance(locale);
		minuteFormat.applyPattern("00.000");
		coordinate = Math.abs(coordinate);
		Double fractionalPart = coordinate % 1;
		Integer degrees = coordinate.intValue();
		coordinate = fractionalPart * 60;
		return String.format("%s° %s", degreeFormat.format(degrees), minuteFormat.format(coordinate));
	}

	public String asDm() {
		return asDm(Locale.getDefault());
	}

	public String asDm(Locale locale) {
		String latitudeDirection = latitude > 0 ? "N" : "S";
		String longitudeDirection = longitude > 0 ? "E" : "W";
		return String.format("%s%s %s%s",
				latitude != 0 ? latitudeDirection : "", decimalToDm(latitude, "00", locale),
				longitude != 0 ? longitudeDirection : "", decimalToDm(longitude, "000", locale));
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

	public Bearing bearingTo(GeoPoint that) {
		return Bearing.between(this, that);
	}

	public Bearing initialBearingTo(GeoPoint that) {
		return bearingTo(that);
	}

	public Bearing finalBearingTo(GeoPoint that) {
		return Bearing.decimalDegrees((Bearing.between(that, this).decimalDegrees() + 180) % 360);
	}

	public Distance distanceTo(GeoPoint that) {
		return Distance.between(this, that);
	}

	public GeoPoint project(Distance distance, Bearing bearing) {

		Double d = distance.in(MetricUnit.meters);
		Double dR = d / distance.EARTH_RADIUS;

		Double latitude = Math.asin(Math.sin(this.getLatitudeRadians()) *
				Math.cos(dR) + Math.cos(this.getLatitudeRadians()) *
				Math.sin(dR) * Math.cos(bearing.radians()));

		Double longitude = this.getLongitudeRadians() + Math.atan2(Math.sin(bearing.radians()) *
				Math.sin(dR) * Math.cos(this.getLatitudeRadians()),
				Math.cos(dR) - Math.sin(this.getLatitudeRadians()) *
				Math.sin(latitude));

		longitude = (longitude + 3 * Math.PI) % (2 * Math.PI) - Math.PI;

		return GeoPoint.parse(Math.toDegrees(latitude), Math.toDegrees(longitude));

	}

	public Double getLatitude() {
		return latitude;
	}

	protected Double getLatitudeRadians() {
		return Math.toRadians(latitude);
	}

	public Double getLongitude() {
		return longitude;
	}

	protected Double getLongitudeRadians() {
		return Math.toRadians(longitude);
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) { return true; }
		if (!(other instanceof GeoPoint)) { return false; }
		GeoPoint d = (GeoPoint) other;
		return this.latitude.equals(d.latitude) && this.longitude.equals(d.longitude);
	}

}
