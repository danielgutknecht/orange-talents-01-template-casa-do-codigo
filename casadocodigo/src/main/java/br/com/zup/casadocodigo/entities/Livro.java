package br.com.zup.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	
	@OneToOne
	private Autor autor;
	
	@OneToOne
	private Categoria categoria;

}
