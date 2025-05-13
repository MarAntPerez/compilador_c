package uapt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mar
 */
public class Parser
{

    private List<Token> tokens;
    private int pos;

    public Parser(List<Token> tokens)
    {
        this.tokens = tokens;
    }

    public Nodo parserProgram()
    {
        List<Nodo> instrucciones = new ArrayList<>();
        while (pos < tokens.size())
        {
            instrucciones.add(parseStatement());
        }
        return new NodoPrograma(instrucciones);
    }

    public Nodo parseStatement()
    {
        Token tok = tokens.get(pos);
        if (tok.tipo.equals("INT"))
        {
            pos++;
            String id = tokens.get(pos++).valor;
            pos++;
            Nodo valor = parseExpresion();
            pos++;
            return new NodoAsignacion(id, valor);
        } else if (tok.tipo.equals("VOID"))
        {
            pos++;
            String nombre = tokens.get(pos++).valor;
            pos++;
            pos++;
            pos++;
            List<Nodo> cuerpo = new ArrayList<>();
            while (!tokens.get(pos).tipo.equals("LLAVEC"))
            {
                cuerpo.add(parseStatement());
            }
            pos++;
            return new NodoFuncion(nombre, cuerpo);
        } else if (tok.tipo.equals("ID") && tokens.get(pos + 1).tipo.equals("PARENA"))
        {
            String nombre = tokens.get(pos++).valor;
            pos++;
            pos++;
            pos++;
            return new NodoLlamadaFuncion(nombre);
        } else if (tok.tipo.equals("IF"))
        {
            pos++;
            pos++;
            String id = tokens.get(pos++).valor;
            pos++;
            int num = Integer.parseInt(tokens.get(pos++).valor);
            pos++;
            pos++;
            List<Nodo> cuerpo = new ArrayList<>();
            while (!tokens.get(pos).tipo.equals("LLAVEC"))
            {
                cuerpo.add(parseStatement());
            }
            pos++;
            return new NodoIf(id, num, cuerpo);
        } else if (tok.tipo.equals("WHILE"))
        {
            pos++;
            pos++;
            String id = tokens.get(pos++).valor;
            pos++;
            int num = Integer.parseInt(tokens.get(pos++).valor);
            pos++;
            pos++;
            List<Nodo> cuerpo = new ArrayList<>();
            while (!tokens.get(pos).tipo.equals("LLAVEC"))
            {
                cuerpo.add(parseStatement());
            }
            pos++;
            return new NodoWhile(id, num, cuerpo);
        } else if (tok.tipo.equals("FOR"))
        {
            pos++;
            pos++;
            Nodo ini = parseStatement();
            String idCond = tokens.get(pos++).valor;
            pos++;
            int num = Integer.parseInt(tokens.get(pos++).valor);
            pos++;
            Nodo inc = parseStatement();
            pos++;
            pos++;
            List<Nodo> cuerpo = new ArrayList<>();
            while (tokens.get(pos).tipo.equals("LLAVEC"))
            {
                cuerpo.add(parseStatement());
            }
            pos++;
            return new NodoFor(ini, idCond, num, inc, cuerpo);
        } else if (tok.tipo.equals("ID") && tokens.get(pos + 1).tipo.equals("ASIGNACION"))
        {
            String id = tokens.get(pos++).valor; // ID
            pos++; // =
            Nodo valor = parseExpresion(); // usa parseExpresion para manejar cosas como x + 1
            pos++; // ;
            return new NodoAsignacion(id, valor);
        }

        throw new RuntimeException("Instruccion no reconocida: " + tok);
    }

    private Nodo parseExpresion()
    {
        Nodo izquierda = parseTermino();

        while (pos < tokens.size() && tokens.get(pos).tipo.equals("MAS"))
        {
            String operador = tokens.get(pos++).valor;
            Nodo derecha = parseTermino();
            izquierda = new NodoExpresion(izquierda, operador, derecha);
        }

        return izquierda;
    }

    private Nodo parseTermino()
    {
        Token tok = tokens.get(pos);

        if (tok.tipo.equals("NUMERO"))
        {
            pos++;
            return new NodoLiteral(Integer.parseInt(tok.valor));
        } else if (tok.tipo.equals("ID"))
        {
            pos++;
            return new NodoVariable(tok.valor);
        } else
        {
            throw new RuntimeException("Término inesperado: " + tok);
        }
    }

}
