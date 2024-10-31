package com.nexstreaming.kinemaster.mediastore.v2.scanner;

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
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.general.util.s;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.mediastore.v2.scanner.MediaDb;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class a {
    private static final Executor b = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    private MediaDb f3604a;
    private final File[] g;
    private final File[] h;
    private c k;
    private Task l;
    private NexEditor m;
    private final boolean x;
    private ContentResolver y;
    private ContentObserver z;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private FileObserver[] f = null;
    private final Handler i = new Handler();
    private final Task j = new Task();
    private u n = null;
    private u o = null;
    private u p = null;
    private u q = null;
    private u r = null;
    private u s = null;
    private u t = null;
    private u u = null;
    private u v = null;
    private u w = null;
    private boolean A = false;
    private Runnable B = new com.nexstreaming.kinemaster.mediastore.v2.scanner.d(this);

    public a(Context context, NexEditor nexEditor, boolean z, File... fileArr) {
        this.g = fileArr;
        this.m = nexEditor;
        this.x = z;
        this.h = new File[]{context.getCacheDir(), context.getExternalCacheDir()};
        this.f3604a = new MediaDb(context);
        if (z) {
            f();
        } else {
            e();
        }
    }

    private void e() {
        if (this.z == null) {
            if (this.y == null) {
                this.y = KineMasterApplication.a().getApplicationContext().getContentResolver();
            }
            this.z = new C0072a(this.i);
            this.y.registerContentObserver(MediaStore.Files.getContentUri("external"), true, this.z);
            this.f = new FileObserver[0];
        }
    }

    public Task a() {
        return this.j;
    }

    private void f() {
        if (this.f == null) {
            this.f = new FileObserver[this.g.length];
            for (int i = 0; i < this.g.length; i++) {
                this.f[i] = new d(this.g[i].getAbsolutePath(), 968);
            }
        }
    }

    public void b() {
        if (!this.e) {
            for (FileObserver fileObserver : this.f) {
                fileObserver.startWatching();
            }
            this.e = true;
            if (!this.c) {
                g();
            }
        }
    }

    public void c() {
        if (this.c) {
            new b(this, null).executeOnExecutor(b, new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task g() {
        com.nexstreaming.kinemaster.mediastore.v2.scanner.b bVar = null;
        if (this.l == null && this.k == null) {
            if (!this.d) {
                this.l = this.j;
                this.d = true;
            } else {
                this.l = new Task();
            }
            if (this.x) {
                this.k = new e(this, bVar);
            } else {
                this.k = new b(this, bVar);
            }
            this.A = false;
            this.k.executeOnExecutor(b, new Void[0]);
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.i.post(new com.nexstreaming.kinemaster.mediastore.v2.scanner.b(this));
    }

    public MediaDb d() {
        return this.f3604a;
    }

    private boolean a(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, boolean z, Date date) {
        if (!a(file.getAbsolutePath())) {
            a(file, FileType.fromExtension(file), z, date, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, boolean z, Date date, boolean z2) {
        a(file, FileType.fromExtension(file), z, date, z2);
    }

    private static Uri a(FileType fileType) {
        switch (fileType.getCategory()) {
            case Video:
            case VideoOrAudio:
                return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            case Audio:
                return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            case Image:
                return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            default:
                Log.e("AllMediaScanner", "Unsupported file type: " + fileType + ", category: " + fileType.getCategory());
                return null;
        }
    }

    private void a(File file, FileType fileType, boolean z, Date date, boolean z2) {
        Uri a2;
        boolean z3;
        FileType.FileCategory fileCategory;
        if (fileType != null && fileType == FileType.MOV) {
            if (z || !this.f3604a.c(file)) {
                FileType.FileCategory category = fileType.getCategory();
                if ((!b(file) || z2) && category != FileType.FileCategory.Audio && (a2 = a(fileType)) != null) {
                    MediaDb.a aVar = new MediaDb.a();
                    if (this.x) {
                        z3 = false;
                    } else {
                        Cursor query = KineMasterApplication.a().getContentResolver().query(a2, new String[]{"_id"}, "_data=?", new String[]{file.getAbsolutePath()}, null);
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
                    if (aVar.f == null) {
                        aVar.f = date;
                    }
                    if (!z3 && this.m != null && (category == FileType.FileCategory.Audio || category == FileType.FileCategory.Video || category == FileType.FileCategory.VideoOrAudio)) {
                        if (!z) {
                            NexClipInfo nexClipInfo = new NexClipInfo();
                            NexEditor.b a3 = this.m.a(file.getAbsolutePath(), nexClipInfo, false, 0);
                            if (a3 != null && !a3.a()) {
                                aVar.d = nexClipInfo.mExistAudio != 0;
                                aVar.e = nexClipInfo.mExistVideo != 0;
                                aVar.h = nexClipInfo.mVideoOrientation;
                                aVar.i = nexClipInfo.mFPS;
                                if (aVar.d) {
                                    aVar.c = nexClipInfo.mAudioDuration;
                                } else {
                                    aVar.c = nexClipInfo.mVideoDuration;
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (z && this.f3604a.c(file)) {
                        return;
                    }
                    if (category == FileType.FileCategory.VideoOrAudio) {
                        if (aVar.e) {
                            fileCategory = FileType.FileCategory.Video;
                        } else if (aVar.d) {
                            fileCategory = FileType.FileCategory.Audio;
                        } else {
                            return;
                        }
                    } else if (category != FileType.FileCategory.Video || aVar.e || aVar.d) {
                        if (category == FileType.FileCategory.Audio && !aVar.d) {
                            return;
                        } else {
                            fileCategory = category;
                        }
                    } else {
                        return;
                    }
                    switch (fileCategory) {
                        case Video:
                            this.f3604a.a(file, MediaDb.MediaType.VIDEO, aVar, null);
                            return;
                        case VideoOrAudio:
                            if (aVar.e) {
                                this.f3604a.a(file, MediaDb.MediaType.VIDEO, aVar, null);
                                return;
                            } else {
                                if (aVar.d) {
                                    this.f3604a.a(file, MediaDb.MediaType.AUDIO, aVar, null);
                                    return;
                                }
                                return;
                            }
                        case Audio:
                            this.f3604a.a(file, MediaDb.MediaType.AUDIO, aVar, null);
                            return;
                        case Image:
                            this.f3604a.a(file, MediaDb.MediaType.IMAGE, aVar, null);
                            return;
                        case Font:
                            this.f3604a.a(file, MediaDb.MediaType.FONT, aVar, null);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public abstract class c extends AsyncTask<Void, Integer, Void> {
        private c() {
        }

        /* synthetic */ c(a aVar, com.nexstreaming.kinemaster.mediastore.v2.scanner.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public class b extends c {

        /* renamed from: a, reason: collision with root package name */
        s f3607a;
        private int d;

        private b() {
            super(a.this, null);
            this.d = 0;
        }

        /* synthetic */ b(a aVar, com.nexstreaming.kinemaster.mediastore.v2.scanner.b bVar) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f3607a = new s("AllMediaScanner", true);
            this.f3607a.a(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            a.this.f3604a.b();
            a();
            b();
            c();
            a.this.f3604a.c();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            this.f3607a.a(2);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            a.this.h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr.length > 0) {
                if (a.this.l != null) {
                    a.this.l.setProgress(numArr[0].intValue(), LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
                }
                if (numArr[0].intValue() >= 1000) {
                    this.f3607a.a(1);
                    a.this.i();
                }
            }
        }

        private boolean a(ContentResolver contentResolver, Uri uri, long j) {
            try {
                Cursor query = contentResolver.query(uri, new String[]{"_id"}, "date_added>?", new String[]{String.valueOf(j)}, null);
                if (query == null) {
                    return false;
                }
                boolean z = query.getCount() > 0;
                try {
                    query.close();
                    return z;
                } catch (Exception e) {
                    return z;
                }
            } catch (Exception e2) {
                return false;
            }
        }

        private void a() {
            int i;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Log.i("AllMediaScanner", "start updateWoringLastModifiedDate : " + currentTimeMillis);
            Uri contentUri = MediaStore.Files.getContentUri("external");
            ContentResolver contentResolver = KineMasterApplication.a().getContentResolver();
            if (!a(contentResolver, contentUri, currentTimeMillis)) {
                Log.d("AllMediaScanner", "updateWoringLastModifiedDate has not been updated.");
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            try {
                i = contentResolver.update(contentUri, contentValues, "_id>?", new String[]{String.valueOf(currentTimeMillis)});
                if (i > 0) {
                    try {
                        Log.i("AllMediaScanner", "Update wrong DATE_ADDED value in Android File DB: count =" + i);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                i = 0;
            }
            int a2 = a.this.f3604a.a(currentTimeMillis);
            if (a2 > 0) {
                Log.i("AllMediaScanner", "Update wrong DATE_ADDED value in Local Media DB: count =" + i);
            }
            Log.i("AllMediaScanner", "end updateWoringLastModifiedDate : duration " + ((System.currentTimeMillis() / 1000) - currentTimeMillis) + "s");
            if (i > 0 || a2 > 0) {
                KMUsage.Updated_Wrong_MODIFIED_DATE_DB.logEvent("Update timestamp", currentTimeMillis + " s", "Update android file db", "updated count = " + i, "Updated local media db", "updated count =  " + a2);
            }
        }

        private void b() {
            Cursor query = KineMasterApplication.a().getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_data", "date_added"}, "date_added>? AND media_type=0 AND (_data LIKE \"%.mov\" OR _data LIKE \"%.MOV\")", new String[]{String.valueOf(a.this.f3604a.a())}, null);
            if (query != null) {
                query.moveToPosition(-1);
                while (query.moveToNext()) {
                    int min = Math.min(((query.getPosition() + 1) * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / query.getCount(), 999);
                    if (this.d != min) {
                        this.d = min;
                        publishProgress(new Integer[]{Integer.valueOf(this.d)});
                    }
                    String string = query.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (file.exists() && !file.isDirectory() && !file.isHidden()) {
                            long j = query.getLong(1);
                            a.this.a(file, false, j > 0 ? new Date(j) : null);
                        }
                    }
                }
                query.close();
                publishProgress(new Integer[]{Integer.valueOf(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED)});
            }
        }

        private void c() {
            int i = 0;
            System.currentTimeMillis();
            Cursor cursor = null;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            do {
                try {
                    try {
                        cursor = a.this.f3604a.a(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, i2, "_id", "path");
                        if (cursor == null) {
                            if (cursor != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        i += cursor.getCount();
                        if (!cursor.moveToFirst()) {
                            break;
                        }
                        do {
                            int columnIndex = cursor.getColumnIndex("_id");
                            int columnIndex2 = cursor.getColumnIndex("path");
                            if (!cursor.isNull(columnIndex) && !cursor.isNull(columnIndex2)) {
                                long j = cursor.getLong(columnIndex);
                                String string = cursor.getString(columnIndex2);
                                if (string == null || string.length() < 1 || !new File(string).exists()) {
                                    arrayList.add(Long.valueOf(j));
                                }
                            }
                        } while (cursor.moveToNext());
                        i2 += LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } while (cursor.getCount() > 0);
            if (cursor != null) {
                cursor.close();
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Long l = (Long) it.next();
                    Log.i("AllMediaScanner", "do delete meida id = " + l);
                    a.this.f3604a.b(l.longValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public class e extends c {

        /* renamed from: a, reason: collision with root package name */
        s f3609a;
        private int d;
        private int e;
        private int f;

        private e() {
            super(a.this, null);
            this.f = 0;
        }

        /* synthetic */ e(a aVar, com.nexstreaming.kinemaster.mediastore.v2.scanner.b bVar) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f3609a = new s("AllMediaScanner", true);
            this.f3609a.a(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            a.this.f3604a.b();
            a();
            a.this.f3604a.c();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            this.f3609a.a(1);
            a.this.i();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            a.this.h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            if (numArr.length > 0) {
                a.this.l.setProgress(numArr[0].intValue(), LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
            }
        }

        private void a() {
            a.this.f3604a.d();
            this.d = 0;
            for (File file : a.this.g) {
                if (!isCancelled()) {
                    a(file, false, true);
                } else {
                    return;
                }
            }
            this.e = this.d;
            this.d = 0;
            for (File file2 : a.this.g) {
                if (!isCancelled()) {
                    a(file2, false, false);
                } else {
                    return;
                }
            }
            a.this.f3604a.e();
        }

        private void a(File file, boolean z, boolean z2) {
            int i;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                long a2 = a.this.f3604a.a(file);
                if (new File(file, ".nomedia").exists()) {
                    z = true;
                }
                long j = -1;
                for (File file2 : listFiles) {
                    if (!isCancelled()) {
                        long lastModified = file2.lastModified();
                        if (lastModified > j) {
                            j = lastModified;
                        }
                        if (!file2.isDirectory() && lastModified <= a2) {
                            a.this.f3604a.d(file2);
                        } else if (!file2.isHidden()) {
                            File[] fileArr = a.this.h;
                            int length = fileArr.length;
                            while (true) {
                                if (i < length) {
                                    i = fileArr[i].equals(file2) ? 0 : i + 1;
                                } else if (file2.isDirectory()) {
                                    a(file2, z, z2);
                                } else {
                                    this.d++;
                                    if (!z2) {
                                        a.this.a(file2, z, null);
                                        int i2 = (this.d * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / this.e;
                                        if (this.f != i2) {
                                            this.f = i2;
                                            publishProgress(new Integer[]{Integer.valueOf(this.f)});
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (!z2) {
                    a.this.f3604a.a(file, j);
                }
            }
        }
    }

    public Task a(File file) {
        return a(file, false);
    }

    public Task a(File file, boolean z) {
        Task task = new Task();
        new com.nexstreaming.kinemaster.mediastore.v2.scanner.c(this, file, z, task).execute(new Void[0]);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* loaded from: classes.dex */
    public class d extends FileObserver {
        private final String b;

        public d(String str, int i) {
            super(str, i);
            this.b = str;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            switch (i) {
                case 8:
                case 128:
                    File file = new File(this.b, str);
                    if (!new File(file.getParent(), ".nomedia").exists()) {
                        a.this.a(file, false, null);
                        return;
                    }
                    return;
                case 64:
                case 512:
                    a.this.f3604a.b(new File(this.b, str));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllMediaScanner.java */
    /* renamed from: com.nexstreaming.kinemaster.mediastore.v2.scanner.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0072a extends ContentObserver {
        public C0072a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.i.removeCallbacks(a.this.B);
            a.this.i.postDelayed(a.this.B, 500L);
            super.onChange(z);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            a.this.i.removeCallbacks(a.this.B);
            a.this.i.postDelayed(a.this.B, 500L);
            super.onChange(z, uri);
        }
    }
}
