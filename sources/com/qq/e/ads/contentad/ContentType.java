package com.qq.e.ads.contentad;

/* loaded from: classes3.dex */
public enum ContentType {
    ARTICLE,
    VIDEO;

    public static ContentType fromString(String str) {
        if ("article".equals(str)) {
            return ARTICLE;
        }
        if ("video".equals(str)) {
            return VIDEO;
        }
        return null;
    }
}
