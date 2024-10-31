package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzj();

    /* renamed from: a */
    private final int f10514a;

    /* renamed from: b */
    private final CredentialPickerConfig f10515b;

    /* renamed from: c */
    private final boolean f10516c;

    /* renamed from: d */
    private final boolean f10517d;

    /* renamed from: e */
    private final String[] f10518e;

    /* renamed from: f */
    private final boolean f10519f;

    /* renamed from: g */
    private final String f10520g;

    /* renamed from: h */
    private final String f10521h;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f10522a;

        /* renamed from: b */
        private boolean f10523b;

        /* renamed from: c */
        private String[] f10524c;

        /* renamed from: d */
        private CredentialPickerConfig f10525d = new CredentialPickerConfig.Builder().a();

        /* renamed from: e */
        private boolean f10526e = false;

        /* renamed from: f */
        private String f10527f;

        /* renamed from: g */
        private String f10528g;

        public final Builder a(boolean z) {
            this.f10522a = z;
            return this;
        }

        public final Builder a(CredentialPickerConfig credentialPickerConfig) {
            Preconditions.a(credentialPickerConfig);
            this.f10525d = credentialPickerConfig;
            return this;
        }

        public final HintRequest a() {
            if (this.f10524c == null) {
                this.f10524c = new String[0];
            }
            if (!this.f10522a && !this.f10523b && this.f10524c.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new HintRequest(this);
        }
    }

    @SafeParcelable.Constructor
    public HintRequest(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2) {
        this.f10514a = i;
        Preconditions.a(credentialPickerConfig);
        this.f10515b = credentialPickerConfig;
        this.f10516c = z;
        this.f10517d = z2;
        Preconditions.a(strArr);
        this.f10518e = strArr;
        if (this.f10514a < 2) {
            this.f10519f = true;
            this.f10520g = null;
            this.f10521h = null;
        } else {
            this.f10519f = z3;
            this.f10520g = str;
            this.f10521h = str2;
        }
    }

    public final CredentialPickerConfig O() {
        return this.f10515b;
    }

    public final String P() {
        return this.f10521h;
    }

    public final String Q() {
        return this.f10520g;
    }

    public final boolean R() {
        return this.f10516c;
    }

    public final boolean U() {
        return this.f10519f;
    }

    public final String[] a() {
        return this.f10518e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) O(), i, false);
        SafeParcelWriter.a(parcel, 2, R());
        SafeParcelWriter.a(parcel, 3, this.f10517d);
        SafeParcelWriter.a(parcel, 4, a(), false);
        SafeParcelWriter.a(parcel, 5, U());
        SafeParcelWriter.a(parcel, 6, Q(), false);
        SafeParcelWriter.a(parcel, 7, P(), false);
        SafeParcelWriter.a(parcel, 1000, this.f10514a);
        SafeParcelWriter.a(parcel, a2);
    }

    private HintRequest(Builder builder) {
        this(2, builder.f10525d, builder.f10522a, builder.f10523b, builder.f10524c, builder.f10526e, builder.f10527f, builder.f10528g);
    }

    /* synthetic */ HintRequest(Builder builder, d dVar) {
        this(builder);
    }
}
