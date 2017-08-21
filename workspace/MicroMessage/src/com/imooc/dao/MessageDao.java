package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;


/*
 * 和message表相关的数据库操作
 */
public class MessageDao {
	
	/*
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command,String description){
		DBAccess dbAccess = new DBAccess();
		List<Message>messageList =new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			//通过SqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}	
		}
		return messageList;
	}
	
	public static void main(String[] args) {
		MessageDao messageDao=new MessageDao();
		messageDao.queryMessageList("", "");
		Map<String,Message> messageMap = new HashMap<String,Message>();
		messageMap.put("key", new Message());
		Logger log = null;
		log.debug("a");
		log.info("b");
		log.warn("c");
		log.error("d");
	}
	
	
	/*
	 * 根据查询条件查询消息列表
	 */
//	public List<Message> queryMessageList(String command,String description){
//		List<Message>messageList =new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","yang","0000");
//			StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String> paramList=new ArrayList<String>();
//			if(command!=null &&!"".equals(command.trim())){
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if(description!=null &&!"".equals(description.trim())){
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			for(int i=0;i< paramList.size();i++){
//				statement.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()){
//				Message message =new Message();
//				messageList.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
