package co.edu.uniquindio.poo.proyectosameday.model.dtos;

public class PersonaDTO {
    private String id, name,rol;

    public PersonaDTO(String id, String name,String rol) {
        this.id = id;
        this.name = name;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
