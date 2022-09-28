package domainapp.modules.simple.dom.so;

import domainapp.modules.simple.SimpleModule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.ObjectSupport;
import org.apache.isis.applib.annotation.Property;

import javax.inject.Named;
import java.time.LocalDate;

@DomainObject(nature = Nature.VIEW_MODEL)
@Named(SimpleModule.NAMESPACE + ".SimpleVM")
@NoArgsConstructor
public class SimpleVM {

    public SimpleVM(SimpleObject object, LocalDate date, String name){
        this.object = object;
        this.someDate = date;
        this.name = name;
    }

    @ObjectSupport
    public String title(){
        return "Simple viewmodel";
    }

    @Property
    @Getter @Setter
    private SimpleObject object;

    @Property
    @Getter @Setter
    private LocalDate someDate;

    @Property
    @Getter @Setter
    private String name;


}
