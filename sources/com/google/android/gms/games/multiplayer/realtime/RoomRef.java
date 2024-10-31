package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class RoomRef extends zzc implements Room {
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String b() {
        return e("external_match_id");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String c() {
        return e("creator_external");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public long d() {
        return b("creation_timestamp");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int e() {
        return c(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return RoomEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public String f() {
        return e("description");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int g() {
        return c("variant");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public Bundle h() {
        if (d("has_automatch_criteria")) {
            return RoomConfig.a(c("automatch_min_players"), c("automatch_max_players"), b("automatch_bit_mask"));
        }
        return null;
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return RoomEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.Room
    public int i() {
        return c("automatch_wait_estimate_sec");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Room a() {
        return new RoomEntity(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public ArrayList<Participant> l() {
        ArrayList<Participant> arrayList = new ArrayList<>(this.c);
        for (int i = 0; i < this.c; i++) {
            arrayList.add(new ParticipantRef(this.a_, this.b_ + i));
        }
        return arrayList;
    }

    public String toString() {
        return RoomEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((RoomEntity) a()).writeToParcel(parcel, i);
    }
}
