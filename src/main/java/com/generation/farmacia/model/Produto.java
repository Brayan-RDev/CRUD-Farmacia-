package com.generation.farmacia.model;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O fabricante do produto não pode estar vazio!")
	@Size(min = 5, message = "O fabricante precisa ter mais do que 5 caracteres!")
	@Size(max = 45, message = "O fabricante precisa ter menos do que 45 caracteres!")
	private String fabricante;
	
	@NotNull(message = "O valor do produto não pode estar vazio!")
	@NumberFormat(pattern = "#,###.##")
	@Positive(message = "O valor do produto deve ser um número positivo!")
	@Column(columnDefinition = "decimal(6,2)")
	private Float preco;

	@NotNull(message = "A quantidade de estoque não pode estar vazia!")
	@PositiveOrZero(message = "A quantidade em estoque deve ser um número positivo!")
	private Integer quantidade;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
