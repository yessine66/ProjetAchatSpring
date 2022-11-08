package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
public class ProduitServiceImplTest {
    @Autowired
    ProduitServiceImpl ProduitService;

    @Test
    public void testAddProduit() {
        Produit p = new Produit();

        p.setCodeProduit("Test_Code");
        p.setLibelleProduit("produit test 1");


        Produit savedProduit = ProduitService.addProduit(p);
    }
}
