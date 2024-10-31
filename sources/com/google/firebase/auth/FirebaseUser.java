package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public abstract Uri O();

    public abstract List<? extends UserInfo> P();

    public abstract List<String> Q();

    public abstract String R();

    public abstract boolean U();

    public abstract FirebaseApp V();

    public abstract FirebaseUser W();

    public abstract zzcz X();

    public abstract String Y();

    public Task<AuthResult> a(AuthCredential authCredential) {
        Preconditions.a(authCredential);
        return FirebaseAuth.getInstance(V()).b(this, authCredential);
    }

    public abstract FirebaseUser a(List<? extends UserInfo> list);

    public abstract void a(zzcz zzczVar);

    public Task<AuthResult> b(AuthCredential authCredential) {
        Preconditions.a(authCredential);
        return FirebaseAuth.getInstance(V()).a(this, authCredential);
    }

    public abstract String getDisplayName();

    public abstract String getEmail();

    public abstract String zzcf();

    public abstract String zzci();

    public Task<Void> a(UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.a(userProfileChangeRequest);
        return FirebaseAuth.getInstance(V()).a(this, userProfileChangeRequest);
    }

    public Task<Void> a() {
        return FirebaseAuth.getInstance(V()).a(this);
    }
}
