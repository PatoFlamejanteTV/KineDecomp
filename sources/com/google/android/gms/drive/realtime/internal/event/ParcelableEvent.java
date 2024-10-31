package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class ParcelableEvent implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f1178a;
    final String b;
    final String c;
    final List<String> d;
    final boolean e;
    final boolean f;
    final boolean g;
    final String h;
    final String i;
    final TextInsertedDetails j;
    final TextDeletedDetails k;
    final ValuesAddedDetails l;
    final ValuesRemovedDetails m;
    final ValuesSetDetails n;
    final ValueChangedDetails o;
    final ReferenceShiftedDetails p;
    final ObjectChangedDetails q;
    final FieldChangedDetails r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelableEvent(int i, String str, String str2, List<String> list, boolean z, boolean z2, boolean z3, String str3, String str4, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.f1178a = i;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = str3;
        this.i = str4;
        this.j = textInsertedDetails;
        this.k = textDeletedDetails;
        this.l = valuesAddedDetails;
        this.m = valuesRemovedDetails;
        this.n = valuesSetDetails;
        this.o = valueChangedDetails;
        this.p = referenceShiftedDetails;
        this.q = objectChangedDetails;
        this.r = fieldChangedDetails;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
