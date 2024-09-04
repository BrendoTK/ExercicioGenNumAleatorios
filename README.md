# Geradores de Números Aleatórios

## A Escolha pelo Padrão Adapter

Ao desenvolver o projeto, nos deparamos com o desafio de uniformizar a interface de duas classes distintas: a classe `Random` do pacote `java.util` e as classes que implementam a interface `RealDistribution` da biblioteca Apache Commons Math. Ambas as classes são capazes de gerar números pseudo-aleatórios, mas utilizam métodos diferentes para configurar a seed (semente) e para gerar os números.

A classe `Random` fornece métodos como `nextDouble()` e `doubles(streamSize: long)` para gerar números aleatórios. Além disso, permite configurar a seed diretamente no construtor ou através do método `setSeed(long seed)`. Por outro lado, as classes que implementam `RealDistribution` oferecem métodos como `sample()` e `sample(int sampleSize)` para gerar números, mas a configuração da seed é feita através do método `reseedRandomGenerator(long seed)`.

Essas diferenças tornam o uso de cada uma dessas classes diferente e, consequentemente, dificultam a criação de uma solução genérica que possa utilizar qualquer uma delas de forma intercambiável. Para resolver esse problema, aplicamos o **Padrão Adapter**.

## O Padrão Adapter

O **Padrão Adapter** é um dos padrões de design mais conhecidos da programação orientada a objetos. Ele é utilizado para permitir que duas interfaces incompatíveis trabalhem juntas. No nosso caso, precisávamos que as diferentes interfaces (`Random` e `RealDistribution`) compartilhassem uma interface comum, facilitando o uso e a substituição das implementações sem a necessidade de modificar o código que as utiliza.

## Implementação do Adapter

Criamos uma interface comum `RandomNumberGenerator`, que define dois métodos principais:

- `generateNumbers(int count)`: Para gerar um vetor de números aleatórios (`double[]`).
- `reseedRandomGenerator(long seed)`: Para definir a seed do gerador de números.

A partir dessa interface, criamos duas classes adaptadoras:

1. **RealDistributionAdapter**: Adaptador para classes que implementam `RealDistribution`, como `NormalDistribution` e `LogNormalDistribution`.
2. **RandomAdapter**: Adaptador para a classe `Random` do pacote `java.util`.

Esses adaptadores implementam a interface `RandomNumberGenerator`, permitindo que as diferentes implementações de geradores de números sejam utilizadas de forma intercambiável e com uma interface unificada. Dessa forma, a configuração da seed e a geração de números passaram a ser feitas de maneira padronizada, independentemente da classe utilizada.

## Benefícios do Padrão Adapter

- **Reusabilidade**: O código que utiliza a interface `RandomNumberGenerator` não precisa se preocupar com as diferenças entre `Random` e `RealDistribution`. Isso facilita a manutenção e a extensão do sistema.
- **Flexibilidade**: Podemos facilmente trocar a implementação do gerador de números sem alterar o código que consome essa funcionalidade. Por exemplo, trocar de `NormalDistribution` para `LogNormalDistribution` é simples e direto.
- **Simplicidade**: A padronização permite que os desenvolvedores trabalhem com uma única interface, simplificando o entendimento e o uso das classes de geração de números aleatórios.

Em resumo, a aplicação do **Padrão Adapter** foi crucial para resolver o problema de inconsistência entre as interfaces, permitindo que diferentes implementações de geradores de números aleatórios fossem utilizadas de maneira uniforme e sem a necessidade de alterações substanciais no código. Isso resultou em um código mais flexível, reutilizável e de fácil manutenção.
