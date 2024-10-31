package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new SnapshotEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1398a;
    private final SnapshotMetadataEntity b;
    private final SnapshotContentsEntity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotEntity(int i, SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this.f1398a = i;
        this.b = new SnapshotMetadataEntity(snapshotMetadata);
        this.c = snapshotContentsEntity;
    }

    static int a(Snapshot snapshot) {
        return zzw.a(snapshot.b(), snapshot.c());
    }

    static boolean a(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return zzw.a(snapshot2.b(), snapshot.b()) && zzw.a(snapshot2.c(), snapshot.c());
    }

    static String b(Snapshot snapshot) {
        return zzw.a(snapshot).a("Metadata", snapshot.b()).a("HasContents", Boolean.valueOf(snapshot.c() != null)).toString();
    }

    private boolean f() {
        return this.c.c();
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public SnapshotMetadata b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public SnapshotContents c() {
        if (f()) {
            return null;
        }
        return this.c;
    }

    public int d() {
        return this.f1398a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Snapshot a() {
        return this;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        SnapshotEntityCreator.a(this, parcel, i);
    }
}
