package h.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalligraphyLayoutInflater.java */
/* loaded from: classes3.dex */
public class f extends LayoutInflater implements h.a.a.a.a {

    /* renamed from: a */
    private static final String[] f26796a = {"android.widget.", "android.webkit."};

    /* renamed from: b */
    private final int f26797b;

    /* renamed from: c */
    private final e f26798c;

    /* renamed from: d */
    private boolean f26799d;

    /* renamed from: e */
    private Field f26800e;

    /* compiled from: CalligraphyLayoutInflater.java */
    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends b {

        /* renamed from: c */
        private final f f26801c;

        public a(LayoutInflater.Factory2 factory2, f fVar, e eVar) {
            super(factory2, eVar);
            this.f26801c = fVar;
        }

        @Override // h.a.a.a.f.b, android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            e eVar = this.f26803b;
            View a2 = this.f26801c.a(view, this.f26802a.onCreateView(view, str, context, attributeSet), str, context, attributeSet);
            eVar.a(a2, context, attributeSet);
            return a2;
        }
    }

    /* compiled from: CalligraphyLayoutInflater.java */
    /* loaded from: classes3.dex */
    public static class c implements LayoutInflater.Factory {

        /* renamed from: a */
        private final LayoutInflater.Factory f26804a;

        /* renamed from: b */
        private final f f26805b;

        /* renamed from: c */
        private final e f26806c;

        public c(LayoutInflater.Factory factory, f fVar, e eVar) {
            this.f26804a = factory;
            this.f26805b = fVar;
            this.f26806c = eVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            if (Build.VERSION.SDK_INT < 11) {
                e eVar = this.f26806c;
                View a2 = this.f26805b.a(null, this.f26804a.onCreateView(str, context, attributeSet), str, context, attributeSet);
                eVar.a(a2, context, attributeSet);
                return a2;
            }
            e eVar2 = this.f26806c;
            View onCreateView = this.f26804a.onCreateView(str, context, attributeSet);
            eVar2.a(onCreateView, context, attributeSet);
            return onCreateView;
        }
    }

    public f(LayoutInflater layoutInflater, Context context, int i, boolean z) {
        super(layoutInflater, context);
        this.f26799d = false;
        this.f26800e = null;
        this.f26797b = i;
        this.f26798c = new e(i);
        a(z);
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new f(this, context, this.f26797b, true);
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        a();
        return super.inflate(xmlPullParser, viewGroup, z);
    }

    @Override // android.view.LayoutInflater
    @TargetApi(11)
    protected View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        e eVar = this.f26798c;
        View onCreateView = super.onCreateView(view, str, attributeSet);
        eVar.a(onCreateView, getContext(), attributeSet);
        return onCreateView;
    }

    @Override // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory factory) {
        if (!(factory instanceof c)) {
            super.setFactory(new c(factory, this, this.f26798c));
        } else {
            super.setFactory(factory);
        }
    }

    @Override // android.view.LayoutInflater
    @TargetApi(11)
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        if (!(factory2 instanceof b)) {
            super.setFactory2(new b(factory2, this.f26798c));
        } else {
            super.setFactory2(factory2);
        }
    }

    private void a(boolean z) {
        if (z) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11 && getFactory2() != null && !(getFactory2() instanceof b)) {
            setFactory2(getFactory2());
        }
        if (getFactory() == null || (getFactory() instanceof c)) {
            return;
        }
        setFactory(getFactory());
    }

    /* compiled from: CalligraphyLayoutInflater.java */
    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class b implements LayoutInflater.Factory2 {

        /* renamed from: a */
        protected final LayoutInflater.Factory2 f26802a;

        /* renamed from: b */
        protected final e f26803b;

        public b(LayoutInflater.Factory2 factory2, e eVar) {
            this.f26802a = factory2;
            this.f26803b = eVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            e eVar = this.f26803b;
            View onCreateView = this.f26802a.onCreateView(str, context, attributeSet);
            eVar.a(onCreateView, context, attributeSet);
            return onCreateView;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            e eVar = this.f26803b;
            View onCreateView = this.f26802a.onCreateView(view, str, context, attributeSet);
            eVar.a(onCreateView, context, attributeSet);
            return onCreateView;
        }
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        View view = null;
        for (String str2 : f26796a) {
            try {
                view = createView(str, str2, attributeSet);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (view == null) {
            view = super.onCreateView(str, attributeSet);
        }
        this.f26798c.a(view, view.getContext(), attributeSet);
        return view;
    }

    private void a() {
        if (!this.f26799d && h.a.a.a.b.a().g()) {
            if (!(getContext() instanceof LayoutInflater.Factory2)) {
                this.f26799d = true;
                return;
            }
            Method b2 = l.b(LayoutInflater.class, "setPrivateFactory");
            if (b2 != null) {
                l.a(this, b2, new a((LayoutInflater.Factory2) getContext(), this, this.f26798c));
            }
            this.f26799d = true;
        }
    }

    public View a(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        if (!h.a.a.a.b.a().e()) {
            return view2;
        }
        if (view2 == null && str.indexOf(46) > -1) {
            if (this.f26800e == null) {
                this.f26800e = l.a(LayoutInflater.class, "mConstructorArgs");
            }
            Object[] objArr = (Object[]) l.a(this.f26800e, this);
            Object obj = objArr[0];
            objArr[0] = context;
            l.a(this.f26800e, this, objArr);
            try {
                view2 = createView(str, null, attributeSet);
                objArr[0] = obj;
            } catch (ClassNotFoundException unused) {
                objArr[0] = obj;
            } catch (Throwable th) {
                objArr[0] = obj;
                l.a(this.f26800e, this, objArr);
                throw th;
            }
            l.a(this.f26800e, this, objArr);
        }
        return view2;
    }
}
