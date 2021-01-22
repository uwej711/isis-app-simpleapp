package domainapp.modules.simple.dom.so;

abstract class HasName {

    public abstract String getName();
    
    public String title() {
        return "Name: " + getName();
    }
    
}
