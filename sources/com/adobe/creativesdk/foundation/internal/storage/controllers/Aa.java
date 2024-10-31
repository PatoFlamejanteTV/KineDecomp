package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.net.Uri;
import android.os.AsyncTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* loaded from: classes.dex */
public class Aa extends AsyncTask<byte[], Integer, Uri> {

    /* renamed from: a, reason: collision with root package name */
    boolean f5507a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ba f5508b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(Ba ba) {
        this.f5508b = ba;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri doInBackground(byte[]... r6) {
        /*
            r5 = this;
            r0 = 0
            r5.f5507a = r0
            r1 = 1
            r2 = 0
            if (r6 != 0) goto La
            r5.f5507a = r1
            return r2
        La:
            r6 = r6[r0]
            if (r6 != 0) goto L11
            r5.f5507a = r1
            return r2
        L11:
            com.adobe.creativesdk.foundation.internal.storage.controllers.Ba r0 = r5.f5508b
            com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity r1 = r0.f5591b
            com.adobe.creativesdk.foundation.storage.a r0 = r0.f5590a
            java.lang.String r0 = r1.a(r0)
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            com.adobe.creativesdk.foundation.internal.storage.controllers.Ba r3 = r5.f5508b     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity r3 = r3.f5591b     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.io.File r3 = r3.f6157e     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r4.<init>()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r4.append(r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.String r0 = ".png"
            r4.append(r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r1.<init>(r3, r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            boolean r0 = r1.createNewFile()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            if (r0 == 0) goto L5e
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r0.write(r6)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            r0.flush()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            com.adobe.creativesdk.foundation.internal.storage.controllers.Ba r6 = r5.f5508b     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity r6 = r6.f5591b     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            com.adobe.creativesdk.foundation.internal.storage.controllers.Ba r3 = r5.f5508b     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity r3 = r3.f5591b     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d r3 = r3.r     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            java.lang.String r3 = r3.a()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            android.net.Uri r6 = android.support.v4.content.FileProvider.getUriForFile(r6, r3, r1)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L7b
            r2 = r6
            goto L5f
        L5c:
            r6 = move-exception
            goto L6e
        L5e:
            r0 = r2
        L5f:
            if (r0 == 0) goto L7a
            r0.close()     // Catch: java.io.IOException -> L65
            goto L7a
        L65:
            r6 = move-exception
            r6.printStackTrace()
            goto L7a
        L6a:
            r6 = move-exception
            goto L7d
        L6c:
            r6 = move-exception
            r0 = r2
        L6e:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r1 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "AdobeUXMobilePackageItemOneUpViewerActivity"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r1, r3, r2, r6)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L7a
            r0.close()     // Catch: java.io.IOException -> L65
        L7a:
            return r2
        L7b:
            r6 = move-exception
            r2 = r0
        L7d:
            if (r2 == 0) goto L87
            r2.close()     // Catch: java.io.IOException -> L83
            goto L87
        L83:
            r0 = move-exception
            r0.printStackTrace()
        L87:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.Aa.doInBackground(byte[][]):android.net.Uri");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
    }
}
