package android.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MergedDataBinderMapper extends c {

    /* renamed from: a */
    private Set<Class<? extends c>> f140a = new HashSet();

    /* renamed from: b */
    private List<c> f141b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private List<String> f142c = new CopyOnWriteArrayList();

    private boolean b() {
        boolean z = false;
        for (String str : this.f142c) {
            try {
                Class<?> cls = Class.forName(str);
                if (c.class.isAssignableFrom(cls)) {
                    a((c) cls.newInstance());
                    this.f142c.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e2) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e2);
            } catch (InstantiationException e3) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e3);
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(c cVar) {
        if (this.f140a.add(cVar.getClass())) {
            this.f141b.add(cVar);
            Iterator<c> it = cVar.a().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    @Override // android.databinding.c
    public ViewDataBinding a(d dVar, View view, int i) {
        Iterator<c> it = this.f141b.iterator();
        while (it.hasNext()) {
            ViewDataBinding a2 = it.next().a(dVar, view, i);
            if (a2 != null) {
                return a2;
            }
        }
        if (b()) {
            return a(dVar, view, i);
        }
        return null;
    }

    @Override // android.databinding.c
    public ViewDataBinding a(d dVar, View[] viewArr, int i) {
        Iterator<c> it = this.f141b.iterator();
        while (it.hasNext()) {
            ViewDataBinding a2 = it.next().a(dVar, viewArr, i);
            if (a2 != null) {
                return a2;
            }
        }
        if (b()) {
            return a(dVar, viewArr, i);
        }
        return null;
    }
}
