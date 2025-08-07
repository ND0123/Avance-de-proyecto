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
public class ModuloAuditorio {
private static Auditorio[] sesiones= new Auditorio[2];
private static Socio[] socios;

    public ModuloAuditorio(Socio[] socios) {
        this.socios = socios;
    }

    public Auditorio[] getSesiones() {
        return sesiones;
    }

    public void setSesiones(Auditorio[] sesiones) {
        this.sesiones = sesiones;
    }

    public Socio[] getSocios() {
        return socios;
    }

    public void setSocios(Socio[] socios) {
        this.socios = socios;
    }



public static void ejecutar(Socio[] listaSocios) {
        socios = listaSocios;

        if (sesiones[0] == null) {
            sesiones[0] = new Auditorio("10:00 AM");
            sesiones[1] = new Auditorio("3:00 PM");
        }

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "AUDITORIO FITNESS\n" +
                "1. Ver cupos disponibles\n" +
                "2. Inscribir socio\n" +
                "3. Cancelar inscripción\n" +
                "4. Ver lista de inscritos\n" +
                "5. Volver"
            ));

            switch (opcion) {
                case 1:
                    String mensaje = "";
                    for (int i = 0; i < sesiones.length; i++) {
                        mensaje += (i + 1) + ". Sesión " + sesiones[i].getHorario() +
                                " - Cupos disponibles: " + sesiones[i].getCuposDisponibles() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case 2:
                    int s = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la sesión (1-2):")) - 1;
                    String id = JOptionPane.showInputDialog("Ingrese el ID del socio:");
                    sesiones[s].inscribirSocio(id);
                    break;

                case 3:
                    int sc = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la sesión (1-2):")) - 1;
                    String idCancelar = JOptionPane.showInputDialog("Ingrese el ID a cancelar:");
                    sesiones[sc].cancelarInscripcion(idCancelar);
                    break;

                case 4:
                    int sv = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la sesión (1-2):")) - 1;
                    sesiones[sv].mostrarInscritos(socios);
                    break;
            }

        } while (opcion != 5);
    }
}
