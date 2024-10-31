package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LabelValue implements SafeParcelable {
    public static final Parcelable.Creator<LabelValue> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    String f2316a;
    String b;
    private final int c;

    LabelValue() {
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LabelValue(int i, String str, String str2) {
        this.c = i;
        this.f2316a = str;
        this.b = str2;
    }

    public int a() {
        return this.c;
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
