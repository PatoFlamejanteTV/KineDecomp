package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class LogicalFilter extends AbstractFilter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final Operator f1165a;
    final List<FilterHolder> b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogicalFilter(int i, Operator operator, List<FilterHolder> list) {
        this.c = i;
        this.f1165a = operator;
        this.b = list;
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <T> T a(zzf<T> zzfVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<FilterHolder> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a().a(zzfVar));
        }
        return zzfVar.a(this.f1165a, arrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
