/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gimnasio;

import java.util.Scanner;

/**
 *
 * @author XPC
 */
public class Gimnasio {

    static Socio[] socios = new Socio[10];
    static Parqueo parqueo = new Parqueo();
    static Scanner entradaUsuario = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cargarSocios();
        int opcion;

        do {
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Mostrar parqueos");
            System.out.println("2. Buscar socio por ID");
            System.out.println("3. Asignar un parqueo");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = entradaUsuario.nextInt();
            entradaUsuario.nextLine(); // Limpia buffer

            switch (opcion) {
                case 1:
                    parqueo.mostrarTodo();
                    break;
                case 2:
                    System.out.print("Ingrese ID del socio: ");
                    String id = entradaUsuario.nextLine().trim();
                    Socio s = buscarSocio(id);
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
                        }
                    } else {
                        System.out.println("Socio no encontrado o inactivo.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public static void cargarSocios() { //La lista de los 4 socios por el momento con su id y nombres
        socios[0] = new Socio("S001", "Carlos Gomez", true);
        socios[1] = new Socio("S002", "Ana Ruiz", true);
        socios[2] = new Socio("S003", "Luis Torres", false);
        socios[3] = new Socio("S004", "Maria Solis", true);
    }

    public static Socio buscarSocio(String id) { //Esto es un for que busca entre la lista al que solicitan
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] != null && socios[i].getId().equalsIgnoreCase(id)) {
                return socios[i];
            }
        }
        return null;

    }

}
