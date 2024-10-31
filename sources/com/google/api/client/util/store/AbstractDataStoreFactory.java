package com.google.api.client.util.store;

import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class AbstractDataStoreFactory implements DataStoreFactory {
    private static final Pattern c = Pattern.compile("\\w{1,30}");

    /* renamed from: a, reason: collision with root package name */
    private final Lock f2561a = new ReentrantLock();
    private final Map<String, DataStore<? extends Serializable>> b = Maps.a();

    protected abstract <V extends Serializable> DataStore<V> b(String str) throws IOException;

    @Override // com.google.api.client.util.store.DataStoreFactory
    public final <V extends Serializable> DataStore<V> a(String str) throws IOException {
        Preconditions.a(c.matcher(str).matches(), "%s does not match pattern %s", str, c);
        this.f2561a.lock();
        try {
            DataStore<V> dataStore = (DataStore) this.b.get(str);
            if (dataStore == null) {
                dataStore = b(str);
                this.b.put(str, dataStore);
            }
            return dataStore;
        } finally {
            this.f2561a.unlock();
        }
    }
}
