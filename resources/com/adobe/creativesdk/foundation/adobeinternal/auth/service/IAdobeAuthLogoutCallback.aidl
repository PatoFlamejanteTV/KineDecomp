package com.adobe.creativesdk.foundation.adobeinternal.auth.service;

// Interface informing the client of logout related events.
interface IAdobeAuthLogoutCallback {


       void onSuccess();


       void onError(int errorCode);
}
