package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class InstrumentInfo implements SafeParcelable {
    public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    private final int f2284a;
    private String b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrumentInfo(int i, String str, String str2) {
        this.f2284a = i;
        this.b = str;
        this.c = str2;
    }

    public int a() {
        return this.f2284a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
