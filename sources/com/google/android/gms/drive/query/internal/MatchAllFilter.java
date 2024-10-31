package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class MatchAllFilter extends AbstractFilter {
    public static final zzl CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    final int f1166a;

    public MatchAllFilter() {
        this(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchAllFilter(int i) {
        this.f1166a = i;
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F a(zzf<F> zzfVar) {
        return zzfVar.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
