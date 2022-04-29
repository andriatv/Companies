package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
Creating CanoePrice class, which shows Canoes price, size and name

*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")

public class CanoePrice {
    @XmlElement(name = "price")
    private int price;
    @XmlElement(name = "size")
    private int size;
    @XmlElement(name = "name")
    private String name;

    public CanoePrice(String name, int price, int size) {

        this.name = name;
        this.price = price;
        this.size = size;
    }
    /*
    kiekvienam is kntamuju sukurima get ir set funcijas kurios nurodys ir nustatys kintamuosius
     */
    public CanoePrice(){}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
sukuriama overide klase kuri tures metoda kaip nud=rodyta pirmin4je klaseje.
 */
    @Override
    public String toString() {
        return String.format("CanoePrice:\n\t name = %s\n\t price = %s\n\t size = %s", name, price,size);
    }
}
