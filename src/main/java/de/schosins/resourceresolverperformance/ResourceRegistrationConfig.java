package de.schosins.resourceresolverperformance;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

/**
 * Not used in this application, but such a configuration solves the performance problem caused by Spring's default configuration when using Thymeleaf and enabled resource chain.
 * 
 * @see {@link ConditionalOnEnabledResourceChain}
 * @see {@link ThymeleafAutoConfiguration ThymeleafWebMvcConfiguration#resourceUrlEncodingFilter}
 * 
 * @author Ken Schosinsky
 */
@Profile("fix")
public class ResourceRegistrationConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());

        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}
