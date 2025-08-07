package gimnasio;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
   
/**
 *
 * @author sebss
 */
/**
 *
 * @author sebss
 */
public class SalaPesas {
    private final int CAPACIDAD_MAXIMA = 50;
    private String[] personasEnSala = new String[CAPACIDAD_MAXIMA];
    private int cantidadActual = 0;

    public void ingresar(String id) {
        if (cantidadActual >= CAPACIDAD_MAXIMA) {
            JOptionPane.showMessageDialog(null, "La sala está llena.");
            return;
        }
        if (estaDentro(id)) {
            JOptionPane.showMessageDialog(null, "El socio ya está en la sala.");
            return;
        }
        personasEnSala[cantidadActual++] = id;
        JOptionPane.showMessageDialog(null, "Ingreso registrado.");
    }

    public void salir(String id) {
        int index = -1;
        for (int i = 0; i < cantidadActual; i++) {
            if (personasEnSala[i].equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < cantidadActual - 1; i++) {
                personasEnSala[i] = personasEnSala[i + 1];
            }
            personasEnSala[--cantidadActual] = null;
            JOptionPane.showMessageDialog(null, "Salida registrada.");
        } else {
            JOptionPane.showMessageDialog(null, "El socio no estaba en la sala.");
        }
    }

    public void mostrarCantidad() {
        JOptionPane.showMessageDialog(null, "Personas en la sala: " + cantidadActual);
    }

    private boolean estaDentro(String id) {
        for (int i = 0; i < cantidadActual; i++) {
            if (personasEnSala[i].equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    public int getCantidadActual() {
        return cantidadActual;
    }
}


    





