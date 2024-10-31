package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

/* loaded from: classes2.dex */
public class QueryRequest implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new zzbn();

    /* renamed from: a, reason: collision with root package name */
    final int f1116a;
    final Query b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryRequest(int i, Query query) {
        this.f1116a = i;
        this.b = query;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbn.a(this, parcel, i);
    }
}
