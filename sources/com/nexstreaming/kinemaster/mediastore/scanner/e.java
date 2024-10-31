package com.nexstreaming.kinemaster.mediastore.scanner;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.FileObserver;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.general.util.G;
import com.nexstreaming.kinemaster.mediastore.scanner.MediaDb;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f21062a = Executors.newSingleThreadExecutor();
    private ContentObserver A;

    /* renamed from: b, reason: collision with root package name */
    private MediaDb f21063b;

    /* renamed from: g, reason: collision with root package name */
    private final Context f21068g;

    /* renamed from: h, reason: collision with root package name */
    private final File[] f21069h;
    private final File[] i;
    private c l;
    private Task m;
    private NexEditor n;
    private final boolean y;
    private ContentResolver z;

    /* renamed from: c, reason: collision with root package name */
    private boolean f21064c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f21065d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f21066e = false;

    /* renamed from: f, reason: collision with root package name */
    private FileObserver[] f21067f = null;
    private final Handler j = new Handler();
    private final Task k = new Task();
    private G o = null;
    private G p = null;
    private G q = null;
    private G r = null;
    private G s = null;
    private G t = null;
    private G u = null;
    private G v = null;
    private G w = null;
    private G x = null;
    private boolean B = false;
    private Runnable C = new com.nexstreaming.kinemaster.mediastore.scanner.c(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public abstract class c extends AsyncTask<Void, Integer, Void> {
        private c() {
        }

        /* synthetic */ c(e eVar, com.nexstreaming.kinemaster.mediastore.scanner.a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public class d extends FileObserver {

        /* renamed from: a, reason: collision with root package name */
        private final String f21076a;

        public d(String str, int i) {
            super(str, i);
            this.f21076a = str;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if (i != 8) {
                if (i != 64) {
                    if (i != 128) {
                        if (i != 512) {
                            return;
                        }
                    }
                }
                e.this.f21063b.d(new File(this.f21076a, str));
                return;
            }
            File file = new File(this.f21076a, str);
            if (new File(file.getParent(), ".nomedia").exists()) {
                return;
            }
            e.this.a(file, false, null);
        }
    }

    public e(Context context, NexEditor nexEditor, boolean z, File... fileArr) {
        this.f21068g = context;
        this.f21069h = fileArr;
        this.n = nexEditor;
        this.y = z;
        this.i = new File[]{context.getCacheDir(), context.getExternalCacheDir()};
        this.f21063b = new MediaDb(context);
        if (z) {
            h();
        } else {
            g();
        }
    }

    private boolean a(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* renamed from: com.nexstreaming.kinemaster.mediastore.scanner.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class AsyncTaskC0110e extends c {

        /* renamed from: b, reason: collision with root package name */
        C f21078b;

        /* renamed from: c, reason: collision with root package name */
        private int f21079c;

        /* renamed from: d, reason: collision with root package name */
        private int f21080d;

        /* renamed from: e, reason: collision with root package name */
        private int f21081e;

        private AsyncTaskC0110e() {
            super(e.this, null);
            this.f21081e = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            if (!com.nexstreaming.kinemaster.ui.e.b.a(e.this.f21068g, com.nexstreaming.kinemaster.ui.e.b.f21563a)) {
                return null;
            }
            e.this.f21063b.a();
            a();
            e.this.f21063b.b();
            return null;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            e.this.i();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f21078b = new C("AllMediaScanner", true);
            this.f21078b.a(0);
        }

        /* synthetic */ AsyncTaskC0110e(e eVar, com.nexstreaming.kinemaster.mediastore.scanner.a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            this.f21078b.a(1);
            e.this.j();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr.length > 0) {
                e.this.m.setProgress(numArr[0].intValue(), 1000);
            }
        }

        private void a() {
            e.this.f21063b.f();
            this.f21079c = 0;
            for (File file : e.this.f21069h) {
                if (isCancelled()) {
                    return;
                }
                a(file, false, true);
            }
            this.f21080d = this.f21079c;
            this.f21079c = 0;
            for (File file2 : e.this.f21069h) {
                if (isCancelled()) {
                    return;
                }
                a(file2, false, false);
            }
            e.this.f21063b.c();
        }

        private void a(File file, boolean z, boolean z2) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            long b2 = e.this.f21063b.b(file);
            boolean z3 = new File(file, ".nomedia").exists() ? true : z;
            long j = -1;
            for (File file2 : listFiles) {
                if (isCancelled()) {
                    return;
                }
                long lastModified = file2.lastModified();
                if (lastModified > j) {
                    j = lastModified;
                }
                if (!file2.isDirectory() && lastModified <= b2) {
                    e.this.f21063b.c(file2);
                } else if (!file2.isHidden()) {
                    File[] fileArr = e.this.i;
                    int length = fileArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            if (fileArr[i].equals(file2)) {
                                break;
                            } else {
                                i++;
                            }
                        } else if (file2.isDirectory()) {
                            a(file2, z3, z2);
                        } else {
                            this.f21079c++;
                            if (!z2) {
                                e.this.a(file2, z3, null);
                                int i2 = (this.f21079c * 1000) / this.f21080d;
                                if (this.f21081e != i2) {
                                    this.f21081e = i2;
                                    publishProgress(Integer.valueOf(this.f21081e));
                                }
                            }
                        }
                    }
                }
            }
            if (z2) {
                return;
            }
            e.this.f21063b.a(file, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task f() {
        if (EditorGlobal.p) {
            Crashlytics.log("initiateScan");
        }
        if (this.m == null && this.l == null) {
            if (!this.f21065d) {
                this.m = this.k;
                this.f21065d = true;
            } else {
                this.m = new Task();
            }
            com.nexstreaming.kinemaster.mediastore.scanner.a aVar = null;
            if (this.y) {
                this.l = new AsyncTaskC0110e(this, aVar);
            } else {
                this.l = new b(this, aVar);
            }
            this.B = false;
            this.l.executeOnExecutor(f21062a, new Void[0]);
            if (EditorGlobal.p) {
                Crashlytics.log("scan task started");
            }
        }
        return this.m;
    }

    private void g() {
        if (this.A != null) {
            return;
        }
        if (this.z == null) {
            this.z = KineMasterApplication.f24056d.getApplicationContext().getContentResolver();
        }
        this.A = new a(this.j);
        this.z.registerContentObserver(MediaStore.Files.getContentUri("external"), true, this.A);
        this.f21067f = new FileObserver[0];
    }

    private void h() {
        if (this.f21067f != null) {
            return;
        }
        this.f21067f = new FileObserver[this.f21069h.length];
        int i = 0;
        while (true) {
            File[] fileArr = this.f21069h;
            if (i >= fileArr.length) {
                return;
            }
            this.f21067f[i] = new d(fileArr[i].getAbsolutePath(), 968);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f21065d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.j.post(new com.nexstreaming.kinemaster.mediastore.scanner.a(this));
    }

    public void d() {
        if (this.f21064c) {
            new b(this, null).executeOnExecutor(f21062a, new Void[0]);
        }
    }

    public void e() {
        if (this.f21066e) {
            return;
        }
        for (FileObserver fileObserver : this.f21067f) {
            fileObserver.startWatching();
        }
        this.f21066e = true;
        if (this.f21064c) {
            return;
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            e.this.j.removeCallbacks(e.this.C);
            e.this.j.postDelayed(e.this.C, 500L);
            super.onChange(z);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            e.this.j.removeCallbacks(e.this.C);
            e.this.j.postDelayed(e.this.C, 500L);
            super.onChange(z, uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public class b extends c {

        /* renamed from: b, reason: collision with root package name */
        private int f21071b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f21072c;

        /* renamed from: d, reason: collision with root package name */
        C f21073d;

        private b() {
            super(e.this, null);
            this.f21071b = 0;
            this.f21072c = false;
        }

        private void b() {
            long d2 = e.this.f21063b.d();
            Cursor query = KineMasterApplication.f24056d.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_data", "date_added"}, "date_added>? AND media_type=0 AND (_data LIKE \"%.mov\" OR _data LIKE \"%.MOV\")", new String[]{String.valueOf(d2)}, null);
            if (query == null) {
                return;
            }
            query.moveToPosition(-1);
            while (query.moveToNext()) {
                int min = Math.min(((query.getPosition() + 1) * 1000) / query.getCount(), SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE);
                if (this.f21071b != min) {
                    this.f21071b = min;
                    publishProgress(Integer.valueOf(this.f21071b));
                }
                String string = query.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    if (file.exists() && !file.isDirectory() && !file.isHidden()) {
                        long j = query.getLong(1);
                        e.this.a(file, false, j > 0 ? new Date(j) : null);
                    }
                }
            }
            query.close();
            publishProgress(1000);
        }

        private void c() {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Log.i("AllMediaScanner", "start updateWoringLastModifiedDate : " + currentTimeMillis);
            Uri contentUri = MediaStore.Files.getContentUri("external");
            ContentResolver contentResolver = KineMasterApplication.f24056d.getContentResolver();
            if (!a(contentResolver, contentUri, currentTimeMillis)) {
                Log.d("AllMediaScanner", "updateWoringLastModifiedDate has not been updated.");
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            int i = 0;
            try {
                i = contentResolver.update(contentUri, contentValues, "_id>?", new String[]{String.valueOf(currentTimeMillis)});
                if (i > 0) {
                    Log.i("AllMediaScanner", "Update wrong DATE_ADDED value in Android File DB: count =" + i);
                }
            } catch (Exception unused) {
            }
            if (e.this.f21063b.b(currentTimeMillis) > 0) {
                Log.i("AllMediaScanner", "Update wrong DATE_ADDED value in Local Media DB: count =" + i);
            }
            Log.i("AllMediaScanner", "end updateWoringLastModifiedDate : duration " + ((System.currentTimeMillis() / 1000) - currentTimeMillis) + com.umeng.commonsdk.proguard.e.ap);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            if (!com.nexstreaming.kinemaster.ui.e.b.a(e.this.f21068g, com.nexstreaming.kinemaster.ui.e.b.f21563a)) {
                return null;
            }
            e.this.f21063b.a();
            c();
            b();
            a();
            e.this.f21063b.b();
            return null;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            e.this.i();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f21073d = new C("AllMediaScanner", true);
            this.f21073d.a(0);
            if (EditorGlobal.p) {
                Crashlytics.log("MediaStoreScannerAsyncTask:onPreExecute");
            }
        }

        /* synthetic */ b(e eVar, com.nexstreaming.kinemaster.mediastore.scanner.a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            this.f21073d.a(2);
            if (!this.f21072c) {
                e.this.j();
                this.f21072c = true;
            }
            if (EditorGlobal.p) {
                Crashlytics.log("MediaStoreScannerAsyncTask:onPostExecute");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr.length > 0) {
                if (e.this.m != null) {
                    e.this.m.setProgress(numArr[0].intValue(), 1000);
                }
                if (numArr[0].intValue() >= 1000) {
                    this.f21073d.a(1);
                    e.this.j();
                    this.f21072c = true;
                }
            }
        }

        private boolean a(ContentResolver contentResolver, Uri uri, long j) {
            try {
                Cursor query = contentResolver.query(uri, new String[]{"_id"}, "date_added>?", new String[]{String.valueOf(j)}, null);
                if (query != null) {
                    r1 = query.getCount() > 0;
                    query.close();
                }
            } catch (Exception unused) {
            }
            return r1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:            if (r5 != null) goto L33;     */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:            if (r2.size() <= 0) goto L40;     */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:            r0 = r2.iterator();     */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:            if (r0.hasNext() == false) goto L55;     */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:            r1 = (java.lang.Long) r0.next();        android.util.Log.i("AllMediaScanner", "do delete meida id = " + r1);        r11.f21074e.f21063b.a(r1.longValue());     */
        /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:            r5.close();     */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:            if (r5 == null) goto L34;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a() {
            /*
                r11 = this;
                java.lang.String r0 = "path"
                java.lang.String r1 = "_id"
                java.lang.System.currentTimeMillis()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                r3 = 0
                r4 = 0
                r5 = r4
                r4 = 0
            L10:
                com.nexstreaming.kinemaster.mediastore.scanner.e r6 = com.nexstreaming.kinemaster.mediastore.scanner.e.this     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                com.nexstreaming.kinemaster.mediastore.scanner.MediaDb r6 = com.nexstreaming.kinemaster.mediastore.scanner.e.a(r6)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r7 = 2
                java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r7[r3] = r1     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r8 = 1
                r7[r8] = r0     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r9 = 1000(0x3e8, float:1.401E-42)
                android.database.Cursor r5 = r6.a(r9, r4, r7)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r5 != 0) goto L2c
                if (r5 == 0) goto L2b
                r5.close()
            L2b:
                return
            L2c:
                r5.getCount()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                boolean r6 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r6 != 0) goto L36
                goto L7a
            L36:
                int r6 = r5.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                int r7 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                boolean r9 = r5.isNull(r6)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r9 != 0) goto L6c
                boolean r9 = r5.isNull(r7)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r9 != 0) goto L6c
                long r9 = r5.getLong(r6)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                java.lang.String r6 = r5.getString(r7)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r6 == 0) goto L65
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r7 < r8) goto L65
                java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r7.<init>(r6)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                boolean r6 = r7.exists()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r6 != 0) goto L6c
            L65:
                java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r2.add(r6)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            L6c:
                boolean r6 = r5.moveToNext()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r6 != 0) goto L36
                int r4 = r4 + 1000
                int r6 = r5.getCount()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r6 > 0) goto L10
            L7a:
                if (r5 == 0) goto L88
                goto L85
            L7d:
                r0 = move-exception
                goto Lc3
            L7f:
                r0 = move-exception
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L7d
                if (r5 == 0) goto L88
            L85:
                r5.close()
            L88:
                int r0 = r2.size()
                if (r0 <= 0) goto Lc2
                java.util.Iterator r0 = r2.iterator()
            L92:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto Lc2
                java.lang.Object r1 = r0.next()
                java.lang.Long r1 = (java.lang.Long) r1
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "do delete meida id = "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "AllMediaScanner"
                android.util.Log.i(r3, r2)
                com.nexstreaming.kinemaster.mediastore.scanner.e r2 = com.nexstreaming.kinemaster.mediastore.scanner.e.this
                com.nexstreaming.kinemaster.mediastore.scanner.MediaDb r2 = com.nexstreaming.kinemaster.mediastore.scanner.e.a(r2)
                long r3 = r1.longValue()
                r2.a(r3)
                goto L92
            Lc2:
                return
            Lc3:
                if (r5 == 0) goto Lc8
                r5.close()
            Lc8:
                goto Lca
            Lc9:
                throw r0
            Lca:
                goto Lc9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediastore.scanner.e.b.a():void");
        }
    }

    public MediaDb b() {
        return this.f21063b;
    }

    public boolean c() {
        return this.f21064c;
    }

    private boolean b(File file) {
        if (file == null || file.isHidden()) {
            return true;
        }
        for (File parentFile = file.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (parentFile.isHidden() || new File(parentFile, ".nomedia").exists()) {
                return true;
            }
        }
        return false;
    }

    public Task a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, boolean z, Date date) {
        if (a(file.getAbsolutePath())) {
            return;
        }
        a(file, FileType.fromExtension(file), z, date, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, boolean z, Date date, boolean z2) {
        a(file, FileType.fromExtension(file), z, date, z2);
    }

    private static Uri a(FileType fileType) {
        int i = com.nexstreaming.kinemaster.mediastore.scanner.d.f21061a[fileType.getCategory().ordinal()];
        if (i == 1 || i == 2) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if (i == 3) {
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (i != 4) {
            Log.e("AllMediaScanner", "Unsupported file type: " + fileType + ", category: " + fileType.getCategory());
            return null;
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    private void a(File file, FileType fileType, boolean z, Date date, boolean z2) {
        Uri a2;
        boolean z3;
        if (fileType != null && fileType == FileType.MOV) {
            if (z || !this.f21063b.a(file)) {
                FileType.FileCategory category = fileType.getCategory();
                if ((b(file) && !z2) || category == FileType.FileCategory.Audio || (a2 = a(fileType)) == null) {
                    return;
                }
                MediaDb.a aVar = new MediaDb.a();
                if (this.y) {
                    z3 = false;
                } else {
                    Cursor query = KineMasterApplication.f24056d.getContentResolver().query(a2, new String[]{"_id"}, "_data=?", new String[]{file.getAbsolutePath()}, null);
                    if (query != null) {
                        z3 = query.getCount() > 0;
                        query.close();
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        return;
                    }
                }
                if (aVar.f21052f == null) {
                    aVar.f21052f = date;
                }
                if (z3 || this.n == null || !(category == FileType.FileCategory.Audio || category == FileType.FileCategory.Video || category == FileType.FileCategory.VideoOrAudio)) {
                    if (z && this.f21063b.a(file)) {
                        return;
                    }
                } else {
                    if (z) {
                        return;
                    }
                    NexClipInfo nexClipInfo = new NexClipInfo();
                    NexEditor.b a3 = this.n.a(file.getAbsolutePath(), nexClipInfo, false, 0);
                    if (a3 != null && !a3.c()) {
                        aVar.f21050d = nexClipInfo.mExistAudio != 0;
                        aVar.f21051e = nexClipInfo.mExistVideo != 0;
                        aVar.f21054h = nexClipInfo.mVideoOrientation;
                        aVar.i = nexClipInfo.mFPS;
                        if (aVar.f21050d) {
                            aVar.f21049c = nexClipInfo.mAudioDuration;
                        } else {
                            aVar.f21049c = nexClipInfo.mVideoDuration;
                        }
                    }
                }
                if (category == FileType.FileCategory.VideoOrAudio) {
                    if (aVar.f21051e) {
                        category = FileType.FileCategory.Video;
                    } else if (!aVar.f21050d) {
                        return;
                    } else {
                        category = FileType.FileCategory.Audio;
                    }
                } else {
                    if (category == FileType.FileCategory.Video && !aVar.f21051e && !aVar.f21050d) {
                        return;
                    }
                    if (category == FileType.FileCategory.Audio && !aVar.f21050d) {
                        return;
                    }
                }
                int i = com.nexstreaming.kinemaster.mediastore.scanner.d.f21061a[category.ordinal()];
                if (i == 1) {
                    this.f21063b.a(file, MediaDb.MediaType.VIDEO, aVar, null);
                    return;
                }
                if (i == 2) {
                    if (aVar.f21051e) {
                        this.f21063b.a(file, MediaDb.MediaType.VIDEO, aVar, null);
                        return;
                    } else {
                        if (aVar.f21050d) {
                            this.f21063b.a(file, MediaDb.MediaType.AUDIO, aVar, null);
                            return;
                        }
                        return;
                    }
                }
                if (i == 3) {
                    this.f21063b.a(file, MediaDb.MediaType.AUDIO, aVar, null);
                } else if (i == 4) {
                    this.f21063b.a(file, MediaDb.MediaType.IMAGE, aVar, null);
                } else {
                    if (i != 5) {
                        return;
                    }
                    this.f21063b.a(file, MediaDb.MediaType.FONT, aVar, null);
                }
            }
        }
    }

    public Task a(File file) {
        return a(file, false);
    }

    public Task a(File file, boolean z) {
        Task task = new Task();
        new com.nexstreaming.kinemaster.mediastore.scanner.b(this, file, z, task).execute(new Void[0]);
        return task;
    }
}
