/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gimnasio;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author XPC
 */
public class Gimnasio {

    static Socio[] socios = new Socio[10];
    static Parqueo parqueo = new Parqueo();
    static SalaPesas salaPesas = new SalaPesas();

    // Escáneres separados para evitar conflictos de buffer
    static Scanner entradaUsuario = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarSocios();
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Mostrar parqueos");
            System.out.println("2. Buscar socio por ID");
            System.out.println("3. Asignar un parqueo");
            System.out.println("4. Ingresar a sala de pesas");
            System.out.println("5. Salir de sala de pesas");
            System.out.println("6. Ver personas en sala de pesas");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");
            opcion = entradaUsuario.nextInt();
            entradaUsuario.nextLine(); // limpia buffer

            switch (opcion) {
                case 1:
                    parqueo.mostrarTodo();
                    break;

                case 2:
                    System.out.print("Ingrese ID del socio: ");
                    String idBuscar = entradaUsuario.nextLine().trim();
                    Socio s = buscarSocio(idBuscar);
                    if (s != null) {
                        System.out.println("Socio encontrado: " + s.getNombre() + " | Activo: " + s.isActivo());
                    } else {
                        System.out.println("Socio no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese ID del socio: ");
                    String idSocio = entradaUsuario.nextLine();
                    Socio socio = buscarSocio(idSocio);

                    if (socio != null && socio.isActivo()) {
                        System.out.print("Ingrese nivel de parqueo (G1, G2, G3): ");
                        String nivel = entradaUsuario.nextLine();

                        System.out.print("Ingrese fila (A-F): ");
                        char fila = entradaUsuario.nextLine().toUpperCase().charAt(0);

                        System.out.print("Ingrese columna (1-5): ");
                        int columna = entradaUsuario.nextInt();
                        entradaUsuario.nextLine(); // limpia buffer

                        boolean asignado = parqueo.asignarEspacio(nivel, fila, columna);
                        if (asignado) {
                            System.out.println("Parqueo asignado correctamente.");
                        } else {
                            System.out.println("No se pudo asignar el parqueo.");
                        }
                    } else {
                        System.out.println("Socio no encontrado o inactivo.");
                    }
                    break;

                case 4:
                    String idIngreso = JOptionPane.showInputDialog(null, "Ingrese ID del socio para ingresar a sala de pesas:");
                    if (idIngreso != null) {
                        Socio socioIngreso = buscarSocio(idIngreso);
                        if (socioIngreso != null && socioIngreso.isActivo()) {
                            salaPesas.ingresar(idIngreso);
                            JOptionPane.showMessageDialog(null, "Ingreso exitoso para: " + socioIngreso.getNombre());
                        } else {
                            JOptionPane.showMessageDialog(null, "Socio no válido o no activo.");
                        }
                    }
                    break;

                case 5:
                    String idSalida = JOptionPane.showInputDialog(null, "Ingrese ID del socio para salir de sala de pesas:");
                    if (idSalida != null) {
                        salaPesas.salir(idSalida);
                        JOptionPane.showMessageDialog(null, "Salida procesada para el ID: " + idSalida);
                    }
                    break;

                case 6:
                    int cantidad = salaPesas.getCantidadActual();
                    JOptionPane.showMessageDialog(null, "Personas en sala de pesas: " + cantidad);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void cargarSocios() {
        socios[0] = new Socio("S001", "Carlos Gomez", true, "Pilates");
        socios[1] = new Socio("S002", "Ana Virginia", true, "Pilates");
        socios[2] = new Socio("S003", "Luis Torres", false, "Pilates");
        socios[3] = new Socio("S004", "Maria Solis", true, "Pilates");
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
