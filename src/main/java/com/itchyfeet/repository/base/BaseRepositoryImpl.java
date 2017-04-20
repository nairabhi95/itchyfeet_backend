package com.itchyfeet.repository.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.itchyfeet.model.User;

public abstract class BaseRepositoryImpl implements BaseRepository {

	private SessionFactory sessionFactory;

	  public void setSessionFactory(final SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	  }

	  protected Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }
	  
	  public int create(User entity) {		 
		 // entity.convertFlexDatesToUTC();
		  return (Integer)getSession().save(entity);	  
	  }
	  
	  /*public void update(BaseModel entity) {		
		  entity.convertFlexDatesToUTC();		  
		  getSession().saveOrUpdate(entity);
	  }
	  
	  public BaseModel findById(Class clazz, Integer id) {
		  return (BaseModel)getSession().get(clazz, id);
	  }
	  
	  public void initialize(Object obj) {
		  if (obj != null)
		  Hibernate.initialize(obj);
	  }
	  
	  public List<Integer> getUserIdList(int[] userIds) {
		ArrayList list = new ArrayList(userIds.length);
		for (int id : userIds) {
			list.add(id);
		}
		
		return list;
	  }
	  public List<Integer> getIntegerArray(String str) {
			List<String> stringArray = new ArrayList<String>(Arrays.asList(str.split(",")));
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for(String stringValue : stringArray) {
	            try {
	            	list.add(Integer.parseInt(stringValue));
	            } catch(NumberFormatException nfe) {
	               System.out.println("Could not parse " + nfe);
	            } 
	        }       
	        return list;
	  }
	  public void remove(Collection entities) {
		  Session session = getSession();
		  if (entities != null) {
			  Iterator itr = entities.iterator();
			  while (itr.hasNext()) {
				  session.delete(itr.next());
			  }
		  }
	  }
	  
	  public void remove(BaseModel model) {
		  Session session = getSession();
		  if (model != null) {
			  session.delete(model);
		  }
	  }
	                                                                                    
	  public void detach(BaseModel model) {
		  Session session = getSession();
		  if (model != null) {
			  session.evict(model);
		  }
	  }
	
	*//**
	 * overide in Entity specific repo layer if requred by calling
	 * getNextLogicalKey method in Base repo
	 *//*
	
	public String getNextLogicalKey(int logicalKeyId, String prefix) {
		if (logicalKeyId != 0) {
			Integer id = getNextLogicalKey(logicalKeyId);
			if (prefix != null) {
				return prefix.concat(id.toString());
			} else {
				return id.toString();
			}
		} else {
			*//**
			 * if Logical key is not setup it will crate a external id as before
			 *//*
			User user = UserContext.getUser();
			String extId = user.getExternalId();
			extId = extId.length() > 7 ? extId.substring(0, 7) : extId;
			return extId + "-" + DateUtil.getCurrentDateInNumbers();

		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int getNextLogicalKey(int logicalKeyID) {
		Integer id = (Integer) getSession()
				.createSQLQuery("SELECT getSeq(:logicalKeyID) FROM DUAL")
				.setInteger("logicalKeyID", logicalKeyID).uniqueResult();
		return id;
	}
	
	@Transactional
	public int getTimeId(Date date) {		
		return (Integer) getSession().createSQLQuery("SELECT time_id FROM time_by_day WHERE the_date=?").setDate(0, date).uniqueResult();
	}

	@Transactional
	public int getUTCTimeId(Date date, String timeZone) {	
		return (Integer) getSession()
				.createSQLQuery(
						"SELECT time_id FROM time_by_day WHERE the_date=DATE(CONVERT_TZ(?,'Asia/Calcutta',IFNULL(?, 'Asia/Calcutta')))")
				.setDate(0, date).setString(1, timeZone).uniqueResult();
	}
	
	public void merge(BaseModel entity) {			  
		  getSession().merge(entity);
	  }*/
	
}
