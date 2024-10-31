package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

/* loaded from: classes.dex */
public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    private final int b;
    private Contents c;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1397a = new Object();
    public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotContentsEntity(int i, Contents contents) {
        this.b = i;
        this.c = contents;
    }

    public int a() {
        return this.b;
    }

    public Contents b() {
        return this.c;
    }

    public boolean c() {
        return this.c == null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        SnapshotContentsEntityCreator.a(this, parcel, i);
    }
}
