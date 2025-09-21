package tech.techsete.utmify_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingParametersRequest implements Serializable {

    @JsonProperty("src")
    private String src;

    @JsonProperty("sck")
    private String sck;

    @JsonProperty("utm_source")
    private String utmSource;

    @JsonProperty("utm_campaign")
    private String utmCampaign;

    @JsonProperty("utm_medium")
    private String utmMedium;

    @JsonProperty("utm_content")
    private String utmContent;

    @JsonProperty("utm_term")
    private String utmTerm;
}
