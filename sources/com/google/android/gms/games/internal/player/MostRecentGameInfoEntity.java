package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1376a;
    private final String b;
    private final String c;
    private final long d;
    private final Uri e;
    private final Uri f;
    private final Uri g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.f1376a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = uri;
        this.f = uri2;
        this.g = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.f1376a = 2;
        this.b = mostRecentGameInfo.b();
        this.c = mostRecentGameInfo.c();
        this.d = mostRecentGameInfo.d();
        this.e = mostRecentGameInfo.e();
        this.f = mostRecentGameInfo.f();
        this.g = mostRecentGameInfo.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.a(mostRecentGameInfo.b(), mostRecentGameInfo.c(), Long.valueOf(mostRecentGameInfo.d()), mostRecentGameInfo.e(), mostRecentGameInfo.f(), mostRecentGameInfo.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.a(mostRecentGameInfo2.b(), mostRecentGameInfo.b()) && zzw.a(mostRecentGameInfo2.c(), mostRecentGameInfo.c()) && zzw.a(Long.valueOf(mostRecentGameInfo2.d()), Long.valueOf(mostRecentGameInfo.d())) && zzw.a(mostRecentGameInfo2.e(), mostRecentGameInfo.e()) && zzw.a(mostRecentGameInfo2.f(), mostRecentGameInfo.f()) && zzw.a(mostRecentGameInfo2.g(), mostRecentGameInfo.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.a(mostRecentGameInfo).a("GameId", mostRecentGameInfo.b()).a("GameName", mostRecentGameInfo.c()).a("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.d())).a("GameIconUri", mostRecentGameInfo.e()).a("GameHiResUri", mostRecentGameInfo.f()).a("GameFeaturedUri", mostRecentGameInfo.g()).toString();
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public long d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri g() {
        return this.g;
    }

    public int h() {
        return this.f1376a;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfo a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        MostRecentGameInfoEntityCreator.a(this, parcel, i);
    }
}
