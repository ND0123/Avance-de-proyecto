/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gimnasio;

import javax.swing.JOptionPane;

public class Gimnasio {

    static Socio[] socios = new Socio[10];
    static Parqueo parqueo = new Parqueo();
    static CabinaInsonorizada[] cabina = new CabinaInsonorizada[9];

    public static void main(String[] args) {
        cargarSocios();
        int opcion;
        CabinaInsonorizada.llenaDataAleatoria(cabina);

        do {
            String input = JOptionPane.showInputDialog(
                "--- MENÚ PRINCIPAL ---\n"
                + "1. Mostrar parqueos\n"
                + "2. Buscar socio por ID\n"
                + "3. Asignar un parqueo\n"
                + "4. Cabinas insonorizadas\n"
                + "0. Salir\n\n"
                + "Ingrese una opción:"
            );

            if (input == null) break; // Cancelar ventana

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    parqueo.mostrarTodo();
                    break;
                case 2:
                    String id = JOptionPane.showInputDialog("Ingrese ID del socio:");
                    Socio s = buscarSocio(id);
                    if (s != null) {
                        JOptionPane.showMessageDialog(null,
                            "Socio encontrado: " + s.getNombre() + " | Activo: " + s.isActivo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Socio no encontrado.");
                    }
                    break;
                case 3:
                    String idSocio = JOptionPane.showInputDialog("Ingrese ID del socio:");
                    Socio socio = buscarSocio(idSocio);

                    if (socio != null && socio.isActivo()) {
                        String nivel = JOptionPane.showInputDialog("Ingrese nivel de parqueo (G1, G2, G3):");

                        String filaInput = JOptionPane.showInputDialog("Ingrese fila (A-F):");
                        if (filaInput == null || filaInput.length() == 0) break;
                        char fila = Character.toUpperCase(filaInput.charAt(0));

                        String colInput = JOptionPane.showInputDialog("Ingrese columna (1-5):");
                        int columna;
                        try {
                            columna = Integer.parseInt(colInput);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Columna inválida.");
                            break;
                        }

                        boolean asignado = parqueo.asignarEspacio(nivel, fila, columna);
                        if (asignado) {
                            JOptionPane.showMessageDialog(null, "Parqueo asignado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo asignar el parqueo.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Socio no encontrado o inactivo.");
                    }
                    break;
                case 4:
                    int opcHorarioCabinas = CabinaInsonorizada.MostrarHorariosCabinas(cabina);
                    CabinaInsonorizada.reservarHorario(cabina, opcHorarioCabinas);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (true);
    }

    public static void cargarSocios() {
        socios[0] = new Socio("S001", "Carlos Gomez", true);
        socios[1] = new Socio("S002", "Ana Ruiz", true);
        socios[2] = new Socio("S003", "Luis Torres", false);
        socios[3] = new Socio("S004", "Maria Solis", true);
    }

    public static Socio buscarSocio(String id) {
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] != null && socios[i].getId().equalsIgnoreCase(id)) {
                return socios[i];
            }
        }
        return null;
    }
}
