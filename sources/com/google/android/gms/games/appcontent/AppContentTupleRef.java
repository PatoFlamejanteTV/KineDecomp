package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes.dex */
public final class AppContentTupleRef extends zzc implements AppContentTuple {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentTupleRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String b() {
        return e("tuple_name");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String c() {
        return e("tuple_value");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AppContentTuple a() {
        return new AppContentTupleEntity(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentTupleEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentTupleEntity.a(this);
    }

    public String toString() {
        return AppContentTupleEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentTupleEntity) a()).writeToParcel(parcel, i);
    }
}
