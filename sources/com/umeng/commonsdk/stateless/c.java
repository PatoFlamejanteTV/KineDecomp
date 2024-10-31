package com.umeng.commonsdk.stateless;

import android.content.Context;
import com.facebook.stetho.BuildConfig;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: UMSLEnvelopeManager.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private String f26331e;
    private int j;
    private int k;
    private byte[] l;
    private byte[] m;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f26327a = {0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private final int f26328b = 1;

    /* renamed from: c, reason: collision with root package name */
    private final int f26329c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f26330d = BuildConfig.VERSION_NAME;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f26332f = null;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f26333g = null;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f26334h = null;
    private int i = 0;
    private boolean n = false;

    private c(byte[] bArr, String str, byte[] bArr2) throws Exception {
        this.f26331e = null;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = null;
        if (bArr != null && bArr.length != 0) {
            this.f26331e = str;
            this.k = bArr.length;
            this.l = f.a(bArr);
            this.j = (int) (System.currentTimeMillis() / 1000);
            this.m = bArr2;
            return;
        }
        throw new Exception("entity is null or empty");
    }

    public static c a(Context context, String str, byte[] bArr) {
        try {
            String mac = DeviceConfig.getMac(context);
            String deviceId = DeviceConfig.getDeviceId(context);
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("[stateless] build envelope, raw is  ");
            sb.append(bArr == null);
            sb.append("m app key is ");
            sb.append(str);
            sb.append("device id is ");
            sb.append(deviceId);
            sb.append(", mac is ");
            sb.append(mac);
            objArr[0] = sb.toString();
            ULog.i("walle", objArr);
            c cVar = new c(bArr, str, (deviceId + mac).getBytes());
            cVar.a();
            return cVar;
        } catch (Exception e2) {
            ULog.i("walle", "[stateless] build envelope, e is " + e2.getMessage());
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static c b(Context context, String str, byte[] bArr) {
        try {
            String mac = DeviceConfig.getMac(context);
            c cVar = new c(bArr, str, (DeviceConfig.getDeviceId(context) + mac).getBytes());
            cVar.a(true);
            cVar.a();
            return cVar;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    private byte[] c() {
        return a(this.f26327a, (int) (System.currentTimeMillis() / 1000));
    }

    private byte[] d() {
        return f.b((f.c(this.f26332f) + this.i + this.j + this.k + f.c(this.f26333g)).getBytes());
    }

    public byte[] b() {
        b bVar = new b();
        bVar.a(this.f26330d);
        bVar.b(this.f26331e);
        bVar.c(f.c(this.f26332f));
        bVar.a(this.i);
        bVar.b(this.j);
        bVar.c(this.k);
        bVar.a(this.l);
        bVar.d(this.n ? 1 : 0);
        bVar.d(f.c(this.f26333g));
        bVar.e(f.c(this.f26334h));
        try {
            return new s().a(bVar);
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void a() {
        if (this.f26332f == null) {
            this.f26332f = c();
        }
        if (this.n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f26332f, 1, bArr, 0, 16);
                this.l = f.a(this.l, bArr);
            } catch (Exception unused) {
            }
        }
        this.f26333g = a(this.f26332f, this.j);
        this.f26334h = d();
    }

    private byte[] a(byte[] bArr, int i) {
        byte[] b2 = f.b(this.m);
        byte[] b3 = f.b(this.l);
        int length = b2.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr2[i3] = b3[i2];
            bArr2[i3 + 1] = b2[i2];
        }
        for (int i4 = 0; i4 < 2; i4++) {
            bArr2[i4] = bArr[i4];
            bArr2[(bArr2.length - i4) - 1] = bArr[(bArr.length - i4) - 1];
        }
        byte[] bArr3 = {(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            bArr2[i5] = (byte) (bArr2[i5] ^ bArr3[i5 % 4]);
        }
        return bArr2;
    }
}
