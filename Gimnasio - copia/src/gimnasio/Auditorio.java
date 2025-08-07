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
public class Auditorio {
 private String horario;
    private String[] inscritos;
    private int cantidad;

    public Auditorio(String horario) {
        this.horario = horario;
        this.inscritos = new String[30];
        this.cantidad = 0;
        
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String[] getInscritos() {
        return inscritos;
    }

    public void setInscritos(String[] inscritos) {
        this.inscritos = inscritos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCuposDisponibles() {
        return 30 - cantidad;
    }

    public boolean inscribirSocio(String idSocio) {
        if (cantidad >= 30) {
            JOptionPane.showMessageDialog(null, "Sesión llena.");
            return false;
        }

        for (int i = 0; i < cantidad; i++) {
            if (inscritos[i].equals(idSocio)) {
                JOptionPane.showMessageDialog(null, "Este socio ya está inscrito.");
                return false;
            }
        }

        inscritos[cantidad] = idSocio;
        cantidad++;
        JOptionPane.showMessageDialog(null, "Socio inscrito correctamente en la sesión de " + horario + ".");
        return true;
    }

    public boolean cancelarInscripcion(String idSocio) {
        for (int i = 0; i < cantidad; i++) {
            if (inscritos[i].equals(idSocio)) {
                for (int j = i; j < cantidad - 1; j++) {
                    inscritos[j] = inscritos[j + 1];
                }
                inscritos[cantidad - 1] = null;
                cantidad--;
                JOptionPane.showMessageDialog(null, "Inscripción cancelada.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Socio no está inscrito.");
        return false;
    }

    public void mostrarInscritos(Socio[] socios) {
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No hay inscritos en la sesión de " + horario + ".");
            return;
        }

        String lista = "Inscritos en sesión de " + horario + ":\n";
        for (int i = 0; i < cantidad; i++) {
            String id = inscritos[i];
            String nombre = buscarNombrePorID(id, socios);
            lista += "- " + id + " (" + nombre + ")\n";
        }

        JOptionPane.showMessageDialog(null, lista);
    }

    private String buscarNombrePorID(String id, Socio[] socios) {
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] != null && socios[i].getId().equals(id)) {
                return socios[i].getNombre();
            }
        }
        return "Nombre no encontrado";
    }
    
    @Override
    public String toString() {
        return "Auditorio{" + "horario=" + horario + ", inscritos=" + inscritos + ", cantidad=" + cantidad + '}';
    }
    
    
}
