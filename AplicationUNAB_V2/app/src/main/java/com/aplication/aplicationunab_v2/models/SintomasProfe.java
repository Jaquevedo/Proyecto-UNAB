package com.aplication.aplicationunab_v2.models;

public class SintomasProfe {

    private String idHistorialP;
    private String fechaP;
    private String rtaP1HistP;
    private String rtaP2HistP;
    private String rtaP3HistP;
    private String rtaP4HistP;
    private String rtaP5HistP;
    private String estadoHistP;

    public SintomasProfe(String idHistorialP, String fechaP, String rtaP1HistP, String rtaP2HistP, String rtaP3HistP, String rtaP4HistP, String rtaP5HistP, String estadoHistP) {
        this.idHistorialP = idHistorialP;
        this.fechaP = fechaP;
        this.rtaP1HistP = rtaP1HistP;
        this.rtaP2HistP = rtaP2HistP;
        this.rtaP3HistP = rtaP3HistP;
        this.rtaP4HistP = rtaP4HistP;
        this.rtaP5HistP = rtaP5HistP;
        this.estadoHistP = estadoHistP;
    }

    public String getIdHistorialP() {
        return idHistorialP;
    }

    public void setIdHistorialP(String idHistorialP) {
        this.idHistorialP = idHistorialP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public String getRtaP1HistP() {
        return rtaP1HistP;
    }

    public void setRtaP1HistP(String rtaP1HistP) {
        this.rtaP1HistP = rtaP1HistP;
    }

    public String getRtaP2HistP() {
        return rtaP2HistP;
    }

    public void setRtaP2HistP(String rtaP2HistP) {
        this.rtaP2HistP = rtaP2HistP;
    }

    public String getRtaP3HistP() {
        return rtaP3HistP;
    }

    public void setRtaP3HistP(String rtaP3HistP) {
        this.rtaP3HistP = rtaP3HistP;
    }

    public String getRtaP4HistP() {
        return rtaP4HistP;
    }

    public void setRtaP4HistP(String rtaP4HistP) {
        this.rtaP4HistP = rtaP4HistP;
    }

    public String getRtaP5HistP() {
        return rtaP5HistP;
    }

    public void setRtaP5HistP(String rtaP5HistP) {
        this.rtaP5HistP = rtaP5HistP;
    }

    public String getEstadoHistP() {
        return estadoHistP;
    }

    public void setEstadoHistP(String estadoHistP) {
        this.estadoHistP = estadoHistP;
    }

    @Override
    public String toString() {
        return "SintomasProfe{" +
                "idHistorialP='" + idHistorialP + '\'' +
                ", fechaP='" + fechaP + '\'' +
                ", rtaP1HistP='" + rtaP1HistP + '\'' +
                ", rtaP2HistP='" + rtaP2HistP + '\'' +
                ", rtaP3HistP='" + rtaP3HistP + '\'' +
                ", rtaP4HistP='" + rtaP4HistP + '\'' +
                ", rtaP5HistP='" + rtaP5HistP + '\'' +
                ", estadoHistP='" + estadoHistP + '\'' +
                '}';
    }
}
