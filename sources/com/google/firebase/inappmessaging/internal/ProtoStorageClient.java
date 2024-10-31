package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Parser;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@ThreadSafe
/* loaded from: classes2.dex */
public class ProtoStorageClient {

    /* renamed from: a */
    private final Application f17809a;

    /* renamed from: b */
    private final String f17810b;

    public ProtoStorageClient(Application application, String str) {
        this.f17809a = application;
        this.f17810b = str;
    }

    public io.reactivex.a a(AbstractMessageLite abstractMessageLite) {
        return io.reactivex.a.a((Callable<?>) ia.a(this, abstractMessageLite));
    }

    public static /* synthetic */ Object a(ProtoStorageClient protoStorageClient, AbstractMessageLite abstractMessageLite) throws Exception {
        synchronized (protoStorageClient) {
            FileOutputStream openFileOutput = protoStorageClient.f17809a.openFileOutput(protoStorageClient.f17810b, 0);
            Throwable th = null;
            try {
                try {
                    openFileOutput.write(abstractMessageLite.toByteArray());
                } finally {
                }
            } finally {
                if (openFileOutput != null) {
                    defpackage.a.a(th, openFileOutput);
                }
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> io.reactivex.i<T> a(Parser<T> parser) {
        return io.reactivex.i.a(ja.a(this, parser));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0022 A[Catch: all -> 0x0026, InvalidProtocolBufferException | FileNotFoundException -> 0x0028, InvalidProtocolBufferException -> 0x002a, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0002, B:8:0x0012, B:9:0x0015, B:16:0x0022, B:17:0x0025, B:29:0x002b, B:30:0x0043), top: B:3:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[Catch: all -> 0x0026, InvalidProtocolBufferException | FileNotFoundException -> 0x0028, InvalidProtocolBufferException -> 0x002a, SYNTHETIC, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:8:0x0012, B:9:0x0015, B:16:0x0022, B:17:0x0025, B:29:0x002b, B:30:0x0043), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ com.google.protobuf.AbstractMessageLite a(com.google.firebase.inappmessaging.internal.ProtoStorageClient r4, com.google.protobuf.Parser r5) throws java.lang.Exception {
        /*
            monitor-enter(r4)
            r0 = 0
            android.app.Application r1 = r4.f17809a     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L28 com.google.protobuf.InvalidProtocolBufferException -> L2a
            java.lang.String r2 = r4.f17810b     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L28 com.google.protobuf.InvalidProtocolBufferException -> L2a
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L28 com.google.protobuf.InvalidProtocolBufferException -> L2a
            java.lang.Object r5 = r5.a(r1)     // Catch: java.lang.Throwable -> L17 java.lang.Throwable -> L1a
            com.google.protobuf.AbstractMessageLite r5 = (com.google.protobuf.AbstractMessageLite) r5     // Catch: java.lang.Throwable -> L17 java.lang.Throwable -> L1a
            if (r1 == 0) goto L15
            defpackage.a.a(r0, r1)     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L28 com.google.protobuf.InvalidProtocolBufferException -> L2a
        L15:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L26
            return r5
        L17:
            r5 = move-exception
            r2 = r0
            goto L20
        L1a:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L1c
        L1c:
            r2 = move-exception
            r3 = r2
            r2 = r5
            r5 = r3
        L20:
            if (r1 == 0) goto L25
            defpackage.a.a(r2, r1)     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L28 com.google.protobuf.InvalidProtocolBufferException -> L2a
        L25:
            throw r5     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L28 com.google.protobuf.InvalidProtocolBufferException -> L2a
        L26:
            r5 = move-exception
            goto L45
        L28:
            r5 = move-exception
            goto L2b
        L2a:
            r5 = move-exception
        L2b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r1.<init>()     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = "Recoverable exception while reading cache: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L26
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L26
            r1.append(r5)     // Catch: java.lang.Throwable -> L26
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L26
            com.google.firebase.inappmessaging.internal.Logging.d(r5)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L26
            return r0
        L45:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L26
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.ProtoStorageClient.a(com.google.firebase.inappmessaging.internal.ProtoStorageClient, com.google.protobuf.Parser):com.google.protobuf.AbstractMessageLite");
    }
}
