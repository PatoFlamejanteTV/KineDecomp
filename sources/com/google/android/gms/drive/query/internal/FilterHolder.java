package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

/* loaded from: classes2.dex */
public class FilterHolder implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f1161a;
    final ComparisonFilter<?> b;
    final FieldOnlyFilter c;
    final LogicalFilter d;
    final NotFilter e;
    final InFilter<?> f;
    final MatchAllFilter g;
    final HasFilter h;
    final FullTextSearchFilter i;
    final OwnedByMeFilter j;
    private final Filter k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterHolder(int i, ComparisonFilter<?> comparisonFilter, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> inFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.f1161a = i;
        this.b = comparisonFilter;
        this.c = fieldOnlyFilter;
        this.d = logicalFilter;
        this.e = notFilter;
        this.f = inFilter;
        this.g = matchAllFilter;
        this.h = hasFilter;
        this.i = fullTextSearchFilter;
        this.j = ownedByMeFilter;
        if (this.b != null) {
            this.k = this.b;
            return;
        }
        if (this.c != null) {
            this.k = this.c;
            return;
        }
        if (this.d != null) {
            this.k = this.d;
            return;
        }
        if (this.e != null) {
            this.k = this.e;
            return;
        }
        if (this.f != null) {
            this.k = this.f;
            return;
        }
        if (this.g != null) {
            this.k = this.g;
            return;
        }
        if (this.h != null) {
            this.k = this.h;
        } else if (this.i != null) {
            this.k = this.i;
        } else {
            if (this.j == null) {
                throw new IllegalArgumentException("At least one filter must be set.");
            }
            this.k = this.j;
        }
    }

    public Filter a() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", this.k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
