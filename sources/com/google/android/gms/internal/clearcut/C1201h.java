package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.clearcut.h */
/* loaded from: classes2.dex */
public final class C1201h<T> extends zzae<T> {

    /* renamed from: a */
    private final Object f12841a;

    /* renamed from: b */
    private String f12842b;

    /* renamed from: c */
    private T f12843c;

    /* renamed from: d */
    private final /* synthetic */ zzan f12844d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1201h(zzao zzaoVar, String str, Object obj, zzan zzanVar) {
        super(zzaoVar, str, obj, null);
        this.f12844d = zzanVar;
        this.f12841a = new Object();
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    protected final T zza(SharedPreferences sharedPreferences) {
        try {
            return zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(valueOf) : new String("Invalid byte[] value in SharedPreferences for "), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    protected final T zzb(String str) {
        T t;
        try {
            synchronized (this.f12841a) {
                if (!str.equals(this.f12842b)) {
                    T t2 = (T) this.f12844d.zzb(Base64.decode(str, 3));
                    this.f12842b = str;
                    this.f12843c = t2;
                }
                t = this.f12843c;
            }
            return t;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.zzds;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid byte[] value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
