package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public interface DataApi {

    /* loaded from: classes.dex */
    public interface DataItemResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface DataListener {
        void a(DataEventBuffer dataEventBuffer);
    }

    /* loaded from: classes.dex */
    public interface DeleteDataItemsResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface GetFdForAssetResult extends Releasable, Result {
    }
}
