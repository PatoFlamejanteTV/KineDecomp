package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class PlayerLevel implements SafeParcelable {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new PlayerLevelCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1300a;
    private final int b;
    private final long c;
    private final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerLevel(int i, int i2, long j, long j2) {
        zzx.a(j >= 0, "Min XP must be positive!");
        zzx.a(j2 > j, "Max XP must be more than min XP!");
        this.f1300a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    public int a() {
        return this.f1300a;
    }

    public int b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzw.a(Integer.valueOf(playerLevel.b()), Integer.valueOf(b())) && zzw.a(Long.valueOf(playerLevel.c()), Long.valueOf(c())) && zzw.a(Long.valueOf(playerLevel.d()), Long.valueOf(d()));
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d));
    }

    public String toString() {
        return zzw.a(this).a("LevelNumber", Integer.valueOf(b())).a("MinXp", Long.valueOf(c())).a("MaxXp", Long.valueOf(d())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.a(this, parcel, i);
    }
}
