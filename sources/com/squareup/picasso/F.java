package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceRequestHandler.java */
/* loaded from: classes3.dex */
public class F extends E {

    /* renamed from: a, reason: collision with root package name */
    private final Context f25575a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(Context context) {
        this.f25575a = context;
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        if (c2.f25548f != 0) {
            return true;
        }
        return "android.resource".equals(c2.f25547e.getScheme());
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        Resources a2 = N.a(this.f25575a, c2);
        return new E.a(a(a2, N.a(a2, c2), c2), Picasso.LoadedFrom.DISK);
    }

    private static Bitmap a(Resources resources, int i, C c2) {
        BitmapFactory.Options b2 = E.b(c2);
        if (E.a(b2)) {
            BitmapFactory.decodeResource(resources, i, b2);
            E.a(c2.i, c2.j, b2, c2);
        }
        return BitmapFactory.decodeResource(resources, i, b2);
    }
}
