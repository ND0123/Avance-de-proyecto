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
    
    // Matrices paralelas para guardar ID de socio
    

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
 public boolean asignarEspacio(int nivel, int fila, int columna) {
        char[][] seleccionado;

        if (nivel == 1) {
            seleccionado = g1;
        } else if (nivel == 2) {
            seleccionado = g2;
        } else if (nivel == 3) {
            seleccionado = g3;
        } else {
            return false;
        }

        if (fila >= 0 && fila < seleccionado.length && columna >= 0 && columna < seleccionado[0].length) {
            if (seleccionado[fila][columna] == 'L') {
                seleccionado[fila][columna] = 'O'; // "O" de ocupado
                return true;
            }
        }
        return false;
    }
        
                  
public boolean asignarEspacio(String nivel, char fila, int columna) {
    char[][] parqueoSeleccionado = null;

    switch (nivel.toUpperCase()) {
        case "G1": parqueoSeleccionado = g1; break;
        case "G2": parqueoSeleccionado = g2; break;
        case "G3": parqueoSeleccionado = g3; break;
        default: System.out.println("Nivel inválido."); return false;
    }

    int filaIndex = fila - 'A';
    int columnaIndex = columna - 1;

    if (filaIndex < 0 || filaIndex >= parqueoSeleccionado.length ||
        columnaIndex < 0 || columnaIndex >= parqueoSeleccionado[0].length) {
        System.out.println("Posición fuera de rango.");
        return false;
    }

    if (parqueoSeleccionado[filaIndex][columnaIndex] == 'L') {
        parqueoSeleccionado[filaIndex][columnaIndex] = 'O';
        return true;
    } else {
        System.out.println("Espacio ya ocupado o reservado.");
        return false;
    }
}

}
