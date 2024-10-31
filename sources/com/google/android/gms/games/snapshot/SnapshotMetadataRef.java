package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class SnapshotMetadataRef extends zzc implements SnapshotMetadata {
    private final Game c;
    private final Player d;

    public SnapshotMetadataRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = new GameRef(dataHolder, i);
        this.d = new PlayerRef(dataHolder, i);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Game b() {
        return this.c;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Player c() {
        return this.d;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String d() {
        return e("external_snapshot_id");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Uri e() {
        return h("cover_icon_image_uri");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return SnapshotMetadataEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String f() {
        return e("cover_icon_image_url");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public float g() {
        float f = f("cover_icon_image_height");
        float f2 = f("cover_icon_image_width");
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String h() {
        return e("unique_name");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return SnapshotMetadataEntity.a(this);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String i() {
        return e(ShareConstants.WEB_DIALOG_PARAM_TITLE);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String j() {
        return e("description");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long k() {
        return b("last_modified_timestamp");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long l() {
        return b("duration");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public boolean m() {
        return c("pending_change_count") > 0;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long n() {
        return b("progress_value");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String o() {
        return e("device_name");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadata a() {
        return new SnapshotMetadataEntity(this);
    }

    public String toString() {
        return SnapshotMetadataEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((SnapshotMetadataEntity) a()).writeToParcel(parcel, i);
    }
}
