package serialization;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 7686713788374756366L;
	private int employeeNumber;
	private String employeeName;

	Employee(int num, String name) {
		employeeNumber = num;
		employeeName = name;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int num) {
		employeeNumber = num;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String name) {
		employeeName = name;
	}
}