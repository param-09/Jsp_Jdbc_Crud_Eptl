package com.model;

public class Employee 
{

	protected int emp_id;
	protected String emp_name;
    protected int dept_id;
    protected String emp_gender;
    
    public Employee(int emp_id, String emp_name, int dept_id,String emp_gender) 
    {
    	this(emp_name,dept_id,emp_gender);
    	this.emp_id=emp_id;	
	}
    public Employee(String emp_name, int dept_id,String emp_gender)
    {
    	this.emp_name=emp_name;
    	this.dept_id=dept_id;
    	this.emp_gender=emp_gender;
    }
    
	public Employee(int emp_id) 
	{
		this.emp_id=emp_id;
	}
	
	public int getEmp_id() 
    {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	
}
