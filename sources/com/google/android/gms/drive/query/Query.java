package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class Query implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final LogicalFilter f1152a;
    final String b;
    final SortOrder c;
    final List<String> d;
    final boolean e;
    final List<DriveSpace> f;
    final boolean g;
    final int h;
    private final Set<DriveSpace> i;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<Filter> f1153a = new ArrayList();
    }

    private Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, Set<DriveSpace> set, boolean z2) {
        this.h = i;
        this.f1152a = logicalFilter;
        this.b = str;
        this.c = sortOrder;
        this.d = list;
        this.e = z;
        this.f = list2;
        this.i = set;
        this.g = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, boolean z2) {
        this(i, logicalFilter, str, sortOrder, list, z, list2, list2 == null ? null : new HashSet(list2), z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", this.f1152a, this.c, this.b, this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
