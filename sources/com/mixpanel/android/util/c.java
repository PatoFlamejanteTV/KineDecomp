package com.mixpanel.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.facebook.internal.Utility;
import com.mixpanel.android.mpmetrics.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: HttpService.java */
/* loaded from: classes.dex */
public class c implements RemoteService {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3075a;

    @Override // com.mixpanel.android.util.RemoteService
    public void a() {
        new Thread(new d(this)).start();
    }

    @Override // com.mixpanel.android.util.RemoteService
    public boolean a(Context context) {
        if (f3075a) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            if (m.f3036a) {
                Log.v("MixpanelAPI.Message", "ConnectivityManager says we " + (z ? "are" : "are not") + " online");
                return z;
            }
            return z;
        } catch (SecurityException e) {
            if (m.f3036a) {
                Log.v("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
            }
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080 A[Catch: all -> 0x015a, TRY_LEAVE, TryCatch #24 {all -> 0x015a, blocks: (B:32:0x007c, B:34:0x0080), top: B:31:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0109 A[Catch: all -> 0x011f, TryCatch #28 {all -> 0x011f, blocks: (B:10:0x0028, B:82:0x0101, B:84:0x0109, B:86:0x0111, B:87:0x011e, B:88:0x0135), top: B:9:0x0028 }] */
    @Override // com.mixpanel.android.util.RemoteService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r14, java.util.Map<java.lang.String, java.lang.Object> r15, javax.net.ssl.SSLSocketFactory r16) throws com.mixpanel.android.util.RemoteService.ServiceUnavailableException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.c.a(java.lang.String, java.util.Map, javax.net.ssl.SSLSocketFactory):byte[]");
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
