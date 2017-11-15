package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TUserDAO;
import com.dao.TXiangmuDAO;
import com.model.TAdmin;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class loginService
{
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;
	private TXiangmuDAO xiangmuDAO;
	
	public TXiangmuDAO getXiangmuDAO() {
		return xiangmuDAO;
	}
	public void setXiangmuDAO(TXiangmuDAO xiangmuDAO) {
		this.xiangmuDAO = xiangmuDAO;
	}
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	
	
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)
		{
			
		}
		if(userType==2)
		{
			
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
	
    public String jiance(String userName)
    {
    	System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="from TUser where userName='"+userName+"'";
		List list=userDAO.getHibernateTemplate().find(sql);
		if(list.size()>0)
		{
			return "no";
		}
		else
		{
			return "yes";
		}
    }
    
    public List xiangmuSelect()
	{
		String sql="from TXiangmu where del='no'";
		List xiangmuList =xiangmuDAO.getHibernateTemplate().find(sql);
		
		return xiangmuList;
		
	}
    
    
    
}
