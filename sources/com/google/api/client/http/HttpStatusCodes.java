package com.google.api.client.http;

import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes2.dex */
public class HttpStatusCodes {
    public static boolean a(int i) {
        if (i == 307) {
            return true;
        }
        switch (i) {
            case ErrorCode.InitError.INIT_ADMANGER_ERROR /* 301 */:
            case ErrorCode.InitError.INIT_PLUGIN_ERROR /* 302 */:
            case ErrorCode.InitError.GET_INTERFACE_ERROR /* 303 */:
                return true;
            default:
                return false;
        }
    }

    public static boolean b(int i) {
        return i >= 200 && i < 300;
    }
}
