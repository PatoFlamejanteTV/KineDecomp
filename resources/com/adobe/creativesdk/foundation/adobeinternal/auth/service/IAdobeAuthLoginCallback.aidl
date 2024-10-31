package com.adobe.creativesdk.foundation.adobeinternal.auth.service;
import com.adobe.creativesdk.foundation.adobeinternal.auth.service.AdobeAuthServiceUserProfile;


// Interface informing the client of Login related events.
interface IAdobeAuthLoginCallback {


    void onSuccess(inout AdobeAuthServiceUserProfile userProfile);


    void onError(int errorCode);
}
