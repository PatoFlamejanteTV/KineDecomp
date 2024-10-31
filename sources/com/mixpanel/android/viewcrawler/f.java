package com.mixpanel.android.viewcrawler;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Pathfinder.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f3090a = new b();

    /* compiled from: Pathfinder.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(View view);
    }

    /* compiled from: Pathfinder.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f3092a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;
        public final String f;

        public c(int i, String str, int i2, int i3, String str2, String str3) {
            this.f3092a = i;
            this.b = str;
            this.c = i2;
            this.d = i3;
            this.e = str2;
            this.f = str3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f3092a == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                if (this.b != null) {
                    jSONObject.put("view_class", this.b);
                }
                if (this.c > -1) {
                    jSONObject.put("index", this.c);
                }
                if (this.d > -1) {
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.d);
                }
                if (this.e != null) {
                    jSONObject.put("contentDescription", this.e);
                }
                if (this.f != null) {
                    jSONObject.put("tag", this.f);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                throw new RuntimeException("Can't serialize PathElement to String", e);
            }
        }
    }

    public void a(View view, List<c> list, a aVar) {
        if (!list.isEmpty()) {
            if (this.f3090a.a()) {
                Log.w("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
                return;
            }
            c cVar = list.get(0);
            List<c> subList = list.subList(1, list.size());
            View a2 = a(cVar, view, this.f3090a.b());
            this.f3090a.c();
            if (a2 != null) {
                b(a2, subList, aVar);
            }
        }
    }

    private void b(View view, List<c> list, a aVar) {
        if (list.isEmpty()) {
            aVar.a(view);
            return;
        }
        if (view instanceof ViewGroup) {
            if (this.f3090a.a()) {
                Log.v("MixpanelAPI.PathFinder", "Path is too deep, will not match");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            c cVar = list.get(0);
            List<c> subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int b2 = this.f3090a.b();
            for (int i = 0; i < childCount; i++) {
                View a2 = a(cVar, viewGroup.getChildAt(i), b2);
                if (a2 != null) {
                    b(a2, subList, aVar);
                }
                if (cVar.c >= 0 && this.f3090a.a(b2) > cVar.c) {
                    break;
                }
            }
            this.f3090a.c();
        }
    }

    private View a(c cVar, View view, int i) {
        int a2 = this.f3090a.a(i);
        if (a(cVar, view)) {
            this.f3090a.b(i);
            if (cVar.c == -1 || cVar.c == a2) {
                return view;
            }
        }
        if (cVar.f3092a == 1 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View a3 = a(cVar, viewGroup.getChildAt(i2), i);
                if (a3 != null) {
                    return a3;
                }
            }
        }
        return null;
    }

    private boolean a(c cVar, View view) {
        if (cVar.b != null && !a(view, cVar.b)) {
            return false;
        }
        if (-1 != cVar.d && view.getId() != cVar.d) {
            return false;
        }
        if (cVar.e == null || cVar.e.equals(view.getContentDescription())) {
            return cVar.f == null || (view.getTag() != null && cVar.f.equals(view.getTag().toString()));
        }
        return false;
    }

    private static boolean a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); !cls.getCanonicalName().equals(str); cls = cls.getSuperclass()) {
            if (cls == Object.class) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Pathfinder.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f3091a = new int[256];
        private int b = 0;

        public boolean a() {
            return this.f3091a.length == this.b;
        }

        public int b() {
            int i = this.b;
            this.b++;
            this.f3091a[i] = 0;
            return i;
        }

        public int a(int i) {
            return this.f3091a[i];
        }

        public void b(int i) {
            int[] iArr = this.f3091a;
            iArr[i] = iArr[i] + 1;
        }

        public void c() {
            this.b--;
            if (this.b < 0) {
                throw new ArrayIndexOutOfBoundsException(this.b);
            }
        }
    }
}
