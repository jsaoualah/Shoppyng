import org.junit.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class basketTest {

    private  Basket basket = new  Basket();


    /*
     * Vérifier que la liste des paniers est vide au début
     */
    @Test
    public void new_basket_should_be_empty() {

        List<Product> products = basket.listProducts();
        assertThat(products).isEmpty();
    }

    /*
     * Vérifier que l'ajout des produits dans la liste des produits se fait bien en affichant la liste des produits aprés l'ajout.
     * Méthode : addProduct
     */
    @Test
    public void should_add_products() {

        Product p1 = new Product("product_1", 150);
        Product p2 = new Product("product_2", 70);
        Product p3 = new Product("product_3", 10);
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);

        List<Product> listProducts = basket.listProducts();

        assertThat(listProducts).hasSize(3);
        assertThat(listProducts.get(0)).isEqualTo(p1);
        assertThat(listProducts.get(1)).isEqualTo(p2);
        assertThat(listProducts.get(2)).isEqualTo(p3);
    }


    /*
     * Vérifier que l'ajout d'un produit null dans le panier léve une exception IllegalArgumentException.
     * Méthode : deleteProduct
     */
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_if_add_null_product() {
        basket.addProduct(null);
    }

    /*
     * Vérifier que la suppression d'un produit a partir du panier se fait bien en affichant la liste des produits aprés suppression.
     * Méthode : deleteProduct
     */
    @Test
    public void should_delete_product() {
        // Given
        Product p1 = new Product("product_test", 130);
        Product p2 = new Product("product_test_to_delete", 200);
        basket.addProduct(p1);
        basket.addProduct(p2);

        // When
        basket.deleteProduct("product_test_to_delete");

        // Then
        List<Product> products = basket.listProducts();
        assertThat(products).hasSize(1);
        assertThat(products.get(0)).isEqualTo(p1);
    }

    /*
     * Vérifier que la suppression d'un produit dont le libelle est null léve une exception IllegalArgumentException.
     * Méthode : deleteProduct
     */
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_if_libelle_product_to_delete_is_null() {

        basket.deleteProduct(null);

    }

    /*
     * Vérifier le montant total des produits du panier
     * Méthode : totalAmount
     */
    @Test
    public void should_return_total_amount_of_products() {

        // Given
        Product p1 = new Product("product_1", 150);
        Product p2 = new Product("product_2", 70);
        Product p3 = new Product("product_3", 10);
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);

        // When
        Integer totalAmmount = basket.totalAmount();

        // Then
        assertThat(totalAmmount).isEqualTo(230);
    }

}