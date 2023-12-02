package org.openjfx;

class Review extends Petition {
    protected String Name ;
    protected String Email;
    protected String DOB;
    protected String Country;
    protected int Anum;
    Petition toReview;
    //private Petition p = new Petition("james bo cane","1999-08-08", "jame@gmail.com", "Brazil", 999999999);
    private int mocktasknum ;

    public Review(){

    }

    public void getPetition(int mocktask){
        Petition p = new Petition();
        toReview = p;
        p = DataBase.pullFromDB(mocktask);
        p = p.pullDB(mocktask);
        this.Anum = p.Anum;
        this.Country = p.Country;
        this.DOB = p.DOB;
        this.Email = p.Email;
        this.Name = p.Name;
        
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
    Petition getPetition(){
        return toReview;
    }

}


