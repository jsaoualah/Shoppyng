
public class Product {

    String libelle;
    Integer  price;

    Product(String libelle, Integer price){
        this.libelle = libelle;
        this.price = price;
    }

    public String getLibelle(){
        return this.libelle;
    }

    public Integer getPrice(){
        return this.price;
    }

}
