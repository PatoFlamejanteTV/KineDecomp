package com.bumptech.glide.load.b;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class i<Data> implements u<File, Data> {

    /* renamed from: a */
    private final d<Data> f8613a;

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> implements v<File, Data> {

        /* renamed from: a */
        private final d<Data> f8614a;

        public a(d<Data> dVar) {
            this.f8614a = dVar;
        }

        @Override // com.bumptech.glide.load.b.v
        public final u<File, Data> a(y yVar) {
            return new i(this.f8614a);
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new j());
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void a(Data data) throws IOException;
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {
        public e() {
            super(new k());
        }
    }

    public i(d<Data> dVar) {
        this.f8613a = dVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(File file, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(file), new c(file, this.f8613a));
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a */
        private final File f8615a;

        /* renamed from: b */
        private final d<Data> f8616b;

        /* renamed from: c */
        private Data f8617c;

        c(File file, d<Data> dVar) {
            this.f8615a = file;
            this.f8616b = dVar;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            try {
                this.f8617c = this.f8616b.a(this.f8615a);
                aVar.a((d.a<? super Data>) this.f8617c);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            Data data = this.f8617c;
            if (data != null) {
                try {
                    this.f8616b.a((d<Data>) data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.a.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return this.f8616b.a();
        }
    }
}
