// IAdobeAuthStatusAIDL.aidl
package com.adobe.creativesdk.foundation.adobeinternal.auth.service;

import com.adobe.creativesdk.foundation.adobeinternal.auth.service.AdobeAuthServiceUserProfile;
import com.adobe.creativesdk.foundation.adobeinternal.auth.service.AdobeAuthLoginParams;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.auth.service.IAdobeAuthLoginCallback;
import com.adobe.creativesdk.foundation.adobeinternal.auth.service.IAdobeAuthLogoutCallback;



interface IAdobeAuthService {


    //Returns whether or not there is a currently logged in user.
    boolean isUserAuthenticated();

    //Returns the profile of the currently logged-in user.
    AdobeAuthServiceUserProfile getUserProfile();

    //Logs in the user.
    void login(in AdobeAuthLoginParams params, IAdobeAuthLoginCallback callback);

    // Logs out the user.
    void logout(IAdobeAuthLogoutCallback callback);

    // Launches a Sign Up dialog.
    void signUp(in AdobeAuthLoginParams params , IAdobeAuthLoginCallback callback);

    //Contact the authentication provider to open and handle the continuable error event.
    void openContinuationAuthEvent(inout AdobeAuthErrorCode errorCode,in AdobeAuthLoginParams params,IAdobeAuthLoginCallback callback);



}
