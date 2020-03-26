package GsonPrac;

import com.google.gson.Gson;

public class GSONUserDefinedObjectsDemo {

	public static void main(String[] args) {
		
		
		Employee emp = new Employee("abc", 100, 1000);
		
		
		
		Gson gson = new Gson();
		
		//Converting emp object to JSON  format or Serialization 
		
		String empJson = gson.toJson(emp);
		
		System.out.println(empJson);
		
		
		//Converting  JSON  to Object format or Serialization 
		Employee emp1 = gson.fromJson(empJson, Employee.class);
	System.out.println("Employee ID: " + emp1.empID +" Employee Salary: "+ emp1.empSalary +" Employee Name: " + emp1.empName);
		

	}

}
