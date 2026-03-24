package com.example.practicaexamenfx.model;

public class Contacto {

    private String name;
    private String tel;
    private String parent;



    public Contacto(String name, String tel, String parent) {
        this.name = name;
        this.tel = tel;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
