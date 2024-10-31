package com.nexstreaming.kinemaster.integration.fcpxml.adapter.items;

import android.content.Context;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileInfo.java */
/* loaded from: classes.dex */
public class b extends SourceItem {
    private static File r;
    public SourceItem.DisplayFormat A;
    public boolean B;
    public boolean C;
    private int D;
    private Context E;
    public String s;
    public String t;
    public SourceItem.MediaType u;
    public boolean v;
    public boolean w;
    public c x;
    public a y;
    public long z;

    /* compiled from: FileInfo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public long f20482a;

        /* renamed from: b */
        public long f20483b;

        /* renamed from: c */
        public long f20484c;

        public a(long j, long j2, long j3) {
            this.f20482a = j;
            this.f20483b = j2;
            this.f20484c = j3;
        }
    }

    /* compiled from: FileInfo.java */
    /* renamed from: com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b$b */
    /* loaded from: classes.dex */
    public static class C0105b {

        /* renamed from: a */
        private String f20485a;

        /* renamed from: b */
        private String f20486b;

        /* renamed from: c */
        private int f20487c;

        /* renamed from: d */
        private SourceItem.MediaType f20488d;

        /* renamed from: e */
        private boolean f20489e;

        /* renamed from: f */
        private boolean f20490f;

        /* renamed from: g */
        private c f20491g;

        /* renamed from: h */
        private a f20492h;
        private long i;
        private Context j;

        public C0105b(Context context) {
            this.j = context;
        }

        public C0105b a(String str) {
            this.f20486b = str;
            return this;
        }

        public C0105b b(String str) {
            this.f20485a = str;
            return this;
        }

        public C0105b a(int i) {
            this.f20487c = i;
            return this;
        }

        public C0105b b(boolean z) {
            this.f20489e = z;
            return this;
        }

        public C0105b a(SourceItem.MediaType mediaType) {
            this.f20488d = mediaType;
            return this;
        }

        public C0105b a(boolean z) {
            this.f20490f = z;
            return this;
        }

        public C0105b a(long j, long j2, long j3, SourceItem.PixelAspectRatio pixelAspectRatio, long j4) {
            long j5 = j2 == 0 ? 1280L : j2;
            long j6 = j3 == 0 ? 720L : j3;
            this.f20491g = new c(j == 0 ? 30L : j, j5, j6, pixelAspectRatio == null ? SourceItem.PixelAspectRatio.square : pixelAspectRatio, j4 == 0 ? 24L : j4);
            return this;
        }

        public C0105b a(long j, long j2, long j3) {
            this.f20492h = new a(j, j2, j3);
            return this;
        }

        public C0105b a(long j) {
            this.i = j;
            return this;
        }

        public b a() {
            if (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.c.a(this.f20486b)) {
                this.f20488d = SourceItem.MediaType.SOLID;
            } else if (this.f20488d == SourceItem.MediaType.IMAGE) {
                File file = new File(this.f20485a);
                if (!file.exists() || !file.canRead()) {
                    try {
                        this.f20485a = b.b(this.j);
                        this.f20486b = c.d.b.d.e.a.c(this.f20485a);
                        this.f20488d = SourceItem.MediaType.BGIMAGE;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return new b(this);
        }
    }

    /* compiled from: FileInfo.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public long f20493a;

        /* renamed from: b */
        public long f20494b;

        /* renamed from: c */
        public SourceItem.PixelAspectRatio f20495c;

        /* renamed from: d */
        public long f20496d;

        /* renamed from: e */
        public long f20497e;

        /* renamed from: f */
        public boolean f20498f;

        public c(long j, long j2, long j3, SourceItem.PixelAspectRatio pixelAspectRatio, long j4) {
            this.f20497e = j;
            this.f20493a = j2;
            this.f20494b = j3;
            this.f20495c = pixelAspectRatio;
            this.f20496d = j4;
            this.f20498f = this.f20497e != 30;
        }
    }

    public b(C0105b c0105b) {
        this.f20475b = c0105b.f20487c;
        this.s = c0105b.f20485a;
        this.t = c0105b.f20486b;
        this.u = c0105b.f20488d;
        this.w = c0105b.f20490f;
        this.v = c0105b.f20489e;
        this.x = c0105b.f20491g;
        this.y = c0105b.f20492h;
        this.C = false;
        this.z = c0105b.i;
        this.E = c0105b.j;
        if (this.v && this.x != null) {
            this.A = SourceItem.DisplayFormat.NDF;
            this.B = false;
        } else {
            this.A = SourceItem.DisplayFormat.DF;
            this.B = true;
        }
    }

    public static String b(Context context) throws IOException {
        if (r == null) {
            r = new File(context.getFilesDir(), ".km_bg");
            r.mkdirs();
        }
        File file = new File(r, "default_backgroud.jpg");
        if (!file.exists()) {
            InputStream open = context.getAssets().open("background.jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } finally {
                    fileOutputStream.close();
                }
            } finally {
                open.close();
            }
        }
        return file.getAbsolutePath();
    }

    public int a() {
        return this.D;
    }

    public void a(int i) {
        this.D = i;
    }
}
