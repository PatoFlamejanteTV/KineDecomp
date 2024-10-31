package io.reactivex.internal.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes3.dex */
public final class b implements io.reactivex.disposables.b, a {

    /* renamed from: a */
    List<io.reactivex.disposables.b> f28142a;

    /* renamed from: b */
    volatile boolean f28143b;

    @Override // io.reactivex.internal.disposables.a
    public boolean a(io.reactivex.disposables.b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(io.reactivex.disposables.b bVar) {
        io.reactivex.d.a.b.a(bVar, "d is null");
        if (!this.f28143b) {
            synchronized (this) {
                if (!this.f28143b) {
                    List list = this.f28142a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f28142a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(io.reactivex.disposables.b bVar) {
        io.reactivex.d.a.b.a(bVar, "Disposable item is null");
        if (this.f28143b) {
            return false;
        }
        synchronized (this) {
            if (this.f28143b) {
                return false;
            }
            List<io.reactivex.disposables.b> list = this.f28142a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f28143b) {
            return;
        }
        synchronized (this) {
            if (this.f28143b) {
                return;
            }
            this.f28143b = true;
            List<io.reactivex.disposables.b> list = this.f28142a;
            this.f28142a = null;
            a(list);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f28143b;
    }

    void a(List<io.reactivex.disposables.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<io.reactivex.disposables.b> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.b((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
