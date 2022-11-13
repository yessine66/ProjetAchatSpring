package tn.esprit.rh.achat;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperateurServiceImplTest  {


    @Autowired
    IOperateurService operateurService;


    @Test
    @Order(2)
    void testRetrieveAllOperateurs() {

        //Operateur op = operateurService.retrieveAllOperateurs(Operateur.builder().)


        /*List<Operateur> listOp = operateurService.retrieveAllOperateurs();
        Assertions.assertEquals(0,listOp.size());*/

        List<Operateur> listOperateurs = operateurService.retrieveAllOperateurs();
        //assertEquals(0, listOperateurs.size());
        assertNotNull(listOperateurs);

    }


    @Test
    @Order(1)
    void testAddOperateur() {
/*
        Operateur op = new Operateur();
        op.setNom("Operateur9");
        op.setPassword("secret9");
        op.setPrenom("Telecm9");
        Operateur opTest = operateurService.addOperateur(op);
        assertEquals(op.getNom(), opTest.getNom());*/

        Operateur o = operateurService.addOperateur(Operateur.builder().nom("opNomTest").
                prenom("opPrenomTest").password("opPassTest").build());
        assertNotNull(o);

    }

/*
    void deleteOperateur(Long id) {

    }


    Operateur updateOperateur(Operateur o) {
        return null;
    }


    Operateur retrieveOperateur(Long id) {
        return null;
    }
    */

}
