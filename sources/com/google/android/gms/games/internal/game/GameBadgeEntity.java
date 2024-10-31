package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* loaded from: classes.dex */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f1374a;
    private int b;
    private String c;
    private String d;
    private Uri e;

    /* loaded from: classes.dex */
    static final class a extends GameBadgeEntityCreator {
        a() {
        }

        @Override // com.google.android.gms.games.internal.game.GameBadgeEntityCreator, android.os.Parcelable.Creator
        /* renamed from: a */
        public GameBadgeEntity createFromParcel(Parcel parcel) {
            if (GameBadgeEntity.b(GameBadgeEntity.h()) || GameBadgeEntity.a(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameBadgeEntity(int i, int i2, String str, String str2, Uri uri) {
        this.f1374a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = uri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.f1374a = 1;
        this.b = gameBadge.b();
        this.c = gameBadge.c();
        this.d = gameBadge.d();
        this.e = gameBadge.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(GameBadge gameBadge) {
        return zzw.a(Integer.valueOf(gameBadge.b()), gameBadge.c(), gameBadge.d(), gameBadge.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzw.a(Integer.valueOf(gameBadge2.b()), gameBadge.c()) && zzw.a(gameBadge2.d(), gameBadge.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(GameBadge gameBadge) {
        return zzw.a(gameBadge).a("Type", Integer.valueOf(gameBadge.b())).a("Title", gameBadge.c()).a("Description", gameBadge.d()).a("IconImageUri", gameBadge.e()).toString();
    }

    static /* synthetic */ Integer h() {
        return c_();
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public int b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public Uri e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public int f() {
        return this.f1374a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public GameBadge a() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!d_()) {
            GameBadgeEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e == null ? null : this.e.toString());
    }
}
