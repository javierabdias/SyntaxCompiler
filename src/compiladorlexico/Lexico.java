package compiladorlexico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author abdias
 */
public class Lexico {

    public FileReader f;
    int fila = 0, columna;
    private boolean program = false;

    private List<Variables> identificadores = new ArrayList<>();

    public Lexico(FileReader archivo) throws IOException {
        this.f = archivo;
        lectura();
    }

    private void lectura() throws FileNotFoundException, IOException {

        String cadena;
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            tokens(cadena);
            fila++;
        }
        b.close();
    }

    private void tokens(String cadena) {
        final StringTokenizer st = new StringTokenizer(cadena);
        columna = 1;
        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();

            if (palabra.equals("program")) {
                program = true;
            }

            if (program) {
                boolean matched = false;
                for (Tipo tipo : Tipo.values()) {
                    Pattern patron = Pattern.compile(tipo.token);
                    Matcher matcher = patron.matcher(palabra);

                    if (matcher.find()) {
                        switch (tipo) {
                            
                            case TIPO_DATO:
                                String identificador = st.nextToken();
                                identificadores.add(new Variables(identificador, palabra));
                                break;
                       
                        }
                        matched = true;
                    }
                }

                if (!matched) {                    
                    while (st.hasMoreTokens()){
                    if(validarVariable(palabra)!=null){
                                          
                        switch(validarVariable(palabra).getTipo()){
                            
                            case "word":
                                break;
                            
                            case "num":
                                break;
                                
                            case "char":
                                break;
                                    
                            case "bool":                                    
                                String operador = st.nextToken();
                                if(st.hasMoreTokens()){
                                    boolValidacion(operador, st.nextToken());
                                } else {
                                    error("error", "Sintaxis", "Operación no permitida");
                                }                                
                                break;
                        }
                    } else {
                        error(palabra, "Léxico" ,"Palabra no encontrada, verifique.");
                    }
                }
                
                }
            } else {
                error(palabra, "Sintáctico" ,"El programa no ha sido definido previamente.");
            }
            columna++;
        }
    }

    private void error(String palabra, String tipo, String comentario) {
        System.out.println("Columna\tFila\tPalabra\tTipo\tComentario");
        System.err.println(columna+"\t"+ fila +"\t"+ palabra +"\t"+ tipo +"\t"+ comentario);
        System.exit(0);
    }
    
    private Variables validarVariable(String palabra){
    
        for (Variables v : identificadores) {
            if(v.getNombre().equals(palabra)){
                return v;
            }
        }
        return null;
    }
    
    private void boolValidacion(String operador, String siguiente){
        switch(operador){
            case "=":
                if (validarVariable(siguiente) != null ){    
                    if (!validarVariable(siguiente).getTipo().equals("bool")){
                        error(siguiente, "Sintaxis", "Tipo de datos incompatibles");
                    }
                } 
                else {
                    if(!siguiente.equals("true") || !siguiente.equals("false")){ 
                        error(siguiente, "Sintaxis", "Tipo de datos incompatibles");
                    }
                }
                break;
            default : error("error", "Sintaxis", "Operación no permitida");
        }
    }
    
    
}
                