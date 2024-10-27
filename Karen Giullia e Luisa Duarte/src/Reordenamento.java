import java.util.ArrayList;

public class Reordenamento {
    public void metodoDeReordenamento(ArrayList<Instrucao> resultado) {

        for (int i = 0; i < resultado.size(); i++) {

            Instrucao instrucao = resultado.get(i);

            char letra1 = instrucao.getOpcode().charAt(0);

            if (!instrucao.getOpcode().equals("nop")) {
                if (letra1 == 'j') {
                    resultado.addFirst(instrucao);
                    resultado.remove(i + 1);
                } else {
                    if (!dependenciaInstrucoes(i, resultado, 15)) {
                        if (letra1 == 'b') {
                            resultado.addFirst(instrucao);
                            resultado.remove(i + 1);
                        } else {
                            for (int j = 0; j < resultado.size(); j++) {
                                if (resultado.get(j).getOpcode().equals("nop")) {
                                    Instrucao instrucaoComp = resultado.get(j);
                                    if (instrucaoComp.getOpcode().equals("nop")) {
                                        if (!dependenciaIndex(j, resultado, 2, i)) {
                                            resultado.set(j, instrucao);
                                            resultado.remove(i);
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }

            }
        }


        try{
            char firstLetter = resultado.getLast().getOpcode().charAt(0);
            if(firstLetter == 'j'){
                resultado.addFirst(resultado.getLast());
                resultado.removeLast();
            }
            if(firstLetter == 'b'){
                resultado.addFirst(resultado.getLast());
                resultado.removeLast();
            }

        }catch(Error error){
            System.out.println(" ");
        }

    }

    private boolean dependenciaInstrucoes(int index, ArrayList<Instrucao> resultado, int quantidade) {
        Instrucao principal = resultado.get(index);
        Opcode mips = new Opcode();

        int inicio = Math.max(0, index - quantidade);
        int fim = Math.min(resultado.size() - 1, index + quantidade);

        for (int i = inicio; i <= fim; i++) {
            if (i == index) {
                continue;
            }
            Instrucao a = resultado.get(i);

            if (a.getOpcode() == null) {
                continue;
            }

            if (i < index) {
                if (Gerenciador.casosDeDependencia(a, principal, mips)) {
                    return true;
                }

            } else {
                if (Gerenciador.casosDeDependencia(principal, a, mips)) {
                    return true;
                }

            }

        }
        return false;
    }

    private boolean dependenciaIndex(int index, ArrayList<Instrucao> resposta, int index2, int quantidade) {
        Instrucao instrucaoPrincipal = resposta.get(index2);
        Opcode opcode = new Opcode();
        int inicio = Math.max(0, index - quantidade);
        int fim = Math.min(resposta.size() - 1, index + quantidade);

        for (int i = inicio; i <= fim; i++) {

            if (i == index) {
                continue;
            }

            Instrucao instrucao = resposta.get(i);

            if (instrucao.getOpcode() == null) {
                continue;
            }

            if (i < index2) {
                if (Gerenciador.casosDeDependencia(instrucao, instrucaoPrincipal, opcode)) {
                    return true;
                }

            } else {
                if (Gerenciador.casosDeDependencia(instrucaoPrincipal, instrucao, opcode)) {
                    return true;
                }

            }

        }
        return false;
    }


}
