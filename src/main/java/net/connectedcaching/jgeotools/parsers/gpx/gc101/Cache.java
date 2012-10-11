package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.*;


/*@Order(elements = {
	"name",
	"placed_by",
	"owner",
	"type",
	"container",
	"attributes",
	"difficulty",
	"terrain",
	"country",
	"state",
	"shortDescription",
	"longDescription",
	"encoded_hints",
	"logs",
	"travelbugs"
})*/
@Root(name = "cache", strict = false)
@Namespace(reference = "http://www.groundspeak.com/cache/1/0/1")
@Default(required = false)
public class Cache {

	protected String name;
	@Element(name = "placed_by", required = false)
	protected String placedBy;
	@ElementList(inline = true, required = false)
	protected List<Cache.Owner> owner;
	protected String type;
	protected String container;
	protected List<Cache.Attribute> attributes;
	protected String difficulty;
	protected String terrain;
	protected String country;
	protected String state;
	@ElementList(name = "short_description", inline = true, required = false)
	protected List<Cache.ShortDescription> shortDescription;
	@ElementList(name = "long_description", inline = true, required = false)
	protected List<Cache.LongDescription> longDescription;
	@Element(name = "encoded_hints")
	protected String encodedHints;
	@ElementList(inline = true, required = false)
	protected List<Cache.Log> logs;
	@ElementList(inline = true, required = false)
	protected List<Cache.Travelbug> travelbugs;
	@org.simpleframework.xml.Attribute
	protected String id;
	@org.simpleframework.xml.Attribute
	protected String available;
	@org.simpleframework.xml.Attribute
	protected String archived;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getPlacedBy() {
		return placedBy;
	}

	public void setPlacedBy(String value) {
		this.placedBy = value;
	}

	public List<Cache.Owner> getOwner() {
		if (owner == null) {
			owner = new ArrayList<Cache.Owner>();
		}
		return this.owner;
	}

	 public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String value) {
		this.container = value;
	}

	public List<Cache.Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList<Cache.Attribute>();
		}
		return this.attributes;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String value) {
		this.difficulty = value;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String value) {
		this.terrain = value;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String value) {
		this.country = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String value) {
		this.state = value;
	}

	public List<Cache.ShortDescription> getShortDescription() {
		if (shortDescription == null) {
			shortDescription = new ArrayList<Cache.ShortDescription>();
		}
		return this.shortDescription;
	}

	public List<Cache.LongDescription> getLongDescription() {
		if (longDescription == null) {
			longDescription = new ArrayList<Cache.LongDescription>();
		}
		return this.longDescription;
	}

	public String getEncodedHints() {
		return encodedHints;
	}

	public void setEncodedHints(String value) {
		this.encodedHints = value;
	}

	public List<Cache.Log> getLogs() {
		if (logs == null) {
			logs = new ArrayList<Cache.Log>();
		}
		return this.logs;
	}

	public List<Cache.Travelbug> getTravelbugs() {
		if (travelbugs == null) {
			travelbugs = new ArrayList<Cache.Travelbug>();
		}
		return this.travelbugs;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String value) {
		this.available = value;
	}

	public String getArchived() {
		return archived;
	}

	public void setArchived(String value) {
		this.archived = value;
	}


	@Default(required = false)
	public static class Attribute {

		@Text
		protected String value;
		@org.simpleframework.xml.Attribute
		protected String id;
		@org.simpleframework.xml.Attribute
		protected Byte inc;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getId() {
			return id;
		}

		public void setId(String value) {
			this.id = value;
		}

		public Byte getInc() {
			return inc;
		}

		public void setInc(Byte value) {
			this.inc = value;
		}

	}


	@Order(elements = {
		"date",
		"type",
		"finder",
		"text",
		"logWpt"
	})
	@Default(required = false)
	public static class Log {

		protected String date;
		protected String type;
		protected List<Cache.Log.Finder> finder;
		protected List<Cache.Log.Text> text;
		@Element(name = "log_wpt")
		protected List<Cache.Log.LogWpt> logWpt;
		@org.simpleframework.xml.Attribute
		protected String id;

		public String getDate() {
			return date;
		}

		public void setDate(String value) {
			this.date = value;
		}

		public String getType() {
			return type;
		}

		public void setType(String value) {
			this.type = value;
		}

		public List<Cache.Log.Finder> getFinder() {
			if (finder == null) {
				finder = new ArrayList<Cache.Log.Finder>();
			}
			return this.finder;
		}

		public List<Cache.Log.Text> getText() {
			if (text == null) {
				text = new ArrayList<Cache.Log.Text>();
			}
			return this.text;
		}

		public List<Cache.Log.LogWpt> getLogWpt() {
			if (logWpt == null) {
				logWpt = new ArrayList<Cache.Log.LogWpt>();
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
		public static class Finder {

			@org.simpleframework.xml.Text
			protected String value;
			@org.simpleframework.xml.Attribute
			protected String id;

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getId() {
				return id;
			}

			public void setId(String value) {
				this.id = value;
			}

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
			@org.simpleframework.xml.Attribute
			protected String encoded;

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getEncoded() {
				return encoded;
			}

			public void setEncoded(String value) {
				this.encoded = value;
			}

		}

	}



	@Default(required = false)
	public static class LongDescription {

		@Text
		protected String value;
		@org.simpleframework.xml.Attribute
		protected String html;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getHtml() {
			return html;
		}

		public void setHtml(String value) {
			this.html = value;
		}

	}


	@Default(required = false)
	public static class Owner {

		@Text
		protected String value;
		@org.simpleframework.xml.Attribute
		protected String id;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getId() {
			return id;
		}

		public void setId(String value) {
			this.id = value;
		}

	}


	@Default(required = false)
	public static class ShortDescription {

		@Text
		protected String value;
		@org.simpleframework.xml.Attribute
		protected String html;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getHtml() {
			return html;
		}

		public void setHtml(String value) {
			this.html = value;
		}

	}


	@Default(required = false)
	public static class Travelbug {

		protected String name;
		@org.simpleframework.xml.Attribute
		protected String id;
		@org.simpleframework.xml.Attribute
		protected String ref;

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}

		public String getId() {
			return id;
		}

		public void setId(String value) {
			this.id = value;
		}

		public String getRef() {
			return ref;
		}

		public void setRef(String value) {
			this.ref = value;
		}

	}


}
