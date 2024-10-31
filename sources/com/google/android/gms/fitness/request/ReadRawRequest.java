package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzof;
import java.util.List;

/* loaded from: classes.dex */
public class ReadRawRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadRawRequest> CREATOR = new zzq();

    /* renamed from: a, reason: collision with root package name */
    private final int f1259a;
    private final zzof b;
    private final List<DataSourceQueryParams> c;
    private final boolean d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadRawRequest(int i, IBinder iBinder, List<DataSourceQueryParams> list, boolean z, boolean z2) {
        this.f1259a = i;
        this.b = zzof.zza.zzbF(iBinder);
        this.c = list;
        this.d = z;
        this.e = z2;
    }

    public List<DataSourceQueryParams> a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1259a;
    }

    public IBinder c() {
        if (this.b != null) {
            return this.b.asBinder();
        }
        return null;
    }

    public boolean d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzq.a(this, parcel, i);
    }
}
