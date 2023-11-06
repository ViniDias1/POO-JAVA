import java.util.Scanner;

public class revisao{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String strg = entrada.next();
        String[] strgLista = new String[100];
    
        while (strg.equals("F") == false){
            

            for (int i = 0;i<strg.length();i++){
                strgLista[i] = strg.substring(i,i+1);
            }

            strg = entrada.next();



        }
        entrada.close();


    }
}
