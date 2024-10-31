package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzrx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class zzag extends ab {
    public zzag(zzv zzvVar) {
        super(zzvVar);
    }

    private Object a(int i, Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Double) {
            return Float.valueOf((float) ((Double) obj).doubleValue());
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return null;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() > i) {
            return null;
        }
        return valueOf;
    }

    public static boolean a(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (z) {
                    if (receiverInfo.exported) {
                    }
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public Object a(Object obj) {
        return a(n().o(), obj);
    }

    public void a(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            l().q().a("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public void a(zzpk.zzb zzbVar, Object obj) {
        zzx.a(obj);
        zzbVar.zzagS = null;
        zzbVar.zzaOH = null;
        zzbVar.zzaOB = null;
        if (obj instanceof String) {
            zzbVar.zzagS = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzbVar.zzaOH = (Long) obj;
        } else if (obj instanceof Float) {
            zzbVar.zzaOB = (Float) obj;
        } else {
            l().b().a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void a(zzpk.zze zzeVar, Object obj) {
        zzx.a(obj);
        zzeVar.zzagS = null;
        zzeVar.zzaOH = null;
        zzeVar.zzaOB = null;
        if (obj instanceof String) {
            zzeVar.zzagS = (String) obj;
            return;
        }
        if (obj instanceof Long) {
            zzeVar.zzaOH = (Long) obj;
        } else if (obj instanceof Float) {
            zzeVar.zzaOB = (Float) obj;
        } else {
            l().b().a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public void a(String str) {
        a("user attribute", n().b(), str);
    }

    void a(String str, int i, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(str + " name is required and can't be null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException(str + " name is required and can't be empty");
        }
        char charAt = str2.charAt(0);
        if (!Character.isLetter(charAt) && charAt != '_') {
            throw new IllegalArgumentException(str + " name must start with a letter or _");
        }
        for (int i2 = 1; i2 < str2.length(); i2++) {
            char charAt2 = str2.charAt(i2);
            if (charAt2 != '_' && !Character.isLetterOrDigit(charAt2)) {
                throw new IllegalArgumentException(str + " name must consist of letters, digits or _ (underscores)");
            }
        }
        if (str2.length() > i) {
            throw new IllegalArgumentException(str + " name is too long. The maximum supported length is " + i);
        }
    }

    public boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(h().currentTimeMillis() - j) > j2;
    }

    public byte[] a(zzpk.zzc zzcVar) {
        try {
            byte[] bArr = new byte[zzcVar.zzFR()];
            zzrx zzC = zzrx.zzC(bArr);
            zzcVar.zza(zzC);
            zzC.zzFE();
            return bArr;
        } catch (IOException e) {
            l().b().a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] a(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            l().b().a("Failed to gzip content", e);
            throw e;
        }
    }

    public Object b(Object obj) {
        return a(n().p(), obj);
    }

    public boolean b(String str) {
        e();
        return i().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    public byte[] b(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            l().b().a("Failed to ungzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }
}
