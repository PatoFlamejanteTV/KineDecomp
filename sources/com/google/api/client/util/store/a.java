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

/* compiled from: AbstractMemoryDataStore.java */
/* loaded from: classes.dex */
class a<V extends Serializable> extends AbstractDataStore<V> {

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, byte[]> f2563a;
    private final Lock b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(DataStoreFactory dataStoreFactory, String str) {
        super(dataStoreFactory, str);
        this.b = new ReentrantLock();
        this.f2563a = Maps.a();
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Set<String> a() throws IOException {
        this.b.lock();
        try {
            return Collections.unmodifiableSet(this.f2563a.keySet());
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final V a(String str) throws IOException {
        if (str == null) {
            return null;
        }
        this.b.lock();
        try {
            return (V) IOUtils.a(this.f2563a.get(str));
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final DataStore<V> a(String str, V v) throws IOException {
        Preconditions.a(str);
        Preconditions.a(v);
        this.b.lock();
        try {
            this.f2563a.put(str, IOUtils.a(v));
            b();
            return this;
        } finally {
            this.b.unlock();
        }
    }

    void b() throws IOException {
    }

    public String toString() {
        return DataStoreUtils.a(this);
    }
}
