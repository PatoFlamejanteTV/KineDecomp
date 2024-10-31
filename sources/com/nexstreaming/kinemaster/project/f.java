package com.nexstreaming.kinemaster.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexProjectHeader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.keyczar.Keyczar;

/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3621a = VideoEditor.a();
    private File b;
    private String c;
    private final String d;
    private final Date e;
    private final Date f;
    private final int g;
    private final UUID h;
    private byte[] i;
    private Bitmap j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(File file, g gVar) {
        this(file);
    }

    private f(File file) {
        String message;
        NexProjectHeader nexProjectHeader;
        this.b = file;
        try {
            nexProjectHeader = VideoEditor.c(file);
            message = null;
        } catch (IOException e) {
            message = e.getMessage();
            nexProjectHeader = null;
        }
        this.d = message;
        if (nexProjectHeader != null) {
            this.e = nexProjectHeader.creationTime;
            this.f = nexProjectHeader.lastEditTime;
            this.g = nexProjectHeader.totalPlayTime;
            this.h = nexProjectHeader.projectUUID;
            this.i = nexProjectHeader.jpegThumbnail;
            return;
        }
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = null;
    }

    public boolean a(File file) {
        if (!this.b.renameTo(file)) {
            return false;
        }
        this.b = file;
        return true;
    }

    public File a() {
        return this.b;
    }

    public Date b() {
        return this.e;
    }

    public Date c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public Bitmap e() {
        if (this.j == null && this.i != null) {
            this.j = BitmapFactory.decodeByteArray(this.i, 0, this.i.length);
            this.i = null;
        }
        return this.j;
    }

    public String f() {
        if (this.c == null) {
            String name = this.b.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                name = name.substring(0, lastIndexOf);
            }
            this.c = g(name);
        }
        return this.c;
    }

    public void a(String str) {
        if (str != null) {
            this.c = str;
        }
    }

    public static ResultTask<f> a(Uri uri) {
        try {
            return b(new File(new URI(uri.toString())));
        } catch (URISyntaxException e) {
            return ResultTask.failedResultTask(Task.makeTaskError(e));
        }
    }

    public static ResultTask<f> b(File file) {
        ResultTask<f> resultTask = new ResultTask<>();
        new g(resultTask).execute(file);
        return resultTask;
    }

    public static ResultTask<List<f>> a(ProjectGalleryActivity.SortingMode sortingMode) {
        ResultTask<List<f>> resultTask = new ResultTask<>();
        new h(sortingMode, resultTask).execute(new Void[0]);
        return resultTask;
    }

    /* compiled from: ProjectInfo.java */
    /* renamed from: com.nexstreaming.kinemaster.project.f$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3622a = new int[ProjectGalleryActivity.SortingMode.values().length];

        static {
            try {
                f3622a[ProjectGalleryActivity.SortingMode.EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3622a[ProjectGalleryActivity.SortingMode.MAKE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3622a[ProjectGalleryActivity.SortingMode.NAME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(String str) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = stringBuffer.length();
        boolean z = false;
        int i2 = -1;
        while (i < length) {
            char charAt = stringBuffer.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                if (i2 == -1) {
                    i2 = i;
                }
            } else if (i2 > -1) {
                int i3 = 10 - (i - i2);
                while (i3 > 0) {
                    stringBuffer.insert(i2, '0');
                    i3--;
                    i++;
                    z = true;
                }
                i2 = -1;
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
        if (z) {
            return stringBuffer.toString();
        }
        return str;
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'Z') {
            return (c - 'A') + 10;
        }
        if (c >= 'a' && c <= 'z') {
            return (c - 'a') + 10;
        }
        return 0;
    }

    private static boolean b(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static File a(Context context) {
        String string = context.getResources().getString(R.string.default_project_name);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10000) {
                return null;
            }
            String str = string + (i2 > 0 ? " " + i2 : "");
            File c = c(str);
            if (b(str) || c.exists()) {
                i = i2 + 1;
            } else {
                return c;
            }
        }
    }

    public static boolean b(String str) {
        return c(str).exists() || d(str).exists() || new File(EditorGlobal.j(), new StringBuilder().append(str).append(f3621a).toString()).exists() || new File(EditorGlobal.j(), new StringBuilder().append(str).append(".nexvideoproject").toString()).exists();
    }

    public static File c(String str) {
        return new File(EditorGlobal.j(), e(str) + f3621a);
    }

    public static File d(String str) {
        return new File(EditorGlobal.j(), e(str) + ".nexvideoproject");
    }

    public static String c(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            name = name.substring(0, lastIndexOf);
        }
        return g(name);
    }

    public static String e(String str) {
        boolean z;
        byte[] bytes;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length * 2);
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt == '.' && i == 0) || charAt == '$' || "/\\*?:;'\"|<>`".indexOf(charAt) >= 0 || charAt < ' ' || charAt == 127) {
                if (z2) {
                    z = z2;
                } else {
                    z = true;
                    sb.append('$');
                }
                try {
                    bytes = Character.toString(charAt).getBytes(Keyczar.DEFAULT_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    bytes = Character.toString(charAt).getBytes();
                }
                for (byte b : bytes) {
                    if ((b & 255) <= 15) {
                        sb.append('0');
                    }
                    sb.append(Integer.toHexString(b & 255));
                }
                z2 = z;
            } else {
                if (z2) {
                    sb.append('$');
                    z2 = false;
                }
                sb.append(charAt);
            }
        }
        if (z2) {
            sb.append('$');
        }
        return sb.toString();
    }

    public static String f(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        return g(str);
    }

    public static String g(String str) {
        int i;
        boolean z;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.clear();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '$') {
                int i3 = i2;
                z = !z2;
                i = i3;
            } else if (z2 && i2 + 1 < length && b(charAt) && b(str.charAt(i2 + 1))) {
                allocate.put((byte) ((a(charAt) * 16) + a(str.charAt(i2 + 1))));
                i = i2 + 1;
                z = z2;
            } else {
                if (allocate.position() > 0) {
                    try {
                        sb.append(new String(allocate.array(), 0, allocate.position(), Keyczar.DEFAULT_ENCODING));
                    } catch (UnsupportedEncodingException e) {
                        sb.append(new String(allocate.array(), 0, allocate.position()));
                    }
                    allocate.clear();
                }
                sb.append(charAt);
                i = i2;
                z = z2;
            }
            z2 = z;
            i2 = i + 1;
        }
        if (allocate.position() > 0) {
            try {
                sb.append(new String(allocate.array(), 0, allocate.position(), Keyczar.DEFAULT_ENCODING));
            } catch (UnsupportedEncodingException e2) {
                sb.append(new String(allocate.array(), 0, allocate.position()));
            }
            allocate.clear();
        }
        return sb.toString();
    }
}
