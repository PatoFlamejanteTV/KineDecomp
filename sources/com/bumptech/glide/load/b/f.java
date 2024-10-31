package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class f implements u<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements v<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.b.v
        public u<File, ByteBuffer> a(y yVar) {
            return new f();
        }
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<ByteBuffer> a(File file, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(file), new a(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements com.bumptech.glide.load.a.d<ByteBuffer> {

        /* renamed from: a, reason: collision with root package name */
        private final File f8606a;

        a(File file) {
            this.f8606a = file;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a((d.a<? super ByteBuffer>) com.bumptech.glide.g.a.a(this.f8606a));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.a.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
