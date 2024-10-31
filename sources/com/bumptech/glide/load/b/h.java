package com.bumptech.glide.load.b;

import android.util.Base64;
import com.bumptech.glide.load.b.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public class h implements g.a<InputStream> {

    /* renamed from: a */
    final /* synthetic */ g.c f8612a;

    public h(g.c cVar) {
        this.f8612a = cVar;
    }

    @Override // com.bumptech.glide.load.b.g.a
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.b.g.a
    public InputStream decode(String str) {
        if (str.startsWith("data:image")) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                if (str.substring(0, indexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        throw new IllegalArgumentException("Not a valid image data URL.");
    }

    @Override // com.bumptech.glide.load.b.g.a
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
