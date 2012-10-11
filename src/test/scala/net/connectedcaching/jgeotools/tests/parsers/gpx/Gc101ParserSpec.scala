package net.connectedcaching.jgeotools.tests.parsers.gpx

import org.specs2.mutable._
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.io.File
import net.connectedcaching.jgeotools.parsers.gpx.gpx10.Gpx
import org.simpleframework.xml.transform.RegistryMatcher
import net.connectedcaching.jgeotools.parsers.gpx.{GregorianCalendarTransformer, DateTransformer}
import java.util.{GregorianCalendar, Date}

class Gc101ParserSpec extends Specification {

	"Geocaching.com GPX v1.0.1 parsing" should {

		val source = new File("src/test/scala/net/connectedcaching/jgeotools/tests/parsers/gpx/Gc101Sample.gpx")

		"be able to read the provided sample file" in {
			val m = new RegistryMatcher()
			m.bind(classOf[Date], new DateTransformer())
			m.bind(classOf[GregorianCalendar], new GregorianCalendarTransformer())
			val serializer: Serializer = new Persister(m)
			val gpx = serializer.read(classOf[Gpx], source)
			gpx must beAnInstanceOf[Gpx]
		}

	}

}
