package org.openjfx;

class Petition extends DataBase{
    protected String Name;
    protected String Email;
    protected String DOB;
    protected String Country;
    protected int Anum;
    protected int iD;
    
    public Petition(){

    }
    public Petition(String name, String dOB, String email, String country, int anum, int id) {
        Name = name;
        Email = email;
        DOB = dOB;
        Country = country;
        Anum = anum;
        iD = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getDOB() {
        return DOB;
    }
    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public int getAnum() {
        return Anum;
    }
    public void setAnum(int anum) {
        Anum = anum;
    }
    public int getiD() {
        return iD;
    }
    public void setiD(int iD) {
        this.iD = iD;
    }
    
//NOT FINISHED
    public Boolean validateEntry() {
        if(Name == null || DOB == null || Country == null|| Email == null || Anum < 0 || Anum >  1000000000){
            return false;
        }
        boolean dV = true;

        if((Name instanceof String)){
            boolean allLetters = Name.chars().allMatch(Character::isLetter);
            if(!allLetters){
                return false;
            }
        }
        //if(!GenericValidator.isDate(DOB, "MM-DD-YYYY", dV)){
        //    return false;
        //}
        //if(Country.equals("Null")){
            //return false;
        //}
        //return GenericValidator.isEmail(Email);
        return true;
    }
    public Boolean searchDB(Petition j){
        for(Petition i : DataBase.dataBaseMap.values()) {

            if(i.Name.equals(j.Name) && i.DOB.equals(j.DOB) && i.Country.equals(j.Country)){
                return true;
            }
        }

        return false;
    }
    /* 
    @Override
    public Petition pullFromDB(int num){
       /*  Petition newP =  
        setName(newP.getName());
        setAnum(newP.getAnum());
        setCountry(newP.getCountry());
        setDOB(newP.getDOB());
        setEmail(newP.getEmail());
        setiD(newP.getiD());
        

        return DataBase.pullFromDB(num);
    } */
    public Petition pullDB(int id){
        return DataBase.pullFromDB(id);
    }


    public Boolean writeToDB(){
        Petition p = new Petition(this.getName(),this.getDOB(),this.getEmail(),this.getCountry(),this.getAnum(), this.getiD());
        DataBase.writeToDB(p, p.getiD());
        DataBase.printDB();
        return true;
    }
    void displayPetition(){
        System.out.println(this.Name);
        System.out.println(this.Country);
        System.out.println(this.Email);
        System.out.println(this.DOB);
        System.out.println(this.Anum);
    }
}
