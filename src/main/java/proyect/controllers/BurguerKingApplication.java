package proyect.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import proyect.views.PantallaInicio;

@SpringBootApplication
public class BurguerKingApplication {

	public static void main(String[] args) {
		PantallaInicio pantallaInicio = new PantallaInicio();
		pantallaInicio.setLocationRelativeTo(null);
		pantallaInicio.setVisible(true);
	}

}
