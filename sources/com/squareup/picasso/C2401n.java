package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentStreamRequestHandler.java */
/* renamed from: com.squareup.picasso.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2401n extends E {

    /* renamed from: a, reason: collision with root package name */
    final Context f25649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2401n(Context context) {
        this.f25649a = context;
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        return "content".equals(c2.f25547e.getScheme());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream c(C c2) throws FileNotFoundException {
        return this.f25649a.getContentResolver().openInputStream(c2.f25547e);
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        return new E.a(c(c2), Picasso.LoadedFrom.DISK);
    }
}
