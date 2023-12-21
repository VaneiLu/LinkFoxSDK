package com.example.linkfox;

import com.alibaba.fastjson.JSONObject;
import com.example.linkfox.req.*;
import com.example.linkfox.resp.*;
import com.fzzixun.openapi.sdk.client.OpenClient;
import com.fzzixun.openapi.sdk.common.RequestMethod;
import com.fzzixun.openapi.sdk.request.AppTokenRequest;
import com.fzzixun.openapi.sdk.request.CommonRequest;
import com.fzzixun.openapi.sdk.response.AppTokenResponse;
import com.fzzixun.openapi.sdk.response.CommonResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class LinkFoxApplicationTests {
    public static final String PROMPT_TO_IMAGE = "/linkfox-ai/image/v1/chat/completion/create/1";
    public static final String PROMPT_TO_IMAGE_RESULT = "/linkfox-ai/image/v1/chat/completion/info/1";

    public static final String IMAGE_TO_IMAGE = "/linkfox-ai/image/v1/chat/completion/create/2";
    public static final String IMAGE_TO_IMAGE_RESULT = "/linkfox-ai/image/v1/chat/completion/info/2";
    public static final String IMAGE_TO_PROMPT = "/linkfox-ai/image/v1/chat/completion/create/3";
    public static final String IMAGE_TO_PROMPT_RESULT = "/linkfox-ai/image/v1/chat/completion/info/3";
    public static final String IMAGE_VARIANT = "/linkfox-ai/image/v1/chat/completion/create/4";
    public static final String IMAGE_VARIANT_RESULT = "/linkfox-ai/image/v1/chat/completion/info/4";
    public static final String IMAGE_UP_SAMPLE = "/linkfox-ai/image/v1/make/create/7";
    public static final String IMAGE_UP_SAMPLE_RESULT = "/linkfox-ai/image/v1/make/info/7";

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

    public static final String TOKEN = "69eb54c19a68fd6e3f7986e381160a8e";

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
        PromptToImageReq.ContentDTO contentDTO = new PromptToImageReq.ContentDTO();
        contentDTO.setPrompt("a boxer on the ring");
        req.setContent(contentDTO);
        req.setChatId("");
        CommonRequest request = new CommonRequest(PROMPT_TO_IMAGE, RequestMethod.POST_JSON);
        request.setBizContent(JSONObject.toJSONString(req));
        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            PromptToImageResp dataObj = response.getDataObj(PromptToImageResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));

        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void promptToImageResult() {

        OnlyIdReq req = new OnlyIdReq();
        req.setId("101742");
        CommonRequest request = new CommonRequest(PROMPT_TO_IMAGE_RESULT, RequestMethod.POST_JSON);

        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();

        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            PromptToImageResultResp dataObj = response.getDataObj(PromptToImageResultResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void imageToImage() {
        CommonRequest request = new CommonRequest(IMAGE_TO_IMAGE, RequestMethod.POST_JSON);
        ImageToImageReq req = new ImageToImageReq();
        ImageToImageReq.ContentDTO contentDTO = new ImageToImageReq.ContentDTO();
        List<ImageToImageReq.ContentDTO.ImagesDTO> imagesList = new ArrayList<>();
        ImageToImageReq.ContentDTO.ImagesDTO imagesDTO = new ImageToImageReq.ContentDTO.ImagesDTO();
        imagesDTO.setUrl("https://tse4-mm.cn.bing.net/th/id/OIP-C.r4I2abQvGMup_fx42SU5egHaEo?rs=1&pid=ImgDetMain");
        imagesList.add(imagesDTO);
        contentDTO.setImages(imagesList);
        contentDTO.setPrompt("cute puppy");
        contentDTO.setWeight("1");
        contentDTO.setRatioStr("494:296");
        req.setContent(contentDTO);
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();

        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            ImageToImageResp dataObj = response.getDataObj(ImageToImageResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void imageToImageResult() {
        CommonRequest request = new CommonRequest(IMAGE_TO_IMAGE_RESULT, RequestMethod.POST_JSON);
        OnlyIdReq req = new OnlyIdReq();
        req.setId("104006");
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();

        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            ImageToImageResultResp dataObj = response.getDataObj(ImageToImageResultResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));

        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void imageToPrompt() {
        CommonRequest request = new CommonRequest(IMAGE_TO_PROMPT, RequestMethod.POST_JSON);
        ImageToPromptReq req = new ImageToPromptReq();
        ImageToPromptReq.ContentDTO.ImagesDTO imagesDTO = new ImageToPromptReq.ContentDTO.ImagesDTO();
        ImageToPromptReq.ContentDTO contentDTO = new ImageToPromptReq.ContentDTO();
        imagesDTO.setUrl("https://tse4-mm.cn.bing.net/th/id/OIP-C.r4I2abQvGMup_fx42SU5egHaEo?rs=1&pid=ImgDetMain");
        contentDTO.setImages(Collections.singletonList(imagesDTO));
        req.setContent(contentDTO);
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();

        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            ImageToPromptResp dataObj = response.getDataObj(ImageToPromptResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));

        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void imageToPromptResult() {
        CommonRequest request = new CommonRequest(IMAGE_TO_PROMPT_RESULT, RequestMethod.POST_JSON);
        OnlyIdReq req = new OnlyIdReq();
        req.setId("103674");
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();

        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            ImageToPromptResultResp dataObj = response.getDataObj(ImageToPromptResultResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));

        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void imageVariant() {
        CommonRequest request = new CommonRequest(IMAGE_VARIANT, RequestMethod.POST_JSON);
        ImageVariantReq req = new ImageVariantReq();
        ImageVariantReq.ContentDTO.ImagesDTO imagesDTO = new ImageVariantReq.ContentDTO.ImagesDTO();
        ImageVariantReq.ContentDTO contentDTO = new ImageVariantReq.ContentDTO();
        contentDTO.setAction(1);
        imagesDTO.setId("684394");
        contentDTO.setImages(Collections.singletonList(imagesDTO));
        req.setContent(contentDTO);
        req.setChatId("8026");
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();
        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            ImageVariantResp dataObj = response.getDataObj(ImageVariantResp.class);
            JSONObject.toJSONString(dataObj);

        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void imageVariantResult() {
        CommonRequest request = new CommonRequest(IMAGE_VARIANT_RESULT, RequestMethod.POST_JSON);
        OnlyIdReq req = new OnlyIdReq();
        req.setId("104580");
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();
        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            ImageVariantResultResp dataObj = response.getDataObj(ImageVariantResultResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));
        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void upSample() {
        CommonRequest request = new CommonRequest(IMAGE_UP_SAMPLE, RequestMethod.POST_JSON);
        UpSampleReq req = new UpSampleReq();
        UpSampleReq.ExtendFieldsDTO extendFieldsDTO = new UpSampleReq.ExtendFieldsDTO();
        extendFieldsDTO.setMagnification("2");
        req.setOutputNum("1");
        req.setImageUrl("https://linkfoxai-ailab-prod.oss-cn-shenzhen.aliyuncs.com/IMAGE_CHAT_IMAGE_ACTION/0/2023/12/20/155114505663_8cc2b35c9f0c11ee959a00163e1498fe_upsample_4.jpg?Expires=1703087544&OSSAccessKeyId=LTAI5tQMD3UtDGPmMJRik6JA&Signature=4%2BkBiTrRuO72B%2BPZE1yIe86OZAY%3D");
        req.setExtendFields(extendFieldsDTO);
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();
        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            UpSampeResp dataObj = response.getDataObj(UpSampeResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));

        } else {
            // 请求失败，对返回结果进行处理
            System.out.println(response.getBody());
            System.out.println(response.getErrorMsg());
        }
    }

    @Test
    public void upSampleResult() {
        CommonRequest request = new CommonRequest(IMAGE_UP_SAMPLE_RESULT, RequestMethod.POST_JSON);
        OnlyIdReq req = new OnlyIdReq();
        req.setId("193846");
        request.setBizContent(JSONObject.toJSONString(req));
        OpenClient client = getClient();
        CommonResponse response = client.executeAppToken(request, TOKEN);
        if (response.isSuccess()) {
            // 请求成功，对返回结果进行处理
            UpSampleResultResp dataObj = response.getDataObj(UpSampleResultResp.class);
            System.out.println(JSONObject.toJSONString(dataObj));
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
