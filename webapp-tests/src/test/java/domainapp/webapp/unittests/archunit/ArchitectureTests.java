package domainapp.webapp.unittests.archunit;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaAnnotation;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import org.apache.commons.math3.geometry.spherical.oned.Arc;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.persistence.jpa.applib.integration.IsisEntityListener;

import domainapp.modules.simple.SimpleModule;
import domainapp.webapp.SimpleApp;

@AnalyzeClasses(
        packagesOf = {SimpleModule.class, SimpleApp.class},
        importOptions = {
                ImportOption.DoNotIncludeTests.class
        })
public class ArchitectureTests {

    @ArchTest
    static ArchRule package_dependencies =
            layeredArchitecture()
                    .layer("simple module").definedBy("domainapp.modules.simple..")
                    .layer("webapp").definedBy("domainapp.webapp..")
            .whereLayer("simple module").mayOnlyBeAccessedByLayers("webapp");

//    @ArchTest
//    static ArchRule classes_annotated_with_PersistenceCapable_are_also_annotated_with_DomainObject =
//            classes()
//                   .that().areAnnotatedWith(PersistenceCapable.class)
//            .should().beAnnotatedWith(DomainObject.class);

//    @ArchTest
//    static ArchRule classes_annotated_with_PersistenceCapable_are_also_annotated_with_XmlJavaTypeAdapter =
//            classes()
//                   .that().areAnnotatedWith(PersistenceCapable.class)
//            .should().beAnnotatedWith(XmlJavaTypeAdapter.class);

    @ArchTest
    static ArchRule classes_annotated_with_Entity_are_also_annotated_with_EntityListeners =
            classes()
                   .that().areAnnotatedWith(Entity.class)
            .should().beAnnotatedWith(EntityListeners.class);

    @ArchTest
    static ArchRule classes_annotated_with_DomainObject_are_also_annotated_with_DomainObjectLayout =
            classes()
                   .that().areAnnotatedWith(DomainObject.class)
            .should().beAnnotatedWith(DomainObjectLayout.class);

}
