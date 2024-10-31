package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zzes {
    private static final String TAG = "zzes";
    private final String className;
    private final zzdl zzqo;
    private final String zzuu;
    private final Class<?>[] zzux;
    private final int zzuv = 2;
    private volatile Method zzuw = null;
    private CountDownLatch zzuy = new CountDownLatch(1);

    public zzes(zzdl zzdlVar, String str, String str2, Class<?>... clsArr) {
        this.zzqo = zzdlVar;
        this.className = str;
        this.zzuu = str2;
        this.zzux = clsArr;
        this.zzqo.zzac().submit(new Sj(this));
    }

    public final void zzaw() {
        try {
            Class loadClass = this.zzqo.zzad().loadClass(zzb(this.zzqo.zzaf(), this.className));
            if (loadClass == null) {
                return;
            }
            this.zzuw = loadClass.getMethod(zzb(this.zzqo.zzaf(), this.zzuu), this.zzux);
            if (this.zzuw == null) {
            }
        } catch (zzcx unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzuy.countDown();
        }
    }

    private final String zzb(byte[] bArr, String str) throws zzcx, UnsupportedEncodingException {
        return new String(this.zzqo.zzae().zza(bArr, str), "UTF-8");
    }

    public final Method zzax() {
        if (this.zzuw != null) {
            return this.zzuw;
        }
        try {
            if (this.zzuy.await(2L, TimeUnit.SECONDS)) {
                return this.zzuw;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
