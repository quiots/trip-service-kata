package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.springframework.beans.factory.annotation.Autowired;

public class TripService {

	@Autowired
	private TripDAO tripDAO;

	public List<Trip> getTripsFromFriend(User loggedUser, User otherUser) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<>();
		checkLogged(loggedUser);

		if(otherUser.isFriendWith(loggedUser)){
			tripList = tripsByUser(otherUser);
		}

		return tripList;
	}

	public List<Trip> tripsByUser(User user){
		return tripDAO.findTripsOfUser(user);
	}

	public void checkLogged(User supposedLoggedUser) throws UserNotLoggedInException{
		if(supposedLoggedUser == null){
			throw new UserNotLoggedInException();
		}
	}

	public User getActualLoggedUser(){
		return UserSession.getInstance().getLoggedUser();
	}


}
