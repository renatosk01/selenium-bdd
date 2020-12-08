# language: pt
  @regressivo
  Funcionalidade: Realizar uma pesquisa no google

    Eu, como Automatizador
    Quero poder realizar uma pesquisa no google
    Para que eu treine a minha automação

    @sanidade
  Cenario: Validar página do google carregada
    Dado que eu navego ate a url do google
    Quando a pagina e carregada
    Entao eu consigo validar que e a pagina do google

  Cenario: Pesquisar por Everis no google
    Dado que eu navego ate a url do google
    E a pagina e carregada
    E eu consigo validar que e a pagina do google
    Quando eu pesquiso por "everis" no campo de pesquisa
    E clico no botao pesquisar
    Entao o texto de destaque aparece no lado direito da pagina

  Cenario: Validar a url da home do site da everis
    Dado que eu navego ate a url do google
    E a pagina e carregada
    E eu consigo validar que e a pagina do google
    Quando eu pesquiso por "everis" no campo de pesquisa
    E clico no botao pesquisar
    E clico na primeira opcao de pesquisa do google
    Entao valido que a url atual e a url do site da everis

    @TesteCritico
  Cenario: Clicar no link de about us no site da everis e validar o título principal
    Dado que eu navego ate a url do google
    E a pagina e carregada
    E eu consigo validar que e a pagina do google
    Quando eu pesquiso por "everis" no campo de pesquisa
    E clico no botao pesquisar
    E clico na primeira opcao de pesquisa do google
    E clico no menu about us
    Entao valido que a pagina carregada e a pagina about us

#    Cenário desafio
    @TesteCritico
  Cenario: Realizar hover no menu what we do, clicar na opção technology e validar texto principal technology no site da everis
    Dado que eu navego ate a url do google
    E a pagina e carregada
    E eu consigo validar que e a pagina do google
    Quando eu pesquiso por "everis" no campo de pesquisa
    E clico no botao pesquisar
    E clico na primeira opcao de pesquisa do google
    E clico na opcao technology dentro do menu de hover what we do
    Entao valido que a pagina carregada e a pagina technology

    Esquema do Cenario: Validar pesquisa feita com sucesso
      Dado que eu navego ate a url do google
      E a pagina e carregada
      E eu consigo validar que e a pagina do google
      Quando eu pesquiso por "<Pesquisa>" no campo de pesquisa
      E clico no botao pesquisar
      Entao valido que a palavra "<Pesquisa>" existe na pagina

      Exemplos:
      | Pesquisa |
      | everis   |
      | amazon   |
      | uol      |
