package net.connectedcaching.jgeotools.parsers.gpx.gpx10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.simpleframework.xml.*;


@Order(elements = {
	"name",
	"desc",
	"author",
	"email",
	"url",
	"urlname",
	"time",
	"keywords",
	"bounds",
	"wpt",
	"rte",
	"trk"
})
@Root(name = "gpx", strict = false)
@Default(required = false)
public class Gpx {

	@Attribute(required = false)
	private String schemaLocation;

	protected String name;
	protected String desc;
	protected String author;
	protected String email;
	//@XmlSchemaType(name = "anyURI")
	protected String url;
	protected String urlname;
	//@XmlSchemaType(name = "dateTime")
	protected GregorianCalendar time;
	protected String keywords;
	protected BoundsType bounds;
	@ElementList(inline = true, required = false)
	protected List<Gpx.Wpt> wpt;
	@ElementList(inline = true, required = false)
	protected List<Gpx.Rte> rte;
	@ElementList(inline = true, required = false)
	protected List<Gpx.Trk> trk;
	//@XmlAnyElement(lax = true)
	//protected List<Object> any;
	@Attribute(required = true)
	protected String version;
	@Attribute(required = true)
	protected String creator;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String value) {
		this.desc = value;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String value) {
		this.author = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String value) {
		this.url = value;
	}

	public String getUrlname() {
		return urlname;
	}

	public void setUrlname(String value) {
		this.urlname = value;
	}

	public GregorianCalendar getTime() {
		return time;
	}

	public void setTime(GregorianCalendar value) {
		this.time = value;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String value) {
		this.keywords = value;
	}

	public BoundsType getBounds() {
		return bounds;
	}

	public void setBounds(BoundsType value) {
		this.bounds = value;
	}

	public List<Gpx.Wpt> getWpt() {
		if (wpt == null) {
			wpt = new ArrayList<Gpx.Wpt>();
		}
		return this.wpt;
	}

	public List<Gpx.Rte> getRte() {
		if (rte == null) {
			rte = new ArrayList<Gpx.Rte>();
		}
		return this.rte;
	}

	public List<Gpx.Trk> getTrk() {
		if (trk == null) {
			trk = new ArrayList<Gpx.Trk>();
		}
		return this.trk;
	}

	public String getVersion() {
		if (version == null) {
			return "1.0";
		} else {
			return version;
		}
	}

	public void setVersion(String value) {
		this.version = value;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String value) {
		this.creator = value;
	}


	@Order(elements = {
		"name",
		"cmt",
		"desc",
		"src",
		"url",
		"urlname",
		"number",
		"rtept"
	})
	@Root(strict = false)
	@Default(required = false)
	public static class Rte {

		protected String name;
		protected String cmt;
		protected String desc;
		protected String src;
		//@XmlSchemaType(name = "anyURI")
		protected String url;
		protected String urlname;
		//@XmlSchemaType(name = "nonNegativeInteger")
		protected BigInteger number;
		@ElementList(inline = true, required = false)
		protected List<Gpx.Rte.Rtept> rtept;

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}

		public String getCmt() {
			return cmt;
		}

		public void setCmt(String value) {
			this.cmt = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String value) {
			this.desc = value;
		}

		public String getSrc() {
			return src;
		}

		public void setSrc(String value) {
			this.src = value;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String value) {
			this.url = value;
		}

		public String getUrlname() {
			return urlname;
		}

		public void setUrlname(String value) {
			this.urlname = value;
		}

		public BigInteger getNumber() {
			return number;
		}

		public void setNumber(BigInteger value) {
			this.number = value;
		}

		public List<Gpx.Rte.Rtept> getRtept() {
			if (rtept == null) {
				rtept = new ArrayList<Gpx.Rte.Rtept>();
			}
			return this.rtept;
		}


		@Order(elements = {
			"ele",
			"time",
			"magvar",
			"geoidheight",
			"name",
			"cmt",
			"desc",
			"src",
			"url",
			"urlname",
			"sym",
			"type",
			"fix",
			"sat",
			"hdop",
			"vdop",
			"pdop",
			"ageofdgpsdata",
			"dgpsid"
		})
		@Default(DefaultType.FIELD)
		public static class Rtept {

			protected BigDecimal ele;
			//@XmlSchemaType(name = "dateTime")
			protected GregorianCalendar time;
			protected BigDecimal magvar;
			protected BigDecimal geoidheight;
			protected String name;
			protected String cmt;
			protected String desc;
			protected String src;
			//@XmlSchemaType(name = "anyURI")
			protected String url;
			protected String urlname;
			protected String sym;
			protected String type;
			protected String fix;
			//@XmlSchemaType(name = "nonNegativeInteger")
			protected BigInteger sat;
			protected BigDecimal hdop;
			protected BigDecimal vdop;
			protected BigDecimal pdop;
			protected BigDecimal ageofdgpsdata;
			protected Integer dgpsid;
			@Attribute(required = true)
			protected BigDecimal lat;
			@Attribute(required = true)
			protected BigDecimal lon;

			public BigDecimal getEle() {
				return ele;
			}

			public void setEle(BigDecimal value) {
				this.ele = value;
			}

			public GregorianCalendar getTime() {
				return time;
			}

			public void setTime(GregorianCalendar value) {
				this.time = value;
			}

			public BigDecimal getMagvar() {
				return magvar;
			}

			public void setMagvar(BigDecimal value) {
				this.magvar = value;
			}

			public BigDecimal getGeoidheight() {
				return geoidheight;
			}

			public void setGeoidheight(BigDecimal value) {
				this.geoidheight = value;
			}

			public String getName() {
				return name;
			}

			public void setName(String value) {
				this.name = value;
			}

			public String getCmt() {
				return cmt;
			}

			public void setCmt(String value) {
				this.cmt = value;
			}

			public String getDesc() {
				return desc;
			}

			public void setDesc(String value) {
				this.desc = value;
			}

			public String getSrc() {
				return src;
			}

			public void setSrc(String value) {
				this.src = value;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String value) {
				this.url = value;
			}

			public String getUrlname() {
				return urlname;
			}

			public void setUrlname(String value) {
				this.urlname = value;
			}

			public String getSym() {
				return sym;
			}

			public void setSym(String value) {
				this.sym = value;
			}

			public String getType() {
				return type;
			}

			public void setType(String value) {
				this.type = value;
			}

			public String getFix() {
				return fix;
			}

			public void setFix(String value) {
				this.fix = value;
			}

			public BigInteger getSat() {
				return sat;
			}

			public void setSat(BigInteger value) {
				this.sat = value;
			}

			public BigDecimal getHdop() {
				return hdop;
			}

			public void setHdop(BigDecimal value) {
				this.hdop = value;
			}

			public BigDecimal getVdop() {
				return vdop;
			}

			public void setVdop(BigDecimal value) {
				this.vdop = value;
			}

			public BigDecimal getPdop() {
				return pdop;
			}

			public void setPdop(BigDecimal value) {
				this.pdop = value;
			}

			public BigDecimal getAgeofdgpsdata() {
				return ageofdgpsdata;
			}

			public void setAgeofdgpsdata(BigDecimal value) {
				this.ageofdgpsdata = value;
			}

			public Integer getDgpsid() {
				return dgpsid;
			}

			public void setDgpsid(Integer value) {
				this.dgpsid = value;
			}

			public BigDecimal getLat() {
				return lat;
			}

			public void setLat(BigDecimal value) {
				this.lat = value;
			}

			public BigDecimal getLon() {
				return lon;
			}

			public void setLon(BigDecimal value) {
				this.lon = value;
			}

		}

	}


	@Order(elements = {
		"name",
		"cmt",
		"desc",
		"src",
		"url",
		"urlname",
		"number",
		"trkseg"
	})
	@Root(strict = false)
	@Default(required = false)
	public static class Trk {

		protected String name;
		protected String cmt;
		protected String desc;
		protected String src;
		//@XmlSchemaType(name = "anyURI")
		protected String url;
		protected String urlname;
		//@XmlSchemaType(name = "nonNegativeInteger")
		protected BigInteger number;
		@ElementList(inline = true, required = false)
		protected List<Gpx.Trk.Trkseg> trkseg;

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}

		public String getCmt() {
			return cmt;
		}

		public void setCmt(String value) {
			this.cmt = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String value) {
			this.desc = value;
		}

		public String getSrc() {
			return src;
		}

		public void setSrc(String value) {
			this.src = value;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String value) {
			this.url = value;
		}

		public String getUrlname() {
			return urlname;
		}

		public void setUrlname(String value) {
			this.urlname = value;
		}

		public BigInteger getNumber() {
			return number;
		}

		public void setNumber(BigInteger value) {
			this.number = value;
		}

		public List<Gpx.Trk.Trkseg> getTrkseg() {
			if (trkseg == null) {
				trkseg = new ArrayList<Gpx.Trk.Trkseg>();
			}
			return this.trkseg;
		}


		@Default(required = false)
		public static class Trkseg {

			@ElementList(inline = true, required = false)
			protected List<Gpx.Trk.Trkseg.Trkpt> trkpt;

			public List<Gpx.Trk.Trkseg.Trkpt> getTrkpt() {
				if (trkpt == null) {
					trkpt = new ArrayList<Gpx.Trk.Trkseg.Trkpt>();
				}
				return this.trkpt;
			}


			@Order(elements = {
				"ele",
				"time",
				"course",
				"speed",
				"magvar",
				"geoidheight",
				"name",
				"cmt",
				"desc",
				"src",
				"url",
				"urlname",
				"sym",
				"type",
				"fix",
				"sat",
				"hdop",
				"vdop",
				"pdop",
				"ageofdgpsdata",
				"dgpsid"
			})
			@Default(required = false)
			public static class Trkpt {

				protected BigDecimal ele;
				//@XmlSchemaType(name = "dateTime")
				protected GregorianCalendar time;
				protected BigDecimal course;
				protected BigDecimal speed;
				protected BigDecimal magvar;
				protected BigDecimal geoidheight;
				protected String name;
				protected String cmt;
				protected String desc;
				protected String src;
				//@XmlSchemaType(name = "anyURI")
				protected String url;
				protected String urlname;
				protected String sym;
				protected String type;
				protected String fix;
				//@XmlSchemaType(name = "nonNegativeInteger")
				protected BigInteger sat;
				protected BigDecimal hdop;
				protected BigDecimal vdop;
				protected BigDecimal pdop;
				protected BigDecimal ageofdgpsdata;
				protected Integer dgpsid;
				@Attribute(required = true)
				protected BigDecimal lat;
				@Attribute(required = true)
				protected BigDecimal lon;

				public BigDecimal getEle() {
					return ele;
				}

				public void setEle(BigDecimal value) {
					this.ele = value;
				}

				public GregorianCalendar getTime() {
					return time;
				}

				public void setTime(GregorianCalendar value) {
					this.time = value;
				}

				public BigDecimal getCourse() {
					return course;
				}

				public void setCourse(BigDecimal value) {
					this.course = value;
				}

				public BigDecimal getSpeed() {
					return speed;
				}

				public void setSpeed(BigDecimal value) {
					this.speed = value;
				}

				public BigDecimal getMagvar() {
					return magvar;
				}

				public void setMagvar(BigDecimal value) {
					this.magvar = value;
				}

				public BigDecimal getGeoidheight() {
					return geoidheight;
				}

				public void setGeoidheight(BigDecimal value) {
					this.geoidheight = value;
				}

				public String getName() {
					return name;
				}

				public void setName(String value) {
					this.name = value;
				}

				public String getCmt() {
					return cmt;
				}

				public void setCmt(String value) {
					this.cmt = value;
				}

				public String getDesc() {
					return desc;
				}

				public void setDesc(String value) {
					this.desc = value;
				}

				public String getSrc() {
					return src;
				}

				public void setSrc(String value) {
					this.src = value;
				}

				public String getUrl() {
					return url;
				}

				public void setUrl(String value) {
					this.url = value;
				}

				public String getUrlname() {
					return urlname;
				}

				public void setUrlname(String value) {
					this.urlname = value;
				}

				public String getSym() {
					return sym;
				}

				public void setSym(String value) {
					this.sym = value;
				}

				public String getType() {
					return type;
				}

				public void setType(String value) {
					this.type = value;
				}

				public String getFix() {
					return fix;
				}

				public void setFix(String value) {
					this.fix = value;
				}

				public BigInteger getSat() {
					return sat;
				}

				public void setSat(BigInteger value) {
					this.sat = value;
				}

				public BigDecimal getHdop() {
					return hdop;
				}

				public void setHdop(BigDecimal value) {
					this.hdop = value;
				}

				public BigDecimal getVdop() {
					return vdop;
				}

				public void setVdop(BigDecimal value) {
					this.vdop = value;
				}

				public BigDecimal getPdop() {
					return pdop;
				}

				public void setPdop(BigDecimal value) {
					this.pdop = value;
				}

				public BigDecimal getAgeofdgpsdata() {
					return ageofdgpsdata;
				}

				public void setAgeofdgpsdata(BigDecimal value) {
					this.ageofdgpsdata = value;
				}

				public Integer getDgpsid() {
					return dgpsid;
				}

				public void setDgpsid(Integer value) {
					this.dgpsid = value;
				}

				public BigDecimal getLat() {
					return lat;
				}

				public void setLat(BigDecimal value) {
					this.lat = value;
				}

				public BigDecimal getLon() {
					return lon;
				}

				public void setLon(BigDecimal value) {
					this.lon = value;
				}

			}

		}

	}


	@Order(elements = {
		"ele",
		"time",
		"magvar",
		"geoidheight",
		"name",
		"cmt",
		"desc",
		"src",
		"url",
		"urlname",
		"sym",
		"type",
		"fix",
		"sat",
		"hdop",
		"vdop",
		"pdop",
		"ageofdgpsdata",
		"dgpsid"
	})
	@Root(strict = false)
	@Default(required = false)
	public static class Wpt {

		@Element(required = false)
		protected BigDecimal ele;
		//@XmlSchemaType(name = "dateTime")
		@Element(required = false)
		protected GregorianCalendar time;
		protected BigDecimal magvar;
		protected BigDecimal geoidheight;
		protected String name;
		protected String cmt;
		protected String desc;
		protected String src;
		//@XmlSchemaType(name = "anyURI")
		protected String url;
		protected String urlname;
		protected String sym;
		protected String type;
		protected String fix;
		//@XmlSchemaType(name = "nonNegativeInteger")
		protected BigInteger sat;
		protected BigDecimal hdop;
		protected BigDecimal vdop;
		protected BigDecimal pdop;
		protected BigDecimal ageofdgpsdata;
		protected Integer dgpsid;
		@Attribute(required = false)
		protected BigDecimal lat;
		@Attribute(required = false)
		protected BigDecimal lon;

		public BigDecimal getEle() {
			return ele;
		}

		public void setEle(BigDecimal value) {
			this.ele = value;
		}

		public GregorianCalendar getTime() {
			return time;
		}

		public void setTime(GregorianCalendar value) {
			this.time = value;
		}

		public BigDecimal getMagvar() {
			return magvar;
		}

		public void setMagvar(BigDecimal value) {
			this.magvar = value;
		}

		public BigDecimal getGeoidheight() {
			return geoidheight;
		}

		public void setGeoidheight(BigDecimal value) {
			this.geoidheight = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}

		public String getCmt() {
			return cmt;
		}

		public void setCmt(String value) {
			this.cmt = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String value) {
			this.desc = value;
		}

		public String getSrc() {
			return src;
		}

		public void setSrc(String value) {
			this.src = value;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String value) {
			this.url = value;
		}

		public String getUrlname() {
			return urlname;
		}

		public void setUrlname(String value) {
			this.urlname = value;
		}

		public String getSym() {
			return sym;
		}

		public void setSym(String value) {
			this.sym = value;
		}

		public String getType() {
			return type;
		}

		public void setType(String value) {
			this.type = value;
		}

		public String getFix() {
			return fix;
		}

		public void setFix(String value) {
			this.fix = value;
		}

		public BigInteger getSat() {
			return sat;
		}

		public void setSat(BigInteger value) {
			this.sat = value;
		}

		public BigDecimal getHdop() {
			return hdop;
		}

		public void setHdop(BigDecimal value) {
			this.hdop = value;
		}

		public BigDecimal getVdop() {
			return vdop;
		}

		public void setVdop(BigDecimal value) {
			this.vdop = value;
		}

		public BigDecimal getPdop() {
			return pdop;
		}

		public void setPdop(BigDecimal value) {
			this.pdop = value;
		}

		public BigDecimal getAgeofdgpsdata() {
			return ageofdgpsdata;
		}

		public void setAgeofdgpsdata(BigDecimal value) {
			this.ageofdgpsdata = value;
		}

		public Integer getDgpsid() {
			return dgpsid;
		}

		public void setDgpsid(Integer value) {
			this.dgpsid = value;
		}

		public BigDecimal getLat() {
			return lat;
		}

		public void setLat(BigDecimal value) {
			this.lat = value;
		}

		public BigDecimal getLon() {
			return lon;
		}

		public void setLon(BigDecimal value) {
			this.lon = value;
		}

	}

}
