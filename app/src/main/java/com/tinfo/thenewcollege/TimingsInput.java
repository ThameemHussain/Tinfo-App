package com.tinfo.thenewcollege;


public class TimingsInput {
    public String todaydate,fajr,zohar,asar,maghrib,isha,jummah,jummah2;

    public TimingsInput(){

    }
    public TimingsInput(String todaydate,String fajr,String zohar,String asar,String maghrib,String isha,String jummah,String jummah2){
        this.todaydate=todaydate;
        this.fajr=fajr;
        this.zohar=zohar;
        this.asar=asar;
        this.maghrib=maghrib;
        this.isha=isha;
        this.jummah=jummah;
        this.jummah2=jummah2;
    }
}
