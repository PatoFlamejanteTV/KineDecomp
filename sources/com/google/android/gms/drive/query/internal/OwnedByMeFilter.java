package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class OwnedByMeFilter extends AbstractFilter {
    public static final zzo CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    final int f1169a;

    public OwnedByMeFilter() {
        this(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OwnedByMeFilter(int i) {
        this.f1169a = i;
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F a(zzf<F> zzfVar) {
        return zzfVar.b();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.a(this, parcel, i);
    }
}
