package uapt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mar
 */
public class Lexer
{

    private String input;
    private int pos = 0;
    private List<Token> tokens = new ArrayList<>();

    public Lexer(String input)
    {
        this.input = input;
    }

    public List<Token> tokenizar()
    {
        while (pos < input.length())
        {
            char actual = input.charAt(pos);

            if (Character.isWhitespace(actual))
            {
                pos++;
            } else if (Character.isDigit(actual))
            {
                tokens.add(numero());
            } else if (Character.isLetter(actual))
            {
                tokens.add(identificador());
            } else
            {
                switch (actual)
                {
                    case '=':
                        tokens.add(new Token("ASIGNACION", "="));
                        break;
                    case '+':
                        tokens.add(new Token("MAS", "+"));
                        break;
                    case '>':
                        tokens.add(new Token("MAYOR", ">"));
                        break;
                    case '(':
                        tokens.add(new Token("PARENA", "("));
                        break;
                    case ')':
                        tokens.add(new Token("PARENC", ")"));
                        break;
                    case '{':
                        tokens.add(new Token("LLAVEA", "{"));
                        break;
                    case '}':
                        tokens.add(new Token("LLAVEC", "}"));
                        break;
                    case ';':
                        tokens.add(new Token("PUNTOYCOMA", ";"));
                        break;
                    default:
                        throw new RuntimeException("Caracter inesperado: " + actual);
                }
                pos++;
            }
        }
        return tokens;
    }

    private Token numero()
    {
        StringBuilder sb = new StringBuilder();

        while (pos < input.length() && Character.isDigit(input.charAt(pos)))
        {
            sb.append(input.charAt(pos++));
        }

        return new Token("NUMERO", sb.toString());
    }

    private Token identificador()
    {
        StringBuilder sb = new StringBuilder();
        while (pos < input.length() && Character.isLetterOrDigit(input.charAt(pos)))
        {
            sb.append(input.charAt(pos++));
        }
        String palabra = sb.toString();
        if (palabra.equals("int"))
        {
            return new Token("INT", palabra);
        }
        if (palabra.equals("if"))
        {
            return new Token("IF", palabra);
        }
        return new Token("ID", palabra);
    }
}
