package stepsDefinitions;

import io.cucumber.java.pt.*;
import pages.*;

public class GoogleTestsSteps {

    GooglePesquisaPage googlePesquisaPage = new GooglePesquisaPage();
    GoogleResultadosPage googleResultadosPage = new GoogleResultadosPage();
    HomeEverisPage homeEverisPage = new HomeEverisPage();
    AboutUsEverisPage aboutUsEverisPage = new AboutUsEverisPage();
    TechnologyEverisPage technologyEverisPage = new TechnologyEverisPage();

    @Dado("que eu navego ate a url do google")
    public void que_eu_navego_até_a_url_do_google() {
        googlePesquisaPage.navegaGoogle();
    }

    @Quando("a pagina e carregada")
    public void a_página_é_carregada() {
        googlePesquisaPage.validaUrlGoogle();
    }

    @Entao("eu consigo validar que e a pagina do google")
    public void eu_consigo_validar_que_é_a_página_do_google() {
        googlePesquisaPage.validaPaginaGoogle("Pesquisa");
    }

//    @E("eu pesquiso por everis no campo de pesquisa")
//    public void eu_pesquiso_por_everis_no_campo_de_pesquisa() {
//        googlePesquisaPage.pesquisaEveris();
//    }

    @E("eu pesquiso por {string} no campo de pesquisa")
    public void eu_pesquiso_por_no_campo_de_pesquisa(String texto) {
        googlePesquisaPage.pesquisaTexto(texto);
    }

    @E("clico no botao pesquisar")
    public void clico_no_botão_pesquisar() {
        googlePesquisaPage.realizaScrollBotao();
        googlePesquisaPage.clicarBotaoPesquisa();
    }

    @Entao("o texto de destaque aparece no lado direito da pagina")
    public void o_texto_de_destaque_aparece_no_lado_direito_da_página() {
        googleResultadosPage.capturaTextoDestaque();
        googleResultadosPage.validaTextoDestaqueEveris();
    }

    @Quando("clico na primeira opcao de pesquisa do google")
    public void clico_na_primeira_opcao_de_pesquisa_do_google() {
        googleResultadosPage.clicaOpcaoEverisHome();
    }

    @Entao("valido que a url atual e a url do site da everis")
    public void valido_que_a_url_atual_e_a_url_do_site_da_everis() {
        homeEverisPage.validaUrlEveris();
    }

    @Quando("clico no menu about us")
    public void clico_no_menu_about_us() {
        homeEverisPage.clicaMenuAboutUs();
    }

    @Entao("valido que a pagina carregada e a pagina about us")
    public void valido_que_a_pagina_carregada_e_a_pagina_about_us() {
        aboutUsEverisPage.validaTextoAboutUs();
    }

    @Quando("clico na opcao technology dentro do menu de hover what we do")
    public void clico_na_opcao_technology_dentro_do_menu_de_hover_what_we_do() {
        homeEverisPage.hoverMenuWhatWeDo();
        homeEverisPage.clicaMenuTechnology();
    }

    @Entao("valido que a pagina carregada e a pagina technology")
    public void valido_que_a_pagina_carregada_e_a_pagina_technology() {
        technologyEverisPage.validaPaginaTechnology();
    }

    @Entao("valido que a palavra {string} existe na pagina")
    public void valido_que_a_palavra_existe_na_pagina(String palavra) {
        googlePesquisaPage.validaPaginaGoogle(palavra);
    }

}
