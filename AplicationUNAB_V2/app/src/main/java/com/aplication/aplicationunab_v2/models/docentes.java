package com.aplication.aplicationunab_v2.models;

public class Docentes {

    private String UID;
    private String email;
    private String nombre;
    private String doc;
    private String programa;
    private String pass;
    private String estado;

    public Docentes(String UID, String nombre, String programa, String doc, String email, String pass, String estado) {
        this.UID = UID;
        this.nombre = nombre;
        this.programa = programa;
        this.doc = doc;
        this.email = email;
        this.pass = pass;
        this.estado = estado;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Docentes{" +
                "UID='" + UID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", programa='" + programa + '\'' +
                ", doc='" + doc + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
