package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    private final int f1278a;
    private final DataType b;
    private final DataSource c;
    private final zzoj d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsubscribeRequest(int i, DataType dataType, DataSource dataSource, IBinder iBinder) {
        this.f1278a = i;
        this.b = dataType;
        this.c = dataSource;
        this.d = zzoj.zza.zzbJ(iBinder);
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzoj zzojVar) {
        this.f1278a = 3;
        this.b = dataType;
        this.c = dataSource;
        this.d = zzojVar;
    }

    private boolean a(UnsubscribeRequest unsubscribeRequest) {
        return com.google.android.gms.common.internal.zzw.a(this.c, unsubscribeRequest.c) && com.google.android.gms.common.internal.zzw.a(this.b, unsubscribeRequest.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1278a;
    }

    public DataType b() {
        return this.b;
    }

    public DataSource c() {
        return this.c;
    }

    public IBinder d() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof UnsubscribeRequest) && a((UnsubscribeRequest) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(this.c, this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.a(this, parcel, i);
    }
}
