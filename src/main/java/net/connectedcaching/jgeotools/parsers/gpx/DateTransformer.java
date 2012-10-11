package net.connectedcaching.jgeotools.parsers.gpx;

import org.simpleframework.xml.transform.Transform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateTransformer implements Transform<Date> {

	protected static List<SimpleDateFormat> KNOWN_FORMATS = new ArrayList<SimpleDateFormat>();
	static	{
		KNOWN_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
		KNOWN_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'"));
		KNOWN_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z"));
		KNOWN_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"));
		KNOWN_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd z"));
		KNOWN_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd"));
	}

	@Override
	public Date read(String value) throws Exception {
		for (SimpleDateFormat df : KNOWN_FORMATS) {
			try {
				Date result = df.parse(value);
				return result;
			} catch (ParseException e) {}
		}
		// GC.com also exports crap dates like 2012-10-11T19:08:56.3786904Z, so try again
		if (value.length() > 24) {
			return read(value.replaceAll("\\.(\\d\\d\\d)\\d*Z", ".$1Z"));
		}
		throw new ParseException("Unparseable date: " + value, 0);
	}

	@Override
	public String write(Date value) throws Exception {
		return KNOWN_FORMATS.get(0).format(value);
	}

}
