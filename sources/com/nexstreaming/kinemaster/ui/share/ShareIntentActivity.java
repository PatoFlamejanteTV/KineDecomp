package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.Gson;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ShareIntentActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f4276a = ShareIntentActivity.class.getSimpleName();
    private AndroidMediaStoreProvider b = null;
    private int c = 0;
    private int d = 6000;
    private ArrayList<MediaStoreItem> e = null;
    private com.nexstreaming.kinemaster.ui.a.e f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i);

        void a(File file);

        void b(File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a(File file, MediaStoreItem mediaStoreItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(ShareIntentActivity shareIntentActivity) {
        int i = shareIntentActivity.c;
        shareIntentActivity.c = i - 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wx_result);
        a();
        a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void a() {
        this.d = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("add_layer_def_duration", "6000"));
        this.b = new AndroidMediaStoreProvider(this);
        this.e = new ArrayList<>();
        this.c = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            boolean z2 = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
            if (!z || !z2) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, R.id.reqperms);
                return;
            }
        }
        if (intent != null) {
            String action = intent.getAction();
            if ((action != null && action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) || action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE")) {
                KineMasterApplication.a().h();
                Task a2 = KineMasterApplication.a().c().a();
                if (a2 != null && a2.isRunning()) {
                    b(intent);
                    return;
                }
                if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                    e(intent);
                    return;
                } else {
                    if (action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE")) {
                        c(intent);
                        return;
                    }
                    return;
                }
            }
            b();
        }
    }

    private void b(Intent intent) {
        Task a2 = KineMasterApplication.a().c().a();
        if (a2 != null && a2.isRunning()) {
            long currentTimeMillis = System.currentTimeMillis();
            KMUsage.Media_Indexing_Start.logEvent("Activity", "ShareIntentActivity");
            if (this.f == null) {
                this.f = new e.a(this).a(false).a(R.string.indexing_media_title).c(R.string.indexing_media_message).a();
                a2.onProgress(new aw(this)).onComplete(new av(this, currentTimeMillis, intent)).onCancel(new at(this));
                if (getFragmentManager().getBackStackEntryCount() == 0 && !this.f.isShowing()) {
                    this.f.show();
                    return;
                }
                return;
            }
            if (!this.f.isShowing()) {
                this.f.show();
            }
        }
    }

    private void b() {
        a((String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        a.C0074a a2 = com.nexstreaming.kinemaster.ui.a.a.a(this).a(getString(R.string.rec_video_fail_formaterr)).a(new ay(this)).a(R.string.button_export_fail_ok, new ax(this));
        if (str != null) {
            a2.b(str);
        }
        a2.a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AndroidMediaStoreProvider c() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE")) {
            this.c = 0;
            ClipData clipData = intent.getClipData();
            com.nexstreaming.kinemaster.ui.a.e a2 = new e.a(this).a();
            if (clipData != null && clipData.getItemCount() > 0 && c() != null) {
                this.c = clipData.getItemCount();
                a2.h(0);
                a2.i(this.c);
                a2.show();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    a(clipData.getItemAt(i).getUri(), new az(this, a2));
                }
            }
        }
    }

    /* renamed from: com.nexstreaming.kinemaster.ui.share.ShareIntentActivity$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4277a = new int[MediaItemType.values().length];

        static {
            try {
                f4277a[MediaItemType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4277a[MediaItemType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4277a[MediaItemType.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private void a(Uri uri, c cVar) {
        String str;
        if (uri != null && cVar != null) {
            try {
                Cursor query = getContentResolver().query(uri, null, null, null, null);
                if (query != null) {
                    int columnIndex = query.getColumnIndex("_data");
                    query.moveToFirst();
                    str = query.getString(columnIndex);
                    query.close();
                } else {
                    List<String> pathSegments = uri.getPathSegments();
                    File file = new File(uri.getPath());
                    if (file.exists()) {
                        str = file.getPath();
                    } else {
                        Iterator<String> it = pathSegments.iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                str = null;
                                break;
                            }
                            int length = it.next().length() + 1 + i;
                            if (uri.getPath().length() > length) {
                                File file2 = new File(uri.getPath().substring(length));
                                if (file2.exists()) {
                                    str = file2.getPath();
                                    break;
                                }
                            }
                            i = length;
                        }
                    }
                }
                File file3 = new File(str);
                if (file3 != null && file3.exists()) {
                    MSID a2 = AndroidMediaStoreProvider.a(file3);
                    if (a2 != null) {
                        MediaStoreItem a3 = c().a(a2);
                        if (a3 != null) {
                            cVar.a(file3, a3);
                            return;
                        }
                        return;
                    }
                    KineMasterApplication.a().c().a(file3, true).onComplete(new ba(this, file3, cVar));
                    return;
                }
                throw new Exception("file not found ");
            } catch (Exception e) {
                e.printStackTrace();
                if (uri.toString().length() > 0 && uri.toString().charAt(0) == '@') {
                    cVar.a(null, null);
                    return;
                }
                String type = getContentResolver().getType(uri);
                if (type != null) {
                    if (type.contains("image") || type.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                        a(uri, new bc(this, cVar));
                        return;
                    }
                    return;
                }
                a(uri.toString());
            }
        }
    }

    private void a(Uri uri, b bVar) {
        if (uri != null && bVar != null) {
            new a(uri, bVar).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Intent intent) {
        EffectLibrary.a(this).b().onComplete(new bg(this, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Intent intent) {
        KMIntentData kMIntentData;
        if (c() != null && intent != null) {
            Intent intent2 = new Intent();
            String stringExtra = intent.getStringExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA);
            intent2.putExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA, stringExtra);
            if (stringExtra != null && (kMIntentData = (KMIntentData) new Gson().fromJson(stringExtra, KMIntentData.class)) != null) {
                KMIntentData.Project project = kMIntentData.project;
                if (project.visualClips != null && project.visualClips.size() > 0) {
                    this.c = project.visualClips.size();
                    for (KMIntentData.VisualClip visualClip : project.visualClips) {
                        if (visualClip != null) {
                            a(Uri.parse(visualClip.path), new au(this, intent2));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MediaStoreItem mediaStoreItem) {
        if (mediaStoreItem != null) {
            r0 = mediaStoreItem.p() == MediaStoreItem.MediaSupportType.Supported;
            if (!r0) {
                a(mediaStoreItem.p().getNotSupportedReason(this));
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Float, File> {
        private b b;
        private Uri c;
        private String d = null;
        private long e = 0;

        public a(Uri uri, b bVar) {
            this.b = null;
            this.c = null;
            this.c = uri;
            this.b = bVar;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            Cursor query = ShareIntentActivity.this.getContentResolver().query(this.c, null, null, null, null);
            int columnIndex = query.getColumnIndex("_display_name");
            int columnIndex2 = query.getColumnIndex("_size");
            query.moveToFirst();
            this.d = query.getString(columnIndex);
            this.e = query.getLong(columnIndex2);
            query.close();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public File doInBackground(Void... voidArr) {
            if (this.c == null) {
                return null;
            }
            File g = EditorGlobal.g();
            g.mkdirs();
            File file = new File(g, this.d);
            if (file.exists()) {
                if (file.length() == this.e) {
                    publishProgress(Float.valueOf(((float) file.length()) / ((float) file.length())));
                    return file;
                }
                file.delete();
            }
            if (!file.exists()) {
                this.b.a(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    InputStream openInputStream = ShareIntentActivity.this.getContentResolver().openInputStream(this.c);
                    byte[] bArr = new byte[2048];
                    long j = 0;
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read != -1) {
                            if (isCancelled()) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                openInputStream.close();
                                if (file.exists()) {
                                    file.delete();
                                }
                                return null;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j += read;
                            publishProgress(Float.valueOf(((float) j) / ((float) this.e)));
                        } else {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            openInputStream.close();
                            return file;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    if (file.exists()) {
                        file.delete();
                        return file;
                    }
                    return file;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    if (file.exists()) {
                        file.delete();
                        return file;
                    }
                    return file;
                }
            } else {
                publishProgress(Float.valueOf(((float) file.length()) / ((float) file.length())));
                return file;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Float... fArr) {
            super.onProgressUpdate(fArr);
            int floatValue = (int) (fArr[0].floatValue() * 100.0f);
            Log.e(ShareIntentActivity.f4276a, "file update value " + this.d + " = " + fArr[0]);
            Log.e(ShareIntentActivity.f4276a, "file progress " + this.d + " = " + floatValue);
            this.b.a(floatValue);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(File file) {
            super.onPostExecute(file);
            this.b.b(file);
        }
    }

    /* loaded from: classes.dex */
    public class d {
        private MediaScannerConnection b;
        private File c;
        private MediaScannerConnection.MediaScannerConnectionClient d;
        private MediaScannerConnection.MediaScannerConnectionClient e = new bh(this);

        public d(File file, MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient) {
            this.d = null;
            this.c = file;
            this.d = mediaScannerConnectionClient;
            this.b = new MediaScannerConnection(ShareIntentActivity.this, this.e);
            this.b.connect();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        boolean z2;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == R.id.reqperms) {
            int min = Math.min(strArr.length, iArr.length);
            int i2 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (i2 < min) {
                if (strArr[i2].equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    boolean z5 = z3;
                    z2 = iArr[i2] == 0;
                    z = z5;
                } else if (strArr[i2].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    z = iArr[i2] == 0;
                    z2 = z4;
                } else {
                    z = z3;
                    z2 = z4;
                }
                i2++;
                z4 = z2;
                z3 = z;
            }
            if (z4 && z3) {
                Intent intent = getIntent();
                if (intent != null) {
                    a(intent);
                    return;
                }
                return;
            }
            finish();
        }
    }
}
