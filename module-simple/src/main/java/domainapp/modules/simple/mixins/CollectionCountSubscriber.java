package domainapp.modules.simple.mixins;

import javax.inject.Inject;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.apache.isis.applib.Identifier;
import org.apache.isis.applib.services.title.TitleService;

import domainapp.modules.simple.dom.so.SimpleObject;

/*
 * ISIS-1628: the @Property mixin annotation of the abstract super class is ignored and
 * needs to be duplicated on the concrete sub class.
 *
 * To replicate the problem remove this annotation and see how the contribution disappears from the UI.
 */
@Component
public class CollectionCountSubscriber {

	@EventListener(Collection_count.PropertyEvent.class)
	public void on(Collection_count.PropertyEvent ev) {

		final Object subject = ev.getSubject();
		final Identifier identifier = ev.getIdentifier();
		System.err.printf("%s collection '%s' now contains %d elements%n",
				titleService.titleOf(subject),
				identifier.getMemberName(),
				ev.getNewValue());
	}

	@Inject TitleService titleService;
}
