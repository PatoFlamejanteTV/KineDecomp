package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class MemoryDataStoreFactory extends AbstractDataStoreFactory {

    /* loaded from: classes2.dex */
    static class a<V extends Serializable> extends AbstractMemoryDataStore<V> {
        a(MemoryDataStoreFactory memoryDataStoreFactory, String str) {
            super(memoryDataStoreFactory, str);
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> b(String str) throws IOException {
        return new a(this, str);
    }
}
