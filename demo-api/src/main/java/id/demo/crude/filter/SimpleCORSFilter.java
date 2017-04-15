package id.demo.crude.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleCORSFilter implements Filter {

    private static final String ALLOWED_DOMAINS_REGEXP = ".*";

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String origin = request.getHeader("Origin");
        if (origin != null && origin.matches(ALLOWED_DOMAINS_REGEXP)) {
            response.addHeader("Access-Control-Allow-Origin", origin);
            if ("options".equalsIgnoreCase(request.getMethod())) {
                response.setHeader("Allow", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS");
                String headers = request.getHeader("Access-Control-Request-Headers");
                String method = request.getHeader("Access-Control-Request-Method");
                response.addHeader("Access-Control-Allow-Methods", method);
                response.addHeader("Access-Control-Allow-Headers", headers);
                // optional, only needed if you want to allow cookies.
                response.addHeader("Access-Control-Allow-Credentials", "true");
                response.setContentType("text/plain,application/txt");
                response.getWriter().flush();
                return;
            }
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}

