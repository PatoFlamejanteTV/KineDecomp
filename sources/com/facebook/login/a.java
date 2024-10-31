package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;

/* compiled from: GetTokenClient.java */
/* loaded from: classes.dex */
final class a extends PlatformServiceClient {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str) {
        super(context, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, NativeProtocol.PROTOCOL_VERSION_20121101, str);
    }

    @Override // com.facebook.internal.PlatformServiceClient
    protected void populateRequestBundle(Bundle bundle) {
    }
}
