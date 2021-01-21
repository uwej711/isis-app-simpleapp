package domainapp.modules.simple.mixins;

import java.util.Collection;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Navigable;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.events.domain.PropertyDomainEvent;

import domainapp.modules.simple.SimpleModule;

@Action(domainEvent = Collection_count.ActionEvent.class)
@Property(domainEvent = Collection_count.PropertyEvent.class)
@PropertyLayout(describedAs = "Number of items in the collection")
public abstract class Collection_count {

	public static class ActionEvent extends ActionDomainEvent<Integer> {}
	public static class PropertyEvent extends PropertyDomainEvent<Object, Integer> {}

	private final Collection<?> collection;
	public Collection_count(Collection<?> collection) {
		super();
		this.collection = collection;

	}

	public int prop() {
		return collection.size();
	}

}
