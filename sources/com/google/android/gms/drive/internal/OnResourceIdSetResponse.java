package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new zzbh();

    /* renamed from: a, reason: collision with root package name */
    private final int f1111a;
    private final List<String> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnResourceIdSetResponse(int i, List<String> list) {
        this.f1111a = i;
        this.b = list;
    }

    public int a() {
        return this.f1111a;
    }

    public List<String> b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbh.a(this, parcel, i);
    }
}