package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f1070a;
    final DriveId b;
    final String c;
    final ParcelFileDescriptor d;
    final ParcelFileDescriptor e;
    final MetadataBundle f;
    final List<String> g;
    final int h;
    final IBinder i;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompletionEvent(int i, DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i2, IBinder iBinder) {
        this.f1070a = i;
        this.b = driveId;
        this.c = str;
        this.d = parcelFileDescriptor;
        this.e = parcelFileDescriptor2;
        this.f = metadataBundle;
        this.g = list;
        this.h = i2;
        this.i = iBinder;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int a() {
        return 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.b, Integer.valueOf(this.h), this.g == null ? "<null>" : "'" + TextUtils.join("','", this.g) + "'");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i | 1);
    }
}
