package uapt;

import java.util.List;

/**
 *
 * @author Mar
 */
public class NodoFuncion extends Nodo
{

    String nombre;
    List<Nodo> cuerpo;

    public NodoFuncion(String nombre, List<Nodo> cuerpo)
    {
        this.nombre = nombre;
        this.cuerpo = cuerpo;
    }

    @Override
    public void ejecutar()
    {
        Memoria.registrarFuncion(nombre, this);
    }

    public void ejecutarCuerpo()
    {
        for (Nodo nodo : cuerpo)
        {
            nodo.ejecutar();
        }
    }

}
