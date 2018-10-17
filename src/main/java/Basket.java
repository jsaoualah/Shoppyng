import com.google.common.base.Preconditions;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Basket {

    List<Product> productList = new ArrayList<Product>();

    /*
     *  Ajout d'un produit dans le panier
     *  @param product product : le produit
     */
    public void addProduct(Product product) {

        Preconditions.checkArgument(product != null);
        productList.add(product);

    }


    /*
     *  Suppression d'un produit du panier
     *  @param String libelle : le libelle du produit a supprimer
     */
    public void deleteProduct(String libelle){

         Preconditions.checkArgument(libelle != null);
         for (Iterator<Product> i = productList.iterator(); i.hasNext();) {
             Product p = i.next();
             if (p.getLibelle().equals(libelle)) {
                 i.remove();
             }
         }
     }


    /*
     *  Affichage de la liste des produits du panier
     */
    public List<Product> listProducts() {
        return productList;
    }


    /*
     *  Le montant total des prix des produits du panier
     */
     public Integer totalAmount() {
        return productList.stream().map(Product::getPrice).reduce(0, Integer::sum);
     }

}
