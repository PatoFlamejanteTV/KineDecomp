package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class FileDataStoreFactory extends AbstractDataStoreFactory {

    /* renamed from: d, reason: collision with root package name */
    private static final Logger f15018d = Logger.getLogger(FileDataStoreFactory.class.getName());

    /* renamed from: e, reason: collision with root package name */
    private final File f15019e;

    /* loaded from: classes2.dex */
    static class a<V extends Serializable> extends AbstractMemoryDataStore<V> {

        /* renamed from: e, reason: collision with root package name */
        private final File f15020e;

        a(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            this.f15020e = new File(file, str);
            if (!IOUtils.a(this.f15020e)) {
                if (this.f15020e.createNewFile()) {
                    this.f15017d = Maps.a();
                    a();
                    return;
                } else {
                    this.f15017d = (HashMap) IOUtils.a((InputStream) new FileInputStream(this.f15020e));
                    return;
                }
            }
            throw new IOException("unable to use a symbolic link: " + this.f15020e);
        }

        @Override // com.google.api.client.util.store.AbstractMemoryDataStore
        public void a() throws IOException {
            IOUtils.a(this.f15017d, new FileOutputStream(this.f15020e));
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> b(String str) throws IOException {
        return new a(this, this.f15019e, str);
    }
}
