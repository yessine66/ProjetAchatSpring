package tn.esprit.rh.achat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OperateurServiceImplMockTest {

    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurService;

    Operateur op = Operateur.builder().nom("op00NomTestM").prenom("op00PrenomTestM").password("op00PassTestM").build();

   /* List<Operateur> operateurList = new ArrayList<Operateur>(){
        {
            add(Operateur.builder().nom("op11NomTest").prenom("op11PrenomTest").password("op11PassTest").build());
            add(Operateur.builder().nom("op22NomTest").prenom("op22PrenomTest").password("op22PassTest").build());
        }
    };

    */

    @Test
     void testMockRetrieveOperateur(){

        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
        Operateur opx = operateurService.retrieveOperateur(0L);
        Assertions.assertNotNull(opx);
    }

    @Test
    void testMockAddOperateur() {
        Mockito.when(operateurRepository.save(op)).thenReturn(op);
        Operateur opx = operateurService.addOperateur(op);
        Assertions.assertSame(opx,op);
        Mockito.verify(operateurRepository).save(op);
    }

    @Test
    void testMockDeleteOperateur(){
        //Operateur oppa = new Operateur((long) 9, "testMOpNomD", "testMOpPrenomD", "testMOpPassD");

        /*Operateur oppa = Operateur.builder().nom("op00NomTestM").prenom("op00PrenomTestM").
                password("op00PassTestM").build();
        */
        /*
        Operateur oppa = Operateur.builder().idOperateur((long) 9).nom("testMOpNomD").prenom("testMOpPrenomD").
                password("op00PassTestM").build();


        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(oppa));
        Operateur opx = operateurService.retrieveOperateur((long) 9);
        Mockito.verify(operateurRepository).deleteById(oppa.getIdOperateur());
        */

        Mockito.lenient().when(operateurRepository.findById(op.getIdOperateur())).thenReturn(Optional.of(op));
        operateurService.deleteOperateur(op.getIdOperateur());
        Mockito.verify(operateurRepository).deleteById(op.getIdOperateur());

    }

    @Test
    void testMockUpdateOperateur() {

        Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(op);
        op.setNom("op00NomTestM");
        Operateur opx = operateurService.updateOperateur(op);
        Assertions.assertEquals(opx.getNom(), op.getNom());


    }



}
