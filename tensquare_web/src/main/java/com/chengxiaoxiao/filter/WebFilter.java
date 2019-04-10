package com.chengxiaoxiao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WebFilter
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-04-10
 */
@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("经过了过滤器....");
        return null;
    }
}
