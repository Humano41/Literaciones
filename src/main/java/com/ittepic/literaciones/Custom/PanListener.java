/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

/**
 *
 * @author Humano 14
 */
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class PanListener extends MouseAdapter {
    private final Point origin = new Point();
    private final JComponent component;

    public PanListener(JComponent component) {
        this.component = component;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Solo nos interesa el botón de la rueda (botón 2)
        if (e.getButton() == MouseEvent.BUTTON2) {
            origin.setLocation(e.getPoint());
            component.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON2) {
            component.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // SwingUtilities.isMiddleMouseButton(e) es una forma robusta de comprobarlo
        if (SwingUtilities.isMiddleMouseButton(e)) {
            JViewport viewport = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, component);
            if (viewport != null) {
                int deltaX = origin.x - e.getX();
                int deltaY = origin.y - e.getY();

                Point viewPosition = viewport.getViewPosition();
                viewPosition.translate(deltaX, deltaY);

                // Asegurarse de que la nueva posición no se salga de los límites
                int newX = Math.max(0, viewPosition.x);
                int newY = Math.max(0, viewPosition.y);
                
                // Aplicamos la nueva posición a la vista del viewport
                viewport.setViewPosition(new Point(newX, newY));
            }
        }
    }
}
