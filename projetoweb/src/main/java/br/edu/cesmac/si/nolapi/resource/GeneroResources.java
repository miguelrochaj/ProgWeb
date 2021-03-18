package br.edu.cesmac.si.nolapi.resource;

import br.edu.cesmac.si.nolapi.domain.Editoria;
import br.edu.cesmac.si.nolapi.domain.Genero;
import br.edu.cesmac.si.nolapi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/generos")
public class GeneroResources {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable("id") Long idGenero){
        return generoRepository.findById(idGenero).map(genero -> ResponseEntity.ok(genero)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Genero genero){
        generoRepository.save(genero);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(genero.getIdGenero()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void alterar(@RequestBody Genero genero){
        generoRepository.save(genero);
    }

    @DeleteMapping
    public void deletar(@RequestBody Genero genero){
        generoRepository.delete(genero);
    }
}
