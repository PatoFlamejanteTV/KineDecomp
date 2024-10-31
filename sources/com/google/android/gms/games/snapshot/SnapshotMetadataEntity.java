package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

/* loaded from: classes.dex */
public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1400a;
    private final GameEntity b;
    private final PlayerEntity c;
    private final String d;
    private final Uri e;
    private final String f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;
    private final float k;
    private final String l;
    private final boolean m;
    private final long n;
    private final String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotMetadataEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, String str, Uri uri, String str2, String str3, String str4, long j, long j2, float f, String str5, boolean z, long j3, String str6) {
        this.f1400a = i;
        this.b = gameEntity;
        this.c = playerEntity;
        this.d = str;
        this.e = uri;
        this.f = str2;
        this.k = f;
        this.g = str3;
        this.h = str4;
        this.i = j;
        this.j = j2;
        this.l = str5;
        this.m = z;
        this.n = j3;
        this.o = str6;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.f1400a = 6;
        this.b = new GameEntity(snapshotMetadata.b());
        this.c = new PlayerEntity(snapshotMetadata.c());
        this.d = snapshotMetadata.d();
        this.e = snapshotMetadata.e();
        this.f = snapshotMetadata.f();
        this.k = snapshotMetadata.g();
        this.g = snapshotMetadata.i();
        this.h = snapshotMetadata.j();
        this.i = snapshotMetadata.k();
        this.j = snapshotMetadata.l();
        this.l = snapshotMetadata.h();
        this.m = snapshotMetadata.m();
        this.n = snapshotMetadata.n();
        this.o = snapshotMetadata.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(SnapshotMetadata snapshotMetadata) {
        return zzw.a(snapshotMetadata.b(), snapshotMetadata.c(), snapshotMetadata.d(), snapshotMetadata.e(), Float.valueOf(snapshotMetadata.g()), snapshotMetadata.i(), snapshotMetadata.j(), Long.valueOf(snapshotMetadata.k()), Long.valueOf(snapshotMetadata.l()), snapshotMetadata.h(), Boolean.valueOf(snapshotMetadata.m()), Long.valueOf(snapshotMetadata.n()), snapshotMetadata.o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzw.a(snapshotMetadata2.b(), snapshotMetadata.b()) && zzw.a(snapshotMetadata2.c(), snapshotMetadata.c()) && zzw.a(snapshotMetadata2.d(), snapshotMetadata.d()) && zzw.a(snapshotMetadata2.e(), snapshotMetadata.e()) && zzw.a(Float.valueOf(snapshotMetadata2.g()), Float.valueOf(snapshotMetadata.g())) && zzw.a(snapshotMetadata2.i(), snapshotMetadata.i()) && zzw.a(snapshotMetadata2.j(), snapshotMetadata.j()) && zzw.a(Long.valueOf(snapshotMetadata2.k()), Long.valueOf(snapshotMetadata.k())) && zzw.a(Long.valueOf(snapshotMetadata2.l()), Long.valueOf(snapshotMetadata.l())) && zzw.a(snapshotMetadata2.h(), snapshotMetadata.h()) && zzw.a(Boolean.valueOf(snapshotMetadata2.m()), Boolean.valueOf(snapshotMetadata.m())) && zzw.a(Long.valueOf(snapshotMetadata2.n()), Long.valueOf(snapshotMetadata.n())) && zzw.a(snapshotMetadata2.o(), snapshotMetadata.o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(SnapshotMetadata snapshotMetadata) {
        return zzw.a(snapshotMetadata).a("Game", snapshotMetadata.b()).a("Owner", snapshotMetadata.c()).a("SnapshotId", snapshotMetadata.d()).a("CoverImageUri", snapshotMetadata.e()).a("CoverImageUrl", snapshotMetadata.f()).a("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.g())).a("Description", snapshotMetadata.j()).a("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.k())).a("PlayedTime", Long.valueOf(snapshotMetadata.l())).a("UniqueName", snapshotMetadata.h()).a("ChangePending", Boolean.valueOf(snapshotMetadata.m())).a("ProgressValue", Long.valueOf(snapshotMetadata.n())).a("DeviceName", snapshotMetadata.o()).toString();
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Game b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Player c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Uri e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public float g() {
        return this.k;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String h() {
        return this.l;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String i() {
        return this.g;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String j() {
        return this.h;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long k() {
        return this.i;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long l() {
        return this.j;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public boolean m() {
        return this.m;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long n() {
        return this.n;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String o() {
        return this.o;
    }

    public int p() {
        return this.f1400a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadata a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataEntityCreator.a(this, parcel, i);
    }
}
