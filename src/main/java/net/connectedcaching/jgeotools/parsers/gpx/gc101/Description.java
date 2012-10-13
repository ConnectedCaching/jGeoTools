package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Text;

@Default(required = false)
public class Description {

	@Text
	protected String value;
	@org.simpleframework.xml.Attribute(name = "html")
	protected Boolean containsHtml;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean containsHtml() {
		return containsHtml;
	}

	public void setContainsHtml(Boolean value) {
		this.containsHtml = value;
	}

}
