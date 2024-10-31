package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
/* renamed from: com.google.android.gms.internal.ads.na, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1007na {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f12342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1007na(zzwb zzwbVar, String str, int i) {
        this.f12342a = com.google.android.gms.ads.internal.zzo.a((String) zzwu.zzpz().zzd(zzaan.zzcsb), zzwbVar, str, i, null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1007na) {
            return Arrays.equals(this.f12342a, ((C1007na) obj).f12342a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12342a);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f12342a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 24);
        sb.append("[InterstitialAdPoolKey ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
