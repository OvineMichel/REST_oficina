package br.com.oficina;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(OrdemServicoRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }
            repository.save(new OrdemServico("Mariana Souza", "(11) 99999-1111", "ABC1D23",
                    "Honda Civic 2020", "Troca de óleo e filtros", "ABERTA",
                    new BigDecimal("380.00"), LocalDate.now(), "Cliente aguarda orçamento final."));
            repository.save(new OrdemServico("Carlos Oliveira", "(11) 98888-2222", "XYZ9E87",
                    "Fiat Toro 2022", "Revisão de freios", "EM_ANDAMENTO",
                    new BigDecimal("920.50"), LocalDate.now().minusDays(1), "Verificar pastilhas traseiras."));
        };
    }
}
