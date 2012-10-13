package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Order(elements = {
		"date",
		"type",
		"finder",
		"text",
		"log_wpt"
})
@Default(required = false)
public class Log {

	protected GregorianCalendar date;
	protected String type;
	protected User finder;
	protected Log.Text text;
	@ElementList(name = "log_wpt", required = false)
	protected List<Log.LogWpt> logWpt;
	@org.simpleframework.xml.Attribute
	protected String id;

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar value) {
		this.date = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public User getFinder() {
		return this.finder;
	}

	public void setFinder(User value) {
		this.finder = value;
	}

	public Log.Text getText() {
		return this.text;
	}

	public void setText(Text value) {
		this.text = value;
	}

	public List<Log.LogWpt> getLogWpt() {
		if (logWpt == null) {
			logWpt = new ArrayList<Log.LogWpt>();
		}
		return this.logWpt;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}


	@Default(required = false)
	public static class LogWpt {

		@org.simpleframework.xml.Attribute
		protected String lat;
		@org.simpleframework.xml.Attribute
		protected String lon;

		public String getLat() {
			return lat;
		}

		public void setLat(String value) {
			this.lat = value;
		}

		public String getLon() {
			return lon;
		}

		public void setLon(String value) {
			this.lon = value;
		}

	}


	@Default(required = false)
	public static class Text {

		@org.simpleframework.xml.Text
		protected String value;
		@org.simpleframework.xml.Attribute(name = "encoded")
		protected Boolean isEncoded;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Boolean isEncoded() {
			return isEncoded;
		}

		public void setIsEncoded(Boolean value) {
			this.isEncoded = value;
		}

	}

}
