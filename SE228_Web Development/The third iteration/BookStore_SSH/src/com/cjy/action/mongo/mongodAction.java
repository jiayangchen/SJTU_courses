package com.cjy.action.mongo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.opensymphony.xwork2.ActionContext;

public class mongodAction {
	public void mongoD() throws IOException
	{
		try{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("local");
		String newFileName ="mkyong-java-image";
		GridFS gfsPhoto =new GridFS(db, "photo");
		gfsPhoto.remove(gfsPhoto.findOne(newFileName));
		System.out.println("删除成功");
		out.print("删除成功");
		
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
	}
}
