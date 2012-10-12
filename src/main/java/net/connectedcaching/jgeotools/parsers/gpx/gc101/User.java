package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Text;

@Default(required = false)
public class User {

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
