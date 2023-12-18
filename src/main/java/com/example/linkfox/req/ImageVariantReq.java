package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ImageVariantReq {

    @JsonProperty("chatId")
    private String chatId;
    @JsonProperty("content")
    private ContentDTO content;

    @NoArgsConstructor
    @Data
    public static class ContentDTO {
        @JsonProperty("images")
        private List<ImagesDTO> images;
        @JsonProperty("action")
        private String action;

        @NoArgsConstructor
        @Data
        public static class ImagesDTO {
            @JsonProperty("id")
            private String id;
            @JsonProperty("url")
            private String url;
        }
    }
}