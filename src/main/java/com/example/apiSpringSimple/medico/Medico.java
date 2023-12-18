package com.example.apiSpringSimple.medico;

import com.example.apiSpringSimple.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialide;

    @Embedded
    private Endereco endereco;

    public Medico(DataRegisterMed dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialide = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }


    public void updateData(DataUpdateMed dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.updateAdress(dados.endereco());
        }
    }
}

