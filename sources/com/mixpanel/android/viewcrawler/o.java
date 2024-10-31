package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.viewcrawler.f;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewVisitor.java */
@TargetApi(16)
/* loaded from: classes.dex */
public abstract class o implements f.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<f.c> f3108a;
    private final com.mixpanel.android.viewcrawler.f b = new com.mixpanel.android.viewcrawler.f();

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public interface h {
        void a(View view, String str, boolean z);
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public interface i {
        void a(e eVar);
    }

    public abstract void a();

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f3114a;
        private final String b;

        public e(String str, String str2) {
            this.f3114a = str;
            this.b = str2;
        }

        public String a() {
            return this.f3114a;
        }

        public String b() {
            return this.b;
        }
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class j extends o {

        /* renamed from: a, reason: collision with root package name */
        private final com.mixpanel.android.viewcrawler.a f3117a;
        private final com.mixpanel.android.viewcrawler.a b;
        private final WeakHashMap<View, Object> c;
        private final Object[] d;

        @Override // com.mixpanel.android.viewcrawler.o
        public /* bridge */ /* synthetic */ void b(View view) {
            super.b(view);
        }

        public j(List<f.c> list, com.mixpanel.android.viewcrawler.a aVar, com.mixpanel.android.viewcrawler.a aVar2) {
            super(list);
            this.f3117a = aVar;
            this.b = aVar2;
            this.d = new Object[1];
            this.c = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.o
        public void a() {
            for (Map.Entry<View, Object> entry : this.c.entrySet()) {
                View key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    this.d[0] = value;
                    this.f3117a.a(key, this.d);
                }
            }
        }

        @Override // com.mixpanel.android.viewcrawler.f.a
        public void a(View view) {
            if (this.b != null) {
                Object[] a2 = this.f3117a.a();
                if (1 == a2.length) {
                    Object obj = a2[0];
                    Object a3 = this.b.a(view);
                    if (obj != a3) {
                        if (obj != null) {
                            if ((obj instanceof Bitmap) && (a3 instanceof Bitmap)) {
                                if (((Bitmap) obj).sameAs((Bitmap) a3)) {
                                    return;
                                }
                            } else if ((obj instanceof BitmapDrawable) && (a3 instanceof BitmapDrawable)) {
                                Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
                                Bitmap bitmap2 = ((BitmapDrawable) a3).getBitmap();
                                if (bitmap != null && bitmap.sameAs(bitmap2)) {
                                    return;
                                }
                            } else if (obj.equals(a3)) {
                                return;
                            }
                        }
                        if (!(a3 instanceof Bitmap) && !(a3 instanceof BitmapDrawable) && !this.c.containsKey(view)) {
                            this.d[0] = a3;
                            if (this.f3117a.a(this.d)) {
                                this.c.put(view, a3);
                            } else {
                                this.c.put(view, null);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            this.f3117a.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class c {
        private c() {
        }

        public boolean a(TreeMap<View, List<View>> treeMap) {
            ArrayList arrayList = new ArrayList();
            while (!treeMap.isEmpty()) {
                if (!a(treeMap, treeMap.firstKey(), arrayList)) {
                    return false;
                }
            }
            return true;
        }

        private boolean a(TreeMap<View, List<View>> treeMap, View view, List<View> list) {
            if (list.contains(view)) {
                return false;
            }
            if (treeMap.containsKey(view)) {
                List<View> remove = treeMap.remove(view);
                list.add(view);
                int size = remove.size();
                for (int i = 0; i < size; i++) {
                    if (!a(treeMap, remove.get(i), list)) {
                        return false;
                    }
                }
                list.remove(view);
            }
            return true;
        }
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class g extends o {
        private static final Set<Integer> d = new HashSet(Arrays.asList(0, 1, 5, 7));
        private static final Set<Integer> e = new HashSet(Arrays.asList(2, 3, 4, 6, 8));

        /* renamed from: a, reason: collision with root package name */
        private final WeakHashMap<View, int[]> f3116a;
        private final List<f> b;
        private final String c;
        private boolean f;
        private final i g;
        private final c h;

        public g(List<f.c> list, List<f> list2, String str, i iVar) {
            super(list);
            this.f3116a = new WeakHashMap<>();
            this.b = list2;
            this.c = str;
            this.f = true;
            this.g = iVar;
            this.h = new c();
        }

        @Override // com.mixpanel.android.viewcrawler.o
        public void a() {
            for (Map.Entry<View, int[]> entry : this.f3116a.entrySet()) {
                View key = entry.getKey();
                int[] value = entry.getValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) key.getLayoutParams();
                for (int i = 0; i < value.length; i++) {
                    layoutParams.addRule(i, value[i]);
                }
                key.setLayoutParams(layoutParams);
            }
            this.f = false;
        }

        @Override // com.mixpanel.android.viewcrawler.o
        public void b(View view) {
            if (this.f) {
                c().a(view, b(), this);
            }
        }

        @Override // com.mixpanel.android.viewcrawler.f.a
        public void a(View view) {
            Set<Integer> set;
            ViewGroup viewGroup = (ViewGroup) view;
            SparseArray<View> sparseArray = new SparseArray<>();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                int id = childAt.getId();
                if (id > 0) {
                    sparseArray.put(id, childAt);
                }
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.b.get(i2);
                View view2 = sparseArray.get(fVar.f3115a);
                if (view2 != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                    int[] iArr = (int[]) layoutParams.getRules().clone();
                    if (iArr[fVar.b] == fVar.c) {
                        continue;
                    } else {
                        if (!this.f3116a.containsKey(view2)) {
                            this.f3116a.put(view2, iArr);
                        }
                        layoutParams.addRule(fVar.b, fVar.c);
                        if (d.contains(Integer.valueOf(fVar.b))) {
                            set = d;
                        } else if (e.contains(Integer.valueOf(fVar.b))) {
                            set = e;
                        } else {
                            set = null;
                        }
                        if (set != null && !a(set, sparseArray)) {
                            a();
                            this.g.a(new e("circular_dependency", this.c));
                            return;
                        }
                        view2.setLayoutParams(layoutParams);
                    }
                }
            }
        }

        private boolean a(Set<Integer> set, SparseArray<View> sparseArray) {
            TreeMap<View, List<View>> treeMap = new TreeMap<>(new p(this));
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                int[] rules = ((RelativeLayout.LayoutParams) valueAt.getLayoutParams()).getRules();
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int i2 = rules[it.next().intValue()];
                    if (i2 > 0 && i2 != valueAt.getId()) {
                        arrayList.add(sparseArray.get(i2));
                    }
                }
                treeMap.put(valueAt, arrayList);
            }
            return this.h.a(treeMap);
        }
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f3115a;
        public final int b;
        public final int c;

        public f(int i, int i2, int i3) {
            this.f3115a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        private final int f3109a;
        private final WeakHashMap<View, C0060a> b;

        @Override // com.mixpanel.android.viewcrawler.o
        public /* bridge */ /* synthetic */ void b(View view) {
            super.b(view);
        }

        public a(List<f.c> list, int i, String str, h hVar) {
            super(list, str, hVar, false);
            this.f3109a = i;
            this.b = new WeakHashMap<>();
        }

        @Override // com.mixpanel.android.viewcrawler.o
        public void a() {
            for (Map.Entry<View, C0060a> entry : this.b.entrySet()) {
                View key = entry.getKey();
                C0060a value = entry.getValue();
                View.AccessibilityDelegate d = d(key);
                if (d == value) {
                    key.setAccessibilityDelegate(value.a());
                } else if (d instanceof C0060a) {
                    ((C0060a) d).a(value);
                }
            }
            this.b.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.f.a
        public void a(View view) {
            View.AccessibilityDelegate d = d(view);
            if (!(d instanceof C0060a) || !((C0060a) d).a(d())) {
                C0060a c0060a = new C0060a(d);
                view.setAccessibilityDelegate(c0060a);
                this.b.put(view, c0060a);
            }
        }

        private View.AccessibilityDelegate d(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (IllegalAccessException e) {
                return null;
            } catch (NoSuchMethodException e2) {
                return null;
            } catch (InvocationTargetException e3) {
                Log.w("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", e3);
                return null;
            }
        }

        /* compiled from: ViewVisitor.java */
        /* renamed from: com.mixpanel.android.viewcrawler.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0060a extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;

            public C0060a(View.AccessibilityDelegate accessibilityDelegate) {
                this.b = accessibilityDelegate;
            }

            public View.AccessibilityDelegate a() {
                return this.b;
            }

            public boolean a(String str) {
                if (a.this.d() == str) {
                    return true;
                }
                if (this.b instanceof C0060a) {
                    return ((C0060a) this.b).a(str);
                }
                return false;
            }

            public void a(C0060a c0060a) {
                if (this.b == c0060a) {
                    this.b = c0060a.a();
                } else if (this.b instanceof C0060a) {
                    ((C0060a) this.b).a(c0060a);
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                if (i == a.this.f3109a) {
                    a.this.c(view);
                }
                if (this.b != null) {
                    this.b.sendAccessibilityEvent(view, i);
                }
            }
        }
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class b extends d {

        /* renamed from: a, reason: collision with root package name */
        private final Map<TextView, TextWatcher> f3111a;

        @Override // com.mixpanel.android.viewcrawler.o
        public /* bridge */ /* synthetic */ void b(View view) {
            super.b(view);
        }

        public b(List<f.c> list, String str, h hVar) {
            super(list, str, hVar, true);
            this.f3111a = new HashMap();
        }

        @Override // com.mixpanel.android.viewcrawler.o
        public void a() {
            for (Map.Entry<TextView, TextWatcher> entry : this.f3111a.entrySet()) {
                entry.getKey().removeTextChangedListener(entry.getValue());
            }
            this.f3111a.clear();
        }

        @Override // com.mixpanel.android.viewcrawler.f.a
        public void a(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                a aVar = new a(textView);
                TextWatcher textWatcher = this.f3111a.get(textView);
                if (textWatcher != null) {
                    textView.removeTextChangedListener(textWatcher);
                }
                textView.addTextChangedListener(aVar);
                this.f3111a.put(textView, aVar);
            }
        }

        /* compiled from: ViewVisitor.java */
        /* loaded from: classes.dex */
        private class a implements TextWatcher {
            private final View b;

            public a(View view) {
                this.b = view;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.c(this.b);
            }
        }
    }

    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static class k extends d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3118a;

        @Override // com.mixpanel.android.viewcrawler.o
        public /* bridge */ /* synthetic */ void b(View view) {
            super.b(view);
        }

        public k(List<f.c> list, String str, h hVar) {
            super(list, str, hVar, false);
            this.f3118a = false;
        }

        @Override // com.mixpanel.android.viewcrawler.o
        public void a() {
        }

        @Override // com.mixpanel.android.viewcrawler.f.a
        public void a(View view) {
            if (view != null && !this.f3118a) {
                c(view);
            }
            this.f3118a = view != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewVisitor.java */
    /* loaded from: classes.dex */
    public static abstract class d extends o {

        /* renamed from: a, reason: collision with root package name */
        private final h f3113a;
        private final String b;
        private final boolean c;

        public d(List<f.c> list, String str, h hVar, boolean z) {
            super(list);
            this.f3113a = hVar;
            this.b = str;
            this.c = z;
        }

        protected void c(View view) {
            this.f3113a.a(view, this.b, this.c);
        }

        protected String d() {
            return this.b;
        }
    }

    public void b(View view) {
        this.b.a(view, this.f3108a, this);
    }

    protected o(List<f.c> list) {
        this.f3108a = list;
    }

    protected List<f.c> b() {
        return this.f3108a;
    }

    protected com.mixpanel.android.viewcrawler.f c() {
        return this.b;
    }
}
