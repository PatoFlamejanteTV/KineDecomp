package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class TurnBasedMatchRef extends zzc implements TurnBasedMatch {
    private final Game c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TurnBasedMatchRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = new GameRef(dataHolder, i);
        this.d = i2;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public Game b() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String c() {
        return e("external_match_id");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String d() {
        return e("creator_external");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public long e() {
        return b("creation_timestamp");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return TurnBasedMatchEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public int f() {
        return c(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public int g() {
        return c("user_match_status");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String h() {
        return e("description");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return TurnBasedMatchEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public int i() {
        return c("variant");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String j() {
        return e("last_updater_external");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public long k() {
        return b("last_updated_timestamp");
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList<Participant> l() {
        ArrayList<Participant> arrayList = new ArrayList<>(this.d);
        for (int i = 0; i < this.d; i++) {
            arrayList.add(new ParticipantRef(this.a_, this.b_ + i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String m() {
        return e("pending_participant_external");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public byte[] n() {
        return g(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public int o() {
        return c(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String p() {
        return e("rematch_id");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public byte[] q() {
        return g("previous_match_data");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public int r() {
        return c("match_number");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public Bundle s() {
        if (d("has_automatch_criteria")) {
            return TurnBasedMatchConfig.a(c("automatch_min_players"), c("automatch_max_players"), b("automatch_bit_mask"));
        }
        return null;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public int t() {
        if (d("has_automatch_criteria")) {
            return c("automatch_max_players");
        }
        return 0;
    }

    public String toString() {
        return TurnBasedMatchEntity.b(this);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public boolean u() {
        return d("upsync_required");
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    public String v() {
        return e("description_participant_id");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatch a() {
        return new TurnBasedMatchEntity(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((TurnBasedMatchEntity) a()).writeToParcel(parcel, i);
    }
}
