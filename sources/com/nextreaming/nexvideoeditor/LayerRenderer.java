package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class LayerRenderer {
    private static int[] ap = new int[1];
    private static final float[] ax = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private q D;
    private q E;
    private w H;
    private v K;
    private q N;
    private q Q;
    private q T;
    private z W;
    private h Z;
    private Object aA;
    private Bitmap aB;
    private ac ac;
    private l af;
    private q ag;
    private RenderMode az;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float i;
    private float j;
    private float k;
    private Map<Bitmap, i> r;
    private Set<i> s;
    private Map<g, Integer> x;
    private Set<Integer> y;
    private float[] g = new float[16];
    private float h = 1.0f;
    private int l = 0;
    private aa[] m = new aa[16];
    private Map<Bitmap, i> n = new WeakHashMap();
    private Set<i> o = new HashSet();
    private Map<Bitmap, i> p = new WeakHashMap();
    private Set<i> q = new HashSet();
    private Map<g, Integer> t = new WeakHashMap();
    private Set<Integer> u = new HashSet();
    private Map<g, Integer> v = new WeakHashMap();
    private Set<Integer> w = new HashSet();
    private q z = new r();
    private q A = new r();
    private q B = new t();
    private q C = new t();
    private w F = new w();
    private w G = new w();
    private v I = new v();
    private v J = new v();
    private q L = new u();
    private q M = new u();
    private q O = new x();
    private q P = new x();
    private q R = new y();
    private q S = new y();
    private z U = new z();
    private z V = new z();
    private h X = new h();
    private h Y = new h();
    private ac aa = new ac();
    private ac ab = new ac();
    private l ad = new l();
    private l ae = new l();
    private RenderTarget ah = RenderTarget.Normal;
    private boolean ai = false;
    private boolean aj = false;
    private boolean ak = false;
    private boolean al = false;
    private boolean am = false;
    private boolean an = false;
    private boolean ao = false;
    private float[] aq = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private ColorMatrix ar = new ColorMatrix();
    private ColorMatrix as = new com.nextreaming.nexvideoeditor.b(this);
    private float[] at = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] au = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private FloatBuffer av = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private FloatBuffer aw = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private float[] ay = new float[16];
    private ColorMatrix aC = new ColorMatrix();

    /* renamed from: a, reason: collision with root package name */
    boolean f4763a = false;

    /* loaded from: classes.dex */
    public enum RenderTarget {
        Normal,
        Mask
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface q {
        void a(float f);

        void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

        void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);
    }

    /* loaded from: classes.dex */
    private interface s extends q {
        void a(float f, float f2, float f3);

        void a(float f, float f2, float f3, float f4);

        void a(int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public enum RenderMode {
        Preview(0),
        Export(1);

        public final int id;

        RenderMode(int i) {
            this.id = i;
        }
    }

    public float a() {
        return this.c;
    }

    public float b() {
        return this.d;
    }

    public float c() {
        return this.e;
    }

    public void a(float f2) {
        this.j = f2;
    }

    public void b(float f2) {
        this.k = f2;
    }

    public float d() {
        return this.j;
    }

    public float e() {
        return this.k;
    }

    public float f() {
        return this.f;
    }

    public Object g() {
        return this.aA;
    }

    public void a(Object obj) {
        this.aA = obj;
    }

    public void a(RenderTarget renderTarget) {
        this.ah = renderTarget;
        NexEditor a2 = EditorGlobal.a();
        if (a2 != null) {
            switch (renderTarget) {
                case Mask:
                    a2.c(w().id);
                    return;
                case Normal:
                    a2.d(w().id);
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public void a(boolean z2) {
        this.ai = z2;
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.aj = false;
            return;
        }
        this.aj = true;
        i c2 = c(bitmap);
        ((u) this.N).a(c2.f4776a);
        ((y) this.T).b(c2.f4776a);
        this.K.a(c2.f4776a);
        this.W.b(c2.f4776a);
    }

    public void b(boolean z2) {
        this.ak = z2;
    }

    public void c(boolean z2) {
        this.al = z2;
    }

    public int h() {
        return this.al ? 1 : 0;
    }

    public void a(int i2, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f3 * f3;
        float f9 = f2 * f2;
        float f10 = f9 - f8;
        float f11 = f8 + (f4 * f10);
        float f12 = f8 + (f10 * f6);
        float f13 = f7 - f5;
        float f14 = 1.0f - f7;
        q[] qVarArr = {this.D, this.Q, this.N, this.T};
        int i3 = (i2 >> 16) & 255;
        int i4 = (i2 >> 8) & 255;
        int i5 = (i2 >> 0) & 255;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < qVarArr.length) {
                s sVar = (s) qVarArr[i7];
                sVar.a(i3, i4, i5);
                sVar.a(f8, f11, f12, f9);
                sVar.a(f5, f13, f14);
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        int f4776a;
        int b;
        int c;
        int d;
        boolean e = false;

        public i(Bitmap bitmap) {
            LayerRenderer.z();
            this.b = bitmap.getWidth();
            this.c = bitmap.getHeight();
            this.d = bitmap.getGenerationId();
            GLES20.glGenTextures(1, LayerRenderer.ap, 0);
            LayerRenderer.z();
            this.f4776a = LayerRenderer.ap[0];
            GLES20.glActiveTexture(33984);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.f4776a);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10241, 9729);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10240, 9729);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10242, 33071);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10243, 33071);
            LayerRenderer.z();
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            if (GLES20.glGetError() != 0) {
                a(3553, 0, bitmap, 0);
                LayerRenderer.z();
            }
        }

        private static void a(int i, int i2, Bitmap bitmap, int i3) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            IntBuffer allocate = IntBuffer.allocate(width * height);
            bitmap.getPixels(allocate.array(), 0, width, 0, 0, width, height);
            int[] array = allocate.array();
            int length = array.length;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = array[i4];
                array[i4] = (i5 & (-16711936)) | ((16711680 & i5) >> 16) | ((i5 & 255) << 16);
            }
            GLES20.glTexImage2D(i, i2, 6408, width, height, i3, 6408, 5121, allocate);
        }

        public void a(Bitmap bitmap) {
            if (bitmap.getGenerationId() != this.d) {
                this.d = bitmap.getGenerationId();
                if (bitmap.getWidth() == this.b && bitmap.getHeight() == this.c) {
                    GLES20.glActiveTexture(33984);
                    LayerRenderer.z();
                    GLES20.glBindTexture(3553, this.f4776a);
                    LayerRenderer.z();
                    GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
                    LayerRenderer.z();
                    return;
                }
                this.b = bitmap.getWidth();
                this.c = bitmap.getHeight();
                GLES20.glActiveTexture(33984);
                LayerRenderer.z();
                GLES20.glBindTexture(3553, this.f4776a);
                LayerRenderer.z();
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                LayerRenderer.z();
            }
        }

        public void a() {
            if (!this.e) {
                LayerRenderer.ap[0] = this.f4776a;
                GLES20.glDeleteTextures(1, LayerRenderer.ap, 0);
                LayerRenderer.z();
                this.f4776a = 0;
                this.e = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class o {
        private int b = 0;

        o() {
        }

        public int a() {
            int i = this.b;
            this.b++;
            return i;
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        int f4774a;
        float b;
        float c;
        boolean d = false;

        public g(float f, float f2) {
            this.b = f;
            this.c = f2;
            GLES20.glGenTextures(1, LayerRenderer.ap, 0);
            LayerRenderer.z();
            this.f4774a = LayerRenderer.ap[0];
            GLES20.glActiveTexture(33984);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.f4774a);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10241, 9729);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10240, 9729);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10242, 33071);
            LayerRenderer.z();
            GLES20.glTexParameteri(3553, 10243, 33071);
            LayerRenderer.z();
            GLES20.glTexImage2D(3553, 0, 6408, (int) this.b, (int) this.c, 0, 6408, 5121, null);
            LayerRenderer.z();
        }

        public void a(float f, float f2, float f3, float f4) {
            if (f3 == this.b && f4 == this.c) {
                GLES20.glActiveTexture(33984);
                LayerRenderer.z();
                GLES20.glBindTexture(3553, this.f4774a);
                LayerRenderer.z();
                GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, (int) f, (int) f2, (int) f3, (int) f4);
                return;
            }
            this.b = f3;
            this.c = f4;
            GLES20.glActiveTexture(33984);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.f4774a);
            LayerRenderer.z();
            GLES20.glCopyTexImage2D(3553, 0, 6408, (int) f, (int) f2, (int) this.b, (int) this.c, 0);
        }

        public int a() {
            return this.f4774a;
        }

        public float b() {
            return this.b;
        }

        public float c() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class p {

        /* renamed from: a, reason: collision with root package name */
        private p f4783a;
        private String b = "";
        private String c = "";
        private String d = "";
        private String f = "";
        private String g = "";

        p() {
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.d = str;
        }

        public void c(String str) {
            this.f = str;
        }

        public void d(String str) {
            this.g = str;
        }

        public final String f() {
            return this.c;
        }

        public final String g() {
            return this.d;
        }

        public final String h() {
            return this.f;
        }

        public final String i() {
            return this.g;
        }

        public void a(p pVar) {
            this.f4783a = pVar;
        }

        public String a() {
            String str = this.f4783a.a() + f();
            if (f() != "") {
                return str + "();";
            }
            return str;
        }

        public String b() {
            String b = this.f4783a.b();
            if (g() != "") {
                return g() + "(" + b + ")";
            }
            return b;
        }

        public String c() {
            return this.f4783a.c() + h();
        }

        public final String j() {
            return c() + "\nvoid main(){\n" + a() + "\n}\n";
        }

        public String d() {
            return this.f4783a.d() + i();
        }

        public final String k() {
            return d() + "\nuniform highp float alpha_test_value_;\nvoid main(){\nhighp vec4 color = " + b() + ";\nif(color.a > 0.0) gl_FragColor = color;\nelse discard;\n}\n";
        }

        public void b(int i) {
        }

        public void a(int i) {
            b(i);
            this.f4783a.a(i);
        }

        public void a(o oVar) {
        }

        public void b(o oVar) {
            a(oVar);
            this.f4783a.b(oVar);
        }
    }

    /* loaded from: classes.dex */
    private class m extends p {
        private m() {
            super();
        }

        /* synthetic */ m(LayerRenderer layerRenderer, com.nextreaming.nexvideoeditor.b bVar) {
            this();
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String a() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String b() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String c() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String d() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends p {
        private int b;
        private int c;
        private int d;
        private int f;
        private int g;
        private FloatBuffer h;
        private FloatBuffer i;
        private int j;
        private float[] k;
        private float l;

        public void a(float f) {
            this.l = f;
        }

        public void a(FloatBuffer floatBuffer) {
            this.h = floatBuffer;
        }

        public void b(FloatBuffer floatBuffer) {
            this.i = floatBuffer;
        }

        public void b_(int i) {
            this.j = i;
        }

        public void a(float[] fArr) {
            this.k = fArr;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetAttribLocation(i, "a_position");
            this.c = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.f = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.d = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.g = GLES20.glGetUniformLocation(i, "u_alpha_test");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.j);
            LayerRenderer.z();
            GLES20.glUniform1i(this.d, a2);
            LayerRenderer.z();
            GLES20.glUniform1f(this.g, this.l);
            GLES20.glEnableVertexAttribArray(this.b);
            LayerRenderer.z();
            GLES20.glEnableVertexAttribArray(this.c);
            LayerRenderer.z();
            LayerRenderer.this.a(this.f, 1, true, this.k, 0);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.b, 4, 5126, false, 0, (Buffer) this.h);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) this.i);
            LayerRenderer.z();
        }

        a() {
            super();
            a("doBaseVertexWork");
            b("applyBase");
            c("//Base Vertex Block\nattribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nvarying highp vec2 v_texCoord;\nvoid doBaseVertexWork(){\n        v_texCoord = a_texCoord;\n        gl_Position = a_position * u_mvp_matrix;\n}");
            d("varying highp vec2 v_texCoord;\nuniform sampler2D u_textureSampler;\nuniform highp float u_alpha_test;\nhighp vec4 applyBase(){\n        highp vec4 color;\n        color.rgba = (texture2D(u_textureSampler, v_texCoord)).bgra;\n        if(color.a < u_alpha_test) return vec4(0,0,0,0);\n        return color;\n}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends p {
        private int b;
        private float[] c;

        public void a(float[] fArr) {
            this.c = fArr;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetUniformLocation(i, "u_colorconv");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            LayerRenderer.this.a(this.b, 1, false, this.c, 0);
            LayerRenderer.z();
        }

        e() {
            super();
            a("");
            b("applyColorConv");
            c("");
            d("uniform highp mat4 u_colorconv;\nhighp vec4 applyColorConv(highp vec4 color){\n        color = color * u_colorconv;\n        color = clamp(color, 0.0, 1.0);\n        return color;\n}");
        }
    }

    /* loaded from: classes.dex */
    private class n extends p {
        private int b;
        private float[] c;

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetUniformLocation(i, "u_overlaycolor");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            GLES20.glUniform4f(this.b, this.c[0], this.c[1], this.c[2], this.c[3]);
        }

        n() {
            super();
            this.c = new float[4];
            a("");
            b("applyOverlay");
            c("");
            d("//Overlay Block\nuniform highp vec4 u_overlaycolor;\nhighp vec4 applyOverlay(highp vec4 color){\n        color.rgb = color.rgb * (1.0 - u_overlaycolor.a) + u_overlaycolor.rgb * color.a;\n        return color;\n}");
            e();
        }

        public void e() {
            this.c[0] = 0.0f;
            this.c[1] = 0.0f;
            this.c[2] = 0.0f;
            this.c[3] = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ab extends p {

        /* renamed from: a, reason: collision with root package name */
        float f4767a;
        private int c;

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.c = GLES20.glGetUniformLocation(i, "u_alpha");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            GLES20.glUniform1f(this.c, this.f4767a);
        }

        ab() {
            super();
            a("");
            b("applyUserAlpha");
            c("");
            d("uniform highp float u_alpha;\nhighp vec4 applyUserAlpha(highp vec4 color){\n        return color * u_alpha;\n}");
            a(1.0f);
        }

        void a(float f) {
            this.f4767a = f;
        }
    }

    /* loaded from: classes.dex */
    private class d extends p {
        private int b;
        private int c;
        private int d;
        private int f;
        private float[] g;
        private float[] h;
        private float[] i;

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetUniformLocation(i, "u_keyvalue");
            this.c = GLES20.glGetUniformLocation(i, "u_division");
            this.d = GLES20.glGetUniformLocation(i, "u_strength");
            this.f = GLES20.glGetUniformLocation(i, "CKMaskOnOff");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            int h = LayerRenderer.this.h();
            GLES20.glUniform3f(this.b, this.g[0], this.g[1], this.g[2]);
            GLES20.glUniform4f(this.c, this.h[0], this.h[1], this.h[2], this.h[3]);
            GLES20.glUniform3f(this.d, this.i[0], this.i[1], this.i[2]);
            GLES20.glUniform1i(this.f, h);
        }

        d() {
            super();
            this.g = new float[3];
            this.h = new float[4];
            this.i = new float[3];
            a("");
            b("applyChromakey");
            c("");
            d("uniform highp vec3 u_keyvalue;\nuniform highp vec3 u_strength;\nuniform highp vec4 u_division;\nuniform int CKMaskOnOff;\nhighp float proportionalstep(highp float edge0, highp float edge1, highp float x){\nx = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\nreturn x;\n}\nhighp vec4 applyChromakey(highp vec4 color){\nconst highp mat4 rgbyuv = mat4(\n\t\t\t0.300, 0.589, 0.111, -0.003,\n\t\t\t-0.169, -0.332, 0.502, 0.502,\n\t\t\t0.499, -0.420, -0.079, 0.502,\n\t\t\t0.000, 0.000, 0.000, 1.000);\nconst highp mat4 yuvrgb = mat4(\n\t\t\t1.000, 0.000, 1.402, -0.701,\n\t\t\t1.000, -0.334, -0.714, 0.529,\n\t\t\t1.000, 1.772, 0.000, -0.886,\n\t\t\t0.000, 0.000, 0.000, 1.000);\nhighp vec4 yuv = color * rgbyuv;\nhighp vec4 yuv_key = vec4(u_keyvalue, 1.0) * rgbyuv;\nhighp float radius = length(vec2(yuv.gb) - vec2(yuv_key.gb));\nhighp float alpha = proportionalstep(u_division.x, u_division.y, radius) * u_strength.x\n+ proportionalstep(u_division.y, u_division.z, radius) * u_strength.y\n+ proportionalstep(u_division.z, u_division.w, radius) * u_strength.z;\nif(CKMaskOnOff == 1){\ncolor = color * 0.000001 + vec4(alpha, alpha, alpha, 1.0);}\nelse{\ncolor = color * alpha;}\n\t\treturn color;\n\t}");
            a(0, 255, 0);
            a(0.3f, 0.4f, 0.45f, 0.5f);
            a(0.05f, 0.3f, 0.65f);
        }

        public void a(int i, int i2, int i3) {
            this.g[0] = i / 255.0f;
            this.g[1] = i2 / 255.0f;
            this.g[2] = i3 / 255.0f;
        }

        public void a(float f, float f2, float f3, float f4) {
            this.h[0] = f;
            this.h[1] = f2;
            this.h[2] = f3;
            this.h[3] = f4;
        }

        public void a(float f, float f2, float f3) {
            this.i[0] = f;
            this.i[1] = f2;
            this.i[2] = f3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends p {

        /* renamed from: a, reason: collision with root package name */
        int f4777a;
        private int c;

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.f4777a = GLES20.glGetUniformLocation(i, "u_textureSampler_for_mask");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.c);
            LayerRenderer.z();
            GLES20.glUniform1i(this.f4777a, a2);
            LayerRenderer.z();
        }

        j() {
            super();
            a("maskWork");
            b("applyMask");
            c("\nvarying highp vec2 v_texCoord_for_mask;\nvoid maskWork() {\nv_texCoord_for_mask = gl_Position.xy / gl_Position.w * 0.5 + 0.5;\n}\n");
            d("\nvarying highp vec2 v_texCoord_for_mask;\nuniform sampler2D u_textureSampler_for_mask;\nhighp vec4 applyMask(highp vec4 color) {\nhighp vec4 mask = (texture2D(u_textureSampler_for_mask, v_texCoord_for_mask)).rgba;\ncolor *= mask.r;\nreturn color;\n}\n");
            LayerRenderer.this.d(1.0f);
        }

        void f_(int i) {
            this.c = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends p {

        /* renamed from: a, reason: collision with root package name */
        int f4773a;
        int b;
        float c;
        private int f;

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.f4773a = GLES20.glGetUniformLocation(i, "u_textureSampler_for_lut");
            this.b = GLES20.glGetUniformLocation(i, "u_strength_for_lut");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.f);
            LayerRenderer.z();
            GLES20.glUniform1i(this.f4773a, a2);
            LayerRenderer.z();
            GLES20.glUniform1f(this.b, this.c);
            LayerRenderer.z();
        }

        f() {
            super();
            this.f = 0;
            this.c = 1.0f;
            a("");
            b("applyLUT");
            c("");
            d("const highp float block_factor = 64.0;\n\tuniform sampler2D u_textureSampler_for_lut;\n\tuniform highp float u_strength_for_lut;\n\n\thighp vec4 applyLUT(highp vec4 color) {\n\t\thighp float block = (block_factor - 1.0) * color.b;\n\t\tcolor.r = (62.0 / 64.0) * color.r + 1.0 / 64.0;\n\t\thighp float t0 = 1.0 - (floor(block) + color.r) / block_factor;\n\t\thighp float t1 = 1.0 - (ceil(block) + color.r) / block_factor;\n\t\thighp vec4 color0 = texture2D(u_textureSampler_for_lut, vec2(color.g, t0)).rgba;\n\t\thighp vec4 color1 = texture2D(u_textureSampler_for_lut, vec2(color.g, t1)).rgba;\n\t\treturn vec4(mix(color, mix(color0, color1, fract(block)), u_strength_for_lut).rgb * color.a, color.a);\n\t}");
        }

        void e_(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends p {
        private int b;
        private int c;
        private int d;
        private int f;
        private int g;
        private int h;
        private FloatBuffer i;
        private FloatBuffer j;
        private int k;
        private int l;
        private float[] m;
        private float n;
        private int o;
        private float[] p;
        private int q;
        private float[] r;

        public void a(float f) {
            this.n = f;
        }

        public void a(FloatBuffer floatBuffer) {
            this.i = floatBuffer;
        }

        public void b(FloatBuffer floatBuffer) {
            this.j = floatBuffer;
        }

        public void c_(int i) {
            this.k = i;
        }

        public void c(int i) {
            this.l = i;
        }

        public void a(float[] fArr) {
            this.m = fArr;
        }

        public void a(float f, float f2) {
            this.p[0] = ((float) Math.floor(f * 30.0f)) + 1.0f;
            this.p[1] = ((float) Math.floor(f2 * 30.0f)) + 1.0f;
        }

        public void b(float f, float f2) {
            this.r[0] = f;
            this.r[1] = f2;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetAttribLocation(i, "a_position");
            this.c = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.g = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.d = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.f = GLES20.glGetUniformLocation(i, "u_maskSampler");
            this.h = GLES20.glGetUniformLocation(i, "u_alpha_test");
            this.o = GLES20.glGetUniformLocation(i, "u_block_size");
            this.q = GLES20.glGetUniformLocation(i, "u_texture_size");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            a(LayerRenderer.this.i() * 0.2f, LayerRenderer.this.i() * 0.2f);
            b(LayerRenderer.this.d(), LayerRenderer.this.e());
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.k);
            LayerRenderer.z();
            GLES20.glUniform1i(this.d, a2);
            LayerRenderer.z();
            int a3 = oVar.a();
            GLES20.glActiveTexture(33984 + a3);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.l);
            LayerRenderer.z();
            GLES20.glUniform1i(this.f, a3);
            LayerRenderer.z();
            GLES20.glUniform1f(this.h, this.n);
            GLES20.glEnableVertexAttribArray(this.b);
            LayerRenderer.z();
            GLES20.glEnableVertexAttribArray(this.c);
            LayerRenderer.z();
            LayerRenderer.this.a(this.g, 1, true, this.m, 0);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.b, 4, 5126, false, 0, (Buffer) this.i);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) this.j);
            LayerRenderer.z();
            GLES20.glUniform2f(this.o, this.p[0], this.p[1]);
            GLES20.glUniform2f(this.q, this.r[0], this.r[1]);
        }

        b() {
            super();
            this.p = new float[2];
            this.r = new float[2];
            a("doBaseVertexWork");
            b("applyBlurBase");
            c("attribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nuniform highp vec2 u_texture_size;\nuniform highp vec2 u_block_size;\nvarying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nvoid doBaseVertexWork(){\n       v_texCoord = a_texCoord;\n       v_blurTexCoords[ 0] = v_texCoord + vec2(-7.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 1] = v_texCoord + vec2(-6.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 2] = v_texCoord + vec2(-5.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 3] = v_texCoord + vec2(-4.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 4] = v_texCoord + vec2(-3.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 5] = v_texCoord + vec2(-2.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 6] = v_texCoord + vec2(-1.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 7] = v_texCoord + vec2( 1.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 8] = v_texCoord + vec2( 2.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 9] = v_texCoord + vec2( 3.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[10] = v_texCoord + vec2( 4.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[11] = v_texCoord + vec2( 5.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[12] = v_texCoord + vec2( 6.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[13] = v_texCoord + vec2( 7.0 / u_texture_size.x * u_block_size.x,0.0);\n       gl_Position = a_position * u_mvp_matrix;\n}");
            d("varying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nuniform highp vec2 u_texture_size;\nuniform sampler2D u_textureSampler;\nuniform sampler2D u_maskSampler;\nuniform highp vec2 u_block_size;\nuniform highp float u_alpha_test;\nhighp vec4 getTexColor(highp vec2 uv){\nhighp float dx = u_block_size.x * (1.0 / u_texture_size.x);\nhighp float dy = u_block_size.y * (1.0 / u_texture_size.y);\nhighp vec4 color = vec4(0.0);\nhighp vec2 coord = vec2(dx*floor(uv.x / dx) + 1. / u_texture_size.x, dy*floor(uv.y / dy) + 1. / u_texture_size.y);\ncolor.rgba = (texture2D(u_textureSampler, coord));\nreturn color;\n}\nhighp vec4 applyBlurBase(){\n       highp vec4 color;\n       highp vec4 mask = texture2D(u_maskSampler, v_texCoord);\n       if(mask.x == 0.0) return vec4(0, 0, 0, 0);\n       color.bgra = getTexColor(v_texCoord) * 0.159576912161;\n       color.bgra += getTexColor(v_blurTexCoords[ 0])*0.0044299121055113265;\n       color.bgra += getTexColor(v_blurTexCoords[1])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[2])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[3])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[4])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[5])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[6])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[7])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[8])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[9])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[10])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[11])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[12])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[13])*0.0044299121055113265;\n        if(color.a < u_alpha_test) return vec4(0,0,0,0);\n        return color.bgra;\n}\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends p {
        private int b;
        private int c;
        private int d;
        private int f;
        private int g;
        private int h;
        private FloatBuffer i;
        private FloatBuffer j;
        private int k;
        private int l;
        private float[] m;
        private float n;
        private int o;
        private float[] p;
        private int q;
        private float[] r;

        public void a(float f) {
            this.n = f;
        }

        public void a(FloatBuffer floatBuffer) {
            this.i = floatBuffer;
        }

        public void b(FloatBuffer floatBuffer) {
            this.j = floatBuffer;
        }

        public void d_(int i) {
            this.k = i;
        }

        public void c(int i) {
            this.l = i;
        }

        public void a(float[] fArr) {
            this.m = fArr;
        }

        public void a(float f, float f2) {
            this.p[0] = ((float) Math.floor(f * 30.0f)) + 1.0f;
            this.p[1] = ((float) Math.floor(f2 * 30.0f)) + 1.0f;
        }

        public void b(float f, float f2) {
            this.r[0] = f;
            this.r[1] = f2;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetAttribLocation(i, "a_position");
            this.c = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.g = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.d = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.f = GLES20.glGetUniformLocation(i, "u_maskSampler");
            this.h = GLES20.glGetUniformLocation(i, "u_alpha_test");
            this.o = GLES20.glGetUniformLocation(i, "u_block_size");
            this.q = GLES20.glGetUniformLocation(i, "u_texture_size");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            a(LayerRenderer.this.i() * 0.2f, LayerRenderer.this.i() * 0.2f);
            b(LayerRenderer.this.d(), LayerRenderer.this.e());
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.k);
            LayerRenderer.z();
            GLES20.glUniform1i(this.d, a2);
            LayerRenderer.z();
            int a3 = oVar.a();
            GLES20.glActiveTexture(33984 + a3);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.l);
            LayerRenderer.z();
            GLES20.glUniform1i(this.f, a3);
            LayerRenderer.z();
            GLES20.glUniform1f(this.h, this.n);
            GLES20.glEnableVertexAttribArray(this.b);
            LayerRenderer.z();
            GLES20.glEnableVertexAttribArray(this.c);
            LayerRenderer.z();
            LayerRenderer.this.a(this.g, 1, true, this.m, 0);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.b, 4, 5126, false, 0, (Buffer) this.i);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) this.j);
            LayerRenderer.z();
            GLES20.glUniform2f(this.o, this.p[0], this.p[1]);
            GLES20.glUniform2f(this.q, this.r[0], this.r[1]);
        }

        c() {
            super();
            this.p = new float[2];
            this.r = new float[2];
            a("doBaseVertexWork");
            b("applyBlurBase");
            c("attribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nuniform highp vec2 u_block_size;\nuniform highp vec2 u_texture_size;\nvarying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nvoid doBaseVertexWork(){\n       v_texCoord = a_texCoord;\n       v_blurTexCoords[ 0] = v_texCoord + vec2(0.0, -7.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 1] = v_texCoord + vec2(0.0, -6.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 2] = v_texCoord + vec2(0.0, -5.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 3] = v_texCoord + vec2(0.0, -4.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 4] = v_texCoord + vec2(0.0, -3.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 5] = v_texCoord + vec2(0.0, -2.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 6] = v_texCoord + vec2(0.0, -1.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 7] = v_texCoord + vec2(0.0,  1.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 8] = v_texCoord + vec2(0.0,  2.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 9] = v_texCoord + vec2(0.0,  3.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[10] = v_texCoord + vec2(0.0,  4.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[11] = v_texCoord + vec2(0.0,  5.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[12] = v_texCoord + vec2(0.0,  6.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[13] = v_texCoord + vec2(0.0,  7.0 / u_texture_size.y * u_block_size.y);\n       gl_Position = a_position * u_mvp_matrix;\n}");
            d("varying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nuniform highp vec2 u_texture_size;\nuniform sampler2D u_textureSampler;\nuniform sampler2D u_maskSampler;\nuniform highp vec2 u_block_size;\nuniform highp float u_alpha_test;\nhighp vec4 getTexColor(highp vec2 uv){\nhighp float dx = u_block_size.x * (1.0 / u_texture_size.x);\nhighp float dy = u_block_size.y * (1.0 / u_texture_size.y);\nhighp vec4 color = vec4(0.0);\nhighp vec2 coord = vec2(dx*floor(uv.x / dx) + 1. / u_texture_size.x, dy*floor(uv.y / dy) + 1. / u_texture_size.y);\ncolor.rgba = (texture2D(u_textureSampler, coord));\nreturn color;\n}\nhighp vec4 applyBlurBase(){\n       highp vec4 color;\n       highp vec4 mask = texture2D(u_maskSampler, v_texCoord);\n       if(mask.x == 0.0) return vec4(0, 0, 0, 0);\n       color.bgra = getTexColor(v_texCoord) * 0.159576912161;\n       color.bgra += getTexColor(v_blurTexCoords[ 0])*0.0044299121055113265;\n       color.bgra += getTexColor(v_blurTexCoords[1])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[2])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[3])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[4])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[5])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[6])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[7])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[8])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[9])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[10])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[11])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[12])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[13])*0.0044299121055113265;\n        if(color.a < u_alpha_test) return vec4(0,0,0,0);\n        return color.rgba;\n}\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends p {
        private int b;
        private int c;
        private int d;
        private int f;
        private int g;
        private int h;
        private FloatBuffer i;
        private FloatBuffer j;
        private int k;
        private int l;
        private float[] m;
        private float n;
        private int o;
        private float[] p;
        private int q;
        private float[] r;

        public void a(float f) {
            this.n = f;
        }

        public void a(FloatBuffer floatBuffer) {
            this.i = floatBuffer;
        }

        public void b(FloatBuffer floatBuffer) {
            this.j = floatBuffer;
        }

        public void g_(int i) {
            this.k = i;
        }

        public void c(int i) {
            this.l = i;
        }

        public void a(float[] fArr) {
            this.m = fArr;
        }

        public void a(float f, float f2) {
            if (f == 0.0f && f2 == 0.0f) {
                this.p[0] = 1.0f;
                this.p[1] = 1.0f;
            } else {
                this.p[0] = ((float) Math.floor(f * 49.0f)) + 1.0f;
                this.p[1] = ((float) Math.floor(f2 * 49.0f)) + 1.0f;
            }
        }

        public void b(float f, float f2) {
            this.r[0] = f;
            this.r[1] = f2;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
            this.b = GLES20.glGetAttribLocation(i, "a_position");
            this.c = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.g = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.d = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.f = GLES20.glGetUniformLocation(i, "u_maskSampler");
            this.h = GLES20.glGetUniformLocation(i, "u_alpha_test");
            this.o = GLES20.glGetUniformLocation(i, "u_block_size");
            this.q = GLES20.glGetUniformLocation(i, "u_texture_size");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
            a(LayerRenderer.this.i(), LayerRenderer.this.i());
            b(LayerRenderer.this.d(), LayerRenderer.this.e());
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.k);
            LayerRenderer.z();
            GLES20.glUniform1i(this.d, a2);
            LayerRenderer.z();
            int a3 = oVar.a();
            GLES20.glActiveTexture(33984 + a3);
            LayerRenderer.z();
            GLES20.glBindTexture(3553, this.l);
            LayerRenderer.z();
            GLES20.glUniform1i(this.f, a3);
            LayerRenderer.z();
            GLES20.glUniform1f(this.h, this.n);
            GLES20.glEnableVertexAttribArray(this.b);
            LayerRenderer.z();
            GLES20.glEnableVertexAttribArray(this.c);
            LayerRenderer.z();
            LayerRenderer.this.a(this.g, 1, true, this.m, 0);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.b, 4, 5126, false, 0, (Buffer) this.i);
            LayerRenderer.z();
            GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) this.j);
            LayerRenderer.z();
            GLES20.glUniform2f(this.o, this.p[0], this.p[1]);
            GLES20.glUniform2f(this.q, this.r[0], this.r[1]);
        }

        k() {
            super();
            this.p = new float[2];
            this.r = new float[2];
            a("doMosaicBaseVertexWork");
            b("mosaicBase");
            c("//Base Vertex Block\nattribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nvarying highp vec2 v_texCoord;\nvoid doMosaicBaseVertexWork(){\n        v_texCoord = a_texCoord;\n        gl_Position = a_position * u_mvp_matrix;\n}");
            d("varying highp vec2 v_texCoord;\nuniform sampler2D u_textureSampler;\nuniform sampler2D u_maskSampler;\nuniform highp float u_alpha_test;\nuniform highp vec2 u_block_size;\nuniform highp vec2 u_texture_size;\nhighp vec4 mosaicBase(){\n   highp vec2 uv = v_texCoord;\n   highp vec4 mask = texture2D(u_maskSampler, uv);\n   if(mask.x == 0.0) return vec4(0, 0, 0, 0);\n   highp float dx = u_block_size.x * (1.0 / u_texture_size.x);\n   highp float dy = u_block_size.y * (1.0 / u_texture_size.y);\n   highp vec2 coord = vec2(dx*floor(uv.x / dx) + 1. / u_texture_size.x, dy*floor(uv.y / dy) + 1. / u_texture_size.y);\n   highp vec4 color = texture2D(u_textureSampler, coord);\n   if(color.a < u_alpha_test) return vec4(0,0,0,0);\n   return color;\n}");
        }
    }

    public void c(float f2) {
        this.i = f2;
    }

    public float i() {
        return this.i;
    }

    /* loaded from: classes.dex */
    private class r implements q {

        /* renamed from: a, reason: collision with root package name */
        a f4784a;
        n b;
        e c;
        ab d;
        private int f;

        r() {
            this.f4784a = new a();
            this.c = new e();
            this.b = new n();
            this.d = new ab();
            this.f4784a.a(new m(LayerRenderer.this, null));
            this.c.a(this.f4784a);
            this.b.a(this.c);
            this.d.a(this.b);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.d.j());
            int a3 = a(35632, this.d.k());
            this.f = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f, a2);
            GLES20.glAttachShader(this.f, a3);
            GLES20.glLinkProgram(this.f);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f));
            this.d.a(this.f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4784a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f == 0) {
                a();
            }
            GLES20.glUseProgram(this.f);
            this.f4784a.a(floatBuffer);
            this.f4784a.b(floatBuffer2);
            this.f4784a.b_(i);
            this.c.a(fArr2);
            this.f4784a.a(fArr);
            this.d.a(f);
            this.d.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* loaded from: classes.dex */
    private class t implements s {

        /* renamed from: a, reason: collision with root package name */
        a f4785a;
        n b;
        ab c;
        e d;
        d e;
        private int g;

        t() {
            this.f4785a = new a();
            this.e = new d();
            this.d = new e();
            this.b = new n();
            this.c = new ab();
            this.f4785a.a(new m(LayerRenderer.this, null));
            this.e.a(this.f4785a);
            this.d.a(this.e);
            this.b.a(this.d);
            this.c.a(this.b);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        private void a() {
            int a2 = a(35633, this.c.j());
            int a3 = a(35632, this.c.k());
            this.g = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.g, a2);
            GLES20.glAttachShader(this.g, a3);
            GLES20.glLinkProgram(this.g);
            GLES20.glGetProgramInfoLog(this.g);
            this.c.a(this.g);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.e.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3, float f4) {
            this.e.a(f, f2, f3, f4);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3) {
            this.e.a(f, f2, f3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4785a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.g == 0) {
                a();
            }
            GLES20.glUseProgram(this.g);
            this.f4785a.a(floatBuffer);
            this.f4785a.b(floatBuffer2);
            this.f4785a.b_(i);
            this.d.a(fArr2);
            this.f4785a.a(fArr);
            this.c.a(f);
            this.c.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* loaded from: classes.dex */
    private class u implements s {

        /* renamed from: a, reason: collision with root package name */
        a f4786a;
        e b;
        n c;
        ab d;
        d e;
        f f;
        private int h;

        u() {
            this.f4786a = new a();
            this.e = new d();
            this.b = new e();
            this.c = new n();
            this.d = new ab();
            this.f = new f();
            this.f4786a.a(new m(LayerRenderer.this, null));
            this.e.a(this.f4786a);
            this.b.a(this.e);
            this.c.a(this.b);
            this.d.a(this.c);
            this.f.a(this.d);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        private void a() {
            int a2 = a(35633, this.f.j());
            int a3 = a(35632, this.f.k());
            this.h = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.h, a2);
            GLES20.glAttachShader(this.h, a3);
            GLES20.glLinkProgram(this.h);
            GLES20.glGetProgramInfoLog(this.h);
            this.f.a(this.h);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.e.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3, float f4) {
            this.e.a(f, f2, f3, f4);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3) {
            this.e.a(f, f2, f3);
        }

        public void a(int i) {
            this.f.e_(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4786a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.h == 0) {
                a();
            }
            GLES20.glUseProgram(this.h);
            this.f4786a.a(floatBuffer);
            this.f4786a.b(floatBuffer2);
            this.f4786a.b_(i);
            this.b.a(fArr2);
            this.f4786a.a(fArr);
            this.d.a(f);
            this.f.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* loaded from: classes.dex */
    private class x implements s {

        /* renamed from: a, reason: collision with root package name */
        a f4789a;
        e b;
        n c;
        ab d;
        j e;
        d f;
        private int h;

        x() {
            this.f4789a = new a();
            this.b = new e();
            this.c = new n();
            this.d = new ab();
            this.e = new j();
            this.f = new d();
            this.f4789a.a(new m(LayerRenderer.this, null));
            this.f.a(this.f4789a);
            this.b.a(this.f);
            this.c.a(this.b);
            this.d.a(this.c);
            this.e.a(this.d);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.f.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3, float f4) {
            this.f.a(f, f2, f3, f4);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3) {
            this.f.a(f, f2, f3);
        }

        public void a(int i) {
            this.e.f_(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.e.j());
            int a3 = a(35632, this.e.k());
            this.h = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.h, a2);
            GLES20.glAttachShader(this.h, a3);
            GLES20.glLinkProgram(this.h);
            Log.e("error", GLES20.glGetProgramInfoLog(this.h));
            this.e.a(this.h);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4789a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.h == 0) {
                a();
            }
            GLES20.glUseProgram(this.h);
            LayerRenderer.z();
            this.f4789a.a(floatBuffer);
            this.f4789a.b(floatBuffer2);
            this.f4789a.b_(i);
            this.b.a(fArr2);
            this.f4789a.a(fArr);
            this.d.a(f);
            this.e.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* loaded from: classes.dex */
    private class y implements s {

        /* renamed from: a, reason: collision with root package name */
        a f4790a;
        e b;
        n c;
        ab d;
        j e;
        d f;
        f g;
        private int i;

        y() {
            this.f4790a = new a();
            this.b = new e();
            this.c = new n();
            this.d = new ab();
            this.g = new f();
            this.e = new j();
            this.f = new d();
            this.f4790a.a(new m(LayerRenderer.this, null));
            this.f.a(this.f4790a);
            this.b.a(this.f);
            this.c.a(this.b);
            this.d.a(this.c);
            this.g.a(this.d);
            this.e.a(this.g);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.f.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3, float f4) {
            this.f.a(f, f2, f3, f4);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f, float f2, float f3) {
            this.f.a(f, f2, f3);
        }

        public void a(int i) {
            this.e.f_(i);
        }

        public void b(int i) {
            this.g.e_(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.e.j());
            int a3 = a(35632, this.e.k());
            this.i = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.i, a2);
            GLES20.glAttachShader(this.i, a3);
            GLES20.glLinkProgram(this.i);
            Log.e("error", GLES20.glGetProgramInfoLog(this.i));
            this.e.a(this.i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4790a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.i == 0) {
                a();
            }
            GLES20.glUseProgram(this.i);
            LayerRenderer.z();
            this.f4790a.a(floatBuffer);
            this.f4790a.b(floatBuffer2);
            this.f4790a.b_(i);
            this.b.a(fArr2);
            this.f4790a.a(fArr);
            this.d.a(f);
            this.e.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class w implements q {

        /* renamed from: a, reason: collision with root package name */
        a f4788a;
        e b;
        n c;
        ab d;
        j e;
        private int g;

        w() {
            this.f4788a = new a();
            this.b = new e();
            this.c = new n();
            this.d = new ab();
            this.e = new j();
            this.f4788a.a(new m(LayerRenderer.this, null));
            this.b.a(this.f4788a);
            this.c.a(this.b);
            this.d.a(this.c);
            this.e.a(this.d);
        }

        public void a(int i) {
            this.e.f_(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.e.j());
            int a3 = a(35632, this.e.k());
            this.g = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.g, a2);
            GLES20.glAttachShader(this.g, a3);
            GLES20.glLinkProgram(this.g);
            Log.e("error", GLES20.glGetProgramInfoLog(this.g));
            this.e.a(this.g);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4788a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.g == 0) {
                a();
            }
            GLES20.glUseProgram(this.g);
            LayerRenderer.z();
            this.f4788a.a(floatBuffer);
            this.f4788a.b(floatBuffer2);
            this.f4788a.b_(i);
            this.b.a(fArr2);
            this.f4788a.a(fArr);
            this.d.a(f);
            this.e.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class v implements q {

        /* renamed from: a, reason: collision with root package name */
        a f4787a;
        e b;
        n c;
        ab d;
        f e;
        private int g;

        v() {
            this.f4787a = new a();
            this.b = new e();
            this.c = new n();
            this.d = new ab();
            this.e = new f();
            this.f4787a.a(new m(LayerRenderer.this, null));
            this.b.a(this.f4787a);
            this.c.a(this.b);
            this.d.a(this.c);
            this.e.a(this.d);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.e.j());
            int a3 = a(35632, this.e.k());
            this.g = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.g, a2);
            GLES20.glAttachShader(this.g, a3);
            GLES20.glLinkProgram(this.g);
            Log.e("error", GLES20.glGetProgramInfoLog(this.g));
            this.e.a(this.g);
        }

        public void a(int i) {
            this.e.e_(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4787a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.g == 0) {
                a();
            }
            GLES20.glUseProgram(this.g);
            LayerRenderer.z();
            this.f4787a.a(floatBuffer);
            this.f4787a.b(floatBuffer2);
            this.f4787a.b_(i);
            this.b.a(fArr2);
            this.f4787a.a(fArr);
            this.d.a(f);
            this.e.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class z implements q {

        /* renamed from: a, reason: collision with root package name */
        a f4791a;
        e b;
        n c;
        ab d;
        j e;
        f f;
        private int h;

        z() {
            this.f4791a = new a();
            this.b = new e();
            this.c = new n();
            this.d = new ab();
            this.f = new f();
            this.e = new j();
            this.f4791a.a(new m(LayerRenderer.this, null));
            this.b.a(this.f4791a);
            this.c.a(this.b);
            this.d.a(this.c);
            this.f.a(this.d);
            this.e.a(this.f);
        }

        public void a(int i) {
            this.e.f_(i);
        }

        public void b(int i) {
            this.f.e_(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.e.j());
            int a3 = a(35632, this.e.k());
            this.h = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.h, a2);
            GLES20.glAttachShader(this.h, a3);
            GLES20.glLinkProgram(this.h);
            Log.e("error", GLES20.glGetProgramInfoLog(this.h));
            this.e.a(this.h);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4791a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.h == 0) {
                a();
            }
            GLES20.glUseProgram(this.h);
            LayerRenderer.z();
            this.f4791a.a(floatBuffer);
            this.f4791a.b(floatBuffer2);
            this.f4791a.b_(i);
            this.b.a(fArr2);
            this.f4791a.a(fArr);
            this.d.a(f);
            this.e.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    public void d(boolean z2) {
        this.am = z2;
    }

    public void e(boolean z2) {
        this.an = z2;
    }

    public void f(boolean z2) {
        this.ao = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h implements q {

        /* renamed from: a, reason: collision with root package name */
        b f4775a;
        n b;
        e c;
        ab d;
        private int f;

        h() {
            this.f4775a = new b();
            this.c = new e();
            this.b = new n();
            this.d = new ab();
            this.f4775a.a(new m(LayerRenderer.this, null));
            this.c.a(this.f4775a);
            this.b.a(this.c);
            this.d.a(this.b);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.d.j());
            int a3 = a(35632, this.d.k());
            this.f = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f, a2);
            GLES20.glAttachShader(this.f, a3);
            GLES20.glLinkProgram(this.f);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f));
            this.d.a(this.f);
        }

        public void a(int i) {
            this.f4775a.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4775a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f == 0) {
                a();
            }
            GLES20.glUseProgram(this.f);
            this.f4775a.a(floatBuffer);
            this.f4775a.b(floatBuffer2);
            this.f4775a.c_(i);
            this.c.a(fArr2);
            this.f4775a.a(fArr);
            this.d.a(f);
            this.d.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ac implements q {

        /* renamed from: a, reason: collision with root package name */
        c f4768a;
        n b;
        e c;
        ab d;
        private int f;

        ac() {
            this.f4768a = new c();
            this.c = new e();
            this.b = new n();
            this.d = new ab();
            this.f4768a.a(new m(LayerRenderer.this, null));
            this.c.a(this.f4768a);
            this.b.a(this.c);
            this.d.a(this.b);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.d.j());
            int a3 = a(35632, this.d.k());
            this.f = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f, a2);
            GLES20.glAttachShader(this.f, a3);
            GLES20.glLinkProgram(this.f);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f));
            this.d.a(this.f);
        }

        public void a(int i) {
            this.f4768a.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4768a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f == 0) {
                a();
            }
            GLES20.glUseProgram(this.f);
            this.f4768a.a(floatBuffer);
            this.f4768a.b(floatBuffer2);
            this.f4768a.d_(i);
            this.c.a(fArr2);
            this.f4768a.a(fArr);
            this.d.a(f);
            this.d.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class l implements q {

        /* renamed from: a, reason: collision with root package name */
        k f4779a;
        n b;
        e c;
        ab d;
        private int f;

        l() {
            this.f4779a = new k();
            this.c = new e();
            this.b = new n();
            this.d = new ab();
            this.f4779a.a(new m(LayerRenderer.this, null));
            this.c.a(this.f4779a);
            this.b.a(this.c);
            this.d.a(this.b);
        }

        public void a(int i) {
            this.f4779a.c(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.d.j());
            int a3 = a(35632, this.d.k());
            this.f = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f, a2);
            GLES20.glAttachShader(this.f, a3);
            GLES20.glLinkProgram(this.f);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f));
            this.d.a(this.f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f) {
            this.f4779a.a(f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f4776a, fArr, fArr2, f, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f == 0) {
                a();
            }
            GLES20.glUseProgram(this.f);
            this.f4779a.a(floatBuffer);
            this.f4779a.b(floatBuffer2);
            this.f4779a.g_(i);
            this.c.a(fArr2);
            this.f4779a.a(fArr);
            this.d.a(f);
            this.d.b(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z() {
        boolean z2 = true;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                if (z2) {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    Log.e("LayerRenderer", "GLError(s) detected at:");
                    for (int i2 = 0; i2 < stackTrace.length && i2 < 5; i2++) {
                        Log.e("LayerRenderer", "    " + i2 + ": " + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + " (" + stackTrace[i2].getClassName() + "." + stackTrace[i2].getMethodName() + ")");
                    }
                    z2 = false;
                }
                Log.e("LayerRenderer", "GLError: 0x" + Integer.toHexString(glGetError) + " (" + GLU.gluErrorString(glGetError) + ")");
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class aa {

        /* renamed from: a, reason: collision with root package name */
        private float[] f4766a;
        private float b;
        private int c;
        private ColorMatrix d;
        private RenderTarget e;
        private boolean f;

        private aa() {
            this.f4766a = new float[16];
            this.d = new ColorMatrix();
        }

        /* synthetic */ aa(com.nextreaming.nexvideoeditor.b bVar) {
            this();
        }

        void a(float[] fArr, float f, int i, ColorMatrix colorMatrix, RenderTarget renderTarget, boolean z) {
            System.arraycopy(fArr, 0, this.f4766a, 0, this.f4766a.length);
            this.b = f;
            this.c = i;
            this.d.set(colorMatrix);
            this.e = renderTarget;
            this.f = z;
        }

        public float[] a() {
            return this.f4766a;
        }

        public ColorMatrix b() {
            return this.d;
        }

        public float c() {
            return this.b;
        }

        public int d() {
            return this.c;
        }

        public RenderTarget e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }
    }

    public int j() {
        return this.b;
    }

    private void A() {
        ArrayList arrayList = null;
        for (i iVar : this.s) {
            if (!this.r.containsValue(iVar)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(iVar);
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a();
            }
            this.s.removeAll(arrayList);
        }
    }

    private void B() {
        ArrayList arrayList = null;
        for (Integer num : this.y) {
            if (!this.x.containsValue(num)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(num);
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ap[0] = ((Integer) it.next()).intValue();
                GLES20.glDeleteTextures(1, ap, 0);
                z();
            }
            this.y.removeAll(arrayList);
        }
    }

    private i c(Bitmap bitmap) {
        i iVar = this.r.get(bitmap);
        if (iVar != null) {
            iVar.a(bitmap);
            z();
            return iVar;
        }
        i iVar2 = new i(bitmap);
        z();
        this.r.put(bitmap, iVar2);
        this.s.add(iVar2);
        return iVar2;
    }

    public g a(g gVar, float f2, float f3, float f4, float f5) {
        if (gVar != null) {
            gVar.a(f2, f3, f4, f5);
            return gVar;
        }
        g gVar2 = new g(f4, f5);
        gVar2.a(f2, f3, f4, f5);
        int a2 = gVar2.a();
        this.x.put(gVar2, Integer.valueOf(a2));
        this.y.add(Integer.valueOf(a2));
        return gVar2;
    }

    public int a(Bitmap bitmap, int i2) {
        Map<Bitmap, i> map;
        Set<i> set;
        if (bitmap == null) {
            return 0;
        }
        if (i2 == 1) {
            map = this.n;
            set = this.o;
        } else {
            map = this.p;
            set = this.q;
        }
        if (map == null) {
            return 0;
        }
        i iVar = map.get(bitmap);
        if (iVar != null) {
            iVar.a(bitmap);
            z();
        } else {
            iVar = new i(bitmap);
            z();
            map.put(bitmap, iVar);
            set.add(iVar);
        }
        return iVar.f4776a;
    }

    private void a(i iVar, float f2, float f3) {
        NexEditor a2 = EditorGlobal.a();
        if (a2 != null) {
            a2.a(w().id, iVar.f4776a, f2, f3);
        }
    }

    private void c(float f2, float f3, float f4, float f5) {
        if (this.ak && this.ai && this.aj) {
            this.ag = this.T;
        } else if (this.ak && this.ai) {
            this.ag = this.Q;
        } else if (this.ak && this.aj) {
            this.ag = this.N;
        } else if (this.ak) {
            this.ag = this.D;
        } else if (this.ai && this.aj) {
            this.ag = this.W;
        } else if (this.aj) {
            this.ag = this.K;
        } else if (this.am) {
            this.ag = this.Z;
        } else if (this.an) {
            this.ag = this.ac;
        } else if (this.ao) {
            this.ag = this.af;
        } else if (this.ai) {
            this.ag = this.H;
        } else {
            this.ag = this.E;
        }
        float[] array = this.ar.getArray();
        this.at[0] = array[0];
        this.at[1] = array[1];
        this.at[2] = array[2];
        this.at[3] = array[4];
        this.at[4] = array[5];
        this.at[5] = array[6];
        this.at[6] = array[7];
        this.at[7] = array[9];
        this.at[8] = array[10];
        this.at[9] = array[11];
        this.at[10] = array[12];
        this.at[11] = array[14];
        this.at[12] = array[15];
        this.at[13] = array[16];
        this.at[14] = array[17];
        this.at[15] = 1.0f;
        float[] fArr = this.ay;
        float[] fArr2 = this.ay;
        float[] fArr3 = this.ay;
        this.ay[14] = -10.0f;
        fArr3[10] = -10.0f;
        fArr2[6] = -10.0f;
        fArr[2] = -10.0f;
        float[] fArr4 = this.ay;
        float[] fArr5 = this.ay;
        float[] fArr6 = this.ay;
        this.ay[15] = 1.0f;
        fArr6[11] = 1.0f;
        fArr5[7] = 1.0f;
        fArr4[3] = 1.0f;
        float[] fArr7 = this.ay;
        this.ay[8] = f2;
        fArr7[0] = f2;
        float[] fArr8 = this.ay;
        this.ay[5] = f5;
        fArr8[1] = f5;
        float[] fArr9 = this.ay;
        this.ay[12] = f4;
        fArr9[4] = f4;
        float[] fArr10 = this.ay;
        this.ay[13] = f3;
        fArr10[9] = f3;
        this.av.rewind();
        this.av.put(this.ay);
        this.av.rewind();
    }

    private void a(i iVar, float f2, float f3, float f4, float f5) {
        c(f2, f3, f4, f5);
        this.ag.a(iVar, this.g, this.at, this.h, this.av, this.aw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, boolean z2, float[] fArr, int i4) {
        if (z2) {
            Matrix.transposeM(this.au, 0, fArr, 0);
            GLES20.glUniformMatrix4fv(i2, i3, false, this.au, i4);
        } else {
            GLES20.glUniformMatrix4fv(i2, i3, false, fArr, i4);
        }
    }

    private void c(int i2, float f2, float f3, float f4, float f5) {
        this.ar.preConcat(this.as);
        c(f2, f3, f4, f5);
        this.ag.a(i2, this.g, this.at, this.h, this.av, this.aw);
    }

    public void a(int i2, float f2, float f3, float f4, float f5) {
        if (i2 >= 0) {
            c(i2, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f2 + (f4 / 2.0f), f3 + (f5 / 2.0f));
        }
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4, float f5) {
        if (bitmap != null) {
            i c2 = c(bitmap);
            z();
            a(c2, f2, f3, f4, f5);
        }
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (bitmap != null) {
            i c2 = c(bitmap);
            z();
            this.aw.rewind();
            this.aw.put(new float[]{0.0f, f7, f6, f7, 0.0f, 0.0f, f6, 0.0f});
            this.aw.rewind();
            GLES20.glActiveTexture(33984);
            z();
            GLES20.glBindTexture(3553, c2.f4776a);
            z();
            GLES20.glTexParameteri(3553, 10241, 9729);
            z();
            GLES20.glTexParameteri(3553, 10240, 9729);
            z();
            GLES20.glTexParameteri(3553, 10242, 10497);
            z();
            GLES20.glTexParameteri(3553, 10243, 10497);
            z();
            a(c2, f2, f3, f4, f5);
            this.aw.rewind();
            this.aw.put(ax);
            this.aw.rewind();
            GLES20.glActiveTexture(33984);
            z();
            GLES20.glBindTexture(3553, c2.f4776a);
            z();
            GLES20.glTexParameteri(3553, 10241, 9729);
            z();
            GLES20.glTexParameteri(3553, 10240, 9729);
            z();
            GLES20.glTexParameteri(3553, 10242, 33071);
            z();
            GLES20.glTexParameteri(3553, 10243, 33071);
            z();
        }
    }

    public void a(Bitmap bitmap, float f2, float f3) {
        if (bitmap != null) {
            a(c(bitmap), f2 - (r1.b / 2), f3 - (r1.c / 2), f2 + (r1.b / 2), f3 + (r1.c / 2));
        }
    }

    public void b(Bitmap bitmap, float f2, float f3) {
        if (bitmap != null) {
            a(c(bitmap), f2, f3);
        }
    }

    public void k() {
        RenderTarget renderTarget = this.ah;
        if (this.ah != RenderTarget.Mask) {
            a(RenderTarget.Mask);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.ah != renderTarget) {
            a(renderTarget);
        }
    }

    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            c(bitmap);
        }
    }

    public void a(ColorMatrix colorMatrix) {
        if (colorMatrix == null) {
            this.ar.reset();
        } else {
            this.ar.set(colorMatrix);
        }
        this.ar.preConcat(this.as);
    }

    public void a(int i2, float f2, float f3, float f4, float f5, float f6) {
        b(i2, f2, f3, f2 + f6, f5);
        b(i2, f4 - f6, f3, f4, f5);
        b(i2, f2 + f6, f3, f4 - f6, f3 + f6);
        b(i2, f2 + f6, f5 - f6, f4 - f6, f5);
    }

    public void b(int i2, float f2, float f3, float f4, float f5) {
        if (this.aB == null) {
            this.aB = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
            this.aB.eraseColor(-1);
        }
        l();
        this.aC.setScale(Color.red(i2) / 255.0f, Color.green(i2) / 255.0f, Color.blue(i2) / 255.0f, 1.0f);
        a(this.aC);
        d(this.h * (Color.alpha(i2) / 255.0f));
        a(this.aB, f2, f3, f4, f5);
        m();
    }

    public void l() {
        if (this.l >= this.m.length) {
            aa[] aaVarArr = new aa[this.m.length + 16];
            System.arraycopy(this.m, 0, aaVarArr, 0, this.m.length);
            this.m = aaVarArr;
        }
        if (this.m[this.l] == null) {
            this.m[this.l] = new aa(null);
        }
        this.m[this.l].a(this.g, this.h, this.b, this.ar, this.ah, this.ai);
        this.l++;
    }

    public void m() {
        if (this.l < 1) {
            throw new IllegalStateException("Restore call without matching save");
        }
        this.l--;
        System.arraycopy(this.m[this.l].a(), 0, this.g, 0, this.g.length);
        this.h = this.m[this.l].c();
        this.b = this.m[this.l].d();
        this.ar.set(this.m[this.l].b());
        a(this.m[this.l].e());
        a(this.m[this.l].f());
    }

    public void n() {
        this.f4763a = true;
        if (this.f4763a) {
            GLES20.glClear(256);
        }
    }

    public void o() {
        this.f4763a = false;
    }

    public void p() {
        this.ag.a(0.0f);
        if (this.f4763a && this.h >= 1.0d) {
            GLES20.glEnable(2929);
            this.ag.a(0.5f);
        }
    }

    public void q() {
        if (this.f4763a) {
            GLES20.glDisable(2929);
        }
    }

    public void a(float f2, float f3, float f4) {
        Matrix.translateM(this.g, 0, f2, f3, f4);
    }

    public void a(float f2, float f3) {
        Matrix.translateM(this.g, 0, f2, f3, 0.0f);
    }

    public void b(float f2, float f3) {
        Matrix.scaleM(this.g, 0, f2, f3, 1.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        a(f4, f5);
        Matrix.scaleM(this.g, 0, f2, f3, 1.0f);
        a(-f4, -f5);
    }

    public void b(float f2, float f3, float f4, float f5) {
        Matrix.rotateM(this.g, 0, f2, f3, f4, f5);
    }

    public void b(float f2, float f3, float f4) {
        a(f3, f4);
        b(f2, 0.0f, 0.0f, 1.0f);
        a(-f3, -f4);
    }

    public void d(float f2) {
        this.h = f2;
    }

    public float r() {
        return this.h;
    }

    public void a(int i2) {
        this.b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        this.c = i2;
        this.d = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2, int i3) {
        this.e = i2;
        this.f = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z2) {
        if (z2) {
            this.r = this.n;
            this.s = this.o;
            this.x = this.t;
            this.y = this.u;
            this.E = this.A;
            this.D = this.C;
            this.N = this.M;
            this.Q = this.P;
            this.T = this.S;
            this.H = this.G;
            this.K = this.J;
            this.W = this.V;
            this.Z = this.Y;
            this.ac = this.ab;
            this.af = this.ae;
            this.ag = this.E;
        } else {
            this.r = this.p;
            this.s = this.q;
            this.x = this.v;
            this.y = this.w;
            this.E = this.z;
            this.D = this.B;
            this.N = this.L;
            this.Q = this.O;
            this.T = this.R;
            this.H = this.F;
            this.K = this.I;
            this.W = this.U;
            this.Z = this.X;
            this.ac = this.aa;
            this.af = this.ad;
            this.ag = this.E;
        }
        this.az = z2 ? RenderMode.Export : RenderMode.Preview;
        NexEditor a2 = EditorGlobal.a();
        if (a2 != null) {
            int b2 = a2.b(this.az.id);
            this.af.a(b2);
            this.Z.a(b2);
            this.ac.a(b2);
            this.H.a(b2);
            this.W.a(b2);
            ((x) this.Q).a(b2);
            ((y) this.T).a(b2);
        }
    }

    public void s() {
        GLES20.glEnable(3042);
        z();
        GLES20.glDisable(2884);
        z();
        GLES20.glDisable(2929);
        z();
        GLES20.glBlendFunc(1, 771);
        z();
    }

    public void t() {
        float f2 = this.c * 0.5f;
        Matrix.perspectiveM(this.g, 0, 45.0f, this.c / this.d, 0.01f, 3000.0f);
        Matrix.translateM(this.g, 0, -f2, -(this.d * 0.5f), -((this.g[0] * f2) - 10.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        z();
        this.h = 1.0f;
        A();
        B();
        Matrix.setIdentityM(this.g, 0);
        this.l = 0;
        this.ar.reset();
        this.ar.preConcat(this.as);
        float f2 = this.c * 0.5f;
        Matrix.perspectiveM(this.g, 0, 45.0f, this.c / this.d, 0.01f, 3000.0f);
        float f3 = (this.g[0] * f2) - 10.0f;
        Matrix.scaleM(this.g, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(this.g, 0, -f2, -(this.d * 0.5f), -f3);
        this.aw.rewind();
        this.aw.put(ax);
        this.aw.rewind();
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        A();
        B();
    }

    public RenderMode w() {
        return this.az;
    }
}
