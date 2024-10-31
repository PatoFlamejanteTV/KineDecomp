package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoe;

/* loaded from: classes.dex */
public class ListSubscriptionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsRequest> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    private final int f1258a;
    private final DataType b;
    private final zzoe c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListSubscriptionsRequest(int i, DataType dataType, IBinder iBinder) {
        this.f1258a = i;
        this.b = dataType;
        this.c = zzoe.zza.zzbE(iBinder);
    }

    public ListSubscriptionsRequest(DataType dataType, zzoe zzoeVar) {
        this.f1258a = 3;
        this.b = dataType;
        this.c = zzoeVar;
    }

    public DataType a() {
        return this.b;
    }

    public IBinder b() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1258a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.a(this, parcel, i);
    }
}
