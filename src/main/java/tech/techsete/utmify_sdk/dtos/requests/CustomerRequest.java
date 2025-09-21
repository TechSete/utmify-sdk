package tech.techsete.utmify_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest implements Serializable {

    @NotEmpty(message = "O campo nome não deve estar vazio!")
    @JsonProperty("name")
    private String name;

    @NotEmpty(message = "O campo e-mail não deve estar vazio!")
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "O campo telefone não deve estar vazio!")
    @JsonProperty("phone")
    private String phone;

    @NotEmpty(message = "O campo documento não deve estar vazio!")
    @JsonProperty("document")
    private String document;

    @JsonProperty("country")
    private String country;

    @JsonProperty("ip")
    private String ip;
}