package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzjo;

/* loaded from: classes2.dex */
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzb();

    /* renamed from: a */
    private final String f16366a;

    /* renamed from: b */
    private final String f16367b;

    /* renamed from: c */
    private final String f16368c;

    /* renamed from: d */
    private final String f16369d;

    /* renamed from: e */
    private final boolean f16370e;

    /* renamed from: f */
    private final String f16371f;

    /* renamed from: g */
    private final boolean f16372g;

    /* renamed from: h */
    private String f16373h;
    private int i;
    private String j;

    @SafeParcelable.Constructor
    public ActionCodeSettings(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) String str6, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) String str7) {
        this.f16366a = str;
        this.f16367b = str2;
        this.f16368c = str3;
        this.f16369d = str4;
        this.f16370e = z;
        this.f16371f = str5;
        this.f16372g = z2;
        this.f16373h = str6;
        this.i = i;
        this.j = str7;
    }

    public static ActionCodeSettings V() {
        return new ActionCodeSettings(new Builder());
    }

    public boolean O() {
        return this.f16370e;
    }

    public String P() {
        return this.f16371f;
    }

    public String Q() {
        return this.f16369d;
    }

    public String R() {
        return this.f16367b;
    }

    public String U() {
        return this.f16366a;
    }

    public final String W() {
        return this.j;
    }

    public boolean a() {
        return this.f16372g;
    }

    public final void e(String str) {
        this.f16373h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, U(), false);
        SafeParcelWriter.a(parcel, 2, R(), false);
        SafeParcelWriter.a(parcel, 3, this.f16368c, false);
        SafeParcelWriter.a(parcel, 4, Q(), false);
        SafeParcelWriter.a(parcel, 5, O());
        SafeParcelWriter.a(parcel, 6, P(), false);
        SafeParcelWriter.a(parcel, 7, a());
        SafeParcelWriter.a(parcel, 8, this.f16373h, false);
        SafeParcelWriter.a(parcel, 9, this.i);
        SafeParcelWriter.a(parcel, 10, this.j, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String zzbt() {
        return this.f16368c;
    }

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private String f16374a;

        /* renamed from: b */
        private String f16375b;

        /* renamed from: c */
        private String f16376c;

        /* renamed from: d */
        private boolean f16377d;

        /* renamed from: e */
        private String f16378e;

        /* renamed from: f */
        private boolean f16379f;

        /* renamed from: g */
        private String f16380g;

        private Builder() {
            this.f16379f = false;
        }

        /* synthetic */ Builder(a aVar) {
            this();
        }
    }

    public final void a(zzjo zzjoVar) {
        this.i = zzjoVar.zzbi();
    }

    private ActionCodeSettings(Builder builder) {
        this.f16366a = builder.f16374a;
        this.f16367b = builder.f16375b;
        this.f16368c = null;
        this.f16369d = builder.f16376c;
        this.f16370e = builder.f16377d;
        this.f16371f = builder.f16378e;
        this.f16372g = builder.f16379f;
        this.j = builder.f16380g;
    }
}
