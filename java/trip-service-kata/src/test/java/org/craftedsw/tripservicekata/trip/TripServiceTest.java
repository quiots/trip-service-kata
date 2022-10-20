package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TripServiceTest {


    @Mock
    private TripDAO tripDAO;

    @InjectMocks
    private TripService tripService;

    private static final User loggedUser = new User();

    @Test
    void getTripsByUser() {

    }

    @Test
    void shouldThrowUserNotLoggedInException(){

    }

    @Test
    void shouldThrowUserNotLoggedInExpcetion(){
        User nullUser = null;
        assertThrows(UserNotLoggedInException.class, () -> {
            tripService.checkLogged(nullUser);
        }, "None user logged in.");
    }




    @Test
    void shouldReturnTripListWhenLoggedUserIsAFriend(){
        User otherUser = new User();
        otherUser.addFriend(loggedUser);
        Trip icelandTrip = new Trip("Iceland");
        Trip japanTrip = new Trip("Japan");
        otherUser.addTrip(icelandTrip);
        otherUser.addTrip(japanTrip);

        when(tripDAO.findTripsOfUser(otherUser)).thenReturn(List.of(icelandTrip,japanTrip));

        final List<Trip> expectedTrips = tripService.getTripsFromFriend(loggedUser,otherUser);


        assertEquals(List.of(icelandTrip,japanTrip),expectedTrips);
    }

    @Test
    void shouldReturnEmptyListWhenLoggedUserIsNotAFriend(){
        User otherUser = new User();
        Trip icelandTrip = new Trip("Iceland");
        Trip japanTrip = new Trip("Japan");
        otherUser.addTrip(icelandTrip);
        otherUser.addTrip(japanTrip);


        assertEquals(List.of(),tripService.getTripsFromFriend(loggedUser,otherUser));
    }
}
