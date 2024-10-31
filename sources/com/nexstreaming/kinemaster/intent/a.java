package com.nexstreaming.kinemaster.intent;

import android.content.Intent;
import com.google.gson.Gson;
import com.nexstreaming.kinemaster.intent.KMIntentData;

/* compiled from: KMIntentBuilder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private KMIntentData f20618a = new KMIntentData();

    /* compiled from: KMIntentBuilder.java */
    /* renamed from: com.nexstreaming.kinemaster.intent.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0107a extends c<C0107a> {
        C0107a(KMIntentData.VisualClip visualClip, a aVar) {
            super(visualClip, aVar);
        }

        public C0107a a(String str) {
            this.f20619a.path = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
        @Override // com.nexstreaming.kinemaster.intent.a.c
        public /* synthetic */ T a(int i) {
            return super.a(i);
        }

        public a a() {
            return this.f20620b;
        }
    }

    /* compiled from: KMIntentBuilder.java */
    /* loaded from: classes.dex */
    public static class b extends c<b> {
        b(KMIntentData.VisualClip visualClip, a aVar) {
            super(visualClip, aVar);
        }

        public b a(String str) {
            this.f20619a.path = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
        @Override // com.nexstreaming.kinemaster.intent.a.c
        public /* synthetic */ T a(int i) {
            return super.a(i);
        }

        public a a() {
            return this.f20620b;
        }
    }

    /* compiled from: KMIntentBuilder.java */
    /* loaded from: classes.dex */
    private static class c<T> {

        /* renamed from: a, reason: collision with root package name */
        protected final KMIntentData.VisualClip f20619a;

        /* renamed from: b, reason: collision with root package name */
        protected final a f20620b;

        /* renamed from: c, reason: collision with root package name */
        protected final T f20621c = this;

        /* JADX WARN: Multi-variable type inference failed */
        c(KMIntentData.VisualClip visualClip, a aVar) {
            this.f20619a = visualClip;
            this.f20620b = aVar;
        }

        public T a(int i) {
            this.f20619a.duration = i;
            return this.f20621c;
        }
    }

    public Intent a() {
        Gson gson = new Gson();
        Intent intent = new Intent(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT);
        intent.setPackage("com.nexstreaming.app.kinemasterfree");
        intent.putExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA, gson.toJson(this.f20618a));
        intent.setFlags(268468224);
        return intent;
    }

    public C0107a b() {
        KMIntentData.VisualClip visualClip = new KMIntentData.VisualClip();
        this.f20618a.project.visualClips.add(visualClip);
        return new C0107a(visualClip, this);
    }

    public b c() {
        KMIntentData.VisualClip visualClip = new KMIntentData.VisualClip();
        this.f20618a.project.visualClips.add(visualClip);
        return new b(visualClip, this);
    }
}
