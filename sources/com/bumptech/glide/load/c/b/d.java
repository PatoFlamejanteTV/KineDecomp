package com.bumptech.glide.load.c.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: classes.dex */
public class d implements h<Uri, Drawable> {

    /* renamed from: a */
    private final Context f8684a;

    public d(Context context) {
        this.f8684a = context.getApplicationContext();
    }

    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(Uri uri, g gVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.h
    public E<Drawable> a(Uri uri, int i, int i2, g gVar) {
        Context a2 = a(uri, uri.getAuthority());
        return c.a(a.a(this.f8684a, a2, b(a2, uri)));
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.f8684a.getPackageName())) {
            return this.f8684a;
        }
        try {
            return this.f8684a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f8684a.getPackageName())) {
                return this.f8684a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }
}
