package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb;
import com.google.android.gms.nearby.sharing.internal.zzc;
import java.util.List;

/* loaded from: classes.dex */
public final class ProvideContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    final int f2134a;
    public IBinder b;
    public zzb c;

    @Deprecated
    public List<SharedContent> d;
    public long e;
    public zzc f;

    ProvideContentRequest() {
        this.f2134a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProvideContentRequest(int i, IBinder iBinder, IBinder iBinder2, List<SharedContent> list, long j, IBinder iBinder3) {
        this.f2134a = i;
        this.b = iBinder;
        this.c = zzb.zza.a(iBinder2);
        this.d = list;
        this.e = j;
        this.f = zzc.zza.a(iBinder3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        if (this.c == null) {
            return null;
        }
        return this.c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        return this.f.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
