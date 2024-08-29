package telran.company.dao;


import telran.company.model.Employee;


public class CompanyImpl implements Company {
	String name;
	Employee[] employees;
	int size;


	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}


	@Override
	public boolean addEmployee(Employee employee) {
		if(size >= employees.length) {
			return false;
		}
	for(int i = 0;i < size; i++) {
		if(employees[i].getId() == employee.getId()) {
			return false;
		}
	}
		employees[size++] = employee;
		return true;
	}


	@Override
	public Employee removeEmployee(int id) {
	for(int i = 0; i < size; i++ ) {
		if(employees[i].getId() == id) {
			Employee fired = employees[i];
			
			for(int j = i; j < size - 1; j++) {
				employees[j] = employees[j + 1];
			}
			employees[size - 1] = null;
			size--;
			return fired;
		}
	}
		
		return null;
	
	}


	@Override
	public Employee findEmployee(int id) {
		for(int i = 0; i < size; i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}


	@Override
	public double totalSalary() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double averageSalary() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double totalSales() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int size() {
		return size;
	}


	@Override
	public void printEmployees() {
		// TODO Auto-generated method stub


	}


}
