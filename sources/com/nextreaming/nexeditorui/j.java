package com.nextreaming.nexeditorui;

import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.InstanceIdResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class J<TResult> implements OnSuccessListener<InstanceIdResult> {

    /* renamed from: a */
    public static final J f24047a = new J();

    J() {
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a */
    public final void onSuccess(InstanceIdResult instanceIdResult) {
        kotlin.jvm.internal.h.a((Object) instanceIdResult, "it");
        String a2 = instanceIdResult.a();
        kotlin.jvm.internal.h.a((Object) a2, "it.token");
        Log.d("FCMToken", a2);
    }
}
