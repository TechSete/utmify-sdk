package tech.techsete.utmify_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest implements Serializable {

    @NotEmpty(message = "O campo id não deve estar vazio!")
    @JsonProperty("id")
    private String id;

    @NotEmpty(message = "O campo nome não deve estar vazio!")
    @JsonProperty("name")
    private String name;

    @JsonProperty("planId")
    private String planId;

    @JsonProperty("planName")
    private String planName;

    @NotNull(message = "O campo quantidade não deve estar vazio!")
    @JsonProperty("quantity")
    private Long quantity;

    @NotNull(message = "O campo valor em centavos não deve estar vazio!")
    @JsonProperty("priceInCents")
    private Long priceInCents;
}