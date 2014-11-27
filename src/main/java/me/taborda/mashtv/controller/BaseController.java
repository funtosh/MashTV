package me.taborda.mashtv.controller ;

import javax.servlet.http.HttpServletResponse ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.web.bind.annotation.ControllerAdvice ;
import org.springframework.web.bind.annotation.ExceptionHandler ;
import org.springframework.web.bind.annotation.ResponseBody ;

@ControllerAdvice
public class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class) ;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Exception handleException(final Exception e, final HttpServletResponse response) {
        LOG.error(e.getMessage(), e) ;
        //        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage()) ;
        return e ;
    }
}