package net.connectedcaching.jgeotools.parsers.gpx.gc101;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.*;


@Order(elements = {
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
	"short_description",
	"long_description",
	"encoded_hints",
	"logs",
	"travelbugs"
})
@Root(name = "cache", strict = false)
@Namespace(reference = "http://www.groundspeak.com/cache/1/0/1")
@Default(required = false)
public class Cache {

	protected String name;
	@Element(name = "placed_by", required = false)
	protected String placedBy;
	protected User owner;
	protected String type;
	protected String container;
	protected List<Attribute> attributes;
	protected String difficulty;
	protected String terrain;
	protected String country;
	protected String state;
	@Element(name = "short_description", required = false)
	protected Description shortDescription;
	@Element(name = "long_description", required = false)
	protected Description longDescription;
	@Element(name = "encoded_hints")
	protected String encodedHints;
	@ElementList(required = false)
	protected List<Log> logs;
	@ElementList(required = false)
	protected List<Travelbug> travelbugs;
	@org.simpleframework.xml.Attribute
	protected String id;
	@org.simpleframework.xml.Attribute
	protected Boolean available;
	@org.simpleframework.xml.Attribute
	protected Boolean archived;

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

	public User getOwner() {
		//if (owner == null) {
		//	owner = new ArrayList<User>();
		//}
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

	public List<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList<Attribute>();
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

	public Description getShortDescription() {
		//if (shortDescription == null) {
		//	shortDescription = new Description();
		//}
		return this.shortDescription;
	}

	public Description getLongDescription() {
		//if (longDescription == null) {
		//	longDescription = new ArrayList<Description>();
		//}
		return this.longDescription;
	}

	public String getEncodedHints() {
		return encodedHints;
	}

	public void setEncodedHints(String value) {
		this.encodedHints = value;
	}

	public List<Log> getLogs() {
		if (logs == null) {
			logs = new ArrayList<Log>();
		}
		return this.logs;
	}

	public List<Travelbug> getTravelbugs() {
		if (travelbugs == null) {
			travelbugs = new ArrayList<Travelbug>();
		}
		return this.travelbugs;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean value) {
		this.available = value;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean value) {
		this.archived = value;
	}

}
