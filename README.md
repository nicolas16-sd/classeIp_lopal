"# classeIp_lopal" 

# Calculadora de IP

---

Este projeto é uma **Calculadora de IP** desenvolvida em Java, na disciplina de Arquitetura de Redes com IoT no SENAI Jandira, utilizando a biblioteca **Swing** para a interface gráfica. Ela permite que você insira um endereço IP e um prefixo CIDR para obter informações detalhadas sobre a rede, como classe do IP, máscara de sub-rede (decimal e binária), número de IPs disponíveis e a listagem de sub-redes com seus respectivos IPs válidos e de broadcast.

## Autor
Nicolas dos Santos Durão

## Funcionalidades

* **Cálculo de Classe de IP**: Identifica a classe do IP (A, B ou C).
* **Máscara de Sub-rede**: Exibe a máscara de sub-rede tanto no formato decimal quanto binário.
* **IPs Disponíveis**: Calcula o número total de IPs disponíveis na rede ou sub-rede.
* **Número de Sub-redes**: Determina a quantidade de sub-redes criadas a partir do CIDR fornecido em relação à classe padrão.
* **Detalhes da Sub-rede**: Para cada sub-rede, mostra o IP da sub-rede, o primeiro e último IP válidos, e o IP de broadcast.
* **Interface Gráfica Simples**: Desenvolvida com Swing para uma interação intuitiva.

## Estrutura do Projeto

O projeto é dividido em duas partes principais:

* **`br.dev.nicolas.ip.gui.Interface`**: Contém a lógica da interface gráfica (GUI) da aplicação, responsável por criar e gerenciar os componentes visuais, capturar a entrada do usuário e exibir os resultados.
* **`br.dev.nicolas.ip.model.Logica`**: Contém a lógica de negócios para os cálculos de IP e sub-rede. Esta classe manipula os dados do IP e CIDR para realizar as operações de rede.

## Como Executar

Para rodar esta calculadora em seu ambiente local, siga os passos abaixo:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/calculadora-ip.git](https://github.com/seu-usuario/calculadora-ip.git)
    cd calculadora-ip
    ```
    *(**Nota:** Se você não tem um repositório, pode simplesmente copiar os arquivos `Interface.java` e `Logica.java` para o seu projeto Java no Eclipse.)*

2.  **Abra no Eclipse:**
    * No Eclipse, vá em `File > Open Projects from File System...`
    * Selecione o diretório onde você clonou (ou copiou) o projeto.
    * Clique em `Finish`.

3.  **Execute a aplicação:**
    * Localize o arquivo `Interface.java` no seu Project Explorer.
    * Clique com o botão direito sobre ele e selecione `Run As > Java Application`.

A janela da calculadora será aberta.

## Requisitos

* **Java Development Kit (JDK)** 8 ou superior.
* **Eclipse IDE** (ou qualquer outra IDE Java).

## Exemplo de Uso

1.  Digite um endereço IP nos quatro campos.
2.  Digite o valor do CIDR (ex: 24, 26) no campo correspondente.
3.  Clique no botão "Calcular".

Os resultados serão exibidos na área de texto abaixo.

