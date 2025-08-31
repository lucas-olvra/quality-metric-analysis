📊 Jira Metrics
API para gestão de Casos de Teste (NFTs), Bugs e Sub-Bugs, com cálculo automático de métricas mensais por projeto.

⚙️ Tecnologias
- Java 17+
- Spring Boot 3
- Spring Data JPA
- H2 (banco em memória para testes)
- Maven

📂 Estrutura do Projeto
src/main/java/com/empresa/jirametrics/
├── controller   -> REST Controllers
├── dto          -> DTOs (ex.: MetricsReport)
├── model        -> Entidades (TestCase, Bug, SubBug)
├── repository   -> JPA Repositories
└── service      -> Regras de negócio (MetricsService)

🚀 Endpoints
🔹 TestCases (NFTs)
| Método | Endpoint          | Descrição                                      |
| ------ | ----------------- | ---------------------------------------------- |
| POST   | `/testcases`      | Criar novo caso de teste                       |
| GET    | `/testcases`      | Listar todos os casos                          |
| PUT    | `/testcases/{id}` | Atualizar completamente                        |
| PATCH  | `/testcases/{id}` | Atualizar parcialmente (ex.: marcar executado) |
| DELETE | `/testcases/{id}` | Deletar caso de teste                          |

**Exemplo criar:**
POST /testcases
{
  "projectKey": "ABC",
  "title": "Validar login com usuário válido",
  "executado": false
}

**Exemplo marcar como executado (não precisa recriar):**
PATCH /testcases/1
{
  "executado": true
}

🔹 Bugs
| Método | Endpoint     | Descrição              |
| ------ | ------------ | ---------------------- |
| POST   | `/bugs`      | Criar novo bug         |
| GET    | `/bugs`      | Listar todos           |
| PATCH  | `/bugs/{id}` | Atualizar parcialmente |
| DELETE | `/bugs/{id}` | Deletar bug            |

**Exemplo criar:**
POST /bugs
{
  "projectKey": "ABC",
  "description": "Erro ao salvar formulário",
  "openedDate": "2025-03-05"
}

**Exemplo fechar bug:**
PATCH /bugs/10
{
  "closedDate": "2025-03-12"
}

🔹 Sub-Bugs
| Método | Endpoint        | Descrição              |
| ------ | --------------- | ---------------------- |
| POST   | `/subbugs`      | Criar sub-bug          |
| GET    | `/subbugs`      | Listar todos           |
| PATCH  | `/subbugs/{id}` | Atualizar parcialmente |
| DELETE | `/subbugs/{id}` | Deletar sub-bug        |

**Exemplo criar:**
POST /subbugs
{
  "projectKey": "ABC",
  "description": "Bug reaberto: erro persiste na tela",
  "openedDate": "2025-03-07"
}

**Exemplo fechar:**
PATCH /subbugs/5
{
  "closedDate": "2025-03-15"
}

🔹 Métricas
| Método | Endpoint                               | Descrição                         |
| ------ | -------------------------------------- | --------------------------------- |
| GET    | `/metrics/{projectKey}/{year}/{month}` | Gera relatório mensal por projeto |

**Exemplo:**
GET /metrics/ABC/2025/3

**Resposta:**
{
  "projectKey": "ABC",
  "plannedTests": 50,
  "executedTests": 40,
  "subBugs": 3,
  "bugs": 10,
  "retrabalhoPercent": 6.0
}


🧪 Testes via Postman
- A API possui CRUD completo + endpoint de métricas.
- Recomenda-se criar uma coleção Postman com todos os exemplos acima para facilitar os testes.

📌Observações Importantes
- TestCases (NFTs) não precisam ser recriados ao executar → basta atualizar o campo executado.
- Bugs e Sub-Bugs aceitam openedDate e closedDate (se closedDate for nulo, considera-se aberto).
- As métricas são calculadas por projeto (projectKey) e por período (ano/mês).
- O relatório mensal considera:
  - Planned Tests
  - Executed Tests
  - Bugs abertos no período
  - SubBugs (retrabalho)
  - Percentual de retrabalho


💻 Instalação e Execução
1- Clone o projeto:
git clone https://github.com/seuusuario/jira-metrics-api.git

2- Entre na pasta do projeto:
cd jira-metrics-api

3- Compile e execute:
mvn spring-boot:run

4- Acesse a API em:
http://localhost:8080
