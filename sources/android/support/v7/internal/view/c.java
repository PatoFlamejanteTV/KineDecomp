package android.support.v7.internal.view;

import android.support.v4.g.ad;
import android.support.v4.g.ae;
import android.support.v4.g.y;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class c {
    private Interpolator c;
    private ad d;
    private boolean e;
    private long b = -1;
    private final ae f = new d(this);

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<y> f124a = new ArrayList<>();

    public c a(y yVar) {
        if (!this.e) {
            this.f124a.add(yVar);
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator<y> it = this.f124a.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (this.b >= 0) {
                    next.a(this.b);
                }
                if (this.c != null) {
                    next.a(this.c);
                }
                if (this.d != null) {
                    next.a(this.f);
                }
                next.b();
            }
            this.e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.e = false;
    }

    public void b() {
        if (this.e) {
            Iterator<y> it = this.f124a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.e = false;
        }
    }
}
