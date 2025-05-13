/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uapt;

/**
 *
 * @author Mar
 */
public class NodoExpresion extends Nodo
{

    Nodo izquierda;
    String operador;
    Nodo derecha;

    public NodoExpresion(Nodo izquierda, String operador, Nodo derecha)
    {
        this.izquierda = izquierda;
        this.operador = operador;
        this.derecha = derecha;
    }

    public int evaluar()
    {
        int izq = (izquierda instanceof NodoLiteral) ? ((NodoLiteral) izquierda).valor : Memoria.get(((NodoVariable) izquierda).id);
        int der = (derecha instanceof NodoLiteral) ? ((NodoLiteral) derecha).valor : Memoria.get(((NodoVariable) derecha).id);

        return switch (operador)
        {
            case "+" ->
                izq + der;
            case "-" ->
                izq - der;
            case "*" ->
                izq * der;
            case "/" ->
                izq / der;
            default ->
                throw new RuntimeException("Operador desconocido: " + operador);
        };
    }

    @Override
    public void ejecutar()
    {
    }

}
