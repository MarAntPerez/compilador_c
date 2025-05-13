package uapt;

import java.util.List;

/**
 *
 * @author Mar
 */
public class NodoWhile extends Nodo
{

    String id;
    int comparador;
    List<Nodo> cuerpo;

    public NodoWhile(String id, int comparador, List<Nodo> cuerpo)
    {
        this.id = id;
        this.comparador = comparador;
        this.cuerpo = cuerpo;
    }

    @Override
    public void ejecutar()
    {
        while (Memoria.get(id) < comparador)
        {
            for (Nodo n : cuerpo)
            {
                n.ejecutar();
            }
        }
    }

}
