package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")
public class City {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "region")
    private String region;

    public City(String name, String region) {

        this.name = name;
        this.region = region;

    }
    public City(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return String.format("City:\n\tname = %s\n\tregion = %s\n\t ", name, region);
    }
}
