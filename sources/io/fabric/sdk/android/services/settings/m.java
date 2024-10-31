package io.fabric.sdk.android.services.settings;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultSettingsSpiCall.java */
/* loaded from: classes3.dex */
public class m extends io.fabric.sdk.android.services.common.a implements y {
    public m(io.fabric.sdk.android.l lVar, String str, String str2, io.fabric.sdk.android.services.network.f fVar) {
        this(lVar, str, str2, fVar, HttpMethod.GET);
    }

    private Map<String, String> b(x xVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", xVar.j);
        hashMap.put("display_version", xVar.i);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(xVar.k));
        String str = xVar.l;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = xVar.f27071h;
        if (!CommonUtils.b(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Type inference failed for: r3v0, types: [io.fabric.sdk.android.services.network.HttpRequest] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // io.fabric.sdk.android.services.settings.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(io.fabric.sdk.android.services.settings.x r9) {
        /*
            r8 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r8.b(r9)     // Catch: java.lang.Throwable -> L69 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6c
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.getHttpRequest(r4)     // Catch: java.lang.Throwable -> L69 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6c
            r8.a(r5, r9)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = r8.getUrl()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r6 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r9.d(r2, r6)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r6.append(r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            java.lang.String r4 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            r9.d(r2, r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            org.json.JSONObject r3 = r8.a(r5)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L67 java.lang.Throwable -> L84
            if (r5 == 0) goto L83
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L55:
            r4.append(r1)
            java.lang.String r0 = r5.d(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.d(r2, r0)
            goto L83
        L67:
            r9 = move-exception
            goto L6e
        L69:
            r9 = move-exception
            r5 = r3
            goto L85
        L6c:
            r9 = move-exception
            r5 = r3
        L6e:
            io.fabric.sdk.android.o r4 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = "Settings request failed."
            r4.c(r2, r6, r9)     // Catch: java.lang.Throwable -> L84
            if (r5 == 0) goto L83
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L55
        L83:
            return r3
        L84:
            r9 = move-exception
        L85:
            if (r5 == 0) goto La1
            io.fabric.sdk.android.o r3 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r0 = r5.d(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.d(r2, r0)
        La1:
            goto La3
        La2:
            throw r9
        La3:
            goto La2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.m.a(io.fabric.sdk.android.services.settings.x):org.json.JSONObject");
    }

    boolean a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    m(io.fabric.sdk.android.l lVar, String str, String str2, io.fabric.sdk.android.services.network.f fVar, HttpMethod httpMethod) {
        super(lVar, str, str2, fVar, httpMethod);
    }

    JSONObject a(HttpRequest httpRequest) {
        int g2 = httpRequest.g();
        io.fabric.sdk.android.f.f().d("Fabric", "Settings result was: " + g2);
        if (a(g2)) {
            return a(httpRequest.a());
        }
        io.fabric.sdk.android.f.f().e("Fabric", "Failed to retrieve settings from " + getUrl());
        return null;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            io.fabric.sdk.android.f.f().a("Fabric", "Failed to parse settings JSON from " + getUrl(), e2);
            io.fabric.sdk.android.f.f().d("Fabric", "Settings response " + str);
            return null;
        }
    }

    private HttpRequest a(HttpRequest httpRequest, x xVar) {
        a(httpRequest, io.fabric.sdk.android.services.common.a.HEADER_API_KEY, xVar.f27064a);
        a(httpRequest, io.fabric.sdk.android.services.common.a.HEADER_CLIENT_TYPE, "android");
        a(httpRequest, io.fabric.sdk.android.services.common.a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        a(httpRequest, io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
        a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", xVar.f27065b);
        a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", xVar.f27066c);
        a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", xVar.f27067d);
        a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", xVar.f27069f);
        if (TextUtils.isEmpty(xVar.f27068e)) {
            a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", xVar.f27070g);
        } else {
            a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", xVar.f27068e);
        }
        return httpRequest;
    }

    private void a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.c(str, str2);
        }
    }
}
