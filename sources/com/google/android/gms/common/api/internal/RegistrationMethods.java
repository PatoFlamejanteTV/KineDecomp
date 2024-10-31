package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;

@KeepForSdk
/* loaded from: classes.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {

    /* renamed from: a */
    public final RegisterListenerMethod<A, L> f10794a;

    /* renamed from: b */
    public final UnregisterListenerMethod<A, L> f10795b;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, L> {

        /* renamed from: a */
        private boolean f10796a = true;

        private Builder() {
        }
    }
}
