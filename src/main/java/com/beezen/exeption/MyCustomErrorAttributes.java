package com.beezen.exeption;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//
//
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyCustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);

        Throwable throwable = getError(requestAttributes);
        
        if(throwable!=null) {
        	  if(throwable instanceof CustomException){
              	Object[] para = ((CustomException)throwable).getParas();
              	  Map<String, Object> causeErrorAttributes = new HashMap<>();
                    causeErrorAttributes.put("message", throwable.getMessage());
                    causeErrorAttributes.put("params", para);
                    errorAttributes.put("customException", causeErrorAttributes);
              }
              
              Throwable cause = throwable.getCause();
              
              if (cause != null) {
                  Map<String, Object> causeErrorAttributes = new HashMap<>();
                  causeErrorAttributes.put("exception", cause.getClass().getName());
                  causeErrorAttributes.put("message", cause.getMessage());
                  errorAttributes.put("cause", causeErrorAttributes);
              }
        }
        
      
        return errorAttributes;
    }
}