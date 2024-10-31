package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: AppLink.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private Uri f3372a;

    /* renamed from: b */
    private List<a> f3373b;

    /* renamed from: c */
    private Uri f3374c;

    /* compiled from: AppLink.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final Uri f3375a;

        /* renamed from: b */
        private final String f3376b;

        /* renamed from: c */
        private final String f3377c;

        /* renamed from: d */
        private final String f3378d;

        public a(String str, String str2, Uri uri, String str3) {
            this.f3376b = str;
            this.f3377c = str2;
            this.f3375a = uri;
            this.f3378d = str3;
        }
    }

    public c(Uri uri, List<a> list, Uri uri2) {
        this.f3372a = uri;
        this.f3373b = list == null ? Collections.emptyList() : list;
        this.f3374c = uri2;
    }
}
