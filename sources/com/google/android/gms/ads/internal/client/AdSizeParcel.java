package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class AdSizeParcel implements SafeParcelable {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final int f534a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final AdSizeParcel[] h;
    public final boolean i;
    public final boolean j;

    public AdSizeParcel() {
        this(4, "interstitial_mb", 0, 0, true, 0, 0, null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3) {
        this.f534a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = i4;
        this.g = i5;
        this.h = adSizeParcelArr;
        this.i = z2;
        this.j = z3;
    }

    public AdSizeParcel(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public AdSizeParcel(Context context, AdSize[] adSizeArr) {
        int i;
        AdSize adSize = adSizeArr[0];
        this.f534a = 4;
        this.e = false;
        this.j = adSize.c();
        if (this.j) {
            this.f = AdSize.f516a.b();
            this.c = AdSize.f516a.a();
        } else {
            this.f = adSize.b();
            this.c = adSize.a();
        }
        boolean z = this.f == -1;
        boolean z2 = this.c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (zzl.a().c(context) && zzl.a().d(context)) {
                this.g = a(displayMetrics) - zzl.a().e(context);
            } else {
                this.g = a(displayMetrics);
            }
            double d = this.g / displayMetrics.density;
            int i2 = (int) d;
            i = d - ((double) ((int) d)) >= 0.01d ? i2 + 1 : i2;
        } else {
            int i3 = this.f;
            this.g = zzl.a().a(displayMetrics, this.f);
            i = i3;
        }
        int c = z2 ? c(displayMetrics) : this.c;
        this.d = zzl.a().a(displayMetrics, c);
        if (z || z2) {
            this.b = i + "x" + c + "_as";
        } else if (this.j) {
            this.b = "320x50_mb";
        } else {
            this.b = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.h = new AdSizeParcel[adSizeArr.length];
            for (int i4 = 0; i4 < adSizeArr.length; i4++) {
                this.h[i4] = new AdSizeParcel(context, adSizeArr[i4]);
            }
        } else {
            this.h = null;
        }
        this.i = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        this(4, adSizeParcel.b, adSizeParcel.c, adSizeParcel.d, adSizeParcel.e, adSizeParcel.f, adSizeParcel.g, adSizeParcelArr, adSizeParcel.i, adSizeParcel.j);
    }

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static AdSizeParcel a() {
        return new AdSizeParcel(4, "reward_mb", 0, 0, false, 0, 0, null, false, false);
    }

    public static AdSizeParcel a(Context context) {
        return new AdSizeParcel(4, "320x50_mb", 0, 0, false, 0, 0, null, true, false);
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int) (c(displayMetrics) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public AdSize b() {
        return com.google.android.gms.ads.zza.a(this.f, this.c, this.b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
