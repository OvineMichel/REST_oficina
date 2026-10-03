# Oficina Mecânica — API REST + Front-end

Projeto adaptado a partir do exemplo `Employee` para gerenciar **ordens de serviço de uma oficina mecânica**.

## Tecnologias

- Java 17+
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- H2 Database persistente em arquivo
- HTML, CSS e JavaScript no front-end servido pelo Spring Boot

## Como executar

Com Java/JDK instalado:

```bash
./mvnw spring-boot:run
```

Abra <http://localhost:8080>.

Para rodar os testes:

```bash
./mvnw test
```

O banco H2 fica em `./data/oficina-db`. A console está em <http://localhost:8080/h2-console>, com:

- JDBC URL: `jdbc:h2:file:./data/oficina-db`
- Usuário: `sa`
- Senha: *(vazia)*

## API REST

Recurso: `/api/ordens-servico`

| Método | Rota | Ação | Resposta principal |
|---|---|---|---|
| GET | `/api/ordens-servico` | Lista todas as ordens | `200 OK` |
| GET | `/api/ordens-servico/{id}` | Busca uma ordem | `200 OK` ou `404 Not Found` |
| POST | `/api/ordens-servico` | Cria uma ordem | `201 Created` |
| PUT | `/api/ordens-servico/{id}` | Atualiza todos os dados da ordem | `200 OK` |
| DELETE | `/api/ordens-servico/{id}` | Exclui uma ordem | `204 No Content` |

### Exemplo de POST/PUT

```json
{
  "clienteNome": "Ana Martins",
  "clienteTelefone": "(11) 98888-1234",
  "veiculoPlaca": "ABC1D23",
  "veiculoModelo": "Volkswagen T-Cross 2021",
  "servico": "Revisão de 40.000 km",
  "status": "ABERTA",
  "valorEstimado": 780.50,
  "dataEntrada": "2026-10-02",
  "observacoes": "Verificar ruído na suspensão"
}
```

Status aceitos pela tela: `ABERTA`, `EM_ANDAMENTO`, `CONCLUIDA` e `CANCELADA`.

## Estrutura principal

- `OrdemServico.java`: entidade JPA e variáveis do cenário.
- `OrdemServicoRepository.java`: persistência com `JpaRepository`.
- `OrdemServicoController.java`: mapeamentos REST GET/POST/PUT/DELETE.
- `ApiExceptionHandler.java`: erros 400 e 404 em JSON.
- `src/main/resources/static/index.html`: front-end para todas as ações.
