package pl.coderslab.jeeusercrud;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "Utf8Filter", value = "/*")
public class Utf8Filter implements Filter {
    private String charsetEncoding = "utf-8";
    private String contentType = "text/html";
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(charsetEncoding);
        response.setContentType(contentType);
        response.setCharacterEncoding(charsetEncoding);
        chain.doFilter(request, response);
    }
}