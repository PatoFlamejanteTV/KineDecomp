package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class DataInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    private final int f1245a;
    private final DataSet b;
    private final zzoj c;
    private final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataInsertRequest(int i, DataSet dataSet, IBinder iBinder, boolean z) {
        this.f1245a = i;
        this.b = dataSet;
        this.c = zzoj.zza.zzbJ(iBinder);
        this.d = z;
    }

    public DataInsertRequest(DataSet dataSet, zzoj zzojVar, boolean z) {
        this.f1245a = 4;
        this.b = dataSet;
        this.c = zzojVar;
        this.d = z;
    }

    private boolean a(DataInsertRequest dataInsertRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, dataInsertRequest.b);
    }

    public DataSet a() {
        return this.b;
    }

    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    public boolean c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1245a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataInsertRequest) && a((DataInsertRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("dataSet", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
