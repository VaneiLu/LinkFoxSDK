package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class LinkFoxExtendFieldBody {
    @JsonProperty("images")
    private List<LinkFoxImageDTO> images;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("outputNum")
    private Integer outputNum;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("scale")
    private String scale;
    @JsonProperty("height")
    private Integer height;
}