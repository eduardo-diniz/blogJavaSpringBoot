package com.spring.codeblog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

//@Entity indica que é um banco
@Entity
//Cria a tabela do banco
@Table (name="TB_POST")

public class Post {

    @Id
    //Genera Ids para tabela automaticamente
    @GeneratedValue(strategy = GenerationType.AUTO)

    //Não permite a existencia de valores brancos ou nulos no campos.
    private Long id;
    @NotBlank
    private String titulo;

    //Não permite a existencia de valores brancos ou nulos no campos.
    @NotBlank
    @NotNull
    private String autor;

    //Configura como os valores são apresentados- vai apresentar o local date em uma string com o formato informado no pattern.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    //Não permite a existencia de valores brancos ou nulos no campos.
    @NotBlank
   //??
    @Lob
    private String texto;


//getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {

        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
