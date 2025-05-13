package uapt;

import java.util.List;

/**
 *
 * @author Mar
 */
public class NodoFor extends Nodo
{

    Nodo inicializacion;
    String idCond;
    int comparador;
    Nodo incremento;
    List<Nodo> cuerpo;

    public NodoFor(Nodo inicializacion, String idCond, int comparador, Nodo incremento, List<Nodo> cuerpo)
    {
        this.inicializacion = inicializacion;
        this.idCond = idCond;
        this.comparador = comparador;
        this.incremento = incremento;
        this.cuerpo = cuerpo;
    }

    @Override
    public void ejecutar()
    {
        inicializacion.ejecutar();
        while (Memoria.get(idCond) < comparador)
        {
            for (Nodo n : cuerpo)
            {
                n.ejecutar();
            }
            incremento.ejecutar();
        }
    }

}
