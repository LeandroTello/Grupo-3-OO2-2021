package com.TPOO2.funciones;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Funciones {

	public static String encriptarPass(String pass) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(pass);
	}
}
