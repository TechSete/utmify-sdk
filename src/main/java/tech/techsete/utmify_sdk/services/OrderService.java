package tech.techsete.utmify_sdk.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.techsete.utmify_sdk.dtos.requests.OrderRequest;
import tech.techsete.utmify_sdk.dtos.responses.OrderResponse;

import java.util.Map;

@Service("UtmifySDKOrderService")
public class OrderService {

    private final WebClient webClient;

    public OrderService(@Qualifier("UtmifyWebClient")
                        WebClient webClient
    ) {
        this.webClient = webClient;
    }

    public OrderResponse createOrder(Map<String, ?> headers,
                                     OrderRequest orderRequest) {
        return createOrderAsync(headers, orderRequest).block();
    }

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
