package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* loaded from: classes.dex */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f1387a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final int f;
    private final String g;
    private final boolean h;
    private final PlayerEntity i;
    private final int j;
    private final ParticipantResult k;
    private final String l;
    private final String m;

    /* loaded from: classes.dex */
    static final class a extends ParticipantEntityCreator {
        a() {
        }

        @Override // com.google.android.gms.games.multiplayer.ParticipantEntityCreator, android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            if (ParticipantEntity.b(ParticipantEntity.p()) || ParticipantEntity.a(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            return new ParticipantEntity(3, readString, readString2, parse, readString4 == null ? null : Uri.parse(readString4), parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0 ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.f1387a = i;
        this.b = str;
        this.c = str2;
        this.d = uri;
        this.e = uri2;
        this.f = i2;
        this.g = str3;
        this.h = z;
        this.i = playerEntity;
        this.j = i3;
        this.k = participantResult;
        this.l = str4;
        this.m = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.f1387a = 3;
        this.b = participant.k();
        this.c = participant.f();
        this.d = participant.g();
        this.e = participant.i();
        this.f = participant.b();
        this.g = participant.c();
        this.h = participant.e();
        Player l = participant.l();
        this.i = l == null ? null : new PlayerEntity(l);
        this.j = participant.d();
        this.k = participant.m();
        this.l = participant.h();
        this.m = participant.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Participant participant) {
        return zzw.a(participant.l(), Integer.valueOf(participant.b()), participant.c(), Boolean.valueOf(participant.e()), participant.f(), participant.g(), participant.i(), Integer.valueOf(participant.d()), participant.m(), participant.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.a(participant2.l(), participant.l()) && zzw.a(Integer.valueOf(participant2.b()), Integer.valueOf(participant.b())) && zzw.a(participant2.c(), participant.c()) && zzw.a(Boolean.valueOf(participant2.e()), Boolean.valueOf(participant.e())) && zzw.a(participant2.f(), participant.f()) && zzw.a(participant2.g(), participant.g()) && zzw.a(participant2.i(), participant.i()) && zzw.a(Integer.valueOf(participant2.d()), Integer.valueOf(participant.d())) && zzw.a(participant2.m(), participant.m()) && zzw.a(participant2.k(), participant.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Participant participant) {
        return zzw.a(participant).a("ParticipantId", participant.k()).a("Player", participant.l()).a("Status", Integer.valueOf(participant.b())).a("ClientAddress", participant.c()).a("ConnectedToRoom", Boolean.valueOf(participant.e())).a("DisplayName", participant.f()).a("IconImage", participant.g()).a("IconImageUrl", participant.h()).a("HiResImage", participant.i()).a("HiResImageUrl", participant.j()).a("Capabilities", Integer.valueOf(participant.d())).a("Result", participant.m()).toString();
    }

    static /* synthetic */ Integer p() {
        return c_();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int b() {
        return this.f;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String c() {
        return this.g;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public int d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public boolean e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String f() {
        return this.i == null ? this.c : this.i.c();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri g() {
        return this.i == null ? this.d : this.i.g();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String h() {
        return this.i == null ? this.l : this.i.h();
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Uri i() {
        return this.i == null ? this.e : this.i.i();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String j() {
        return this.i == null ? this.m : this.i.j();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public String k() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public Player l() {
        return this.i;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public ParticipantResult m() {
        return this.k;
    }

    public int n() {
        return this.f1387a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Participant a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!d_()) {
            ParticipantEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d == null ? null : this.d.toString());
        parcel.writeString(this.e != null ? this.e.toString() : null);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i != null ? 1 : 0);
        if (this.i != null) {
            this.i.writeToParcel(parcel, i);
        }
    }
}
