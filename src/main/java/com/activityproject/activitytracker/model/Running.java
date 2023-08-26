package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Running extends Activity{

    private int sprints;

   @ManyToOne
    @JoinColumn(name="name",nullable = false)
    private User user;

}
