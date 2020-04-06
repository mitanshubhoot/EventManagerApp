package com.example.event_manager_app;

public class UserRepository {

    private final UserAccountDao userAccountDao;
    private static UserRepository instance;


    private UserRepository(UserAccountDao userAccountDao)
    {
        this.userAccountDao = userAccountDao;
    }

    public static UserRepository getInstance(UserAccountDao userAccountDao)
    {
        if(instance == null)
        {
            instance = new UserRepository(userAccountDao);
        }
        return instance;
    }

    public boolean isValidAccount(String email, final String password)
    {
        UserAccount userAccount = null;
        try{
            userAccount = userAccountDao.getAccount(email);
        }
        catch (RuntimeException r)
        {

        }
        if(userAccount==null )
            return false;
        return userAccount.getPassword().equals(password);
    }
    public boolean isValidRegister(String email)
    {
        String register_email = null;
        try{
             register_email = userAccountDao.RegisterAccount(email);
        }
        catch (RuntimeException r)
        {
        }
        if(register_email==null)
            return true;
        return false;
    }

    public void insertUser(String email, String password)
    {
        UserAccount account = new UserAccount(email, password);
        userAccountDao.insert(account);
    }
}