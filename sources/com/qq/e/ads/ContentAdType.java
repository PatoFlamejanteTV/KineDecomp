package com.qq.e.ads;

import com.umeng.commonsdk.proguard.e;

/* loaded from: classes3.dex */
public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        if (e.an.equals(str)) {
            return AD;
        }
        if ("information".equals(str)) {
            return INFORMATION;
        }
        return null;
    }
}
