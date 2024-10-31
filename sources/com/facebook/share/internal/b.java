package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeStatusClient.java */
@Deprecated
/* loaded from: classes.dex */
public final class B extends PlatformServiceClient {

    /* renamed from: a */
    private String f9500a;

    public B(Context context, String str, String str2) {
        super(context, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20141001, str);
        this.f9500a = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    protected void populateRequestBundle(Bundle bundle) {
        bundle.putString(ShareConstants.EXTRA_OBJECT_ID, this.f9500a);
    }
}
