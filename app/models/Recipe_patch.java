package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class Recipe_patch
{
    //Attributes
    private Long id;

    private String name;

    private Integer minutes;

    private Integer serves;

    private User parentUser;


    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getParentUser() {
        return parentUser;
    }

    public Long getParentUserId()
    {
        return parentUser.getId();
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }
}
