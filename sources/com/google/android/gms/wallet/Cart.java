package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Cart implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    String f2278a;
    String b;
    ArrayList<LineItem> c;
    private final int d;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    Cart() {
        this.d = 1;
        this.c = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cart(int i, String str, String str2, ArrayList<LineItem> arrayList) {
        this.d = i;
        this.f2278a = str;
        this.b = str2;
        this.c = arrayList;
    }

    public int a() {
        return this.d;
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
