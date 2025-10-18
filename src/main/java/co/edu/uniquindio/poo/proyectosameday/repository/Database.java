package co.edu.uniquindio.poo.proyectosameday.repository;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static  Database db;

    private List<String> listCiudades;

    private Database() {
        this.listCiudades = new ArrayList<>();

        listCiudades.add("CALARCA");
        listCiudades.add("ARMENIA");
        listCiudades.add("CIRCASIA");
        listCiudades.add("FILANDIA");
        listCiudades.add("SALENTO");
        listCiudades.add("PIJAO");
        listCiudades.add("MONTENEGRO");
        listCiudades.add("TEBAIDA");
        listCiudades.add("CORDOBA");
        listCiudades.add("QUIMBAYA");
        listCiudades.add("GENOVA");
        listCiudades.add("BUENAVISTA");
    }

    public static Database getInstance(){
        if(db == null){
            db = new Database();
        }
        return db;
    }

    public List<String> getListCiudades() {
        return listCiudades;
    }

    public void setListCiudades(List<String> listCiudades) {
        this.listCiudades = listCiudades;
    }
}
