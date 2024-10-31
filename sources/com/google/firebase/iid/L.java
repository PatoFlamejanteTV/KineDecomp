package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class L implements Continuation<Bundle, String> {

    /* renamed from: a */
    private final /* synthetic */ I f17337a;

    public L(I i) {
        this.f17337a = i;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(Task<Bundle> task) throws Exception {
        String a2;
        Bundle a3 = task.a(IOException.class);
        I i = this.f17337a;
        a2 = I.a(a3);
        return a2;
    }
}
