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
    int valor;

    public NodoAsignacion(String id, int valor)
    {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public void ejecutar()
    {
        Memoria.set(id, valor);
    }
    
}
