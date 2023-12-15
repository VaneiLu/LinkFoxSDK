package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class PromptToImageReq {

    @JsonProperty("chatId")
    private String chatId;
    @JsonProperty("content")
    private ContentDTO content;

    @NoArgsConstructor
    @Data
    public static class ContentDTO {
        @JsonProperty("niji")
        private String niji;
        @JsonProperty("ratioStr")
        private String ratioStr;
        @JsonProperty("stylize")
        private String stylize;
        @JsonProperty("prompt")
        private String prompt;
        @JsonProperty("quality")
        private String quality;
    }
}