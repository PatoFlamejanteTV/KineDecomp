package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginStatusClient.java */
/* loaded from: classes.dex */
public final class E extends PlatformServiceClient {

    /* renamed from: a */
    private final String f9359a;

    /* renamed from: b */
    private final String f9360b;

    /* renamed from: c */
    private final long f9361c;

    public E(Context context, String str, String str2, String str3, long j) {
        super(context, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20170411, str);
        this.f9359a = str2;
        this.f9360b = str3;
        this.f9361c = j;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    protected void populateRequestBundle(Bundle bundle) {
        bundle.putString(NativeProtocol.EXTRA_LOGGER_REF, this.f9359a);
        bundle.putString(NativeProtocol.EXTRA_GRAPH_API_VERSION, this.f9360b);
        bundle.putLong(NativeProtocol.EXTRA_TOAST_DURATION_MS, this.f9361c);
    }
}
