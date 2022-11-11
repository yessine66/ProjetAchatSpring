package tn.esprit.rh.achat;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperateurServiceImplTest  {


    @Autowired
    IOperateurService operateurService;


    @Test
    @Order(1)
    void testRetrieveAllOperateurs() {
        List<Operateur> listOp = operateurService.retrieveAllOperateurs();
        Assertions.assertEquals(0,listOp.size());
    }

/*
    Operateur addOperateur(Operateur o) {
        return null;
    }


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
