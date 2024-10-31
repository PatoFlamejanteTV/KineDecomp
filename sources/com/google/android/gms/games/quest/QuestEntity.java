package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class QuestEntity implements SafeParcelable, Quest {
    public static final Parcelable.Creator<QuestEntity> CREATOR = new QuestEntityCreator();
    private final int c;
    private final GameEntity d;
    private final String e;
    private final long f;
    private final Uri g;
    private final String h;
    private final String i;
    private final long j;
    private final long k;
    private final Uri l;
    private final String m;
    private final String n;
    private final long o;
    private final long p;
    private final int q;
    private final int r;
    private final ArrayList<MilestoneEntity> s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuestEntity(int i, GameEntity gameEntity, String str, long j, Uri uri, String str2, String str3, long j2, long j3, Uri uri2, String str4, String str5, long j4, long j5, int i2, int i3, ArrayList<MilestoneEntity> arrayList) {
        this.c = i;
        this.d = gameEntity;
        this.e = str;
        this.f = j;
        this.g = uri;
        this.h = str2;
        this.i = str3;
        this.j = j2;
        this.k = j3;
        this.l = uri2;
        this.m = str4;
        this.n = str5;
        this.o = j4;
        this.p = j5;
        this.q = i2;
        this.r = i3;
        this.s = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.c = 2;
        this.d = new GameEntity(quest.j());
        this.e = quest.b();
        this.f = quest.m();
        this.i = quest.d();
        this.g = quest.e();
        this.h = quest.f();
        this.j = quest.n();
        this.l = quest.g();
        this.m = quest.h();
        this.k = quest.o();
        this.n = quest.c();
        this.o = quest.p();
        this.p = quest.q();
        this.q = quest.k();
        this.r = quest.l();
        List<Milestone> i = quest.i();
        int size = i.size();
        this.s = new ArrayList<>(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.s.add((MilestoneEntity) i.get(i2).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Quest quest) {
        return zzw.a(quest.j(), quest.b(), Long.valueOf(quest.m()), quest.e(), quest.d(), Long.valueOf(quest.n()), quest.g(), Long.valueOf(quest.o()), quest.i(), quest.c(), Long.valueOf(quest.p()), Long.valueOf(quest.q()), Integer.valueOf(quest.k()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzw.a(quest2.j(), quest.j()) && zzw.a(quest2.b(), quest.b()) && zzw.a(Long.valueOf(quest2.m()), Long.valueOf(quest.m())) && zzw.a(quest2.e(), quest.e()) && zzw.a(quest2.d(), quest.d()) && zzw.a(Long.valueOf(quest2.n()), Long.valueOf(quest.n())) && zzw.a(quest2.g(), quest.g()) && zzw.a(Long.valueOf(quest2.o()), Long.valueOf(quest.o())) && zzw.a(quest2.i(), quest.i()) && zzw.a(quest2.c(), quest.c()) && zzw.a(Long.valueOf(quest2.p()), Long.valueOf(quest.p())) && zzw.a(Long.valueOf(quest2.q()), Long.valueOf(quest.q())) && zzw.a(Integer.valueOf(quest2.k()), Integer.valueOf(quest.k()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Quest quest) {
        return zzw.a(quest).a("Game", quest.j()).a("QuestId", quest.b()).a("AcceptedTimestamp", Long.valueOf(quest.m())).a("BannerImageUri", quest.e()).a("BannerImageUrl", quest.f()).a("Description", quest.d()).a("EndTimestamp", Long.valueOf(quest.n())).a("IconImageUri", quest.g()).a("IconImageUrl", quest.h()).a("LastUpdatedTimestamp", Long.valueOf(quest.o())).a("Milestones", quest.i()).a("Name", quest.c()).a("NotifyTimestamp", Long.valueOf(quest.p())).a("StartTimestamp", Long.valueOf(quest.q())).a("State", Integer.valueOf(quest.k())).toString();
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String b() {
        return this.e;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String c() {
        return this.n;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Uri e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String f() {
        return this.h;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Uri g() {
        return this.l;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String h() {
        return this.m;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public List<Milestone> i() {
        return new ArrayList(this.s);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Game j() {
        return this.d;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public int k() {
        return this.q;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public int l() {
        return this.r;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long m() {
        return this.f;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long n() {
        return this.j;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long o() {
        return this.k;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long p() {
        return this.o;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long q() {
        return this.p;
    }

    public int r() {
        return this.c;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Quest a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        QuestEntityCreator.a(this, parcel, i);
    }
}
