package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class GmsLogger {

    /* renamed from: a */
    private final String f11108a;

    /* renamed from: b */
    private final String f11109b;

    public GmsLogger(String str, String str2) {
        Preconditions.a(str, (Object) "log tag cannot be null");
        Preconditions.a(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f11108a = str;
        if (str2 != null && str2.length() > 0) {
            this.f11109b = str2;
        } else {
            this.f11109b = null;
        }
    }

    public GmsLogger(String str) {
        this(str, null);
    }
}
