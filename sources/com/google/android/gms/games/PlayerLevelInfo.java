package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class PlayerLevelInfo implements SafeParcelable {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1301a;
    private final long b;
    private final long c;
    private final PlayerLevel d;
    private final PlayerLevel e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerLevelInfo(int i, long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        zzx.a(j != -1);
        zzx.a(playerLevel);
        zzx.a(playerLevel2);
        this.f1301a = i;
        this.b = j;
        this.c = j2;
        this.d = playerLevel;
        this.e = playerLevel2;
    }

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        this(1, j, j2, playerLevel, playerLevel2);
    }

    public int a() {
        return this.f1301a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public PlayerLevel d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlayerLevel e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.a(Long.valueOf(this.b), Long.valueOf(playerLevelInfo.b)) && zzw.a(Long.valueOf(this.c), Long.valueOf(playerLevelInfo.c)) && zzw.a(this.d, playerLevelInfo.d) && zzw.a(this.e, playerLevelInfo.e);
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.b), Long.valueOf(this.c), this.d, this.e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelInfoCreator.a(this, parcel, i);
    }
}
