package com.cjy.action.mongo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.opensymphony.xwork2.ActionContext;

public class mongosAction {
	
	public void mongoS() throws IOException
	{
		try{
			
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("local");	
		
		String newFileName ="mkyong-java-image";
		GridFS gfsPhoto =new GridFS(db, "photo");
		GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
		System.out.println(imageForOutput);
		out.println(imageForOutput);
		
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
	}
}
