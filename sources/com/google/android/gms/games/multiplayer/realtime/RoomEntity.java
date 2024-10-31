package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f1390a;
    private final String b;
    private final String c;
    private final long d;
    private final int e;
    private final String f;
    private final int g;
    private final Bundle h;
    private final ArrayList<ParticipantEntity> i;
    private final int j;

    /* loaded from: classes.dex */
    static final class a extends RoomEntityCreator {
        a() {
        }

        @Override // com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator, android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoomEntity createFromParcel(Parcel parcel) {
            if (RoomEntity.b(RoomEntity.m()) || RoomEntity.a(RoomEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomEntity(int i, String str, String str2, long j, int i2, String str3, int i3, Bundle bundle, ArrayList<ParticipantEntity> arrayList, int i4) {
        this.f1390a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = i2;
        this.f = str3;
        this.g = i3;
        this.h = bundle;
        this.i = arrayList;
        this.j = i4;
    }

    public RoomEntity(Room room) {
        this.f1390a = 2;
        this.b = room.b();
        this.c = room.c();
        this.d = room.d();
        this.e = room.e();
        this.f = room.f();
        this.g = room.g();
        this.h = room.h();
        ArrayList<Participant> l = room.l();
        int size = l.size();
        this.i = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.i.add((ParticipantEntity) l.get(i).a());
        }
        this.j = room.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Room room) {
        return zzw.a(room.b(), room.c(), Long.valueOf(room.d()), Integer.valueOf(room.e()), room.f(), Integer.valueOf(room.g()), room.h(), room.l(), Integer.valueOf(room.i()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return zzw.a(room2.b(), room.b()) && zzw.a(room2.c(), room.c()) && zzw.a(Long.valueOf(room2.d()), Long.valueOf(room.d())) && zzw.a(Integer.valueOf(room2.e()), Integer.valueOf(room.e())) && zzw.a(room2.f(), room.f()) && zzw.a(Integer.valueOf(room2.g()), Integer.valueOf(room.g())) && zzw.a(room2.h(), room.h()) && zzw.a(room2.l(), room.l()) && zzw.a(Integer.valueOf(room2.i()), Integer.valueOf(room.i()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Room room) {
        return zzw.a(room).a("RoomId", room.b()).a("CreatorId", room.c()).a("CreationTimestamp", Long.valueOf(room.d())).a("RoomStatus", Integer.valueOf(room.e())).a("Description", room.f()).a("Variant", Integer.valueOf(room.g())).a("AutoMatchCriteria", room.h()).a("Participants", room.l()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.i())).toString();
    }

    static /* synthetic */ Integer m() {
        return c_();
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String c() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public long d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String f() {
        return this.f;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int g() {
        return this.g;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public Bundle h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int i() {
        return this.j;
    }

    public int j() {
        return this.f1390a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Room a() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList<Participant> l() {
        return new ArrayList<>(this.i);
    }

    public String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!d_()) {
            RoomEntityCreator.a(this, parcel, i);
            return;
        }
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeBundle(this.h);
        int size = this.i.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.i.get(i2).writeToParcel(parcel, i);
        }
    }
}
