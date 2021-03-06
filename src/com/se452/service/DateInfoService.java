package com.se452.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.AppUser;
import com.se452.model.DateInfo;
import com.se452.model.DateInfoId;
import com.se452.model.Status;

public class DateInfoService implements DateInfoServiceInterface{
	EntityManager manager;
	
	public DateInfoService(){
		manager = Persistence.createEntityManagerFactory("SE452EclipseLink2").createEntityManager();
	}
	
	@Override
	public void createDate(AppUser matchMaker, AppUser user1, AppUser user2, Date dateTime, String location, String description) {
		manager.getTransaction().begin();
		DateInfo date = new DateInfo ();
		date.setMatchMakerId(matchMaker);
		date.setUser1Id(user1);
		date.setUser2Id(user2);
		date.setLocation(location);
		date.setDescription(description);
		date.setDateTime(dateTime);
		manager.persist(date);
		manager.getTransaction().commit();
	}

	@Override
	public void updateDate(DateInfoId id,Date dateTime,String location, String description) {
		DateInfo info = manager.find(DateInfo.class, id);
		info.setLocation(location);
		info.setDateTime(dateTime);
		info.setDescription(description);
		manager.getTransaction().commit();
	}

	@Override
	public List<DateInfo> ViewDateAsMatchMaker(int userId) {
		UserServiceDao userService = new UserServiceDao();
		AppUser user = userService.getUser(userId);
		
		Query query = manager.createQuery("select e from DateInfo e where e.MatchMakerId=:id");
		query.setParameter("id", user);
		
		List <DateInfo> listOfDates = (List <DateInfo>)query.getResultList();
		userService.finalCommit();
		return listOfDates;
	}

	@Override
	public void writeFeedBack() {
		
		
	}

	@Override
	public void rejectDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewDateAsUser() {

	}


	public void closeConnection(){
		manager.close();
	}
}
