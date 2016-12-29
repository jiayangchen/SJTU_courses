package com.cjy.action.mongo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class mongouAction {
	public void mongoU() throws IOException
	{
		try{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("local");
		DBCollection collection = db.getCollection("User");
		
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("userid",2);
		newDocument.put("username","5140379040");
		
		BasicDBObject newdocumentDetail = new BasicDBObject();
		
		newdocumentDetail.put("photoURL", "URL");
		newdocumentDetail.put("phone", "58607977");
		newDocument.put("deatil",newdocumentDetail);
		collection.update(new BasicDBObject().append("userid", 2), newDocument);
		
		System.out.println("更新成功");
		out.print("更新成功");
		
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
	}
}
