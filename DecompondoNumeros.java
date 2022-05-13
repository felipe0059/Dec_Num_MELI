import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

      /*
      * Complete a seguinte função para que ela retorne todos os números
      * de 4 dígitos, onde cada um é menor ou igual a <maxDigit>
      * e a soma dos digitos resulte em 21.
      * Exemplos com maxDigit=6: 3666, 4566
      *
      * Se nenhum for encontrado, o retorno é null.
      */
            
        public static List<Integer> calculation(int maxDigit) {
        List<Integer> sequencia = new ArrayList<>();
        
        
        for (int i = 1000; i < 10000; i++) {
            String string = String.valueOf(i);
            String nova_string = "";
            int soma_dos_digitos = 0;

            for (Character numero : string.toCharArray()) { //Copia os caracteres nesta instância para uma matriz de caracteres Unicode.

                int digito = Integer.parseInt(numero.toString()); //O método toString() retorna a representação String.
                
                if (digito > maxDigit) {
                    nova_string += maxDigit;
                    soma_dos_digitos += maxDigit;
                } else {
                    nova_string += digito;
                    soma_dos_digitos += digito;
                }
            }

            int num = Integer.parseInt(nova_string);

            if (soma_dos_digitos == 21 && !(sequencia.contains(num))) {
                sequencia.add(num);
            }
        }

        if (sequencia.size() > 0) {
            return sequencia;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {

        System.out.println(calculation(8));

    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int maxDigit = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.calculation(maxDigit);

        if(result != null){
            for (int i = 0; i < result.size(); i++) {
                if(i > 0){
                    bufferedWriter.newLine();
                }
                bufferedWriter.write(String.valueOf(result.get(i)));
            }            
        }else{
            bufferedWriter.write("null");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
