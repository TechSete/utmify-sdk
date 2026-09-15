# Utmify SDK

SDK Java para integração com a API da Utmify, com suporte ao envio de pedidos e parâmetros de rastreamento.

## Requisitos

- Java 17+
- Spring Boot 4+
- Jackson 3
- Maven 3.9+ ou Maven Wrapper

## Instalação

Adicione a dependência ao projeto consumidor:

```xml
<dependency>
    <groupId>tech.techsete</groupId>
    <artifactId>utmify-sdk</artifactId>
    <version>1.0.2</version>
</dependency>
```

Ou com Gradle:

```groovy
implementation 'tech.techsete:utmify-sdk:1.0.2'
```

## Configuração

O SDK possui autoconfiguração Spring Boot. Ao adicionar a dependência, os componentes do pacote `tech.techsete.utmify_sdk` são registrados automaticamente.

O SDK utiliza Jackson 3, portanto integrações e testes que instanciem `ObjectMapper` diretamente devem usar o pacote `tools.jackson.databind`.

## Enviar pedido

```java
import tech.techsete.utmify_sdk.dtos.requests.CommissionRequest;
import tech.techsete.utmify_sdk.dtos.requests.CustomerRequest;
import tech.techsete.utmify_sdk.dtos.requests.OrderRequest;
import tech.techsete.utmify_sdk.dtos.requests.ProductRequest;
import tech.techsete.utmify_sdk.dtos.requests.TrackingParametersRequest;
import tech.techsete.utmify_sdk.dtos.responses.OrderResponse;
import tech.techsete.utmify_sdk.enums.OrderStatus;
import tech.techsete.utmify_sdk.enums.PaymentMethod;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

Map<String, String> headers = Map.of("x-api-token", "SEU_TOKEN");

OrderRequest request = OrderRequest.builder()
        .orderId("pedido-123")
        .platform("Minha Plataforma")
        .paymentMethod(PaymentMethod.PIX)
        .status(OrderStatus.PAID)
        .createdAt(OffsetDateTime.now())
        .approvedDate(OffsetDateTime.now())
        .customer(CustomerRequest.builder()
                .name("Cliente")
                .email("cliente@email.com")
                .phone("11999999999")
                .document("12345678909")
                .country("BR")
                .ip("127.0.0.1")
                .build())
        .products(List.of(ProductRequest.builder()
                .id("produto-1")
                .name("Produto")
                .quantity(1L)
                .priceInCents(10000L)
                .build()))
        .trackingParameters(TrackingParametersRequest.builder()
                .utmSource("telegram")
                .utmCampaign("campanha")
                .utmMedium("bot")
                .build())
        .commission(CommissionRequest.builder()
                .totalPriceInCents(10000L)
                .gatewayFeeInCents(500L)
                .userCommissionInCents(9500L)
                .currency("BRL")
                .build())
        .isTest(Boolean.FALSE)
        .build();

OrderResponse response = orderService.createOrder(headers, request);
```