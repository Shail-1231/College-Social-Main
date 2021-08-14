package com.myapp.collegesocial;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EventModel implements Serializable {

    String eventName, eventOrganiser, eventDescription, category, venue, email, registrationLink;
    String image;
    Long cost, contact;
    String date;
    String time;

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventOrganiser(String eventOrganiser) {
        this.eventOrganiser = eventOrganiser;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
