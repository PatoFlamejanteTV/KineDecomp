package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.Gson;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
public class Da extends Fragment {

    /* renamed from: a */
    private AndroidMediaStoreProvider f23254a = null;

    /* renamed from: b */
    private int f23255b = 0;

    /* renamed from: c */
    private int f23256c = 6000;

    /* renamed from: d */
    private ArrayList<com.nexstreaming.kinemaster.mediastore.item.c> f23257d = null;

    /* renamed from: e */
    private b f23258e = null;

    /* compiled from: ShareIntentCheckFragment.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(Intent intent);

        void a(File file, MediaInfo mediaInfo, String str);
    }

    /* compiled from: ShareIntentCheckFragment.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i);

        void a(File file);

        void b(File file);
    }

    /* compiled from: ShareIntentCheckFragment.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(File file, com.nexstreaming.kinemaster.mediastore.item.c cVar);
    }

    /* compiled from: ShareIntentCheckFragment.java */
    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a */
        private MediaScannerConnection f23264a;

        /* renamed from: b */
        private File f23265b;

        /* renamed from: c */
        private MediaScannerConnection.MediaScannerConnectionClient f23266c;

        /* renamed from: d */
        private Context f23267d;

        /* renamed from: e */
        private MediaScannerConnection.MediaScannerConnectionClient f23268e = new Ea(this);

        public e(Context context, File file, MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient) {
            this.f23266c = null;
            this.f23267d = null;
            this.f23267d = context;
            this.f23265b = file;
            this.f23266c = mediaScannerConnectionClient;
            this.f23264a = new MediaScannerConnection(this.f23267d, this.f23268e);
            this.f23264a.connect();
        }
    }

    private void A() {
        this.f23256c = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("add_layer_def_duration", "4500"));
        this.f23254a = new AndroidMediaStoreProvider(getActivity());
        this.f23257d = new ArrayList<>();
        this.f23255b = 0;
    }

    public static /* synthetic */ int b(Da da) {
        int i = da.f23255b;
        da.f23255b = i - 1;
        return i;
    }

    public AndroidMediaStoreProvider z() {
        return this.f23254a;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() == null || !(getActivity() instanceof b)) {
            return;
        }
        this.f23258e = (b) getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(Da.class.getName());
        return a(layoutInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(getActivity().getIntent());
    }

    private void b(Intent intent) {
        KMIntentData kMIntentData;
        KMIntentData.Project project;
        List<KMIntentData.VisualClip> list;
        if (z() == null || intent == null || getActivity() == null) {
            return;
        }
        Intent intent2 = new Intent();
        String stringExtra = intent.getStringExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA);
        intent2.putExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA, stringExtra);
        if (stringExtra == null || (kMIntentData = (KMIntentData) new Gson().fromJson(stringExtra, KMIntentData.class)) == null || (list = (project = kMIntentData.project).visualClips) == null || list.size() <= 0) {
            return;
        }
        this.f23255b = project.visualClips.size();
        for (KMIntentData.VisualClip visualClip : project.visualClips) {
            if (visualClip != null) {
                a(Uri.parse(visualClip.path), new Ba(this, intent2));
            }
        }
    }

    private void c(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE")) {
            this.f23255b = 0;
            ClipData clipData = intent.getClipData();
            if (clipData == null || clipData.getItemCount() <= 0 || z() == null) {
                return;
            }
            this.f23255b = clipData.getItemCount();
            for (int i = 0; i < clipData.getItemCount(); i++) {
                a(clipData.getItemAt(i).getUri(), new va(this));
            }
        }
    }

    public void d(Intent intent) {
        intent.setAction(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT);
        b bVar = this.f23258e;
        if (bVar != null) {
            bVar.a(intent);
        }
    }

    public boolean f(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        b bVar;
        if (cVar != null && getActivity() != null) {
            r0 = cVar.g() == MediaSupportType.Supported;
            if (!r0 && (bVar = this.f23258e) != null) {
                bVar.a(null, null, cVar.g().getNotSupportedReason(getActivity()));
            }
        }
        return r0;
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.activity_wx_result, (ViewGroup) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity == 0 || !(activity instanceof b)) {
            return;
        }
        this.f23258e = (b) activity;
    }

    private void a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ((action == null || !action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) && !action.equals("android.intent.action.SEND") && !action.equals("android.intent.action.SEND_MULTIPLE")) {
                b bVar = this.f23258e;
                if (bVar != null) {
                    bVar.a(null, null, null);
                    return;
                }
                return;
            }
            if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                b(intent);
            } else if (action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE")) {
                c(intent);
            }
        }
    }

    private void a(Uri uri, d dVar) {
        String str;
        if (uri == null || dVar == null || getActivity() == null) {
            return;
        }
        try {
            Cursor query = getActivity().getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                int columnIndex = query.getColumnIndex("_data");
                query.moveToFirst();
                String string = query.getString(columnIndex);
                query.close();
                str = string;
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
                        i += it.next().length() + 1;
                        if (uri.getPath().length() > i) {
                            File file2 = new File(uri.getPath().substring(i));
                            if (file2.exists()) {
                                str = file2.getPath();
                                break;
                            }
                        }
                    }
                }
            }
            File file3 = new File(str);
            if (file3.exists()) {
                MediaStoreItemId a2 = AndroidMediaStoreProvider.a(file3);
                if (a2 != null && z().a(a2) != null) {
                    dVar.a(file3, z().a(a2));
                    return;
                }
                File c2 = EditorGlobal.c();
                c2.mkdirs();
                File file4 = new File(c2, file3.getName());
                if (file4.exists()) {
                    if (file4.length() == file3.length()) {
                        MediaStoreItemId a3 = AndroidMediaStoreProvider.a(file3);
                        if (a3 != null && z().a(a3) != null) {
                            dVar.a(file3, z().a(a3));
                            return;
                        }
                    } else {
                        file4.delete();
                    }
                }
                a(file3, file4);
                new e(getActivity(), file4, new wa(this, dVar));
                return;
            }
            throw new Exception("file not found ");
        } catch (Exception unused) {
            if (uri.toString().length() > 0 && uri.toString().charAt(0) == '@') {
                dVar.a(null, null);
                return;
            }
            String type = getActivity().getContentResolver().getType(uri);
            if (type != null) {
                if (type.contains(MessengerShareContentUtility.MEDIA_IMAGE) || type.contains("video")) {
                    a(uri, new Aa(this, dVar));
                    return;
                }
                return;
            }
            b bVar = this.f23258e;
            if (bVar != null) {
                bVar.a(null, null, uri.toString());
            }
        }
    }

    /* compiled from: ShareIntentCheckFragment.java */
    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Void, Float, File> {

        /* renamed from: a */
        private c f23259a;

        /* renamed from: b */
        private Uri f23260b;

        /* renamed from: c */
        private String f23261c = null;

        /* renamed from: d */
        private long f23262d = 0;

        /* renamed from: e */
        private Context f23263e;

        public a(Context context, Uri uri, c cVar) {
            this.f23259a = null;
            this.f23260b = null;
            this.f23263e = null;
            this.f23263e = context;
            this.f23260b = uri;
            this.f23259a = cVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public File doInBackground(Void... voidArr) {
            if (this.f23260b == null || this.f23261c == null) {
                return null;
            }
            File c2 = EditorGlobal.c();
            c2.mkdirs();
            File file = new File(c2, this.f23261c);
            if (file.exists()) {
                if (file.length() == this.f23262d) {
                    publishProgress(Float.valueOf(((float) file.length()) / ((float) file.length())));
                    return file;
                }
                file.delete();
            }
            if (!file.exists()) {
                this.f23259a.a(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    InputStream openInputStream = this.f23263e.getContentResolver().openInputStream(this.f23260b);
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
                            publishProgress(Float.valueOf(((float) j) / ((float) this.f23262d)));
                        } else {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            openInputStream.close();
                            break;
                        }
                    }
                } catch (FileNotFoundException unused) {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (IOException unused2) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } else {
                publishProgress(Float.valueOf(((float) file.length()) / ((float) file.length())));
            }
            return file;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            Cursor query = this.f23263e.getContentResolver().query(this.f23260b, null, null, null, null);
            if (query == null) {
                File file = new File(this.f23260b.getPath());
                this.f23261c = file.getPath();
                this.f23262d = file.length();
            } else {
                if (query.getCount() < 1) {
                    return;
                }
                int columnIndex = query.getColumnIndex("_display_name");
                int columnIndex2 = query.getColumnIndex("_size");
                query.moveToFirst();
                this.f23261c = query.getString(columnIndex);
                this.f23262d = query.getLong(columnIndex2);
                query.close();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Float... fArr) {
            super.onProgressUpdate(fArr);
            int floatValue = (int) (fArr[0].floatValue() * 100.0f);
            Log.e("ShareCheckFragment", "file update value " + this.f23261c + " = " + fArr[0]);
            Log.e("ShareCheckFragment", "file progress " + this.f23261c + " = " + floatValue);
            this.f23259a.a(floatValue);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(File file) {
            super.onPostExecute(file);
            this.f23259a.b(file);
        }
    }

    private static void a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
            try {
                fileChannel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                fileChannel2 = channel;
                th = th;
                fileChannel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
        try {
            fileChannel.transferFrom(channel, 0L, channel.size());
            if (channel != null) {
                channel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Throwable th3) {
            fileChannel2 = channel;
            th = th3;
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    private void a(Uri uri, c cVar) {
        if (uri == null || cVar == null || getActivity() == null) {
            return;
        }
        new a(getActivity(), uri, cVar).execute(new Void[0]);
    }
}
