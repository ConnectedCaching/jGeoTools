package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import org.simpleframework.xml.Default;

@Default(required = false)
public class Travelbug {

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
