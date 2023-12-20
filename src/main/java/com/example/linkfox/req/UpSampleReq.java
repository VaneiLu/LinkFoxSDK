package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpSampleReq {
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("outputNum")
    private String outputNum;
    @JsonProperty("extendFields")
    private ExtendFieldsDTO extendFields;

    @NoArgsConstructor
    @Data
    public static class ExtendFieldsDTO {
        @JsonProperty("magnification")
        private String magnification;
    }
}