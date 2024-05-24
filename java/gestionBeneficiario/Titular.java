/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionBeneficiario;


/**
 *
 * @author ariel
 */
public class Titular {

    public String nombre;
    public String apellido;
    public int dni, mz, cs;
    public Titular siguiente;

    public Titular(String nombre, String apellido, int dni, int mz, 
            int cs, Titular siguiente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mz = mz;
        this.cs = cs;
        this.siguiente = siguiente;
    }
    public Titular(String nombre, String apellido, int dni, int mz, int cs) {
        this(nombre, apellido, dni, mz, cs, null);
    }  

}
