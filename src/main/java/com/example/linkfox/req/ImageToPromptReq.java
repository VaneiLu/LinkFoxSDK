package com.example.linkfox.req;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ImageToPromptReq {

    @JsonProperty("content")
    private ContentDTO content;

    @NoArgsConstructor
    @Data
    public static class ContentDTO {
        @JsonProperty("images")
        private List<ImagesDTO> images;

        @NoArgsConstructor
        @Data
        public static class ImagesDTO {
            @JsonProperty("url")
            private String url;
        }
    }
}