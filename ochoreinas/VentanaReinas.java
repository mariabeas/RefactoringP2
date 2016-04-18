package ochoreinas;

//Eight Reinas puzzle written in Java
//Written by Tim Budd, January 1996
//revised for 1.3 event model July 2001
//

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

import javax.swing.*;

@SuppressWarnings("serial")
public class VentanaReinas extends Frame implements Serializable {
	transient Reina ultimaReina = null;
	
	public VentanaReinas() {
	    setTitle("Problema de las ocho reinas");
	    setSize(600, 500);
	    for (int i = 1; i <= 8; i++) {
	        ultimaReina = new Reina(i, ultimaReina);
	        ultimaReina.buscaSolucion();
	        }
	    addMouseListener(new MouseKeeper());
	    addWindowListener(new CloseQuit());
	    }
public static void main(String [ ] args) {
    VentanaReinas world = new VentanaReinas();
    world.show();
}

 


@Override
public void paint(Graphics g) {
    super.paint(g);
        // dibuja el tablero
    for (int i = 0; i <= 8; i++) {
        g.drawLine(50 * i + 10, 40, 50*i + 10, 440);
        g.drawLine(10, 50 * i + 40, 410, 50*i + 40);
    }
    g.drawString("Pulse con para una nueva soluci�n", 20, 470);
        // draw queens
    ultimaReina.paint(g);
    }

private class CloseQuit extends WindowAdapter {
	@Override
    public void windowClosing (WindowEvent e) {
		
		throw new UnsupportedOperationException();
		
    }

	
}

private class MouseKeeper extends MouseAdapter {
	@Override
    public void mousePressed (MouseEvent e) {
        ultimaReina.avanza();
        repaint();
    }
}
}

