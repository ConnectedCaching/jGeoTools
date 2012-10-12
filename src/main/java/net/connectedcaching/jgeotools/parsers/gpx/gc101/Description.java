package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Default(required = false)
public class Description {

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
