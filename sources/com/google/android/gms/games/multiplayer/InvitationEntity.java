package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f1386a;
    private final GameEntity b;
    private final String c;
    private final long d;
    private final int e;
    private final ParticipantEntity f;
    private final ArrayList<ParticipantEntity> g;
    private final int h;
    private final int i;

    /* loaded from: classes.dex */
    static final class a extends InvitationEntityCreator {
        a() {
        }

        @Override // com.google.android.gms.games.multiplayer.InvitationEntityCreator, android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.b(InvitationEntity.n()) || InvitationEntity.a(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity createFromParcel2 = ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationEntity(int i, GameEntity gameEntity, String str, long j, int i2, ParticipantEntity participantEntity, ArrayList<ParticipantEntity> arrayList, int i3, int i4) {
        this.f1386a = i;
        this.b = gameEntity;
        this.c = str;
        this.d = j;
        this.e = i2;
        this.f = participantEntity;
        this.g = arrayList;
        this.h = i3;
        this.i = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationEntity(Invitation invitation) {
        this.f1386a = 2;
        this.b = new GameEntity(invitation.d());
        this.c = invitation.e();
        this.d = invitation.g();
        this.e = invitation.h();
        this.h = invitation.i();
        this.i = invitation.j();
        String k = invitation.f().k();
        Participant participant = null;
        ArrayList<Participant> l = invitation.l();
        int size = l.size();
        this.g = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = l.get(i);
            if (participant2.k().equals(k)) {
                participant = participant2;
            }
            this.g.add((ParticipantEntity) participant2.a());
        }
        zzx.a(participant, "Must have a valid inviter!");
        this.f = (ParticipantEntity) participant.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Invitation invitation) {
        return zzw.a(invitation.d(), invitation.e(), Long.valueOf(invitation.g()), Integer.valueOf(invitation.h()), invitation.f(), invitation.l(), Integer.valueOf(invitation.i()), Integer.valueOf(invitation.j()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzw.a(invitation2.d(), invitation.d()) && zzw.a(invitation2.e(), invitation.e()) && zzw.a(Long.valueOf(invitation2.g()), Long.valueOf(invitation.g())) && zzw.a(Integer.valueOf(invitation2.h()), Integer.valueOf(invitation.h())) && zzw.a(invitation2.f(), invitation.f()) && zzw.a(invitation2.l(), invitation.l()) && zzw.a(Integer.valueOf(invitation2.i()), Integer.valueOf(invitation.i())) && zzw.a(Integer.valueOf(invitation2.j()), Integer.valueOf(invitation.j()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Invitation invitation) {
        return zzw.a(invitation).a("Game", invitation.d()).a("InvitationId", invitation.e()).a("CreationTimestamp", Long.valueOf(invitation.g())).a("InvitationType", Integer.valueOf(invitation.h())).a("Inviter", invitation.f()).a("Participants", invitation.l()).a("Variant", Integer.valueOf(invitation.i())).a("AvailableAutoMatchSlots", Integer.valueOf(invitation.j())).toString();
    }

    static /* synthetic */ Integer n() {
        return c_();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Game d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public Participant f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public long g() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int h() {
        return this.e;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int i() {
        return this.h;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public int j() {
        return this.i;
    }

    public int k() {
        return this.f1386a;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList<Participant> l() {
        return new ArrayList<>(this.g);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Invitation a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!d_()) {
            InvitationEntityCreator.a(this, parcel, i);
            return;
        }
        this.b.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e);
        this.f.writeToParcel(parcel, i);
        int size = this.g.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.g.get(i2).writeToParcel(parcel, i);
        }
    }
}
