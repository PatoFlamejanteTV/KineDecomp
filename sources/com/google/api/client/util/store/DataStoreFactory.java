package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes2.dex */
public interface DataStoreFactory {
    <V extends Serializable> DataStore<V> a(String str) throws IOException;
}
