package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import java.util.List;

/* loaded from: classes.dex */
public interface NodeApi {

    /* loaded from: classes.dex */
    public interface GetConnectedNodesResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface GetLocalNodeResult extends Result {
    }

    /* loaded from: classes.dex */
    public interface NodeListener {
        void a(Node node);

        void b(Node node);
    }

    /* loaded from: classes.dex */
    public interface zza {
        void a(List<Node> list);
    }
}
