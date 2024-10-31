package com.nexstreaming.kinemaster.intent;

import android.content.Intent;
import com.google.gson.Gson;
import com.nexstreaming.kinemaster.intent.KMIntentData;

/* compiled from: KMIntentBuilder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private KMIntentData f3403a = new KMIntentData();

    public b a() {
        KMIntentData.VisualClip visualClip = new KMIntentData.VisualClip();
        this.f3403a.project.visualClips.add(visualClip);
        return new b(visualClip, this);
    }

    public C0069a b() {
        KMIntentData.VisualClip visualClip = new KMIntentData.VisualClip();
        this.f3403a.project.visualClips.add(visualClip);
        return new C0069a(visualClip, this);
    }

    public Intent c() {
        Gson gson = new Gson();
        Intent intent = new Intent(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT);
        intent.setPackage("com.nexstreaming.app.kinemasterfree");
        intent.putExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA, gson.toJson(this.f3403a));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KMIntentBuilder.java */
    /* loaded from: classes.dex */
    public static class c<T> {

        /* renamed from: a, reason: collision with root package name */
        protected final KMIntentData.VisualClip f3404a;
        protected final a b;
        protected final T c = this;

        /* JADX WARN: Multi-variable type inference failed */
        c(KMIntentData.VisualClip visualClip, a aVar) {
            this.f3404a = visualClip;
            this.b = aVar;
        }

        public T a(int i) {
            this.f3404a.duration = i;
            return this.c;
        }
    }

    /* compiled from: KMIntentBuilder.java */
    /* loaded from: classes.dex */
    public static class b extends c<b> {
        b(KMIntentData.VisualClip visualClip, a aVar) {
            super(visualClip, aVar);
        }

        public b a(String str) {
            this.f3404a.path = str;
            return this;
        }

        public a a() {
            return this.b;
        }
    }

    /* compiled from: KMIntentBuilder.java */
    /* renamed from: com.nexstreaming.kinemaster.intent.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069a extends c<C0069a> {
        C0069a(KMIntentData.VisualClip visualClip, a aVar) {
            super(visualClip, aVar);
        }

        public C0069a a(String str) {
            this.f3404a.path = str;
            return this;
        }

        public a a() {
            return this.b;
        }
    }
}
