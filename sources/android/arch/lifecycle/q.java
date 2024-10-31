package android.arch.lifecycle;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a */
    private final a f55a;

    /* renamed from: b */
    private final r f56b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface a {
        <T extends p> T create(Class<T> cls);
    }

    public q(r rVar, a aVar) {
        this.f55a = aVar;
        this.f56b = rVar;
    }

    public <T extends p> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends p> T a(String str, Class<T> cls) {
        T t = (T) this.f56b.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f55a.create(cls);
        this.f56b.a(str, t2);
        return t2;
    }
}
