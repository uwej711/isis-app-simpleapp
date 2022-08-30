package domainapp.webapp.bdd.specs;

import javax.inject.Inject;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import org.apache.isis.applib.annotation.PriorityPrecedence;
import org.apache.isis.applib.services.iactnlayer.InteractionContext;
import org.apache.isis.applib.services.iactnlayer.InteractionService;
import org.apache.isis.applib.services.user.UserMemento;

import lombok.val;

/**
 * equivalent to the Spring @Transactional attribute
 */
public class TransactionalStepDef {

    private Runnable afterScenario;

    @io.cucumber.java.Before(order = PriorityPrecedence.EARLY)
    public void beforeScenario(){

        //open InteractionSession to be closed after scenario (see below)
        interactionService.openInteraction(InteractionContext.ofUserWithSystemDefaults(UserMemento.ofName("initialization")));

        val txTemplate = new TransactionTemplate(txMan);
        val status = txTemplate.getTransactionManager().getTransaction(null);
        afterScenario = () -> {
            txTemplate.getTransactionManager().rollback(status);
            interactionService.closeInteractionLayers();
        };

        status.flush();
    }

    @io.cucumber.java.After
    public void afterScenario(){
        if(afterScenario==null) {
            return;
        }
        afterScenario.run();
        afterScenario = null;
    }

    @Inject private InteractionService interactionService;
    @Inject private PlatformTransactionManager txMan;

}
