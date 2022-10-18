package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void shouldReturnFalseWhenLoggedUserIsNotFriendWithOtherUser(){
        User loggedUser = new User();
        User otherUser = new User();
        assertEquals(false, otherUser.isFriendWith(loggedUser));
    }

    @Test
    void shouldReturnTrueWhenLoggedUserIsFriendWithOtherUser(){
        User loggedUser = new User();
        User otherUser = new User();
        otherUser.addFriend(loggedUser);
        assertTrue(otherUser.isFriendWith(loggedUser));
    }

}
