package com.example.linkfox.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: linkFox
 * @BelongsPackage: com.example.linkfox.resp
 * @Author: lujp
 * @CreateTime: 2023-12-05
 * @Description:
 * @Version: 1.0
 */

@NoArgsConstructor
@Data
public class LinkFoxFissionResp {

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
        private Integer teamId;
        @JsonProperty("userId")
        private Long userId;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("extendFields")
        private ExtendFieldsDTO extendFields;
        @JsonProperty("totalCount")
        private Integer totalCount;
        @JsonProperty("successCount")
        private Integer successCount;
        @JsonProperty("failCount")
        private Integer failCount;
        @JsonProperty("preDrawCount")
        private Integer preDrawCount;
        @JsonProperty("drawCount")
        private Integer drawCount;
        @JsonProperty("planId")
        private Integer planId;
        @JsonProperty("items")
        private List<ItemsDTO> items;
        @JsonProperty("version")
        private Integer version;
        @JsonProperty("createTime")
        private Integer createTime;
        @JsonProperty("updateTime")
        private Integer updateTime;

        @NoArgsConstructor
        @Data
        public static class ExtendFieldsDTO {
            @JsonProperty("outputNum")
            private Integer outputNum;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("weight")
            private String weight;
            @JsonProperty("height")
            private Integer height;
        }

        @NoArgsConstructor
        @Data
        public static class ItemsDTO {
            @JsonProperty("teamId")
            private Integer teamId;
            @JsonProperty("userId")
            private Long userId;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("taskId")
            private Integer taskId;
            @JsonProperty("planId")
            private Integer planId;
            @JsonProperty("type")
            private Integer type;
            @JsonProperty("status")
            private Integer status;
            @JsonProperty("extendFields")
            private ExtendFieldsDTO extendFields;
            @JsonProperty("errorCode")
            private String errorCode;
            @JsonProperty("errorMsg")
            private String errorMsg;
            @JsonProperty("errorBody")
            private String errorBody;
            @JsonProperty("preDrawCount")
            private Integer preDrawCount;
            @JsonProperty("drawCount")
            private Integer drawCount;
            @JsonProperty("expireTime")
            private Integer expireTime;
            @JsonProperty("retryTimes")
            private Integer retryTimes;
            @JsonProperty("successCount")
            private Integer successCount;
            @JsonProperty("failCount")
            private Integer failCount;
            @JsonProperty("resultList")
            private List<ResultListDTO> resultList;
            @JsonProperty("createTime")
            private Integer createTime;
            @JsonProperty("updateTime")
            private Integer updateTime;

            @NoArgsConstructor
            @Data
            public static class ExtendFieldsDTO {
                @JsonProperty("images")
                private List<ImagesDTO> images;
                @JsonProperty("outputNum")
                private Integer outputNum;
                @JsonProperty("width")
                private Integer width;
                @JsonProperty("weight")
                private String weight;
                @JsonProperty("height")
                private Integer height;

                @NoArgsConstructor
                @Data
                public static class ImagesDTO {
                    @JsonProperty("width")
                    private Integer width;
                    @JsonProperty("prompt")
                    private String prompt;
                    @JsonProperty("url")
                    private String url;
                    @JsonProperty("height")
                    private Integer height;
                }
            }

            @NoArgsConstructor
            @Data
            public static class ResultListDTO {
                @JsonProperty("teamId")
                private Integer teamId;
                @JsonProperty("userId")
                private Long userId;
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("imageMakeId")
                private Integer imageMakeId;
                @JsonProperty("relationId")
                private Integer relationId;
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
                @JsonProperty("downloadUserId")
                private Integer downloadUserId;
                @JsonProperty("downloadTime")
                private Integer downloadTime;
                @JsonProperty("count")
                private Integer count;
                @JsonProperty("planId")
                private Integer planId;
                @JsonProperty("extendField")
                private ExtendFieldDTO extendField;
                @JsonProperty("createTime")
                private Integer createTime;

                @NoArgsConstructor
                @Data
                public static class ExtendFieldDTO {
                    @JsonProperty("batchId")
                    private String batchId;
                }
            }
        }
    }
}