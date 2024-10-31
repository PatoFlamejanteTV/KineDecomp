package de.greenrobot.event;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod.java */
/* loaded from: classes3.dex */
final class l {

    /* renamed from: a */
    final Method f26713a;

    /* renamed from: b */
    final ThreadMode f26714b;

    /* renamed from: c */
    final Class<?> f26715c;

    /* renamed from: d */
    String f26716d;

    public l(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f26713a = method;
        this.f26714b = threadMode;
        this.f26715c = cls;
    }

    private synchronized void a() {
        if (this.f26716d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f26713a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f26713a.getName());
            sb.append('(');
            sb.append(this.f26715c.getName());
            this.f26716d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f26716d.equals(lVar.f26716d);
    }

    public int hashCode() {
        return this.f26713a.hashCode();
    }
}
