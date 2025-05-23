/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uapt;

/**
 *
 * @author Mar
 */
public class NodoAsignacion extends Nodo
{
    
    String id;
    Nodo expresion;

    public NodoAsignacion(String id, Nodo expresion)
    {
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public void ejecutar()
    {
        Memoria.set(id, ((NodoExpresion) expresion).evaluar());
    }
    
}
