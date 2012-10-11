package net.connectedcaching.jgeotools.parsers.gpx.gpx10;

import java.math.BigDecimal;

import org.simpleframework.xml.*;


@Root(name = "boundsType")
@Default(DefaultType.FIELD)
public class BoundsType {

	@Attribute(required = true)
	protected BigDecimal minlat;
	@Attribute(required = true)
	protected BigDecimal minlon;
	@Attribute(required = true)
	protected BigDecimal maxlat;
	@Attribute(required = true)
	protected BigDecimal maxlon;

	public BigDecimal getMinlat() {
		return minlat;
	}

	public void setMinlat(BigDecimal value) {
		this.minlat = value;
	}

	public BigDecimal getMinlon() {
		return minlon;
	}

	public void setMinlon(BigDecimal value) {
		this.minlon = value;
	}

	public BigDecimal getMaxlat() {
		return maxlat;
	}

	public void setMaxlat(BigDecimal value) {
		this.maxlat = value;
	}

	public BigDecimal getMaxlon() {
		return maxlon;
	}

	public void setMaxlon(BigDecimal value) {
		this.maxlon = value;
	}

}
