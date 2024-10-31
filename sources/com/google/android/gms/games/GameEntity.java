package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* loaded from: classes.dex */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f1295a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final Uri h;
    private final Uri i;
    private final Uri j;
    private final boolean k;
    private final boolean l;
    private final String m;
    private final int n;
    private final int o;
    private final int p;
    private final boolean q;
    private final boolean r;
    private final String s;
    private final String t;
    private final String u;
    private final boolean v;
    private final boolean w;
    private final boolean x;
    private final String y;
    private final boolean z;

    /* loaded from: classes.dex */
    static final class a extends GameEntityCreator {
        a() {
        }

        @Override // com.google.android.gms.games.GameEntityCreator, android.os.Parcelable.Creator
        /* renamed from: a */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GameEntity.b(GameEntity.C()) || GameEntity.a(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            String readString8 = parcel.readString();
            Uri parse2 = readString8 == null ? null : Uri.parse(readString8);
            String readString9 = parcel.readString();
            return new GameEntity(7, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameEntity(int i, String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, String str10, boolean z5, boolean z6, boolean z7, String str11, boolean z8) {
        this.f1295a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = uri;
        this.s = str8;
        this.i = uri2;
        this.t = str9;
        this.j = uri3;
        this.u = str10;
        this.k = z;
        this.l = z2;
        this.m = str7;
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = z3;
        this.r = z4;
        this.v = z5;
        this.w = z6;
        this.x = z7;
        this.y = str11;
        this.z = z8;
    }

    public GameEntity(Game game) {
        this.f1295a = 7;
        this.b = game.b();
        this.d = game.d();
        this.e = game.e();
        this.f = game.f();
        this.g = game.g();
        this.c = game.c();
        this.h = game.h();
        this.s = game.i();
        this.i = game.j();
        this.t = game.k();
        this.j = game.l();
        this.u = game.m();
        this.k = game.n();
        this.l = game.q();
        this.m = game.r();
        this.n = game.s();
        this.o = game.t();
        this.p = game.u();
        this.q = game.v();
        this.r = game.w();
        this.v = game.o();
        this.w = game.p();
        this.x = game.x();
        this.y = game.y();
        this.z = game.z();
    }

    static /* synthetic */ Integer C() {
        return c_();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Game game) {
        return zzw.a(game.b(), game.c(), game.d(), game.e(), game.f(), game.g(), game.h(), game.j(), game.l(), Boolean.valueOf(game.n()), Boolean.valueOf(game.q()), game.r(), Integer.valueOf(game.s()), Integer.valueOf(game.t()), Integer.valueOf(game.u()), Boolean.valueOf(game.v()), Boolean.valueOf(game.w()), Boolean.valueOf(game.o()), Boolean.valueOf(game.p()), Boolean.valueOf(game.x()), game.y(), Boolean.valueOf(game.z()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.a(game2.b(), game.b()) && zzw.a(game2.c(), game.c()) && zzw.a(game2.d(), game.d()) && zzw.a(game2.e(), game.e()) && zzw.a(game2.f(), game.f()) && zzw.a(game2.g(), game.g()) && zzw.a(game2.h(), game.h()) && zzw.a(game2.j(), game.j()) && zzw.a(game2.l(), game.l()) && zzw.a(Boolean.valueOf(game2.n()), Boolean.valueOf(game.n())) && zzw.a(Boolean.valueOf(game2.q()), Boolean.valueOf(game.q())) && zzw.a(game2.r(), game.r()) && zzw.a(Integer.valueOf(game2.s()), Integer.valueOf(game.s())) && zzw.a(Integer.valueOf(game2.t()), Integer.valueOf(game.t())) && zzw.a(Integer.valueOf(game2.u()), Integer.valueOf(game.u())) && zzw.a(Boolean.valueOf(game2.v()), Boolean.valueOf(game.v()))) {
            if (zzw.a(Boolean.valueOf(game2.w()), Boolean.valueOf(game.w() && zzw.a(Boolean.valueOf(game2.o()), Boolean.valueOf(game.o())) && zzw.a(Boolean.valueOf(game2.p()), Boolean.valueOf(game.p())))) && zzw.a(Boolean.valueOf(game2.x()), Boolean.valueOf(game.x())) && zzw.a(game2.y(), game.y()) && zzw.a(Boolean.valueOf(game2.z()), Boolean.valueOf(game.z()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Game game) {
        return zzw.a(game).a("ApplicationId", game.b()).a("DisplayName", game.c()).a("PrimaryCategory", game.d()).a("SecondaryCategory", game.e()).a("Description", game.f()).a("DeveloperName", game.g()).a("IconImageUri", game.h()).a("IconImageUrl", game.i()).a("HiResImageUri", game.j()).a("HiResImageUrl", game.k()).a("FeaturedImageUri", game.l()).a("FeaturedImageUrl", game.m()).a("PlayEnabledGame", Boolean.valueOf(game.n())).a("InstanceInstalled", Boolean.valueOf(game.q())).a("InstancePackageName", game.r()).a("AchievementTotalCount", Integer.valueOf(game.t())).a("LeaderboardCount", Integer.valueOf(game.u())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.v())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.w())).a("AreSnapshotsEnabled", Boolean.valueOf(game.x())).a("ThemeColor", game.y()).a("HasGamepadSupport", Boolean.valueOf(game.z())).toString();
    }

    public int A() {
        return this.f1295a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Game a() {
        return this;
    }

    @Override // com.google.android.gms.games.Game
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Game
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Game
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Game
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.Game
    public String f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.Game
    public String g() {
        return this.g;
    }

    @Override // com.google.android.gms.games.Game
    public Uri h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.Game
    public String i() {
        return this.s;
    }

    @Override // com.google.android.gms.games.Game
    public Uri j() {
        return this.i;
    }

    @Override // com.google.android.gms.games.Game
    public String k() {
        return this.t;
    }

    @Override // com.google.android.gms.games.Game
    public Uri l() {
        return this.j;
    }

    @Override // com.google.android.gms.games.Game
    public String m() {
        return this.u;
    }

    @Override // com.google.android.gms.games.Game
    public boolean n() {
        return this.k;
    }

    @Override // com.google.android.gms.games.Game
    public boolean o() {
        return this.v;
    }

    @Override // com.google.android.gms.games.Game
    public boolean p() {
        return this.w;
    }

    @Override // com.google.android.gms.games.Game
    public boolean q() {
        return this.l;
    }

    @Override // com.google.android.gms.games.Game
    public String r() {
        return this.m;
    }

    @Override // com.google.android.gms.games.Game
    public int s() {
        return this.n;
    }

    @Override // com.google.android.gms.games.Game
    public int t() {
        return this.o;
    }

    public String toString() {
        return b(this);
    }

    @Override // com.google.android.gms.games.Game
    public int u() {
        return this.p;
    }

    @Override // com.google.android.gms.games.Game
    public boolean v() {
        return this.q;
    }

    @Override // com.google.android.gms.games.Game
    public boolean w() {
        return this.r;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!d_()) {
            GameEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h == null ? null : this.h.toString());
        parcel.writeString(this.i == null ? null : this.i.toString());
        parcel.writeString(this.j != null ? this.j.toString() : null);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
    }

    @Override // com.google.android.gms.games.Game
    public boolean x() {
        return this.x;
    }

    @Override // com.google.android.gms.games.Game
    public String y() {
        return this.y;
    }

    @Override // com.google.android.gms.games.Game
    public boolean z() {
        return this.z;
    }
}
