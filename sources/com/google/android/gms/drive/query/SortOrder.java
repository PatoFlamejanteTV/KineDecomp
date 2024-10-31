package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class SortOrder implements SafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final List<FieldWithSortOrder> f1155a;
    final boolean b;
    final int c;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<FieldWithSortOrder> f1156a = new ArrayList();
        private boolean b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortOrder(int i, List<FieldWithSortOrder> list, boolean z) {
        this.c = i;
        this.f1155a = list;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", TextUtils.join(",", this.f1155a), Boolean.valueOf(this.b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
