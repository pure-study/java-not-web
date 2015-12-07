package net.will.javatest.utilstest.beanutils;

public class Product extends AbsBaseObject {
    private String name;
    private Double price;
    private Provider provider;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Provider getProvider() {
        return provider;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
