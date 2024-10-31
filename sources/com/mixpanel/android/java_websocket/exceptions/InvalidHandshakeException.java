package com.mixpanel.android.java_websocket.exceptions;

import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class InvalidHandshakeException extends InvalidDataException {
    private static final long serialVersionUID = -1426533877490484964L;

    public InvalidHandshakeException() {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE);
    }

    public InvalidHandshakeException(String str, Throwable th) {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, str, th);
    }

    public InvalidHandshakeException(String str) {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, str);
    }

    public InvalidHandshakeException(Throwable th) {
        super(LicenseErrCode.ERROR_NOT_BIND_TO_SERVICE, th);
    }
}
