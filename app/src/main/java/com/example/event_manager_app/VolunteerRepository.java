package com.example.event_manager_app;

import java.util.List;

public class VolunteerRepository {
    private final VolunteerDao volunteerDao;
    private static VolunteerRepository instance;
    public VolunteerRepository(VolunteerDao volunteerDao)
    {
        this.volunteerDao = volunteerDao;
    }
    public static VolunteerRepository getInstance(VolunteerDao volunteerDao)
    {
        if(instance == null)
        {
            instance = new VolunteerRepository(volunteerDao);
        }
        return instance;
    }
    public List<Volunteer> getAllVolunteers(String email)
    {
        return  volunteerDao.getAllVolunteers(email);
    }


}
