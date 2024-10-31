package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes.dex */
public class MemoryDataStoreFactory extends AbstractDataStoreFactory {
    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> b(String str) throws IOException {
        return new a(this, str);
    }

    /* loaded from: classes.dex */
    static class a<V extends Serializable> extends com.google.api.client.util.store.a<V> {
        a(MemoryDataStoreFactory memoryDataStoreFactory, String str) {
            super(memoryDataStoreFactory, str);
        }
    }
}
