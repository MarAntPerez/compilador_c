/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            int valor = Integer.parseInt(tokens.get(pos++).valor);
            pos++;
            return new NodoAsignacion(id, valor);
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
        }
        throw new RuntimeException("Instruccion no reconocida: " + tok);
    }

}
