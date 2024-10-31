package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class AbstractMemoryDataStore<V extends Serializable> extends AbstractDataStore<V> {

    /* renamed from: c */
    private final Lock f15016c;

    /* renamed from: d */
    protected HashMap<String, byte[]> f15017d;

    public AbstractMemoryDataStore(DataStoreFactory dataStoreFactory, String str) {
        super(dataStoreFactory, str);
        this.f15016c = new ReentrantLock();
        this.f15017d = Maps.a();
    }

    @Override // com.google.api.client.util.store.DataStore
    public final V a(String str) throws IOException {
        if (str == null) {
            return null;
        }
        this.f15016c.lock();
        try {
            return (V) IOUtils.a(this.f15017d.get(str));
        } finally {
            this.f15016c.unlock();
        }
    }

    public void a() throws IOException {
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Set<String> keySet() throws IOException {
        this.f15016c.lock();
        try {
            return Collections.unmodifiableSet(this.f15017d.keySet());
        } finally {
            this.f15016c.unlock();
        }
    }

    public String toString() {
        return DataStoreUtils.a(this);
    }

    @Override // com.google.api.client.util.store.DataStore
    public final DataStore<V> a(String str, V v) throws IOException {
        Preconditions.a(str);
        Preconditions.a(v);
        this.f15016c.lock();
        try {
            this.f15017d.put(str, IOUtils.a(v));
            a();
            return this;
        } finally {
            this.f15016c.unlock();
        }
    }
}
