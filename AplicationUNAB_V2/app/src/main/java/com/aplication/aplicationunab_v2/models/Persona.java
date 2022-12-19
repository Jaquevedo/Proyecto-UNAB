package com.aplication.aplicationunab_v2.models;

public class Persona {

    private String uId;
    private String user;
    private String nombres;
    private String apellidos;
    private String programa;
    private String password;
    private String rol;

    public Persona(String uId, String user, String nombres, String apellidos, String programa, String password, String rol) {
        this.uId = uId;
        this.user = user;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.programa = programa;
        this.password = password;
        this.rol = rol;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
