package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class PlayerStatsEntity implements SafeParcelable, PlayerStats {
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1401a;
    private final float b;
    private final float c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final float h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerStatsEntity(int i, float f, float f2, int i2, int i3, int i4, float f3, float f4) {
        this.f1401a = i;
        this.b = f;
        this.c = f2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f3;
        this.h = f4;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.f1401a = 1;
        this.b = playerStats.b();
        this.c = playerStats.c();
        this.d = playerStats.d();
        this.e = playerStats.e();
        this.f = playerStats.f();
        this.g = playerStats.g();
        this.h = playerStats.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(PlayerStats playerStats) {
        return zzw.a(Float.valueOf(playerStats.b()), Float.valueOf(playerStats.c()), Integer.valueOf(playerStats.d()), Integer.valueOf(playerStats.e()), Integer.valueOf(playerStats.f()), Float.valueOf(playerStats.g()), Float.valueOf(playerStats.h()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return zzw.a(Float.valueOf(playerStats2.b()), Float.valueOf(playerStats.b())) && zzw.a(Float.valueOf(playerStats2.c()), Float.valueOf(playerStats.c())) && zzw.a(Integer.valueOf(playerStats2.d()), Integer.valueOf(playerStats.d())) && zzw.a(Integer.valueOf(playerStats2.e()), Integer.valueOf(playerStats.e())) && zzw.a(Integer.valueOf(playerStats2.f()), Integer.valueOf(playerStats.f())) && zzw.a(Float.valueOf(playerStats2.g()), Float.valueOf(playerStats.g())) && zzw.a(Float.valueOf(playerStats2.h()), Float.valueOf(playerStats.h()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(PlayerStats playerStats) {
        return zzw.a(playerStats).a("AverageSessionLength", Float.valueOf(playerStats.b())).a("ChurnProbability", Float.valueOf(playerStats.c())).a("DaysSinceLastPlayed", Integer.valueOf(playerStats.d())).a("NumberOfPurchases", Integer.valueOf(playerStats.e())).a("NumberOfSessions", Integer.valueOf(playerStats.f())).a("SessionPercentile", Float.valueOf(playerStats.g())).a("SpendPercentile", Float.valueOf(playerStats.h())).toString();
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float g() {
        return this.g;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    public int i() {
        return this.f1401a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public PlayerStats a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PlayerStatsEntityCreator.a(this, parcel, i);
    }
}
