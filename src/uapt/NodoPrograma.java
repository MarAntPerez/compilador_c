/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uapt;

import java.util.List;

/**
 *
 * @author Mar
 */
public class NodoPrograma extends Nodo
{
    List<Nodo> instruccines;

    public NodoPrograma(List<Nodo> instruccines)
    {
        this.instruccines = instruccines;
    }

    @Override
    public void ejecutar()
    {
        for(Nodo nodo: instruccines){
            nodo.ejecutar();
        }
    }
}
