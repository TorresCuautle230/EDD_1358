/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nomina;

/**
 *
 * @author cuaut
 */
public class Trabajador {
    private double HORA_EXTRA = 276.5;
    private int numTrabajador;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int hrsExtra;
    private int suledoBase;
    private int añoingreso;

    public Trabajador(int numTrabajador, String nombre, String apPaterno, String apMaterno, int hrsExtra, int suledoBase, int añoingreso) {
        this.numTrabajador = numTrabajador;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.hrsExtra = hrsExtra;
        this.suledoBase = suledoBase;
        this.añoingreso = añoingreso;
    }

    Trabajador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getNumTrabajador() {
        return numTrabajador;
    }

    public void setNumTrabajador(int numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public int getHrsExtra() {
        return hrsExtra;
    }

    public void setHrsExtra(int hrsExtra) {
        this.hrsExtra = hrsExtra;
    }

    public int getSuledoBase() {
        return suledoBase;
    }

    public void setSuledoBase(int suledoBase) {
        this.suledoBase = suledoBase;
    }

    public int getAñoingreso() {
        return añoingreso;
    }

    public void setAñoingreso(int añoingreso) {
        this.añoingreso = añoingreso;
    }

    @Override
    public String toString() {
        return "{" + " numTrabajador=" + numTrabajador + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", hrsExtra=" + hrsExtra + ", suledoBase=" + suledoBase + ", a\u00f1oingreso=" + añoingreso + '}';
    }

    
    

    public double sueldoTotal(){
        int antiguedad=2022-añoingreso;
        double total=suledoBase+(suledoBase*(antiguedad*0.03))+(hrsExtra*HORA_EXTRA);
        return total;
    }


    
}
