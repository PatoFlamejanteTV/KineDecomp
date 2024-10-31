package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes2.dex */
public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final int f1064a;
    final List<String> b;
    final List<String> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealtimeDocumentSyncRequest(int i, List<String> list, List<String> list2) {
        this.f1064a = i;
        this.b = (List) zzx.a(list);
        this.c = (List) zzx.a(list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
