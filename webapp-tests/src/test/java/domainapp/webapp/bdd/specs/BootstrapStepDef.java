package domainapp.webapp.bdd.specs;

import org.apache.isis.applib.annotation.PriorityPrecedence;

public class BootstrapStepDef extends CucumberTestAbstract {

    @io.cucumber.java.Before(order= PriorityPrecedence.FIRST)
    public void bootstrap() {
        // empty
    }

}
