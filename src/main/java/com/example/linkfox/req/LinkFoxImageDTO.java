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
public class LinkFoxImageDTO {
    @JsonProperty("url")
    private String url;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
}