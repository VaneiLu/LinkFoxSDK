package com.example.linkfox.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ImageToPromptResultResp {
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
            @JsonProperty("prompts")
            private List<String> prompts;
        }

    }
}