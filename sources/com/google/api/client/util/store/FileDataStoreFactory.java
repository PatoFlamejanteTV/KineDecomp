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

/* loaded from: classes.dex */
public class FileDataStoreFactory extends AbstractDataStoreFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2562a = Logger.getLogger(FileDataStoreFactory.class.getName());
    private final File b;

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> b(String str) throws IOException {
        return new a(this, this.b, str);
    }

    /* loaded from: classes.dex */
    static class a<V extends Serializable> extends com.google.api.client.util.store.a<V> {
        private final File b;

        a(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            this.b = new File(file, str);
            if (IOUtils.a(this.b)) {
                String valueOf = String.valueOf(String.valueOf(this.b));
                throw new IOException(new StringBuilder(valueOf.length() + 31).append("unable to use a symbolic link: ").append(valueOf).toString());
            }
            if (this.b.createNewFile()) {
                this.f2563a = Maps.a();
                b();
            } else {
                this.f2563a = (HashMap) IOUtils.a((InputStream) new FileInputStream(this.b));
            }
        }

        @Override // com.google.api.client.util.store.a
        void b() throws IOException {
            IOUtils.a(this.f2563a, new FileOutputStream(this.b));
        }
    }
}
