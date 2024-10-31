package com.google.api.client.util.store;

import com.google.api.client.util.Preconditions;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class AbstractDataStore<V extends Serializable> implements DataStore<V> {

    /* renamed from: a, reason: collision with root package name */
    private final DataStoreFactory f2560a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDataStore(DataStoreFactory dataStoreFactory, String str) {
        this.f2560a = (DataStoreFactory) Preconditions.a(dataStoreFactory);
        this.b = (String) Preconditions.a(str);
    }
}
