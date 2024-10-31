package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* loaded from: classes.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f1299a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final long f;
    private final int g;
    private final long h;
    private final String i;
    private final String j;
    private final String k;
    private final MostRecentGameInfoEntity l;
    private final PlayerLevelInfo m;
    private final boolean n;
    private final boolean o;
    private final String p;
    private final String q;

    /* loaded from: classes.dex */
    static final class a extends PlayerEntityCreator {
        a() {
        }

        @Override // com.google.android.gms.games.PlayerEntityCreator, android.os.Parcelable.Creator
        /* renamed from: a */
        public PlayerEntity createFromParcel(Parcel parcel) {
            if (PlayerEntity.b(PlayerEntity.t()) || PlayerEntity.a(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(12, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerEntity(int i, String str, String str2, Uri uri, Uri uri2, long j, int i2, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7) {
        this.f1299a = i;
        this.b = str;
        this.c = str2;
        this.d = uri;
        this.i = str3;
        this.e = uri2;
        this.j = str4;
        this.f = j;
        this.g = i2;
        this.h = j2;
        this.k = str5;
        this.n = z;
        this.l = mostRecentGameInfoEntity;
        this.m = playerLevelInfo;
        this.o = z2;
        this.p = str6;
        this.q = str7;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean z) {
        this.f1299a = 12;
        this.b = z ? player.b() : null;
        this.c = player.c();
        this.d = player.g();
        this.i = player.h();
        this.e = player.i();
        this.j = player.j();
        this.f = player.k();
        this.g = player.m();
        this.h = player.l();
        this.k = player.o();
        this.n = player.n();
        MostRecentGameInfo q = player.q();
        this.l = q != null ? new MostRecentGameInfoEntity(q) : null;
        this.m = player.p();
        this.o = player.f();
        this.p = player.d();
        this.q = player.e();
        if (z) {
            zzb.a(this.b);
        }
        zzb.a(this.c);
        zzb.a(this.f > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Player player) {
        return zzw.a(player.b(), player.c(), Boolean.valueOf(player.f()), player.g(), player.i(), Long.valueOf(player.k()), player.o(), player.p(), player.d(), player.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.a(player2.b(), player.b()) && zzw.a(player2.c(), player.c()) && zzw.a(Boolean.valueOf(player2.f()), Boolean.valueOf(player.f())) && zzw.a(player2.g(), player.g()) && zzw.a(player2.i(), player.i()) && zzw.a(Long.valueOf(player2.k()), Long.valueOf(player.k())) && zzw.a(player2.o(), player.o()) && zzw.a(player2.p(), player.p()) && zzw.a(player2.d(), player.d()) && zzw.a(player2.e(), player.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Player player) {
        return zzw.a(player).a("PlayerId", player.b()).a("DisplayName", player.c()).a("HasDebugAccess", Boolean.valueOf(player.f())).a("IconImageUri", player.g()).a("IconImageUrl", player.h()).a("HiResImageUri", player.i()).a("HiResImageUrl", player.j()).a("RetrievedTimestamp", Long.valueOf(player.k())).a("Title", player.o()).a("LevelInfo", player.p()).a("GamerTag", player.d()).a("Name", player.e()).toString();
    }

    static /* synthetic */ Integer t() {
        return c_();
    }

    @Override // com.google.android.gms.games.Player
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Player
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Player
    public String d() {
        return this.p;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Player
    public String e() {
        return this.q;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.Player
    public boolean f() {
        return this.o;
    }

    @Override // com.google.android.gms.games.Player
    public Uri g() {
        return this.d;
    }

    @Override // com.google.android.gms.games.Player
    public String h() {
        return this.i;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.Player
    public Uri i() {
        return this.e;
    }

    @Override // com.google.android.gms.games.Player
    public String j() {
        return this.j;
    }

    @Override // com.google.android.gms.games.Player
    public long k() {
        return this.f;
    }

    @Override // com.google.android.gms.games.Player
    public long l() {
        return this.h;
    }

    @Override // com.google.android.gms.games.Player
    public int m() {
        return this.g;
    }

    @Override // com.google.android.gms.games.Player
    public boolean n() {
        return this.n;
    }

    @Override // com.google.android.gms.games.Player
    public String o() {
        return this.k;
    }

    @Override // com.google.android.gms.games.Player
    public PlayerLevelInfo p() {
        return this.m;
    }

    @Override // com.google.android.gms.games.Player
    public MostRecentGameInfo q() {
        return this.l;
    }

    public int r() {
        return this.f1299a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Player a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!d_()) {
            PlayerEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d == null ? null : this.d.toString());
        parcel.writeString(this.e != null ? this.e.toString() : null);
        parcel.writeLong(this.f);
    }
}
