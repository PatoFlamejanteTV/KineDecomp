package c.d.b.a;

import android.util.Log;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Locale;

/* compiled from: ChipsetInfo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3575a = "a";

    /* renamed from: b, reason: collision with root package name */
    public static a f3576b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final String f3577c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3578d;

    /* renamed from: h, reason: collision with root package name */
    private final InterfaceC0013a f3582h;
    private String i;

    /* renamed from: e, reason: collision with root package name */
    private final String f3579e = NexEditor.a("ro.board.platform");

    /* renamed from: g, reason: collision with root package name */
    private final String f3581g = NexEditor.a("ro.product.board");

    /* renamed from: f, reason: collision with root package name */
    private final String f3580f = NexEditor.a("ro.mediatek.platform");

    /* compiled from: ChipsetInfo.java */
    /* renamed from: c.d.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0013a {
        String a();

        String b();

        String c();

        String d();

        String e();

        String f();

        String g();

        int h();

        String i();
    }

    /* compiled from: ChipsetInfo.java */
    /* loaded from: classes.dex */
    private static class b implements InterfaceC0013a {

        /* renamed from: a, reason: collision with root package name */
        private String f3583a;

        /* renamed from: b, reason: collision with root package name */
        private String f3584b;

        /* renamed from: c, reason: collision with root package name */
        private String f3585c;

        /* renamed from: d, reason: collision with root package name */
        private String f3586d;

        /* renamed from: e, reason: collision with root package name */
        private String f3587e;

        /* renamed from: f, reason: collision with root package name */
        private String f3588f;

        /* renamed from: g, reason: collision with root package name */
        private String f3589g;

        /* renamed from: h, reason: collision with root package name */
        private String f3590h;
        private int i;

        /* JADX WARN: Removed duplicated region for block: B:117:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        b() {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: c.d.b.a.a.b.<init>():void");
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String a() {
            return this.f3585c;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String b() {
            return this.f3589g;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String c() {
            return this.f3586d;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String d() {
            return this.f3588f;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String e() {
            return this.f3583a;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String f() {
            return this.f3584b;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String g() {
            return this.f3587e;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public int h() {
            return this.i;
        }

        @Override // c.d.b.a.a.InterfaceC0013a
        public String i() {
            return this.f3590h;
        }

        public String toString() {
            return "{ processor: " + this.f3583a + ", features: " + this.f3584b + ", implementer: " + this.f3585c + ", architecture: " + this.f3586d + ", variant: " + this.f3587e + ", part: " + this.f3588f + ", revision: " + this.f3589g + ", hardware: " + this.f3590h + " }";
        }
    }

    private a() {
        String str;
        String str2;
        String str3;
        String str4 = "ro.board.platform";
        String str5 = this.f3579e;
        if (str5 != null && str5.trim().equalsIgnoreCase("msm8916") && (str3 = this.f3581g) != null && str3.trim().equalsIgnoreCase("msm8939")) {
            str4 = "ro.product.board";
            str5 = "msm8939";
        }
        if (str5 != null && str5.trim().equalsIgnoreCase("msm8960") && (str2 = this.f3581g) != null && str2.trim().equalsIgnoreCase("8x30")) {
            str4 = "special";
            str5 = "MSM8x30n";
        }
        if (str5 != null && str5.trim().equalsIgnoreCase("exynos5") && (str = this.f3581g) != null && str.startsWith("universal") && !this.f3581g.startsWith("universal5")) {
            str5 = this.f3581g;
            str4 = "ro.product.board";
        }
        if (str5 == null || str5.trim().length() < 1) {
            str5 = NexEditor.a("ro.mediatek.platform");
            str4 = "ro.mediatek.platform";
        }
        if (str5 == null || str5.trim().length() < 1) {
            str5 = NexEditor.a("ro.hardware");
            str4 = "ro.hardware";
        }
        String str6 = "unknown";
        if (str5 == null || str5.trim().length() < 1) {
            str4 = "unknown";
        } else {
            str6 = str5;
        }
        this.f3577c = str6;
        this.f3578d = str4;
        this.f3582h = new b();
    }

    public String b() {
        return this.f3579e;
    }

    public String c() {
        return this.f3577c;
    }

    public String d() {
        if (this.i == null) {
            String g2 = this.f3582h.g();
            if (g2 != null && g2.length() > 0) {
                this.i = this.f3577c + "." + this.f3582h.h();
            } else {
                this.i = this.f3577c;
            }
        }
        return this.i;
    }

    public String e() {
        String lowerCase = d().toLowerCase(Locale.ENGLISH);
        return ((lowerCase.hashCode() == -1273098711 && lowerCase.equals("msm8974.2")) ? (char) 0 : (char) 65535) != 0 ? this.f3577c : "Qualcomm Snapdragon 800";
    }

    public InterfaceC0013a f() {
        return this.f3582h;
    }

    public String g() {
        return this.f3580f;
    }

    public String h() {
        return this.f3581g;
    }

    public String i() {
        return this.f3578d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str) {
        if (str != null && str.length() > 0) {
            try {
                if (str.toLowerCase().startsWith("0x")) {
                    return Integer.parseInt(str.substring(2), 16);
                }
                return Integer.parseInt(str, 10);
            } catch (NumberFormatException e2) {
                Log.e(f3575a, e2.getMessage(), e2);
            }
        }
        return 0;
    }
}
