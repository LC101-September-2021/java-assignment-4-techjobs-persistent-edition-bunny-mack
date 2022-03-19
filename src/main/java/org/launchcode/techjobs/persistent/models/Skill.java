package org.launchcode.techjobs.persistent.models;

import org.launchcode.techjobs.persistent.models.data.JobRepository;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @ManyToMany(mappedBy="skills")
    private final List<Job> jobs = new ArrayList<>();

    @NotBlank (message = "Description is required")
    @Size (max = 150, message = "Description too long")
    private String description;

    public Skill(String description) {
        this.description = description;
    }

    public Skill(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}