package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class c extends zzj {

    /* renamed from: a */
    private int f10981a;

    public c(byte[] bArr) {
        Preconditions.a(bArr.length == 25);
        this.f10981a = Arrays.hashCode(bArr);
    }

    public static byte[] zza(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        IObjectWrapper u;
        if (obj != null && (obj instanceof zzi)) {
            try {
                zzi zziVar = (zzi) obj;
                if (zziVar.zzc() == hashCode() && (u = zziVar.u()) != null) {
                    return Arrays.equals(v(), (byte[]) ObjectWrapper.a(u));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f10981a;
    }

    @Override // com.google.android.gms.common.internal.zzi
    public final IObjectWrapper u() {
        return ObjectWrapper.a(v());
    }

    public abstract byte[] v();

    @Override // com.google.android.gms.common.internal.zzi
    public final int zzc() {
        return hashCode();
    }
}
