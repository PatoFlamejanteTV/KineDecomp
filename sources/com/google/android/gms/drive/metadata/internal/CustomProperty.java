package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* loaded from: classes2.dex */
public class CustomProperty implements SafeParcelable {
    public static final Parcelable.Creator<CustomProperty> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f1146a;
    final CustomPropertyKey b;
    final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomProperty(int i, CustomPropertyKey customPropertyKey, String str) {
        this.f1146a = i;
        zzx.a(customPropertyKey, "key");
        this.b = customPropertyKey;
        this.c = str;
    }

    public CustomProperty(CustomPropertyKey customPropertyKey, String str) {
        this(1, customPropertyKey, str);
    }

    public CustomPropertyKey a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
