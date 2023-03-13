package com.example.examenjrfx;

public class Alumno {
    private String nombre;
    private String apellido;
    private Double AD;
    private Double SGE;
    private Double DI;
    private Double PMDM;
    private Double PSP;
    private Double EIE;
    private Double HLC;

    public Alumno(String nombre, String apellido, Double AD, Double SGE, Double DI, Double PMDM, Double PSP, Double EIE, Double HLC) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.AD = AD;
        this.SGE = SGE;
        this.DI = DI;
        this.PMDM = PMDM;
        this.PSP = PSP;
        this.EIE = EIE;
        this.HLC = HLC;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Double getAD() {
        return AD;
    }
    public void setAD(Double aD) {
        AD = aD;
    }
    public Double getSGE() {
        return SGE;
    }
    public void setSGE(Double sGE) {
        SGE = sGE;
    }
    public Double getDI() {
        return DI;
    }
    public void setDI(Double dI) {
        DI = dI;
    }
    public Double getPMDM() {
        return PMDM;
    }
    public void setPMDM(Double pMDM) {
        PMDM = pMDM;
    }
    public Double getPSP() {
        return PSP;
    }
    public void setPSP(Double pSP) {
        PSP = pSP;
    }
    public Double getEIE() {
        return EIE;
    }
    public void setEIE(Double eIE) {
        EIE = eIE;
    }
    public Double getHLC() {
        return HLC;
    }
    public void setHLC(Double hLC) {
        HLC = hLC;
    }
    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", AD=" + AD + ", SGE=" + SGE + ", DI=" + DI
                + ", PMDM=" + PMDM + ", PSP=" + PSP + ", EIE=" + EIE + ", HLC=" + HLC + "]";
    }
}
