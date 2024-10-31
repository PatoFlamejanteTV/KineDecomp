package com.google.firebase.iid;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private int f17389a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, TaskCompletionSource<Void>> f17390b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    private final C1620r f17391c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(C1620r c1620r) {
        this.f17391c = c1620r;
    }

    private final String b() {
        String a2;
        synchronized (this.f17391c) {
            a2 = this.f17391c.a();
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String[] split = a2.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a() {
        return b() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x000c, code lost:            if (com.google.firebase.iid.FirebaseInstanceId.h() == false) goto L8;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x000e, code lost:            android.util.Log.d("FirebaseInstanceId", "topic sync succeeded");     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0016, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.google.firebase.iid.FirebaseInstanceId r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            java.lang.String r0 = r4.b()     // Catch: java.lang.Throwable -> L42
            r1 = 1
            if (r0 != 0) goto L17
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.h()     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto L15
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch: java.lang.Throwable -> L42
        L15:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            return r1
        L17:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            boolean r2 = a(r5, r0)
            if (r2 != 0) goto L20
            r5 = 0
            return r5
        L20:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>> r2 = r4.f17390b     // Catch: java.lang.Throwable -> L3f
            int r3 = r4.f17389a     // Catch: java.lang.Throwable -> L3f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = r2.remove(r3)     // Catch: java.lang.Throwable -> L3f
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch: java.lang.Throwable -> L3f
            r4.a(r0)     // Catch: java.lang.Throwable -> L3f
            int r0 = r4.f17389a     // Catch: java.lang.Throwable -> L3f
            int r0 = r0 + r1
            r4.f17389a = r0     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L0
            r0 = 0
            r2.a(r0)
            goto L0
        L3f:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            throw r5
        L42:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            goto L46
        L45:
            throw r5
        L46:
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.v.a(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    private final synchronized boolean a(String str) {
        synchronized (this.f17391c) {
            String a2 = this.f17391c.a();
            String valueOf = String.valueOf(str);
            if (!a2.startsWith(valueOf.length() != 0 ? ",".concat(valueOf) : new String(","))) {
                return false;
            }
            String valueOf2 = String.valueOf(str);
            this.f17391c.a(a2.substring((valueOf2.length() != 0 ? ",".concat(valueOf2) : new String(",")).length()));
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:            if (r4 == 1) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:            r7.b(r8);     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:            if (com.google.firebase.iid.FirebaseInstanceId.h() == false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:            android.util.Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.google.firebase.iid.FirebaseInstanceId r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "!"
            java.lang.String[] r8 = r8.split(r1)
            int r1 = r8.length
            r2 = 1
            r3 = 2
            if (r1 != r3) goto L75
            r1 = 0
            r3 = r8[r1]
            r8 = r8[r2]
            r4 = -1
            int r5 = r3.hashCode()     // Catch: java.io.IOException -> L56
            r6 = 83
            if (r5 == r6) goto L2a
            r6 = 85
            if (r5 == r6) goto L20
            goto L33
        L20:
            java.lang.String r5 = "U"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L56
            if (r3 == 0) goto L33
            r4 = 1
            goto L33
        L2a:
            java.lang.String r5 = "S"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L56
            if (r3 == 0) goto L33
            r4 = 0
        L33:
            if (r4 == 0) goto L47
            if (r4 == r2) goto L38
            goto L75
        L38:
            r7.b(r8)     // Catch: java.io.IOException -> L56
            boolean r7 = com.google.firebase.iid.FirebaseInstanceId.h()     // Catch: java.io.IOException -> L56
            if (r7 == 0) goto L75
            java.lang.String r7 = "unsubscribe operation succeeded"
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L56
            goto L75
        L47:
            r7.a(r8)     // Catch: java.io.IOException -> L56
            boolean r7 = com.google.firebase.iid.FirebaseInstanceId.h()     // Catch: java.io.IOException -> L56
            if (r7 == 0) goto L75
            java.lang.String r7 = "subscribe operation succeeded"
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L56
            goto L75
        L56:
            r7 = move-exception
            java.lang.String r8 = "Topic sync failed: "
            java.lang.String r7 = r7.getMessage()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r2 = r7.length()
            if (r2 == 0) goto L6c
            java.lang.String r7 = r8.concat(r7)
            goto L71
        L6c:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r8)
        L71:
            android.util.Log.e(r0, r7)
            return r1
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.v.a(com.google.firebase.iid.FirebaseInstanceId, java.lang.String):boolean");
    }
}
