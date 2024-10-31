package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.ads.ih */
/* loaded from: classes2.dex */
final class C0944ih extends ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        SecureRandom zzakb;
        zzakb = zzboy.zzakb();
        return zzakb;
    }
}
