package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.annotations.PublicApi;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@PublicApi
/* loaded from: classes2.dex */
public final class FirebaseOptions {

    /* renamed from: a */
    private final String f16333a;

    /* renamed from: b */
    private final String f16334b;

    /* renamed from: c */
    private final String f16335c;

    /* renamed from: d */
    private final String f16336d;

    /* renamed from: e */
    private final String f16337e;

    /* renamed from: f */
    private final String f16338f;

    /* renamed from: g */
    private final String f16339g;

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @PublicApi
    /* loaded from: classes2.dex */
    public static final class Builder {
        @PublicApi
        public Builder() {
        }
    }

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.b(!Strings.b(str), "ApplicationId must be set.");
        this.f16334b = str;
        this.f16333a = str2;
        this.f16335c = str3;
        this.f16336d = str4;
        this.f16337e = str5;
        this.f16338f = str6;
        this.f16339g = str7;
    }

    @PublicApi
    public static FirebaseOptions a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String a2 = stringResourceValueReader.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new FirebaseOptions(a2, stringResourceValueReader.a("google_api_key"), stringResourceValueReader.a("firebase_database_url"), stringResourceValueReader.a("ga_trackingId"), stringResourceValueReader.a("gcm_defaultSenderId"), stringResourceValueReader.a("google_storage_bucket"), stringResourceValueReader.a("project_id"));
    }

    @PublicApi
    public String b() {
        return this.f16334b;
    }

    @PublicApi
    public String c() {
        return this.f16335c;
    }

    @PublicApi
    public String d() {
        return this.f16337e;
    }

    @PublicApi
    public String e() {
        return this.f16338f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return Objects.a(this.f16334b, firebaseOptions.f16334b) && Objects.a(this.f16333a, firebaseOptions.f16333a) && Objects.a(this.f16335c, firebaseOptions.f16335c) && Objects.a(this.f16336d, firebaseOptions.f16336d) && Objects.a(this.f16337e, firebaseOptions.f16337e) && Objects.a(this.f16338f, firebaseOptions.f16338f) && Objects.a(this.f16339g, firebaseOptions.f16339g);
    }

    public int hashCode() {
        return Objects.a(this.f16334b, this.f16333a, this.f16335c, this.f16336d, this.f16337e, this.f16338f, this.f16339g);
    }

    public String toString() {
        return Objects.a(this).a("applicationId", this.f16334b).a("apiKey", this.f16333a).a("databaseUrl", this.f16335c).a("gcmSenderId", this.f16337e).a("storageBucket", this.f16338f).a("projectId", this.f16339g).toString();
    }

    @PublicApi
    public String a() {
        return this.f16333a;
    }
}
