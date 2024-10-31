package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes.dex */
public final class GameBadgeRef extends zzc implements GameBadge {
    public GameBadgeRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public int b() {
        return c("badge_type");
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public String c() {
        return e("badge_title");
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public String d() {
        return e("badge_description");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public Uri e() {
        return h("badge_icon_image_uri");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return GameBadgeEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public GameBadge a() {
        return new GameBadgeEntity(this);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return GameBadgeEntity.a(this);
    }

    public String toString() {
        return GameBadgeEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((GameBadgeEntity) a()).writeToParcel(parcel, i);
    }
}
