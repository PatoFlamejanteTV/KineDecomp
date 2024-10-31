package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Object> f675a = new HashMap<>();

    public Object a(String str) {
        return this.f675a.get(str);
    }
}
