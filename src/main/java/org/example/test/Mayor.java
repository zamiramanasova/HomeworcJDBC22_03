package org.example.test;

public class Mayor {

    private int id;
    private String profession;
    private String name;
    private int age;

    public Mayor() {
    }

    public Mayor(int id, String profession, String name, int age, int cityId) {
        this.id = id;
        this.profession = profession;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Mayor{" +
//                "id=" + id +
//                ", profession='" + profession + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", cityId=" + cityId +
//                '}';
//    }

    @Override
    public String toString() {
        return "{Mayor: " + id +
                ", " + profession + '\'' +
                ", " + name + '\'' +
                ", " + age +
                '}';
    }
}
