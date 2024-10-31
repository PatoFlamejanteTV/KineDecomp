package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class ParcelableEventList implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEventList> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f1179a;
    final List<ParcelableEvent> b;
    final DataHolder c;
    final boolean d;
    final List<String> e;
    final ParcelableChangeInfo f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelableEventList(int i, List<ParcelableEvent> list, DataHolder dataHolder, boolean z, List<String> list2, ParcelableChangeInfo parcelableChangeInfo) {
        this.f1179a = i;
        this.b = list;
        this.c = dataHolder;
        this.d = z;
        this.e = list2;
        this.f = parcelableChangeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
