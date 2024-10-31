package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class zzn extends zzd {

    /* renamed from: a, reason: collision with root package name */
    private volatile String f747a;
    private Future<String> b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzn(zzf zzfVar) {
        super(zzfVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    private boolean a(Context context, String str) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.a(str);
        com.google.android.gms.common.internal.zzx.c("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        try {
            try {
                try {
                    a("Storing clientId", str);
                    fileOutputStream = context.openFileOutput("gaClientId", 0);
                    fileOutputStream.write(str.getBytes());
                    z = true;
                    fileOutputStream = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            fileOutputStream = fileOutputStream;
                        } catch (IOException e) {
                            e("Failed to close clientId writing stream", e);
                            fileOutputStream = "Failed to close clientId writing stream";
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e("Error creating clientId file", e2);
                    fileOutputStream = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            fileOutputStream = fileOutputStream;
                        } catch (IOException e3) {
                            e("Failed to close clientId writing stream", e3);
                            fileOutputStream = "Failed to close clientId writing stream";
                        }
                    }
                }
            } catch (IOException e4) {
                e("Error writing to clientId file", e4);
                fileOutputStream = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        fileOutputStream = fileOutputStream;
                    } catch (IOException e5) {
                        e("Failed to close clientId writing stream", e5);
                        fileOutputStream = "Failed to close clientId writing stream";
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    e("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        String e = e();
        try {
            return !a(r().c(), e) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : e;
        } catch (Exception e2) {
            e("Error saving clientId file", e2);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x008b -> B:10:0x002e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x008d -> B:10:0x002e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0092 -> B:10:0x002e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String a(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.zzx.c(r1)
            java.lang.String r1 = "gaClientId"
            java.io.FileInputStream r2 = r7.openFileInput(r1)     // Catch: java.io.FileNotFoundException -> L70 java.io.IOException -> L7f java.lang.Throwable -> L98
            r1 = 36
            byte[] r3 = new byte[r1]     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            r1 = 0
            int r4 = r3.length     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            int r4 = r2.read(r3, r1, r4)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            int r1 = r2.available()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            if (r1 <= 0) goto L36
            java.lang.String r1 = "clientId file seems corrupted, deleting it."
            r6.e(r1)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            r2.close()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            java.lang.String r1 = "gaClientId"
            r7.deleteFile(r1)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.io.IOException -> L2f
        L2e:
            return r0
        L2f:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.e(r2, r1)
            goto L2e
        L36:
            r1 = 14
            if (r4 >= r1) goto L54
            java.lang.String r1 = "clientId file is empty, deleting it."
            r6.e(r1)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            r2.close()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            java.lang.String r1 = "gaClientId"
            r7.deleteFile(r1)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.io.IOException -> L4d
            goto L2e
        L4d:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.e(r2, r1)
            goto L2e
        L54:
            r2.close()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            r5 = 0
            r1.<init>(r3, r5, r4)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            java.lang.String r3 = "Read client id from disk"
            r6.a(r3, r1)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Laa java.io.FileNotFoundException -> Lac
            if (r2 == 0) goto L67
            r2.close()     // Catch: java.io.IOException -> L69
        L67:
            r0 = r1
            goto L2e
        L69:
            r0 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.e(r2, r0)
            goto L67
        L70:
            r1 = move-exception
            r1 = r0
        L72:
            if (r1 == 0) goto L2e
            r1.close()     // Catch: java.io.IOException -> L78
            goto L2e
        L78:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.e(r2, r1)
            goto L2e
        L7f:
            r1 = move-exception
            r2 = r0
        L81:
            java.lang.String r3 = "Error reading client id file, deleting it"
            r6.e(r3, r1)     // Catch: java.lang.Throwable -> La8
            java.lang.String r1 = "gaClientId"
            r7.deleteFile(r1)     // Catch: java.lang.Throwable -> La8
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.io.IOException -> L91
            goto L2e
        L91:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.e(r2, r1)
            goto L2e
        L98:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L9b:
            if (r2 == 0) goto La0
            r2.close()     // Catch: java.io.IOException -> La1
        La0:
            throw r0
        La1:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.e(r2, r1)
            goto La0
        La8:
            r0 = move-exception
            goto L9b
        Laa:
            r1 = move-exception
            goto L81
        Lac:
            r1 = move-exception
            r1 = r2
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzn.a(android.content.Context):java.lang.String");
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
    }

    public String b() {
        String str;
        D();
        synchronized (this) {
            if (this.f747a == null) {
                this.b = r().a(new u(this));
            }
            if (this.b != null) {
                try {
                    this.f747a = this.b.get();
                } catch (InterruptedException e) {
                    d("ClientId loading or generation was interrupted", e);
                    this.f747a = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (ExecutionException e2) {
                    e("Failed to load or generate client id", e2);
                    this.f747a = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                if (this.f747a == null) {
                    this.f747a = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                a("Loaded clientId", this.f747a);
                this.b = null;
            }
            str = this.f747a;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        synchronized (this) {
            this.f747a = null;
            this.b = r().a(new v(this));
        }
        return b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        String a2 = a(r().c());
        return a2 == null ? f() : a2;
    }

    protected String e() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
