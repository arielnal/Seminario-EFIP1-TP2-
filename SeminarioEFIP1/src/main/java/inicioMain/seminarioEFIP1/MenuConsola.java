/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicioMain.seminarioEFIP1;

import gestionBeneficiario.*;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class MenuConsola {

    private final Beneficiario benA = new Beneficiario();
    private final Scanner entrada = new Scanner(System.in);

    public void MenuConsola() {
        int bandera = 0;
        int seleccion = 0;
        do {

            do {
                System.out.println("Por favor selecciones una opcción:");
                System.out.println("   1. Agregar Beneficiario.");
                System.out.println("   2. Modificar Beneficiario.");
                System.out.println("   3. Mostrar Lista de beneficiarios.");
                System.out.println("   4. Menú de lotes.");
                System.out.println("   5. Salir.");
                System.out.print("   Selecciones su opción: ");
                seleccion = entrada.nextInt();

                if (seleccion >= 1 && seleccion <= 5) {
                    bandera = 1;
                } else {
                    System.out.print("Opción no disponible");
                    System.out.print("Seleccione una opción disponible");
                    System.out.print("   Selecciones su opción: ");
                }

            } while (bandera == 0);
      
            switch (seleccion) {
                case 1 -> benA.AltaBen();
                case 2 -> benA.ModificarBen();
                case 3 -> benA.ImprimirLista();
                case 4 -> benA.ML();
                case 5 -> {
                    System.out.println("Gracias!, vuelva pronto");
                    bandera = 2;
                }
            }
        } while (bandera != 2);
    }

}
