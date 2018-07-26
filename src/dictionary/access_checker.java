package dictionary;
public class access_checker {
    int access_checking(int user_id,int passkey)
    {
        int access=2;
        if(user_id<=1000)//user
        {
            access=0;
        }
        else if (user_id>1000 && user_id<1500)//admin
        {
            access=1;
        }
        return access;
    }
    
}
