package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();

    /* renamed from: a */
    private final int f10489a;

    /* renamed from: b */
    private final boolean f10490b;

    /* renamed from: c */
    private final boolean f10491c;

    /* renamed from: d */
    @Deprecated
    private final boolean f10492d;

    /* renamed from: e */
    private final int f10493e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private boolean f10494a = false;

        /* renamed from: b */
        private boolean f10495b = true;

        /* renamed from: c */
        private int f10496c = 1;

        public Builder a(boolean z) {
            this.f10495b = z;
            return this;
        }

        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(this);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Prompt {
    }

    @SafeParcelable.Constructor
    public CredentialPickerConfig(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i2) {
        this.f10489a = i;
        this.f10490b = z;
        this.f10491c = z2;
        if (i < 2) {
            this.f10492d = z3;
            this.f10493e = z3 ? 3 : 1;
        } else {
            this.f10492d = i2 == 3;
            this.f10493e = i2;
        }
    }

    public final boolean O() {
        return this.f10490b;
    }

    public final boolean P() {
        return this.f10491c;
    }

    @Deprecated
    public final boolean a() {
        return this.f10493e == 3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, O());
        SafeParcelWriter.a(parcel, 2, P());
        SafeParcelWriter.a(parcel, 3, a());
        SafeParcelWriter.a(parcel, 4, this.f10493e);
        SafeParcelWriter.a(parcel, 1000, this.f10489a);
        SafeParcelWriter.a(parcel, a2);
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.f10494a, builder.f10495b, false, builder.f10496c);
    }

    /* synthetic */ CredentialPickerConfig(Builder builder, a aVar) {
        this(builder);
    }
}
