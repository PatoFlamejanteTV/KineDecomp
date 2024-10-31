package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class zzd implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();

    /* renamed from: a */
    private final String f16518a;

    /* renamed from: b */
    private final String f16519b;

    /* renamed from: c */
    private Map<String, Object> f16520c;

    /* renamed from: d */
    private boolean f16521d;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z) {
        Preconditions.b(str);
        Preconditions.b(str2);
        this.f16518a = str;
        this.f16519b = str2;
        this.f16520c = a.b(str2);
        this.f16521d = z;
    }

    @Nullable
    public final String a() {
        return this.f16518a;
    }

    public final boolean b() {
        return this.f16521d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, a(), false);
        SafeParcelWriter.a(parcel, 2, this.f16519b, false);
        SafeParcelWriter.a(parcel, 3, b());
        SafeParcelWriter.a(parcel, a2);
    }

    public zzd(boolean z) {
        this.f16521d = z;
        this.f16519b = null;
        this.f16518a = null;
        this.f16520c = null;
    }
}
