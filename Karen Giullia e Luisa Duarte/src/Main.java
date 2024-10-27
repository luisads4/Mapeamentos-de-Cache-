import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LeitorArquivo leitor;

        // Diretório onde estão os arquivos
        String caminhoPasta="C:\\Users\\Karen\\Desktop\\if\\Arquitetura\\tp2\\Nova pasta (4)\\Trabalho2\\src\\arquivos";

        File diretorio = new File(caminhoPasta);
        File[] arquivos = diretorio.listFiles();
        //array com as instrcuções do arquivo
        ArrayList<Instrucao> instrucoes;
        //resultado
        ArrayList<Instrucao> resultado = new ArrayList<>();
        Gerenciador gerenciador = new Gerenciador();

        for (File arquivo : arquivos) { // Percorre cada arquivo no diretório
            leitor = new LeitorArquivo(arquivo.getAbsolutePath());
            String nomeAtual = arquivo.getName();
            //le as instrucoes do arquivo
            instrucoes = leitor.leArquivo();
            if (nomeAtual.equals("TESTE-01.txt") || nomeAtual.equals("TESTE-02.txt")){
                //metodo da bolha
                resultado = gerenciador.iniciar(instrucoes, 1);
            }else if(nomeAtual.equals("TESTE-03.txt") || nomeAtual.equals("TESTE-04.txt")){
                //adiantamento com bolha
                resultado = gerenciador.iniciar(instrucoes, 2);
            } else if (nomeAtual.equals("TESTE-05.txt") || nomeAtual.equals("TESTE-06.txt") || nomeAtual.equals("TESTE-07.txt")) {
                //Reordenamento com bolha/NOP
                resultado = gerenciador.iniciar(instrucoes, 3);
            } else if (nomeAtual.equals("TESTE-08.txt") || nomeAtual.equals("TESTE-09.txt") || nomeAtual.equals("TESTE-10.txt")) {
                //Adiantamento + Reordenamento + Bolha/NOP
                resultado = gerenciador.iniciar(instrucoes, 4);
            }
            //coloca em uma string
            String arquivoResultado ="";
            //nome do arquivo, tira o final .txt e acrescenta o resultado
            String arquivoNome =  nomeAtual.replace(".txt", "-RESULTADO.txt");
            System.out.println();
            System.out.println(arquivoNome);
            //imprime e coloca no arquivo
            for (Instrucao linha :  resultado) {
                System.out.println(linha.getInstrucaoCompleta());
                arquivoResultado += linha.getInstrucaoCompleta();
                arquivoResultado += "\n";
            }
            //escreve no arquivo resultado
            leitor.escreveArquivo(arquivoResultado,caminhoPasta, arquivoNome);

        }
    }
}