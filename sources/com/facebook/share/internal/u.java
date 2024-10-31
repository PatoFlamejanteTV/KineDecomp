package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;

/* compiled from: LikeStatusClient.java */
/* loaded from: classes.dex */
final class u extends PlatformServiceClient {

    /* renamed from: a, reason: collision with root package name */
    private String f377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, String str, String str2) {
        super(context, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20141001, str);
        this.f377a = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    protected void populateRequestBundle(Bundle bundle) {
        bundle.putString(ShareConstants.EXTRA_OBJECT_ID, this.f377a);
    }
}
