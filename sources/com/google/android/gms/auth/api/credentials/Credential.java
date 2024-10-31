package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

/* loaded from: classes.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zzc();

    /* renamed from: a */
    @Nonnull
    private final String f10473a;

    /* renamed from: b */
    private final String f10474b;

    /* renamed from: c */
    private final Uri f10475c;

    /* renamed from: d */
    @Nonnull
    private final List<IdToken> f10476d;

    /* renamed from: e */
    private final String f10477e;

    /* renamed from: f */
    private final String f10478f;

    /* renamed from: g */
    private final String f10479g;

    /* renamed from: h */
    private final String f10480h;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private final String f10481a;

        /* renamed from: b */
        private String f10482b;

        /* renamed from: c */
        private Uri f10483c;

        /* renamed from: d */
        private List<IdToken> f10484d;

        /* renamed from: e */
        private String f10485e;

        /* renamed from: f */
        private String f10486f;

        /* renamed from: g */
        private String f10487g;

        /* renamed from: h */
        private String f10488h;

        public Builder(String str) {
            this.f10481a = str;
        }

        public Builder a(Uri uri) {
            this.f10483c = uri;
            return this;
        }

        public Builder b(String str) {
            this.f10482b = str;
            return this;
        }

        public Builder c(String str) {
            this.f10485e = str;
            return this;
        }

        public Builder a(String str) {
            this.f10486f = str;
            return this;
        }

        public Credential a() {
            return new Credential(this.f10481a, this.f10482b, this.f10483c, this.f10484d, this.f10485e, this.f10486f, this.f10487g, this.f10488h);
        }
    }

    @SafeParcelable.Constructor
    public Credential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) List<IdToken> list, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 9) String str5, @SafeParcelable.Param(id = 10) String str6) {
        List<IdToken> unmodifiableList;
        Preconditions.a(str, (Object) "credential identifier cannot be null");
        String trim = str.trim();
        Preconditions.a(trim, (Object) "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str4);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                    z = true;
                }
            }
            if (!Boolean.valueOf(z).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.f10474b = str2;
        this.f10475c = uri;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.f10476d = unmodifiableList;
        this.f10473a = trim;
        this.f10477e = str3;
        this.f10478f = str4;
        this.f10479g = str5;
        this.f10480h = str6;
    }

    public String O() {
        return this.f10480h;
    }

    public String P() {
        return this.f10479g;
    }

    @Nonnull
    public List<IdToken> Q() {
        return this.f10476d;
    }

    public String R() {
        return this.f10474b;
    }

    public Uri U() {
        return this.f10475c;
    }

    public String a() {
        return this.f10478f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f10473a, credential.f10473a) && TextUtils.equals(this.f10474b, credential.f10474b) && Objects.a(this.f10475c, credential.f10475c) && TextUtils.equals(this.f10477e, credential.f10477e) && TextUtils.equals(this.f10478f, credential.f10478f);
    }

    @Nonnull
    public String getId() {
        return this.f10473a;
    }

    public String getPassword() {
        return this.f10477e;
    }

    public int hashCode() {
        return Objects.a(this.f10473a, this.f10474b, this.f10475c, this.f10477e, this.f10478f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, getId(), false);
        SafeParcelWriter.a(parcel, 2, R(), false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) U(), i, false);
        SafeParcelWriter.d(parcel, 4, Q(), false);
        SafeParcelWriter.a(parcel, 5, getPassword(), false);
        SafeParcelWriter.a(parcel, 6, a(), false);
        SafeParcelWriter.a(parcel, 9, P(), false);
        SafeParcelWriter.a(parcel, 10, O(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
