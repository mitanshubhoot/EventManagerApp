package com.example.event_manager_app;

public class CoordinatorRepository {
    private final CoordinatorDao coordinatorDao;
    public static CoordinatorRepository INSTANCE ;
    public CoordinatorRepository(CoordinatorDao coordinatorDao)
    {
       this.coordinatorDao = coordinatorDao;
    }
    public static CoordinatorRepository getInstance(CoordinatorDao coordinatorDao)
    {
        if(INSTANCE == null)
            INSTANCE = new CoordinatorRepository(coordinatorDao);

        return INSTANCE;

    }
    public void insert(Coordinator c)
    {
        coordinatorDao.insert(c);
    }
}
