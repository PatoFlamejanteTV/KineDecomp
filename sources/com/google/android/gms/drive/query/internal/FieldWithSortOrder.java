package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* loaded from: classes2.dex */
public class FieldWithSortOrder implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final String f1160a;
    final boolean b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldWithSortOrder(int i, String str, boolean z) {
        this.c = i;
        this.f1160a = str;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = this.f1160a;
        objArr[1] = this.b ? "ASC" : "DESC";
        return String.format(locale, "FieldWithSortOrder[%s %s]", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
