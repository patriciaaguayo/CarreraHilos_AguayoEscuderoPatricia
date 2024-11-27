/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrerahilos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author patriciaaguayo
 */
public class Carrera extends Thread{
    
    private JLabel eti;
    private InterfazCarrera mapa;
    
    public Carrera (JLabel eti, InterfazCarrera mapa){
        
        this.eti = eti;
        this.mapa = mapa;
    }
    
    public void run(){
        
        int p1 = 0, p2 = 0, p3 = 0 , p4 = 0;
        
        while(true){
           
            try{
               
                sleep((int)(Math.random()*500 ));
                
                p1 = mapa.getSonic().getLocation().x;
                p2 = mapa.getDonkey().getLocation().x;
                p3 = mapa.getFantasma().getLocation().x;
                p4 = mapa.getToad().getLocation().x;
                
                if(p1<mapa.getMeta().getLocation().x - 10 && p2<mapa.getMeta().getLocation().x - 10 && p3<mapa.getMeta().getLocation().x - 10 && p4<mapa.getMeta().getLocation().x - 10){
                    
                    eti.setLocation(eti.getLocation().x+5, eti.getLocation().y);
                    mapa.repaint();
                    
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
    
}
