package com.healthmetrics.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Helper class used to get internationalized messages from resource bundles.
 * 
 * @author Gonzalo
 *
 */
@Component
public class MessageHelper {

	@Autowired
	private MessageSource messageSource;

	/**
	 * Gets a simple message from the resource bundle.
	 *
	 * @param key
	 *            Key of the message.
	 * @return Text of the message.
	 */
	public String getMessage(String key) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}

	/**
	 * Gets a message from the resource bundle adding the received parameters.
	 *
	 * @param key
	 *            Key of the message.
	 * @param params
	 *            Parameters to substitute in the message.
	 * @return Text of the message.
	 */
	public String getMessageWithParams(String key, Object[] params) {
		return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
	}

}
