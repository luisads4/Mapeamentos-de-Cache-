import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LeitorArquivo {
    private String diretorioArquivo;
    BufferedReader entradaDeDados;

    public LeitorArquivo(String diretorioArquivo) throws FileNotFoundException {
        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));
    }

    private String[] leLinha() {
        String[] linhaArray = new String[4];  // Garante que sempre teremos 4 posições
        try {
            String linha = entradaDeDados.readLine();  // Lê uma linha do input
            if (linha != null) {
                // Remove os caracteres não desejados
                linha = linha.replace(",", "");
                linha = linha.replace("(", " ");
                linha = linha.replace(")", "");
                // Remove espaços extras
                linha = linha.trim().replaceAll("\\s+", " ");

                // Divide a linha em palavras com base em espaços
                String[] partes = linha.split(" ");


                for (int i = 0; i < 4; i++) {
                    if (i < partes.length) {
                        linhaArray[i] = partes[i];
                    } else {
                        linhaArray[i] = " ";
                    }
                }

            } else {
                entradaDeDados.close();
                linhaArray = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhaArray;
    }

    public ArrayList<Instrucao> leArquivo(){
        ArrayList<Instrucao> instrucoes = new ArrayList<>();
        Instrucao instrucao;
        String[] linha;
        while((linha = leLinha())!=null){
            if (!linha[0].isEmpty()) {  //ignora linhas vazias
                if (linha[0].equals("nop")) {
                    instrucao = new Instrucao("nop", "", "", "");
                } else {
                    instrucao = new Instrucao(linha[0], linha[1], linha[3], linha[2]);
                }
                instrucoes.add(instrucao);
            }

        }
        return instrucoes;
    }
    public void escreveArquivo(String escreverArquivo, String caminhoPasta, String nomeArquivo) {
        // Cria a pasta se não existir
        File pasta = new File(caminhoPasta);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        // Cria o caminho completo do arquivo
        String caminhoCompleto = caminhoPasta + File.separator + nomeArquivo;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoCompleto));
            bufferedWriter.write(escreverArquivo);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
