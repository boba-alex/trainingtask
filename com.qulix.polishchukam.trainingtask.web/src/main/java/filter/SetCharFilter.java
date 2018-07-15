package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "SetCharFilter", urlPatterns = "/*")
public class SetCharFilter implements Filter {
    private FilterConfig filterConfig = null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encoding = req.getCharacterEncoding();
        if(!"UTF-8".equalsIgnoreCase(encoding)){
            resp.setCharacterEncoding("UTF-8");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

}
