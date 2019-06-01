package compiladorlexico;

import java.util.ArrayList;
import java.util.List;

public class tabla {

    private static List <Token> errores = new ArrayList<>();

    private tabla (){}

    public static List<Token> getErrores() {
        return errores;
    }

    public static void agregar(int columna, int fila, String nomToken, String tipo, String log){
        Token token = new Token(columna, fila, nomToken, tipo, log);
        errores.add(token);
    }


    public static void imprimir(){
        System.out.println("Columna\tFila\tPalabra\tTipo\tComentario");
        for(Token token : errores){
            System.err.println("|"+token.getColumna()+"|\t|"+token.getLínea()+"|\t|"+token.getNomToken()+
                    "|\t|"+token.getTipo()+"|\t|"+token.getLog()+"|");
        }
    }

}
