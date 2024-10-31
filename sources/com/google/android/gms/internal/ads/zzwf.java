package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
/* loaded from: classes2.dex */
public class zzwf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwf> CREATOR = new zzwg();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzckk;
    public final boolean zzckl;
    public final zzwf[] zzckm;
    public final boolean zzckn;
    public final boolean zzcko;
    public boolean zzckp;

    public zzwf() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzwf zzg(Context context) {
        return new zzwf("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static zzwf zzpo() {
        return new zzwf("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzckk, false);
        SafeParcelWriter.a(parcel, 3, this.height);
        SafeParcelWriter.a(parcel, 4, this.heightPixels);
        SafeParcelWriter.a(parcel, 5, this.zzckl);
        SafeParcelWriter.a(parcel, 6, this.width);
        SafeParcelWriter.a(parcel, 7, this.widthPixels);
        SafeParcelWriter.a(parcel, 8, (Parcelable[]) this.zzckm, i, false);
        SafeParcelWriter.a(parcel, 9, this.zzckn);
        SafeParcelWriter.a(parcel, 10, this.zzcko);
        SafeParcelWriter.a(parcel, 11, this.zzckp);
        SafeParcelWriter.a(parcel, a2);
    }

    public final AdSize zzpp() {
        return com.google.android.gms.ads.zzc.a(this.width, this.height, this.zzckk);
    }

    public zzwf(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzwf(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    public zzwf(zzwf zzwfVar, zzwf[] zzwfVarArr) {
        this(zzwfVar.zzckk, zzwfVar.height, zzwfVar.heightPixels, zzwfVar.zzckl, zzwfVar.width, zzwfVar.widthPixels, zzwfVarArr, zzwfVar.zzckn, zzwfVar.zzcko, zzwfVar.zzckp);
    }

    @SafeParcelable.Constructor
    public zzwf(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) zzwf[] zzwfVarArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4) {
        this.zzckk = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzckl = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzckm = zzwfVarArr;
        this.zzckn = z2;
        this.zzcko = z3;
        this.zzckp = z4;
    }
}
