package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")
public class SleepingPlaces {
    @XmlElement(name = "PlaceName")
    private String PlaceName;
    @XmlElement(name = "price")
    private int price;
    private List<City> cities = new ArrayList<>();

    public SleepingPlaces(String PlaceName, int price) {
        this.PlaceName = PlaceName;
        this.price = price;
    }
    public SleepingPlaces(){}

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public List<City> getCities(){
        return cities;
    }
    private String printCities(){
        String result = " ";
        for (City city: getCities()) {
            result += String.format("City:\n\t name = %s\n\tregion = %s",city.getName(),city.getRegion());
        }
        return result;
    }
    @Override
    public String toString() {
        return String.format("SleepingPlaces:\n\tPlaceName = %s\n\tprice = %s\n\t %s", PlaceName, price,getCities());
    }

}
