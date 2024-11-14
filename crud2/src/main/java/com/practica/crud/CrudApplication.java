package com.practica.crud;

import com.practica.crud.Service.UsuarioServicios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class CrudApplication {
    static {
		UsuarioServicios.deserializar();
	}
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
