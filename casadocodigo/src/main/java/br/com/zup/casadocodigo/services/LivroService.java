package br.com.zup.casadocodigo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.casadocodigo.endpoint.controller.request.LivroRequest;
import br.com.zup.casadocodigo.endpoint.controller.response.LivroResponse;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.entities.Livro;
import br.com.zup.casadocodigo.repositories.AutorRepository;
import br.com.zup.casadocodigo.repositories.CategoriaRepository;
import br.com.zup.casadocodigo.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	public LivroRepository livroRepository;

	@Autowired
	public AutorRepository autorRepository;

	@Autowired
	public CategoriaRepository categoriaRepository;

	public LivroResponse criarLivro(LivroRequest livroRequest) {

		Optional<Autor> autorId = autorRepository.findById(livroRequest.getAutorId());

		if (autorId.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID autor não foi encontrado");
		}

		Optional<Categoria> categoriaId = categoriaRepository.findById(livroRequest.getCategoriaId());

		if (categoriaId.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID cotegoria não foi encontrado");
		}

		Livro livro = new Livro(livroRequest, autorId.get(), categoriaId.get());

		livroRepository.save(livro);

		return new LivroResponse(livro);

	}

	public LivroResponse buscaPorId(Long id) {
		Optional<Livro> optionalLivro = livroRepository.findById(id);

		if (optionalLivro.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID do livro não foi encontrado");
		}
		Livro livro = optionalLivro.get();

		return new LivroResponse(livro);
	}

	public List<LivroResponse> listarTodosLivros() {
		Iterable<Livro> iterador = livroRepository.findAll();

		List<Livro> lista = new ArrayList<Livro>();
		iterador.forEach(lista::add);
		
		return lista.stream().map(LivroResponse::new).collect(Collectors.toList());
	}

}
