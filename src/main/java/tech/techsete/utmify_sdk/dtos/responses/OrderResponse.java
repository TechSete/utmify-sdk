package tech.techsete.utmify_sdk.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    @JsonProperty("OK")
    private Boolean ok;

    @JsonProperty("data")
    private HashMap<?, ?> data;

    @JsonProperty("result")
    private String result;
}