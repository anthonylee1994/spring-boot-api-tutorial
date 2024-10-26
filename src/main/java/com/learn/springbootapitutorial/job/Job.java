package com.learn.springbootapitutorial.job;

import com.learn.springbootapitutorial.company.Company;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author anthonylee
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne(optional = false)
    private Company company;
}
