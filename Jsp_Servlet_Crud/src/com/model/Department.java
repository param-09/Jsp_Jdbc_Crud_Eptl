package com.model;

public class Department 
{
	protected int dept_id;
	protected String dept_name;
	
	public Department(int dept_id,String dept_name) 
    {
    	this.dept_name=dept_name;
    	this.dept_id=dept_id;	
	}
    public Department(String dept_name)
    {
    	this.dept_name=dept_name;
    }
    
	public Department(int dept_id) 
	{
		this.dept_id=dept_id;
	}
	
	
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
}
