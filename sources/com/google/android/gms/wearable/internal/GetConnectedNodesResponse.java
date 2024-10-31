package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class GetConnectedNodesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConnectedNodesResponse> CREATOR = new zzaq();

    /* renamed from: a, reason: collision with root package name */
    public final int f2352a;
    public final int b;
    public final List<NodeParcelable> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetConnectedNodesResponse(int i, int i2, List<NodeParcelable> list) {
        this.f2352a = i;
        this.b = i2;
        this.c = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaq.a(this, parcel, i);
    }
}
