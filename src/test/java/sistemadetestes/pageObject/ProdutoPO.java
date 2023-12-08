package sistemadetestes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Página de objetos para a funcionalidade de produtos do sistema criado para a aula/prova.
 */
public class ProdutoPO extends BasePO {

    @FindBy(css = "#collapsibleNavbar > ul > li > a")
    private WebElement buttonVoltarLogin;

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriarProduto;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvarProduto;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(css = "div.alert.alert-danger button.close")
    public WebElement buttonFecharMensagemErro;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> tableProduto;

    @FindBy(id = "cadastro-produto")
    public WebElement divCadastro;

    @FindBy(css = "div.alert.alert-danger")
    public WebElement spamErro;

    @FindBy(css = "div.card")
    public WebElement divDetalhes;

    @FindBy(id = "detalhes-nome")
    public WebElement spanNomeProdutoDetalhes;

    @FindBy(id = "detalhes-quantidade")
    public WebElement spanQuantidadeProdutoDetalhes;

    @FindBy(id = "detalhes-valor")
    public WebElement spanValorProdutoDetalhes;

    @FindBy(id = "detalhes-data")
    public WebElement spanDataCadastroProdutoDetalhes;

    /**
     * Construtor da classe.
     *
     * @param driver O driver do Selenium WebDriver.
     */
    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Clica no botão "Criar".
     */
    public void clicarBotaoCriar() {
        buttonCriarProduto.click();
    }

    /**
     * Clica no botão "Salvar".
     */
    public void clicarBotaoSalvar() {
        buttonSalvarProduto.click();
    }

    /**
     * Clica no botão "Sair".
     */
    public void clicarBotaoSair() {
        buttonSair.click();
    }

    /**
     * Verifica se a tela de cadastro de produtos está aberta.
     *
     * @return true se a tela estiver aberta, false caso contrário.
     */
    public boolean telaCadastroEstaAberta() {
        return divCadastro.isDisplayed();
    }

    /**
     * Obtém as linhas de produtos da tabela.
     *
     * @return Uma lista de elementos WebElement representando as linhas de produtos.
     */
    public List<WebElement> obterLinhasProdutos() {
        return tableProduto;
    }

    /**
     * Preenche o campo de nome do produto com o valor especificado.
     *
     * @param codigo O nome do produto.
     */
    public void preencherCampoCodigo(String codigo) {
        WebElement campoCodigo = driver.findElement(By.id("codigo"));
        campoCodigo.sendKeys(codigo);
    }

    /**
     * Preenche o campo de nome do produto com o valor especificado.
     *
     * @param nome O nome do produto.
     */
    public void preencherCampoNome(String nome) {
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys(nome);
    }

    /**
     * Preenche o campo de quantidade do produto com o valor especificado.
     *
     * @param quantidade A quantidade do produto.
     */
    public void preencherCampoQuantidade(String quantidade) {
        WebElement campoQuantidade = driver.findElement(By.id("quantidade"));
        campoQuantidade.sendKeys(quantidade);
    }

    /**
     * Preenche o campo de valor do produto com o valor especificado.
     *
     * @param valor O valor do produto.
     */
    public void preencherCampoValor(String valor) {
        WebElement campoValor = driver.findElement(By.id("valor"));
        campoValor.sendKeys(valor);
    }

    /**
     * Preenche o campo de data de cadastro do produto com o valor especificado.
     *
     * @param data A data de cadastro do produto.
     */
    public void preencherCampoDataCadastro(String data) {
        WebElement campoDataCadastro = driver.findElement(By.id("data"));
        campoDataCadastro.sendKeys(data);
    }

    /**
     * Verifica se um produto com o nome especificado está presente na tabela de produtos.
     *
     * @param nome O nome do produto.
     * @return true se o produto estiver presente, false caso contrário.
     */
    public boolean verificarProdutoNaTabela(String nome) {
        List<WebElement> rows = tableProduto;
        for (WebElement row : rows) {
            if (row.getText().contains(nome)) {
                return true;
            }
        }
        return false;
    }

}