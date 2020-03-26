package TestCases;

public class JsonInputData {

	public String empName;
	public int empID;
	public int empSalary;

	public JsonInputData() {
		this.empName = "Rahul";
		this.empID = 10;
		this.empSalary = 9900;
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
