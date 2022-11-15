package tn.esprit.rh.achat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    Operateur op = Operateur.builder().nom("op00NomTest").prenom("op00PrenomTest").password("op00PassTest").build();

   /* List<Operateur> operateurList = new ArrayList<Operateur>(){
        {
            add(Operateur.builder().nom("op11NomTest").prenom("op11PrenomTest").password("op11PassTest").build());
            add(Operateur.builder().nom("op22NomTest").prenom("op22PrenomTest").password("op22PassTest").build());
        }
    };

    */


    @Test
     void testMockRetrieveOperateur(){
        /*Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
        Operateur opx = operateurService.retrieveOperateur(op.getIdOperateur());
        Assertions.assertNotNull(op);*/

        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
        Operateur opx = operateurService.retrieveOperateur(0L);
        Assertions.assertNotNull(opx);
    }



}
