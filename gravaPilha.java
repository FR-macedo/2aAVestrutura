
import java.io.*;
import java.util.*;

public class GravaPilha {
    public static void main(String[] args) {

        String caminhoArquivo = "\\Produto.txt";
        int codigo;
        String descricao;
        double valor;
        int quantidade;
        int categoria;
        int contador = 1;
        try {
            File arquivo = new File(caminhoArquivo);
            Scanner leitorArquivo = new Scanner(arquivo);
            Stack<RegPro> registros = new Stack<>();

            while (leitorArquivo.hasNextLine()) {
                String linha = leitorArquivo.nextLine();
                String[] dados = linha.split(";");
                codigo = Integer.parseInt(dados[0]);
                descricao = dados[1];
                valor = Double.parseDouble(dados[2]);
                valor = valor / 100;
                quantidade = Integer.parseInt(dados[3]);
                categoria = Integer.parseInt(dados[4]);
                registros.push(new RegPro(codigo, descricao, valor, quantidade, categoria));
            }

            // imprimir valores para teste
            while (!registros.isEmpty()) {
                RegPro i = registros.pop();
                System.out.println("\n");
                System.out.println("*Item [" + contador + "]" + "da lista*");
                System.out.println("Código: " + i.getCodigo());
                System.out.println("Descrição: " + i.getDescricao());
                System.out.println("Preço: " + i.getPreco());
                System.out.println("Quantidade: " + i.getQtd());
                System.out.println("Categoria:" + i.getCategoria());
                contador++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

}