/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author XPC
 */
public class ModuloClaseGrupales {
private static ClaseGrupal[] clases = new ClaseGrupal[6];

public static void ejecutar() {
        inicializarClases();

        int subopcion;
        do {
            subopcion = Integer.parseInt(JOptionPane.showInputDialog(
                "GESTIÓN DE CLASES GRUPALES\n\n" +
                "1. Ver clases disponibles\n" +
                "2. Inscribir socio en clase\n" +
                "3. Cancelar inscripción\n" +
                "4. Ver inscritos\n" +
                "5. Volver al menú principal"
            ));

            switch (subopcion) {
                case 1:
                    mostrarClasesDisponibles();
                    break;
                case 2:
                    int claseInscribir = Integer.parseInt(
                            JOptionPane.showInputDialog("Ingrese el número de la clase (1-6):")
                    ) - 1;
                    String id = JOptionPane.showInputDialog("Ingrese el ID del socio:");
                    clases[claseInscribir].registrarSocio(id);
                    break;
                case 3:
                    int claseCancelar = Integer.parseInt(
                            JOptionPane.showInputDialog("Ingrese el número de la clase (1-6):")
                    ) - 1;
                    String idCancelar = JOptionPane.showInputDialog("Ingrese el ID del socio a cancelar:");
                    clases[claseCancelar].cancelarReserva(idCancelar);
                    break;
                case 4:
                    int claseVer = Integer.parseInt(
                            JOptionPane.showInputDialog("Ingrese el número de la clase (1-6):")
                    ) - 1;
                    clases[claseVer].mostrarInscritos();
                    break;
                case 5:
                    // volver
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (subopcion != 5);
    }

    private static void inicializarClases() {
        if (clases[0] == null) {
            clases[0] = new ClaseGrupal("Yoga", "7:00 AM", 10);
            clases[1] = new ClaseGrupal("Zumba", "8:00 AM", 15);
            clases[2] = new ClaseGrupal("Pilates", "9:00 AM", 12);
            clases[3] = new ClaseGrupal("Crossfit", "6:00 PM", 12);
            clases[4] = new ClaseGrupal("Funcional", "7:00 PM", 10);
            clases[5] = new ClaseGrupal("Step", "8:00 PM", 15);
        }
    }

    private static void mostrarClasesDisponibles() {
        String listado = "CLASES DISPONIBLES\n\n";
        listado += " MAÑANA:\n";
        for (int i = 0; i < 3; i++) {
            listado += (i + 1) + ". " + clases[i].getNombre() + " - " +
                    clases[i].getHorario() + " - Cupos disponibles: " +
                    clases[i].getCuposDisponibles() + "\n";
        }
        listado += "\n NOCHE:\n";
        for (int i = 3; i < 6; i++) {
            listado += (i + 1) + ". " + clases[i].getNombre() + " - " +
                    clases[i].getHorario() + " - Cupos disponibles: " +
                    clases[i].getCuposDisponibles() + "\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }


}
