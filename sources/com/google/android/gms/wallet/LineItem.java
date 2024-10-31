package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LineItem implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    String f2285a;
    String b;
    String c;
    String d;
    int e;
    String f;
    private final int g;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    /* loaded from: classes.dex */
    public interface Role {
    }

    LineItem() {
        this.g = 1;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LineItem(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.g = i;
        this.f2285a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i2;
        this.f = str5;
    }

    public int a() {
        return this.g;
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
