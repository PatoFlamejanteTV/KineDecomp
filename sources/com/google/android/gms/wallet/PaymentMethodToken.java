package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class PaymentMethodToken implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    int f2291a;
    String b;
    private final int c;

    private PaymentMethodToken() {
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PaymentMethodToken(int i, int i2, String str) {
        this.c = i;
        this.f2291a = i2;
        this.b = str;
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
        zzo.a(this, parcel, i);
    }
}
