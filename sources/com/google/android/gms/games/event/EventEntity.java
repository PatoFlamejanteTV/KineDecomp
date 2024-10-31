package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

/* loaded from: classes.dex */
public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1313a;
    private final String b;
    private final String c;
    private final String d;
    private final Uri e;
    private final String f;
    private final PlayerEntity g;
    private final long h;
    private final String i;
    private final boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventEntity(int i, String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.f1313a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = uri;
        this.f = str4;
        this.g = new PlayerEntity(player);
        this.h = j;
        this.i = str5;
        this.j = z;
    }

    public EventEntity(Event event) {
        this.f1313a = 1;
        this.b = event.b();
        this.c = event.c();
        this.d = event.d();
        this.e = event.e();
        this.f = event.f();
        this.g = (PlayerEntity) event.g().a();
        this.h = event.h();
        this.i = event.i();
        this.j = event.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Event event) {
        return zzw.a(event.b(), event.c(), event.d(), event.e(), event.f(), event.g(), Long.valueOf(event.h()), event.i(), Boolean.valueOf(event.j()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzw.a(event2.b(), event.b()) && zzw.a(event2.c(), event.c()) && zzw.a(event2.d(), event.d()) && zzw.a(event2.e(), event.e()) && zzw.a(event2.f(), event.f()) && zzw.a(event2.g(), event.g()) && zzw.a(Long.valueOf(event2.h()), Long.valueOf(event.h())) && zzw.a(event2.i(), event.i()) && zzw.a(Boolean.valueOf(event2.j()), Boolean.valueOf(event.j()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Event event) {
        return zzw.a(event).a("Id", event.b()).a("Name", event.c()).a("Description", event.d()).a("IconImageUri", event.e()).a("IconImageUrl", event.f()).a("Player", event.g()).a("Value", Long.valueOf(event.h())).a("FormattedValue", event.i()).a("isVisible", Boolean.valueOf(event.j())).toString();
    }

    @Override // com.google.android.gms.games.event.Event
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.event.Event
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.event.Event
    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.event.Event
    public Uri e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.event.Event
    public String f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.event.Event
    public Player g() {
        return this.g;
    }

    @Override // com.google.android.gms.games.event.Event
    public long h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.event.Event
    public String i() {
        return this.i;
    }

    @Override // com.google.android.gms.games.event.Event
    public boolean j() {
        return this.j;
    }

    public int k() {
        return this.f1313a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Event a() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        EventEntityCreator.a(this, parcel, i);
    }
}
