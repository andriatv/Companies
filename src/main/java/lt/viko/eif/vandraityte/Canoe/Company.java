package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")

public class Company {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String address;
    @XmlAttribute
    private int phoneNumber;

    @XmlElement(name="City")
    private List<City> cities = new ArrayList<>();
    @XmlElement(name="Route")
    private List<Route> routes = new ArrayList<>();
    @XmlElement(name="CanoePrice")
    private List<CanoePrice> canoePrices = new ArrayList<>();
    @XmlElement(name="SleepingPlaces")
    private List<SleepingPlaces> sleepingPlaces = new ArrayList<>();

    public Company(String name, String address, int phoneNumber) {

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<City> getCities(){
        return cities;
    }
    public void setCities(List<City> cities){ this.cities = cities; }
    private String printCities(){
        String result = " ";
        for (City city: getCities()) {
            result += String.format("City:\n\t name = %s\n\t region = %s ",city.getName(),city.getRegion());
        }
        return result;
    }
    public List<Route> getRoutes(){
        return routes;
    }
    public void setRoutes(List<Route> routes){ this.routes = routes; }

    private String printRoutes(){
        String result = " ";
        for (Route route: getRoutes()) {
            result += String.format(" Route:\n\t RiverName = %s\n\t disance = %s",route.getRiverName(),route.getDisance());
        }
        return result;
    }

    public List<CanoePrice> getCanoePrices(){
        return canoePrices;
    }
    public void setCanoePrices(List<CanoePrice> canoePrices){ this.canoePrices = canoePrices; }

    private String printCanoePrices(){
        String result = " ";
        for (CanoePrice canoePrice: getCanoePrices()) {
            result += String.format("\n\t CanoePrice:\n\t\t name =%s\n\t price=%s\n\t size = %s",canoePrice.getName(),canoePrice.getPrice(),canoePrice.getSize());
        }
        return result;
    }

    public List<SleepingPlaces> getSleepingPlaces(){
        return sleepingPlaces;
    }
    public void setSleepingPlaces(List<SleepingPlaces> sleepingPlaces){ this.sleepingPlaces = sleepingPlaces; }

    private String printSleepingPlaces(){
        String result = " ";
        for (SleepingPlaces sleepingPlaces: getSleepingPlaces()) {
            result += String.format("SleepingPlaces:\n\t PlaceName =%s\n\t price=%s",sleepingPlaces.getPlaceName(),sleepingPlaces.getPrice());
        }
        return result;
    }
    @Override
    public String toString() {
        return String.format("Company:\n\t name =%s\n\t address=%s\n\t phoneNumber=%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s", name, address, phoneNumber, printCities(),printRoutes(),printCanoePrices(),printSleepingPlaces());
    }
}
