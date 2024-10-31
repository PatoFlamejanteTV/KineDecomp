package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.content.Context;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Kb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Sa;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: EditGridView.java */
/* loaded from: classes.dex */
public class C extends Kb {
    private HashMap<String, C0330a> s;
    private WeakReference<G> t;
    private boolean u;

    public C(Context context) {
        super(context);
        this.s = new HashMap<>();
        this.u = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(C0330a c0330a) {
        this.s.put(c0330a.f5272a, c0330a);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return this.u;
    }

    private void x() {
        G g2;
        WeakReference<G> weakReference = this.t;
        if (weakReference == null || weakReference.get() == null || (g2 = this.t.get()) == null) {
            return;
        }
        if (this.s.size() == 0) {
            g2.o();
        } else if (this.s.size() == 1) {
            g2.w();
        } else {
            g2.d(this.s.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Kb, com.adobe.creativesdk.foundation.internal.storage.controllers.Rb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(int i) {
    }

    public void s() {
        this.s.clear();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        this.u = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.u = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<C0533a> v() {
        ArrayList<C0533a> arrayList = new ArrayList<>();
        Iterator<C0330a> it = this.s.values().iterator();
        while (it.hasNext()) {
            arrayList.add((C0533a) it.next().f5278g);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(C0533a c0533a) {
        HashMap<String, C0330a> hashMap = this.s;
        return hashMap != null && hashMap.containsKey(c0533a.getGUID());
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Kb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void e(Context context) {
        super.e(context);
        this.f5614g.setEnabled(false);
    }

    public void a(G g2) {
        this.t = new WeakReference<>(g2);
    }

    /* compiled from: EditGridView.java */
    /* loaded from: classes.dex */
    protected class a extends Kb.a implements H {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public boolean a(Sa sa, C0330a c0330a) {
            boolean a2 = super.a(sa, c0330a);
            if (a2) {
                if (sa instanceof Q) {
                    Q q = (Q) sa;
                    q.e(C.this.c((C0533a) c0330a.f5278g));
                    q.A();
                } else if (sa instanceof T) {
                    ((T) sa).f(C.this.c((C0533a) c0330a.f5278g));
                }
            }
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void b(Sa sa, C0330a c0330a, int i) {
            super.b(sa, c0330a, i);
            if (sa instanceof Q) {
                Q q = (Q) sa;
                q.e(C.this.c((C0533a) c0330a.f5278g));
                q.A();
            }
            if (sa instanceof T) {
                ((T) sa).f(C.this.c((C0533a) c0330a.f5278g));
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Kb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa c(ViewGroup viewGroup) {
            T t = new T();
            t.a(this);
            t.a(C.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_assetsgrid_folderviewcell, viewGroup);
            return t;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.H
        public boolean e() {
            return C.this.w();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.H
        public void a(int i) {
            C0330a c2 = c(i);
            if (!C.this.c((C0533a) c2.f5278g)) {
                C.this.e(c2);
            } else {
                C.this.a(c2.f5272a);
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Kb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa b(ViewGroup viewGroup) {
            Q q = new Q();
            q.a(C.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_generic_staggered_assetviewcell, viewGroup);
            q.a(this);
            return q;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void a(Sa sa, C0330a c0330a, int i) {
            super.a(sa, c0330a, i);
            if (sa instanceof Q) {
                ((Q) sa).A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.s.containsKey(str)) {
            this.s.remove(str);
            x();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Kb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected Db.a a(Context context) {
        return new a(context);
    }
}
