package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

/* loaded from: classes.dex */
public final class PlayerRef extends zzc implements Player {
    private final PlayerColumnNames c;
    private final PlayerLevelInfo d;
    private final MostRecentGameInfoRef e;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        this.c = new PlayerColumnNames(str);
        this.e = new MostRecentGameInfoRef(dataHolder, i, this.c);
        if (!s()) {
            this.d = null;
            return;
        }
        int c = c(this.c.k);
        int c2 = c(this.c.n);
        PlayerLevel playerLevel = new PlayerLevel(c, b(this.c.l), b(this.c.m));
        this.d = new PlayerLevelInfo(b(this.c.j), b(this.c.p), playerLevel, c != c2 ? new PlayerLevel(c2, b(this.c.m), b(this.c.o)) : playerLevel);
    }

    private boolean s() {
        return (i(this.c.j) || b(this.c.j) == -1) ? false : true;
    }

    @Override // com.google.android.gms.games.Player
    public String b() {
        return e(this.c.f1377a);
    }

    @Override // com.google.android.gms.games.Player
    public String c() {
        return e(this.c.b);
    }

    @Override // com.google.android.gms.games.Player
    public String d() {
        return e(this.c.A);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.Player
    public String e() {
        return e(this.c.B);
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return PlayerEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.Player
    public boolean f() {
        return d(this.c.z);
    }

    @Override // com.google.android.gms.games.Player
    public Uri g() {
        return h(this.c.c);
    }

    @Override // com.google.android.gms.games.Player
    public String h() {
        return e(this.c.d);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return PlayerEntity.a(this);
    }

    @Override // com.google.android.gms.games.Player
    public Uri i() {
        return h(this.c.e);
    }

    @Override // com.google.android.gms.games.Player
    public String j() {
        return e(this.c.f);
    }

    @Override // com.google.android.gms.games.Player
    public long k() {
        return b(this.c.g);
    }

    @Override // com.google.android.gms.games.Player
    public long l() {
        if (!a_(this.c.i) || i(this.c.i)) {
            return -1L;
        }
        return b(this.c.i);
    }

    @Override // com.google.android.gms.games.Player
    public int m() {
        return c(this.c.h);
    }

    @Override // com.google.android.gms.games.Player
    public boolean n() {
        return d(this.c.s);
    }

    @Override // com.google.android.gms.games.Player
    public String o() {
        return e(this.c.q);
    }

    @Override // com.google.android.gms.games.Player
    public PlayerLevelInfo p() {
        return this.d;
    }

    @Override // com.google.android.gms.games.Player
    public MostRecentGameInfo q() {
        if (i(this.c.t)) {
            return null;
        }
        return this.e;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Player a() {
        return new PlayerEntity(this);
    }

    public String toString() {
        return PlayerEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) a()).writeToParcel(parcel, i);
    }
}
