public class Instrucao {
    private String opcode;
    private String registrador1;
    private String registrador2;
    private String registrador3;

    public Instrucao(String opcode, String registrador1, String registrador2, String registrador3){
        this.opcode = opcode;
        this.registrador1 = registrador1;
        this.registrador2 = registrador2;
        this.registrador3 = registrador3;
    }

    public String getOpcode(){
        return opcode;
    }

    public String getRegistrador1(){
        return registrador1;
    }

    public String getRegistrador2(){
        return registrador2;
    }

    public String getRegistrador3(){
        return registrador3;
    }
    public void setRegistrador3(String registrador3){
        this.registrador3 = registrador3;
    }

    public String getInstrucaoCompleta(){
        return opcode + " " + registrador1 + " " + registrador2 + " " + registrador3 + " ";
    }
}
