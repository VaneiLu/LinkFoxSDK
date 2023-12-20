package com.example.linkfox.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UpSampeResp {
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
        @JsonProperty("planId")
        private Integer planId;
        @JsonProperty("imageUrl")
        private String imageUrl;
        @JsonProperty("outputNum")
        private Integer outputNum;
        @JsonProperty("extendFields")
        private ExtendFieldsDTO extendFields;
        @JsonProperty("preDrawCount")
        private Integer preDrawCount;
        @JsonProperty("expireTime")
        private Integer expireTime;
        @JsonProperty("createTime")
        private Integer createTime;
        @JsonProperty("updateTime")
        private Integer updateTime;

        @NoArgsConstructor
        @Data
        public static class ExtendFieldsDTO {
            @JsonProperty("magnification")
            private Integer magnification;
        }
    }
}