package com.user.core.userManagement.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author @Sonu Kumar Sinha
 *
 */
@Configuration
public class LocaleConfiguration implements WebMvcConfigurer{

	/**
	 * LocaleResolver Bean determines the current Locale based on
	 * session, cookies or accept-language-Header, It can be SessionLocaleResolver 
	 * AcceptHeaderLocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return acceptHeaderLocaleResolver;
	}
	
	/**
	 * LocaleChangeInterceptor is required to switch to a new Locale
	 * based on language parameter appended to request
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor);
	}
	
	/**
	 * MessageSource is used for resolving messages, with support for the parameterization and 
	 * internationalization of the messages. Spring contains two built-in MessageSource implementations: 
	 * ResourceBundleMessageSource and ReloadableResourceBundleMessageSource. The latter is able to reload 
	 * message definitions without restarting the Virtual Machine
	 */
	@Bean("messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		return messageSource;
	}
	
	/**
	 * To Override the JSR-303 Normal Validation Error Messages
	 */
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
}
