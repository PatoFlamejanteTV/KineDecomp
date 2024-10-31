package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Oj {

    /* renamed from: a, reason: collision with root package name */
    static zzbjs f11739a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzdl zzdlVar) throws IllegalAccessException, InvocationTargetException {
        Method zza;
        if (f11739a != null) {
            return true;
        }
        String str = (String) zzwu.zzpz().zzd(zzaan.zzctp);
        if (str == null || str.length() == 0) {
            str = null;
            if (zzdlVar != null && (zza = zzdlVar.zza("phpjyfBMe8u7C5auGMsy22WXoT6iMDb5qqttOP4sXOBlc73QdE1wdYLJ++PsHndY", "86B2wkBiSbEIJu45HO/BQ/RpWXZRq9YpFeIER87ao7I=")) != null) {
                str = (String) zza.invoke(null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            zzbju zzk = zzbjy.zzk(zzbu.zza(str, true));
            zzbjo.zza(zzbkp.zzfdl);
            f11739a = zzbks.zza(zzk);
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
        return f11739a != null;
    }
}
