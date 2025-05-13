package uapt;

/**
 *
 * @author Mar
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String codigoFuente = "int x = 5; if (x > 3) { x = x + 1; }";
        Lexer lexer = new Lexer(codigoFuente);

        Parser parser = new Parser(lexer.tokenizar());
        Nodo programa = parser.parserProgram();

        programa.ejecutar();
    }

}
