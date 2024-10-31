package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.content.Context;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Sa;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Ub;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: EditSectionalListView.java */
/* loaded from: classes.dex */
public class D extends Ub {
    private HashMap<String, C0330a> q;
    private WeakReference<G> r;
    private boolean s;

    public D(Context context) {
        super(context);
        this.q = new HashMap<>();
        this.s = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(C0330a c0330a) {
        this.q.put(c0330a.f5272a, c0330a);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return this.s;
    }

    private void x() {
        G g2;
        WeakReference<G> weakReference = this.r;
        if (weakReference == null || (g2 = weakReference.get()) == null) {
            return;
        }
        if (this.q.size() == 0) {
            g2.o();
        } else if (this.q.size() == 1) {
            g2.w();
        } else {
            g2.d(this.q.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(int i) {
    }

    public void s() {
        this.q.clear();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.s = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<C0533a> v() {
        ArrayList<C0533a> arrayList = new ArrayList<>();
        Iterator<C0330a> it = this.q.values().iterator();
        while (it.hasNext()) {
            arrayList.add((C0533a) it.next().f5278g);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(C0533a c0533a) {
        HashMap<String, C0330a> hashMap = this.q;
        return hashMap != null && hashMap.containsKey(c0533a.getGUID());
    }

    /* compiled from: EditSectionalListView.java */
    /* loaded from: classes.dex */
    protected class a extends Ub.b implements H {
        public a(Context context) {
            super(context);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.H
        public void a(int i) {
            C0330a c2 = c(i);
            if (!D.this.c((C0533a) c2.f5278g)) {
                D.this.e(c2);
            } else {
                D.this.a(c2.f5272a);
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Ub.b, com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa b(ViewGroup viewGroup) {
            L l = new L();
            l.a(D.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_list_assetviewcell, viewGroup);
            l.a(this);
            return l;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Ub.b, com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa c(ViewGroup viewGroup) {
            N n = new N();
            n.a(D.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_list_folderviewcell, viewGroup);
            n.a(this);
            return n;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.H
        public boolean e() {
            return D.this.w();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void b(Sa sa, C0330a c0330a, int i) {
            super.b(sa, c0330a, i);
            if (sa instanceof L) {
                ((L) sa).e(D.this.c((C0533a) c0330a.f5278g));
            }
            if (sa instanceof N) {
                ((N) sa).f(D.this.c((C0533a) c0330a.f5278g));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public boolean a(Sa sa, C0330a c0330a) {
            boolean a2 = super.a(sa, c0330a);
            if (a2) {
                if (sa instanceof L) {
                    ((L) sa).e(D.this.c((C0533a) c0330a.f5278g));
                } else if (sa instanceof N) {
                    ((N) sa).f(D.this.c((C0533a) c0330a.f5278g));
                }
            }
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void a(Sa sa, C0330a c0330a, int i) {
            super.a(sa, c0330a, i);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void e(Context context) {
        super.e(context);
        this.f5614g.setEnabled(false);
    }

    public void a(G g2) {
        this.r = new WeakReference<>(g2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.q.containsKey(str)) {
            this.q.remove(str);
            x();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Ub, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected Db.a a(Context context) {
        return new a(context);
    }
}
