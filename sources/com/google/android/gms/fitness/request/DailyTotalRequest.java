package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznt;

/* loaded from: classes.dex */
public class DailyTotalRequest implements SafeParcelable {
    public static final Parcelable.Creator<DailyTotalRequest> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    private final int f1242a;
    private final zznt b;
    private DataType c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DailyTotalRequest(int i, IBinder iBinder, DataType dataType) {
        this.f1242a = i;
        this.b = zznt.zza.zzbt(iBinder);
        this.c = dataType;
    }

    public DailyTotalRequest(zznt zzntVar, DataType dataType) {
        this.f1242a = 2;
        this.b = zzntVar;
        this.c = dataType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1242a;
    }

    public DataType b() {
        return this.c;
    }

    public IBinder c() {
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", this.c.c());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
