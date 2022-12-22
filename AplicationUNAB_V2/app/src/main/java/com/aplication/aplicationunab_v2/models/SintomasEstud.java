package com.aplication.aplicationunab_v2.models;

public class SintomasEstud {

    private String idHistorial;
    private String fecha;
    private String rtaP1Hist;
    private String rtaP2Hist;
    private String rtaP3Hist;
    private String rtaP4Hist;
    private String rtaP5Hist;
    private String estadoHist;

    public SintomasEstud(String idHistorial, String fecha, String rtaP1Hist, String rtaP2Hist, String rtaP3Hist, String rtaP4Hist, String rtaP5Hist, String estadoHist) {
        this.idHistorial = idHistorial;
        this.fecha = fecha;
        this.rtaP1Hist = rtaP1Hist;
        this.rtaP2Hist = rtaP2Hist;
        this.rtaP3Hist = rtaP3Hist;
        this.rtaP4Hist = rtaP4Hist;
        this.rtaP5Hist = rtaP5Hist;
        this.estadoHist = estadoHist;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRtaP1Hist() {
        return rtaP1Hist;
    }

    public void setRtaP1Hist(String rtaP1Hist) {
        this.rtaP1Hist = rtaP1Hist;
    }

    public String getRtaP2Hist() {
        return rtaP2Hist;
    }

    public void setRtaP2Hist(String rtaP2Hist) {
        this.rtaP2Hist = rtaP2Hist;
    }

    public String getRtaP3Hist() {
        return rtaP3Hist;
    }

    public void setRtaP3Hist(String rtaP3Hist) {
        this.rtaP3Hist = rtaP3Hist;
    }

    public String getRtaP4Hist() {
        return rtaP4Hist;
    }

    public void setRtaP4Hist(String rtaP4Hist) {
        this.rtaP4Hist = rtaP4Hist;
    }

    public String getRtaP5Hist() {
        return rtaP5Hist;
    }

    public void setRtaP5Hist(String rtaP5Hist) {
        this.rtaP5Hist = rtaP5Hist;
    }

    public String getEstadoHist() {
        return estadoHist;
    }

    public void setEstadoHist(String estadoHist) {
        this.estadoHist = estadoHist;
    }

    @Override
    public String toString() {
        return "Sintomas{" +
                "idHistorial='" + idHistorial + '\'' +
                ", fecha='" + fecha + '\'' +
                ", rtaP1Hist='" + rtaP1Hist + '\'' +
                ", rtaP2Hist='" + rtaP2Hist + '\'' +
                ", rtaP3Hist='" + rtaP3Hist + '\'' +
                ", rtaP4Hist='" + rtaP4Hist + '\'' +
                ", rtaP5Hist='" + rtaP5Hist + '\'' +
                ", estadoHist='" + estadoHist + '\'' +
                '}';
    }
}
