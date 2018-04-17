# Microservices com Spring Boot e Spring Cloud

Prepare sua nuvem de microsserviços com o Spring Cloud

O que o projeto contém
- Comunicação entre microsserviços
- Configuração Centralizada do Microservice com o Spring Cloud Config Server
- Usando o Spring Cloud Bus para trocar mensagens sobre atualizações de configuração
- Simplifiquei a comunicação com outros microsserviços usando o Feign REST Client
- Implementar balanceamento de carga no lado do cliente
- Implementei o dimensionamento dinâmico usando o Eureka Naming Server and Ribbon
- Implementei o gateway de API com o Zuul
- Implementei rastreamento distribuído com Spring Cloud Sleuth e Zipkin
- Implementei tolerância a falhas com Zipkin



#### Spring Cloud Config Server
-  Limites do Microservice
-  serviço de limites rígidos
-  Configurando Perfis para Serviço de Limites

#### Implementei 2 microsserviços com o Eureka Naming Server, Ribbon e Feign

- Configurei o balanceamento de carga no lado do cliente com a Faixa de Opções
- Balanceamento de carga no lado do cliente
- Servidor o Eureka Naming Server
- Microservice Exchange Exchange a Eureka
- Distribuição chamadas usando Eureka e Ribbon

#### Gateways da API e rastreamento distribuído
- Uso o Zuul API Gateway
- Implementado o Filtro de Log do Zuul
- Configurando o Zuul API Gateway entre invocações de microsserviço
- O Spring Cloud Sleuth
- A Rastreamento Distribuído com Zipkin
- O Rabbit MQ
- Usando o Zipkin UI Dashboard para rastrear solicitações

#### Spring Cloud Bus e Hysterix
- Spring Cloud Bus
- Implementando o Spring Cloud Bus
- Tolerância a falhas com Hystrix


## Ports

| Aplicação | Porto |
| ------------- | ------------- |
| Limita serviço | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
| | |
| Serviço de Marketing Campaing | 8200, 8201, 8202, .. |
| Serviço de Socio Torcedor | 8300, 8301, 8302, ... |
| Servidor de Nomes Netflix Eureka | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Servidor de rastreamento distribuído Zipkin | 9411 |


## URLs

| Aplicação | URL |
| ------------- | ------------- |
| Limita serviço | http://localhost:8080/limits POST -> http://localhost:8080/actuador/atualização |
Spring Cloud Config Server | http://localhost:8888 /limits-service/ default http://localhost:8888/limits-service/dev |
| Serviço de Serviço de Marketing Campaing - Chamada Direta |  |
| Serviço de Socio Torcedor | http://localhost:8300/socio-torcedor-service/socios/ |
| Eureka | http://localhost: 8761 / |
| Zuul - Marketing e Socio | http://localhost:8765/socio-torcedor-service/socio-torcedor-service/socios/ INR http://localhost:8765/marketing-campaing-service/marketing-campaing-service/campaings |
| Zipkin | http://localhost:9411/