package tech.techsete.utmify_sdk.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.techsete.utmify_sdk.dtos.requests.OrderRequest;
import tech.techsete.utmify_sdk.dtos.responses.OrderResponse;

import java.util.Map;

/**
 * A classe {@code OrderService} é responsável por gerenciar operações relacionadas a pedidos,
 * utilizando comunicação assíncrona e síncrona com uma API externa por meio de um {@code WebClient}.
 * É um serviço Spring anotado como {@code @Service} para integração no contexto do Spring Framework.
 * <p>
 * A classe fornece funcionalidades para criar pedidos e suporta tanto a execução em tempo
 * real quanto futura (assíncrona).
 * </p>
 * <p>
 * Esta classe foi projetada para ser usada em aplicações Spring.
 * </p>
 *
 * @see WebClient
 * @see OrderRequest
 * @see OrderResponse
 */
@Service("UtmifySDKOrderService")
public class OrderService {

    private final WebClient webClient;

    /**
     * Construtor para inicialização do serviço de pedidos.
     *
     * @param webClient uma instância configurada do {@link WebClient}, anotada com {@code @Qualifier}
     *                  para identificar a instância específica usada para este serviço.
     */
    public OrderService(@Qualifier("UtmifyWebClient")
                        WebClient webClient
    ) {
        this.webClient = webClient;
    }

    /**
     * Cria um pedido de forma síncrona utilizando os cabeçalhos e o {@link OrderRequest} fornecidos.
     * Esta operação bloqueia a execução até que a resposta seja obtida.
     *
     * <p><b>Exemplo de Uso:</b></p>
     * <pre>{@code
     * Map<String, String> headers = Map.of("Authorization", "Bearer token_123");
     * OrderRequest request = new OrderRequest(...);
     * OrderResponse response = orderService.createOrder(headers, request);
     * }</pre>
     *
     * @param headers cabeçalhos HTTP a serem enviados na requisição.
     * @param orderRequest o pedido a ser criado, incluindo todos os detalhes necessários.
     * @return um objeto {@link OrderResponse} que contém os detalhes do pedido criado.
     *
     * @throws IllegalStateException se a comunicação com o servidor falhar.
     */
    public OrderResponse createOrder(Map<String, ?> headers,
                                     OrderRequest orderRequest) {
        return createOrderAsync(headers, orderRequest).block();
    }

    /**
     * Cria um pedido de forma assíncrona utilizando os cabeçalhos e o {@link OrderRequest} fornecidos.
     * A operação retorna um {@link Mono} para ser tratado de forma reativa e não bloqueante.
     *
     * <p><b>Exemplo de Uso:</b></p>
     * <pre>{@code
     * Map<String, String> headers = Map.of("Authorization", "Bearer token_123");
     * OrderRequest request = new OrderRequest(...);
     * Mono<OrderResponse> response = orderService.createOrderAsync(headers, request);
     * response.subscribe(orderResponse -> {
     *     System.out.println("Pedido criado: " + orderResponse);
     * });
     * }</pre>
     *
     * @param headers cabeçalhos HTTP a serem enviados na requisição.
     * @param orderRequest o pedido a ser criado, validado com {@link jakarta.validation.Valid}.
     * @return um {@link Mono} que resolve para um objeto {@link OrderResponse}.
     *
     * @throws IllegalArgumentException se os parâmetros tampões não forem válidos.
     */
    public Mono<OrderResponse> createOrderAsync(Map<String, ?> headers,
                                                @Valid OrderRequest orderRequest) {
        return webClient.post()
                .uri("/api-credentials/orders")
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .bodyValue(orderRequest)
                .retrieve()
                .bodyToMono(OrderResponse.class);
    }

}
