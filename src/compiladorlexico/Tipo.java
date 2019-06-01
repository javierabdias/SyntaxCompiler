package compiladorlexico;


public enum Tipo {
    LINEA("[$]$"),
    PALABRA_RESERVADA("(if|then|endif|loop|endloop|else|write|read)$"),
    TIPO_DATO("(num|word|bool|char|program)$"),
    INICIO("(begin)$"),
    FIN("(end)$"),
    EXPRESION("(^[(])(.*)([)]$)"),
    NUM("^\\d+$"),
    OPERADOR_ARITMETICO("[=|+|-|*|/]"),
    BOOL("(true|false)"),
    STRING("(^[<])(.*)([>]$)");


    public final String token;

    Tipo(String s) {
        this.token = s;
    }


}
