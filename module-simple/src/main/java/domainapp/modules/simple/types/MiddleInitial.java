package domainapp.modules.simple.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;

@Name
@Property(optionality = Optionality.OPTIONAL, maxLength = MiddleInitial.MAX_LEN)
@Parameter(optionality = Optionality.OPTIONAL, maxLength = MiddleInitial.MAX_LEN)
@PropertyLayout(named = "Middle initial")
@ParameterLayout(named = "Middle initial")
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MiddleInitial {

    int MAX_LEN = 1;
}
