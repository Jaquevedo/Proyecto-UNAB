package com.aplication.aplicationunab_v2.models;

public class cursos {
    private String UID;
    private String docente;
    private String codigo;
    private String curso;
    private String horario;

    public cursos(String UID, String docente, String codigo, String curso, String horario) {
        this.UID = UID;
        this.docente = docente;
        this.codigo = codigo;
        this.curso = curso;
        this.horario = horario;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }



}


