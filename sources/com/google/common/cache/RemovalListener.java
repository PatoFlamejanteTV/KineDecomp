package com.google.common.cache;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: classes2.dex */
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
