package domainapp.modules.simple.mixins;

import org.springframework.stereotype.Component;

import org.apache.isis.applib.annotation.Property;

import domainapp.modules.simple.dom.so.SimpleObject;

/*
 * ISIS-1628: the @Property mixin annotation of the abstract super class is ignored and
 * needs to be duplicated on the concrete sub class.
 *
 * To replicate the problem remove this annotation and see how the contribution disappears from the UI.
 */
@Component
public class SimpleObject_numberOfChildren extends Collection_count {

	public SimpleObject_numberOfChildren(SimpleObject simpleObject) {
		super(simpleObject.getChildren());
	}

}
