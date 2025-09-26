package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private static Empresa empresa;
    private String nombre,nit;
    private List<Persona> listPersonas;

    private Empresa(){
        this.nombre="Same-Day";
        this.nit="12345";
        this.listPersonas=new ArrayList<Persona>();
    }

    public static Empresa getInstance(){
        if(empresa==null){
            empresa = new Empresa();
        }
        return empresa;
    }

    public void agregarPersona(Persona persona){
        this.listPersonas.add(persona);
    }

    public Persona getUsuario(String correo){
        for(Persona persona:this.listPersonas){
            if (persona.getClass() == Usuario.class){
                if (((Usuario) persona).getCorreo().equals(correo)){
                    return persona;
                }
            }
        }
        return null;
    }

    public Persona getRepartidor(String documento){
        for(Persona persona:this.listPersonas){
            if (persona.getClass() == Repartidor.class){
                if (((Repartidor) persona).getDocumento().equals(documento)){
                    return persona;
                }
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

}
