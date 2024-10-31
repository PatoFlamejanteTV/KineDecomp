package com.nexstreaming.app.general.service.download;

import android.os.AsyncTask;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* compiled from: FileDownloadTask.java */
/* loaded from: classes2.dex */
public class l extends AsyncTask<Void, a, com.nexstreaming.app.general.service.download.b> {

    /* renamed from: a */
    private a f19715a;

    /* renamed from: b */
    private final k f19716b;

    /* renamed from: c */
    private final b f19717c;

    /* renamed from: d */
    private long f19718d = 0;

    /* compiled from: FileDownloadTask.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        public final long f19719a;

        /* renamed from: b */
        public final long f19720b;

        /* renamed from: c */
        public final int f19721c;

        public a(long j, long j2, int i) {
            this.f19719a = j;
            this.f19720b = j2;
            this.f19721c = i;
        }

        public int a() {
            long j = this.f19720b;
            if (j <= 0) {
                return 0;
            }
            double d2 = this.f19719a;
            double d3 = j;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return (int) ((d2 / d3) * 100.0d);
        }

        public String toString() {
            return "DownloadStatus{completedBytes=" + this.f19719a + ", totalBytes=" + this.f19720b + ", error=" + this.f19721c + '}';
        }
    }

    /* compiled from: FileDownloadTask.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(k kVar);

        void a(k kVar, long j, long j2, int i);

        void a(k kVar, com.nexstreaming.app.general.service.download.b bVar);

        void a(l lVar, k kVar);

        void b(k kVar);
    }

    public l(k kVar, b bVar) {
        this.f19715a = null;
        this.f19716b = kVar;
        this.f19717c = bVar;
        this.f19715a = new a(0L, 0L, 0);
    }

    public a a() {
        return this.f19715a;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(com.nexstreaming.app.general.service.download.b bVar) {
        super.onPostExecute(bVar);
        Log.d("FileDownloadTask", "service connection error: onPostExecute() called with: result = [" + bVar + "]");
        b bVar2 = this.f19717c;
        if (bVar2 != null) {
            int i = bVar.f19687a;
            if (i == 1) {
                bVar2.a(this.f19716b);
            } else if (i != 17) {
                bVar2.a(this.f19716b, bVar);
            } else {
                bVar2.b(this.f19716b);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        b bVar = this.f19717c;
        if (bVar != null) {
            bVar.a(this, this.f19716b);
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onCancelled(com.nexstreaming.app.general.service.download.b bVar) {
        super.onCancelled(bVar);
        b bVar2 = this.f19717c;
        if (bVar2 != null) {
            bVar2.b(this.f19716b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x038f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.app.general.service.download.b a(com.nexstreaming.app.general.service.download.k r27) {
        /*
            Method dump skipped, instructions count: 923
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.service.download.l.a(com.nexstreaming.app.general.service.download.k):com.nexstreaming.app.general.service.download.b");
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.nexstreaming.app.general.service.download.b doInBackground(Void... voidArr) {
        k kVar = this.f19716b;
        if (kVar != null) {
            if (kVar.h()) {
                File b2 = this.f19716b.b();
                publishProgress(new a(b2.length(), b2.length(), 1));
                return new com.nexstreaming.app.general.service.download.b(1, R.string.project_settings_done);
            }
            return a(this.f19716b);
        }
        return new com.nexstreaming.app.general.service.download.b(64, R.string.asset_download_failed);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(a... aVarArr) {
        super.onProgressUpdate(aVarArr);
        if (aVarArr.length > 0) {
            this.f19715a = aVarArr[0];
            a aVar = this.f19715a;
            if (aVar == null || this.f19717c == null) {
                return;
            }
            int i = aVar.f19721c;
            if ((i == 1 || i == 16) && this.f19718d + 500 < System.currentTimeMillis()) {
                this.f19718d = System.currentTimeMillis();
                b bVar = this.f19717c;
                k kVar = this.f19716b;
                a aVar2 = this.f19715a;
                bVar.a(kVar, aVar2.f19719a, aVar2.f19720b, aVar2.a());
            }
        }
    }
}
