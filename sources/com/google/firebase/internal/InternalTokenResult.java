package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public class InternalTokenResult {

    /* renamed from: a */
    private String f18049a;

    @KeepForSdk
    public InternalTokenResult(String str) {
        this.f18049a = str;
    }

    @KeepForSdk
    public String a() {
        return this.f18049a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return Objects.a(this.f18049a, ((InternalTokenResult) obj).f18049a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.a(this.f18049a);
    }

    public String toString() {
        return Objects.a(this).a("token", this.f18049a).toString();
    }
}
