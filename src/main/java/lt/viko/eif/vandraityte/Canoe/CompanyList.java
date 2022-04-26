package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
/**
 *  This class is used as wrapper for JAXB marshaling and its representing Companies object list
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Companies")
public class CompanyList {
    @XmlElement(name = "Company")
    private ArrayList<Company> companyList = new ArrayList<>();

    public ArrayList<Company> getCompaniesList() {
        return companyList;
    }

    public void addCompany(Company company) {
        this.companyList.add(company);
    }

}
