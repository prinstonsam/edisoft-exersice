package com.prinstonsam.edisoft.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by samsik on 14.03.16.
 */
public class CharsetFilter implements Filter{
    // кодировка
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        // читаем из конфигурации
        encoding = config.getInitParameter("requestEncoding");

        if (encoding == null)
            encoding = "utf-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}
