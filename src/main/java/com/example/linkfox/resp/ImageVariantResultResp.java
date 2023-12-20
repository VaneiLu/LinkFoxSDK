package com.example.linkfox.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ImageVariantResultResp {
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("traceId")
    private String traceId;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("chatId")
        private Integer chatId;
        @JsonProperty("userId")
        private Long userId;
        @JsonProperty("teamId")
        private Integer teamId;
        @JsonProperty("replyId")
        private Integer replyId;
        @JsonProperty("model")
        private Integer model;
        @JsonProperty("role")
        private Integer role;
        @JsonProperty("content")
        private ContentDTO content;
        @JsonProperty("extendField")
        private ExtendFieldDTO extendField;
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("planId")
        private Integer planId;
        @JsonProperty("preChatCount")
        private Integer preChatCount;
        @JsonProperty("chatCount")
        private Integer chatCount;
        @JsonProperty("errorCode")
        private String errorCode;
        @JsonProperty("errorMsg")
        private String errorMsg;
        @JsonProperty("errorBody")
        private String errorBody;
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("retryTimes")
        private Integer retryTimes;
        @JsonProperty("expireTime")
        private Integer expireTime;
        @JsonProperty("createTime")
        private Integer createTime;
        @JsonProperty("updateTime")
        private Integer updateTime;

        @NoArgsConstructor
        @Data
        public static class ContentDTO {
            @JsonProperty("images")
            private List<ImagesDTO> images;
            @JsonProperty("action")
            private Integer action;

            @NoArgsConstructor
            @Data
            public static class ImagesDTO {
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("url")
                private String url;
                @JsonProperty("status")
                private Integer status;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ExtendFieldDTO {
            @JsonProperty("channel")
            private Long channel;
            @JsonProperty("prompt")
            private String prompt;
        }
    }
}