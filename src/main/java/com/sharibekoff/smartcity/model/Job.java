package com.sharibekoff.smartcity.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String jobName;

    @Positive
    private Double salary;

    @NotBlank
    @Size(max = 100)
    private String jobDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return id != null && Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
