package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class FACLConfig implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f814a;
    boolean b;
    String c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f814a = i;
        this.b = z;
        this.c = str;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) obj;
        return this.b == fACLConfig.b && TextUtils.equals(this.c, fACLConfig.c) && this.d == fACLConfig.d && this.e == fACLConfig.e && this.f == fACLConfig.f && this.g == fACLConfig.g;
    }

    public int hashCode() {
        return zzw.a(Boolean.valueOf(this.b), this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
