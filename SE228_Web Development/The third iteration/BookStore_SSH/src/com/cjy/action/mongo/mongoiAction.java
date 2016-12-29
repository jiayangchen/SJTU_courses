package com.cjy.action.mongo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.mongodb.gridfs.GridFSInputFile;
import com.mongodb.util.JSON;
import com.opensymphony.xwork2.ActionContext;

public class mongoiAction {
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	public void mongoI() throws IOException
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		key = (String) request.getParameter("key");
		value = (String) request.getParameter("value");	
		System.out.println(key+" "+value);

		//连接MongoDB
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("local");		
		//DBCollection collection = db.getCollection("User");
		
		String newFileName ="mkyong-java-image";
		File imageFile =new File("c:\\JavaWebHosting.png");
		GridFS gfsPhoto =new GridFS(db, "photo");
		GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
		gfsFile.setFilename(newFileName);
		gfsFile.save();
		/*BasicDBObject document = new BasicDBObject();
		document.put("userid",2);
		document.put("username","5140379040");
		
		BasicDBObject documentDetail = new BasicDBObject();
		
		documentDetail.put("photoURL", "url");
		documentDetail.put("phone", "13372130382");
		
		//document.put(key, value);
		document.put("detail", documentDetail);
		
		collection.insert(document);*/

		out.print("插入成功");

		/*BasicDBObject searchQuery = new BasicDBObject();		
        searchQuery.put("userid",2);
        DBCursor cursor = collection.find(searchQuery);
		while(cursor.hasNext()){
			System.out.println(cursor.next());
			out.println(cursor.next());
		}*/
	}
}
