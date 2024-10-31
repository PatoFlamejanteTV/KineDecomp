package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzc();

    /* renamed from: a */
    Bundle f18054a;

    /* renamed from: b */
    private Map<String, String> f18055b;

    /* renamed from: c */
    private Notification f18056c;

    /* loaded from: classes2.dex */
    public static class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f18054a = bundle;
    }

    public final Notification O() {
        if (this.f18056c == null && a.a(this.f18054a)) {
            this.f18056c = new Notification(this.f18054a);
        }
        return this.f18056c;
    }

    public final Map<String, String> a() {
        if (this.f18055b == null) {
            Bundle bundle = this.f18054a;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.f18055b = arrayMap;
        }
        return this.f18055b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f18054a, false);
        SafeParcelWriter.a(parcel, a2);
    }

    /* loaded from: classes2.dex */
    public static class Notification {

        /* renamed from: a */
        private final String f18057a;

        /* renamed from: b */
        private final String f18058b;

        /* renamed from: c */
        private final String[] f18059c;

        /* renamed from: d */
        private final String f18060d;

        /* renamed from: e */
        private final String f18061e;

        /* renamed from: f */
        private final String[] f18062f;

        /* renamed from: g */
        private final String f18063g;

        /* renamed from: h */
        private final String f18064h;
        private final String i;
        private final String j;
        private final String k;
        private final Uri l;

        private Notification(Bundle bundle) {
            this.f18057a = a.a(bundle, "gcm.n.title");
            this.f18058b = a.b(bundle, "gcm.n.title");
            this.f18059c = a(bundle, "gcm.n.title");
            this.f18060d = a.a(bundle, "gcm.n.body");
            this.f18061e = a.b(bundle, "gcm.n.body");
            this.f18062f = a(bundle, "gcm.n.body");
            this.f18063g = a.a(bundle, "gcm.n.icon");
            this.f18064h = a.d(bundle);
            this.i = a.a(bundle, "gcm.n.tag");
            this.j = a.a(bundle, "gcm.n.color");
            this.k = a.a(bundle, "gcm.n.click_action");
            this.l = a.b(bundle);
        }

        private static String[] a(Bundle bundle, String str) {
            Object[] c2 = a.c(bundle, str);
            if (c2 == null) {
                return null;
            }
            String[] strArr = new String[c2.length];
            for (int i = 0; i < c2.length; i++) {
                strArr[i] = String.valueOf(c2[i]);
            }
            return strArr;
        }

        public String b() {
            return this.f18057a;
        }

        public String a() {
            return this.f18060d;
        }

        /* synthetic */ Notification(Bundle bundle, b bVar) {
            this(bundle);
        }
    }
}
