/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrerahilos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author patriciaaguayo
 */
public class Carrera extends Thread{
    
    private JLabel eti; // Personaje
    private JProgressBar barraProgreso; // Barra de progreso
    private InterfazCarrera mapa; // Referencia a la interfaz principal
    private String nombrePersonaje; // Nombre del personaje
    
    public Carrera (JLabel eti, JProgressBar barraProgreso, InterfazCarrera mapa, String nombrePersonaje){
        
        this.eti = eti;
        this.barraProgreso = barraProgreso;
        this.mapa = mapa;
        this.nombrePersonaje = nombrePersonaje;
    }
    
    public void run(){
        
        int p1 = 0, p2 = 0, p3 = 0 , p4 = 0;
        
        while(true){
           
            try{
               
                sleep((int)(Math.random()*80 ));
                
                p1 = mapa.getSonic().getLocation().x;
                p2 = mapa.getDonkey().getLocation().x;
                p3 = mapa.getFantasma().getLocation().x;
                p4 = mapa.getToad().getLocation().x;
                
                if(p1<mapa.getMeta().getLocation().x - 10 && p2<mapa.getMeta().getLocation().x - 10 && p3<mapa.getMeta().getLocation().x - 10 && p4<mapa.getMeta().getLocation().x - 10){
                    
                    eti.setLocation(eti.getLocation().x+ (int)(Math.random()*5 ), eti.getLocation().y);
                    actualizarBarraProgreso();
                    mapa.repaint();
                    
                    actualizarBarraProgreso();
                    
                }else{
                    break;
                }
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            
            if(eti.getLocation().x >= mapa.getMeta().getLocation().x - 10){
                
                 // Obtener las distancias recorridas por cada personaje
                 
                int MetrosSonic = mapa.getSonic().getLocation().x;
                int MetrosDonkey = mapa.getDonkey().getLocation().x;
                int MetrosFantasma = mapa.getFantasma().getLocation().x;
                int MetrosToad = mapa.getToad().getLocation().x;

                // Determinar el máximo recorrido
                
                int maxDistancia = Math.max(Math.max(MetrosSonic, MetrosDonkey), Math.max(MetrosFantasma, MetrosToad));

                // Verificar qué personajes tienen la distancia máxima
                
                boolean sonicGana = MetrosSonic == maxDistancia;
                boolean donkeyGana = MetrosDonkey == maxDistancia;
                boolean fantasmaGana = MetrosFantasma == maxDistancia;
                boolean toadGana = MetrosToad == maxDistancia;

                // Construir el mensaje del ganador o empate
                
                StringBuilder mensajeGanador = new StringBuilder();
                
                if (sonicGana) {
                    mensajeGanador.append("Sonic");
                }
                
                if (donkeyGana) {
                    if (mensajeGanador.length() > 0) mensajeGanador.append(" y ");
                    mensajeGanador.append("Donkey Kong");
                }
                
                if (fantasmaGana) {
                    if (mensajeGanador.length() > 0) mensajeGanador.append(" y ");
                    mensajeGanador.append("Fantasma");
                }
                
                if (toadGana) {
                    if (mensajeGanador.length() > 0) mensajeGanador.append(" y ");
                    mensajeGanador.append("Toad");
                }

                // Mostrar mensaje de ganador o empate
                
                if (mensajeGanador.toString().contains(" y ")) {
                    JOptionPane.showMessageDialog(null, "¡Empate entre " + mensajeGanador + "!");
               
                } else {
                    JOptionPane.showMessageDialog(null, "¡Ha ganado " + mensajeGanador + "!");
                }

                // Mostrar las distancias recorridas
                
                JOptionPane.showMessageDialog(null, 
                    " Sonic ha recorrido " + MetrosSonic + " m\n" +
                    " Donkey Kong ha recorrido " + MetrosDonkey + " m\n" +
                    " Fantasma ha recorrido " + MetrosFantasma + " m\n" +
                    " Toad ha recorrido " + MetrosToad + " m");
                
            }
        }
        
        // Notifica que ha terminado la carrera
        
        mapa.notificarHiloTerminado();
    }
    
    private void actualizarBarraProgreso() {
        
        int posicionActual = eti.getLocation().x; // Distancia recorrida por el personaje
 
        int posicionMeta = mapa.getMeta().getLocation().x; // Posición máxima (meta)

        int progreso = (int) ((double) posicionActual / posicionMeta * 100); // Calcular el porcentaje de avance

        // Actualizar la barra de progreso
        
        barraProgreso.setValue(Math.min(progreso, 100)); // No superar el 100%
        
        // Mostrar el porcentaje como texto en la barra
        
        barraProgreso.setString(nombrePersonaje + ": " + progreso + "%");
    }
    
}
