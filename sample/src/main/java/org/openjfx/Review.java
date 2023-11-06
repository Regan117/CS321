package org.openjfx;

public class Review extends App {
    protected String Name ;
    protected String Email;
    protected String DOB;
    protected String Country;
    protected int Anum;

    public Review(int mocktasknum){
        Petition p = new Petition();
        p = p.pullFromDB(mocktasknum);
        Name = p.getName();
        DOB = p.getDOB();
        Email = p.getEmail();
        Country = p.getCountry();
        Anum = p.getAnum();
    }

    void Edit(){



    }
    boolean UpdateWF(){
        return false;
    }
    void WriteToPetition(){
        
    }
    void AccessPetition(){
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
