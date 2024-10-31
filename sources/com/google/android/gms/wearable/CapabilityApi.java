package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface CapabilityApi {

    /* loaded from: classes.dex */
    public interface AddLocalCapabilityResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface CapabilityListener {
        void a(CapabilityInfo capabilityInfo);
    }

    /* loaded from: classes.dex */
    public interface GetAllCapabilitiesResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface GetCapabilityResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface RemoveLocalCapabilityResult extends Result {
    }
}
