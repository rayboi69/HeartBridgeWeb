package com.se452.service;
import javax.persistence.Entity;

import com.se452.model.Gift;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;


public interface GiftServiceInterface {
	    //add all the gifts
		void addGift( String giftName, String giftDescription, byte[] giftPicture );
		//review the gifts I sent
		List<Gift> reviewGiftUserSend( int userSent_Id );
		//review the gifts I received
		List<Gift> reviewGiftUserReveived( int userReceived_Id);
		//delete the gifts I received
		void deleteGIftUserReceived(int giftId, int userReceived_Id);
		//send gift to friend
		void sendGift(int gift_Id, int user_Send, int user_Received, Date modifiedTimestamp) throws NoSuchAlgorithmException;
		void commitTransaction();



}
