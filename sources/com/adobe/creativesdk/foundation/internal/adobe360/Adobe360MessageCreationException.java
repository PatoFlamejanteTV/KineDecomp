package com.adobe.creativesdk.foundation.internal.adobe360;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Adobe360MessageCreationException extends AdobeCSDKException {
    public static final String Adobe30MessageKey = "Adobe360Message";

    public Adobe360MessageCreationException(HashMap<String, Object> hashMap) {
        super(hashMap);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException
    public String getDescription() {
        return null;
    }

    public Adobe360MessageCreationException(HashMap<String, Object> hashMap, Exception exc) {
        super(hashMap, exc);
    }
}
