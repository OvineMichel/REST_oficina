package br.com.oficina;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ordens_servico")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String clienteNome;

    @NotBlank(message = "O telefone do cliente é obrigatório")
    private String clienteTelefone;

    @NotBlank(message = "A placa do veículo é obrigatória")
    private String veiculoPlaca;

    @NotBlank(message = "O modelo do veículo é obrigatório")
    private String veiculoModelo;

    @NotBlank(message = "O serviço solicitado é obrigatório")
    private String servico;

    @NotBlank(message = "O status é obrigatório")
    private String status;

    @NotNull(message = "O valor estimado é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor não pode ser negativo")
    private BigDecimal valorEstimado;

    @NotNull(message = "A data de entrada é obrigatória")
    private LocalDate dataEntrada;

    private String observacoes;

    protected OrdemServico() {}

    public OrdemServico(String clienteNome, String clienteTelefone, String veiculoPlaca,
                        String veiculoModelo, String servico, String status,
                        BigDecimal valorEstimado, LocalDate dataEntrada, String observacoes) {
        this.clienteNome = clienteNome;
        this.clienteTelefone = clienteTelefone;
        this.veiculoPlaca = veiculoPlaca;
        this.veiculoModelo = veiculoModelo;
        this.servico = servico;
        this.status = status;
        this.valorEstimado = valorEstimado;
        this.dataEntrada = dataEntrada;
        this.observacoes = observacoes;
    }

    public Long getId() { return id; }
    public String getClienteNome() { return clienteNome; }
    public String getClienteTelefone() { return clienteTelefone; }
    public String getVeiculoPlaca() { return veiculoPlaca; }
    public String getVeiculoModelo() { return veiculoModelo; }
    public String getServico() { return servico; }
    public String getStatus() { return status; }
    public BigDecimal getValorEstimado() { return valorEstimado; }
    public LocalDate getDataEntrada() { return dataEntrada; }
    public String getObservacoes() { return observacoes; }

    public void atualizarCom(OrdemServico dados) {
        this.clienteNome = dados.clienteNome;
        this.clienteTelefone = dados.clienteTelefone;
        this.veiculoPlaca = dados.veiculoPlaca;
        this.veiculoModelo = dados.veiculoModelo;
        this.servico = dados.servico;
        this.status = dados.status;
        this.valorEstimado = dados.valorEstimado;
        this.dataEntrada = dados.dataEntrada;
        this.observacoes = dados.observacoes;
    }
}
