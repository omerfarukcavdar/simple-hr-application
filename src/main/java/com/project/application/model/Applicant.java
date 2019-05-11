package com.project.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.text.Document;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicantId;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String thoughtsOnJob;

    @NotNull
    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;
}
