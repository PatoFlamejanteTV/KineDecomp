package com.nexstreaming.kinemaster.mediastore.provider;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.FileList;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.QueryParams;
import com.nexstreaming.kinemaster.mediastore.RemoteMediaInfo;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.F;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.umeng.analytics.pro.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class GoogleDriveProvider implements F.b {

    /* renamed from: b, reason: collision with root package name */
    private final String f20966b;

    /* renamed from: c, reason: collision with root package name */
    private final String f20967c;

    /* renamed from: d, reason: collision with root package name */
    private final com.nexstreaming.kinemaster.mediastore.item.b f20968d;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<MediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c> f20969e;

    /* renamed from: f, reason: collision with root package name */
    private final Drive f20970f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f20972h;
    private GoogleAccountCredential i;
    private File j;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f20971g = Executors.newSingleThreadExecutor();
    private Map<MediaStoreItemId, ResultTask<File>> k = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Context f20965a = KineMasterApplication.m();

    /* loaded from: classes.dex */
    private class DownloadCancelException extends RuntimeException {
        private DownloadCancelException() {
        }

        /* synthetic */ DownloadCancelException(GoogleDriveProvider googleDriveProvider, u uVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void a(double d2);

        void onCancel();

        void onFailure(Exception exc);

        void onSuccess();
    }

    public GoogleDriveProvider(Activity activity, String str) {
        this.f20972h = activity;
        this.f20966b = str;
        this.f20967c = "GoogleDrive/" + str;
        this.f20968d = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.FOLDER, new MediaStoreItemId(this.f20967c, "root"));
        this.f20968d.a(str);
        this.f20969e = new ConcurrentHashMap<>();
        this.i = GoogleAccountCredential.a(activity, Collections.singleton(DriveScopes.DRIVE_READONLY)).a(new Account(str, "com.google"));
        this.f20970f = new Drive.Builder(AndroidHttp.a(), new JacksonFactory(), this.i).build();
        this.j = new File(EditorGlobal.e(this.f20965a), File.separator + this.f20967c);
        if (this.j.exists()) {
            return;
        }
        this.j.mkdirs();
    }

    private Set<String> d() {
        return PreferenceManager.getDefaultSharedPreferences(this.f20965a).getStringSet("com.kinemaster.cloud_folder_accts", new HashSet());
    }

    private io.reactivex.m<String> e() {
        return io.reactivex.m.a(new io.reactivex.o() { // from class: com.nexstreaming.kinemaster.mediastore.provider.a
            @Override // io.reactivex.o
            public final void a(io.reactivex.n nVar) {
                GoogleDriveProvider.this.a(nVar);
            }
        });
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public int a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        return 1;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public Bitmap a(com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(MediaStoreItemId mediaStoreItemId, QueryParams queryParams) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public ResultTask<com.nexstreaming.kinemaster.mediastore.item.c> b(MediaStoreItemId mediaStoreItemId) {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void b() {
        Set<String> d2 = d();
        if (d2.contains(this.f20966b)) {
            return;
        }
        d2.add(this.f20966b);
        a(d2);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F.b
    public String c() {
        return this.f20966b;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public String getProviderId() {
        return this.f20967c;
    }

    private com.bumptech.glide.h c(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        String string = cVar.a(GoogleDriveProvider.class).getString("thmbunailLink", null);
        com.bumptech.glide.h<Bitmap> a2 = com.bumptech.glide.c.b(this.f20965a).a();
        a2.a(string);
        a2.a((com.bumptech.glide.k<?, ? super Bitmap>) new com.bumptech.glide.load.resource.bitmap.f().b());
        return a2.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(com.nexstreaming.kinemaster.mediastore.item.b.f20910a, com.nexstreaming.kinemaster.mediastore.item.b.f20911b));
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a() {
        Set<String> d2 = d();
        d2.remove(this.f20966b);
        a(d2);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.bumptech.glide.h<?> b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (cVar.getType().equals(MediaItemType.FOLDER)) {
            if (this.f20968d.getId().equals(cVar.getId())) {
                return a(R.drawable.panel_media_browser_googledrive);
            }
            return a(R.drawable.panel_media_browser_default);
        }
        return c(cVar);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public com.nexstreaming.kinemaster.mediastore.item.c a(MediaStoreItemId mediaStoreItemId) {
        if (this.f20968d.getId().equals(mediaStoreItemId)) {
            return this.f20968d;
        }
        return this.f20969e.get(mediaStoreItemId);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public List<com.nexstreaming.kinemaster.mediastore.item.c> a(QueryParams queryParams) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20968d);
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void c(MediaStoreItemId mediaStoreItemId) {
        ResultTask<File> resultTask = this.k.get(mediaStoreItemId);
        if (resultTask != null) {
            resultTask.cancel();
        }
    }

    public Task<FileList> b(final String str) {
        return Tasks.a(this.f20971g, new Callable() { // from class: com.nexstreaming.kinemaster.mediastore.provider.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GoogleDriveProvider.this.a(str);
            }
        });
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    public void a(MediaStoreItemId mediaStoreItemId, final QueryParams queryParams, final F.d dVar, final F.c cVar) {
        final ArrayList arrayList = new ArrayList();
        if (mediaStoreItemId != null) {
            b(mediaStoreItemId.getSimpleId()).a(new OnSuccessListener() { // from class: com.nexstreaming.kinemaster.mediastore.provider.g
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GoogleDriveProvider.this.a(queryParams, arrayList, dVar, (FileList) obj);
                }
            }).a(new OnFailureListener() { // from class: com.nexstreaming.kinemaster.mediastore.provider.h
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GoogleDriveProvider.this.a(cVar, exc);
                }
            });
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0027. Please report as an issue. */
    public /* synthetic */ void a(QueryParams queryParams, ArrayList arrayList, F.d dVar, FileList fileList) {
        for (com.google.api.services.drive.model.File file : fileList.getFiles()) {
            String id = file.getId();
            com.nexstreaming.kinemaster.mediastore.item.b bVar = null;
            String mimeType = file.getMimeType();
            char c2 = 65535;
            switch (mimeType.hashCode()) {
                case -1487394660:
                    if (mimeType.equals("image/jpeg")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1184200201:
                    if (mimeType.equals("application/vnd.google-apps.folder")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -879267568:
                    if (mimeType.equals("image/gif")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -879258763:
                    if (mimeType.equals("image/png")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1331848029:
                    if (mimeType.equals("video/mp4")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                bVar = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.FOLDER, this.f20967c, id);
                bVar.c(false);
            } else if (c2 == 1 || c2 == 2 || c2 == 3) {
                bVar = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.IMAGE, this.f20967c, id);
                bVar.b(false);
                bVar.a(MediaSupportType.Supported);
                bVar.c(true);
            } else if (c2 == 4) {
                bVar = com.nexstreaming.kinemaster.mediastore.item.b.a(MediaItemType.VIDEO, this.f20967c, id);
                bVar.a(MediaSupportType.Supported);
                bVar.b(file.getWebContentLink());
                bVar.c(true);
            }
            if (bVar != null) {
                bVar.a(MediaSupportType.Supported);
                bVar.a(file.getName());
                bVar.b(file.size());
                Bundle a2 = bVar.a(GoogleDriveProvider.class);
                if (a2 != null) {
                    a2.putString("thmbunailLink", file.getThumbnailLink());
                }
                if (queryParams != null && queryParams.a(bVar.getType())) {
                    arrayList.add(bVar);
                    this.f20969e.put(bVar.getId(), bVar);
                }
            }
        }
        dVar.a(arrayList);
    }

    public /* synthetic */ void a(F.c cVar, Exception exc) {
        if (exc instanceof UserRecoverableAuthIOException) {
            this.f20972h.startActivityForResult(((UserRecoverableAuthIOException) exc).getIntent(), k.a.u);
        }
        cVar.onFailure();
    }

    private com.bumptech.glide.h a(int i) {
        com.bumptech.glide.h<Bitmap> a2 = com.bumptech.glide.c.b(this.f20965a).a().a(Integer.valueOf(i));
        a2.a((com.bumptech.glide.k<?, ? super Bitmap>) new com.bumptech.glide.load.resource.bitmap.f().b());
        return a2.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(com.nexstreaming.kinemaster.mediastore.item.b.f20910a, com.nexstreaming.kinemaster.mediastore.item.b.f20911b).a((com.bumptech.glide.load.j<Bitmap>) new f.a.a.a.c(R.drawable.panel_media_browser_folder_item_background_fill_mask)));
    }

    @Override // com.nexstreaming.kinemaster.mediastore.provider.F
    @SuppressLint({"CheckResult"})
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, final com.nexstreaming.app.general.task.Task task) {
        final String str = "https://www.googleapis.com/drive/v3/files/" + cVar.getId().getSimpleId() + "?alt=media";
        final com.nexstreaming.kinemaster.mediastore.item.b bVar = (com.nexstreaming.kinemaster.mediastore.item.b) cVar;
        int i = E.f20961a[cVar.getType().ordinal()];
        if (i == 1) {
            e().b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new io.reactivex.c.e() { // from class: com.nexstreaming.kinemaster.mediastore.provider.d
                @Override // io.reactivex.c.e
                public final void accept(Object obj) {
                    GoogleDriveProvider.this.a(bVar, str, task, (String) obj);
                }
            }, new io.reactivex.c.e() { // from class: com.nexstreaming.kinemaster.mediastore.provider.i
                @Override // io.reactivex.c.e
                public final void accept(Object obj) {
                    com.nexstreaming.app.general.task.Task.this.sendFailure(com.nexstreaming.app.general.task.Task.makeTaskError(((Throwable) obj).getMessage()));
                }
            });
        } else {
            if (i != 2) {
                return;
            }
            a(bVar, str, task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.nexstreaming.kinemaster.mediastore.item.b bVar, final String str, String str2, final com.nexstreaming.app.general.task.Task task) {
        Bundle a2 = bVar.a(GoogleDriveProvider.class);
        if (a2 != null) {
            a2.putString("downloadUrl", str);
            a2.putString("oAuthToken", str2);
            a(bVar).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.mediastore.provider.c
                @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
                public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                    GoogleDriveProvider.this.a(bVar, str, task, resultTask, event, (MediaSupportType) obj);
                }
            }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.mediastore.provider.b
                @Override // com.nexstreaming.app.general.task.Task.OnFailListener
                public final void onFail(com.nexstreaming.app.general.task.Task task2, Task.Event event, Task.TaskError taskError) {
                    com.nexstreaming.app.general.task.Task.this.sendFailure(taskError);
                }
            });
        }
    }

    public /* synthetic */ void a(com.nexstreaming.kinemaster.mediastore.item.b bVar, String str, com.nexstreaming.app.general.task.Task task, ResultTask resultTask, Task.Event event, MediaSupportType mediaSupportType) {
        if (!mediaSupportType.isNotSupported()) {
            a(bVar, str, task);
        } else if (mediaSupportType.isNotSupported()) {
            task.sendFailure(com.nexstreaming.app.general.task.Task.makeTaskError(mediaSupportType.getNotSupportedReason(this.f20965a)));
        } else {
            task.sendFailure(com.nexstreaming.app.general.task.Task.makeTaskError(this.f20965a.getResources().getString(R.string.download_failed)));
        }
    }

    private void a(com.nexstreaming.kinemaster.mediastore.item.b bVar, String str, com.nexstreaming.app.general.task.Task task) {
        File file = new File(this.j, bVar.c());
        ResultTask<File> a2 = a(bVar.getId().getSimpleId(), str, file.getAbsolutePath());
        a2.onResultAvailable(new y(this, bVar, task)).onProgress((Task.OnProgressListener) new w(this, task)).onFailure((Task.OnFailListener) new v(this, task, file)).onCancel((Task.OnTaskEventListener) new u(this, task));
        this.k.put(bVar.getId(), a2);
    }

    private void a(Set<String> set) {
        PreferenceManager.getDefaultSharedPreferences(this.f20965a).edit().putStringSet("com.kinemaster.cloud_folder_accts", set).apply();
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.google.api.services.drive.Drive$Files$List] */
    public /* synthetic */ FileList a(String str) throws Exception {
        return this.f20970f.files().list().setQ("'" + str + "' in parents and trashed=false and (mimeType='application/vnd.google-apps.folder' or mimeType contains 'video/mp4' or mimeType='image/jpeg' or mimeType='image/gif' or mimeType='image/png')").setFields2("files(id, mimeType, webContentLink, name, size, thumbnailLink)").setSpaces("drive").execute();
    }

    public /* synthetic */ void a(io.reactivex.n nVar) throws Exception {
        nVar.onNext(this.i.a());
        nVar.onComplete();
    }

    private ResultTask<MediaSupportType> a(com.nexstreaming.kinemaster.mediastore.item.b bVar) {
        ResultTask<MediaSupportType> resultTask = new ResultTask<>();
        if (!bVar.h()) {
            resultTask.sendResult(bVar.g());
            return resultTask;
        }
        Bundle a2 = bVar.a(GoogleDriveProvider.class);
        RemoteMediaInfo.a(a2.getString("downloadUrl"), (Map<String, String>) Collections.singletonMap("Authorization", "Bearer " + a2.getString("oAuthToken"))).onResultAvailable(new A(this, bVar, resultTask)).onFailure((Task.OnFailListener) new z(this, bVar, resultTask));
        return resultTask;
    }

    @SuppressLint({"StaticFieldLeak"})
    private ResultTask<File> a(String str, String str2, String str3) {
        String str4 = str3 + ".tmp";
        ResultTask<File> resultTask = new ResultTask<>();
        File file = new File(str3);
        File file2 = new File(str4);
        resultTask.setCancellable(true);
        if (file.exists()) {
            resultTask.sendResult(file);
            return resultTask;
        }
        try {
            new C(this, str, str2, new FileOutputStream(str4), resultTask, file2, file).executeOnExecutor(this.f20971g, null);
        } catch (IOException e2) {
            resultTask.sendFailure(new D(this, e2));
        }
        return resultTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, OutputStream outputStream, final ResultTask<File> resultTask, final a aVar) {
        try {
            MediaHttpDownloader mediaHttpDownloader = this.f20970f.files().get(str).getMediaHttpDownloader();
            if (mediaHttpDownloader == null) {
                mediaHttpDownloader = new MediaHttpDownloader(AndroidHttp.a(), this.f20970f.getRequestFactory().a());
            }
            mediaHttpDownloader.a(10485760);
            mediaHttpDownloader.a(new MediaHttpDownloaderProgressListener() { // from class: com.nexstreaming.kinemaster.mediastore.provider.e
                @Override // com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener
                public final void a(MediaHttpDownloader mediaHttpDownloader2) {
                    GoogleDriveProvider.this.a(resultTask, aVar, mediaHttpDownloader2);
                }
            });
            mediaHttpDownloader.a(new GenericUrl(str2), outputStream);
        } catch (DownloadCancelException unused) {
            aVar.onCancel();
        } catch (IOException e2) {
            aVar.onFailure(e2);
        }
    }

    public /* synthetic */ void a(ResultTask resultTask, a aVar, MediaHttpDownloader mediaHttpDownloader) throws IOException {
        if (!resultTask.isCancelRequested()) {
            int i = E.f20962b[mediaHttpDownloader.a().ordinal()];
            if (i == 1) {
                aVar.a(mediaHttpDownloader.b());
                return;
            }
            if (i == 2) {
                aVar.a(mediaHttpDownloader.b());
                return;
            } else if (i != 3) {
                aVar.onFailure(new Exception("UNKNOWN_ERROR"));
                return;
            } else {
                aVar.onSuccess();
                return;
            }
        }
        throw new DownloadCancelException(this, null);
    }
}
