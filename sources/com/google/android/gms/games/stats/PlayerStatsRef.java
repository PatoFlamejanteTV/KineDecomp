package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes.dex */
public class PlayerStatsRef extends zzc implements PlayerStats {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerStatsRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float b() {
        return f("ave_session_length_minutes");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float c() {
        return f("churn_probability");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int d() {
        return c("days_since_last_played");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int e() {
        return c("num_purchases");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return PlayerStatsEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int f() {
        return c("num_sessions");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float g() {
        return f("num_sessions_percentile");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float h() {
        return f("spend_percentile");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return PlayerStatsEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public PlayerStats a() {
        return new PlayerStatsEntity(this);
    }

    public String toString() {
        return PlayerStatsEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((PlayerStatsEntity) a()).writeToParcel(parcel, i);
    }
}
