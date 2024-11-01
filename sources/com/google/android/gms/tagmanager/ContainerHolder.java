package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface ContainerHolder extends Releasable, Result {

    /* loaded from: classes.dex */
    public interface ContainerAvailableListener {
        void a(ContainerHolder containerHolder, String str);
    }
}
