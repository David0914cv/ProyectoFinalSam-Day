package co.edu.uniquindio.poo.proyectosameday.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String hashear(String input) {
        try {
            // Crear el objeto MessageDigest con SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Aplicar hash al texto (UTF-8 para evitar problemas de codificación)
            byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convertir el resultado a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: algoritmo no soportado", e);
        }
    }
}
