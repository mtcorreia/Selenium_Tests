package sistemadetestes.test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sistemadetestes.pageObject.ProdutoPO;

import static org.junit.Assert.*;

/**
 * Classe de testes para a funcionalidade de produtos do sistema.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {

    private static ProdutoPO productPage;

    /**
     * Inicializando a página de produtos.
     */
    @BeforeClass
    public static void prepararTestes() {
        productPage = new ProdutoPO(driver);
    
    }
    
    /**
     * Teste para verificar se a tela de cadastro de produtos é aberta corretamente ao clicar no botão "Criar".
     */
    @Test
    public void TC001_clicarUmaVezNoBotaoCriarDeveAbrirATelaDeCadastroDeProdutos() {
        productPage.clicarBotaoCriar();
        assertTrue(productPage.telaCadastroEstaAberta());
    }
    
    /**
     * Teste para verificar se a tela de cadastro de produtos é fechada corretamente ao clicar no botão "Sair".
     */
    @Test
    public void TC002_deveFecharATelaDeCadastroDeProdutosAoClicarNoBotaoSair() {
        productPage.clicarBotaoCriar();
        productPage.clicarBotaoSair();
        productPage.clicarBotaoSair();
        assertFalse(productPage.telaCadastroEstaAberta());
    }
    
    /**
     * Teste para verificar se é possível adicionar um novo produto na tabela.
     */
    @Test
    public void TC003_deveAdicionarUmNovoProduto() {
        String codigo = "1";
        String nomeProduto = "Novo Produto";
        String quantidadeProduto = "5";
        String valorProduto = "100.00";
        String dataCadastroProduto = "2023-06-23";

        assertFalse(productPage.verificarProdutoNaTabela(nomeProduto));

        productPage.clicarBotaoCriar();

        productPage.preencherCampoCodigo(codigo);
        productPage.preencherCampoNome(nomeProduto);
        productPage.preencherCampoQuantidade(quantidadeProduto);
        productPage.preencherCampoValor(valorProduto);
        productPage.preencherCampoDataCadastro(dataCadastroProduto);

        productPage.clicarBotaoSalvar();

        assertTrue(productPage.verificarProdutoNaTabela(nomeProduto));
    }
}