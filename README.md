# Agendamento de Transferências Financeiras


Aplicação para agendamento de transferências financeiras com calculo de taxas.

## Decisões arquiteturais ##

Neste projeto foi utilizado os frameworks SpringBoot e SpringData por sua facilidade e simplicidade ao iniciar
um projeto e persistir dados.
Como banco de dados utilizei o H2, pelo seu funcionamento em memoria, seguindo a exigência do teste.

No desenvolvimento do codigo a todo momento houve a preocupação de utilizar os recursos mais recentes do Java e tambem de criar um codigo limpo, flexivel e de baixo acoplamento,
para facilitar novas implementações ou manutenção.
Na questão central do teste foi utilizado o design pattern "Factory Method" para encapsular o código que cria objetos do tipo de taxa,
para facilitar a implementação de novas taxas.


## Instalação ##

Para rodar o projeto utilize uma das seguintes opções:
 - Baixe o jar da pasta root e com o JDK 13 configurado corretamento nas variaveis de ambiente execulte o jar utilizando 
 o comando: java -jar agendamento-bancario.jar
 - Importe o projeto em sua IDE, ajuste para o JDK 13 no Build Path caso necessario e utilize o maven para compilar e
então utilize o DevTools do Spring Suite para inicializar a aplicação.


## Testando a aplicação ##

Abra o browser e visite a página: http://localhost:8080/agendamento


## Ferramentas Utilizadas: ##

- Java 13
- SpringBoot 2.2.0.RELEASE com tomcat embedded
- SpringData JPA
- Thymeleaf
- Junit
- H2 database
- Spring Tools Suite 4
- Maven
- Github
- Eclipse IDE