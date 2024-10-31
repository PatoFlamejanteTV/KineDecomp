package c.a.a.a.a.b.a;

import de.greenrobot.event.e;

/* compiled from: ACEventBus.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static a f3427a;

    /* renamed from: b */
    private e f3428b;

    private a(e eVar) {
        this.f3428b = eVar;
    }

    public static a a() {
        if (f3427a == null) {
            synchronized (a.class) {
                if (f3427a == null) {
                    f3427a = new a(e.a());
                }
            }
        }
        return f3427a;
    }

    public void b(Object obj) {
        this.f3428b.b(obj);
    }

    public void c(Object obj) {
        this.f3428b.c(obj);
    }

    public a() {
        this(new e());
    }

    public void a(Object obj) {
        this.f3428b.a(obj);
    }
}
