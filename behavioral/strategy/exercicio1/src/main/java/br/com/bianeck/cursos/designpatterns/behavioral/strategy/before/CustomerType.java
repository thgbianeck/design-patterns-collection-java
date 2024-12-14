package br.com.bianeck.cursos.designpatterns.behavioral.strategy.before;

/**
 * Enumeração que representa os diferentes tipos de clientes no sistema.
 * Esta enumeração é utilizada para categorizar clientes e potencialmente
 * determinar benefícios, descontos ou tratamentos específicos para cada tipo.
 */
public enum CustomerType {
    /**
     * Representa um cliente regular ou padrão.
     * Geralmente, este é o tipo atribuído a novos clientes ou aqueles
     * sem status especial.
     */
    REGULAR,

    /**
     * Representa um cliente premium.
     * Clientes premium podem ter acesso a benefícios adicionais ou
     * descontos especiais em comparação com clientes regulares.
     */
    PREMIUM,

    /**
     * Representa um cliente VIP (Very Important Person).
     * Clientes VIP geralmente recebem o mais alto nível de serviço,
     * benefícios exclusivos e os melhores descontos disponíveis.
     */
    VIP
}