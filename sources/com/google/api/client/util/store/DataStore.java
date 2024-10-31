package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

/* loaded from: classes2.dex */
public interface DataStore<V extends Serializable> {
    DataStore<V> a(String str, V v) throws IOException;

    V a(String str) throws IOException;

    Set<String> keySet() throws IOException;
}
