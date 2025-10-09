package co.edu.uniquindio.poo.proyectosameday.model.dtos;

public class UsuarioDTO {
    private String id, name;

    public UsuarioDTO(String id, String name) {
        this.id = id;
        this.name = name;
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
        return "UsuarioDTO{" +
                "id='" + id + '\'' +
                ", nombre='" + name + '\'' +
                '}';
    }
}
