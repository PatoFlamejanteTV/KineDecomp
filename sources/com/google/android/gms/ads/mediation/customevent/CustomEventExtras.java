package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: a */
    private final HashMap<String, Object> f10305a = new HashMap<>();

    public final Object a(String str) {
        return this.f10305a.get(str);
    }
}
