package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class ResumableUploadByteRequest extends a {
    private final String o;
    private final byte[] p;
    private final long q;
    private final boolean r;
    private final int s;

    public ResumableUploadByteRequest(Uri uri, FirebaseApp firebaseApp, String str, byte[] bArr, long j, int i, boolean z) {
        super(uri, firebaseApp);
        if (TextUtils.isEmpty(str)) {
            this.f18182f = new IllegalArgumentException("uploadURL is null or empty");
        }
        if (bArr == null && i != -1) {
            this.f18182f = new IllegalArgumentException("contentType is null or empty");
        }
        if (j < 0) {
            this.f18182f = new IllegalArgumentException("offset cannot be negative");
        }
        this.s = i;
        this.o = str;
        this.p = i <= 0 ? null : bArr;
        this.q = j;
        this.r = z;
        super.a("X-Goog-Upload-Protocol", "resumable");
        if (this.r && this.s > 0) {
            super.a("X-Goog-Upload-Command", "upload, finalize");
        } else if (this.r) {
            super.a("X-Goog-Upload-Command", "finalize");
        } else {
            super.a("X-Goog-Upload-Command", "upload");
        }
        super.a("X-Goog-Upload-Offset", Long.toString(this.q));
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String a() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected byte[] e() {
        return this.p;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected int f() {
        int i = this.s;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String o() {
        return this.o;
    }
}
