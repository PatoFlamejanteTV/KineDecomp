package com.google.android.gms.appindexing;

import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class AndroidAppUri {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f771a;

    private AndroidAppUri(Uri uri) {
        this.f771a = uri;
    }

    public static AndroidAppUri a(String str, Uri uri) {
        Uri.Builder authority = new Uri.Builder().scheme("android-app").authority(str);
        if (uri != null) {
            authority.appendPath(uri.getScheme());
            if (uri.getAuthority() != null) {
                authority.appendPath(uri.getAuthority());
            }
            Iterator<String> it = uri.getPathSegments().iterator();
            while (it.hasNext()) {
                authority.appendPath(it.next());
            }
            authority.encodedQuery(uri.getEncodedQuery()).encodedFragment(uri.getEncodedFragment());
        }
        return new AndroidAppUri(authority.build());
    }

    public boolean equals(Object obj) {
        if (obj instanceof AndroidAppUri) {
            return this.f771a.equals(((AndroidAppUri) obj).f771a);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.f771a);
    }

    public String toString() {
        return this.f771a.toString();
    }
}
