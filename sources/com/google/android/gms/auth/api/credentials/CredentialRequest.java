package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzg();

    /* renamed from: a */
    private final int f10497a;

    /* renamed from: b */
    private final boolean f10498b;

    /* renamed from: c */
    private final String[] f10499c;

    /* renamed from: d */
    private final CredentialPickerConfig f10500d;

    /* renamed from: e */
    private final CredentialPickerConfig f10501e;

    /* renamed from: f */
    private final boolean f10502f;

    /* renamed from: g */
    private final String f10503g;

    /* renamed from: h */
    private final String f10504h;
    private final boolean i;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f10505a;

        /* renamed from: b */
        private String[] f10506b;

        /* renamed from: c */
        private CredentialPickerConfig f10507c;

        /* renamed from: d */
        private CredentialPickerConfig f10508d;

        /* renamed from: e */
        private boolean f10509e = false;

        /* renamed from: f */
        private boolean f10510f = false;

        /* renamed from: g */
        private String f10511g = null;

        /* renamed from: h */
        private String f10512h;

        public final Builder a(boolean z) {
            this.f10505a = z;
            return this;
        }

        public final Builder a(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.f10506b = strArr;
            return this;
        }

        public final CredentialRequest a() {
            if (this.f10506b == null) {
                this.f10506b = new String[0];
            }
            if (!this.f10505a && this.f10506b.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new CredentialRequest(this);
        }
    }

    @SafeParcelable.Constructor
    public CredentialRequest(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z3) {
        this.f10497a = i;
        this.f10498b = z;
        Preconditions.a(strArr);
        this.f10499c = strArr;
        this.f10500d = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().a() : credentialPickerConfig;
        this.f10501e = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().a() : credentialPickerConfig2;
        if (i < 3) {
            this.f10502f = true;
            this.f10503g = null;
            this.f10504h = null;
        } else {
            this.f10502f = z2;
            this.f10503g = str;
            this.f10504h = str2;
        }
        this.i = z3;
    }

    public final CredentialPickerConfig O() {
        return this.f10501e;
    }

    public final CredentialPickerConfig P() {
        return this.f10500d;
    }

    public final String Q() {
        return this.f10504h;
    }

    public final String R() {
        return this.f10503g;
    }

    public final boolean U() {
        return this.f10502f;
    }

    public final boolean V() {
        return this.f10498b;
    }

    public final String[] a() {
        return this.f10499c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, V());
        SafeParcelWriter.a(parcel, 2, a(), false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) P(), i, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) O(), i, false);
        SafeParcelWriter.a(parcel, 5, U());
        SafeParcelWriter.a(parcel, 6, R(), false);
        SafeParcelWriter.a(parcel, 7, Q(), false);
        SafeParcelWriter.a(parcel, 1000, this.f10497a);
        SafeParcelWriter.a(parcel, 8, this.i);
        SafeParcelWriter.a(parcel, a2);
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.f10505a, builder.f10506b, builder.f10507c, builder.f10508d, builder.f10509e, builder.f10511g, builder.f10512h, false);
    }

    /* synthetic */ CredentialRequest(Builder builder, b bVar) {
        this(builder);
    }
}
