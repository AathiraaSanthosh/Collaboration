package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.Job;

public class JobDAOImpl implements JobDAO
{

	@Autowired
	SessionFactory sessionFactory;
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean createJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(job);
		    return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	@Override
	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getJobs()
	{
	
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job where status='A'");
		List<Job> listjob=query.list();
		session.close();
		return listjob;
	}
		
		
	
    @Transactional
	@Override
	public boolean approveJob(Job job) 
    {
    	try
		{
			job.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(job);
		    return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
    	
    	
    	
	}

	@Override
	public boolean editJob(int jobid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean deleteJob(int jobid)
	{
		try
    	{
    		Session session=sessionFactory.openSession();
    		Job job=(Job)session.get(Job.class,jobid);
    		session.delete(job);
    		session.flush();
    		session.close();
    		return true;
    	}
		catch(Exception e)
    	{
			System.out.println("Exception Arised:"+e);
                    	
		return false;
		
	}

}}
