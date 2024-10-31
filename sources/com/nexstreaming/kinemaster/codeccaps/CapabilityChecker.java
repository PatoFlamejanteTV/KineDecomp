package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.media.CamcorderProfile;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nexstreaming.kinemaster.editorwrapper.H264Level;
import com.nexstreaming.kinemaster.editorwrapper.H264Profile;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class CapabilityChecker {

    /* renamed from: a */
    private static int f20017a = 1;

    /* renamed from: b */
    private static final b f20018b = new C1729q();

    /* renamed from: c */
    private static int[] f20019c = {2160, 1440, 1080, 720, 540, 360};

    /* renamed from: d */
    private static int[] f20020d = {4, 2, 3, 1, 5, 6};

    /* renamed from: e */
    private static int[] f20021e = {1, 3, 2, 4, 5};

    /* renamed from: f */
    private static int[] f20022f = {4, 2, 3, 1, 5, 6, 8, 7, 10, 9};

    /* renamed from: g */
    private static int[] f20023g = {4, 2, 3, 1, 5, 6, 8, 7, 10, 9};
    private List<P> A;
    private int B;
    private File C;
    private long i;
    private ResultTask<u> l;
    private P m;
    private InterfaceC1716d n;
    private WeakReference<Activity> o;
    private boolean t;
    private boolean u;
    private ResultTask<P.b> x;

    /* renamed from: h */
    private Handler f20024h = new Handler();
    private boolean j = false;
    private boolean k = false;
    private List<File> p = new ArrayList();
    private SortedMap<Integer, Integer> q = new TreeMap(Collections.reverseOrder());
    private SortedMap<Integer, Integer> r = new TreeMap(Collections.reverseOrder());
    private SortedMap<Integer, Integer> s = new TreeMap(Collections.reverseOrder());
    private long v = 1000;
    private boolean w = false;
    private boolean y = false;
    private b z = f20018b;
    private a D = new a(null);

    /* loaded from: classes.dex */
    public enum TagType {
        ExportOnly,
        Preview,
        Export,
        Transcode
    }

    /* loaded from: classes.dex */
    public static class a implements u {

        /* renamed from: a */
        int f20025a;

        /* renamed from: b */
        int f20026b;

        /* renamed from: c */
        int f20027c;

        /* renamed from: d */
        int f20028d;

        /* renamed from: e */
        int f20029e;

        /* renamed from: f */
        int f20030f;

        /* renamed from: g */
        int f20031g;

        /* renamed from: h */
        int f20032h;
        int i;
        int j;
        int k;
        boolean l;
        boolean m;
        boolean n;
        List<P.b> o;
        private Map<Integer, Integer> p;
        private Map<Integer, Integer> q;
        private Map<Integer, Integer> r;

        private a() {
            this.f20025a = 0;
            this.f20026b = 0;
            this.f20027c = 0;
            this.f20028d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f20029e = 0;
            this.f20030f = 0;
            this.f20031g = 0;
            this.f20032h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = false;
            this.m = false;
            this.n = false;
            this.o = new ArrayList();
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public int d() {
            return this.f20025a;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public Map<Integer, Integer> e() {
            return this.r;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public int f() {
            return this.f20026b;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public c.d.b.a.b g() {
            int i = this.f20030f;
            return new c.d.b.a.b((i * 16) / 9, i);
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public c.d.b.a.b h() {
            int i = this.f20028d;
            return new c.d.b.a.b((i * 16) / 9, i);
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public List<P.b> i() {
            return this.o;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public int j() {
            return this.k;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public int k() {
            return this.j;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public c.d.b.a.b l() {
            int i = this.f20032h;
            return new c.d.b.a.b((i * 16) / 9, i);
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public c.d.b.a.b m() {
            int i = this.f20027c;
            return new c.d.b.a.b((i * 16) / 9, i);
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public c.d.b.a.b n() {
            int i = this.f20029e;
            return new c.d.b.a.b((i * 16) / 9, i);
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public Map<Integer, Integer> o() {
            return this.q;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public int p() {
            return this.i;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public Map<Integer, Integer> q() {
            return this.p;
        }

        public boolean r() {
            return this.n;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public c.d.b.a.b a() {
            int i = this.f20031g;
            if (i == 0) {
                int i2 = this.f20030f;
                return new c.d.b.a.b((i2 * 16) / 9, i2);
            }
            return new c.d.b.a.b((i * 16) / 9, i);
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public boolean b() {
            return this.m;
        }

        @Override // com.nexstreaming.kinemaster.codeccaps.u
        public boolean c() {
            return this.l;
        }

        /* synthetic */ a(C1729q c1729q) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void log(String str);
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final String f20033a;

        /* renamed from: b */
        public final TagType f20034b;

        /* renamed from: c */
        public final int f20035c;

        /* renamed from: d */
        public final int f20036d;

        /* renamed from: e */
        public final int f20037e;

        /* renamed from: f */
        public final H264Profile f20038f;

        public c(String str, TagType tagType, int i, int i2, int i3) {
            this(str, tagType, i, i2, i3, null);
        }

        c(String str, TagType tagType, int i, int i2, int i3, H264Profile h264Profile) {
            this.f20033a = str;
            this.f20034b = tagType;
            this.f20035c = i;
            this.f20036d = i2;
            this.f20037e = i3;
            this.f20038f = h264Profile;
        }
    }

    public CapabilityChecker(InterfaceC1716d interfaceC1716d) {
        this.n = interfaceC1716d;
    }

    private int c() {
        int[] iArr = {6, 5, 4};
        int[] iArr2 = {8, 6, 5, 4};
        if (Build.VERSION.SDK_INT >= 21) {
            iArr = iArr2;
        }
        int length = iArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (CamcorderProfile.hasProfile(i3)) {
                i = Math.max(i, i3 != 4 ? i3 != 5 ? i3 != 6 ? i3 != 8 ? 0 : 2160 : 1080 : 720 : 480);
            }
        }
        return i;
    }

    public void d() {
        this.m = null;
        this.f20024h.postDelayed(new t(this), this.v);
    }

    public void b() {
        if (!this.j || this.k || this.t) {
            return;
        }
        this.t = true;
        P p = this.m;
        if (p != null) {
            p.a();
        }
    }

    public static String b(String str, SortedMap<Integer, Integer> sortedMap) {
        String str2 = str != null ? "" + str + " (" + sortedMap.size() + ")\n" : "";
        loop0: while (true) {
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
                if (i == 0) {
                    str2 = str2 + "  ";
                }
                str2 = str2 + "  " + entry.getKey().intValue() + "p*" + entry.getValue().intValue();
                i++;
                if (i == 3) {
                    break;
                }
            }
            str2 = str2 + "\n";
        }
        return str2.endsWith("\n") ? str2.substring(0, str2.length() - 1) : str2;
    }

    public void a(b bVar) {
        if (bVar == null) {
            bVar = f20018b;
        }
        this.z = bVar;
    }

    private int a(String str, boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        int i = 0;
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder() == z) {
                int i2 = i;
                for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                    if (str.equals(str2)) {
                        MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str2).getVideoCapabilities();
                        int i3 = i2;
                        for (int i4 : f20019c) {
                            if (i4 > i3 && videoCapabilities.isSizeSupported((i4 * 16) / 9, i4)) {
                                i3 = i4;
                            }
                        }
                        i2 = i3;
                    }
                }
                i = i2;
            }
        }
        return i;
    }

    public ResultTask<u> a(Activity activity) {
        int i;
        int i2;
        int i3;
        int[] iArr;
        int[] iArr2;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr3;
        File file;
        int[] iArr4;
        String b2;
        if (!this.j) {
            this.j = true;
            this.l = new ResultTask<>();
            this.o = new WeakReference<>(activity);
            InterfaceC1716d interfaceC1716d = this.n;
            if (interfaceC1716d != null && (b2 = interfaceC1716d.b()) != null) {
                this.n.a(b2);
                this.n.a();
            }
            this.C = EditorGlobal.b();
            this.C.mkdirs();
            this.A = new ArrayList();
            int c2 = c();
            int a2 = a("video/avc", true);
            a("video/avc", false);
            int max = Math.max(c2, a2);
            for (int i8 : f20019c) {
                File file2 = new File(this.C, com.umeng.commonsdk.proguard.e.ar + i8 + "p.mp4");
                if (file2.exists()) {
                    file2.delete();
                }
                if (i8 <= max) {
                    this.p.add(file2);
                    this.A.add(P.a(new c("Export " + i8 + "p", TagType.ExportOnly, i8, 0, 0, H264Profile.AVCProfileHigh), 4600, file2.getAbsolutePath(), (i8 * 16) / 9, i8, 30, -1, H264Profile.AVCProfileHigh, H264Level.AVCLevel41));
                }
            }
            for (int i9 : f20019c) {
                File file3 = new File(this.C, com.umeng.commonsdk.proguard.e.ar + i9 + "p.mp4");
                if (file3.exists()) {
                    file3.delete();
                }
                if (i9 <= max) {
                    this.A.add(P.a(new c("Export BASELINE " + i9 + "p", TagType.ExportOnly, i9, 0, 0), 4600, file3.getAbsolutePath(), (i9 * 16) / 9, i9, 30, -1, null, null));
                }
            }
            int[] iArr5 = f20019c;
            int length = iArr5.length;
            int i10 = 0;
            while (true) {
                i = 1080;
                i2 = 720;
                i3 = SemanticAnnotations.SemanticType.ST_SPII_ID_VALUE;
                if (i10 >= length) {
                    break;
                }
                int i11 = iArr5[i10];
                if (i11 <= max) {
                    File file4 = new File(this.C, com.umeng.commonsdk.proguard.e.ar + i11 + "p.mp4");
                    if (i11 > 1200) {
                        iArr4 = f20021e;
                    } else if (i11 == 720) {
                        iArr4 = f20022f;
                    } else if (i11 == 1080) {
                        iArr4 = f20023g;
                    } else {
                        iArr4 = f20020d;
                    }
                    int length2 = iArr4.length;
                    int i12 = 0;
                    while (i12 < length2) {
                        int i13 = iArr4[i12];
                        StringBuilder sb = new StringBuilder();
                        int[] iArr6 = iArr5;
                        sb.append("Play ");
                        sb.append(i11);
                        sb.append("p (x");
                        sb.append(i13);
                        sb.append(")");
                        File file5 = file4;
                        int i14 = i11;
                        P a3 = P.a(new c(sb.toString(), TagType.Preview, i11, 0, i13), ((i13 * 400) + 350 + SemanticAnnotations.SemanticType.ST_TIMESTAMP_VALUE + 0) * 1);
                        int i15 = 0;
                        while (i15 < i13) {
                            a3.a(file5.getAbsolutePath(), ((i15 * 400) + 350) * 1);
                            i15++;
                            file5 = file5;
                        }
                        this.A.add(a3);
                        i12++;
                        i11 = i14;
                        file4 = file5;
                        iArr5 = iArr6;
                    }
                }
                i10++;
                iArr5 = iArr5;
            }
            int[] iArr7 = f20019c;
            int length3 = iArr7.length;
            int i16 = 0;
            while (i16 < length3) {
                int i17 = iArr7[i16];
                if (i17 <= max) {
                    File file6 = new File(this.C, com.umeng.commonsdk.proguard.e.ar + i17 + "p.mp4");
                    if (i17 > i3) {
                        iArr = f20021e;
                    } else if (i17 == i2) {
                        iArr = f20022f;
                    } else if (i17 == i) {
                        iArr = f20023g;
                    } else {
                        iArr = f20020d;
                    }
                    int[] iArr8 = iArr;
                    int length4 = iArr8.length;
                    int i18 = 0;
                    while (i18 < length4) {
                        int i19 = iArr8[i18];
                        if (i19 <= 1) {
                            iArr2 = iArr7;
                            i4 = max;
                            i5 = length3;
                            i6 = i18;
                            i7 = length4;
                            iArr3 = iArr8;
                            file = file6;
                        } else {
                            File file7 = this.C;
                            iArr2 = iArr7;
                            StringBuilder sb2 = new StringBuilder();
                            i4 = max;
                            sb2.append("edt");
                            sb2.append(i17);
                            sb2.append("p_x");
                            int i20 = i19 - 1;
                            sb2.append(i20);
                            i5 = length3;
                            sb2.append(".mp4");
                            File file8 = new File(file7, sb2.toString());
                            this.p.add(file8);
                            i6 = i18;
                            i7 = length4;
                            iArr3 = iArr8;
                            file = file6;
                            P a4 = P.a(new c("EncDec " + i17 + "p (x" + i20 + ") + enc x1", TagType.Export, i17, 0, i19), ((i19 * 400) + 350 + SemanticAnnotations.SemanticType.ST_TIMESTAMP_VALUE + 0) * 1, file8.getAbsolutePath(), (i17 * 16) / 9, i17, 30, -1, null, null);
                            for (int i21 = 0; i21 < i20; i21++) {
                                a4.a(file.getAbsolutePath(), ((i21 * 400) + 350) * 1);
                            }
                            this.A.add(a4);
                        }
                        i18 = i6 + 1;
                        iArr8 = iArr3;
                        file6 = file;
                        iArr7 = iArr2;
                        max = i4;
                        length3 = i5;
                        length4 = i7;
                    }
                }
                i16++;
                iArr7 = iArr7;
                max = max;
                length3 = length3;
                i = 1080;
                i2 = 720;
                i3 = SemanticAnnotations.SemanticType.ST_SPII_ID_VALUE;
            }
            this.B = this.A.size();
            this.i = System.nanoTime();
            d();
            return this.l;
        }
        throw new IllegalStateException();
    }

    public void a(boolean z) {
        this.y = z;
        ResultTask<P.b> resultTask = this.x;
        if (resultTask != null) {
            resultTask.cancel();
        }
    }
}
