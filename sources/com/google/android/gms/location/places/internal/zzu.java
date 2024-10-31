package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzsd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzu extends com.google.android.gms.common.data.zzc {
    private final String c;

    public zzu(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = "SafeDataBufferRef";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(String str, float f) {
        return (!a_(str) || i(str)) ? f : f(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(String str, int i) {
        return (!a_(str) || i(str)) ? i : c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <E extends SafeParcelable> E a(String str, Parcelable.Creator<E> creator) {
        byte[] a2 = a(str, (byte[]) null);
        if (a2 == null) {
            return null;
        }
        return (E) com.google.android.gms.common.internal.safeparcel.zzc.a(a2, creator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, String str2) {
        return (!a_(str) || i(str)) ? str2 : e(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <E extends SafeParcelable> List<E> a(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] a2 = a(str, (byte[]) null);
        if (a2 == null) {
            return list;
        }
        try {
            zzru zzz = zzru.zzz(a2);
            if (zzz.zzbhW == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzz.zzbhW.length);
            byte[][] bArr = zzz.zzbhW;
            for (byte[] bArr2 : bArr) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.a(bArr2, creator));
            }
            return arrayList;
        } catch (zzsd e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Integer> a(String str, List<Integer> list) {
        byte[] a2 = a(str, (byte[]) null);
        if (a2 == null) {
            return list;
        }
        try {
            zzru zzz = zzru.zzz(a2);
            if (zzz.zzbhV == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzz.zzbhV.length);
            for (int i = 0; i < zzz.zzbhV.length; i++) {
                arrayList.add(Integer.valueOf(zzz.zzbhV[i]));
            }
            return arrayList;
        } catch (zzsd e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, boolean z) {
        return (!a_(str) || i(str)) ? z : d(str);
    }

    protected byte[] a(String str, byte[] bArr) {
        return (!a_(str) || i(str)) ? bArr : g(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> b(String str, List<String> list) {
        byte[] a2 = a(str, (byte[]) null);
        if (a2 == null) {
            return list;
        }
        try {
            zzru zzz = zzru.zzz(a2);
            return zzz.zzbhU != null ? Arrays.asList(zzz.zzbhU) : list;
        } catch (zzsd e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }
}
