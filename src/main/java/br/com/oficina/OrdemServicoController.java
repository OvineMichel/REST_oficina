package br.com.oficina;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordens-servico")
@Validated
public class OrdemServicoController {
    private final OrdemServicoRepository repository;

    public OrdemServicoController(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public OrdemServico buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new OrdemServicoNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<OrdemServico> criar(@Valid @RequestBody OrdemServico ordem) {
        OrdemServico salva = repository.save(ordem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salva.getId()).toUri();
        return ResponseEntity.created(location).body(salva);
    }

    @PutMapping("/{id}")
    public OrdemServico atualizar(@PathVariable Long id, @Valid @RequestBody OrdemServico dados) {
        OrdemServico existente = buscar(id);
        existente.atualizarCom(dados);
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new OrdemServicoNotFoundException(id);
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
