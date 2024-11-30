# Proyecto Carrera de Personajes

## Descripción
Este proyecto simula una carrera entre varios personajes, representados gráficamente en una interfaz gráfica de usuario (GUI) con barras de progreso. 
Los personajes avanzan de manera aleatoria, y el objetivo es que uno de ellos alcance la meta antes que los demás.

## Configuraciones

### Modificar la distancia de la carrera (meta)
- La meta está representada por el objeto `JLabel` llamado **`Meta`** en la interfaz gráfica.  
- Este objeto es **transparente**, pero define el final del recorrido.  
- Para cambiar la distancia de la carrera, mueve esta etiqueta en la GUI al lugar deseado. Esto ajustará automáticamente la distancia que deben recorrer los personajes.

### Modificar la velocidad de los personajes

1. **Frecuencia de ejecución:**  

   En la clase **`Carrera`**, dentro del método donde se maneja el avance de los personajes, se encuentra la línea: sleep((int)(Math.random() * 80));

   - Este fragmento define el tiempo que el hilo se "pausa" antes de volver a ejecutar, simulando la frecuencia con la que los personajes avanzan.
   - Cambia el valor del multiplicador 80 para modificar esta frecuencia:
       - Un número menor hará que los personajes avancen más rápido.
       - Un número mayor hará que los personajes avancen más lento.
         
2. **Cantidad de avance por iteración:**

También en la clase Carrera, se encuentra la línea: eti.setLocation(eti.getLocation().x + (int)(Math.random() * 5), eti.getLocation().y);

   - Esta línea determina cuánto avanzará un personaje en cada iteración del hilo.
   - Cambia el valor del multiplicador 5 para ajustar este avance:
       - Un valor mayor hará que los personajes den pasos más largos.
       - Un valor menor reducirá la distancia recorrida por iteración, ralentizando su progreso.
         
3. **Relación entre la posición y las barras de progreso:**

El progreso visual de los personajes se representa mediante barras de progreso, actualizadas con el método: actualizarBarraProgreso();
Este método calcula el porcentaje de avance de cada personaje en función de su posición actual y la distancia hasta la meta.
Así, el progreso se calcula como un porcentaje que se refleja en las barras de progreso.
