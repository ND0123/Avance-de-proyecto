/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ##main
 */
public class CabinaInsonorizada {
    
    
    private boolean estado = true;
    private String horaReserva;
    private String id;

    @Override
    public String toString() {
        return "CabinaInsonorizada{" + "estado=" + estado + ", horaReserva=" + horaReserva + ", id=" + id + '}';
    }


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean getEstado() {
        return estado;
    }
    
    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public CabinaInsonorizada(boolean estado, String horaReserva, String id) {
        this.estado = estado;
        this.horaReserva = horaReserva;
        this.id = id;
    }
    
    public static void llenaDataAleatoria(CabinaInsonorizada[] vector ){
        for (int i = 0; i < vector.length; i++) {
            Random numero = new Random();
            vector[i]= new CabinaInsonorizada( true, i+9+":"+"00", "ss");
        }
    }
    
    
    public static void reservarHorario(CabinaInsonorizada[] vector, int indice ){  
        //JOptionPane.showInputDialog(null, "El numero de horario que desea modificar");
        Boolean estado = false;
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del socio de la reserva: ");
        vector[indice-1].setId(id);
        vector[indice-1].setEstado(estado);
    }

    
    public static int MostrarHorariosCabinas(CabinaInsonorizada[] vector) {

        StringBuilder resultado = new StringBuilder();

        resultado.append("                      Horarios disponibles\n Seleccione un horario para reservar\n=================================\n");

        for (int i = 0; i < vector.length; i++) {
            boolean estadoreserva = vector[i].getEstado();
            if (estadoreserva) {
                int indice = i + 1;
                resultado.append(indice + "- ");
                resultado.append(vector[i].getHoraReserva());
                resultado.append("\n");
            } else {
            }

        }
        int opcHorario = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));
        return opcHorario;
    }
}
    