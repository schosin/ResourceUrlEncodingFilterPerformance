# ResourceUrlEncodingFilterPerformance

Simple demo application showcasing the performance impact of `ResourceUrlEncodingFilter` when processing URLs using `HttpServletResponse#encodeURL`.

Just run the tests or start the application and navigate to http://localhost:8080/?links=1. Increase the value of 'links' and observe the CPU impact.

# Workaround

Start the application with `-Dspring.profiles.active=fix`. With this profile active, the default configuration will be replaced, improving the performance significantly for pages with many links.

This is achieved by setting `spring.web.resources.add-mappings` to false and registering custom resource handlers (e.g. `/css/** -> classpath:/static/css/`), removing the need to check whether any other link passed to `HttpServletResponse#encodeURL` is a static resource.

See `ResourceRegistrationConfig` for the resource handlers.

# Details

When using Thymeleaf with enabled `ResourceUrlEncodingFilter`, this happends for every usage of @{...} to build URLs. The problem occurs when `PathResourceResolver` is checking any URL passed to `HttpServletResponse#encodeURL` against a list of possible static resources, throwing a FileNotFoundException for each miss.

See https://github.com/spring-projects/spring-framework/issues/27538
