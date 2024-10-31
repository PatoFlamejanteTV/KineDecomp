package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PendingPost.java */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a */
    private static final List<i> f26703a = new ArrayList();

    /* renamed from: b */
    Object f26704b;

    /* renamed from: c */
    n f26705c;

    /* renamed from: d */
    i f26706d;

    private i(Object obj, n nVar) {
        this.f26704b = obj;
        this.f26705c = nVar;
    }

    public static i a(n nVar, Object obj) {
        synchronized (f26703a) {
            int size = f26703a.size();
            if (size > 0) {
                i remove = f26703a.remove(size - 1);
                remove.f26704b = obj;
                remove.f26705c = nVar;
                remove.f26706d = null;
                return remove;
            }
            return new i(obj, nVar);
        }
    }

    public static void a(i iVar) {
        iVar.f26704b = null;
        iVar.f26705c = null;
        iVar.f26706d = null;
        synchronized (f26703a) {
            if (f26703a.size() < 10000) {
                f26703a.add(iVar);
            }
        }
    }
}
