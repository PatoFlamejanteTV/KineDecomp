package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.api.client.util.DateTime;
import com.google.api.services.drive.model.File;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.QueryParams;
import com.nexstreaming.kinemaster.mediastore.v2.a;
import com.nexstreaming.sdk2.nexsns.SNS;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
public class l implements com.nexstreaming.kinemaster.mediastore.v2.l {
    private static final a.InterfaceC0071a q = new t();
    private static final a.b r = new u();
    private final String b;
    private final com.nexstreaming.kinemaster.mediastore.v2.a c;
    private final MSID d;
    private String e;
    private com.nexstreaming.sdk2.nexsns.ab g;
    private SNS h;
    private DisplayMetrics i;
    private Activity j;
    private File k;
    private boolean l;
    private MediaStore o;
    private boolean f = false;
    private Map<MSID, MediaStoreItem> m = new HashMap();
    private boolean n = false;
    private GoogleApiClient.ConnectionCallbacks p = new m(this);
    private Paint s = new Paint();

    /* renamed from: a, reason: collision with root package name */
    Map<MSID, ResultTask<File>> f3586a = new ConcurrentHashMap();

    public static String a(String str) {
        return "GoogleDrive/" + str;
    }

    public l(Activity activity, com.nexstreaming.sdk2.nexsns.ab abVar, String str) {
        this.b = "GoogleDrive/" + str;
        this.k = new File(EditorGlobal.f(this.j), File.separator + this.b);
        if (!this.k.exists()) {
            this.k.mkdirs();
        }
        this.j = activity;
        this.e = str;
        this.i = activity.getResources().getDisplayMetrics();
        this.d = new MSID(this.b, "root");
        this.c = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, this.d);
        this.c.a(str);
        this.l = EditorGlobal.a(activity.getResources());
        this.g = abVar;
        this.h = this.g.c("grivedownload", this.e);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public String a() {
        return this.b;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public MediaStoreItem a(MSID msid) {
        return this.d.equals(msid) ? this.c : this.m.get(msid);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public ResultTask<MediaStoreItem> b(MSID msid) {
        ResultTask<com.google.api.services.drive.model.File> b;
        if (this.h != null && (b = ((com.nexstreaming.sdk2.nexsns.a) this.h).b(msid.getSimpleId())) != null) {
            ResultTask<MediaStoreItem> resultTask = new ResultTask<>();
            b.onResultAvailable(new y(this, resultTask)).onFailure((Task.OnFailListener) new x(this, resultTask));
            return resultTask;
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(MSID msid, QueryParams queryParams) throws Task.TaskErrorException {
        Comparator aaVar;
        e();
        ArrayList arrayList = new ArrayList();
        if (this.h != null) {
            ResultTask<List<com.google.api.services.drive.model.File>> a2 = ((com.nexstreaming.sdk2.nexsns.a) this.h).a(msid.getSimpleId());
            a2.makeWaitable();
            try {
                List<com.google.api.services.drive.model.File> awaitResult = a2.awaitResult();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= awaitResult.size()) {
                        break;
                    }
                    MediaStoreItem mediaStoreItem = this.m.get(new MSID(this.b, awaitResult.get(i2).getId()));
                    if (mediaStoreItem != null) {
                        if (queryParams.a(mediaStoreItem.b())) {
                            arrayList.add(mediaStoreItem);
                        }
                    } else {
                        MediaStoreItem a3 = a(awaitResult.get(i2));
                        if (a3 != null) {
                            this.m.put(a3.c(), a3);
                            if (queryParams.a(a3.b()) && queryParams != null) {
                                arrayList.add(a3);
                            }
                        }
                    }
                    i = i2 + 1;
                }
            } catch (Task.TaskErrorException e) {
                throw new Task.TaskErrorException(Task.makeTaskError(e.getTaskError().getMessage()), e);
            }
        }
        int i3 = queryParams.d() == QueryParams.SortOrder.DESC ? -1 : 1;
        switch (queryParams.c()) {
            case SIZE:
                aaVar = new z(this, i3);
                break;
            case DISPLAY_NAME:
                aaVar = new aa(this, i3);
                break;
            default:
                aaVar = new ab(this, i3);
                break;
        }
        Collections.sort(arrayList, aaVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaStoreItem a(com.google.api.services.drive.model.File file) {
        String mimeType = file.getMimeType();
        String title = file.getTitle();
        DateTime createdDate = file.getCreatedDate();
        String id = file.getId();
        file.getThumbnailLink();
        file.getWebContentLink();
        String g = this.h.g();
        if (mimeType.equals("application/vnd.google-apps.folder")) {
            com.nexstreaming.kinemaster.mediastore.v2.a a2 = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.FOLDER, this.b, id);
            a2.a(title);
            a2.a(createdDate.getValue());
            a2.b(createdDate.getValue());
            a2.a(false);
            a2.a(MediaStoreItem.MediaSupportType.Supported);
            return a2;
        }
        if (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/gif")) {
            com.nexstreaming.kinemaster.mediastore.v2.a a3 = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.IMAGE, this.b, id);
            a3.a(createdDate.getValue());
            a3.b(createdDate.getValue());
            a3.a(title);
            a3.c(file.getFileSize().longValue());
            a3.c(false);
            File.ImageMediaMetadata imageMediaMetadata = file.getImageMediaMetadata();
            if (imageMediaMetadata != null) {
                a3.a(imageMediaMetadata.getWidth().intValue(), imageMediaMetadata.getHeight().intValue());
            }
            Bundle a4 = a3.a(l.class);
            a4.putString("thmbunailLink", file.getThumbnailLink());
            a4.putString("downloadUrl", file.getDownloadUrl());
            a4.putLong("versionnumber", file.getVersion().longValue());
            a4.putString("webContentLink", file.getWebContentLink());
            a4.putString("oAuthToken", g);
            a3.a(MediaStoreItem.MediaSupportType.Supported);
            a3.a(q);
            java.io.File c = c(a3);
            if (c.exists()) {
                a3.b(c.getAbsolutePath());
                a3.a(false);
                return a3;
            }
            a3.a(true);
            return a3;
        }
        if (!mimeType.equals("video/mp4")) {
            return null;
        }
        com.nexstreaming.kinemaster.mediastore.v2.a a5 = com.nexstreaming.kinemaster.mediastore.v2.a.a(MediaItemType.VIDEO, this.b, id);
        a5.a(createdDate.getValue());
        a5.b(createdDate.getValue());
        a5.a(title);
        a5.b(file.getWebContentLink());
        a5.c(file.getFileSize().longValue());
        Bundle a6 = a5.a(l.class);
        a6.putString("thmbunailLink", file.getThumbnailLink());
        a6.putString("downloadUrl", file.getDownloadUrl());
        a6.putLong("versionnumber", file.getVersion().longValue());
        a6.putString("webContentLink", file.getWebContentLink());
        a6.putString("oAuthToken", g);
        a5.a(r);
        a5.a(q);
        java.io.File c2 = c(a5);
        if (c2.exists()) {
            a5.b(c2.getAbsolutePath());
            a5.a(false);
            return a5;
        }
        a5.a(MediaStoreItem.MediaSupportType.CheckAsync);
        a5.a(true);
        return a5;
    }

    private java.io.File c(MediaStoreItem mediaStoreItem) {
        String substring;
        Bundle a2 = mediaStoreItem.a(l.class);
        String a3 = mediaStoreItem.a(this.j);
        int lastIndexOf = a3.lastIndexOf(".");
        if (lastIndexOf < 0) {
            switch (mediaStoreItem.b()) {
                case VIDEO:
                    substring = "mp4";
                    break;
                case IMAGE:
                    substring = "jpg";
                    break;
                default:
                    substring = "unknown";
                    break;
            }
        } else {
            substring = a3.substring(lastIndexOf + 1);
            a3 = a3.substring(0, lastIndexOf);
        }
        return new java.io.File(this.k, a3 + "_" + a2.getLong("versionnumber", 1L) + "." + substring);
    }

    public void e() {
        if (!this.f) {
            this.h.f().onSuccess(new n(this)).onFailure(new ac(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public List<MediaStoreItem> a(QueryParams queryParams) {
        return Collections.singletonList(this.c);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public Bitmap a(MediaStoreItem mediaStoreItem, boolean z) {
        e();
        if (mediaStoreItem.b().equals(MediaItemType.FOLDER)) {
            if (this.d.equals(mediaStoreItem.c())) {
                return BitmapFactory.decodeResource(this.j.getResources(), R.drawable.panel_media_browser_googledrive, null);
            }
            return BitmapFactory.decodeResource(this.j.getResources(), R.drawable.panel_media_browser_default, null);
        }
        Environment.getExternalStorageDirectory().getAbsolutePath();
        Bundle a2 = mediaStoreItem.a(l.class);
        String string = a2.getString("thmbunailLink", null);
        Long valueOf = Long.valueOf(a2.getLong("versionnumber", 1L));
        String a3 = mediaStoreItem.a(this.j);
        int lastIndexOf = a3.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String str = a3.substring(0, lastIndexOf) + "_thumb_" + valueOf + ".jpg";
        } else {
            String str2 = a3 + "_thumb_" + valueOf + ".jpg";
        }
        if (string != null) {
            ResultTask<Bitmap> a4 = ((com.nexstreaming.sdk2.nexsns.a) this.h).a(mediaStoreItem.c().getSimpleId(), string);
            a4.makeWaitable();
            try {
                return a4.awaitResult();
            } catch (Task.TaskErrorException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public int a(MediaStoreItem mediaStoreItem) {
        return 1;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStoreItem mediaStoreItem, Task task) {
        if (this.f3586a.get(mediaStoreItem.c()) != null) {
            throw new RuntimeException("Duplicate download request");
        }
        com.nexstreaming.kinemaster.mediastore.v2.a aVar = (com.nexstreaming.kinemaster.mediastore.v2.a) mediaStoreItem;
        String string = mediaStoreItem.a(l.class).getString("downloadUrl", null);
        java.io.File c = c(mediaStoreItem);
        if (this.h != null) {
            ResultTask<java.io.File> a2 = ((com.nexstreaming.sdk2.nexsns.a) this.h).a(aVar.c().getSimpleId(), string, c.getAbsolutePath());
            this.f3586a.put(mediaStoreItem.c(), a2);
            a2.makeWaitable();
            a2.onResultAvailable(new r(this, aVar, task)).onProgress((Task.OnProgressListener) new q(this, task)).onFailure((Task.OnFailListener) new p(this, task, c)).onCancel((Task.OnTaskEventListener) new o(this, task));
            try {
                try {
                    a2.awaitResult();
                } finally {
                    this.f3586a.remove(mediaStoreItem.c());
                }
            } catch (Task.TaskErrorException e) {
                if (a2.didSignalEvent(Task.Event.CANCEL)) {
                    task.signalEvent(Task.Event.CANCEL);
                } else {
                    task.sendFailure(Task.makeTaskError(e.getMessage(), e));
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void a(MediaStore mediaStore) {
        this.o = mediaStore;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b() {
        this.o = null;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void b(MediaStoreItem mediaStoreItem) {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void c() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void d() {
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.l
    public void c(MSID msid) {
        ResultTask<java.io.File> resultTask = this.f3586a.get(msid);
        if (resultTask != null) {
            resultTask.cancel();
        }
    }

    public String f() {
        return this.e;
    }
}
