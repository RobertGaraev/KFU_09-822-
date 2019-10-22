package Kurs2.lab.Lab3;

import java.util.ArrayList;

public class Sportsmen {
    private String name,s,birthday;
    private ArrayList<String> place;
    private ArrayList<String> award;
    private ArrayList<Integer> year;
    private ArrayList<Integer> result;
    public Sportsmen(String name, String birthday, String s) {
        this.name = name;
        this.birthday = birthday;
        this.s=s;
        place=new ArrayList<>();
        award=new ArrayList<>();
        year=new ArrayList<>();
        result=new ArrayList<>();
    }
    public void addplace(String place){
        this.place.add(place);
    }
    public void addaward(String award){
        this.award.add(award);
    }
    public void addyear(String year){
        this.year.add(Integer.parseInt(year));
    }
    public void addresult(String result){
        this.result.add(Integer.parseInt(result));
    }
    public String getname(){
        return name;
    }
    public String getbirthday(){
        return birthday;
    }
    public String gets(){
        return s;
    }
    public String getplace(int i){
        if (i<place.size())return place.get(i);
        else return "-1";
    }
    public String getaward(int i){
        if (i<award.size())return award.get(i);
        else return "-1";
    }
    public int getyear(int i){
        if (i<year.size())return year.get(i);
        else return -1;
    }
    public int getresult(int i){
        if (i<result.size())return result.get(i);
        else return -1;
    }
}
