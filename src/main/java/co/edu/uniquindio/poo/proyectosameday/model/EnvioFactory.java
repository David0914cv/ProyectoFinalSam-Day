package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;

public class EnvioFactory {
    public static EnvioComponent newInstance(String type,String cityOrigin,String cityDestination,String addressOrigin,String addressDestination,EstadoEnvio statusShipping,double price,LocalDateTime deliveryDate,Usuario usuario){

        Envio envio = new Envio(cityOrigin, cityDestination, addressOrigin, addressDestination, statusShipping, price, LocalDateTime.now(), deliveryDate,usuario);

        if (type.equalsIgnoreCase("prioritario")){
            return new EnvioEntregaPrioritaria(envio);
        }else if (type.equalsIgnoreCase("seguro")){
            return  new EnvioSeguro(envio);
        }else if (type.equalsIgnoreCase("normal")){
            return envio;
        }else{
            throw new IllegalArgumentException("Tipo de envio no valido");
        }

    }
}
