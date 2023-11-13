package org.openjfx;

class Approver extends App {
    protected String Name ;
    protected String Email;
    protected String DOB;
    protected String Country;
    protected int Anum;
    //private Petition p = new Petition("james bo cane","1999-08-08", "jame@gmail.com", "Brazil", 999999999);
    private int mocktasknum = 1;

    public Approver(){

    }

    public Approver(int mocktasknum){
        Petition p = new Petition();
        p = p.pullFromDB(mocktasknum);
        Name = p.getName();
        DOB = p.getDOB();
        Email = p.getEmail();
        Country = p.getCountry();
        Anum = p.getAnum();
    }

    public String getName(){
        return Name;
    }
    public String getEmail() {
        return Email;
    }
    public String getDOB() {
        return DOB;
    }
    
    public String getCountry() {
        return Country;
    }
    
    public int getAnum() {
        return Anum;
    }

}

