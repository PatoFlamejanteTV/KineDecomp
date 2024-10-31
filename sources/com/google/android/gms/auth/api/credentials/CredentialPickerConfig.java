package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CredentialPickerConfig implements SafeParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f788a;
    private final boolean b;
    private final boolean c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f789a = false;
        private boolean b = true;

        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CredentialPickerConfig(int i, boolean z, boolean z2) {
        this.f788a = i;
        this.b = z;
        this.c = z2;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.f789a, builder.b);
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
