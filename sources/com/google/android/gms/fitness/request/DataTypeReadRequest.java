package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznw;

/* loaded from: classes.dex */
public class DataTypeReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeReadRequest> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    private final int f1253a;
    private final String b;
    private final zznw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataTypeReadRequest(int i, String str, IBinder iBinder) {
        this.f1253a = i;
        this.b = str;
        this.c = zznw.zza.zzbw(iBinder);
    }

    public DataTypeReadRequest(String str, zznw zznwVar) {
        this.f1253a = 3;
        this.b = str;
        this.c = zznwVar;
    }

    private boolean a(DataTypeReadRequest dataTypeReadRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.b, dataTypeReadRequest.b);
    }

    public String a() {
        return this.b;
    }

    public IBinder b() {
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1253a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeReadRequest) && a((DataTypeReadRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.b);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("name", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
