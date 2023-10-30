package org.openjfx;

class Approver extends App {
    protected String Name = "joe";
    protected String Email;
    protected int DOB;
    protected String Country;
    protected int Anum;
    private Petition p = new Petition("james bo cane",12341989, "jame@gmail.com", "Brazil", 999999999);
    public Approver(){

    }

    public Approver(int tasknum){
        p.pullFromDB(tasknum);
        Name = p.getName();
        Email = p.getEmail();
        DOB = p.getDOB();
        Country = p.getCountry();
        Anum = p.getAnum();
    }

    public String getName(){
        return Name;
    }
    public String getEmail() {
        return Email;
    }
    public int getDOB() {
        return DOB;
    }
    
    public String getCountry() {
        return Country;
    }
    
    public int getAnum() {
        return Anum;
    }


}

