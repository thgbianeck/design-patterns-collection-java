package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after;

import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.strategies.DiscountPremium;
import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.strategies.DiscountRegular;
import br.com.bianeck.cursos.designpatterns.behavioral.strategy.after.strategies.DiscountVIP;

/**
 * Enumeração que representa os diferentes tipos de clientes no sistema.
 * Esta enumeração é utilizada para categorizar clientes e determinar
 * a estratégia de desconto aplicável a cada tipo de cliente.
 * Cada tipo de cliente está associado a uma implementação específica
 * da interface Discount.
 */
public enum CustomerType {
    /**
     * Representa um cliente regular ou padrão.
     * Este tipo é atribuído a novos clientes ou aqueles sem status especial.
     * Utiliza a estratégia de desconto DiscountRegular.
     */
    REGULAR(new DiscountRegular()),

    /**
     * Representa um cliente premium.
     * Clientes premium têm acesso a benefícios adicionais e descontos
     * mais vantajosos em comparação com clientes regulares.
     * Utiliza a estratégia de desconto DiscountPremium.
     */
    PREMIUM(new DiscountPremium()),

    /**
     * Representa um cliente VIP (Very Important Person).
     * Clientes VIP recebem o mais alto nível de serviço e os melhores
     * descontos disponíveis no sistema.
     * Utiliza a estratégia de desconto DiscountVIP.
     */
    VIP(new DiscountVIP());

    private final Discount discount;
    
    /**
     * Construtor privado para associar cada tipo de cliente
     * a sua respectiva estratégia de desconto.
     *
     * @param discount A estratégia de desconto associada ao tipo de cliente.
     */
    CustomerType(Discount discount) {
        this.discount = discount;
    }

    /**
     * Retorna a estratégia de desconto associada ao tipo de cliente.
     *
     * @return A implementação de Discount correspondente ao tipo de cliente.
     */
    public Discount getDiscount() {
        return discount;
    }
}