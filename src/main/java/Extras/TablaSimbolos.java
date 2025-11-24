/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import com.ittepic.literaciones.Custom.Simbolo;
import java.util.HashMap;
import java.util.LinkedHashMap; // Usamos LinkedHashMap para mantener el orden de inserción
import java.util.Map;
/**
 *
 * @author jaime
 */
public class TablaSimbolos {
  // Un mapa para almacenar los símbolos. La clave es el nombre del símbolo (String).
    private final Map<String, Simbolo> tabla;

    public TablaSimbolos() {
        this.tabla = new HashMap<>();
    }

    // Método para agregar un nuevo símbolo.
    // Devuelve true si se pudo agregar, false si ya existía.
    public boolean agregar(Simbolo simbolo) {
       /* if (tabla.containsKey(simbolo.getNombre())) {
            // Error: El símbolo ya fue declarado.
            return false;
        }
        tabla.put(simbolo.getNombre(), simbolo);
*/
        return true;
    }

    // Método para buscar un símbolo por su nombre.
    // Devuelve el objeto Simbolo si lo encuentra, o null si no existe.
    public Simbolo buscar(String nombre) {
        return tabla.get(nombre);
    }

    // Para obtener todos los símbolos y mostrarlos en la GUI
    public Map<String, Simbolo> getTabla() {
        return tabla;
    }
    
    // Método para imprimir en consola (muy útil para depurar)
    public void imprimir() {
        System.out.println("--- Contenido de la Tabla de Simbolos ---");
        for (Simbolo s : tabla.values()) {
           // System.out.println(s.getNombre());
        }
        System.out.println("-----------------------------------------");
    }
}
