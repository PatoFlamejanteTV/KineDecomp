package com.crashlytics.android.beta;

import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class CheckForUpdatesRequest extends a {
    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String HEADER_BETA_TOKEN = "X-CRASHLYTICS-BETA-TOKEN";
    static final String INSTANCE = "instance";
    static final String SDK_ANDROID_DIR_TOKEN_TYPE = "3";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    public CheckForUpdatesRequest(l lVar, String str, String str2, f fVar, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(lVar, str, str2, fVar, HttpMethod.GET);
        this.responseTransform = checkForUpdatesResponseTransform;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str, String str2) {
        httpRequest.c(a.HEADER_ACCEPT, a.ACCEPT_JSON_VALUE);
        httpRequest.c(a.HEADER_USER_AGENT, a.CRASHLYTICS_USER_AGENT + this.kit.getVersion());
        httpRequest.c(a.HEADER_DEVELOPER_TOKEN, a.CLS_ANDROID_SDK_DEVELOPER_TOKEN);
        httpRequest.c(a.HEADER_CLIENT_TYPE, "android");
        httpRequest.c(a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        httpRequest.c(a.HEADER_API_KEY, str);
        httpRequest.c(HEADER_BETA_TOKEN, createBetaTokenHeaderValueFor(str2));
        return httpRequest;
    }

    static String createBetaTokenHeaderValueFor(String str) {
        return "3:" + str;
    }

    private Map<String, String> getQueryParamsFor(BuildProperties buildProperties) {
        HashMap hashMap = new HashMap();
        hashMap.put(BUILD_VERSION, buildProperties.versionCode);
        hashMap.put(DISPLAY_VERSION, buildProperties.versionName);
        hashMap.put(INSTANCE, buildProperties.buildId);
        hashMap.put("source", "3");
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.crashlytics.android.beta.CheckForUpdatesResponse invoke(java.lang.String r8, java.lang.String r9, com.crashlytics.android.beta.BuildProperties r10) {
        /*
            r7 = this;
            java.lang.String r0 = "Checking for updates request ID: "
            java.lang.String r1 = "Fabric"
            java.lang.String r2 = "X-REQUEST-ID"
            java.lang.String r3 = "Beta"
            r4 = 0
            java.util.Map r10 = r7.getQueryParamsFor(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            io.fabric.sdk.android.services.network.HttpRequest r5 = r7.getHttpRequest(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r7.applyHeadersTo(r5, r8, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            io.fabric.sdk.android.o r8 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = "Checking for updates from "
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = r7.getUrl()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.d(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            io.fabric.sdk.android.o r8 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r6 = "Checking for updates query params are: "
            r9.append(r6)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.d(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            boolean r8 = r5.l()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r8 == 0) goto L83
            io.fabric.sdk.android.o r8 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = "Checking for updates was successful"
            r8.d(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r5.a()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.<init>(r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            com.crashlytics.android.beta.CheckForUpdatesResponseTransform r9 = r7.responseTransform     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            com.crashlytics.android.beta.CheckForUpdatesResponse r8 = r9.fromJson(r8)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r5 == 0) goto L82
            java.lang.String r9 = r5.d(r2)
            io.fabric.sdk.android.o r10 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.d(r1, r9)
        L82:
            return r8
        L83:
            io.fabric.sdk.android.o r8 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.<init>()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r10 = "Checking for updates failed. Response code: "
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            int r10 = r5.g()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r9.append(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            r8.e(r3, r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lef
            if (r5 == 0) goto Lee
            java.lang.String r8 = r5.d(r2)
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            goto Le1
        Laf:
            r8 = move-exception
            goto Lb6
        Lb1:
            r8 = move-exception
            r5 = r4
            goto Lf0
        Lb4:
            r8 = move-exception
            r5 = r4
        Lb6:
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()     // Catch: java.lang.Throwable -> Lef
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lef
            r10.<init>()     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = "Error while checking for updates from "
            r10.append(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r6 = r7.getUrl()     // Catch: java.lang.Throwable -> Lef
            r10.append(r6)     // Catch: java.lang.Throwable -> Lef
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lef
            r9.c(r3, r10, r8)     // Catch: java.lang.Throwable -> Lef
            if (r5 == 0) goto Lee
            java.lang.String r8 = r5.d(r2)
            io.fabric.sdk.android.o r9 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
        Le1:
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.d(r1, r8)
        Lee:
            return r4
        Lef:
            r8 = move-exception
        Lf0:
            if (r5 == 0) goto L10c
            java.lang.String r9 = r5.d(r2)
            io.fabric.sdk.android.o r10 = io.fabric.sdk.android.f.f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.d(r1, r9)
        L10c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.CheckForUpdatesRequest.invoke(java.lang.String, java.lang.String, com.crashlytics.android.beta.BuildProperties):com.crashlytics.android.beta.CheckForUpdatesResponse");
    }
}
