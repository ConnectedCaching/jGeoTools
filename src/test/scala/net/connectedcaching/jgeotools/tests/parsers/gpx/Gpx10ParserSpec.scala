package net.connectedcaching.jgeotools.tests.parsers.gpx

import org.specs2.mutable._
import org.simpleframework.xml.core.Persister
import java.io.File
import net.connectedcaching.jgeotools.parsers.gpx.gpx10.Gpx
import org.simpleframework.xml.Serializer

class Gpx10ParserSpec extends Specification {

	"GPX v1.0 parsing" should {

		val serializer: Serializer = new Persister()
		val source = new File("src/test/scala/net/connectedcaching/jgeotools/tests/parsers/gpx/sample.gpx")

		"be able to read the provided sample file" in {
			serializer.read(classOf[Gpx], source) must beAnInstanceOf[Gpx]
		}

	}

}
