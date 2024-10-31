package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int b;
    private final String c;
    private final Long d;
    private final Uri e;
    private BitmapTeleporter f;
    private final Long g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotMetadataChangeEntity(int i, String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this.b = i;
        this.c = str;
        this.d = l;
        this.f = bitmapTeleporter;
        this.e = uri;
        this.g = l2;
        if (this.f != null) {
            zzx.a(this.e == null, "Cannot set both a URI and an image");
        } else if (this.e != null) {
            zzx.a(this.f == null, "Cannot set both a URI and an image");
        }
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Long c() {
        return this.d;
    }

    public Long d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BitmapTeleporter e() {
        return this.f;
    }

    public Uri f() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataChangeCreator.a(this, parcel, i);
    }
}
