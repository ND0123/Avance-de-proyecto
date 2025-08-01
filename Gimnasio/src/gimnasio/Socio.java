/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

/**
 *
 * @author XPC
 */
public class Socio {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getClasesGrupal() {
        return clasesGrupal;
    }

    public void setClasesGrupal(String clasesGrupal) {
        this.clasesGrupal = clasesGrupal;
    }

    private String id;
    private String nombre;
    private boolean activo;
    private String clasesGrupal;

    
    public Socio(String id, String nombre, boolean activo, String clasesGrupal) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.clasesGrupal = clasesGrupal;
    }
    

    
    
}
