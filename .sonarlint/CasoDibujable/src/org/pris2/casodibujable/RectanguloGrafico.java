package org.pris2.casodibujable;

import java.awt.Graphics;
import java.awt.Color;

class RectanguloGrafico extends Rectangulo implements Dibujable {
	// nueva variable miembro
	Color color;

	// constructor
	public RectanguloGrafico(double x1, double y1, double x2, double y2, Color unColor) {
		// llamada al constructor de Rectangulo
		super(x1, y1, x2, y2);
		this.color = unColor; // en este caso this es opcional
	}

	// métodos de la interface Dibujable
	@Override
	public void dibujar(Graphics dw) {
		dw.setColor(color);
		dw.drawRect((int) x1, (int) y1, (int) (x2 - x1), (int) (y2 - y1));
	}

	@Override
	public void setPosicion(double x, double y) {
		; // método vacío, pero necesario de definir
	}
} // fin de la clase RectanguloGrafico