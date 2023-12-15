package com.example.linkfox;

import com.alibaba.fastjson.JSONObject;
import com.example.linkfox.req.OnlyIdReq;
import com.example.linkfox.req.PromptToImageReq;
import com.fzzixun.openapi.sdk.client.OpenClient;
import com.fzzixun.openapi.sdk.common.RequestMethod;
import com.fzzixun.openapi.sdk.request.AppTokenRequest;
import com.fzzixun.openapi.sdk.request.CommonRequest;
import com.fzzixun.openapi.sdk.response.AppTokenResponse;
import com.fzzixun.openapi.sdk.response.CommonResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class LinkFoxApplicationTests {

    public static final String APP_TOKEN = "d11c29138eb5775feeebd334e7a70184";

    public static final String PROMPT_TO_IMAGE = "/linkfox-ai/image/v1/chat/completion/create/1";
    public static final String PROMPT_TO_IMAGE_RESULT = "/linkfox-ai/image/v1/chat/completion/info/1";

    public static final String IMAGE_TO_IMAGE = "/linkfox-ai/image/v1/chat/completion/create/2";
    public static final String IMAGE_TO_IMAGE_RESULT = "/linkfox-ai/image/v1/chat/completion/info/2";
    public static final String IMAGE_TO_PROMPT = "/linkfox-ai/image/v1/chat/completion/create/3";
    public static final String IMAGE_TO_PROMPT_RESULT = "/linkfox-ai/image/v1/chat/completion/info/3";
    public static final String proxyUrl = "https://redirect.sdspod.com/linkfox/";
    public static final String appId = "202311221176941619505655808";
    public static final String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCcDA" +
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

    public static final String TOKEN = "通过接口/缓存里面拿";
    @Test
    public void getTokenTest() {

        // 创建请求客户端，声明一个就行
        OpenClient client = new OpenClient(proxyUrl, appId, privateKeyIsv);

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
    public void promptToImage() {
        PromptToImageReq req = new PromptToImageReq();
        OpenClient client = getClient();
        req.setContent(new PromptToImageReq.ContentDTO());
        req.setChatId("");
        CommonRequest request = new CommonRequest(PROMPT_TO_IMAGE, RequestMethod.POST_JSON);
        request.setBizContent(JSONObject.toJSONString(req));
        CommonResponse response = client.executeAppToken(request, TOKEN);
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
    public void promptToImageResult() {

        OnlyIdReq req = new OnlyIdReq();
        req.setId(1L);
        CommonRequest request = new CommonRequest(PROMPT_TO_IMAGE_RESULT, RequestMethod.POST_JSON);

        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();

        CommonResponse response = client.executeAppToken(request, TOKEN);
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



    private OpenClient getClient() {
        return new OpenClient(proxyUrl, appId, privateKeyIsv);
    }
}
