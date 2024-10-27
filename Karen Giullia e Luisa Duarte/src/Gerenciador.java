import java.util.ArrayList;

public class Gerenciador {
    Bolha bolha;
    Reordenamento reordenamento;
    Adiantamento adiantamento;

    public Gerenciador() {
        bolha = new Bolha();
        reordenamento = new Reordenamento();
        adiantamento = new Adiantamento();
    }

    public ArrayList<Instrucao> iniciar(ArrayList<Instrucao> instrucoes, int opcao) {

        ArrayList<Instrucao> resultado = new ArrayList<>();

        int tamanho = instrucoes.size() - 1;


        for (int i = 0; i < tamanho; i++) {
            Instrucao instrucao1 = instrucoes.get(i);
            Instrucao instrucao2 = instrucoes.get(i + 1);
            Instrucao instrucao3;

            if (i == instrucoes.size() - 2) {
                instrucao3 = null;
            } else {
                instrucao3 = instrucoes.get(i + 2);
            }

            int numNop = quantidadeNOP(instrucao1, instrucao2, instrucao3);
            //opções de arquivo
            if (opcao== 1 || opcao==3) {
                //apenas bolha ou com reordenamento
                bolha.metodoDaBolha(instrucao1, numNop, resultado);
            }
            if (opcao==2 || opcao==4) {
                //adiantamento com bolha ou os 3 juntos
                adiantamento.adiantamentoComBolha(instrucao1, numNop, resultado);
            }
        }
        resultado.add(instrucoes.get(tamanho));
        if (opcao==3 || opcao==4) {
            //reordenamento
            reordenamento.metodoDeReordenamento(resultado);
        }

        return resultado;
    }
    private int quantidadeNOP(Instrucao instrucao1, Instrucao instrucao2, Instrucao instrucao3) {
        Opcode opcode = new Opcode();

        //se nao for nop
        if (instrucao1.getOpcode() != "nop") {
            if (instrucao2.getOpcode() != "nop") {
                //ve o caso
                if (casosDeDependencia(instrucao1, instrucao2, opcode)) {
                    return 2;
                }
            }

            if (instrucao3 != null) {
                if (instrucao3.getOpcode() != "nop") {
                    if (casosDeDependencia(instrucao1, instrucao3, opcode)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }
    protected static boolean casosDeDependencia(Instrucao instrucao1, Instrucao instrucao2, Opcode opcode) {

        if (opcode.isInstrucaoDestino(instrucao1.getOpcode()) && !opcode.isInstrucaoDestino(instrucao2.getOpcode())) {
            if (instrucao1.getRegistrador1().equals(instrucao2.getRegistrador1()) || instrucao1.getRegistrador1().equals(instrucao2.getRegistrador2())
                    || instrucao1.getRegistrador1().equals(instrucao2.getRegistrador3())) {
                return true;
            }
        }

        if (opcode.isInstrucaoDestino(instrucao1.getOpcode()) && opcode.isInstrucaoDestino(instrucao2.getOpcode())) {
            if (instrucao1.getRegistrador1().equals(instrucao2.getRegistrador2()) || instrucao1.getRegistrador1().equals(instrucao2.getRegistrador3())) {
                return true;
            }
        }

        if (!opcode.isInstrucaoDestino(instrucao1.getOpcode()) && opcode.isInstrucaoDestino(instrucao2.getOpcode())) {
            if (instrucao1.getRegistrador2().equals(instrucao2.getRegistrador2()) || instrucao1.getRegistrador3().equals(instrucao2.getRegistrador3())) {
                return true;
            }
        }

        return false;
    }


}
