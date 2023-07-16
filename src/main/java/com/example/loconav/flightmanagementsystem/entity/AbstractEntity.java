package com.example.loconav.flightmanagementsystem.entity;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Audited
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now().getEpochSecond();
        this.updatedBy = "USER";
    }

    @PrePersist
    public void onPersist() {
        this.createdAt = Instant.now().getEpochSecond();
        this.createdBy = "USER";
        this.updatedAt = Instant.now().getEpochSecond();
        this.updatedBy = "USER";
    }
}
