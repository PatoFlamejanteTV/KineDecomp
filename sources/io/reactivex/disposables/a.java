package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.e;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes3.dex */
public final class a implements b, io.reactivex.internal.disposables.a {

    /* renamed from: a */
    e<b> f28114a;

    /* renamed from: b */
    volatile boolean f28115b;

    @Override // io.reactivex.internal.disposables.a
    public boolean a(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(b bVar) {
        io.reactivex.d.a.b.a(bVar, "disposable is null");
        if (!this.f28115b) {
            synchronized (this) {
                if (!this.f28115b) {
                    e<b> eVar = this.f28114a;
                    if (eVar == null) {
                        eVar = new e<>();
                        this.f28114a = eVar;
                    }
                    eVar.a((e<b>) bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(b bVar) {
        io.reactivex.d.a.b.a(bVar, "disposables is null");
        if (this.f28115b) {
            return false;
        }
        synchronized (this) {
            if (this.f28115b) {
                return false;
            }
            e<b> eVar = this.f28114a;
            if (eVar != null && eVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f28115b) {
            return;
        }
        synchronized (this) {
            if (this.f28115b) {
                return;
            }
            this.f28115b = true;
            e<b> eVar = this.f28114a;
            this.f28114a = null;
            a(eVar);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f28115b;
    }

    public void a() {
        if (this.f28115b) {
            return;
        }
        synchronized (this) {
            if (this.f28115b) {
                return;
            }
            e<b> eVar = this.f28114a;
            this.f28114a = null;
            a(eVar);
        }
    }

    void a(e<b> eVar) {
        if (eVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : eVar.a()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
