package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class ResumableUploadQueryRequest extends a {
    private final String o;

    public ResumableUploadQueryRequest(Uri uri, FirebaseApp firebaseApp, String str) {
        super(uri, firebaseApp);
        if (TextUtils.isEmpty(str)) {
            this.f18182f = new IllegalArgumentException("uploadURL is null or empty");
        }
        this.o = str;
        super.a("X-Goog-Upload-Protocol", "resumable");
        super.a("X-Goog-Upload-Command", "query");
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String a() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String o() {
        return this.o;
    }
}
