package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzark;

@zzark
/* loaded from: classes.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();

    /* renamed from: a */
    private final String f10118a;

    /* renamed from: b */
    public final String f10119b;

    /* renamed from: c */
    public final String f10120c;

    /* renamed from: d */
    public final String f10121d;

    /* renamed from: e */
    public final String f10122e;

    /* renamed from: f */
    public final String f10123f;

    /* renamed from: g */
    private final String f10124g;

    /* renamed from: h */
    public final Intent f10125h;

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f10118a, false);
        SafeParcelWriter.a(parcel, 3, this.f10119b, false);
        SafeParcelWriter.a(parcel, 4, this.f10120c, false);
        SafeParcelWriter.a(parcel, 5, this.f10121d, false);
        SafeParcelWriter.a(parcel, 6, this.f10122e, false);
        SafeParcelWriter.a(parcel, 7, this.f10123f, false);
        SafeParcelWriter.a(parcel, 8, this.f10124g, false);
        SafeParcelWriter.a(parcel, 9, (Parcelable) this.f10125h, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzc(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) Intent intent) {
        this.f10118a = str;
        this.f10119b = str2;
        this.f10120c = str3;
        this.f10121d = str4;
        this.f10122e = str5;
        this.f10123f = str6;
        this.f10124g = str7;
        this.f10125h = intent;
    }
}
