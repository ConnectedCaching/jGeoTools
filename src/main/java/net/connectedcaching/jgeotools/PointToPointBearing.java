package net.connectedcaching.jgeotools;

public class PointToPointBearing extends Bearing {

	public PointToPointBearing(GeoPoint from, GeoPoint to) {
		this.from = from;
		this.to = to;
	}

	protected GeoPoint from;
	protected GeoPoint to;

	/*var lat1 = this._lat.toRad(), lat2 = point._lat.toRad();
	var dLon = (point._lon-this._lon).toRad();

	var y = Math.sin(dLon) * Math.cos(lat2);
	var x = Math.cos(lat1)*Math.sin(lat2) -
			Math.sin(lat1)*Math.cos(lat2)*Math.cos(dLon);
	var brng = Math.atan2(y, x);

	return (brng.toDeg()+360) % 360;*/

	private Double getBearing() {
		Double longitudeDistance = Math.toRadians(to.getLongitude() - from.getLongitude());
		Double x = Math.cos(from.getLatitudeRadians()) * Math.sin(to.getLatitudeRadians()) -
				Math.sin(from.getLatitudeRadians()) * Math.cos(to.getLatitudeRadians()) * Math.cos(longitudeDistance);
		Double y = Math.sin(longitudeDistance) * Math.cos(to.getLatitudeRadians());
		Double bearing = Math.atan2(y, x);
		return (Math.toDegrees(bearing) + 360) % 360;
	}

	@Override
	protected Double getBearingInDecimalDegrees() {
		return getBearing();
	}

}
