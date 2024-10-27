import java.util.ArrayList;
import java.util.List;

public class Opcode {
    private List<String> instrucaoDestino;
    private List<String> instrucoesDeMemoria;
    private List<String> instrucaoOrigem;

    public Opcode(){
        instrucaoOrigem = new ArrayList<>();
        instrucaoDestino = new ArrayList<>();
        instrucoesDeMemoria = new ArrayList<>();

        instrucaoOrigem.add("bltz");
        instrucaoOrigem.add("bgez");
        instrucaoOrigem.add("bltzal");
        instrucaoOrigem.add("bgezal");
        instrucaoOrigem.add("div");
        instrucaoOrigem.add("divu");
        instrucaoOrigem.add("sw");
        instrucaoOrigem.add("sb");
        instrucaoOrigem.add("sh");
        instrucaoOrigem.add("swl");
        instrucaoOrigem.add("swr");
        instrucaoOrigem.add("mthi");
        instrucaoOrigem.add("mtlo");
        instrucaoOrigem.add("mult");
        instrucaoOrigem.add("multu");
        instrucaoOrigem.add("jr");
        instrucaoOrigem.add("j");
        instrucaoOrigem.add("jal");


        instrucaoDestino.add("lb");
        instrucaoDestino.add("lh");
        instrucaoDestino.add("lwl");
        instrucaoDestino.add("lw");
        instrucaoDestino.add("lbu");
        instrucaoDestino.add("lhu");
        instrucaoDestino.add("lwr");
        instrucaoDestino.add("add");
        instrucaoDestino.add("addu");
        instrucaoDestino.add("sub");
        instrucaoDestino.add("subu");
        instrucaoDestino.add("and");
        instrucaoDestino.add("or");
        instrucaoDestino.add("xor");
        instrucaoDestino.add("nor");
        instrucaoDestino.add("slt");
        instrucaoDestino.add("sltu");
        instrucaoDestino.add("addi");
        instrucaoDestino.add("addiu");
        instrucaoDestino.add("slti");
        instrucaoDestino.add("sltiu");
        instrucaoDestino.add("andi");
        instrucaoDestino.add("ori");
        instrucaoDestino.add("xori");
        instrucaoDestino.add("lui");
        instrucaoDestino.add("sll");
        instrucaoDestino.add("srl");
        instrucaoDestino.add("sra");
        instrucaoDestino.add("sllv");
        instrucaoDestino.add("srlv");
        instrucaoDestino.add("srav");
        instrucaoDestino.add("mfhi");
        instrucaoDestino.add("mflo");
        instrucaoDestino.add("jalr");

        instrucoesDeMemoria.add("lb");
        instrucoesDeMemoria.add("lh");
        instrucoesDeMemoria.add("lwl");
        instrucoesDeMemoria.add("lw");
        instrucoesDeMemoria.add("lbu");
        instrucoesDeMemoria.add("lhu");
        instrucoesDeMemoria.add("lwr");
        instrucoesDeMemoria.add("sb");
        instrucoesDeMemoria.add("sh");
        instrucoesDeMemoria.add("swl");
        instrucoesDeMemoria.add("sw");
        instrucoesDeMemoria.add("swr");
        instrucoesDeMemoria.add("j");
        instrucoesDeMemoria.add("jal");
        instrucoesDeMemoria.add("jr");
        instrucoesDeMemoria.add("jalr");
        instrucoesDeMemoria.add("sll");
        instrucoesDeMemoria.add("srl");
        instrucoesDeMemoria.add("sra");
        instrucoesDeMemoria.add("sllv");
        instrucoesDeMemoria.add("srlv");
        instrucoesDeMemoria.add("srav");


        instrucaoOrigem.add("bltz");
        instrucaoOrigem.add("bgez");
        instrucaoOrigem.add("bltzal");
        instrucaoOrigem.add("bgezal");
        instrucaoOrigem.add("beq");
        instrucaoOrigem.add("bne");
        instrucaoOrigem.add("blez");
        instrucaoOrigem.add("btgz");
        instrucaoOrigem.add("sw");
        instrucaoOrigem.add("sb");
        instrucaoOrigem.add("sh");
        instrucaoOrigem.add("swl");
        instrucaoOrigem.add("swr");
        instrucaoOrigem.add("jr");
        instrucaoOrigem.add("j");
        instrucaoOrigem.add("jal");
        instrucaoOrigem.add("mthi");
        instrucaoOrigem.add("mtlo");
        instrucaoOrigem.add("mult");
        instrucaoOrigem.add("multu");
        instrucaoOrigem.add("div");
        instrucaoOrigem.add("divu");


    }
    public boolean isInstrucaoDestino(String instru) {
        return instrucaoDestino.contains(instru);

    }

    public boolean isInstrucaoMemoria(String instru) {
        return instrucoesDeMemoria.contains(instru);
    }
}
