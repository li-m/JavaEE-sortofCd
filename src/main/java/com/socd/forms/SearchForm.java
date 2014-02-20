package com.socd.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.socd.beans.SearchContent;

public class SearchForm {
    private static String       INPUT_TYPE    = "searchType";
    private static String       INPUT_KEYWORD = "searchKeyWord";

    private Map<String, String> errors        = new HashMap<String, String>();
    private String              validation    = null;

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getValidation() {
        return validation;
    }

    public SearchContent genSearch( HttpServletRequest request ) {
        String type = getInputValue( request, INPUT_TYPE );
        String keyWord = getInputValue( request, INPUT_KEYWORD );

        SearchContent searchContent = new SearchContent();

               
        try {
			if(typeValidation( type )){
				searchContent.setType( type );
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        searchContent.setKeyWord( keyWord );

        if ( type == null || keyWord == null ) {
            validation = "Empty";
        } else if ( errors.isEmpty() ) {
            validation = "Validated";
        } else {
            validation = "Error";
        }

        return searchContent;
    }

    private static String getInputValue( HttpServletRequest request, String inputName ) {
        String value = request.getParameter( inputName );
        return value;
       /* if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value;
        }*/        
    }

    private void setError( String input, String message ) {
        errors.put( input, message );
    }

    private boolean typeValidation( String type ) throws Exception {
    	if(type!=null){
                                         
                if ( type.equals("ID") || type.equals("Author") || type.equals("Category") || type.equals("Song")) {
                    return true;
                } 
                else
                	return false;
    	}
    	else
    		return false;
                
    }

    
}