package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    private static Empresa empresa;
    private String nombre,nit;
    private List<Persona> listPersonas;
    private List<Administrador> listAdministradores ;

    private Empresa(){
        this.nombre="Same-Day";
        this.nit="12345";
        this.listPersonas=new ArrayList<>();
        this.listAdministradores=new ArrayList<>();
    }

    public static Empresa getInstance(){
        if(empresa==null){
            empresa = new Empresa();
        }
        return empresa;
    }

    public void agregarAdministrador(Administrador administrador){
        this.listAdministradores.add(administrador);
    }

    public Administrador getAministrador(String documento){
        for(Administrador admin:this.listAdministradores){
            if ( admin.getDocumento().equals(documento)){
                return admin;
            }
        }
        return null;
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

    public Map<String,String> iniciarSesion(String tipo, String user, String contrasena){
        Map<String,String> resp=new HashMap<>();
        switch (tipo) {
            case "Administrador" -> {
                if (getAministrador(user) != null && getAministrador(user).getContrasena().equals(Hash.hashearSHA256(contrasena))) {
                    resp.put("message","Login exitoso");
                    resp.put("user", getAministrador(user).getDocumento());
                    resp.put("name", getAministrador(user).getNombre());
                    return resp;
                }
                resp.put("message","Usuario o contraseña incorrecto");
                return resp;
            }
            case "Usuario" -> {
                Usuario user1 = (Usuario)(getUsuario(user));
                if ( user1!=null && user1.getContrasena().equals(Hash.hashearSHA256(contrasena))) {
                    resp.put("message","Login exitoso");
                    resp.put("user", user1.getCorreo());
                    resp.put("name", user1.getNombre());
                    return resp;
                }
                resp.put("message","Usuario o contraseña incorrecto");
                return resp;
            }
            case "Repartidor" -> {
                Repartidor rep = (Repartidor)(getRepartidor(user));
                if (rep!= null && rep.getContrasena().equals(Hash.hashearSHA256(contrasena))) {
                    resp.put("message","Login exitoso");
                    resp.put("user", rep.getDocumento());
                    resp.put("name", rep.getNombre());
                    return resp;
                }
                resp.put("message","Usuario o contraseña incorrecto");
                return resp;
            }
        }

        resp.put("message","Usuario o contraseña incorrecto");
        return resp;

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

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }
}
