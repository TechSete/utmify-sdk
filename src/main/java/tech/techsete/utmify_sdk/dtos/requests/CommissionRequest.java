package tech.techsete.utmify_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommissionRequest {

    @NotNull(message = "O campo preço total em centavos não deve estar vazio!")
    @JsonProperty("totalPriceInCents")
    private Long totalPriceInCents;

    @NotNull(message = "O campo taxa do gateway em centavos não deve estar vazio!")
    @JsonProperty("gatewayFeeInCents")
    private Long gatewayFeeInCents;

    @NotNull(message = "O campo comissão do usuário em centavos não deve estar vazio!")
    @JsonProperty("userCommissionInCents")
    private Long userCommissionInCents;

    @JsonProperty("currency")
    private String currency;
}