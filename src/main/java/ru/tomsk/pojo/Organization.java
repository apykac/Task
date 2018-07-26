package ru.tomsk.pojo;

public class Organization {
    private long id;
    private int inn;
    private int ogrn;
    private String name;
    private String address;

    public Organization() {
    }

    public Organization(int inn, int ogrn, String name, String address) {
        this.inn = inn;
        this.ogrn = ogrn;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public int getOgrn() {
        return ogrn;
    }

    public void setOgrn(int ogrn) {
        this.ogrn = ogrn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", inn=" + inn +
                ", ogrn=" + ogrn +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
