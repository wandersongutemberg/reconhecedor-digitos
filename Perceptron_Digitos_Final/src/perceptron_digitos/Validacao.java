package perceptron_digitos;

/**
 *
 * @author Wanderson
 */
public class Validacao {

    public Validacao() {

    }

    public double somatorio(int mat[][], double w[]) {

        double yent = 0;
        double entrada[] = new double[16];
        int l = 1;
        entrada[0] = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                entrada[l] = mat[i][j];
                l++;
            }
        }
        for (int j = 0; j < 16; j++) {
            yent = yent + entrada[j] * w[j];
        }
        return yent;
    }

    public double saida(double yent, double limiar) {
        double f;

        if (yent > limiar) {
            f = 1;
        } else if (yent < -limiar) {
            f = -1;
        } else {
            f = 0;
        }
        return f;
    }
    
    private boolean testaArrayIgual(double arr1[], double arr2[]) {
        boolean igual = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                igual = false;
        }
        return igual;
    }

    public String teste(int mat[][], double w[][], double t[][], double limiar) {

        /*System.out.println("mat: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }*/

        System.out.println("");
        System.out.println("w: ");
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i].length; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println("");
        }
        
        double yent, f;
        boolean mudou;
        String saida = "?";
        int i = 0;
        
        do {
            mudou = false;
            
            System.out.println("");
            System.out.println("f: ");
            for (int neuronio = 0; neuronio < 4; neuronio++) {
                yent = somatorio(mat,w[neuronio]);
                f = saida(yent, limiar);
                System.out.print("f:"+f + " yent:"+yent + " ");
                
                if (f != t[i][neuronio]) {
                    mudou = true;
                }
            }
            /*if (!mudou) {
                System.out.println("I: " + i);
                saida = String.valueOf(i);
            }*/
            //System.out.println("f: " + f[0] + " " + f[1] + " " + f[2] + " " + f[3]);
            //System.out.println("");
            
            /*if (testaArrayIgual(f, t[i])) {
                System.out.println("I: " + i);
                saida = String.valueOf(i);
                break;
            }*/
            if (mudou)
                i++;
        } while (mudou == true);
        
        System.out.println("");
        System.out.println("I: " + i);
        saida = String.valueOf(i);
        return saida;
        
        
        
        
        

        
        
        /*if (testaArrayIgual(f,t[0])) {
            return "0";
        } else if (testaArrayIgual(f,t[1])) {
            return "1";
        } else if (testaArrayIgual(f,t[2])) {
            return "2";
        } else if (testaArrayIgual(f,t[3])) {
            return "3";
        } else if (testaArrayIgual(f,t[4])) {
            return "4";
        } else if (testaArrayIgual(f,t[5])) {
            return "5";
        } else if (testaArrayIgual(f,t[6])) {
            return "6";
        } else if (testaArrayIgual(f,t[7])) {
            return "7";
        } else if (testaArrayIgual(f,t[8])) {
            return "8";
        } else if (testaArrayIgual(f,t[9])) {
            return "9";
        } else {
            return "?";
        }*/
    }

}
