package com.bumptech.glide.load.b;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class g<Model, Data> implements u<Model, Data> {

    /* renamed from: a */
    private final a<Data> f8607a;

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public interface a<Data> {
        Class<Data> a();

        void a(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Model> implements v<Model, InputStream> {

        /* renamed from: a */
        private final a<InputStream> f8611a = new h(this);

        @Override // com.bumptech.glide.load.b.v
        public u<Model, InputStream> a(y yVar) {
            return new g(this.f8611a);
        }
    }

    public g(a<Data> aVar) {
        this.f8607a = aVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(Model model, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(model), new b(model.toString(), this.f8607a));
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    private static final class b<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a */
        private final String f8608a;

        /* renamed from: b */
        private final a<Data> f8609b;

        /* renamed from: c */
        private Data f8610c;

        b(String str, a<Data> aVar) {
            this.f8608a = str;
            this.f8609b = aVar;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            try {
                this.f8610c = this.f8609b.decode(this.f8608a);
                aVar.a((d.a<? super Data>) this.f8610c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            try {
                this.f8609b.a(this.f8610c);
            } catch (IOException unused) {
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
            return this.f8609b.a();
        }
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
