package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class OnDownloadProgressResponse implements SafeParcelable {

    /* renamed from: a, reason: collision with root package name */
    final int f1102a;
    final long b;
    final long c;
    final int d;
    final List<DriveFileRange> e;
    private static final List<DriveFileRange> f = new ArrayList();
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzay();

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnDownloadProgressResponse(int i, long j, long j2, int i2, List<DriveFileRange> list) {
        this.f1102a = i;
        this.b = j;
        this.c = j2;
        this.d = i2;
        this.e = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzay.a(this, parcel, i);
    }
}
