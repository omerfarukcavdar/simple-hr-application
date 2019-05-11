package com.project.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    private String jobTitle;

    private String jobDescription;

    private Integer numberOfPeopleToHire;

    private LocalDateTime lastApplicationDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "job")
    private List<Applicant> applicants=new ArrayList<>();
}
