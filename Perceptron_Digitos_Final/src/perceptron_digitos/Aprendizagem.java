package perceptron_digitos;

/**
 *
 * @author Wanderson
 */
public class Aprendizagem {

    private double x[][] = {
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}, //0
        {1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1}, //1
        {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, //2
        {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}, //3
        {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1}, //4
        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, //5
        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1}, //6
        {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1}, //7
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, //8
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}, //9
    };

    private double w[][] = new double[4][16];
    /* {
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    }*/
    /*private double w[][] = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };*/
    private double t[][] = {
        {-1, -1, -1, -1},
        {-1, 1, -1, -1},
        {-1, -1, 1, -1},
        {-1, 1, 1, -1},
        {-1, 1, 1, 1},
        {1, -1, -1, -1},
        {1, 1, -1, -1},
        {1, -1, 1, -1},
        {1, 1, 1, -1},
        {1, 1, 1, 1}
    };

    private int epocas;

    public Aprendizagem() {
        epocas = 0;
    }

    public double[][] getw() {
        return w;
    }

    public double[][] gett() {
        return t;
    }

    public int getepocas() {
        return epocas;
    }

    public double somatorio(int i, int neuronio) {
        double yent = 0;
        for (int j = 0; j < x[0].length; j++) {
            yent = yent + x[i][j] * w[neuronio][j];
        }
        return yent;
    }

    public double saida(double yent, double limiar) {
        if (yent > limiar) {
            return 1;
        } else if (yent < -limiar) {
            return -1;
        } else {
            return 0;
        }
    }

    public void atualiza(double alfa, double f, int i, int neuronio) {
        for (int j = 0; j < x[0].length; j++) {
            w[neuronio][j] = w[neuronio][j] + alfa * (t[i][neuronio] - f) * x[i][j];
        }
    }

    public void algoritmo(double alfa, double limiar) {
        double yent, f;
        boolean mudou;

        do {
            mudou = false;
            for (int i = 0; i < x.length; i++) {

                for (int neuronio = 0; neuronio < 4; neuronio++) {
                    yent = somatorio(i, neuronio);
                    f = saida(yent, limiar);
                    if (f != t[i][neuronio]) {
                        atualiza(alfa, f, i, neuronio);
                        mudou = true;
                    }
                }
            }
            epocas++;
        } while (mudou == true);
    }
}
