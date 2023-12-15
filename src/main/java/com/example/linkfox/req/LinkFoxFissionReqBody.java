package com.example.linkfox.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: linkFox
 * @BelongsPackage: com.example.linkfox
 * @Author: lujp
 * @CreateTime: 2023-12-05
 * @Description:
 * @Version: 1.0
 */
@NoArgsConstructor
@Data
public class LinkFoxFissionReqBody {

    @JsonProperty("extendFields")
    private LinkFoxExtendFieldBody extendFields;
    @JsonProperty("type")
    private String type;
}