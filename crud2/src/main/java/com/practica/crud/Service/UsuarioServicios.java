package com.practica.crud.Service;

import com.practica.crud.Model.Usuarios;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServicios {
    private static ArrayList<Usuarios> users = new ArrayList<>();
    private static long nextId = 1L; // Inicializamos nextId

    public static void serializar() {
        try (FileOutputStream archivo = new FileOutputStream("personas.bin");
             ObjectOutputStream salida = new ObjectOutputStream(archivo)) {

            salida.writeObject(users);
            salida.writeLong(nextId); // Serializamos nextId
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción para obtener detalles
        }
    }

    public static void deserializar() {
        try (FileInputStream archivo = new FileInputStream("personas.bin");
             ObjectInputStream entrada = new ObjectInputStream(archivo)) {

            users = (ArrayList<Usuarios>) entrada.readObject();
            nextId = entrada.readLong(); // Deserializamos nextId
        } catch (IOException e) {
            System.out.println("No hay datos para cargar o ocurrió un error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }
    }

    public ArrayList<Usuarios> getUser() {
        return users;
    }

    public Optional<Usuarios> getUserById(Long id) {
        return users.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Usuarios createUser(Usuarios user) {
        user.setId(nextId++);
        users.add(user);
        serializar();
        return user;
    }

    public Optional<Usuarios> updateUser(Long id, Usuarios user) {
        Optional<Usuarios> query = this.getUserById(id);
        if (query.isEmpty()) {
            return query;
        }
        Usuarios existente = query.get();
        existente.setNombre(user.getNombre());
        existente.setApellido(user.getApellido());
        existente.setEdad(user.getEdad());
        serializar();
        return query;
    }

    public boolean deleteuser(Long id) {
        boolean eliminado = users.removeIf(e -> e.getId().equals(id));
        if (eliminado) {
            serializar();
        }
        return eliminado;
    }
}
