package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class CredentialRequest implements SafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f790a;
    private final boolean b;
    private final String[] c;
    private final CredentialPickerConfig d;
    private final CredentialPickerConfig e;

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.f790a = i;
        this.b = z;
        this.c = (String[]) zzx.a(strArr);
        this.d = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().a() : credentialPickerConfig;
        this.e = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().a() : credentialPickerConfig2;
    }

    public boolean a() {
        return this.b;
    }

    public String[] b() {
        return this.c;
    }

    public CredentialPickerConfig c() {
        return this.d;
    }

    public CredentialPickerConfig d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
