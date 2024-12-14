package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after;

/**
 * Representa um endereço com informações de rua, cidade e país.
 * Esta classe é utilizada para armazenar detalhes de localização,
 * possivelmente para fins de entrega ou faturamento.
 */
public class Address {
    
    // Atributos privados para encapsular os dados do endereço
    private String street;  // Armazena o nome da rua
    private String city;    // Armazena o nome da cidade
    private String country; // Armazena o nome do país

    /**
     * Obtém o nome da rua do endereço.
     *
     * @return Uma String representando o nome da rua.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Define o nome da rua do endereço.
     *
     * @param street Uma String com o novo nome da rua.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Obtém o nome da cidade do endereço.
     *
     * @return Uma String representando o nome da cidade.
     */
    public String getCity() {
        return city;
    }

    /**
     * Define o nome da cidade do endereço.
     *
     * @param city Uma String com o novo nome da cidade.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Obtém o nome do país do endereço.
     *
     * @return Uma String representando o nome do país.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define o nome do país do endereço.
     *
     * @param country Uma String com o novo nome do país.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}