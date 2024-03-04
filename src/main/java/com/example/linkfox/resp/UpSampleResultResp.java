package com.example.linkfox.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UpSampleResultResp {

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
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("subType")
        private Integer subType;
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("prompt")
        private String prompt;
        @JsonProperty("promptTranslation")
        private String promptTranslation;
        @JsonProperty("imageUrl")
        private String imageUrl;
        @JsonProperty("style")
        private String style;
        @JsonProperty("ratio")
        private Integer ratio;
        @JsonProperty("outputNum")
        private Integer outputNum;
        @JsonProperty("extendFields")
        private ExtendFieldsDTO extendFields;
        @JsonProperty("errorCode")
        private String errorCode;
        @JsonProperty("errorMsg")
        private String errorMsg;
        @JsonProperty("errorStop")
        private Boolean errorStop;
        @JsonProperty("resultList")
        private List<ResultListDTO> resultList;
        @JsonProperty("preDrawCount")
        private Integer preDrawCount;
        @JsonProperty("drawCount")
        private Integer drawCount;
        @JsonProperty("expireTime")
        private Long expireTime;
        @JsonProperty("createTime")
        private Long createTime;
        @JsonProperty("updateTime")
        private Long updateTime;

        @NoArgsConstructor
        @Data
        public static class ExtendFieldsDTO {
            @JsonProperty("magnification")
            private Integer magnification;
        }

        @NoArgsConstructor
        @Data
        public static class ResultListDTO {
            @JsonProperty("id")
            private Long id;
            @JsonProperty("status")
            private Integer status;
            @JsonProperty("errorCode")
            private String errorCode;
            @JsonProperty("errorMsg")
            private String errorMsg;
            @JsonProperty("errorBody")
            private String errorBody;
            @JsonProperty("url")
            private String url;
            @JsonProperty("key")
            private String key;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("format")
            private String format;
            @JsonProperty("size")
            private Integer size;
            @JsonProperty("downloadFlag")
            private Boolean downloadFlag;
            @JsonProperty("downloadTime")
            private Integer downloadTime;
            @JsonProperty("count")
            private Integer count;
        }
    }
}