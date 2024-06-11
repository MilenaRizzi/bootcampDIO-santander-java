# Resolução do desafio Modelagem e Diagramação de um Componente iPhone

**Objetivo**
1. Criar um diagrama UML que represente as funcionalidades descritas acima.
2. Implementar as classes e interfaces correspondentes em Java (Opcional).

```mermaid
classDiagram
    iPhone --> ReprodutorMusical
    iPhone --> AparelhoTelefonico
    iPhone --> NavegadorInternet

    class ReprodutorMusical {
        <<interface>>
        +tocar()
        +pausar()
        +selecionarMusica(String musica)
    }

    class AparelhoTelefonico {
        <<interface>> 
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }
    