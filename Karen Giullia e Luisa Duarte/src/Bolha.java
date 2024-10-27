import java.util.ArrayList;

public class Bolha {
    public void metodoDaBolha(Instrucao instrucao, int nop, ArrayList<Instrucao> resultado) {
        if (nop == 0) {
            resultado.add(instrucao);
        }
        if (nop == 1) {
            resultado.add(instrucao);
            resultado.add(new Instrucao("nop", "", "", ""));
        }
        if (nop == 2) {
            resultado.add(instrucao);
            resultado.add(new Instrucao("nop", "", "", ""));
            resultado.add(new Instrucao("nop", "", "", ""));

        }
    }
    
}
