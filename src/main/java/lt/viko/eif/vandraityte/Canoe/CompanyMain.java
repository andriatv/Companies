package lt.viko.eif.vandraityte.Canoe;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Creating CompanyOutputResolver class to write  StreamResult on a StringWriter and to get file */
class CompanyOutputResolver extends SchemaOutputResolver {

    public Result createOutput(String namespaceURI, String suggestedFileName) {
        File file = new File("Company.xsd");
        StreamResult result = new StreamResult(file);
        result.setSystemId(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
        return result;
    }
}
/**
 * Filling main file
 */
public class CompanyMain {
    public static void main(String args[]) throws JAXBException {

        Company company = new Company();

        /*List<Company> companyList = new ArrayList<Company>();*/
/**
 * adding few Companies to our list
 */
        company.setName("Svaja");
        company.setAddress("Viksnenu 15");
        company.setPhoneNumber(861250467);
        company.getCities().add(new City("Viksnenai", "Mariampoles raj."));
        company.getRoutes().add(new Route("Neris", 15));
        company.getCanoePrices().add(new CanoePrice("Vongola", 10, 2));
        company.getSleepingPlaces().add(new SleepingPlaces("Sekvoja", 150));

        Company company1 = new Company();
        company1.setName("Jura");
        company1.setAddress("Salcininku 15");
        company1.setPhoneNumber(861250467);
        company1.getCities().add(new City("Salcininku", "Kauno raj."));
        company1.getRoutes().add(new Route("Salcia", 10));
        company1.getCanoePrices().add(new CanoePrice("Ingla", 12, 2));
        company1.getSleepingPlaces().add(new SleepingPlaces("Pas Juoza", 170));
       /* companyList.add(company);
        companyList.add(company1);*/

        List<Company> _companyList = new ArrayList<>();
        _companyList.add(company);
        _companyList.add(company1);

        /* Printing of the canoe objects to console */
        System.out.println("_________________________");
        System.out.println("List of companies that books canoes");
        System.out.println("_________________________");
/**
 * Attaching Company list class, to get and set previously created values
 */
        for (Company com : _companyList) {
            System.out.println(com);
        }
        CompanyList companyList = new CompanyList();
        companyList.addCompany(company);
        companyList.addCompany(company1);

        /*  Marshaling of CanoeList wrapper class.*/
        JAXBContext jaxbContext = JAXBContext.newInstance(CompanyList.class);
        Marshaller marshal = jaxbContext.createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

        marshal.marshal(companyList, new File("Company.xml"));
        System.out.println("_________________________");
        System.out.println("XML file");
        System.out.println("_________________________");

        marshal.marshal(companyList, System.out);

        /**
         * Creating first thread to run a Server
         */
        Thread tr1 = new Thread(() -> {

            Server server = new Server();
            try {
                server.launchServer();
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        });
        tr1.start();

        /**
         * Creating second thread to run a Client
         */
        Thread tr2 = new Thread(() -> {

            Client client = new Client();
            client.launchClient();
        });
        tr2.start();

        System.out.println("Number of active threads from the given thread: " + Thread.activeCount());

        try {
            /*  unmarshalling of CanoeList wrapper class.*/

            JAXBContext context= JAXBContext.newInstance (CompanyList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaOutputResolver sor = new CompanyOutputResolver();
            context.generateSchema(sor);
            File file = new File ("Company.xml");
            Source source = new StreamSource(file);
            JAXBElement<CompanyList> element = unmarshaller.unmarshal(source, CompanyList.class);

            System.out.println("_________________________");
            System.out.println(" XML file code");
            System.out.println("_________________________");

            CompanyList item = element.getValue();
            System.out.println (item.getCompaniesList());
        }
        catch (JAXBException | IOException exp) {
            System.out.println("Exception occurred: " + exp.getMessage());
        }
        try{Thread.sleep(4000);
        } catch(Exception x) {
        }
        System.exit(0); // done

    }
}



