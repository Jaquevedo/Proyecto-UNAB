package com.aplication.aplicationunab_v2.models;

public class Estudiante {

    private String uId;
    private String email;
    private String nombres;
    private String documento;
    private String programa;
    private String password;
    private String estado;

    public Estudiante(String uId, String email, String nombres, String documento, String programa, String password, String estado) {
        this.uId = uId;
        this.email = email;
        this.nombres = nombres;
        this.documento = documento;
        this.programa = programa;
        this.password = password;
        this.estado = estado;
    }

    public Estudiante() {

    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "uId='" + uId + '\'' +
                ", email='" + email + '\'' +
                ", nombres='" + nombres + '\'' +
                ", documento='" + documento + '\'' +
                ", programa='" + programa + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
