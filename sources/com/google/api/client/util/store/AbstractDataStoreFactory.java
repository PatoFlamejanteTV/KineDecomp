package com.google.api.client.util.store;

import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class AbstractDataStoreFactory implements DataStoreFactory {

    /* renamed from: a */
    private static final Pattern f15013a = Pattern.compile("\\w{1,30}");

    /* renamed from: b */
    private final Lock f15014b = new ReentrantLock();

    /* renamed from: c */
    private final Map<String, DataStore<? extends Serializable>> f15015c = Maps.a();

    @Override // com.google.api.client.util.store.DataStoreFactory
    public final <V extends Serializable> DataStore<V> a(String str) throws IOException {
        Preconditions.a(f15013a.matcher(str).matches(), "%s does not match pattern %s", str, f15013a);
        this.f15014b.lock();
        try {
            DataStore<V> dataStore = (DataStore) this.f15015c.get(str);
            if (dataStore == null) {
                dataStore = b(str);
                this.f15015c.put(str, dataStore);
            }
            return dataStore;
        } finally {
            this.f15014b.unlock();
        }
    }

    protected abstract <V extends Serializable> DataStore<V> b(String str) throws IOException;
}
