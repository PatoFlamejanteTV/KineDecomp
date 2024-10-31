package com.nexstreaming.kinemaster.ui.share;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ExportedVideoDatabaseTask.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.da */
/* loaded from: classes2.dex */
public class AsyncTaskC2214da extends AsyncTask<Integer, Void, ArrayList<V>> {

    /* renamed from: a */
    private final ExportedVideoDatabase f23333a;

    /* renamed from: b */
    private String f23334b;

    /* renamed from: c */
    private String f23335c;

    /* renamed from: d */
    private V f23336d;

    /* renamed from: e */
    private ArrayList<V> f23337e;

    /* renamed from: f */
    private a f23338f;

    /* compiled from: ExportedVideoDatabaseTask.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.share.da$a */
    /* loaded from: classes2.dex */
    public interface a {
        void a(ArrayList<V> arrayList);
    }

    public AsyncTaskC2214da(ExportedVideoDatabase exportedVideoDatabase, String str, a aVar) {
        this(exportedVideoDatabase, str, null, null, aVar);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ArrayList<V> doInBackground(Integer... numArr) {
        int intValue = numArr[0].intValue();
        if (intValue == 0) {
            return new ArrayList<>(Arrays.asList(this.f23333a.j().b(this.f23334b)));
        }
        if (intValue == 1) {
            this.f23333a.j().a(this.f23336d);
        } else if (intValue == 2) {
            this.f23333a.j().b(this.f23336d);
        } else if (intValue == 3) {
            this.f23333a.j().a(this.f23334b, this.f23335c);
        } else if (intValue == 4) {
            this.f23333a.j().a(this.f23334b);
        } else if (intValue == 5) {
            this.f23333a.j().a(this.f23337e);
        }
        return null;
    }

    public AsyncTaskC2214da(ExportedVideoDatabase exportedVideoDatabase, String str, String str2, a aVar) {
        this(exportedVideoDatabase, str, str2, null, aVar);
    }

    public AsyncTaskC2214da(ExportedVideoDatabase exportedVideoDatabase, String str, V v, a aVar) {
        this(exportedVideoDatabase, str, null, v, aVar);
    }

    public AsyncTaskC2214da(ExportedVideoDatabase exportedVideoDatabase, String str, ArrayList<V> arrayList, a aVar) {
        this.f23333a = exportedVideoDatabase;
        this.f23334b = str;
        this.f23335c = null;
        this.f23337e = arrayList;
        this.f23338f = aVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ArrayList<V> arrayList) {
        a aVar = this.f23338f;
        if (aVar != null) {
            aVar.a(arrayList);
        }
        super.onPostExecute(arrayList);
    }

    public AsyncTaskC2214da(ExportedVideoDatabase exportedVideoDatabase, String str, String str2, V v, a aVar) {
        this.f23333a = exportedVideoDatabase;
        this.f23334b = str;
        this.f23335c = str2;
        this.f23336d = v;
        this.f23338f = aVar;
    }
}
