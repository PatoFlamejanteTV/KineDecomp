package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class FullTextSearchFilter extends AbstractFilter {
    public static final zzh CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final String f1162a;
    final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullTextSearchFilter(int i, String str) {
        this.b = i;
        this.f1162a = str;
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F a(zzf<F> zzfVar) {
        return zzfVar.a(this.f1162a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
