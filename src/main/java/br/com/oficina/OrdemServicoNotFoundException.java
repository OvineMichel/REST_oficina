package br.com.oficina;

public class OrdemServicoNotFoundException extends RuntimeException {
    public OrdemServicoNotFoundException(Long id) {
        super("Ordem de serviço " + id + " não encontrada");
    }
}
