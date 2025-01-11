
package sistemacontroleestoque;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaControleEstoque {
     
    private final Produtos produtosList[] = new Produtos[5]; //// O  codigo aprendento algumas interrupicoes ///
    private int posicaoAtual = 0;
  
    public static void main(String[] args) {
        SistemaControleEstoque app = new SistemaControleEstoque();
        app.tituloMenu();
        app.telaPrincipal();
    }
    
    private void telaPrincipal() {
        int opcao = 0;
        do{
            opcao = opcaoMenu();
            switch (opcao) {
                case 1:
                    menuCadastroProduto();
                    break;
                case 2:
                    menuMovimentacao();
                    break;
                case 3:
                    reajustePreçoProdutos();
                    break;
                case 4:
                    relatorioDeProdutos();
                    break;
                case 0: 
                    System.out.println("Saindo.");
                    break;
                default:
                    opcaoInvalida();
                    break;
                    
            }
        }while (opcao != 0);
        
    }
    private int opcaoMenu() {
        int opcao;
        System.out.println("Menu Principal \n" + 
                           "1 - Cadastro de Produto\n" +
                           "2 - Alteração de Produto\n" +
                           "3 - Reajuste de Produtos\n" +
                           "4 - Relatórios de Produtos \n" +
                           "0 - Sair\n" +
                           " Opção :_\n");
        opcao = getEscolhaMenu();
        return opcao;
    }
    
    private void menuCadastroProduto(){
        int opcao;
        System.out.println("1 - Incluir Produto\n" + 
                           "2 - Alterar Produto\n" +
                           "3 - Consultar Produto\n" +
                           "4 - Excluir Produto\n" +
                           "0 - Retornar\n");
        opcao = getEscolhaMenu();
        switch (opcao) {
            case 1:
                cadastrarProdutos();
                break;
            case 2: 
                alterarProdutos();
                break;
            case 3: 
                consultarProdutos();
                break;
            case 4:
                excluirProdutos();
                break;
            default:
                opcaoInvalida();
                break;
        } 
    }
    private Produtos setDadosDoProduto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do Produto");
        String nome = scanner.nextLine();
        System.out.println("Informe a unidade de medida");
        scanner = new Scanner(System.in);
        String unidade = scanner.nextLine();
        System.out.println("Informe a quantidade");
        int quantidade = scanner.nextInt();
        Produtos produtos = new Produtos();
        produtos.setNome(nome);
        produtos.setUnidade(unidade);
        produtos.setQuantidadeEmEstoque(quantidade);
        return produtos;
    }
    
    private void cadastrarProdutos(){
        String escolha;
        do {
            this.tituloMenu();
            System.out.println("Cadastro de Produtos");
            Produtos produtos = setDadosDoProduto();
             escolha =  confirmaOperacao();
            
            if (escolha.equalsIgnoreCase("S")) {
                produtosList[posicaoAtual] = produtos;
                posicaoAtual++;
            }
            escolha = getRepetirOperacao();
        }
        while (escolha.equalsIgnoreCase("S"));
    }
    private void menuMovimentacao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alteração dos Produtos");
        System.out.println("1 - Entrada\n" + 
                           "2 - Saída\n" +
                           "0 - Retornar\n" +
                           "Opção: _\n");
        int opcaoMovimentacao = scanner.nextInt();
        switch (opcaoMovimentacao){
            case 1: 
                entradaProduto();
                break;
            case 2: 
                saidaProduto();
                break;
            case 0:
                System.out.println("Voltar ao menu");
                break;
            default: 
                opcaoInvalida();
                break;
        }
    }
    private void entradaProduto() {
        String escolha;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrada de Produto");
            System.out.println("Nome do Produto");
            String nomeProduto = scanner.nextLine();
            Produtos produtosMovimentacao;
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if
            (nomeProduto.equalsIgnoreCase(produtosList[i].getNome())){
                controle=false;
                produtosMovimentacao = produtosList[i];
                System.out.println("Quantidade atual: " +
            produtoMovimentacao.getQuantidadeEmEstoque());
                System.out.println("Quantidade de Entrada: ");
                int quantidadeEntrada = scanner.nextInt();
                System.out.println("Quantidade Total: " + 
                        
            (produtosMovimentacao.getQuantidadeEmEstoque() + quantidadeEntrada));
                escolha = confirmaOperacao();
                if (escolha.equalsIgnoreCase("S")){
            produtosMovimentacao.setAdicionarQuantidade(quantidadeEntrada);
                produtosList[i] = produtosMovimentacao;
                }
                break;
            }
            }
            mensagenProdutoNaoEncontrado(controle);
            escolha = getRepetirOperacao();
        } while (escolha.equalsIgnoreCase("S"));
    }
    private void saidaMovimentacao() {
        String escolha;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Saída de Produtos");
            System.out.println("Nome do Produto");
            String nomeProduto = scanner.nextLine();
            boolean controle = true;
            for (int i = 0; i < posicaoAtual; i++){
                if
            (nomeProdutos.equalsIgnoreCase(produtosList[i].getNome())){
                controle=false;
                Produtos produtosMovimentacao = produtosList[i];
                System.out.println("Quantidade Atual: " + 
            produtosMovimentacao.getQuantidadeEmEstoque());
                System.out.println("Quantidade Saida: ");
                int quantidadeSaida = scanner.nextInt();
                System.out.println("Quantidade Total: " +
            (produtosMovimentacao.getQuantidadeEmEstoque() - quantidadeSaida));
                if (produtosMovimentacao.getQuantidadeEmEstoque()< quantidadeSaida){
                    System.out.println("Quantidade indisponível");
                    break;
                }
                escolha = confirmaOperacao();
                if (escolha.equalsIgnoreCase("S")){
                    producaoMovimentacao.setDiminuirQuantidade(quantidadeSaida);
                    produtosList[i] = produtosMovimentacao;
                }
                break;
                }
            }
            mensagemProdutoNaoEncontrado(controle);
            escolha = getRepetirOperacao();
        }
        while (escolha.equalsIgnoreCase("S"));
    }
    
    private void relatorioDeProdutos(){
        this.tituloMenu();
        System.out.println("Relatório");
        for (int i = 0; i < posicaoAtual; i++){
            System.out.println("\n");
            System.out.println("Produtos: \n" + produtosList[i]);
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Aperte O + ENTER para continuar");
            scanner.next();
        }
    }
    private void excluirProdutos(){
        String escolha = null;
        do{
            Scanner scanner = new Scanner(System.in);
            this.tituloMenu();
            System.out.println("Excluindo Produto");
            System.out.println("Qual produto deseja excluir?");
            String nomeConsulta = scanner.nextLine();
            boolean controle = true;
            ArrayList<Produtos> arrayList = new ArrayList();
            arrayList.add(new Produtos());
            for (int i = 0; i < posicaoAtual; i++){
                scanner = new Scanner(System.in);
                Produtos produtos = arrayList.get(i);
                if (nomeConsulta.equalsIgnoreCase(produtosList[i].getNome()))
                    controle = false;
                    System.out.println(produtosList[i].toString());
                    System.out.println("Confirmar exclusão? \n (S/N)");
                    escolha = scanner.next();
                    if (escolha.equalsIgnoreCase("S")){
                        for (int j = i; j < posicaoAtual - 1; j++){
                            produtosList[j] = produtosList[j + 1];
                            posicaoAtual--;
                        }
                    }
                    break;
            }
        }while (escolha.equalsIgnoreCase("S"));
        boolean controle = false;
        mensagemProdutoNaoEncontrado(controle);
        escolha = getRepetirOperacao();
    }
    
    


    private void opcaoInvalida() {
        System.out.println("Opção inválida");
    }

    private void consultarProdutos() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.tituloMenu();
            System.out.println("Consulta de Produtos");
            System.out.println("Informe o nome do produto para pesquisa");
            String nomeConsulta = scanner.nextLine();
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeConsulta.equalsIgnoreCase(produtosList[i].getNome())) {
                    controle=false;
                    System.out.println(produtosList[i].toString());
                    
                }                    break;
            }
            mensagemProdutoNaoEncontrado(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void alterarProdutos() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.tituloMenu();
            System.out.println("Alteração de Produto");
            System.out.println("Informe o nome do produto para alterar");
            String nomeConsulta = scanner.nextLine();
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {

                if (nomeConsulta.equalsIgnoreCase(produtosList[i].getNome())) {
                    controle=false;
                    System.out.println("Produto Encontrado\n");
                    Produtos produtos = setDadosDoProduto();
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtosList[i] = produtos;
                    }
                    break;
                }
            }
            mensagemProdutoNaoEncontrada(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }
    
    private void mensagemProdutoNaoEncontrado (boolean controle){
        if (controle){
           System.out.println("Produto não encontrado");
    }
}
    private String getRepetirOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("REPETIR OPERAÇÃO ( S/N ) ? ");
        escolha = scanner.nextLine();
        return escolha;
    }

    private String confirmaOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("CONFIRMA OPERAÇÃO ( S/N ) ?");
        escolha = scanner.nextLine();
        return escolha;
    }

    private int getEscolhaMenu() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    private void tituloMenu() {
        System.out.println("CONTROLE DE ESTOQUE.\n");
    }

    private void reajustePreçoProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void relatorioDeProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getEscohaMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void casdastrarProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void alterarProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void consultarProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saidaProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mensagenProdutoNaoEncontrado(boolean controle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private static String  confirmaOperação() { //o metodo de asinatura e confirmaoperacao quando coloco o nome coreto gera um erro ///
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mensagemProdutoNaoEncontrada(boolean controle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void reajustePreçoProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

