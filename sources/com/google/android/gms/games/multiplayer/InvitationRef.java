package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class InvitationRef extends zzc implements Invitation {
    private final Game c;
    private final ParticipantRef d;
    private final ArrayList<Participant> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = new GameRef(dataHolder, i);
        this.e = new ArrayList<>(i2);
        String e = e("external_inviter_id");
        ParticipantRef participantRef = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticipantRef participantRef2 = new ParticipantRef(this.a_, this.b_ + i3);
            if (participantRef2.k().equals(e)) {
                participantRef = participantRef2;
            }
            this.e.add(participantRef2);
        }
        this.d = (ParticipantRef) zzx.a(participantRef, "Must have a valid inviter!");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Invitation a() {
        return new InvitationEntity(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Game d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public String e() {
        return e("external_invitation_id");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return InvitationEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Participant f() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public long g() {
        return Math.max(b("creation_timestamp"), b("last_modified_timestamp"));
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int h() {
        return c("type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return InvitationEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int i() {
        return c("variant");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int j() {
        if (d("has_automatch_criteria")) {
            return c("automatch_max_players");
        }
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList<Participant> l() {
        return this.e;
    }

    public String toString() {
        return InvitationEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) a()).writeToParcel(parcel, i);
    }
}
