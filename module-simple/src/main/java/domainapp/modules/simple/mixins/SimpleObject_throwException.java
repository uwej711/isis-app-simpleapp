package domainapp.modules.simple.mixins;

import org.springframework.stereotype.Component;

import org.apache.isis.applib.annotation.Action;

import lombok.RequiredArgsConstructor;

import domainapp.modules.simple.dom.so.SimpleObject;

@Component
@Action()
@RequiredArgsConstructor
public class SimpleObject_throwException {

	private final SimpleObject simpleObject;

	public void act(String errorText) {
		throw new RuntimeException(errorText);
	}
}
