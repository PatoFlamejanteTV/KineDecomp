package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.SlashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class ResumableUploadStartRequest extends a {
    private final JSONObject o;
    private final String p;

    public ResumableUploadStartRequest(Uri uri, FirebaseApp firebaseApp, JSONObject jSONObject, String str) {
        super(uri, firebaseApp);
        this.o = jSONObject;
        this.p = str;
        if (TextUtils.isEmpty(this.p)) {
            this.f18182f = new IllegalArgumentException("mContentType is null or empty");
        }
        super.a("X-Goog-Upload-Protocol", "resumable");
        super.a("X-Goog-Upload-Command", "start");
        super.a("X-Goog-Upload-Header-Content-Type", this.p);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String a() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected JSONObject d() {
        return this.o;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String h() throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String g2 = g();
        arrayList.add("name");
        arrayList2.add(g2 != null ? SlashUtil.d(g2) : "");
        arrayList.add("uploadType");
        arrayList2.add("resumable");
        return a(arrayList, arrayList2, false);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String o() {
        return NetworkRequest.f18178b + this.f18181e.getAuthority() + "/o";
    }
}
