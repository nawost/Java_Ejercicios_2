package ejerciciosnivel2;
/**
 *
 * @author Joan Marí
 */
public class EjerciciosNivel2 {

    public boolean esEscaleraPalabras(char[][] listaPalabras){
        for (int i=0; i<listaPalabras.length-1; i++){
            int contador = 0;
            for (int j=0; j<listaPalabras[0].length; j++){
                if (listaPalabras[i][j] != listaPalabras[i+1][j]){
                    contador++;
                }
            }
            if (contador != 1){ //si es distinto de uno es porque se diferencian en mas de un caracter
                return false;
            }
        }
        return true;
    }
    
    private int costeErroresADN (String uno, String dos){
        int coste = 0;
        for (int i=0; i<uno.length(); i++){
            if (uno.charAt(i) == '-' || dos.charAt(i) == '-'){coste +=2;}
            else{
            if (uno.charAt(i) == 'C' && dos.charAt(i) != 'G'){coste++;}
            if (uno.charAt(i) == 'G' && dos.charAt(i) != 'C'){coste++;}
            if (uno.charAt(i) == 'A' && dos.charAt(i) != 'T'){coste++;}
            if (uno.charAt(i) == 'T' && dos.charAt(i) != 'A'){coste++;}
            }
        }
        
        return coste;
    }
    
    private int subcadenaDeStrings (String str1, String str2){
        int posicion = -1;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(0)){
                posicion = i;
                int j = 0;
                while (j < str2.length() && i < str1.length() && str1.charAt(i) == str2.charAt(j)){
                    j++;
                    i++;
                }
                if (j == str2.length()){//ha encontrado la palabra 2 en la palabra 1
                    return posicion;
                }
                if (i == str1.length()){//se ha terminado la palabra 1 y no se ha encontrado la palabra 2
                    return -1;
                }
                //si llega aqui es porque la palabra 1 es distinto a la palabra dos
                i = posicion;
                posicion = -1;
            }
        }
        return posicion;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char [][] listaPalabras = {
            {'P', 'A', 'T', 'A'}, 
            {'P', 'A', 'T', 'O'}, 
            {'R', 'A', 'T', 'O'}, 
            {'R', 'A', 'M', 'O'}, 
            {'G', 'A', 'M', 'O'}, 
            {'G', 'A', 'T', 'O'}, 
            {'M', 'A', 'T', 'O'}, 
        };
        EjerciciosNivel2 e = new EjerciciosNivel2();
        //Ejercicio 1
        System.out.println(e.esEscaleraPalabras(listaPalabras));
        //Ejercicio 2
        System.out.println(e.costeErroresADN("ACGT", "TGCA"));
        System.out.println(e.costeErroresADN("A-C-G-T-ACGT", "TTGGCCAATGCA"));
        System.out.println(e.costeErroresADN("AAAAAAAA", "TTTATTTT"));
        System.out.println(e.costeErroresADN("GATTACA", "CTATT-T"));
        System.out.println(e.costeErroresADN("CAT-TAG-ACT", "GTATATCCAAA"));
        System.out.println(e.costeErroresADN("--------", "ACGTACGT"));
        System.out.println(e.costeErroresADN("TAATAA", "ATTATT"));
        System.out.println(e.costeErroresADN("GGGA-GAATATCTGGACT", "CCCTACTTA-AGACCGGT"));
        //Ejercicio 3
        System.out.println(e.subcadenaDeStrings("HOLA MUNDO", "MU"));
        System.out.println(e.subcadenaDeStrings("HOLA MUNDO", "ME"));
        System.out.println(e.subcadenaDeStrings("HOLA MUNDO", "DO"));
    }
    
}
