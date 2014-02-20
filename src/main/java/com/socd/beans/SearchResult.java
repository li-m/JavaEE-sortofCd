package com.socd.beans;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.socd.dbconn.Mysql_connection;


public class SearchResult {
private List<Cd> cdlist=new ArrayList<Cd>();
private String type;
private String keyWord;
private Mysql_connection con;
private Cd cd;
public  SearchResult(SearchContent searchContent) throws Exception
{
	con = new Mysql_connection();	
	type=searchContent.getType();	
	keyWord=searchContent.getKeyWord();	
	if(type!=null && keyWord!=null){
	if(type.equals("ID")){		
		ResultSet rs = con.queryTable("select * from cd where id='"+keyWord+"'");
	    while (rs.next()) {	
	    	cd=new Cd();
	    	cd.setId(Integer.parseInt(rs.getString("id")));
	    	cd.setName(rs.getString("name")); 
	    	cd.setCategory(rs.getString("category"));
	    	cd.setAuthor(rs.getString("author"));
	    	cdlist.add(cd);			    	
	    }
	}
	if(type.equals("Author")){		
		ResultSet rs = con.queryTable("select * from cd where author='"+keyWord+"'");
	    while (rs.next()) {	
	    	cd=new Cd();
	    	cd.setId(Integer.parseInt(rs.getString("id")));
	    	cd.setName(rs.getString("name")); 
	    	cd.setCategory(rs.getString("category"));
	    	cd.setAuthor(rs.getString("author"));
	    	cdlist.add(cd);			    	
	    }
	}
	if(type.equals("Category")){		
		ResultSet rs = con.queryTable("select * from cd where category='"+keyWord+"'");
	    while (rs.next()) {	
	    	cd=new Cd();
	    	cd.setId(Integer.parseInt(rs.getString("id")));
	    	cd.setName(rs.getString("name")); 
	    	cd.setCategory(rs.getString("category"));
	    	cd.setAuthor(rs.getString("author"));
	    	cdlist.add(cd);			    	
	    }
	}
	
	}
	
}

public List<Cd> getCdlist() {
	return cdlist;
}
}
