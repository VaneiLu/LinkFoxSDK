package com.example.linkfox.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ImageVariantResp {

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
        @JsonProperty("teamId")
        private String teamId;
        @JsonProperty("userId")
        private String userId;
        @JsonProperty("id")
        private String id;
        @JsonProperty("lastCompletionId")
        private String lastCompletionId;
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("createTime")
        private Integer createTime;
        @JsonProperty("updateTime")
        private Integer updateTime;
        @JsonProperty("completions")
        private List<CompletionsDTO> completions;

        @NoArgsConstructor
        @Data
        public static class CompletionsDTO {
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("chatId")
            private Integer chatId;
            @JsonProperty("userId")
            private Long userId;
            @JsonProperty("teamId")
            private Integer teamId;
            @JsonProperty("model")
            private Integer model;
            @JsonProperty("role")
            private Integer role;
            @JsonProperty("type")
            private Integer type;
            @JsonProperty("planId")
            private Integer planId;
            @JsonProperty("status")
            private Integer status;
            @JsonProperty("createTime")
            private Integer createTime;
            @JsonProperty("updateTime")
            private Integer updateTime;

        }
    }
}