package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
/*
Creating Route class, which shows City, route and distance

*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")
public class Route {
    @XmlElement(name = "RiverName")
    private String RiverName;
    @XmlElement(name = "Disance")
    private int disance;
    private List <City> cities = new ArrayList<>();

    public Route(String RiverName, int disance) {

        this.RiverName = RiverName;
        this.disance = disance;
    }
    public Route(){}

    public String getRiverName() {
        return RiverName;
    }

    public void setRiverName(String riverName) {
        RiverName = riverName;
    }

    public int getDisance() {
        return disance;
    }

    public void setDisance(int disance) {
        this.disance = disance;
    }


    @Override
    public String toString() {
        return String.format("Route:\n\tRiverName = %s\n\t disance = %s", RiverName, disance);
    }
}
