package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ImageToImageReq {

    @JsonProperty("content")
    private ContentDTO content;

    @NoArgsConstructor
    @Data
    public static class ContentDTO {
        @JsonProperty("images")
        private List<ImagesDTO> images;
        @JsonProperty("weight")
        private String weight;
        @JsonProperty("ratioStr")
        private String ratioStr;
        @JsonProperty("style")
        private String style;
        @JsonProperty("prompt")
        private String prompt;
        @JsonProperty("quality")
        private String quality;

        @NoArgsConstructor
        @Data
        public static class ImagesDTO {
            @JsonProperty("url")
            private String url;
        }
    }
}