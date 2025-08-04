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

    private String nombreClase;
    private String hora;
    private String idSsocio;
    private int cupoMax;
    private int cupoActual;
    private boolean estado;
    
    public static void llenaDataAleatoria(ClaseGrupal[] vector ){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = new ClaseGrupal("nombre", i+9+":00", "nulo", i, i, true);
        }
    }
    public static int MostrarHorariosClasesGrupales(ClaseGrupal[] vector) {

        StringBuilder resultado = new StringBuilder();

        resultado.append("                      Horarios disponibles\n Seleccione un horario para reservar\n=================================\n");

        for (int i = 0; i < vector.length; i++) {
            boolean estadoreserva = vector[i].getEstado();
            if (estadoreserva) {
                int indice = i + 1;
                resultado.append(indice + "- ");
                resultado.append(vector[i].getHora());
                resultado.append("\n");
            } else {
            }
        }
        int opcHorario = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));
        return opcHorario;
    }
    public static void reservarHorario(ClaseGrupal[] vector, int indice ){  
        //JOptionPane.showInputDialog(null, "El numero de horario que desea modificar");
        Boolean estado = false;
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del socio de la reserva: ");
        vector[indice-1].setIdSsocio(id);
        vector[indice-1].getHora();
        
    }
    @Override
    public String toString() {
        return "ClaseGrupal{" + "nombreClase=" + nombreClase + ", hora=" + hora + ", idSsocio=" + idSsocio + ", cupoMax=" + cupoMax + ", cupoActual=" + cupoActual + ", estado=" + estado + '}';
    }

    public ClaseGrupal(String nombreClase, String hora, String idSsocio, int cupoMax, int cupoActual, boolean estado) {
        this.nombreClase = nombreClase;
        this.hora = hora;
        this.idSsocio = idSsocio;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
        this.estado = estado;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdSsocio() {
        return idSsocio;
    }

    public void setIdSsocio(String idSsocio) {
        this.idSsocio = idSsocio;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public int getCupoActual() {
        return cupoActual;
    }

    public void setCupoActual(int cupoActual) {
        this.cupoActual = cupoActual;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    
    
    
}



            
    



    





 


  
    
    
    
    
    
    
    
    
    
    
    
    
    




    
    
   
       