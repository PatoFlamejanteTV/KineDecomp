package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class zabw {

    /* renamed from: a */
    public final RegisterListenerMethod<Api.AnyClient, ?> f10905a;

    /* renamed from: b */
    public final UnregisterListenerMethod<Api.AnyClient, ?> f10906b;

    public zabw(RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        this.f10905a = registerListenerMethod;
        this.f10906b = unregisterListenerMethod;
    }
}
