package com.nexstreaming.kinemaster.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Aa;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexProjectHeader;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.ProjectAspectRatio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private static final String f21201a = VideoEditor.u();

    /* renamed from: b */
    private static final Executor f21202b = Executors.newCachedThreadPool();

    /* renamed from: c */
    private final int f21203c;

    /* renamed from: d */
    private final String f21204d;

    /* renamed from: e */
    private final Date f21205e;

    /* renamed from: f */
    private final Date f21206f;

    /* renamed from: g */
    private final UUID f21207g;

    /* renamed from: h */
    private byte[] f21208h;
    private Bitmap i;
    private File j;
    private String k;
    private b l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProjectInfo.java */
    /* loaded from: classes.dex */
    public static final class a extends Aa {
        private b i;

        /* synthetic */ a(Context context, InputStream inputStream, boolean z, b bVar, g gVar) {
            this(context, inputStream, z, bVar);
        }

        @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
        protected void a(Task.TaskError taskError) {
        }

        @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
        protected void a(NexTimeline nexTimeline) {
        }

        @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
        protected void b(C1780za c1780za) {
            if (c1780za != null) {
                ProjectAspectRatio projectRatio = c1780za.a().getProjectRatio();
                b bVar = this.i;
                if (bVar != null) {
                    bVar.a(projectRatio);
                }
            }
        }

        private a(Context context, InputStream inputStream, boolean z, b bVar) {
            super(context, inputStream, z);
            this.i = bVar;
        }
    }

    /* compiled from: ProjectInfo.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(ProjectAspectRatio projectAspectRatio);
    }

    public /* synthetic */ k(File file, g gVar) {
        this(file);
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'A';
        if (c2 < 'A' || c2 > 'Z') {
            c3 = 'a';
            if (c2 < 'a' || c2 > 'z') {
                return 0;
            }
        }
        return (c2 - c3) + 10;
    }

    private static boolean b(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return true;
        }
        if (c2 < 'A' || c2 > 'Z') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    public static String i(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = stringBuffer.length();
        int i = 0;
        int i2 = -1;
        boolean z = false;
        while (i < length) {
            char charAt = stringBuffer.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (i2 > -1) {
                    int i3 = 10 - (i - i2);
                    while (i3 > 0) {
                        stringBuffer.insert(i2, '0');
                        i++;
                        i3--;
                        z = true;
                    }
                    i2 = -1;
                }
            } else if (i2 == -1) {
                i2 = i;
            }
            i++;
        }
        if (i2 > -1) {
            int i4 = 10 - (length - i2);
            while (i4 > 0) {
                stringBuffer.insert(i2, '0');
                i4--;
                z = true;
            }
        }
        return z ? stringBuffer.toString() : str;
    }

    public Bitmap b() {
        byte[] bArr;
        if (this.i == null && (bArr = this.f21208h) != null) {
            this.i = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            this.f21208h = null;
        }
        return this.i;
    }

    public boolean c(File file) {
        if (!this.j.renameTo(file)) {
            return false;
        }
        this.j = file;
        return true;
    }

    public Date d() {
        return this.f21206f;
    }

    public File e() {
        return this.j;
    }

    public String f() {
        if (this.k == null) {
            String name = this.j.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                name = name.substring(0, lastIndexOf);
            }
            this.k = c(name);
        }
        return this.k;
    }

    public int g() {
        return this.f21203c;
    }

    public void h(String str) {
        if (str != null) {
            this.k = str;
        }
    }

    private k(File file) {
        String message;
        NexProjectHeader nexProjectHeader;
        this.l = null;
        this.j = file;
        try {
            nexProjectHeader = VideoEditor.c(file);
            message = null;
        } catch (IOException e2) {
            message = e2.getMessage();
            nexProjectHeader = null;
        }
        this.f21204d = message;
        if (nexProjectHeader != null) {
            this.f21205e = nexProjectHeader.creationTime;
            this.f21206f = nexProjectHeader.lastEditTime;
            this.f21203c = nexProjectHeader.totalPlayTime;
            this.f21207g = nexProjectHeader.projectUUID;
            this.f21208h = nexProjectHeader.jpegThumbnail;
            return;
        }
        this.f21205e = null;
        this.f21206f = null;
        this.f21203c = 0;
        this.f21207g = null;
    }

    public static String d(String str) {
        byte[] bytes;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length * 2);
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt != '.' || i != 0) && charAt != '$' && "/\\*?:;'\"|<>`".indexOf(charAt) < 0 && charAt >= ' ' && charAt != 127) {
                if (z) {
                    sb.append('$');
                    z = false;
                }
                sb.append(charAt);
            } else {
                if (!z) {
                    sb.append('$');
                    z = true;
                }
                try {
                    bytes = Character.toString(charAt).getBytes("UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    bytes = Character.toString(charAt).getBytes();
                }
                for (byte b2 : bytes) {
                    int i2 = b2 & 255;
                    if (i2 <= 15) {
                        sb.append('0');
                    }
                    sb.append(Integer.toHexString(i2));
                }
            }
        }
        if (z) {
            sb.append('$');
        }
        return sb.toString();
    }

    public static File e(String str) {
        return new File(EditorGlobal.o(), d(str) + ".nexvideoproject");
    }

    public static File g(String str) {
        return new File(EditorGlobal.o(), d(str) + f21201a);
    }

    public void a(b bVar) {
        this.l = bVar;
    }

    public Date c() {
        return this.f21205e;
    }

    public static ResultTask<k> a(Uri uri) {
        try {
            return a(new File(new URI(uri.toString())));
        } catch (URISyntaxException e2) {
            return ResultTask.failedResultTask(Task.makeTaskError(e2));
        }
    }

    public static String c(String str) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.clear();
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '$') {
                z = !z;
            } else if (z && (i = i2 + 1) < length && b(charAt) && b(str.charAt(i))) {
                allocate.put((byte) ((a(charAt) * 16) + a(str.charAt(i))));
                i2 = i;
            } else {
                if (allocate.position() > 0) {
                    try {
                        sb.append(new String(allocate.array(), 0, allocate.position(), "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                        sb.append(new String(allocate.array(), 0, allocate.position()));
                    }
                    allocate.clear();
                }
                sb.append(charAt);
            }
            i2++;
        }
        if (allocate.position() > 0) {
            try {
                sb.append(new String(allocate.array(), 0, allocate.position(), "UTF-8"));
            } catch (UnsupportedEncodingException unused2) {
                sb.append(new String(allocate.array(), 0, allocate.position()));
            }
            allocate.clear();
        }
        return sb.toString();
    }

    public static File b(Context context) {
        String string = EditorGlobal.t() ? "Demo Project" : context.getResources().getString(R.string.default_project_name);
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(i > 0 ? " " + i : "");
            String sb2 = sb.toString();
            File g2 = g(sb2);
            if (!f(sb2) && !g2.exists()) {
                return g2;
            }
        }
        return null;
    }

    public static ResultTask<k> a(File file) {
        ResultTask<k> resultTask = new ResultTask<>();
        new g(resultTask).execute(file);
        return resultTask;
    }

    public static boolean f(String str) {
        if (!g(str).exists() && !e(str).exists()) {
            if (!new File(EditorGlobal.o(), str + f21201a).exists()) {
                if (!new File(EditorGlobal.o(), str + ".nexvideoproject").exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String b(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            name = name.substring(0, lastIndexOf);
        }
        return c(name);
    }

    public static ResultTask<List<k>> a(ProjectGalleryActivity.SortingMode sortingMode) {
        ResultTask<List<k>> resultTask = new ResultTask<>();
        new i(sortingMode, resultTask).executeOnExecutor(f21202b, new Void[0]);
        return resultTask;
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        return c(str);
    }

    public void a(Context context) {
        File file = this.j;
        if (file != null) {
            try {
                new a(context, new FileInputStream(file), false, this.l, null).execute(new Void[0]);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
