/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uapt;

/**
 *
 * @author Mar
 */
public class NodoLlamadaFuncion extends Nodo
{

    String nombre;

    public NodoLlamadaFuncion(String nombre)
    {
        this.nombre = nombre;
    }
    
    @Override
    public void ejecutar()
    {
        NodoFuncion funcion = Memoria.obtenerFuncion(nombre);
        if(funcion == null){
            throw new RuntimeException("Funcion no definida: " + nombre);
        }
        funcion.ejecutarCuerpo();
    }
    
}
