package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: UserField.java */
/* loaded from: classes.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private String f3443a;
    private UserFieldType b;
    private String c;
    private String d;
    private int e;
    private Map<String, String> f = new HashMap();
    private List<a> g = new ArrayList();
    private List<a> h = Collections.unmodifiableList(this.g);
    private a i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: protected */
    public au(ae aeVar) {
        String a2 = aeVar.a("label");
        try {
            this.b = UserFieldType.valueOf(aeVar.a("type"));
            this.f3443a = this.b.name() + ":" + aeVar.a(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.c = aeVar.a("default", "");
            this.e = aeVar.a("maxlines", 1);
            this.f.put("", a2);
            this.d = aeVar.a("editor", "");
            this.j = true;
        } catch (IllegalArgumentException e) {
            this.j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ae aeVar) {
        if (this.i == null) {
            this.f.put(aeVar.a("locale").toLowerCase(Locale.ENGLISH), aeVar.a("value"));
        } else {
            this.i.f3444a.put(aeVar.a("locale").toLowerCase(Locale.ENGLISH), aeVar.a("value"));
        }
    }

    public String b() {
        return this.f3443a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public UserFieldType f() {
        return this.b;
    }

    public List<a> g() {
        return this.h;
    }

    public String a(Context context) {
        return ah.a(context, this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ae aeVar) {
        if (this.i == null) {
            this.i = new a(aeVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        if (this.i != null) {
            this.g.add(this.i);
            this.i = null;
        }
    }

    /* compiled from: UserField.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, String> f3444a = new HashMap();
        private String b;
        private String c;

        protected a(ae aeVar) {
            this.b = aeVar.a("value");
            this.c = aeVar.a("icon");
            this.f3444a.put("", aeVar.a("label"));
        }

        public String a(Context context) {
            return ah.a(context, this.f3444a);
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }
}
