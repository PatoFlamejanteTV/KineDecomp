package com.mixpanel.android.java_websocket.exceptions;

import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class InvalidFrameException extends InvalidDataException {
    private static final long serialVersionUID = -9016496369828887591L;

    public InvalidFrameException() {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE);
    }

    public InvalidFrameException(String str) {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, str);
    }

    public InvalidFrameException(Throwable th) {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, th);
    }

    public InvalidFrameException(String str, Throwable th) {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, str, th);
    }
}
