package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class FACLData implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f815a;
    FACLConfig b;
    String c;
    boolean d;
    String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.f815a = i;
        this.b = fACLConfig;
        this.c = str;
        this.d = z;
        this.e = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
