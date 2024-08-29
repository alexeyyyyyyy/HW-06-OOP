package telran.company.tests;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import telran.company.dao.Company;
import telran.company.dao.CompanyImpl;
import telran.company.model.Employee;
import telran.company.model.Manager;
import telran.company.model.SalesManager;
import telran.company.model.WageEmployee;


class CompanyTest {
	Company company;
	Employee[] firm;
	
	@BeforeEach
	void setUp() throws Exception {
		company = new CompanyImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20_000, 2);
		firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
		firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40_000, 0.1);
		firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 91, 80_000, 0.1);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}
	}


	@Test
	void testAddEmployee() {
		assertFalse(company.addEmployee(firm[3]));
		Employee employee = new SalesManager(5000, "Sergey", "Petrov", 182, 160_000, 0.2);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.size());
		employee = new SalesManager(6000, "Sergey", "Petrov", 182, 160_000, 0.2);
		assertFalse(company.addEmployee(employee));
	}


	@Test
	void testRemoveEmployee() {
		Employee fired = company.removeEmployee(1000);
		
		assertNotNull(fired);
		assertEquals(1000, fired.getId());
		assertEquals(3,company.size());
		assertNull(company.findEmployee(1000));
		
		
		
		fired = company.removeEmployee(4000);
		
		assertEquals(4000,fired.getId());
		assertEquals(2,company.size());
	}


	@Test
	void testFindEmployee() {
		Employee employee = company.findEmployee(1000);
	    assertEquals(1000, employee.getId(), "Employee ID 1000");
	    assertNotNull(employee);
		
	}


	@Test
	void testTotalSalary() {
		fail("Not yet implemented");
	}


	@Test
	void testAverageSalary() {
		fail("Not yet implemented");
	}


	@Test
	void testTotalSales() {
		fail("Not yet implemented");
	}


	@Test
	void testSize() {
		fail("Not yet implemented");
	}


	@Test
	void testPrintEmployees() {
		fail("Not yet implemented");
	}


}
