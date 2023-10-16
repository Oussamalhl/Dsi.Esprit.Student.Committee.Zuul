package org.zuul.Config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(this.getClass());



    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //getting the current HTTP request that is to be handled
        HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
        //printing the detail of the request
        logger.info("request -> {} request uri-> {}", request, request.getRequestURI());
        return null;
    }
}
