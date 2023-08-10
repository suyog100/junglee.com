package com.example.safari.junglesafari.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminPage {
    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contact_number", length = 5, nullable = false)
    private Integer contact_number;

    @Column(name = "PackageNo", nullable = false)
    private String PackageNo;
}
