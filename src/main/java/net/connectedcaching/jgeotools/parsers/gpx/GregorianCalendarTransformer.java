package net.connectedcaching.jgeotools.parsers.gpx;

import org.simpleframework.xml.transform.Transform;

import java.util.GregorianCalendar;

public class GregorianCalendarTransformer implements Transform<GregorianCalendar> {

	protected static final DateTransformer transformer = new DateTransformer();

	@Override
	public GregorianCalendar read(String value) throws Exception {
		GregorianCalendar calendar = new GregorianCalendar();
		if (value != null) {
			calendar.setTime(transformer.read(value));
		}
		return calendar;
	}

	@Override
	public String write(GregorianCalendar value) throws Exception {
		return transformer.write(value.getTime());
	}

}
