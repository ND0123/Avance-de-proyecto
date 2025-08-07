/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author ##main
 */
public class ClaseGrupal {
    private String nombre;               // Ej: Yoga, Zumba, Pilates
    private String horario;             // Ej: "9:00 AM"
    private int capacidadMaxima;        // Ej: 20
    private String[] inscritos;         // Guarda los IDs de los socios inscritos
    private int cantidadActual;         // Cuántos socios hay inscritos

    public ClaseGrupal(String nombre, String horario, int capacidadMaxima) {
        this.nombre = nombre;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new String[capacidadMaxima];
        this.cantidadActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String[] getInscritos() {
        return inscritos;
    }

    public void setInscritos(String[] inscritos) {
        this.inscritos = inscritos;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    

    @Override
    public String toString() {
        return "ClaseGrupal{" + "nombre=" + nombre + ", horario=" + horario + ", capacidadMaxima=" + capacidadMaxima + ", inscritos=" + inscritos + ", cantidadActual=" + cantidadActual + '}';
    }
    
    public int getCuposDisponibles() {
        return capacidadMaxima - cantidadActual;
    }

    // Registro de socios
    public boolean registrarSocio(String idSocio) {
        if (cantidadActual >= capacidadMaxima) {
            JOptionPane.showMessageDialog(null, "La clase está llena.");
            return false;
        }

        for (int i = 0; i < cantidadActual; i++) {
            if (inscritos[i].equals(idSocio)) {
                JOptionPane.showMessageDialog(null, "El socio ya está inscrito.");
                return false;
            }
        }

        inscritos[cantidadActual] = idSocio;
        cantidadActual++;
        JOptionPane.showMessageDialog(null, "Socio registrado en " + nombre + " (" + horario + ").");
        return true;
    }

    // Cancelación de reserva
    public boolean cancelarReserva(String idSocio) {
        for (int i = 0; i < cantidadActual; i++) {
            if (inscritos[i].equals(idSocio)) {
                for (int j = i; j < cantidadActual - 1; j++) {
                    inscritos[j] = inscritos[j + 1];
                }
                inscritos[cantidadActual - 1] = null;
                cantidadActual--;
                JOptionPane.showMessageDialog(null, "Reserva cancelada.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "El socio no estaba inscrito.");
        return false;
    }

    // Mostrar lista de inscritos
    public void mostrarInscritos() {
        if (cantidadActual == 0) {
            JOptionPane.showMessageDialog(null, "No hay inscritos en esta clase.");
            return;
        }

        String lista = "Inscritos en " + nombre + " (" + horario + "):\n";
        for (int i = 0; i < cantidadActual; i++) {
            lista += "- " + inscritos[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
       
}



            
    



    





 


  
    
    
    
    
    
    
    
    
    
    
    
    
    




    
    
   
       