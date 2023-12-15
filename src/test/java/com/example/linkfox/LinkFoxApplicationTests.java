package com.example.linkfox;

import com.alibaba.fastjson.JSONObject;
import com.example.linkfox.req.*;
import com.example.linkfox.resp.LinkFoxFissionResp;
import com.fzzixun.openapi.sdk.client.OpenClient;
import com.fzzixun.openapi.sdk.common.RequestMethod;
import com.fzzixun.openapi.sdk.request.AppTokenRequest;
import com.fzzixun.openapi.sdk.request.CommonRequest;
import com.fzzixun.openapi.sdk.response.AppTokenResponse;
import com.fzzixun.openapi.sdk.response.CommonResponse;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class LinkFoxApplicationTests {

    public static final String APP_TOKEN = "d11c29138eb5775feeebd334e7a70184";

    @Test
    public void getTokenTest() {
        String url = "https://sbappstoreapi.ziniao.com";

        String appId = "202311221176941619505655808";

        String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCcDA" +
                "Ohd98jYPgflNCaaD4flROoLeaKr78Gfb+mTJkVygNuX4XVN9d+aQAZr6V89qT07fs8zQaKaaEnFb/TIbWzRV" +
                "v7OkoSPuQ2WS2Qm2omsr38vWh47GaGKg8Tv9snFHtCrHYACYIoxMBeVpyMm532NYkxzs93R/jRJI+i2JQif" +
                "v2WywZofPd0CsG+MYbRFsmSjMNznFgGBQqdmV+npC/JkMWEgdk4gQCQbKRRZ5ICVrCSq77ZoRyBbOJSrdJVP" +
                "NzpSec51iR6UOmGU5LHnumfFiswY+Al9C3SI5Jv7nNk4SbWz68w34QIqHDI3tMoAVTiwna2Hkmtg+Z+9Yzq5" +
                "SyFAgMBAAECggEBAJGXfAO47c36eUYt+Hs3605YLuDpAoI++wG5bYhhSytTMeRW521KDpr4qIlOoh53mOyU5a" +
                "WSvRmC+EKZPkJk3zyF6A38EoP3fcFfbu3Oszmr5yraJZE9L2LZ9vs8M+LAb0iD1Ayw0mnrOHhMYv+labn/tSN" +
                "ti5AE7Jdlf0Y2v+92ClhDAh6Yg4S5Q02vRYDwXDWwQz93GKaFIs1dIB8B8JObCAPDa9Kqa5NPSHIRmF3Cjd6c" +
                "24kn/LLtUIaxShVUEqnAWbRTkLlSqh0LOY1FVCP3im4wwf1KEHx3h4sv10taUg4KZ/5WaDTJ6+Xe9gUiDY5dl3" +
                "Dm9OOFn7WK+Av8UTkCgYEA2AwBPqOt+xQNfokYqlh3AZ4GojkMZQYaDxViXtPsLoynJntcH/gQHGRctZqd88Jz" +
                "pR9vCbrS64eV8uqELC7DEuSNMtKQAha7elZgoNWA8FkySbBgWsnH9u/C5W0UHi8wXYmuL1cu5Cmruocu1e4R19s" +
                "RSr4Z3JW/dLEiwzaXJtsCgYEAuOeEmQNsFCiat0I/03gJ4CmXs59AQlKQc8Fa8autSeMxd3OKytXjcDwxtjis9E" +
                "WvkQ0e1sXhxNisKGNKRuRTQTkVWQnUcbtMM/JbZpoXmqGji93Mm3/GtF/NgT+uCRlQke9SW6pv6Z5z69J1wKti69VhP" +
                "5o1WlFS8Byjrk1z6B8CgYEAydXdS9HKdihzuuUFoA7pjx88/0zgoXij27eUoRbHLW3FspPIqy0qj/vLCPYb3mCpfXf" +
                "yWlqpNdUDZ19kf4poQDw5FWPVmb33BAGyYE9WGDScYG9gdTDRmYbAw2m2Q8S+IITBsAR5EDtF7grg3Id/L/O/Id6b" +
                "dpKHvNLHsSxM5cUCgYAeiSVtu5Hytk3uq8MsoitHWLcT093h1g7C/xCMzqQ8ioeVyYAHRVFdLKOtCykM4iE/XCJWp" +
                "7FEN+Aef1852+Uf5VRwMt5hteO8xG5xwErbn4wJwiRTHcPr79JZYPHV0NdsclBwkPIQa7mLHWOS4PriJYf83/Olqb5" +
                "/psslMudMUwKBgQDB1PKu9ue7WrJgs+P3BWORDOak1NlbzCqriGkiuOL4B4IDnqPbeBdkfmyH+D5B6dg/DfwseeDZ" +
                "M0QqTUilHlejkG3dOWNLTEvZy23c1p5rPM99fwdn28ja7u0rpfxQ2GI5Kr0ZJqGKf7pmND/HrSCRKSfNH3eVSXhNl6bJdKpgKA==";

        // 创建请求客户端，声明一个就行
        OpenClient client = new OpenClient(url, appId, privateKeyIsv);

        // 创建请求对象
        AppTokenRequest request = new AppTokenRequest();
        // 发送请求
        CommonResponse response = client.execute(request);
        if (response.isSuccess()) {
            System.out.println("成功");
            // 返回结果
            String data = response.getData();
            System.out.println(data);

            AppTokenResponse appTokenResponse = response.getDataObj(AppTokenResponse.class);
            System.out.println(appTokenResponse.getAppAuthToken());
        } else {
            System.out.println("失败");
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void fissionTest() {
        CommonRequest request = new CommonRequest("/linkfox-ai/image/v1/batch/task/create/1", RequestMethod.POST_JSON);
        LinkFoxFissionReqBody reqBody = new LinkFoxFissionReqBody();
        reqBody.setType("1");
        LinkFoxExtendFieldBody extendFieldBody = new LinkFoxExtendFieldBody();
        extendFieldBody.setHeight(768);
        extendFieldBody.setWidth(1024);
        LinkFoxImageDTO linkFoxImageDTO = new LinkFoxImageDTO();
        linkFoxImageDTO.setUrl("https://ts1.cn.mm.bing.net/th/id/R-C.0ac8db0557811b59e023cc5686a72bcb?rik=pSeUfzpFAuAIaQ&riu=http%3a%2f%2fwww.quazero.com%2fuploads%2fallimg%2f140305%2f1-140305223024.jpg&ehk=r78GawrcHRT2NUrUGn%2ffa0j%2fkTj8SQ9p%2fTuP%2fr8nT%2fM%3d&risl=&pid=ImgRaw&r=0");
        linkFoxImageDTO.setHeight(768);
        linkFoxImageDTO.setWidth(1024);

        extendFieldBody.setImages(Collections.singletonList(linkFoxImageDTO));
        extendFieldBody.setWeight(2);
        extendFieldBody.setOutputNum(4);
        reqBody.setExtendFields(extendFieldBody);

        String bizContent = JSONObject.toJSONString(reqBody);
        // 按接口文档设置业务参数
        request.setBizContent(bizContent);
        String url = "https://redirect.sdspod.com/linkfox/";

        String appId = "202311221176941619505655808";

        String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCcDA" +
                "Ohd98jYPgflNCaaD4flROoLeaKr78Gfb+mTJkVygNuX4XVN9d+aQAZr6V89qT07fs8zQaKaaEnFb/TIbWzRV" +
                "v7OkoSPuQ2WS2Qm2omsr38vWh47GaGKg8Tv9snFHtCrHYACYIoxMBeVpyMm532NYkxzs93R/jRJI+i2JQif" +
                "v2WywZofPd0CsG+MYbRFsmSjMNznFgGBQqdmV+npC/JkMWEgdk4gQCQbKRRZ5ICVrCSq77ZoRyBbOJSrdJVP" +
                "NzpSec51iR6UOmGU5LHnumfFiswY+Al9C3SI5Jv7nNk4SbWz68w34QIqHDI3tMoAVTiwna2Hkmtg+Z+9Yzq5" +
                "SyFAgMBAAECggEBAJGXfAO47c36eUYt+Hs3605YLuDpAoI++wG5bYhhSytTMeRW521KDpr4qIlOoh53mOyU5a" +
                "WSvRmC+EKZPkJk3zyF6A38EoP3fcFfbu3Oszmr5yraJZE9L2LZ9vs8M+LAb0iD1Ayw0mnrOHhMYv+labn/tSN" +
                "ti5AE7Jdlf0Y2v+92ClhDAh6Yg4S5Q02vRYDwXDWwQz93GKaFIs1dIB8B8JObCAPDa9Kqa5NPSHIRmF3Cjd6c" +
                "24kn/LLtUIaxShVUEqnAWbRTkLlSqh0LOY1FVCP3im4wwf1KEHx3h4sv10taUg4KZ/5WaDTJ6+Xe9gUiDY5dl3" +
                "Dm9OOFn7WK+Av8UTkCgYEA2AwBPqOt+xQNfokYqlh3AZ4GojkMZQYaDxViXtPsLoynJntcH/gQHGRctZqd88Jz" +
                "pR9vCbrS64eV8uqELC7DEuSNMtKQAha7elZgoNWA8FkySbBgWsnH9u/C5W0UHi8wXYmuL1cu5Cmruocu1e4R19s" +
                "RSr4Z3JW/dLEiwzaXJtsCgYEAuOeEmQNsFCiat0I/03gJ4CmXs59AQlKQc8Fa8autSeMxd3OKytXjcDwxtjis9E" +
                "WvkQ0e1sXhxNisKGNKRuRTQTkVWQnUcbtMM/JbZpoXmqGji93Mm3/GtF/NgT+uCRlQke9SW6pv6Z5z69J1wKti69VhP" +
                "5o1WlFS8Byjrk1z6B8CgYEAydXdS9HKdihzuuUFoA7pjx88/0zgoXij27eUoRbHLW3FspPIqy0qj/vLCPYb3mCpfXf" +
                "yWlqpNdUDZ19kf4poQDw5FWPVmb33BAGyYE9WGDScYG9gdTDRmYbAw2m2Q8S+IITBsAR5EDtF7grg3Id/L/O/Id6b" +
                "dpKHvNLHsSxM5cUCgYAeiSVtu5Hytk3uq8MsoitHWLcT093h1g7C/xCMzqQ8ioeVyYAHRVFdLKOtCykM4iE/XCJWp" +
                "7FEN+Aef1852+Uf5VRwMt5hteO8xG5xwErbn4wJwiRTHcPr79JZYPHV0NdsclBwkPIQa7mLHWOS4PriJYf83/Olqb5" +
                "/psslMudMUwKBgQDB1PKu9ue7WrJgs+P3BWORDOak1NlbzCqriGkiuOL4B4IDnqPbeBdkfmyH+D5B6dg/DfwseeDZ" +
                "M0QqTUilHlejkG3dOWNLTEvZy23c1p5rPM99fwdn28ja7u0rpfxQ2GI5Kr0ZJqGKf7pmND/HrSCRKSfNH3eVSXhNl6bJdKpgKA==";

        // 创建请求客户端，声明一个就行
        OpenClient client = new OpenClient(url, appId, privateKeyIsv);
        // 发起请求
        CommonResponse response = client.executeAppToken(request, APP_TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            String data = response.getData();
            System.out.println(data);
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }


    @Test
    public void getFusionResultTest() {
        String url = "https://redirect.sdspod.com/linkfox/";

        String appId = "202311221176941619505655808";

        String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCcDA" +
                "Ohd98jYPgflNCaaD4flROoLeaKr78Gfb+mTJkVygNuX4XVN9d+aQAZr6V89qT07fs8zQaKaaEnFb/TIbWzRV" +
                "v7OkoSPuQ2WS2Qm2omsr38vWh47GaGKg8Tv9snFHtCrHYACYIoxMBeVpyMm532NYkxzs93R/jRJI+i2JQif" +
                "v2WywZofPd0CsG+MYbRFsmSjMNznFgGBQqdmV+npC/JkMWEgdk4gQCQbKRRZ5ICVrCSq77ZoRyBbOJSrdJVP" +
                "NzpSec51iR6UOmGU5LHnumfFiswY+Al9C3SI5Jv7nNk4SbWz68w34QIqHDI3tMoAVTiwna2Hkmtg+Z+9Yzq5" +
                "SyFAgMBAAECggEBAJGXfAO47c36eUYt+Hs3605YLuDpAoI++wG5bYhhSytTMeRW521KDpr4qIlOoh53mOyU5a" +
                "WSvRmC+EKZPkJk3zyF6A38EoP3fcFfbu3Oszmr5yraJZE9L2LZ9vs8M+LAb0iD1Ayw0mnrOHhMYv+labn/tSN" +
                "ti5AE7Jdlf0Y2v+92ClhDAh6Yg4S5Q02vRYDwXDWwQz93GKaFIs1dIB8B8JObCAPDa9Kqa5NPSHIRmF3Cjd6c" +
                "24kn/LLtUIaxShVUEqnAWbRTkLlSqh0LOY1FVCP3im4wwf1KEHx3h4sv10taUg4KZ/5WaDTJ6+Xe9gUiDY5dl3" +
                "Dm9OOFn7WK+Av8UTkCgYEA2AwBPqOt+xQNfokYqlh3AZ4GojkMZQYaDxViXtPsLoynJntcH/gQHGRctZqd88Jz" +
                "pR9vCbrS64eV8uqELC7DEuSNMtKQAha7elZgoNWA8FkySbBgWsnH9u/C5W0UHi8wXYmuL1cu5Cmruocu1e4R19s" +
                "RSr4Z3JW/dLEiwzaXJtsCgYEAuOeEmQNsFCiat0I/03gJ4CmXs59AQlKQc8Fa8autSeMxd3OKytXjcDwxtjis9E" +
                "WvkQ0e1sXhxNisKGNKRuRTQTkVWQnUcbtMM/JbZpoXmqGji93Mm3/GtF/NgT+uCRlQke9SW6pv6Z5z69J1wKti69VhP" +
                "5o1WlFS8Byjrk1z6B8CgYEAydXdS9HKdihzuuUFoA7pjx88/0zgoXij27eUoRbHLW3FspPIqy0qj/vLCPYb3mCpfXf" +
                "yWlqpNdUDZ19kf4poQDw5FWPVmb33BAGyYE9WGDScYG9gdTDRmYbAw2m2Q8S+IITBsAR5EDtF7grg3Id/L/O/Id6b" +
                "dpKHvNLHsSxM5cUCgYAeiSVtu5Hytk3uq8MsoitHWLcT093h1g7C/xCMzqQ8ioeVyYAHRVFdLKOtCykM4iE/XCJWp" +
                "7FEN+Aef1852+Uf5VRwMt5hteO8xG5xwErbn4wJwiRTHcPr79JZYPHV0NdsclBwkPIQa7mLHWOS4PriJYf83/Olqb5" +
                "/psslMudMUwKBgQDB1PKu9ue7WrJgs+P3BWORDOak1NlbzCqriGkiuOL4B4IDnqPbeBdkfmyH+D5B6dg/DfwseeDZ" +
                "M0QqTUilHlejkG3dOWNLTEvZy23c1p5rPM99fwdn28ja7u0rpfxQ2GI5Kr0ZJqGKf7pmND/HrSCRKSfNH3eVSXhNl6bJdKpgKA==";

        // 创建请求客户端，声明一个就行
        OpenClient client = new OpenClient(url, appId, privateKeyIsv);
        CommonRequest request = new CommonRequest("/linkfox-ai/image/v1/batch/task/info/1", RequestMethod.POST_JSON);

        LinkFoxGetFissionResultReqBody body = new LinkFoxGetFissionResultReqBody();
        body.setId(950);
        String bizContent = JSONObject.toJSONString(body);
        // 按接口文档设置业务参数
        request.setBizContent(bizContent);

        // 发起请求
        CommonResponse response = client.executeAppToken(request, APP_TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            LinkFoxFissionResp dataObj = response.getDataObj(LinkFoxFissionResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void linkFoxImageTest() {
        String url = "https://redirect.sdspod.com/linkfox/";

        String appId = "202311221176941619505655808";

        String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCcDA" +
                "Ohd98jYPgflNCaaD4flROoLeaKr78Gfb+mTJkVygNuX4XVN9d+aQAZr6V89qT07fs8zQaKaaEnFb/TIbWzRV" +
                "v7OkoSPuQ2WS2Qm2omsr38vWh47GaGKg8Tv9snFHtCrHYACYIoxMBeVpyMm532NYkxzs93R/jRJI+i2JQif" +
                "v2WywZofPd0CsG+MYbRFsmSjMNznFgGBQqdmV+npC/JkMWEgdk4gQCQbKRRZ5ICVrCSq77ZoRyBbOJSrdJVP" +
                "NzpSec51iR6UOmGU5LHnumfFiswY+Al9C3SI5Jv7nNk4SbWz68w34QIqHDI3tMoAVTiwna2Hkmtg+Z+9Yzq5" +
                "SyFAgMBAAECggEBAJGXfAO47c36eUYt+Hs3605YLuDpAoI++wG5bYhhSytTMeRW521KDpr4qIlOoh53mOyU5a" +
                "WSvRmC+EKZPkJk3zyF6A38EoP3fcFfbu3Oszmr5yraJZE9L2LZ9vs8M+LAb0iD1Ayw0mnrOHhMYv+labn/tSN" +
                "ti5AE7Jdlf0Y2v+92ClhDAh6Yg4S5Q02vRYDwXDWwQz93GKaFIs1dIB8B8JObCAPDa9Kqa5NPSHIRmF3Cjd6c" +
                "24kn/LLtUIaxShVUEqnAWbRTkLlSqh0LOY1FVCP3im4wwf1KEHx3h4sv10taUg4KZ/5WaDTJ6+Xe9gUiDY5dl3" +
                "Dm9OOFn7WK+Av8UTkCgYEA2AwBPqOt+xQNfokYqlh3AZ4GojkMZQYaDxViXtPsLoynJntcH/gQHGRctZqd88Jz" +
                "pR9vCbrS64eV8uqELC7DEuSNMtKQAha7elZgoNWA8FkySbBgWsnH9u/C5W0UHi8wXYmuL1cu5Cmruocu1e4R19s" +
                "RSr4Z3JW/dLEiwzaXJtsCgYEAuOeEmQNsFCiat0I/03gJ4CmXs59AQlKQc8Fa8autSeMxd3OKytXjcDwxtjis9E" +
                "WvkQ0e1sXhxNisKGNKRuRTQTkVWQnUcbtMM/JbZpoXmqGji93Mm3/GtF/NgT+uCRlQke9SW6pv6Z5z69J1wKti69VhP" +
                "5o1WlFS8Byjrk1z6B8CgYEAydXdS9HKdihzuuUFoA7pjx88/0zgoXij27eUoRbHLW3FspPIqy0qj/vLCPYb3mCpfXf" +
                "yWlqpNdUDZ19kf4poQDw5FWPVmb33BAGyYE9WGDScYG9gdTDRmYbAw2m2Q8S+IITBsAR5EDtF7grg3Id/L/O/Id6b" +
                "dpKHvNLHsSxM5cUCgYAeiSVtu5Hytk3uq8MsoitHWLcT093h1g7C/xCMzqQ8ioeVyYAHRVFdLKOtCykM4iE/XCJWp" +
                "7FEN+Aef1852+Uf5VRwMt5hteO8xG5xwErbn4wJwiRTHcPr79JZYPHV0NdsclBwkPIQa7mLHWOS4PriJYf83/Olqb5" +
                "/psslMudMUwKBgQDB1PKu9ue7WrJgs+P3BWORDOak1NlbzCqriGkiuOL4B4IDnqPbeBdkfmyH+D5B6dg/DfwseeDZ" +
                "M0QqTUilHlejkG3dOWNLTEvZy23c1p5rPM99fwdn28ja7u0rpfxQ2GI5Kr0ZJqGKf7pmND/HrSCRKSfNH3eVSXhNl6bJdKpgKA==";

        // 创建请求客户端，声明一个就行
        OpenClient client = new OpenClient(url, appId, privateKeyIsv);
        CommonRequest request = new CommonRequest("/linkfox-ai/image/v1/make/create/1", RequestMethod.POST_JSON);

        LinkFoxImageReqBody reqBody = new LinkFoxImageReqBody();
        reqBody.setImageUrl("https://picx.zhimg.com/v2-97ce9e4aaac5d3b83e8474117749d76a_r.jpg?source=1def8aca");
        reqBody.setOutputNum(4);
        reqBody.setSubType(4);
        reqBody.setStyle("人物素材");
        request.setBizContent(JSONObject.toJSONString(reqBody));
        CommonResponse response = client.executeAppToken(request, APP_TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            Object dataObj = response.getDataObj(Object.class);
            String data = response.getData();
            System.out.println(data);
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }


    @Test
    public void getImageResultTest() {
        String url = "https://redirect.sdspod.com/linkfox/";

        String appId = "202311221176941619505655808";

        String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCcDA" +
                "Ohd98jYPgflNCaaD4flROoLeaKr78Gfb+mTJkVygNuX4XVN9d+aQAZr6V89qT07fs8zQaKaaEnFb/TIbWzRV" +
                "v7OkoSPuQ2WS2Qm2omsr38vWh47GaGKg8Tv9snFHtCrHYACYIoxMBeVpyMm532NYkxzs93R/jRJI+i2JQif" +
                "v2WywZofPd0CsG+MYbRFsmSjMNznFgGBQqdmV+npC/JkMWEgdk4gQCQbKRRZ5ICVrCSq77ZoRyBbOJSrdJVP" +
                "NzpSec51iR6UOmGU5LHnumfFiswY+Al9C3SI5Jv7nNk4SbWz68w34QIqHDI3tMoAVTiwna2Hkmtg+Z+9Yzq5" +
                "SyFAgMBAAECggEBAJGXfAO47c36eUYt+Hs3605YLuDpAoI++wG5bYhhSytTMeRW521KDpr4qIlOoh53mOyU5a" +
                "WSvRmC+EKZPkJk3zyF6A38EoP3fcFfbu3Oszmr5yraJZE9L2LZ9vs8M+LAb0iD1Ayw0mnrOHhMYv+labn/tSN" +
                "ti5AE7Jdlf0Y2v+92ClhDAh6Yg4S5Q02vRYDwXDWwQz93GKaFIs1dIB8B8JObCAPDa9Kqa5NPSHIRmF3Cjd6c" +
                "24kn/LLtUIaxShVUEqnAWbRTkLlSqh0LOY1FVCP3im4wwf1KEHx3h4sv10taUg4KZ/5WaDTJ6+Xe9gUiDY5dl3" +
                "Dm9OOFn7WK+Av8UTkCgYEA2AwBPqOt+xQNfokYqlh3AZ4GojkMZQYaDxViXtPsLoynJntcH/gQHGRctZqd88Jz" +
                "pR9vCbrS64eV8uqELC7DEuSNMtKQAha7elZgoNWA8FkySbBgWsnH9u/C5W0UHi8wXYmuL1cu5Cmruocu1e4R19s" +
                "RSr4Z3JW/dLEiwzaXJtsCgYEAuOeEmQNsFCiat0I/03gJ4CmXs59AQlKQc8Fa8autSeMxd3OKytXjcDwxtjis9E" +
                "WvkQ0e1sXhxNisKGNKRuRTQTkVWQnUcbtMM/JbZpoXmqGji93Mm3/GtF/NgT+uCRlQke9SW6pv6Z5z69J1wKti69VhP" +
                "5o1WlFS8Byjrk1z6B8CgYEAydXdS9HKdihzuuUFoA7pjx88/0zgoXij27eUoRbHLW3FspPIqy0qj/vLCPYb3mCpfXf" +
                "yWlqpNdUDZ19kf4poQDw5FWPVmb33BAGyYE9WGDScYG9gdTDRmYbAw2m2Q8S+IITBsAR5EDtF7grg3Id/L/O/Id6b" +
                "dpKHvNLHsSxM5cUCgYAeiSVtu5Hytk3uq8MsoitHWLcT093h1g7C/xCMzqQ8ioeVyYAHRVFdLKOtCykM4iE/XCJWp" +
                "7FEN+Aef1852+Uf5VRwMt5hteO8xG5xwErbn4wJwiRTHcPr79JZYPHV0NdsclBwkPIQa7mLHWOS4PriJYf83/Olqb5" +
                "/psslMudMUwKBgQDB1PKu9ue7WrJgs+P3BWORDOak1NlbzCqriGkiuOL4B4IDnqPbeBdkfmyH+D5B6dg/DfwseeDZ" +
                "M0QqTUilHlejkG3dOWNLTEvZy23c1p5rPM99fwdn28ja7u0rpfxQ2GI5Kr0ZJqGKf7pmND/HrSCRKSfNH3eVSXhNl6bJdKpgKA==";

        // 创建请求客户端，声明一个就行
        OpenClient client = new OpenClient(url, appId, privateKeyIsv);
        CommonRequest request = new CommonRequest("/linkfox-ai/image/v1/make/info/1", RequestMethod.POST_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 141979);
        request.setBizContent(jsonObject.toJSONString());
        CommonResponse response = client.executeAppToken(request, APP_TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            Object dataObj = response.getDataObj(Object.class);
            String data = response.getData();
            System.out.println(data);
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }
}
