package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.facebook.share.internal.ShareConstants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeStorageAsyncResponseHandler.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0332b {

    /* renamed from: a, reason: collision with root package name */
    long f5377a;

    /* renamed from: b, reason: collision with root package name */
    sa f5378b;

    /* renamed from: c, reason: collision with root package name */
    ra f5379c;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0332b(long j, ra raVar, sa saVar) {
        this.f5377a = j;
        this.f5378b = saVar;
        this.f5379c = raVar;
    }

    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Handler handler;
        try {
            String string = new JSONObject(lVar.d()).getString(ShareConstants.WEB_DIALOG_PARAM_HREF);
            try {
                handler = new Handler();
            } catch (Exception unused) {
                handler = null;
            }
            a(string, this.f5377a, handler);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, Handler handler) {
        try {
            ra raVar = this.f5379c;
            URL url = new URI(raVar.c("files").a().toString() + str).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            raVar.a(jVar, (String) null, (byte[]) null, new C0331a(this, j, str, handler), handler);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
        }
    }
}
