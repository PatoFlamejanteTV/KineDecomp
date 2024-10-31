package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class ParticipantRef extends zzc implements Participant {
    private final PlayerRef c;

    public ParticipantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = new PlayerRef(dataHolder, i);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int b() {
        return c("player_status");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String c() {
        return e("client_address");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int d() {
        return c("capabilities");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public boolean e() {
        return c("connected") > 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return ParticipantEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String f() {
        return i("external_player_id") ? e("default_display_name") : this.c.c();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri g() {
        return i("external_player_id") ? h("default_display_image_uri") : this.c.g();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String h() {
        return i("external_player_id") ? e("default_display_image_url") : this.c.h();
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri i() {
        return i("external_player_id") ? h("default_display_hi_res_image_uri") : this.c.i();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String j() {
        return i("external_player_id") ? e("default_display_hi_res_image_url") : this.c.j();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String k() {
        return e("external_participant_id");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Player l() {
        if (i("external_player_id")) {
            return null;
        }
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public ParticipantResult m() {
        if (i("result_type")) {
            return null;
        }
        return new ParticipantResult(k(), c("result_type"), c("placing"));
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Participant a() {
        return new ParticipantEntity(this);
    }

    public String toString() {
        return ParticipantEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((ParticipantEntity) a()).writeToParcel(parcel, i);
    }
}
