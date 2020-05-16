package org.study.asdl.utils.txyun;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;


/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020-05-12 09:55
 * @Description:
 */
public class SmsSend {

    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKIDrZVBaTKUbS4Xjdih5GAoCI7D2l9IOlqe", "hAUXImzvay54apwoTrHSgf6FAsFMDsGR");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            String params = "{\"PhoneNumberSet\":[\"+8615071392085\"],\"TemplateID\":\"603186\",\"Sign\":\"chisj网\",\"TemplateParamSet\":[\"555555\"],\"SessionContext\":\"123456\",\"SmsSdkAppid\":\"1400368025\"}";
            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);

            SendSmsResponse resp = client.SendSms(req);

            System.out.println(SendSmsRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }


}
