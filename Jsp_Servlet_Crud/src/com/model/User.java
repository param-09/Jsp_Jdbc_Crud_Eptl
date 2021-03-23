package com.model;

public class User 
{
	protected int id;
    protected String name;
    protected String contact;
    protected String email;
    
    public User(int id, String name, String contact, String email) 
    {
    	this(name,contact,email);
    	this.id=id;	
	}
    public User(String name, String contact, String email)
    {
    	this.name=name;
    	this.contact=contact;
    	this.email=email;
    }
    
	public User(int id) 
	{
		this.id=id;
	}
	public int getId() 
    {
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getContact() 
	{
		return contact;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
}


  




