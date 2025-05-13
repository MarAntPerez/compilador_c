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
public class NodoIf extends Nodo
{

    String id;
    int comparador;
    List<Nodo> cuerpo;

    public NodoIf(String id, int comparador, List<Nodo> cuerpo)
    {
        this.id = id;
        this.comparador = comparador;
        this.cuerpo = cuerpo;
    }

    @Override
    public void ejecutar()
    {
        if (Memoria.get(id) > comparador)
        {
            for (Nodo n : cuerpo)
            {
                n.ejecutar();
            }
        }
    }

}
