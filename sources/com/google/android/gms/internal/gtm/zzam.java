package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public class zzam {
    private final zzap zzwc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzam(zzap zzapVar) {
        Preconditions.a(zzapVar);
        this.zzwc = zzapVar;
    }

    public static boolean zzda() {
        return Log.isLoggable(zzby.zzzb.get(), 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.zzwc.getContext();
    }

    public final void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    public final void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    public final void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    public final zzap zzcm() {
        return this.zzwc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Clock zzcn() {
        return this.zzwc.zzcn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzci zzco() {
        return this.zzwc.zzco();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbq zzcp() {
        return this.zzwc.zzcp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.analytics.zzk zzcq() {
        return this.zzwc.zzcq();
    }

    public final GoogleAnalytics zzcr() {
        return this.zzwc.zzde();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzae zzcs() {
        return this.zzwc.zzcs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbv zzct() {
        return this.zzwc.zzct();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzda zzcu() {
        return this.zzwc.zzcu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzcm zzcv() {
        return this.zzwc.zzcv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbh zzcw() {
        return this.zzwc.zzdh();
    }

    protected final zzad zzcx() {
        return this.zzwc.zzdg();
    }

    protected final zzba zzcy() {
        return this.zzwc.zzcy();
    }

    protected final zzbu zzcz() {
        return this.zzwc.zzcz();
    }

    public final void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    public final void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    public final void zzq(String str) {
        zza(2, str, null, null, null);
    }

    public final void zzr(String str) {
        zza(3, str, null, null, null);
    }

    public final void zzs(String str) {
        zza(4, str, null, null, null);
    }

    public final void zzt(String str) {
        zza(5, str, null, null, null);
    }

    public final void zzu(String str) {
        zza(6, str, null, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    public final void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    public final void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String zzc(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String zzb = zzb(obj);
        String zzb2 = zzb(obj2);
        String zzb3 = zzb(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzb)) {
            sb.append(str2);
            sb.append(zzb);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzb2)) {
            sb.append(str2);
            sb.append(zzb2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzb3)) {
            sb.append(str2);
            sb.append(zzb3);
        }
        return sb.toString();
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    public final void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    private final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzap zzapVar = this.zzwc;
        zzci zzdd = zzapVar != null ? zzapVar.zzdd() : null;
        if (zzdd != null) {
            String str2 = zzby.zzzb.get();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, zzc(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                zzdd.zzb(i, str, obj, obj2, obj3);
                return;
            }
            return;
        }
        String str3 = zzby.zzzb.get();
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, zzc(str, obj, obj2, obj3));
        }
    }

    private static String zzb(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }
        if (obj instanceof Throwable) {
            return ((Throwable) obj).toString();
        }
        return obj.toString();
    }
}
