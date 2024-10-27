import java.util.ArrayList;

public class Adiantamento {
    public void adiantamentoComBolha(Instrucao instrucao, int nop, ArrayList<Instrucao> resultado) {
        Opcode opcode = new Opcode();

        if (nop == 0) {
            resultado.add(instrucao);
        }
        if (nop == 1) {
            resultado.add(instrucao);
        }
        if (nop == 2) {
            if (opcode.isInstrucaoMemoria(instrucao.getOpcode())) {
                resultado.add(instrucao);
                resultado.add(new Instrucao("nop", "", "", ""));
            } else {
                resultado.add(instrucao);
            }
        }
    }

}
