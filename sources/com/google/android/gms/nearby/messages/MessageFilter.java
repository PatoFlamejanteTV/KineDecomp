package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class MessageFilter implements SafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public static final MessageFilter f2096a = new Builder().a().b();
    final int b;
    private final List<MessageType> c;
    private final List<NearbyDeviceFilter> d;
    private final boolean e;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<MessageType> f2097a = new ArrayList();
        private final List<NearbyDeviceFilter> b = new ArrayList();
        private boolean c;

        public Builder a() {
            this.c = true;
            return this;
        }

        public MessageFilter b() {
            zzx.a(this.c || !this.f2097a.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(this.f2097a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageFilter(int i, List<MessageType> list, List<NearbyDeviceFilter> list2, boolean z) {
        this.b = i;
        this.c = Collections.unmodifiableList((List) zzx.a(list));
        this.e = z;
        this.d = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
    }

    private MessageFilter(List<MessageType> list, List<NearbyDeviceFilter> list2, boolean z) {
        this(1, list, list2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<MessageType> a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<NearbyDeviceFilter> c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.e == messageFilter.e && zzw.a(this.c, messageFilter.c) && zzw.a(this.d, messageFilter.d);
    }

    public int hashCode() {
        return zzw.a(this.c, this.d, Boolean.valueOf(this.e));
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.e + ", messageTypes=" + this.c + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
