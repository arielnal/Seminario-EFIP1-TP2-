/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionBeneficiario;

import inicioMain.seminarioEFIP1.MenuConsola;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Beneficiario {

    private int mz, cs;
    protected Loteo l;
    protected Titular inicio;
    private final Scanner entrada = new Scanner(System.in);

    public Beneficiario() {
        inicio = null;
    }

    public boolean listaVacia() {
        return inicio == null;
    }

    public boolean BenefIngresado(String nombre, String apellido, int dni, int mz, int cs) {
        Titular recorrer = inicio;
        Titular auxiliar = new Titular(nombre, apellido, dni, mz, cs);
        int aux = 0;
        if (!listaVacia()) {
            while (recorrer != null) {
                if (auxiliar.dni == recorrer.dni) {
                    aux++;
                }
                recorrer = recorrer.siguiente;
            }
        }
        return aux == 0;
    }

    public void AltaBen() {

        System.out.println("Por favor complete los campos solicitados. No admite errores en el DNI");
        System.out.print("   1. Nombre Beneficiario: ");
        String nombre = entrada.next();
        System.out.print("   2. Apellido Beneficiario: ");
        String apellido = entrada.next();
        System.out.print("   3. DNI Beneficiario: ");
        int dni = entrada.nextInt();
        System.out.print("   4. Indicar ubicación de la manzana: ");
        int mz = entrada.nextInt();
        System.out.print("   5. Indicar ubicación de la casa: ");
        int cs = entrada.nextInt();

        if (BenefIngresado(nombre, apellido, dni, mz, cs)) {
            Titular nT = new Titular(nombre, apellido, dni, mz, cs);
            if (l.Estado(mz, cs)) {
                if (listaVacia()) {
                    inicio = nT;
                    l.AsignarLote(mz, cs);
                } else {
                    nT.siguiente = inicio;
                    inicio = nT;
                    l.AsignarLote(mz, cs);
                }
                System.err.println("Beneficiario ingresado con éxito");
            } else {
                System.err.println("Lote ocupado o inexistente, consulte disponibles");
            }
        } else {
            //mensaje para avisar que el código ya fue utilizado
            System.err.println("El beneficiario ya se encuantr en el registro");
        }
    }

    public void ModificarBen() {

        System.out.println("Por favor complete los campos solicitados. No admite cambios en el DNI!");
        System.out.print("   1. Nombre Beneficiario: ");
        String nombre = entrada.next();
        System.out.print("   2. Apellido Beneficiario: ");
        String apellido = entrada.next();
        System.out.print("   3. DNI Beneficiario: ");
        int dni = entrada.nextInt();
        System.out.print("   4. Indicar ubicación de la manzana: ");
        int mz = entrada.nextInt();
        System.out.print("   5. Indicar ubicación de la casa: ");
        int cs = entrada.nextInt();

        if (!listaVacia()) {
            Titular recorrer = inicio;
            Titular auxiliar = new Titular(nombre, apellido, dni, mz, cs);
            while (recorrer != null) {
                if (auxiliar.dni == recorrer.dni) {
                    l.LiberarLote(recorrer.mz, recorrer.cs);
                    recorrer.nombre = auxiliar.nombre;
                    recorrer.apellido = auxiliar.apellido;
                    recorrer.mz = auxiliar.mz;
                    recorrer.cs = auxiliar.cs;
                    l.AsignarLote(auxiliar.mz, auxiliar.cs);
                    System.err.println("Cambio exitoso!");
                }
                recorrer = recorrer.siguiente;
            }
        } else {
            System.out.println(" El beneficiario no encontrado!");
        }
    }

    public void ImprimirLista() {

        System.out.println("lista vacía?" + listaVacia());

        if (!listaVacia()) {
            String contLista = "Lista actual de beneficiarios \n";
            Titular recorrer = inicio;
            while (recorrer != null) {
                contLista += "nombre: " + recorrer.nombre + " - apellido: "
                        + recorrer.apellido + " - dni: " + recorrer.dni
                        + " - mz: " + recorrer.mz + " - cs: " + recorrer.cs + "\n";
                recorrer = recorrer.siguiente;
            }
            System.out.println(contLista
                    + "Fin de la lista");
        } else {
            System.out.println("Lista vacía");
        }
    }

    public void ML() {
        int bandera = 0;
        int seleccion;
        do {
            System.out.println("Por favor selecciones una opcción:");
            System.out.println("   1. Indicar tamaño del loteo.");
            System.out.println("   2. Mostrar Lista de lotes Vacíos.");
            System.out.println("   3. Mostrar Lista de lotes Ocupados");
            System.out.println("   4. Retroceder.");
            System.out.print("   Selecciones su opción: ");
            seleccion = entrada.nextInt();

            if (seleccion >= 1 && seleccion < 4) {
                bandera = 1;
            } else {
                System.out.print("Opción no disponible");
                System.out.print("Seleccione una opción disponible");
                System.out.print("   Selecciones su opción: ");
            }

        } while (bandera == 0);

        switch (seleccion) {
            case 1 ->
                TamaLot();
            case 2 ->
                l.MLotesV();
            case 3 ->
                l.MLotesO();
            case 4 ->
                System.err.println("   Seleccionó : volver al menú en consola");
        }
    }

    public void TamaLot() {

        System.out.println("Por favor siga las indicaciones");
        System.out.print("   1. Indicar el núemro de manzanas: ");
        mz = entrada.nextInt();
        System.out.print("   2. Indicar el número de casas: ");
        cs = entrada.nextInt();
        
        this.l = new Loteo(mz, cs);
        l.VaciarLote();

    }

}
