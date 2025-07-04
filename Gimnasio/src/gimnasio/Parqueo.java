/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

/**
 *
 * @author XPC
 */
public class Parqueo {
private char[][] g1 = new char[4][5];
    private char[][] g2 = new char[5][5];
    private char[][] g3 = new char[6][5];

    public Parqueo() {
        inicializar(g1, 'L');
        inicializar(g2, 'L');
        inicializar(g3, 'L');

        marcarDiscapacitados(g1);
        marcarDiscapacitados(g2);
        marcarDiscapacitados(g3);

        marcarEntrenadores(g1);
        marcarEntrenadores(g2);
        marcarEntrenadores(g3);
    }
private void inicializar(char[][] nivel, char valor) {
        for (int i = 0; i < nivel.length; i++) {
            for (int j = 0; j < nivel[0].length; j++) {
                nivel[i][j] = valor;
            }
        }
    }

    private void marcarDiscapacitados(char[][] nivel) {
        int marcados = 0;
        for (int i = 0; i < nivel.length && marcados < 3; i++) {
            nivel[i][0] = 'D';
            marcados++;
        }
    }

    private void marcarEntrenadores(char[][] nivel) {
        int filas = nivel.length;
        int columnas = nivel[0].length;
        int marcados = 0;
        for (int i = 0; i < filas && marcados < 2; i++) {
            for (int j = 0; j < columnas && marcados < 2; j++) {
                if (nivel[i][j] == 'L') {
                    nivel[i][j] = 'E';
                    marcados++;
                }
            }
        }
    }

    private void mostrarNivel(char[][] nivel, String nombre) {
        System.out.println("Nivel " + nombre + ":");
        System.out.print("   ");
        for (int i = 1; i <= 5; i++) {
            System.out.print("| " + i + " ");
        }
        System.out.println("|");

        for (int i = 0; i < nivel.length; i++) {
            System.out.print((char)('A' + i) + "  ");
            for (int j = 0; j < nivel[0].length; j++) {
                System.out.print("| " + nivel[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println();
    }

    public void mostrarTodo() {
        mostrarNivel(g1, "G1");
        mostrarNivel(g2, "G2");
        mostrarNivel(g3, "G3");
    }

}
