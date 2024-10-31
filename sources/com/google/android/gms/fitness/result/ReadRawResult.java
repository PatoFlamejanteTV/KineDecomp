package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ReadRawResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<ReadRawResult> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    private final int f1290a;
    private final DataHolder b;
    private final List<DataHolder> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadRawResult(int i, DataHolder dataHolder, List<DataHolder> list) {
        this.f1290a = i;
        this.b = dataHolder;
        this.c = list == null ? Collections.singletonList(dataHolder) : list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1290a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DataHolder> c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return new Status(this.b.e());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
