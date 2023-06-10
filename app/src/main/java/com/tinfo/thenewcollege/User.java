package com.tinfo.thenewcollege;



public class User {

    public  String n,em,d,Section,YearofStudying;
    public User(){

    }
    public User(String n,String em,String d,String Section,String YearofStudying)
        {
        this.n=n;
        this.em=em;
        this.d=d;
        this.Section=Section;
        this.YearofStudying=YearofStudying;
        }

        public  String getname(){
        return n;
        }
        public void setname(String n){
        this.n=n;
        }

}
