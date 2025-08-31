package com.empresa.jirametrics.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SubBug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectKey; // sigla do projeto Jira

    private String nfrId;       // História/NFT relacionada
    private LocalDate openedDate;
    private LocalDate closedDate; // Pode ser nulo se ainda aberto
}
