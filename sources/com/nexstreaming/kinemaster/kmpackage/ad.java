package com.nexstreaming.kinemaster.kmpackage;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMTAsyncPackageLoader.java */
/* loaded from: classes.dex */
public class ad extends AsyncTask<ak, Integer, List<b>> {

    /* renamed from: a, reason: collision with root package name */
    private a f3430a = null;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KMTAsyncPackageLoader.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(ai aiVar, boolean z);

        void a(String str, Exception exc, boolean z);
    }

    public ad a(a aVar) {
        this.f3430a = aVar;
        return this;
    }

    public ad a(boolean z) {
        this.b = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: KMTAsyncPackageLoader.java */
    /* loaded from: classes.dex */
    public class b {
        private final ai b;
        private final String c;
        private final Exception d;

        public boolean a() {
            return this.b != null;
        }

        public ai b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public Exception d() {
            return this.d;
        }

        public b(ai aiVar) {
            this.d = null;
            this.b = aiVar;
            this.c = null;
        }

        public b(ak akVar, Exception exc) {
            this.d = exc;
            this.b = null;
            this.c = "Error(s) loading package '" + akVar.b() + "': " + exc.getMessage();
        }

        public b(String str) {
            this.d = null;
            this.b = null;
            this.c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<b> doInBackground(ak... akVarArr) {
        ArrayList arrayList = new ArrayList(akVarArr.length);
        for (ak akVar : akVarArr) {
            try {
                ai aiVar = new ai(akVar);
                List<String> k = aiVar.k();
                if (k.size() > 0) {
                    StringBuilder sb = new StringBuilder("Error(s) loading package '" + akVar.b() + "':\n");
                    for (String str : k) {
                        sb.append("\n  ");
                        sb.append(str);
                    }
                    arrayList.add(new b(sb.toString()));
                } else {
                    arrayList.add(new b(aiVar));
                }
            } catch (KineMasterPackageException e) {
                arrayList.add(new b(akVar, e));
            } catch (IOException e2) {
                arrayList.add(new b(akVar, e2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<b> list) {
        if (this.f3430a != null) {
            for (b bVar : list) {
                if (bVar.a()) {
                    this.f3430a.a(bVar.b(), this.b);
                } else {
                    this.f3430a.a(bVar.c(), bVar.d(), this.b);
                }
            }
            this.f3430a = null;
        }
        super.onPostExecute(list);
    }
}
