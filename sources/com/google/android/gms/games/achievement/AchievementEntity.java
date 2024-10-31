package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

/* loaded from: classes.dex */
public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1302a;
    private final String b;
    private final int c;
    private final String d;
    private final String e;
    private final Uri f;
    private final String g;
    private final Uri h;
    private final String i;
    private final int j;
    private final String k;
    private final PlayerEntity l;
    private final int m;
    private final int n;
    private final String o;
    private final long p;
    private final long q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AchievementEntity(int i, String str, int i2, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i3, String str6, PlayerEntity playerEntity, int i4, int i5, String str7, long j, long j2) {
        this.f1302a = i;
        this.b = str;
        this.c = i2;
        this.d = str2;
        this.e = str3;
        this.f = uri;
        this.g = str4;
        this.h = uri2;
        this.i = str5;
        this.j = i3;
        this.k = str6;
        this.l = playerEntity;
        this.m = i4;
        this.n = i5;
        this.o = str7;
        this.p = j;
        this.q = j2;
    }

    public AchievementEntity(Achievement achievement) {
        this.f1302a = 1;
        this.b = achievement.b();
        this.c = achievement.c();
        this.d = achievement.d();
        this.e = achievement.e();
        this.f = achievement.f();
        this.g = achievement.g();
        this.h = achievement.h();
        this.i = achievement.i();
        this.l = (PlayerEntity) achievement.l().a();
        this.m = achievement.m();
        this.p = achievement.p();
        this.q = achievement.q();
        if (achievement.c() == 1) {
            this.j = achievement.j();
            this.k = achievement.k();
            this.n = achievement.n();
            this.o = achievement.o();
        } else {
            this.j = 0;
            this.k = null;
            this.n = 0;
            this.o = null;
        }
        zzb.a(this.b);
        zzb.a(this.e);
    }

    static int a(Achievement achievement) {
        int i;
        int i2;
        if (achievement.c() == 1) {
            i2 = achievement.n();
            i = achievement.j();
        } else {
            i = 0;
            i2 = 0;
        }
        return zzw.a(achievement.b(), achievement.d(), Integer.valueOf(achievement.c()), achievement.e(), Long.valueOf(achievement.q()), Integer.valueOf(achievement.m()), Long.valueOf(achievement.p()), achievement.l(), Integer.valueOf(i2), Integer.valueOf(i));
    }

    static boolean a(Achievement achievement, Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement.c() == 1) {
            z2 = zzw.a(Integer.valueOf(achievement2.n()), Integer.valueOf(achievement.n()));
            z = zzw.a(Integer.valueOf(achievement2.j()), Integer.valueOf(achievement.j()));
        } else {
            z = true;
            z2 = true;
        }
        return zzw.a(achievement2.b(), achievement.b()) && zzw.a(achievement2.d(), achievement.d()) && zzw.a(Integer.valueOf(achievement2.c()), Integer.valueOf(achievement.c())) && zzw.a(achievement2.e(), achievement.e()) && zzw.a(Long.valueOf(achievement2.q()), Long.valueOf(achievement.q())) && zzw.a(Integer.valueOf(achievement2.m()), Integer.valueOf(achievement.m())) && zzw.a(Long.valueOf(achievement2.p()), Long.valueOf(achievement.p())) && zzw.a(achievement2.l(), achievement.l()) && z2 && z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Achievement achievement) {
        zzw.zza a2 = zzw.a(achievement).a("Id", achievement.b()).a("Type", Integer.valueOf(achievement.c())).a("Name", achievement.d()).a("Description", achievement.e()).a("Player", achievement.l()).a("State", Integer.valueOf(achievement.m()));
        if (achievement.c() == 1) {
            a2.a("CurrentSteps", Integer.valueOf(achievement.n()));
            a2.a("TotalSteps", Integer.valueOf(achievement.j()));
        }
        return a2.toString();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String g() {
        return this.g;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String i() {
        return this.i;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int j() {
        zzb.a(c() == 1);
        return s();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String k() {
        zzb.a(c() == 1);
        return t();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Player l() {
        return this.l;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int m() {
        return this.m;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int n() {
        zzb.a(c() == 1);
        return u();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String o() {
        zzb.a(c() == 1);
        return v();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long p() {
        return this.p;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long q() {
        return this.q;
    }

    public int r() {
        return this.f1302a;
    }

    public int s() {
        return this.j;
    }

    public String t() {
        return this.k;
    }

    public String toString() {
        return b(this);
    }

    public int u() {
        return this.n;
    }

    public String v() {
        return this.o;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Achievement a() {
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AchievementEntityCreator.a(this, parcel, i);
    }
}
