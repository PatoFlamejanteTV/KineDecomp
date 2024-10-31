package com.google.api.client.util.store;

import com.google.api.client.util.Preconditions;
import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class AbstractDataStore<V extends Serializable> implements DataStore<V> {

    /* renamed from: a */
    private final DataStoreFactory f15011a;

    /* renamed from: b */
    private final String f15012b;

    public AbstractDataStore(DataStoreFactory dataStoreFactory, String str) {
        Preconditions.a(dataStoreFactory);
        this.f15011a = dataStoreFactory;
        Preconditions.a(str);
        this.f15012b = str;
    }
}
