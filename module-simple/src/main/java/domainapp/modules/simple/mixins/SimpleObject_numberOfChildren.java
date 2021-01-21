package domainapp.modules.simple.mixins;

import org.springframework.stereotype.Component;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;

import domainapp.modules.simple.dom.so.SimpleObject;

/*
 * ISIS-1628: the @Property mixin annotation of the abstract super class is ignored and
 * needs to be duplicated on the concrete sub class.
 *
 * To replicate the problem remove this annotation and see how the contribution disappears from the UI.
 */
@Component
@Property(domainEvent = Collection_count.PropertyEvent.class)
@PropertyLayout(describedAs = "Number of items in the collection")
public class SimpleObject_numberOfChildren extends Collection_count {

	public SimpleObject_numberOfChildren(SimpleObject simpleObject) {
		super(simpleObject.getChildren());
	}

}
