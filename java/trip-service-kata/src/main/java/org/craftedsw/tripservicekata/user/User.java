package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<>();
	private List<User> friends = new ArrayList<>();

	public User(){

	}

	public User(List<Trip> trips,List<User> friends){
		this.trips=trips;
		this.friends=friends;
	}
	
	public List<User> getFriends() {
		return friends;
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public List<Trip> trips() {
		return trips;
	}

	public boolean isFriendWith(User user){
		for (User friend : getFriends()) {
			if (friend.equals(user)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(trips, user.trips) && Objects.equals(friends, user.friends);
	}

	@Override
	public int hashCode() {
		return Objects.hash(trips, friends);
	}
}
