package com.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCepingDAO;
import com.dao.TUserDAO;
import com.model.TCeping;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ComparatorUser;

public class UserAction extends ActionSupport
{
    private int userId;
	private String userName;
	private String userPw;
	private String userRealname;
	
	private String userAddress;
	private String userSex;
	private String userTel;
	private String userEmail;
	
	private String newDel;
   
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	private TCepingDAO cepingDAO;
	
	
	public String userReg()
	{
		TUser user=new TUser();
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserSex(userSex);
		user.setUserDel("no");
		userDAO.save(user);
		
		
		this.setMessage("注册成功，请登陆");
		this.setPath("qiantai/default.jsp");
		return "succeed";
	}
	
	
	
	public String userEdit()
	{
		TUser user=userDAO.findById(userId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserSex(userSex);
		user.setUserDel("no");
		userDAO.attachDirty(user);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功，重新登录后生效");
		return "msg";
	}
	
	
	public String userLogin()
	{
		String sql="from TUser where userName=? and userPw=?";
		Object[] con={userName,userPw};
		List userList=userDAO.getHibernateTemplate().find(sql,con);
		if(userList.size()==0)
		{
			this.setMessage("用户名或密码错误");
			this.setPath("qiantai/default.jsp");
		}
		else
		{
			 Map session= ServletActionContext.getContext().getSession();
			 TUser user=(TUser)userList.get(0);
			 session.put("user", user);
			 session.put("userType", 1);
			 this.setMessage("成功登录");
			 this.setPath("qiantai/default.jsp");
		}
		return "succeed";
	}
	
	
	public String userLogout()
	{
		Map session= ServletActionContext.getContext().getSession();
		session.remove("user");
		session.remove("userType");
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	public String userXinxi()
	{
		TUser user=userDAO.findById(userId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userMana()
	{
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public String userLianghua()
	{
		
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<userList.size();i++)
		{
			TUser user=(TUser)userList.get(i);
			int userId=user.getUserId();
			user.setZongfen(get_fen(userId));
		}
		
		ComparatorUser comparator = new ComparatorUser();
		Collections.sort(userList, comparator);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userRes()
	{
		String sql="from TUser where userDel='no' and userRealname like '%"+userRealname.trim()+"%'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public int get_fen(int userId)
	{
		int jj=0;
		
		String sql="from TCeping where userId="+userId;
		List cepingList =cepingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cepingList.size();i++)
		{
			TCeping ceping=(TCeping)cepingList.get(i);
			jj=jj+ceping.getFenzhi();
		}
		
		return jj;
	}
	
	
	public String getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public TCepingDAO getCepingDAO() {
		return cepingDAO;
	}



	public void setCepingDAO(TCepingDAO cepingDAO) {
		this.cepingDAO = cepingDAO;
	}



	public String getUserRealname()
	{
		return userRealname;
	}

	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}

	public String getUserSex()
	{
		return userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getUserTel()
	{
		return userTel;
	}

	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

	public int getUserId()
	{
		return userId;
	}


	public String getNewDel()
	{
		return newDel;
	}
	public void setNewDel(String newDel)
	{
		this.newDel = newDel;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}


	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}




	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	
}
