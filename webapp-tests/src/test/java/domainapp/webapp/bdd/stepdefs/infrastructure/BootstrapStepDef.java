package domainapp.webapp.bdd.stepdefs.infrastructure;

import org.apache.isis.applib.annotation.PriorityPrecedence;

import domainapp.webapp.bdd.CucumberTestAbstract;

public class BootstrapStepDef extends CucumberTestAbstract {

    @io.cucumber.java.Before(order= PriorityPrecedence.FIRST)
    public void bootstrap() {
        // empty
    }

}
