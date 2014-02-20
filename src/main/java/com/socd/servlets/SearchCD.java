package com.socd.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socd.beans.*;
import com.socd.forms.SearchForm;


public class SearchCD extends HttpServlet {
    public static final String ATT_CONTENT = "searchContent";
    public static final String ATT_FORM    = "searchForm";
    
    public static final String VIEW_SEARCH = "/WEB-INF/search.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	List<Cd> cdlist=null;
        SearchForm searchForm = new SearchForm();
        SearchContent searchContent = searchForm.genSearch( request );
        try {
			SearchResult searchResult = new SearchResult( searchContent );
			cdlist=searchResult.getCdlist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute( ATT_CONTENT, searchContent );
        request.setAttribute( ATT_FORM, searchForm );
        request.setAttribute( "SearchResult", cdlist );
                  
        this.getServletContext().getRequestDispatcher( VIEW_SEARCH ).forward( request, response );
              
        
    }

}
