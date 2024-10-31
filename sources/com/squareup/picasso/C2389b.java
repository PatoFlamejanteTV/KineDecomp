package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetRequestHandler.java */
/* renamed from: com.squareup.picasso.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2389b extends E {

    /* renamed from: a, reason: collision with root package name */
    private static final int f25631a = 22;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f25632b;

    public C2389b(Context context) {
        this.f25632b = context.getAssets();
    }

    static String c(C c2) {
        return c2.f25547e.toString().substring(f25631a);
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        Uri uri = c2.f25547e;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        return new E.a(this.f25632b.open(c(c2)), Picasso.LoadedFrom.DISK);
    }
}
