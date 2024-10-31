package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzz();

    /* renamed from: a */
    private String f16414a;

    /* renamed from: b */
    private String f16415b;

    /* renamed from: c */
    private boolean f16416c;

    /* renamed from: d */
    private boolean f16417d;

    /* renamed from: e */
    private Uri f16418e;

    @SafeParcelable.Constructor
    public UserProfileChangeRequest(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.f16414a = str;
        this.f16415b = str2;
        this.f16416c = z;
        this.f16417d = z2;
        this.f16418e = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String getDisplayName() {
        return this.f16414a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.a(parcel, 3, this.f16415b, false);
        SafeParcelWriter.a(parcel, 4, this.f16416c);
        SafeParcelWriter.a(parcel, 5, this.f16417d);
        SafeParcelWriter.a(parcel, a2);
    }

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private String f16419a;

        /* renamed from: b */
        private Uri f16420b;

        /* renamed from: c */
        private boolean f16421c;

        /* renamed from: d */
        private boolean f16422d;

        public Builder a(String str) {
            if (str == null) {
                this.f16421c = true;
            } else {
                this.f16419a = str;
            }
            return this;
        }

        public Builder a(Uri uri) {
            if (uri == null) {
                this.f16422d = true;
            } else {
                this.f16420b = uri;
            }
            return this;
        }

        public UserProfileChangeRequest a() {
            String str = this.f16419a;
            Uri uri = this.f16420b;
            return new UserProfileChangeRequest(str, uri == null ? null : uri.toString(), this.f16421c, this.f16422d);
        }
    }
}
