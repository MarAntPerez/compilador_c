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
        String codigoFuente = "void saludo() { int x = 1; } saludo(); int i = 0; for (i = 0; i < 2; i = i + 1) { int z = i; }";
        Lexer lexer = new Lexer(codigoFuente);

        Parser parser = new Parser(lexer.tokenizar());
        Nodo programa = parser.parserProgram();

        programa.ejecutar(); // Interpreta directamente el AST (modo intérprete)
        Memoria.imprimir();

    }

}
