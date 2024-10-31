package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class NotFilter extends AbstractFilter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    final FilterHolder f1167a;
    final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotFilter(int i, FilterHolder filterHolder) {
        this.b = i;
        this.f1167a = filterHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.drive.query.Filter
    public <T> T a(zzf<T> zzfVar) {
        return (T) zzfVar.a((zzf<T>) this.f1167a.a().a(zzfVar));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
