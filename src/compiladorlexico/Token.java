package compiladorlexico;


public class Token {

    private int línea;
    private int columna;
    private String nomToken;
    private String tipo;
    private String log;

    public Token(int línea, int columna, String nomToken, String tipo, String log) {
        this.línea = línea;
        this.columna = columna;
        this.nomToken = nomToken;
        this.tipo = tipo;
        this.log = log;
    }

    public int getLínea() {
        return línea;
    }

    public void setLínea(int línea) {
        this.línea = línea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getNomToken() {
        return nomToken;
    }

    public void setNomToken(String nomToken) {
        this.nomToken = nomToken;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
