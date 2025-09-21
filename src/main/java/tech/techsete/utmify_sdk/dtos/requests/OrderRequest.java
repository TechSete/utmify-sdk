package tech.techsete.utmify_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tech.techsete.utmify_sdk.enums.OrderStatus;
import tech.techsete.utmify_sdk.enums.PaymentMethod;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {

    @NotEmpty(message = "O campo ID do pedido não deve estar vazio!")
    @JsonProperty("orderId")
    private String orderId;

    @NotEmpty(message = "O campo plataforma não deve estar vazio!")
    @JsonProperty("platform")
    private String platform;

    @NotNull(message = "O campo método de pagamento não deve estar vazio!")
    @JsonProperty("paymentMethod")
    private PaymentMethod paymentMethod;

    @NotNull(message = "O campo status não deve estar vazio!")
    @JsonProperty("status")
    private OrderStatus status;

    @NotNull(message = "O campo criado em não deve estar vazio!")
    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime createdAt;

    @JsonProperty("approvedDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime approvedDate;

    @JsonProperty("refundedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime refundedAt;

    @Valid
    @NotNull(message = "O campo cliente não deve estar vazio!")
    @JsonProperty("customer")
    private CustomerRequest customer;

    @Valid
    @NotNull(message = "O campo lista de produtos não deve estar vazio!")
    @JsonProperty("products")
    private List<ProductRequest> products;

    @Valid
    @NotNull(message = "O campo parâmetros de rastreamento não deve estar vazio!")
    @JsonProperty("trackingParameters")
    private TrackingParametersRequest trackingParameters;

    @Valid
    @NotNull(message = "O campo comissão não deve estar vazio!")
    @JsonProperty("commission")
    private CommissionRequest commission;

    @JsonProperty("isTest")
    private Boolean isTest;
}
