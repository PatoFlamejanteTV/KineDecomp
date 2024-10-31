package com.google.android.gms.games.request;

import android.os.Parcel;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class GameRequestRef extends zzc implements GameRequest {
    private final int c;

    public GameRequestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int a(String str) {
        for (int i = this.b_; i < this.b_ + this.c; i++) {
            int a2 = this.a_.a(i);
            if (this.a_.c("recipient_external_player_id", i, a2).equals(str)) {
                return this.a_.b("recipient_status", i, a2);
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GameRequest a() {
        return new GameRequestEntity(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public String d() {
        return e("external_request_id");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Game e() {
        return new GameRef(this.a_, this.b_);
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return GameRequestEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Player f() {
        return new PlayerRef(this.a_, e_(), "sender_");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public byte[] h() {
        return g(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return GameRequestEntity.a(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int i() {
        return c("type");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long j() {
        return b("creation_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long k() {
        return b("expiration_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int l() {
        return c(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public List<Player> n() {
        ArrayList arrayList = new ArrayList(this.c);
        for (int i = 0; i < this.c; i++) {
            arrayList.add(new PlayerRef(this.a_, this.b_ + i, "recipient_"));
        }
        return arrayList;
    }

    public String toString() {
        return GameRequestEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((GameRequestEntity) a()).writeToParcel(parcel, i);
    }
}
