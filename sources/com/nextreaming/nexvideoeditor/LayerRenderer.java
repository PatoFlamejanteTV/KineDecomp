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
import java.lang.reflect.Array;
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

/* loaded from: classes3.dex */
public class LayerRenderer implements InterfaceC2352c {

    /* renamed from: a */
    private static int[] f24455a = new int[1];

    /* renamed from: b */
    private static final float[] f24456b = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private Map<g, Integer> A;
    private RenderMode Aa;
    private Set<Integer> B;
    private Object Ba;
    private Bitmap Ca;
    private q G;
    private q H;
    private w K;
    private v N;
    private q Q;
    private q T;
    private q W;
    private z Z;

    /* renamed from: c */
    private int f24457c;
    private h ca;

    /* renamed from: d */
    private int f24458d;

    /* renamed from: e */
    private int f24459e;

    /* renamed from: f */
    private int f24460f;
    private C fa;

    /* renamed from: g */
    private int f24461g;
    private l ia;
    private q ja;
    private float l;
    private float m;
    private float n;
    private Map<Bitmap, i> u;
    private Set<i> v;

    /* renamed from: h */
    private float[] f24462h = new float[16];
    private float i = 1.0f;
    private float j = 1.0f;
    private float k = 1.0f;
    private int o = 0;
    private A[] p = new A[16];
    private Map<Bitmap, i> q = new WeakHashMap();
    private Set<i> r = new HashSet();
    private Map<Bitmap, i> s = new WeakHashMap();
    private Set<i> t = new HashSet();
    private Map<g, Integer> w = new WeakHashMap();
    private Set<Integer> x = new HashSet();
    private Map<g, Integer> y = new WeakHashMap();
    private Set<Integer> z = new HashSet();
    private q C = new r();
    private q D = new r();
    private q E = new t();
    private q F = new t();
    private w I = new w();
    private w J = new w();
    private v L = new v();
    private v M = new v();
    private q O = new u();
    private q P = new u();
    private q R = new x();
    private q S = new x();
    private q U = new y();
    private q V = new y();
    private z X = new z();
    private z Y = new z();
    private h aa = new h();
    private h ba = new h();
    private C da = new C();
    private C ea = new C();
    private l ga = new l();
    private l ha = new l();
    private RenderTarget ka = RenderTarget.Normal;
    private boolean la = false;
    private boolean ma = false;
    private boolean na = false;
    private boolean oa = false;
    private boolean pa = false;
    private boolean qa = false;
    private boolean ra = false;
    private float[] sa = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] ta = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private ColorMatrix ua = new ColorMatrix();
    private float[] va = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] wa = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private FloatBuffer xa = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private FloatBuffer ya = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private float[] za = new float[16];
    private ColorMatrix Da = new ColorMatrix();
    boolean Ea = false;

    /* loaded from: classes3.dex */
    public class B extends p {

        /* renamed from: h */
        private int f24471h;
        float i;

        B() {
            super();
            d("");
            c("applyUserAlpha");
            b("");
            a("uniform highp float u_alpha;\nhighp vec4 applyUserAlpha(highp vec4 color){\n        return color * u_alpha;\n}");
            a(1.0f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24471h = GLES20.glGetUniformLocation(i, "u_alpha");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            GLES20.glUniform1f(this.f24471h, this.i);
        }

        void a(float f2) {
            this.i = f2;
        }
    }

    /* loaded from: classes3.dex */
    public enum RenderMode {
        Preview(0),
        Export(1);

        public final int id;

        RenderMode(int i) {
            this.id = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum RenderTarget {
        Normal,
        Mask
    }

    /* renamed from: com.nextreaming.nexvideoeditor.LayerRenderer$a */
    /* loaded from: classes3.dex */
    public class C2347a extends p {

        /* renamed from: h */
        private int f24478h;
        private int i;
        private int j;
        private int k;
        private int l;
        private FloatBuffer m;
        private FloatBuffer n;
        private int o;
        private float[] p;
        private float q;

        C2347a() {
            super();
            d("doBaseVertexWork");
            c("applyBase");
            b("//Base Vertex Block\nattribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nvarying highp vec2 v_texCoord;\nvoid doBaseVertexWork(){\n        v_texCoord = a_texCoord;\n        gl_Position = a_position * u_mvp_matrix;\n}");
            a("varying highp vec2 v_texCoord;\nuniform sampler2D u_textureSampler;\nuniform highp float u_alpha_test;\nhighp vec4 applyBase(){\n        highp vec4 color;\n        color = (texture2D(u_textureSampler, v_texCoord));\n        if(color.a < u_alpha_test) return vec4(0,0,0,0);\n        return color;\n}");
        }

        public void a(float f2) {
            this.q = f2;
        }

        public void b(FloatBuffer floatBuffer) {
            this.n = floatBuffer;
        }

        public void c(int i) {
            this.o = i;
        }

        public void a(FloatBuffer floatBuffer) {
            this.m = floatBuffer;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.o);
            LayerRenderer.A();
            GLES20.glUniform1i(this.j, a2);
            LayerRenderer.A();
            GLES20.glUniform1f(this.l, this.q);
            GLES20.glEnableVertexAttribArray(this.f24478h);
            LayerRenderer.A();
            GLES20.glEnableVertexAttribArray(this.i);
            LayerRenderer.A();
            LayerRenderer.this.a(this.k, 1, true, this.p, 0);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.f24478h, 4, 5126, false, 0, (Buffer) this.m);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, (Buffer) this.n);
            LayerRenderer.A();
        }

        public void a(float[] fArr) {
            this.p = fArr;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24478h = GLES20.glGetAttribLocation(i, "a_position");
            this.i = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.k = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.j = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.l = GLES20.glGetUniformLocation(i, "u_alpha_test");
        }
    }

    /* renamed from: com.nextreaming.nexvideoeditor.LayerRenderer$b */
    /* loaded from: classes3.dex */
    public class C2348b extends p {

        /* renamed from: h */
        private int f24479h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private FloatBuffer n;
        private FloatBuffer o;
        private int p;
        private int q;
        private float[] r;
        private float s;
        private int t;
        private float[] u;
        private int v;
        private float[] w;

        C2348b() {
            super();
            this.u = new float[2];
            this.w = new float[2];
            d("doBaseVertexWork");
            c("applyBlurBase");
            b("attribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nuniform highp vec2 u_texture_size;\nuniform highp vec2 u_block_size;\nvarying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nvoid doBaseVertexWork(){\n       v_texCoord = a_texCoord;\n       v_blurTexCoords[ 0] = v_texCoord + vec2(-7.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 1] = v_texCoord + vec2(-6.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 2] = v_texCoord + vec2(-5.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 3] = v_texCoord + vec2(-4.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 4] = v_texCoord + vec2(-3.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 5] = v_texCoord + vec2(-2.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 6] = v_texCoord + vec2(-1.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 7] = v_texCoord + vec2( 1.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 8] = v_texCoord + vec2( 2.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[ 9] = v_texCoord + vec2( 3.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[10] = v_texCoord + vec2( 4.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[11] = v_texCoord + vec2( 5.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[12] = v_texCoord + vec2( 6.0 / u_texture_size.x * u_block_size.x,0.0);\n       v_blurTexCoords[13] = v_texCoord + vec2( 7.0 / u_texture_size.x * u_block_size.x,0.0);\n       gl_Position = a_position * u_mvp_matrix;\n}");
            a("varying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nuniform highp vec2 u_texture_size;\nuniform sampler2D u_textureSampler;\nuniform sampler2D u_maskSampler;\nuniform highp vec2 u_block_size;\nuniform highp float u_alpha_test;\nhighp vec4 getTexColor(highp vec2 uv){\nhighp float dx = u_block_size.x * (1.0 / u_texture_size.x);\nhighp float dy = u_block_size.y * (1.0 / u_texture_size.y);\nhighp vec4 color = vec4(0.0);\nhighp vec2 coord = vec2(dx*floor(uv.x / dx) + 1. / u_texture_size.x, dy*floor(uv.y / dy) + 1. / u_texture_size.y);\ncolor.rgba = (texture2D(u_textureSampler, coord));\nreturn color;\n}\nhighp vec4 applyBlurBase(){\n       highp vec4 color;\n       highp vec4 mask = texture2D(u_maskSampler, v_texCoord);\n       if(mask.x == 0.0) return vec4(0, 0, 0, 0);\n       color.bgra = getTexColor(v_texCoord) * 0.159576912161;\n       color.bgra += getTexColor(v_blurTexCoords[ 0])*0.0044299121055113265;\n       color.bgra += getTexColor(v_blurTexCoords[1])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[2])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[3])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[4])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[5])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[6])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[7])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[8])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[9])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[10])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[11])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[12])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[13])*0.0044299121055113265;\n        if(color.a < u_alpha_test) return vec4(0,0,0,0);\n        return color.bgra;\n}\n");
        }

        public void a(float f2) {
            this.s = f2;
        }

        public void b(FloatBuffer floatBuffer) {
            this.o = floatBuffer;
        }

        public void c(int i) {
            this.q = i;
        }

        public void d(int i) {
            this.p = i;
        }

        public void a(FloatBuffer floatBuffer) {
            this.n = floatBuffer;
        }

        public void b(float f2, float f3) {
            float[] fArr = this.w;
            fArr[0] = f2;
            fArr[1] = f3;
        }

        public void a(float[] fArr) {
            this.r = fArr;
        }

        public void a(float f2, float f3) {
            this.u[0] = ((float) Math.floor(f2 * 30.0f)) + 1.0f;
            this.u[1] = ((float) Math.floor(f3 * 30.0f)) + 1.0f;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            a(LayerRenderer.this.g() * 0.2f, LayerRenderer.this.g() * 0.2f);
            b(LayerRenderer.this.p(), LayerRenderer.this.o());
            int a2 = oVar.a();
            GLES20.glActiveTexture(a2 + 33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.p);
            LayerRenderer.A();
            GLES20.glUniform1i(this.j, a2);
            LayerRenderer.A();
            int a3 = oVar.a();
            GLES20.glActiveTexture(33984 + a3);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.q);
            LayerRenderer.A();
            GLES20.glUniform1i(this.k, a3);
            LayerRenderer.A();
            GLES20.glUniform1f(this.m, this.s);
            GLES20.glEnableVertexAttribArray(this.f24479h);
            LayerRenderer.A();
            GLES20.glEnableVertexAttribArray(this.i);
            LayerRenderer.A();
            LayerRenderer.this.a(this.l, 1, true, this.r, 0);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.f24479h, 4, 5126, false, 0, (Buffer) this.n);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, (Buffer) this.o);
            LayerRenderer.A();
            int i = this.t;
            float[] fArr = this.u;
            GLES20.glUniform2f(i, fArr[0], fArr[1]);
            int i2 = this.v;
            float[] fArr2 = this.w;
            GLES20.glUniform2f(i2, fArr2[0], fArr2[1]);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24479h = GLES20.glGetAttribLocation(i, "a_position");
            this.i = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.l = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.j = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.k = GLES20.glGetUniformLocation(i, "u_maskSampler");
            this.m = GLES20.glGetUniformLocation(i, "u_alpha_test");
            this.t = GLES20.glGetUniformLocation(i, "u_block_size");
            this.v = GLES20.glGetUniformLocation(i, "u_texture_size");
        }
    }

    /* renamed from: com.nextreaming.nexvideoeditor.LayerRenderer$c */
    /* loaded from: classes3.dex */
    public class C2349c extends p {

        /* renamed from: h */
        private int f24480h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private FloatBuffer n;
        private FloatBuffer o;
        private int p;
        private int q;
        private float[] r;
        private float s;
        private int t;
        private float[] u;
        private int v;
        private float[] w;

        C2349c() {
            super();
            this.u = new float[2];
            this.w = new float[2];
            d("doBaseVertexWork");
            c("applyBlurBase");
            b("attribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nuniform highp vec2 u_block_size;\nuniform highp vec2 u_texture_size;\nvarying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nvoid doBaseVertexWork(){\n       v_texCoord = a_texCoord;\n       v_blurTexCoords[ 0] = v_texCoord + vec2(0.0, -7.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 1] = v_texCoord + vec2(0.0, -6.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 2] = v_texCoord + vec2(0.0, -5.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 3] = v_texCoord + vec2(0.0, -4.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 4] = v_texCoord + vec2(0.0, -3.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 5] = v_texCoord + vec2(0.0, -2.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 6] = v_texCoord + vec2(0.0, -1.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 7] = v_texCoord + vec2(0.0,  1.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 8] = v_texCoord + vec2(0.0,  2.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[ 9] = v_texCoord + vec2(0.0,  3.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[10] = v_texCoord + vec2(0.0,  4.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[11] = v_texCoord + vec2(0.0,  5.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[12] = v_texCoord + vec2(0.0,  6.0 / u_texture_size.y * u_block_size.y);\n       v_blurTexCoords[13] = v_texCoord + vec2(0.0,  7.0 / u_texture_size.y * u_block_size.y);\n       gl_Position = a_position * u_mvp_matrix;\n}");
            a("varying highp vec2 v_texCoord;\nvarying highp vec2 v_blurTexCoords[14];\nuniform highp vec2 u_texture_size;\nuniform sampler2D u_textureSampler;\nuniform sampler2D u_maskSampler;\nuniform highp vec2 u_block_size;\nuniform highp float u_alpha_test;\nhighp vec4 getTexColor(highp vec2 uv){\nhighp float dx = u_block_size.x * (1.0 / u_texture_size.x);\nhighp float dy = u_block_size.y * (1.0 / u_texture_size.y);\nhighp vec4 color = vec4(0.0);\nhighp vec2 coord = vec2(dx*floor(uv.x / dx) + 1. / u_texture_size.x, dy*floor(uv.y / dy) + 1. / u_texture_size.y);\ncolor.rgba = (texture2D(u_textureSampler, coord));\nreturn color;\n}\nhighp vec4 applyBlurBase(){\n       highp vec4 color;\n       highp vec4 mask = texture2D(u_maskSampler, v_texCoord);\n       if(mask.x == 0.0) return vec4(0, 0, 0, 0);\n       color.bgra = getTexColor(v_texCoord) * 0.159576912161;\n       color.bgra += getTexColor(v_blurTexCoords[ 0])*0.0044299121055113265;\n       color.bgra += getTexColor(v_blurTexCoords[1])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[2])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[3])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[4])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[5])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[6])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[7])*0.147308056121;\n       color.bgra += getTexColor(v_blurTexCoords[8])*0.115876621105;\n       color.bgra += getTexColor(v_blurTexCoords[9])*0.0776744219933;\n       color.bgra += getTexColor(v_blurTexCoords[10])*0.0443683338718;\n       color.bgra += getTexColor(v_blurTexCoords[11])*0.0215963866053;\n       color.bgra += getTexColor(v_blurTexCoords[12])*0.00895781211794;\n       color.bgra += getTexColor(v_blurTexCoords[13])*0.0044299121055113265;\n        if(color.a < u_alpha_test) return vec4(0,0,0,0);\n        return color.rgba;\n}\n");
        }

        public void a(float f2) {
            this.s = f2;
        }

        public void b(FloatBuffer floatBuffer) {
            this.o = floatBuffer;
        }

        public void c(int i) {
            this.q = i;
        }

        public void d(int i) {
            this.p = i;
        }

        public void a(FloatBuffer floatBuffer) {
            this.n = floatBuffer;
        }

        public void b(float f2, float f3) {
            float[] fArr = this.w;
            fArr[0] = f2;
            fArr[1] = f3;
        }

        public void a(float[] fArr) {
            this.r = fArr;
        }

        public void a(float f2, float f3) {
            this.u[0] = ((float) Math.floor(f2 * 30.0f)) + 1.0f;
            this.u[1] = ((float) Math.floor(f3 * 30.0f)) + 1.0f;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            a(LayerRenderer.this.g() * 0.2f, LayerRenderer.this.g() * 0.2f);
            b(LayerRenderer.this.p(), LayerRenderer.this.o());
            int a2 = oVar.a();
            GLES20.glActiveTexture(a2 + 33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.p);
            LayerRenderer.A();
            GLES20.glUniform1i(this.j, a2);
            LayerRenderer.A();
            int a3 = oVar.a();
            GLES20.glActiveTexture(33984 + a3);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.q);
            LayerRenderer.A();
            GLES20.glUniform1i(this.k, a3);
            LayerRenderer.A();
            GLES20.glUniform1f(this.m, this.s);
            GLES20.glEnableVertexAttribArray(this.f24480h);
            LayerRenderer.A();
            GLES20.glEnableVertexAttribArray(this.i);
            LayerRenderer.A();
            LayerRenderer.this.a(this.l, 1, true, this.r, 0);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.f24480h, 4, 5126, false, 0, (Buffer) this.n);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, (Buffer) this.o);
            LayerRenderer.A();
            int i = this.t;
            float[] fArr = this.u;
            GLES20.glUniform2f(i, fArr[0], fArr[1]);
            int i2 = this.v;
            float[] fArr2 = this.w;
            GLES20.glUniform2f(i2, fArr2[0], fArr2[1]);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24480h = GLES20.glGetAttribLocation(i, "a_position");
            this.i = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.l = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.j = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.k = GLES20.glGetUniformLocation(i, "u_maskSampler");
            this.m = GLES20.glGetUniformLocation(i, "u_alpha_test");
            this.t = GLES20.glGetUniformLocation(i, "u_block_size");
            this.v = GLES20.glGetUniformLocation(i, "u_texture_size");
        }
    }

    /* loaded from: classes3.dex */
    public class e extends p {

        /* renamed from: h */
        private int f24482h;
        private float[] i;

        e() {
            super();
            d("");
            c("applyColorConv");
            b("");
            a("uniform highp mat4 u_colorconv;\nhighp vec4 applyColorConv(highp vec4 color){\n        color = color * u_colorconv;\n        color = clamp(color, 0.0, 1.0);\n        return color;\n}");
        }

        public void a(float[] fArr) {
            this.i = fArr;
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            LayerRenderer.this.a(this.f24482h, 1, false, this.i, 0);
            LayerRenderer.A();
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24482h = GLES20.glGetUniformLocation(i, "u_colorconv");
        }
    }

    /* loaded from: classes3.dex */
    public class f extends p {

        /* renamed from: h */
        int f24483h;
        int i;
        private int j;
        float k;

        f() {
            super();
            this.j = 0;
            this.k = 1.0f;
            d("");
            c("applyLUT");
            b("");
            a("const highp float block_factor = 64.0;\nuniform sampler2D u_textureSampler_for_lut;\nuniform highp float u_strength_for_lut;\n\nhighp vec4 applyLUT(highp vec4 color) {\n   highp float block = (block_factor - 1.0) * color.b;\n   highp float low = floor(block);\n   highp float high = ceil(block);\n   highp float y0 = mod(low, 8.0);\n   highp float x0 = (low - y0) / 8.0;\n   highp float y1 = mod(high, 8.0);\n   highp float x1 = (high - y1) / 8.0;\n   x0 /= 8.0;\n   y0 /= 8.0;\n   x1 /= 8.0;\n   y1 /= 8.0;\n   highp vec2 rg_pos = (63.0 / 512.0) * color.rg + 0.5 / 512.0;\n   highp vec4 color0 = texture2D(u_textureSampler_for_lut, vec2(x0, y0) + rg_pos.yx).rgba;\n   highp vec4 color1 = texture2D(u_textureSampler_for_lut, vec2(x1, y1) + rg_pos.yx).rgba;\n   return vec4(mix(color.rgb, mix(color0, color1, fract(block)).rgb, u_strength_for_lut).rgb * color.a, color.a);\n}");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24483h = GLES20.glGetUniformLocation(i, "u_textureSampler_for_lut");
            this.i = GLES20.glGetUniformLocation(i, "u_strength_for_lut");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.j);
            LayerRenderer.A();
            GLES20.glUniform1i(this.f24483h, a2);
            LayerRenderer.A();
            GLES20.glUniform1f(this.i, this.k);
            LayerRenderer.A();
        }

        void c(int i) {
            this.j = i;
        }
    }

    /* loaded from: classes3.dex */
    public class j extends p {

        /* renamed from: h */
        int f24499h;
        private int i;

        j() {
            super();
            d("maskWork");
            c("applyMask");
            b("\nvarying highp vec2 v_texCoord_for_mask;\nvoid maskWork() {\nv_texCoord_for_mask = gl_Position.xy / gl_Position.w * 0.5 + 0.5;\n}\n");
            a("\nvarying highp vec2 v_texCoord_for_mask;\nuniform sampler2D u_textureSampler_for_mask;\nhighp vec4 applyMask(highp vec4 color) {\nhighp vec4 mask = (texture2D(u_textureSampler_for_mask, v_texCoord_for_mask)).rgba;\ncolor *= mask.r;\nreturn color;\n}\n");
            LayerRenderer.this.a(1.0f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24499h = GLES20.glGetUniformLocation(i, "u_textureSampler_for_mask");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            int a2 = oVar.a();
            GLES20.glActiveTexture(33984 + a2);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.i);
            LayerRenderer.A();
            GLES20.glUniform1i(this.f24499h, a2);
            LayerRenderer.A();
        }

        void c(int i) {
            this.i = i;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends p {

        /* renamed from: h */
        private int f24500h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private FloatBuffer n;
        private FloatBuffer o;
        private int p;
        private int q;
        private float[] r;
        private float s;
        private int t;
        private float[] u;
        private int v;
        private float[] w;

        k() {
            super();
            this.u = new float[2];
            this.w = new float[2];
            d("doMosaicBaseVertexWork");
            c("mosaicBase");
            b("//Base Vertex Block\nattribute vec4 a_position;\nattribute vec2 a_texCoord;uniform mat4 u_mvp_matrix;\nvarying highp vec2 v_texCoord;\nvoid doMosaicBaseVertexWork(){\n        v_texCoord = a_texCoord;\n        gl_Position = a_position * u_mvp_matrix;\n}");
            a("varying highp vec2 v_texCoord;\nuniform sampler2D u_textureSampler;\nuniform sampler2D u_maskSampler;\nuniform highp float u_alpha_test;\nuniform highp vec2 u_block_size;\nuniform highp vec2 u_texture_size;\nhighp vec4 mosaicBase(){\n   highp vec2 uv = v_texCoord;\n   highp vec4 mask = texture2D(u_maskSampler, uv);\n   if(mask.x == 0.0) return vec4(0, 0, 0, 0);\n   highp float dx = u_block_size.x * (1.0 / u_texture_size.x);\n   highp float dy = u_block_size.y * (1.0 / u_texture_size.y);\n   highp vec2 coord = vec2(dx*floor(uv.x / dx) + 1. / u_texture_size.x, dy*floor(uv.y / dy) + 1. / u_texture_size.y);\n   highp vec4 color = texture2D(u_textureSampler, coord);\n   if(color.a < u_alpha_test) return vec4(0,0,0,0);\n   return color;\n}");
        }

        public void a(float f2) {
            this.s = f2;
        }

        public void b(FloatBuffer floatBuffer) {
            this.o = floatBuffer;
        }

        public void c(int i) {
            this.q = i;
        }

        public void d(int i) {
            this.p = i;
        }

        public void a(FloatBuffer floatBuffer) {
            this.n = floatBuffer;
        }

        public void b(float f2, float f3) {
            float[] fArr = this.w;
            fArr[0] = f2;
            fArr[1] = f3;
        }

        public void a(float[] fArr) {
            this.r = fArr;
        }

        public void a(float f2, float f3) {
            if (f2 == 0.0f && f3 == 0.0f) {
                float[] fArr = this.u;
                fArr[0] = 1.0f;
                fArr[1] = 1.0f;
            } else {
                this.u[0] = ((float) Math.floor(f2 * 49.0f)) + 1.0f;
                this.u[1] = ((float) Math.floor(f3 * 49.0f)) + 1.0f;
            }
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            a(LayerRenderer.this.g(), LayerRenderer.this.g());
            b(LayerRenderer.this.p(), LayerRenderer.this.o());
            int a2 = oVar.a();
            GLES20.glActiveTexture(a2 + 33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.p);
            LayerRenderer.A();
            GLES20.glUniform1i(this.j, a2);
            LayerRenderer.A();
            int a3 = oVar.a();
            GLES20.glActiveTexture(33984 + a3);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.q);
            LayerRenderer.A();
            GLES20.glUniform1i(this.k, a3);
            LayerRenderer.A();
            GLES20.glUniform1f(this.m, this.s);
            GLES20.glEnableVertexAttribArray(this.f24500h);
            LayerRenderer.A();
            GLES20.glEnableVertexAttribArray(this.i);
            LayerRenderer.A();
            LayerRenderer.this.a(this.l, 1, true, this.r, 0);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.f24500h, 4, 5126, false, 0, (Buffer) this.n);
            LayerRenderer.A();
            GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, (Buffer) this.o);
            LayerRenderer.A();
            int i = this.t;
            float[] fArr = this.u;
            GLES20.glUniform2f(i, fArr[0], fArr[1]);
            int i2 = this.v;
            float[] fArr2 = this.w;
            GLES20.glUniform2f(i2, fArr2[0], fArr2[1]);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24500h = GLES20.glGetAttribLocation(i, "a_position");
            this.i = GLES20.glGetAttribLocation(i, "a_texCoord");
            this.l = GLES20.glGetUniformLocation(i, "u_mvp_matrix");
            this.j = GLES20.glGetUniformLocation(i, "u_textureSampler");
            this.k = GLES20.glGetUniformLocation(i, "u_maskSampler");
            this.m = GLES20.glGetUniformLocation(i, "u_alpha_test");
            this.t = GLES20.glGetUniformLocation(i, "u_block_size");
            this.v = GLES20.glGetUniformLocation(i, "u_texture_size");
        }
    }

    /* loaded from: classes3.dex */
    public class l implements q {

        /* renamed from: a */
        private int f24501a;

        /* renamed from: b */
        k f24502b;

        /* renamed from: c */
        n f24503c;

        /* renamed from: d */
        e f24504d;

        /* renamed from: e */
        B f24505e;

        l() {
            this.f24502b = new k();
            this.f24504d = new e();
            this.f24503c = new n();
            this.f24505e = new B();
            this.f24502b.a(new m(LayerRenderer.this, null));
            this.f24504d.a(this.f24502b);
            this.f24503c.a(this.f24504d);
            this.f24505e.a(this.f24503c);
        }

        public void a(int i) {
            this.f24502b.c(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24505e.j());
            int a3 = a(35632, this.f24505e.h());
            this.f24501a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24501a, a2);
            GLES20.glAttachShader(this.f24501a, a3);
            GLES20.glLinkProgram(this.f24501a);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f24501a));
            this.f24505e.b(this.f24501a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24502b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24501a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24501a);
            this.f24502b.a(floatBuffer);
            this.f24502b.b(floatBuffer2);
            this.f24502b.d(i);
            this.f24504d.a(fArr2);
            this.f24502b.a(fArr);
            this.f24505e.a(f2);
            this.f24505e.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class m extends p {
        private m() {
            super();
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String a() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(o oVar) {
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String b() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(int i) {
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String g() {
            return "";
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public String i() {
            return "";
        }

        /* synthetic */ m(LayerRenderer layerRenderer, C2351b c2351b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class n extends p {

        /* renamed from: h */
        private int f24508h;
        private float[] i;

        n() {
            super();
            this.i = new float[4];
            d("");
            c("applyOverlay");
            b("");
            a("//Overlay Block\nuniform highp vec4 u_overlaycolor;\nhighp vec4 applyOverlay(highp vec4 color){\n        color.rgb = color.rgb * (1.0 - u_overlaycolor.a) + u_overlaycolor.rgb * color.a;\n        return color;\n}");
            k();
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24508h = GLES20.glGetUniformLocation(i, "u_overlaycolor");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            int i = this.f24508h;
            float[] fArr = this.i;
            GLES20.glUniform4f(i, fArr[0], fArr[1], fArr[2], fArr[3]);
        }

        public void k() {
            float[] fArr = this.i;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
        }
    }

    /* loaded from: classes3.dex */
    public class o {

        /* renamed from: a */
        private int f24509a = 0;

        o() {
        }

        public int a() {
            int i = this.f24509a;
            this.f24509a = i + 1;
            return i;
        }
    }

    /* loaded from: classes3.dex */
    public class p {

        /* renamed from: a */
        private p f24511a;

        /* renamed from: b */
        private String f24512b = "";

        /* renamed from: c */
        private String f24513c = "";

        /* renamed from: d */
        private String f24514d = "";

        /* renamed from: e */
        private String f24515e = "";

        /* renamed from: f */
        private String f24516f = "";

        p() {
        }

        public void a(int i) {
        }

        public void a(String str) {
            this.f24516f = str;
        }

        public void b(o oVar) {
        }

        public void b(String str) {
            this.f24515e = str;
        }

        public void c(String str) {
            this.f24514d = str;
        }

        public void d(String str) {
            this.f24513c = str;
        }

        public final String e() {
            return this.f24514d;
        }

        public final String f() {
            return this.f24513c;
        }

        public String g() {
            return this.f24511a.g() + c();
        }

        public final String h() {
            return g() + "\nuniform highp float alpha_test_value_;\nvoid main(){\nhighp vec4 color = " + a() + ";\nif(color.a > 0.0) gl_FragColor = color;\nelse discard;\n}\n";
        }

        public String i() {
            return this.f24511a.i() + d();
        }

        public final String j() {
            return i() + "\nvoid main(){\n" + b() + "\n}\n";
        }

        public void a(p pVar) {
            this.f24511a = pVar;
        }

        public String b() {
            String str = this.f24511a.b() + f();
            if (f() == "") {
                return str;
            }
            return str + "();";
        }

        public final String c() {
            return this.f24516f;
        }

        public final String d() {
            return this.f24515e;
        }

        public String a() {
            String a2 = this.f24511a.a();
            if (e() == "") {
                return a2;
            }
            return e() + "(" + a2 + ")";
        }

        public void b(int i) {
            a(i);
            this.f24511a.b(i);
        }

        public void a(o oVar) {
            b(oVar);
            this.f24511a.a(oVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface q {
        void a(float f2);

        void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

        void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface s extends q {
        void a(float f2, float f3, float f4);

        void a(float f2, float f3, float f4, float f5);

        void a(int i, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public class w implements q {

        /* renamed from: a */
        private int f24546a;

        /* renamed from: b */
        C2347a f24547b;

        /* renamed from: c */
        e f24548c;

        /* renamed from: d */
        n f24549d;

        /* renamed from: e */
        B f24550e;

        /* renamed from: f */
        j f24551f;

        w() {
            this.f24547b = new C2347a();
            this.f24548c = new e();
            this.f24549d = new n();
            this.f24550e = new B();
            this.f24551f = new j();
            this.f24547b.a(new m(LayerRenderer.this, null));
            this.f24548c.a(this.f24547b);
            this.f24549d.a(this.f24548c);
            this.f24550e.a(this.f24549d);
            this.f24551f.a(this.f24550e);
        }

        public void a(int i) {
            this.f24551f.c(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24551f.j());
            int a3 = a(35632, this.f24551f.h());
            this.f24546a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24546a, a2);
            GLES20.glAttachShader(this.f24546a, a3);
            GLES20.glLinkProgram(this.f24546a);
            Log.e("error", GLES20.glGetProgramInfoLog(this.f24546a));
            this.f24551f.b(this.f24546a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24547b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24546a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24546a);
            LayerRenderer.A();
            this.f24547b.a(floatBuffer);
            this.f24547b.b(floatBuffer2);
            this.f24547b.c(i);
            this.f24548c.a(fArr2);
            this.f24547b.a(fArr);
            this.f24550e.a(f2);
            this.f24551f.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class x implements s {

        /* renamed from: a */
        private int f24553a;

        /* renamed from: b */
        C2347a f24554b;

        /* renamed from: c */
        e f24555c;

        /* renamed from: d */
        n f24556d;

        /* renamed from: e */
        B f24557e;

        /* renamed from: f */
        j f24558f;

        /* renamed from: g */
        d f24559g;

        x() {
            this.f24554b = new C2347a();
            this.f24555c = new e();
            this.f24556d = new n();
            this.f24557e = new B();
            this.f24558f = new j();
            this.f24559g = new d();
            this.f24554b.a(new m(LayerRenderer.this, null));
            this.f24559g.a(this.f24554b);
            this.f24555c.a(this.f24559g);
            this.f24556d.a(this.f24555c);
            this.f24557e.a(this.f24556d);
            this.f24558f.a(this.f24557e);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.f24559g.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4, float f5) {
            this.f24559g.a(f2, f3, f4, f5);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4) {
            this.f24559g.a(f2, f3, f4);
        }

        public void a(int i) {
            this.f24558f.c(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24558f.j());
            int a3 = a(35632, this.f24558f.h());
            this.f24553a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24553a, a2);
            GLES20.glAttachShader(this.f24553a, a3);
            GLES20.glLinkProgram(this.f24553a);
            Log.e("error", GLES20.glGetProgramInfoLog(this.f24553a));
            this.f24558f.b(this.f24553a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24554b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24553a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24553a);
            LayerRenderer.A();
            this.f24554b.a(floatBuffer);
            this.f24554b.b(floatBuffer2);
            this.f24554b.c(i);
            this.f24555c.a(fArr2);
            this.f24554b.a(fArr);
            this.f24557e.a(f2);
            this.f24558f.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class y implements s {

        /* renamed from: a */
        private int f24561a;

        /* renamed from: b */
        C2347a f24562b;

        /* renamed from: c */
        e f24563c;

        /* renamed from: d */
        n f24564d;

        /* renamed from: e */
        B f24565e;

        /* renamed from: f */
        j f24566f;

        /* renamed from: g */
        d f24567g;

        /* renamed from: h */
        f f24568h;

        y() {
            this.f24562b = new C2347a();
            this.f24563c = new e();
            this.f24564d = new n();
            this.f24565e = new B();
            this.f24568h = new f();
            this.f24566f = new j();
            this.f24567g = new d();
            this.f24562b.a(new m(LayerRenderer.this, null));
            this.f24567g.a(this.f24562b);
            this.f24563c.a(this.f24567g);
            this.f24564d.a(this.f24563c);
            this.f24565e.a(this.f24564d);
            this.f24568h.a(this.f24565e);
            this.f24566f.a(this.f24568h);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.f24567g.a(i, i2, i3);
        }

        public void b(int i) {
            this.f24566f.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4, float f5) {
            this.f24567g.a(f2, f3, f4, f5);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4) {
            this.f24567g.a(f2, f3, f4);
        }

        public void a(int i) {
            this.f24568h.c(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24566f.j());
            int a3 = a(35632, this.f24566f.h());
            this.f24561a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24561a, a2);
            GLES20.glAttachShader(this.f24561a, a3);
            GLES20.glLinkProgram(this.f24561a);
            Log.e("error", GLES20.glGetProgramInfoLog(this.f24561a));
            this.f24566f.b(this.f24561a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24562b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24561a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24561a);
            LayerRenderer.A();
            this.f24562b.a(floatBuffer);
            this.f24562b.b(floatBuffer2);
            this.f24562b.c(i);
            this.f24563c.a(fArr2);
            this.f24562b.a(fArr);
            this.f24565e.a(f2);
            this.f24566f.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* loaded from: classes3.dex */
    public class z implements q {

        /* renamed from: a */
        private int f24569a;

        /* renamed from: b */
        C2347a f24570b;

        /* renamed from: c */
        e f24571c;

        /* renamed from: d */
        n f24572d;

        /* renamed from: e */
        B f24573e;

        /* renamed from: f */
        j f24574f;

        /* renamed from: g */
        f f24575g;

        z() {
            this.f24570b = new C2347a();
            this.f24571c = new e();
            this.f24572d = new n();
            this.f24573e = new B();
            this.f24575g = new f();
            this.f24574f = new j();
            this.f24570b.a(new m(LayerRenderer.this, null));
            this.f24571c.a(this.f24570b);
            this.f24572d.a(this.f24571c);
            this.f24573e.a(this.f24572d);
            this.f24575g.a(this.f24573e);
            this.f24574f.a(this.f24575g);
        }

        public void a(int i) {
            this.f24575g.c(i);
        }

        public void b(int i) {
            this.f24574f.c(i);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24574f.j());
            int a3 = a(35632, this.f24574f.h());
            this.f24569a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24569a, a2);
            GLES20.glAttachShader(this.f24569a, a3);
            GLES20.glLinkProgram(this.f24569a);
            Log.e("error", GLES20.glGetProgramInfoLog(this.f24569a));
            this.f24574f.b(this.f24569a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24570b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24569a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24569a);
            LayerRenderer.A();
            this.f24570b.a(floatBuffer);
            this.f24570b.b(floatBuffer2);
            this.f24570b.c(i);
            this.f24571c.a(fArr2);
            this.f24570b.a(fArr);
            this.f24573e.a(f2);
            this.f24574f.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    public static void A() {
        boolean z2 = true;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            if (z2) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                Log.e("LayerRenderer", "GLError(s) detected at:");
                for (int i2 = 0; i2 < stackTrace.length && i2 < 5; i2++) {
                    Log.e("LayerRenderer", "    " + i2 + ": " + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + " (" + stackTrace[i2].getClassName() + "." + stackTrace[i2].getMethodName() + ")");
                }
                z2 = false;
            }
            Log.e("LayerRenderer", "GLError: 0x" + Integer.toHexString(glGetError) + " (" + GLU.gluErrorString(glGetError) + ")");
        }
    }

    private void B() {
        ArrayList arrayList = null;
        for (Integer num : this.B) {
            if (!this.A.containsValue(num)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(num);
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f24455a[0] = ((Integer) it.next()).intValue();
                GLES20.glDeleteTextures(1, f24455a, 0);
                A();
            }
            this.B.removeAll(arrayList);
        }
    }

    private void C() {
        ArrayList arrayList = null;
        for (i iVar : this.v) {
            if (!this.u.containsValue(iVar)) {
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
            this.v.removeAll(arrayList);
        }
    }

    public void c(float f2) {
        this.n = f2;
    }

    public void d(float f2) {
        this.m = f2;
    }

    public int e() {
        return this.oa ? 1 : 0;
    }

    public int f() {
        return this.f24457c;
    }

    public float g() {
        return this.l;
    }

    public Object h() {
        return this.Ba;
    }

    public boolean i() {
        return this.la;
    }

    public float j() {
        return this.f24459e;
    }

    public float k() {
        return this.f24458d;
    }

    public RenderMode l() {
        return this.Aa;
    }

    public float m() {
        return this.f24461g;
    }

    public float n() {
        return this.f24460f;
    }

    public float o() {
        return this.n;
    }

    public float p() {
        return this.m;
    }

    public void q() {
        C();
        B();
    }

    public void r() {
        A();
        this.k = 1.0f;
        C();
        B();
        Matrix.setIdentityM(this.f24462h, 0);
        this.o = 0;
        this.ua.reset();
        int i2 = this.f24458d;
        float f2 = i2 * 0.5f;
        int i3 = this.f24459e;
        Matrix.perspectiveM(this.f24462h, 0, 45.0f, i2 / i3, 1.0f, 3000.0f);
        float[] fArr = this.f24462h;
        float f3 = fArr[0] * f2;
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(this.f24462h, 0, -f2, -(i3 * 0.5f), -f3);
        this.ya.rewind();
        this.ya.put(f24456b);
        this.ya.rewind();
        v();
    }

    public void s() {
        if (this.Ea) {
            GLES20.glDisable(2929);
        }
    }

    public void t() {
        this.Ea = false;
    }

    public void u() {
        int i2 = this.f24458d;
        float f2 = i2 * 0.5f;
        int i3 = this.f24459e;
        Matrix.perspectiveM(this.f24462h, 0, 45.0f, i2 / i3, 0.01f, 3000.0f);
        float[] fArr = this.f24462h;
        Matrix.translateM(fArr, 0, -f2, -(i3 * 0.5f), -(fArr[0] * f2));
    }

    public void v() {
        GLES20.glEnable(3042);
        A();
        GLES20.glDisable(2884);
        A();
        GLES20.glDisable(2929);
        A();
        GLES20.glBlendFunc(1, 771);
        A();
    }

    public void w() {
        int i2 = this.o;
        if (i2 >= 1) {
            this.o = i2 - 1;
            float[] e2 = this.p[this.o].e();
            float[] fArr = this.f24462h;
            System.arraycopy(e2, 0, fArr, 0, fArr.length);
            this.k = this.p[this.o].a();
            this.i = this.p[this.o].g();
            this.j = this.p[this.o].h();
            this.f24457c = this.p[this.o].b();
            this.ua.set(this.p[this.o].c());
            if (this.ka != this.p[this.o].f()) {
                a(this.p[this.o].f());
            }
            d(this.p[this.o].d());
            return;
        }
        throw new IllegalStateException("Restore call without matching save");
    }

    public void x() {
        int i2 = this.o;
        A[] aArr = this.p;
        if (i2 >= aArr.length) {
            A[] aArr2 = new A[aArr.length + 16];
            System.arraycopy(aArr, 0, aArr2, 0, aArr.length);
            this.p = aArr2;
        }
        A[] aArr3 = this.p;
        int i3 = this.o;
        if (aArr3[i3] == null) {
            aArr3[i3] = new A(null);
        }
        this.p[this.o].a(this.f24462h, this.k, this.f24457c, this.ua, this.ka, this.la, this.i, this.j);
        this.o++;
    }

    public void y() {
        this.ja.a(0.0f);
        if (!this.Ea || this.k < 1.0d) {
            return;
        }
        GLES20.glDepthFunc(515);
        GLES20.glEnable(2929);
        this.ja.a(0.5f);
    }

    public void z() {
        this.Ea = true;
        if (this.Ea) {
            GLES20.glClear(256);
        }
    }

    public void b(boolean z2) {
        this.na = z2;
    }

    public void c(Bitmap bitmap) {
        if (bitmap == null) {
            this.ma = false;
            return;
        }
        this.ma = true;
        i d2 = d(bitmap);
        ((u) this.Q).a(d2.f24494a);
        ((y) this.W).a(d2.f24494a);
        this.N.a(d2.f24494a);
        this.Z.a(d2.f24494a);
    }

    public void d(boolean z2) {
        this.la = z2;
    }

    public void e(boolean z2) {
        this.ra = z2;
    }

    public void f(boolean z2) {
        if (z2) {
            this.u = this.q;
            this.v = this.r;
            this.A = this.w;
            this.B = this.x;
            this.H = this.D;
            this.G = this.F;
            this.Q = this.P;
            this.T = this.S;
            this.W = this.V;
            this.K = this.J;
            this.N = this.M;
            this.Z = this.Y;
            this.ca = this.ba;
            this.fa = this.ea;
            this.ia = this.ha;
            this.ja = this.H;
        } else {
            this.u = this.s;
            this.v = this.t;
            this.A = this.y;
            this.B = this.z;
            this.H = this.C;
            this.G = this.E;
            this.Q = this.O;
            this.T = this.R;
            this.W = this.U;
            this.K = this.I;
            this.N = this.L;
            this.Z = this.X;
            this.ca = this.aa;
            this.fa = this.da;
            this.ia = this.ga;
            this.ja = this.H;
        }
        this.Aa = z2 ? RenderMode.Export : RenderMode.Preview;
        NexEditor i2 = EditorGlobal.i();
        if (i2 != null) {
            int e2 = i2.e(this.Aa.id);
            this.ia.a(e2);
            this.ca.a(e2);
            this.fa.a(e2);
            this.K.a(e2);
            this.Z.b(e2);
            ((x) this.T).a(e2);
            ((y) this.W).b(e2);
        }
    }

    public void g(boolean z2) {
        this.qa = z2;
    }

    /* loaded from: classes3.dex */
    public static class A {

        /* renamed from: a */
        private float[] f24463a;

        /* renamed from: b */
        private float f24464b;

        /* renamed from: c */
        private float f24465c;

        /* renamed from: d */
        private float f24466d;

        /* renamed from: e */
        private int f24467e;

        /* renamed from: f */
        private ColorMatrix f24468f;

        /* renamed from: g */
        private RenderTarget f24469g;

        /* renamed from: h */
        private boolean f24470h;

        private A() {
            this.f24463a = new float[16];
            this.f24468f = new ColorMatrix();
        }

        void a(float[] fArr, float f2, int i, ColorMatrix colorMatrix, RenderTarget renderTarget, boolean z, float f3, float f4) {
            float[] fArr2 = this.f24463a;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f24464b = f2;
            this.f24467e = i;
            this.f24468f.set(colorMatrix);
            this.f24469g = renderTarget;
            this.f24470h = z;
            this.f24465c = f3;
            this.f24466d = f4;
        }

        public int b() {
            return this.f24467e;
        }

        public ColorMatrix c() {
            return this.f24468f;
        }

        public boolean d() {
            return this.f24470h;
        }

        public float[] e() {
            return this.f24463a;
        }

        public RenderTarget f() {
            return this.f24469g;
        }

        public float g() {
            return this.f24465c;
        }

        public float h() {
            return this.f24466d;
        }

        /* synthetic */ A(C2351b c2351b) {
            this();
        }

        public float a() {
            return this.f24464b;
        }
    }

    /* loaded from: classes3.dex */
    public class v implements q {

        /* renamed from: a */
        private int f24539a;

        /* renamed from: b */
        C2347a f24540b;

        /* renamed from: c */
        e f24541c;

        /* renamed from: d */
        n f24542d;

        /* renamed from: e */
        B f24543e;

        /* renamed from: f */
        f f24544f;

        v() {
            this.f24540b = new C2347a();
            this.f24541c = new e();
            this.f24542d = new n();
            this.f24543e = new B();
            this.f24544f = new f();
            this.f24540b.a(new m(LayerRenderer.this, null));
            this.f24541c.a(this.f24540b);
            this.f24542d.a(this.f24541c);
            this.f24543e.a(this.f24542d);
            this.f24544f.a(this.f24543e);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24544f.j());
            int a3 = a(35632, this.f24544f.h());
            this.f24539a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24539a, a2);
            GLES20.glAttachShader(this.f24539a, a3);
            GLES20.glLinkProgram(this.f24539a);
            Log.e("error", GLES20.glGetProgramInfoLog(this.f24539a));
            this.f24544f.b(this.f24539a);
        }

        public void a(int i) {
            this.f24544f.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24540b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24539a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24539a);
            LayerRenderer.A();
            this.f24540b.a(floatBuffer);
            this.f24540b.b(floatBuffer2);
            this.f24540b.c(i);
            this.f24541c.a(fArr2);
            this.f24540b.a(fArr);
            this.f24543e.a(f2);
            this.f24544f.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    private i d(Bitmap bitmap) {
        i iVar = this.u.get(bitmap);
        if (iVar != null) {
            iVar.a(bitmap);
            A();
            return iVar;
        }
        i iVar2 = new i(bitmap);
        A();
        this.u.put(bitmap, iVar2);
        this.v.add(iVar2);
        return iVar2;
    }

    public void a(Object obj) {
        this.Ba = obj;
    }

    public void b(float f2) {
        this.l = f2;
    }

    /* loaded from: classes3.dex */
    public class C implements q {

        /* renamed from: a */
        private int f24472a;

        /* renamed from: b */
        C2349c f24473b;

        /* renamed from: c */
        n f24474c;

        /* renamed from: d */
        e f24475d;

        /* renamed from: e */
        B f24476e;

        C() {
            this.f24473b = new C2349c();
            this.f24475d = new e();
            this.f24474c = new n();
            this.f24476e = new B();
            this.f24473b.a(new m(LayerRenderer.this, null));
            this.f24475d.a(this.f24473b);
            this.f24474c.a(this.f24475d);
            this.f24476e.a(this.f24474c);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24476e.j());
            int a3 = a(35632, this.f24476e.h());
            this.f24472a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24472a, a2);
            GLES20.glAttachShader(this.f24472a, a3);
            GLES20.glLinkProgram(this.f24472a);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f24472a));
            this.f24476e.b(this.f24472a);
        }

        public void a(int i) {
            this.f24473b.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24473b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24472a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24472a);
            this.f24473b.a(floatBuffer);
            this.f24473b.b(floatBuffer2);
            this.f24473b.d(i);
            this.f24475d.a(fArr2);
            this.f24473b.a(fArr);
            this.f24476e.a(f2);
            this.f24476e.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends p {

        /* renamed from: h */
        private int f24481h;
        private int i;
        private int j;
        private int k;
        private float[] l;
        private float[] m;
        private float[] n;

        d() {
            super();
            this.l = new float[3];
            this.m = new float[4];
            this.n = new float[3];
            d("");
            c("applyChromakey");
            b("");
            a("uniform highp vec3 u_keyvalue;\nuniform highp vec3 u_strength;\nuniform highp vec4 u_division;\nuniform int CKMaskOnOff;\nhighp float proportionalstep(highp float edge0, highp float edge1, highp float x){\nx = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\nreturn x;\n}\nhighp vec4 applyChromakey(highp vec4 color){\nconst highp mat4 rgbyuv = mat4(\n\t\t\t0.300, 0.589, 0.111, -0.003,\n\t\t\t-0.169, -0.332, 0.502, 0.502,\n\t\t\t0.499, -0.420, -0.079, 0.502,\n\t\t\t0.000, 0.000, 0.000, 1.000);\nconst highp mat4 yuvrgb = mat4(\n\t\t\t1.000, 0.000, 1.402, -0.701,\n\t\t\t1.000, -0.334, -0.714, 0.529,\n\t\t\t1.000, 1.772, 0.000, -0.886,\n\t\t\t0.000, 0.000, 0.000, 1.000);\nhighp vec4 yuv = color * rgbyuv;\nhighp vec4 yuv_key = vec4(u_keyvalue, 1.0) * rgbyuv;\nhighp float radius = length(vec2(yuv.gb) - vec2(yuv_key.gb));\nhighp float alpha = proportionalstep(u_division.x, u_division.y, radius) * u_strength.x\n+ proportionalstep(u_division.y, u_division.z, radius) * u_strength.y\n+ proportionalstep(u_division.z, u_division.w, radius) * u_strength.z;\nif(CKMaskOnOff == 1){\ncolor = color * 0.000001 + vec4(alpha, alpha, alpha, 1.0);}\nelse{\ncolor = color * alpha;}\n\t\treturn color;\n\t}");
            a(0, 255, 0);
            a(0.3f, 0.4f, 0.45f, 0.5f);
            a(0.05f, 0.3f, 0.65f);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void a(int i) {
            this.f24481h = GLES20.glGetUniformLocation(i, "u_keyvalue");
            this.i = GLES20.glGetUniformLocation(i, "u_division");
            this.j = GLES20.glGetUniformLocation(i, "u_strength");
            this.k = GLES20.glGetUniformLocation(i, "CKMaskOnOff");
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.p
        public void b(o oVar) {
            int e2 = LayerRenderer.this.e();
            int i = this.f24481h;
            float[] fArr = this.l;
            GLES20.glUniform3f(i, fArr[0], fArr[1], fArr[2]);
            int i2 = this.i;
            float[] fArr2 = this.m;
            GLES20.glUniform4f(i2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
            int i3 = this.j;
            float[] fArr3 = this.n;
            GLES20.glUniform3f(i3, fArr3[0], fArr3[1], fArr3[2]);
            GLES20.glUniform1i(this.k, e2);
        }

        public void a(int i, int i2, int i3) {
            float[] fArr = this.l;
            fArr[0] = i / 255.0f;
            fArr[1] = i2 / 255.0f;
            fArr[2] = i3 / 255.0f;
        }

        public void a(float f2, float f3, float f4, float f5) {
            float[] fArr = this.m;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
        }

        public void a(float f2, float f3, float f4) {
            float[] fArr = this.n;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements q {

        /* renamed from: a */
        private int f24488a;

        /* renamed from: b */
        C2348b f24489b;

        /* renamed from: c */
        n f24490c;

        /* renamed from: d */
        e f24491d;

        /* renamed from: e */
        B f24492e;

        h() {
            this.f24489b = new C2348b();
            this.f24491d = new e();
            this.f24490c = new n();
            this.f24492e = new B();
            this.f24489b.a(new m(LayerRenderer.this, null));
            this.f24491d.a(this.f24489b);
            this.f24490c.a(this.f24491d);
            this.f24492e.a(this.f24490c);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24492e.j());
            int a3 = a(35632, this.f24492e.h());
            this.f24488a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24488a, a2);
            GLES20.glAttachShader(this.f24488a, a3);
            GLES20.glLinkProgram(this.f24488a);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f24488a));
            this.f24492e.b(this.f24488a);
        }

        public void a(int i) {
            this.f24489b.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24489b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24488a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24488a);
            this.f24489b.a(floatBuffer);
            this.f24489b.b(floatBuffer2);
            this.f24489b.d(i);
            this.f24491d.a(fArr2);
            this.f24489b.a(fArr);
            this.f24492e.a(f2);
            this.f24492e.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class r implements q {

        /* renamed from: a */
        private int f24518a;

        /* renamed from: b */
        C2347a f24519b;

        /* renamed from: c */
        n f24520c;

        /* renamed from: d */
        e f24521d;

        /* renamed from: e */
        B f24522e;

        r() {
            this.f24519b = new C2347a();
            this.f24521d = new e();
            this.f24520c = new n();
            this.f24522e = new B();
            this.f24519b.a(new m(LayerRenderer.this, null));
            this.f24521d.a(this.f24519b);
            this.f24520c.a(this.f24521d);
            this.f24522e.a(this.f24520c);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        void a() {
            int a2 = a(35633, this.f24522e.j());
            int a3 = a(35632, this.f24522e.h());
            this.f24518a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24518a, a2);
            GLES20.glAttachShader(this.f24518a, a3);
            GLES20.glLinkProgram(this.f24518a);
            Log.e("layererrenderer", GLES20.glGetProgramInfoLog(this.f24518a));
            this.f24522e.b(this.f24518a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24519b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24518a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24518a);
            this.f24519b.a(floatBuffer);
            this.f24519b.b(floatBuffer2);
            this.f24519b.c(i);
            this.f24521d.a(fArr2);
            this.f24519b.a(fArr);
            this.f24522e.a(f2);
            this.f24522e.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class t implements s {

        /* renamed from: a */
        private int f24524a;

        /* renamed from: b */
        C2347a f24525b;

        /* renamed from: c */
        n f24526c;

        /* renamed from: d */
        B f24527d;

        /* renamed from: e */
        e f24528e;

        /* renamed from: f */
        d f24529f;

        t() {
            this.f24525b = new C2347a();
            this.f24529f = new d();
            this.f24528e = new e();
            this.f24526c = new n();
            this.f24527d = new B();
            this.f24525b.a(new m(LayerRenderer.this, null));
            this.f24529f.a(this.f24525b);
            this.f24528e.a(this.f24529f);
            this.f24526c.a(this.f24528e);
            this.f24527d.a(this.f24526c);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        private void a() {
            int a2 = a(35633, this.f24527d.j());
            int a3 = a(35632, this.f24527d.h());
            this.f24524a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24524a, a2);
            GLES20.glAttachShader(this.f24524a, a3);
            GLES20.glLinkProgram(this.f24524a);
            GLES20.glGetProgramInfoLog(this.f24524a);
            this.f24527d.b(this.f24524a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.f24529f.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4, float f5) {
            this.f24529f.a(f2, f3, f4, f5);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4) {
            this.f24529f.a(f2, f3, f4);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24525b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24524a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24524a);
            this.f24525b.a(floatBuffer);
            this.f24525b.b(floatBuffer2);
            this.f24525b.c(i);
            this.f24528e.a(fArr2);
            this.f24525b.a(fArr);
            this.f24527d.a(f2);
            this.f24527d.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class u implements s {

        /* renamed from: a */
        private int f24531a;

        /* renamed from: b */
        C2347a f24532b;

        /* renamed from: c */
        e f24533c;

        /* renamed from: d */
        n f24534d;

        /* renamed from: e */
        B f24535e;

        /* renamed from: f */
        d f24536f;

        /* renamed from: g */
        f f24537g;

        u() {
            this.f24532b = new C2347a();
            this.f24536f = new d();
            this.f24533c = new e();
            this.f24534d = new n();
            this.f24535e = new B();
            this.f24537g = new f();
            this.f24532b.a(new m(LayerRenderer.this, null));
            this.f24536f.a(this.f24532b);
            this.f24533c.a(this.f24536f);
            this.f24534d.a(this.f24533c);
            this.f24535e.a(this.f24534d);
            this.f24537g.a(this.f24535e);
        }

        public int a(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderInfoLog(glCreateShader);
            return glCreateShader;
        }

        private void a() {
            int a2 = a(35633, this.f24537g.j());
            int a3 = a(35632, this.f24537g.h());
            this.f24531a = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.f24531a, a2);
            GLES20.glAttachShader(this.f24531a, a3);
            GLES20.glLinkProgram(this.f24531a);
            GLES20.glGetProgramInfoLog(this.f24531a);
            this.f24537g.b(this.f24531a);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(int i, int i2, int i3) {
            this.f24536f.a(i, i2, i3);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4, float f5) {
            this.f24536f.a(f2, f3, f4, f5);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.s
        public void a(float f2, float f3, float f4) {
            this.f24536f.a(f2, f3, f4);
        }

        public void a(int i) {
            this.f24537g.c(i);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(float f2) {
            this.f24532b.a(f2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(i iVar, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            a(iVar.f24494a, fArr, fArr2, f2, floatBuffer, floatBuffer2);
        }

        @Override // com.nextreaming.nexvideoeditor.LayerRenderer.q
        public void a(int i, float[] fArr, float[] fArr2, float f2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
            if (this.f24531a == 0) {
                a();
            }
            GLES20.glUseProgram(this.f24531a);
            this.f24532b.a(floatBuffer);
            this.f24532b.b(floatBuffer2);
            this.f24532b.c(i);
            this.f24533c.a(fArr2);
            this.f24532b.a(fArr);
            this.f24535e.a(f2);
            this.f24537g.a(new o());
            GLES20.glDrawArrays(5, 0, 4);
            LayerRenderer.A();
        }
    }

    public void a(RenderTarget renderTarget) {
        this.ka = renderTarget;
        NexEditor i2 = EditorGlobal.i();
        if (i2 == null) {
            return;
        }
        int i3 = C2351b.f24689a[renderTarget.ordinal()];
        if (i3 == 1) {
            i2.n(l().id);
        } else {
            if (i3 == 2) {
                i2.m(l().id);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void b(Bitmap bitmap) {
        if (this.u.remove(bitmap) != null) {
            C();
        }
    }

    public void b(int i2, float f2, float f3, float f4, float f5) {
        if (i2 < 0) {
            return;
        }
        float f6 = f4 / 2.0f;
        float f7 = f5 / 2.0f;
        d(i2, f2 - f6, f3 - f7, f2 + f6, f3 + f7);
    }

    private void b(int i2, int i3, String str, int i4, int i5, int i6, float f2, float f3, float f4, float f5, float f6, boolean z2) {
        NexEditor i7 = EditorGlobal.i();
        if (i7 != null) {
            Matrix.transposeM(this.wa, 0, this.f24462h, 0);
            i7.a(i2, i3, str, this.Aa.id, i4, i5, i6, this.wa, f2, f3, f4, f5, f6, z2);
        }
    }

    private void d(int i2, float f2, float f3, float f4, float f5) {
        c(f2, f3, f4, f5);
        this.ja.a(i2, this.f24462h, this.va, this.k, this.xa, this.ya);
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: a */
        int f24484a;

        /* renamed from: b */
        float f24485b;

        /* renamed from: c */
        float f24486c;

        /* renamed from: d */
        boolean f24487d = false;

        public g(float f2, float f3) {
            this.f24485b = f2;
            this.f24486c = f3;
            GLES20.glGenTextures(1, LayerRenderer.f24455a, 0);
            LayerRenderer.A();
            this.f24484a = LayerRenderer.f24455a[0];
            GLES20.glActiveTexture(33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.f24484a);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10241, 9729);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10240, 9729);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10242, 33071);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10243, 33071);
            LayerRenderer.A();
            GLES20.glTexImage2D(3553, 0, 6408, (int) this.f24485b, (int) this.f24486c, 0, 6408, 5121, null);
            LayerRenderer.A();
        }

        public void a(float f2, float f3, float f4, float f5) {
            if (f4 == this.f24485b && f5 == this.f24486c) {
                GLES20.glActiveTexture(33984);
                LayerRenderer.A();
                GLES20.glBindTexture(3553, this.f24484a);
                LayerRenderer.A();
                GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, (int) f2, (int) f3, (int) f4, (int) f5);
                return;
            }
            this.f24485b = f4;
            this.f24486c = f5;
            GLES20.glActiveTexture(33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.f24484a);
            LayerRenderer.A();
            GLES20.glCopyTexImage2D(3553, 0, 6408, (int) f2, (int) f3, (int) this.f24485b, (int) this.f24486c, 0);
        }

        public int b() {
            return this.f24484a;
        }

        public float c() {
            return this.f24485b;
        }

        public float a() {
            return this.f24486c;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a */
        int f24494a;

        /* renamed from: b */
        int f24495b;

        /* renamed from: c */
        int f24496c;

        /* renamed from: d */
        int f24497d;

        /* renamed from: e */
        boolean f24498e = false;

        public i(Bitmap bitmap) {
            LayerRenderer.A();
            this.f24495b = bitmap.getWidth();
            this.f24496c = bitmap.getHeight();
            this.f24497d = bitmap.getGenerationId();
            GLES20.glGenTextures(1, LayerRenderer.f24455a, 0);
            LayerRenderer.A();
            this.f24494a = LayerRenderer.f24455a[0];
            GLES20.glActiveTexture(33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.f24494a);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10241, 9729);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10240, 9729);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10242, 33071);
            LayerRenderer.A();
            GLES20.glTexParameteri(3553, 10243, 33071);
            LayerRenderer.A();
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            if (GLES20.glGetError() != 0) {
                a(3553, 0, bitmap, 0);
                LayerRenderer.A();
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
            if (bitmap.getGenerationId() == this.f24497d) {
                return;
            }
            this.f24497d = bitmap.getGenerationId();
            if (bitmap.getWidth() == this.f24495b && bitmap.getHeight() == this.f24496c) {
                GLES20.glActiveTexture(33984);
                LayerRenderer.A();
                GLES20.glBindTexture(3553, this.f24494a);
                LayerRenderer.A();
                GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
                LayerRenderer.A();
                return;
            }
            this.f24495b = bitmap.getWidth();
            this.f24496c = bitmap.getHeight();
            GLES20.glActiveTexture(33984);
            LayerRenderer.A();
            GLES20.glBindTexture(3553, this.f24494a);
            LayerRenderer.A();
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            LayerRenderer.A();
        }

        public void a() {
            if (this.f24498e) {
                return;
            }
            LayerRenderer.f24455a[0] = this.f24494a;
            GLES20.glDeleteTextures(1, LayerRenderer.f24455a, 0);
            LayerRenderer.A();
            this.f24494a = 0;
            this.f24498e = true;
        }
    }

    public void c(boolean z2) {
        this.oa = z2;
    }

    private void c(float f2, float f3, float f4, float f5) {
        if (this.na && this.la && this.ma) {
            this.ja = this.W;
        } else if (this.na && this.la) {
            this.ja = this.T;
        } else if (this.na && this.ma) {
            this.ja = this.Q;
        } else if (this.na) {
            this.ja = this.G;
        } else if (this.la && this.ma) {
            this.ja = this.Z;
        } else if (this.ma) {
            this.ja = this.N;
        } else if (this.pa) {
            this.ja = this.ca;
        } else if (this.qa) {
            this.ja = this.fa;
        } else if (this.ra) {
            this.ja = this.ia;
        } else if (this.la) {
            this.ja = this.K;
        } else {
            this.ja = this.H;
        }
        float[] array = this.ua.getArray();
        float[] fArr = this.va;
        fArr[0] = array[0];
        fArr[1] = array[1];
        fArr[2] = array[2];
        fArr[3] = array[4];
        fArr[4] = array[5];
        fArr[5] = array[6];
        fArr[6] = array[7];
        fArr[7] = array[9];
        fArr[8] = array[10];
        fArr[9] = array[11];
        fArr[10] = array[12];
        fArr[11] = array[14];
        fArr[12] = array[15];
        fArr[13] = array[16];
        fArr[14] = array[17];
        fArr[15] = 1.0f;
        float[] fArr2 = this.za;
        fArr2[14] = 0.0f;
        fArr2[10] = 0.0f;
        fArr2[6] = 0.0f;
        fArr2[2] = 0.0f;
        fArr2[15] = 1.0f;
        fArr2[11] = 1.0f;
        fArr2[7] = 1.0f;
        fArr2[3] = 1.0f;
        fArr2[8] = f2;
        fArr2[0] = f2;
        fArr2[5] = f5;
        fArr2[1] = f5;
        fArr2[12] = f4;
        fArr2[4] = f4;
        fArr2[13] = f3;
        fArr2[9] = f3;
        this.xa.rewind();
        this.xa.put(this.za);
        this.xa.rewind();
    }

    public void a(int i2, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f3 * f3;
        float f9 = f2 * f2;
        float f10 = f9 - f8;
        float f11 = (f4 * f10) + f8;
        float f12 = (f6 * f10) + f8;
        float f13 = f7 - f5;
        float f14 = 1.0f - f7;
        int i3 = (i2 >> 16) & 255;
        int i4 = (i2 >> 8) & 255;
        int i5 = (i2 >> 0) & 255;
        for (q qVar : new q[]{this.G, this.T, this.Q, this.W}) {
            s sVar = (s) qVar;
            sVar.a(i3, i4, i5);
            sVar.a(f8, f11, f12, f9);
            sVar.a(f5, f13, f14);
        }
    }

    public void b(Bitmap bitmap, float f2, float f3) {
        if (bitmap == null) {
            return;
        }
        a(d(bitmap), f2, f3);
    }

    public float d() {
        return this.k;
    }

    public void b(float f2, float f3, float f4) {
        Matrix.translateM(this.f24462h, 0, f2, f3, f4);
    }

    public void b(float f2, float f3) {
        Matrix.translateM(this.f24462h, 0, f2, f3, 0.0f);
    }

    public void b(float f2, float f3, float f4, float f5) {
        this.i *= f2;
        this.j *= f3;
        b(f4, f5);
        Matrix.scaleM(this.f24462h, 0, f2, f3, 1.0f);
        b(-f4, -f5);
    }

    public void a(boolean z2) {
        this.pa = z2;
    }

    public g a(g gVar, float f2, float f3, float f4, float f5) {
        if (gVar != null) {
            gVar.a(f2, f3, f4, f5);
            return gVar;
        }
        g gVar2 = new g(f4, f5);
        gVar2.a(f2, f3, f4, f5);
        int b2 = gVar2.b();
        this.A.put(gVar2, Integer.valueOf(b2));
        this.B.add(Integer.valueOf(b2));
        return gVar2;
    }

    public void b(int i2) {
        this.f24457c = i2;
    }

    public void b(int i2, int i3) {
        this.f24460f = i2;
        this.f24461g = i3;
    }

    public int a(Bitmap bitmap, int i2) {
        Map<Bitmap, i> map;
        Set<i> set;
        if (bitmap == null) {
            return 0;
        }
        if (i2 == 1) {
            map = this.q;
            set = this.r;
        } else {
            map = this.s;
            set = this.t;
        }
        if (map == null) {
            return 0;
        }
        i iVar = map.get(bitmap);
        if (iVar != null) {
            iVar.a(bitmap);
            A();
        } else {
            iVar = new i(bitmap);
            A();
            map.put(bitmap, iVar);
            set.add(iVar);
        }
        return iVar.f24494a;
    }

    private void a(i iVar, float f2, float f3) {
        NexEditor i2 = EditorGlobal.i();
        if (i2 == null) {
            return;
        }
        i2.a(l().id, iVar.f24494a, f2, f3);
    }

    private void a(i iVar, float f2, float f3, float f4, float f5) {
        c(f2, f3, f4, f5);
        this.ja.a(iVar, this.f24462h, this.va, this.k, this.xa, this.ya);
    }

    public void a(int i2, int i3, boolean z2, float[] fArr, int i4) {
        if (z2) {
            Matrix.transposeM(this.wa, 0, fArr, 0);
            GLES20.glUniformMatrix4fv(i2, i3, false, this.wa, i4);
        } else {
            GLES20.glUniformMatrix4fv(i2, i3, false, fArr, i4);
        }
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4, float f5) {
        if (bitmap == null) {
            return;
        }
        i d2 = d(bitmap);
        A();
        a(d2, f2, f3, f4, f5);
    }

    public void a(int i2, String str, int i3, int i4, int i5, float f2, float f3, float f4, float f5, float f6, boolean z2) {
        b(i2, 0, str, i3, i4, i5, f2, f3, f4, f5, f6, z2);
    }

    public void a(int i2, int i3, String str, int i4, int i5, int i6, float f2, float f3, float f4, float f5, float f6, boolean z2) {
        NexEditor i7;
        if (i3 > 0 && (i7 = EditorGlobal.i()) != null) {
            i7.b(this.Aa.id);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(17664);
            b(i3, f2, f3, f4, f5);
            i7.c(this.Aa.id);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            float f7 = f4 / 2.0f;
            float f8 = f5 / 2.0f;
            b(i2, i7.d(this.Aa.id), str, i4, i5, i6, f2 - f7, f3 - f8, f2 + f7, f3 + f8, f6, z2);
        }
    }

    public void a(int i2, int i3, String str, String str2, int i4, int i5, int i6, float f2, float f3, float f4, float f5, float f6, boolean z2) {
        Log.d("LayerRenderer", "drawRenderItem case1");
        if (i3 < 0) {
            Log.d("LayerRenderer", "drawRenderItem case2");
            return;
        }
        NexEditor i7 = EditorGlobal.i();
        if (i7 != null) {
            Log.d("LayerRenderer", "drawRenderItem case3");
            i7.b(this.Aa.id);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(17664);
            b(i3, i7.d(this.Aa.id), str2, i4, i5, i6, f2, f3, f4, f5, f6, z2);
            i7.c(this.Aa.id);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            b(i2, i7.d(this.Aa.id), str, i4, i5, i6, f2, f3, f4, f5, f6, z2);
        }
    }

    public void c() {
        RenderTarget renderTarget = this.ka;
        RenderTarget renderTarget2 = RenderTarget.Mask;
        if (renderTarget != renderTarget2) {
            a(renderTarget2);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.ka != renderTarget) {
            a(renderTarget);
        }
    }

    public void a(int i2, Bitmap bitmap, String str, int i3, int i4, int i5, float f2, float f3, float f4, float f5, float f6, boolean z2) {
        NexEditor i6;
        if (bitmap == null || (i6 = EditorGlobal.i()) == null) {
            return;
        }
        i6.b(this.Aa.id);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(17664);
        a(bitmap, f2, f3, f4, f5);
        i6.c(this.Aa.id);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        b(i2, i6.d(this.Aa.id), str, i3, i4, i5, f2, f3, f4, f5, f6, z2);
    }

    public void c(int i2, float f2, float f3, float f4, float f5) {
        if (this.Ca == null) {
            this.Ca = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
            this.Ca.eraseColor(-1);
        }
        x();
        this.Da.setScale(Color.red(i2) / 255.0f, Color.green(i2) / 255.0f, Color.blue(i2) / 255.0f, 1.0f);
        a(this.Da);
        a(this.k * (Color.alpha(i2) / 255.0f));
        a(this.Ca, f2, f3, f4, f5);
        w();
    }

    public void a(int i2, Bitmap bitmap, String str, int i3, int i4, int i5, float f2, float f3, float f4, boolean z2) {
        NexEditor i6;
        if (bitmap == null || (i6 = EditorGlobal.i()) == null) {
            return;
        }
        i6.b(this.Aa.id);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(17664);
        i d2 = d(bitmap);
        int i7 = d2.f24495b;
        int i8 = d2.f24496c;
        a(d2, f2 - (i7 / 2), f3 - (i8 / 2), f2 + (i7 / 2), f3 + (i8 / 2));
        i6.c(this.Aa.id);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int d3 = i6.d(this.Aa.id);
        int i9 = d2.f24495b;
        int i10 = d2.f24496c;
        b(i2, d3, str, i3, i4, i5, f2 - (i9 / 2), f3 - (i10 / 2), f2 + (i9 / 2), f3 + (i10 / 2), f4, z2);
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (bitmap == null) {
            return;
        }
        i d2 = d(bitmap);
        A();
        this.ya.rewind();
        this.ya.put(new float[]{0.0f, f7, f6, f7, 0.0f, 0.0f, f6, 0.0f});
        this.ya.rewind();
        GLES20.glActiveTexture(33984);
        A();
        GLES20.glBindTexture(3553, d2.f24494a);
        A();
        GLES20.glTexParameteri(3553, 10241, 9729);
        A();
        GLES20.glTexParameteri(3553, 10240, 9729);
        A();
        GLES20.glTexParameteri(3553, 10242, 10497);
        A();
        GLES20.glTexParameteri(3553, 10243, 10497);
        A();
        a(d2, f2, f3, f4, f5);
        this.ya.rewind();
        this.ya.put(f24456b);
        this.ya.rewind();
        GLES20.glActiveTexture(33984);
        A();
        GLES20.glBindTexture(3553, d2.f24494a);
        A();
        GLES20.glTexParameteri(3553, 10241, 9729);
        A();
        GLES20.glTexParameteri(3553, 10240, 9729);
        A();
        GLES20.glTexParameteri(3553, 10242, 33071);
        A();
        GLES20.glTexParameteri(3553, 10243, 33071);
        A();
    }

    public void a(Bitmap bitmap, float f2, float f3) {
        if (bitmap == null) {
            return;
        }
        i d2 = d(bitmap);
        int i2 = d2.f24495b;
        int i3 = d2.f24496c;
        a(d2, f2 - (i2 / 2), f3 - (i3 / 2), f2 + (i2 / 2), f3 + (i3 / 2));
    }

    public void a(int i2) {
        RenderTarget renderTarget = this.ka;
        RenderTarget renderTarget2 = RenderTarget.Mask;
        if (renderTarget != renderTarget2) {
            a(renderTarget2);
        }
        GLES20.glClearColor(Color.red(i2) / 255.0f, Color.green(i2) / 255.0f, Color.blue(i2) / 255.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.ka != renderTarget) {
            a(renderTarget);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        d(bitmap);
    }

    public void a(ColorMatrix colorMatrix) {
        if (colorMatrix == null) {
            this.ua.reset();
        } else {
            this.ua.set(colorMatrix);
        }
    }

    public void a(int i2, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 + f6;
        c(i2, f2, f3, f7, f5);
        float f8 = f4 - f6;
        c(i2, f8, f3, f4, f5);
        c(i2, f7, f3, f8, f3 + f6);
        c(i2, f7, f5 - f6, f8, f5);
    }

    public void a(int i2, float f2, float f3, float f4, float f5) {
        if (this.Ca == null) {
            this.Ca = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
            this.Ca.eraseColor(-1);
        }
        x();
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, 4, 4);
        Matrix.multiplyMV(fArr[0], 0, this.f24462h, 0, new float[]{f2, f3, 0.0f, 1.0f}, 0);
        Matrix.multiplyMV(fArr[1], 0, this.f24462h, 0, new float[]{f4, f3, 0.0f, 1.0f}, 0);
        Matrix.multiplyMV(fArr[2], 0, this.f24462h, 0, new float[]{f2, f5, 0.0f, 1.0f}, 0);
        Matrix.multiplyMV(fArr[3], 0, this.f24462h, 0, new float[]{f4, f5, 0.0f, 1.0f}, 0);
        float f6 = 1.0E9f;
        float f7 = 1.0E9f;
        float f8 = -1.0E9f;
        float f9 = -1.0E9f;
        for (int i3 = 0; i3 < 4; i3++) {
            float[] fArr2 = fArr[i3];
            float f10 = fArr2[0] / fArr[i3][3];
            fArr2[0] = f10;
            float[] fArr3 = fArr[i3];
            float f11 = fArr3[1] / fArr[i3][3];
            fArr3[1] = f11;
            if (f10 < f6) {
                f6 = f10;
            }
            if (f10 > f8) {
                f8 = f10;
            }
            if (f11 < f7) {
                f7 = f11;
            }
            if (f11 > f9) {
                f9 = f11;
            }
        }
        float[] fArr4 = this.sa;
        float[] fArr5 = this.f24462h;
        System.arraycopy(fArr4, 0, fArr5, 0, fArr5.length);
        this.Da.setScale(Color.red(i2) / 255.0f, Color.green(i2) / 255.0f, Color.blue(i2) / 255.0f, 1.0f);
        a(this.Da);
        a(this.k * (Color.alpha(i2) / 255.0f));
        float n2 = 2.0f / n();
        float m2 = 2.0f / m();
        a(this.Ca, f6 - n2, f7 - m2, f8 + n2, f9 + m2);
        w();
    }

    public void a(float f2, float f3) {
        this.i *= f2;
        this.j *= f3;
        Matrix.scaleM(this.f24462h, 0, f2, f3, 1.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        Matrix.rotateM(this.f24462h, 0, f2, f3, f4, f5);
    }

    public void a(float f2, float f3, float f4) {
        b(f3, f4);
        a(f2, 0.0f, 0.0f, 1.0f);
        b(-f3, -f4);
    }

    public void a(float f2) {
        this.k = f2;
    }

    public void a(int i2, int i3) {
        this.f24458d = i2;
        this.f24459e = i3;
    }
}
