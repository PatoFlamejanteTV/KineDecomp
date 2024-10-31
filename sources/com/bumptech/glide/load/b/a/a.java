package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.google.protos.datapol.SemanticAnnotations;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements u<l, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public static final f<Integer> f8589a = f.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE));

    /* renamed from: b, reason: collision with root package name */
    private final t<l, l> f8590b;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0050a implements v<l, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final t<l, l> f8591a = new t<>(500);

        @Override // com.bumptech.glide.load.b.v
        public u<l, InputStream> a(y yVar) {
            return new a(this.f8591a);
        }
    }

    public a(t<l, l> tVar) {
        this.f8590b = tVar;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(l lVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<InputStream> a(l lVar, int i, int i2, g gVar) {
        t<l, l> tVar = this.f8590b;
        if (tVar != null) {
            l a2 = tVar.a(lVar, 0, 0);
            if (a2 == null) {
                this.f8590b.a(lVar, 0, 0, lVar);
            } else {
                lVar = a2;
            }
        }
        return new u.a<>(lVar, new k(lVar, ((Integer) gVar.a(f8589a)).intValue()));
    }
}
