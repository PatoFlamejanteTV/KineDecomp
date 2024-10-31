package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class EventRef extends zzc implements Event {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.games.event.Event
    public String b() {
        return e("external_event_id");
    }

    @Override // com.google.android.gms.games.event.Event
    public String c() {
        return e("name");
    }

    @Override // com.google.android.gms.games.event.Event
    public String d() {
        return e("description");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.event.Event
    public Uri e() {
        return h("icon_image_uri");
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return EventEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.event.Event
    public String f() {
        return e("icon_image_url");
    }

    @Override // com.google.android.gms.games.event.Event
    public Player g() {
        return new PlayerRef(this.a_, this.b_);
    }

    @Override // com.google.android.gms.games.event.Event
    public long h() {
        return b("value");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return EventEntity.a(this);
    }

    @Override // com.google.android.gms.games.event.Event
    public String i() {
        return e("formatted_value");
    }

    @Override // com.google.android.gms.games.event.Event
    public boolean j() {
        return d("visibility");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Event a() {
        return new EventEntity(this);
    }

    public String toString() {
        return EventEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((EventEntity) a()).writeToParcel(parcel, i);
    }
}
