# ResourceUrlEncodingFilterPerformance

Simple demo application showcasing the performance impact of ResourceUrlEncodingFilter when processing URLs using HttpServletResponse#encodeURL.

Just run the tests or start the application and navigate to http://localhost:8080/?links=1. Increase the value of 'links' and observe the CPU impact.

When using Thymeleaf with enabled ResourceUrlEncodingFilter, this happends for every usage of @{...} to build URLs.