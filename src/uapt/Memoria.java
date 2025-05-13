/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uapt;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mar
 */
class Memoria
{
    private static Map<String, Integer> tabla = new HashMap<>();
    
    public static void set(String id, int valor){
        tabla.put(id, valor);
    }
    
    public static int get(String id){
        return tabla.getOrDefault(id, 0);
    }
    
    public static void imprimir(){
        System.out.println(tabla);
    }
}
