package c.a.a.a.c.a;

import android.content.Context;

/* compiled from: AdobeCommonApplicationContextHolder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    static a f3453a;

    /* renamed from: b */
    private Context f3454b = null;

    private a() {
    }

    public static a b() {
        if (f3453a == null) {
            f3453a = new a();
        }
        return f3453a;
    }

    public Context a() {
        return this.f3454b;
    }

    public void a(Context context) {
        this.f3454b = context.getApplicationContext();
    }
}
