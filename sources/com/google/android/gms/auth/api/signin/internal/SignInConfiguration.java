package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();

    /* renamed from: a */
    private final String f10588a;

    /* renamed from: b */
    private GoogleSignInOptions f10589b;

    @SafeParcelable.Constructor
    public SignInConfiguration(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        Preconditions.b(str);
        this.f10588a = str;
        this.f10589b = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f10588a.equals(signInConfiguration.f10588a)) {
            GoogleSignInOptions googleSignInOptions = this.f10589b;
            if (googleSignInOptions == null) {
                if (signInConfiguration.f10589b == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.f10589b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().a(this.f10588a).a(this.f10589b).a();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f10588a, false);
        SafeParcelWriter.a(parcel, 5, (Parcelable) this.f10589b, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final GoogleSignInOptions zzm() {
        return this.f10589b;
    }
}
