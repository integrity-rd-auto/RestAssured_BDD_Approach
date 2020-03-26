package GsonPrac;

public class Employee {
	
	String empName;
	int empID;
	int empSalary;
	
	public Employee(String empName, int empID, int empSalary) {
		this.empName = empName;
		this.empID = empID;
		this.empSalary = empSalary;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	

}
