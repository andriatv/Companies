package lt.viko.eif.vandraityte.Canoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Creating test to check if name is set and get
 */
class CompanyTest {
@Test
    void SetCompanyName (){
    Company company = new Company();
    company.setName("123");
    assertEquals("123", company.getName());
    }

}