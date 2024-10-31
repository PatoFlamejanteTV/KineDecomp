package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class GetNetworkRequest extends NetworkRequest {
    public GetNetworkRequest(Uri uri, FirebaseApp firebaseApp, long j) {
        super(uri, firebaseApp);
        if (j != 0) {
            super.a("Range", "bytes=" + j + "-");
        }
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String a() {
        return "GET";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String h() throws UnsupportedEncodingException {
        return a(Collections.singletonList("alt"), Collections.singletonList("media"), true);
    }
}
