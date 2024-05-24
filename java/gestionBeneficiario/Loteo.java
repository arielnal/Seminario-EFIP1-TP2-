/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionBeneficiario;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Loteo {

    private final int mz, cs;
    private final Boolean[][] loteo;
    private final Boolean vacio = true;
    private final Boolean ocupado = false;


    public Loteo(int mz, int cs) {
        this.loteo = new Boolean[mz][cs];
        this.mz = mz;
        this.cs = cs;
    }

    public void VaciarLote() {
        for (int i = 0; i < mz; i++) {
            for (int j = 0; j < cs; j++) {
                loteo[i][j] = vacio;
            }
        }
    }


    public void AsignarLote(int mz, int cs) {
        if (mz >= 4 || cs >= 4) {
            throw new ArrayIndexOutOfBoundsException("No existe el lote seleccionado");
        } else if (mz < 4 || cs < 4) {
            loteo[mz][cs] = ocupado;
            System.out.println("Lote asignado!");
        }
    }

    public void LiberarLote(int mz, int cs) {
        if (mz >= 4 || cs >= 4) {
            throw new ArrayIndexOutOfBoundsException("No existe el lote seleccionado");
        } else if (mz < 4 || cs < 4) {
            loteo[mz][cs] = vacio;
            System.err.println("Lote libre!");
        }
    }

    public Boolean Estado(int mz, int cs) {
        try {
            Boolean estado = loteo[mz][cs];
            return estado;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No existe el lote seleccionado" + e);
        }
        return ocupado;
    }

    public void MLotesV() {
        try {
            System.out.println("Los siguientes lotes se encuantran disponibles");
            for (int i = 0; i < mz; i++) {
                for (int j = 0; j < cs; j++) {
                    if (Objects.equals(loteo[i][j], vacio)) {
                        System.out.print("[mz]:" + i + " [cs]:" + j + " + ");
                    }
                }
                System.out.println("");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No existe el lote seleccionado" + e);
        }
    }

    public void MLotesO() {
        try {
            System.out.println("Los siguientes lotes NO se encuantran disponibles");
            for (int i = 0; i < mz; i++) {
                for (int j = 0; j < cs; j++) {
                    if (Objects.equals(loteo[i][j], ocupado)) {
                        System.out.print("[mz]:" + i + " [cs]:" + j + " + ");
                    }
                }
                System.out.println("");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No existe el lote seleccionado" + e);
        }
    }

}
