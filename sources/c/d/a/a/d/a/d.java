package c.d.a.a.d.a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import com.nexstreaming.app.general.nexasset.assetpackage.InstallSourceType;
import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.service.download.k;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.general.util.P;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AssetInstallHelper.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a */
    private static final Executor f3551a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static d f3552b = null;

    /* renamed from: c */
    private h f3553c;

    /* renamed from: d */
    private NotificationManager f3554d;

    /* renamed from: e */
    private Context f3555e;

    /* renamed from: f */
    private ArrayList<InterfaceC1821j> f3556f = new ArrayList<>();

    /* compiled from: AssetInstallHelper.java */
    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Void, Void, Exception> {

        /* renamed from: a */
        final WeakReference<Context> f3557a;

        /* renamed from: b */
        InterfaceC1821j f3558b;

        /* renamed from: c */
        Bitmap f3559c;

        /* renamed from: d */
        Bitmap f3560d;

        /* renamed from: e */
        NotificationManager f3561e;

        /* renamed from: f */
        String f3562f;

        /* renamed from: g */
        private h f3563g;

        /* renamed from: h */
        c f3564h;
        Task i;
        private ArrayList<InterfaceC1821j> j;

        public /* synthetic */ a(Context context, InterfaceC1821j interfaceC1821j, Bitmap bitmap, Bitmap bitmap2, NotificationManager notificationManager, String str, h hVar, c cVar, ArrayList arrayList, Task task, c.d.a.a.d.a.b bVar) {
            this(context, interfaceC1821j, bitmap, bitmap2, notificationManager, str, hVar, cVar, arrayList, task);
        }

        private boolean b(String str) {
            return this.f3563g.c(str) != null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Exception doInBackground(Void... voidArr) {
            FileOutputStream fileOutputStream;
            File file = new File(a(this.f3558b.getAssetId()));
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        this.f3560d.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        c.d.a.a.d.a.c cVar = new c.d.a.a.d.a.c(this, this.f3558b);
                        if (!b(this.f3558b.getAssetId())) {
                            a(cVar, file);
                        }
                        Log.i("AssetInstallHelper", "install asset completed : asset = [" + this.f3558b + "]");
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return e;
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream;
                        new File(a(this.f3558b.a())).delete();
                        new File(a(this.f3558b.getAssetId())).delete();
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return e;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f3557a.get());
            builder.setContentTitle(this.f3558b.f()).setOngoing(true).setColor(this.f3557a.get().getResources().getColor(R.color.km_red)).setContentText(this.f3557a.get().getString(R.string.installing_assets)).setProgress(0, 0, true).setLargeIcon(this.f3559c).setSmallIcon(android.R.drawable.stat_sys_download);
            this.f3561e.notify(256, builder.build());
        }

        private a(Context context, InterfaceC1821j interfaceC1821j, Bitmap bitmap, Bitmap bitmap2, NotificationManager notificationManager, String str, h hVar, c cVar, ArrayList<InterfaceC1821j> arrayList, Task task) {
            this.f3557a = new WeakReference<>(context);
            this.f3558b = interfaceC1821j;
            this.f3559c = bitmap;
            this.f3560d = bitmap2;
            this.f3561e = notificationManager;
            this.f3562f = str;
            this.f3563g = hVar;
            this.f3564h = cVar;
            this.i = task;
            this.j = arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Exception exc) {
            super.onPostExecute(exc);
            this.f3561e.cancel(256);
            if (exc != null) {
                this.i.sendFailure(new b(this.f3557a.get().getString(R.string.asset_install_failed), R.string.asset_install_failed, exc));
                return;
            }
            com.nexstreaming.app.general.nexasset.assetpackage.b a2 = this.f3563g.a(this.f3558b.a());
            c cVar = this.f3564h;
            boolean z = (cVar == null || (cVar.isShowing() && this.f3564h.i(a2.getAssetIdx()))) ? false : true;
            if (this.j.size() > 0 || z) {
                this.j.add(0, this.f3558b);
                Intent intent = new Intent("com.nextreaming.kinemaster.asset.install.clear");
                Intent intent2 = new Intent("com.nextreaming.kinemaster.asset.install.clear");
                intent2.putExtra("open", true);
                PendingIntent broadcast = PendingIntent.getBroadcast(this.f3557a.get(), 0, intent, 134217728);
                PendingIntent broadcast2 = PendingIntent.getBroadcast(this.f3557a.get(), 1, intent2, 134217728);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f3557a.get());
                builder.setContentTitle(this.f3557a.get().getString(R.string.asset_install_completed)).setContentText(a(this.f3558b)).setColor(this.f3557a.get().getResources().getColor(R.color.km_red)).setAutoCancel(true).setNumber(this.j.size()).setGroup("AssetInstallHelper").setGroupSummary(true).setContentIntent(broadcast2).setDeleteIntent(broadcast).setSmallIcon(R.drawable.notification_icon);
                if (this.j.size() == 1) {
                    builder.setLargeIcon(this.f3560d);
                }
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle(this.f3557a.get().getString(R.string.asset_install_completed));
                for (int i = 0; i < 3; i++) {
                    if (this.j.size() > i) {
                        inboxStyle.addLine(a(this.j.get(i)));
                    }
                }
                if (this.j.size() > 3) {
                    inboxStyle.setSummaryText("+" + (this.j.size() - 3) + " more");
                }
                builder.setStyle(inboxStyle);
                this.f3561e.notify(272, builder.build());
            }
            Intent intent3 = new Intent("com.nextreaming.kinemaster.asset.install.completed");
            intent3.putExtra("asset_id", a2.getAssetId());
            intent3.putExtra("asset_idx", String.valueOf(a2.getAssetIdx()));
            this.f3557a.get().sendBroadcast(intent3);
            this.i.signalEvent(Task.Event.COMPLETE);
        }

        private String a(String str) {
            String str2 = this.f3557a.get().getFilesDir() + File.separator + "assets" + File.separator + "thumb";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str2 + File.separator + str;
        }

        private void a(InterfaceC1821j interfaceC1821j, File file) throws IOException {
            if (file == null && !file.exists()) {
                throw new FileNotFoundException("Not found asset thumbnail file");
            }
            File file2 = new File(a(interfaceC1821j.a()));
            if (file2.exists()) {
                if (this.f3563g.a(file2)) {
                    File file3 = new File(a(interfaceC1821j.getCategoryAliasName(), interfaceC1821j.getAssetId()));
                    try {
                        P.a(file2, file3);
                        this.f3563g.a(file3, file, interfaceC1821j);
                        file2.delete();
                        return;
                    } catch (IOException e2) {
                        Log.w("AssetInstallHelper", "installPackage unzip error", e2);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        throw new IOException(e2);
                    }
                }
                this.f3563g.a(file2, file, interfaceC1821j);
                return;
            }
            throw new FileNotFoundException("Not found asset file");
        }

        private String a(int i) {
            String str = this.f3557a.get().getFilesDir() + File.separator + "assets";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str + File.separator + i;
        }

        public String a(InterfaceC1821j interfaceC1821j) {
            return J.a(this.f3557a.get(), interfaceC1821j.j(), interfaceC1821j.f());
        }

        private String a(String str, String str2) {
            File file = new File(this.f3557a.get().getFilesDir() + File.separator + "assets" + File.separator + str + File.separator + str2 + "_unpack");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
    }

    /* compiled from: AssetInstallHelper.java */
    /* loaded from: classes2.dex */
    public static final class b implements Task.TaskError {

        /* renamed from: a */
        private final String f3565a;

        /* renamed from: b */
        final int f3566b;

        /* renamed from: c */
        final Exception f3567c;

        public b(String str, int i, Exception exc) {
            this.f3565a = str;
            this.f3566b = i;
            this.f3567c = exc;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return this.f3567c;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return context.getString(this.f3566b);
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return this.f3565a;
        }
    }

    /* compiled from: AssetInstallHelper.java */
    /* loaded from: classes2.dex */
    public interface c {
        boolean i(int i);

        boolean isShowing();
    }

    private d(Context context) {
        this.f3553c = h.a(context);
        this.f3554d = (NotificationManager) context.getSystemService("notification");
        this.f3555e = context;
    }

    public boolean b(int i) {
        return this.f3553c.a(i) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int c(int i) throws Exception {
        com.nexstreaming.app.general.nexasset.assetpackage.b a2 = this.f3553c.a(i);
        ?? r1 = 1;
        if (a2 != null) {
            if (a2.getInstallSourceType() == InstallSourceType.STORE) {
                File localPath = a2.getLocalPath();
                File file = new File(c(a2.getAssetId()));
                if (localPath.isDirectory()) {
                    a(localPath);
                } else {
                    localPath.delete();
                }
                file.delete();
                boolean delete = localPath.exists() ? localPath.delete() : true;
                this.f3553c.b(i);
                Intent intent = new Intent("com.nextreaming.kinemaster.asset.uninstall.completed");
                intent.putExtra("asset_id", a2.getAssetId());
                intent.putExtra("asset_idx", String.valueOf(a2.getAssetIdx()));
                this.f3555e.sendBroadcast(intent);
                r1 = delete;
            } else {
                throw new IllegalAccessException("Uninstall now allowed: " + i);
            }
        }
        return r1;
    }

    public boolean b(String str) {
        return this.f3553c.c(str) != null;
    }

    public static d a(Context context) {
        if (f3552b == null) {
            f3552b = new d(context);
        }
        return f3552b;
    }

    public void b() {
        ArrayList<InterfaceC1821j> arrayList = this.f3556f;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public Task a(InterfaceC1821j interfaceC1821j) {
        return a(interfaceC1821j, (c) null);
    }

    public Bitmap a(Bitmap bitmap) {
        int i;
        int i2;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int min = Math.min(width, height);
            if (width < height) {
                i2 = (height - width) / 2;
                i = 0;
            } else {
                i = (width - height) / 2;
                i2 = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, i2, min, min);
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint(1);
            paint.setColor(ResourcesCompat.getColor(this.f3555e.getResources(), R.color.km_red, null));
            Rect rect = new Rect(0, 0, min, min);
            float f2 = min / 8;
            canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(createBitmap, rect, rect, paint);
            return createBitmap2;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    private String c(String str) {
        String str2 = this.f3555e.getFilesDir() + File.separator + "assets" + File.separator + "thumb";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + str;
    }

    public Task a(InterfaceC1821j interfaceC1821j, c cVar) {
        Task task = new Task();
        KineMasterApplication.m().q().g().onResultAvailable(new c.d.a.a.d.a.b(this, interfaceC1821j, cVar, task)).onFailure(task);
        return task;
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public Task a(InterfaceC1821j interfaceC1821j, k kVar) {
        com.nexstreaming.app.general.nexasset.assetpackage.b a2 = this.f3553c.a(interfaceC1821j.a());
        if (a2 != null) {
            File localPath = a2.getLocalPath();
            if (localPath.exists() && !kVar.c().equals(localPath.getAbsolutePath())) {
                localPath.delete();
            }
            this.f3553c.b(interfaceC1821j.a());
            Intent intent = new Intent("com.nextreaming.kinemaster.asset.uninstall.completed");
            intent.putExtra("asset_id", a2.getAssetId());
            intent.putExtra("asset_idx", String.valueOf(a2.getAssetIdx()));
            this.f3555e.sendBroadcast(intent);
        }
        return a(interfaceC1821j);
    }

    public r a(String str) {
        Iterator<? extends r> it = this.f3553c.b(str).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public String a(int i) {
        String str = this.f3555e.getFilesDir() + File.separator + "assets";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + File.separator + i;
    }
}
