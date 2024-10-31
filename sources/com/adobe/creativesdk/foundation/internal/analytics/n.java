package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: AdobeAnalyticsETSSession.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static n f4739a;

    /* renamed from: b, reason: collision with root package name */
    private A f4740b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4741c = true;

    private n() {
        this.f4740b = null;
        this.f4740b = new A(b(), "Adobe Creative SDK", null);
    }

    public static n a() {
        if (f4739a == null) {
            f4739a = new n();
        }
        return f4739a;
    }

    private String b() {
        return m.f4738a[AdobeAuthIdentityManagementService.K().w().ordinal()] != 1 ? "https://cc-api-data-stage.adobe.io/ingest" : "https://cc-api-data.adobe.io/ingest";
    }

    public com.adobe.creativesdk.foundation.internal.net.l a(String str) {
        URL url;
        byte[] bArr = null;
        if (this.f4741c) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "ETSAnalytics", str);
            try {
                url = new URL(b());
            } catch (MalformedURLException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, n.class.getSimpleName(), e2.getMessage(), e2);
                url = null;
            }
            if (url != null) {
                com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j(url, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, null);
                jVar.b(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
                jVar.b("x-api-key", AdobeAuthIdentityManagementService.K().h());
                jVar.b("Authorization", "Bearer " + AdobeAuthIdentityManagementService.K().c());
                try {
                    bArr = str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, n.class.getSimpleName(), e3.getMessage(), e3);
                }
                jVar.a(bArr);
                return this.f4740b.a(jVar, AdobeNetworkRequestPriority.NORMAL);
            }
        }
        return null;
    }
}
