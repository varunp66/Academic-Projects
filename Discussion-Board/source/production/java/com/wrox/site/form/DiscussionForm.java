package com.wrox.site.form;

import java.time.Instant;

public class DiscussionForm
{
    private String user;
    private String subject;
    private String message;
    private Instant delete;

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
    
    
    
    
       public Instant getDelete()
    {
        return delete;
    }

    public void setDelete(Instant delete)
    {
        this.delete = delete;
    }

 
}
