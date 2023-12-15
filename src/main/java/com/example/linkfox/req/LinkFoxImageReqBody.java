package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: linkFox
 * @BelongsPackage: com.example.linkfox.req
 * @Author: lujp
 * @CreateTime: 2023-12-05
 * @Description:
 * @Version: 1.0
 */
@NoArgsConstructor
@Data
public class LinkFoxImageReqBody {

    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("outputNum")
    private Integer outputNum;
    @JsonProperty("style")
    private String style;
    @JsonProperty("subType")
    private Integer subType;
    @JsonProperty("type")
    private String type;
    @JsonProperty("prompt")
    private String prompt;
    @JsonProperty("ratio")
    private Double ratio;
}