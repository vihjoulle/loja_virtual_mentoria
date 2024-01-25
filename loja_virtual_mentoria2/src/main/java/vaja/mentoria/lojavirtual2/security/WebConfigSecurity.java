package vaja.mentoria.lojavirtual2.security;

import java.lang.annotation.Annotation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import jakarta.servlet.http.HttpSessionListener;

@Configuration
@EnableWebSecurity
public abstract class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {


    @Override
	public
    WebConfigSecurity(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers(HttpMethod.GET, "/salvarAcesso", "/deleteAcesso")
		.requestMatchers(HttpMethod.POST, "/salvarAcesso", "/deleteAcesso");
		/*Ingnorando URL no momento para nao autenticar*/
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	
}