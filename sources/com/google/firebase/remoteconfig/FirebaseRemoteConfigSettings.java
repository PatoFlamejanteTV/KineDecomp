package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigSettings {

    /* renamed from: a */
    private final boolean f18076a;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        private boolean f18077a = false;

        public Builder a(boolean z) {
            this.f18077a = z;
            return this;
        }

        public FirebaseRemoteConfigSettings a() {
            return new FirebaseRemoteConfigSettings(this);
        }
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.f18076a = builder.f18077a;
    }

    public boolean a() {
        return this.f18076a;
    }

    /* synthetic */ FirebaseRemoteConfigSettings(Builder builder, b bVar) {
        this(builder);
    }
}
