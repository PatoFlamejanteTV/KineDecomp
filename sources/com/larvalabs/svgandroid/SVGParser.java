package com.larvalabs.svgandroid;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes2.dex */
public class SVGParser {

    /* loaded from: classes2.dex */
    public enum Prefix {
        matrix,
        translate,
        scale,
        skewX,
        skewY,
        rotate
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a */
        private ArrayList<Float> f19275a;

        /* renamed from: b */
        private int f19276b;

        public b(ArrayList<Float> arrayList, int i) {
            this.f19275a = arrayList;
            this.f19276b = i;
        }

        public int a() {
            return this.f19276b;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a */
        private boolean f19277a;

        /* renamed from: b */
        private int f19278b;

        /* renamed from: c */
        private boolean f19279c;

        /* renamed from: d */
        private int f19280d;

        /* renamed from: e */
        private float f19281e;

        /* renamed from: f */
        private int f19282f;

        /* renamed from: g */
        private int f19283g;

        /* renamed from: h */
        private Map<Integer, Integer> f19284h;
        private Set<Integer> i;
        private int j;

        public c() {
            this.f19277a = false;
            this.f19278b = 0;
            this.f19279c = false;
            this.f19280d = 0;
            this.f19281e = 0.0f;
            this.f19282f = 0;
            this.f19283g = 0;
            this.i = new HashSet();
        }

        public int b(int i) {
            Map<Integer, Integer> map = this.f19284h;
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return this.f19284h.get(Integer.valueOf(i)).intValue();
            }
            Map<Integer, Integer> map2 = this.f19284h;
            if (map2 == null || this.j <= 0) {
                return i;
            }
            for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                int intValue = entry.getKey().intValue();
                if (Math.max(Math.max(Math.abs(Color.red(intValue) - Color.red(i)), Math.abs(Color.green(intValue) - Color.green(i))), Math.abs(Color.blue(intValue) - Color.blue(i))) <= this.j) {
                    int intValue2 = entry.getValue().intValue();
                    return Color.rgb(Math.max(0, Math.min(255, (Color.red(i) - Color.red(intValue)) + Color.red(intValue2))), Math.max(0, Math.min(255, (Color.green(i) - Color.green(intValue)) + Color.green(intValue2))), Math.max(0, Math.min(255, (Color.blue(i) - Color.blue(intValue)) + Color.blue(intValue2))));
                }
            }
            return i;
        }

        public void a(int i) {
            this.f19277a = true;
            this.f19278b = i;
        }

        public void a(int i, float f2) {
            this.f19279c = true;
            this.f19280d = i;
            this.f19281e = f2;
        }

        public void a(Map<Integer, Integer> map, int i) {
            this.f19284h = map;
            this.j = i;
        }

        public c(c cVar) {
            this.f19277a = false;
            this.f19278b = 0;
            this.f19279c = false;
            this.f19280d = 0;
            this.f19281e = 0.0f;
            this.f19282f = 0;
            this.f19283g = 0;
            this.i = new HashSet();
            if (cVar != null) {
                this.f19277a = cVar.f19277a;
                this.f19278b = cVar.f19278b;
                this.f19279c = cVar.f19279c;
                this.f19280d = cVar.f19280d;
                this.f19281e = cVar.f19281e;
                this.f19282f = cVar.f19282f;
                this.f19283g = cVar.f19283g;
                if (cVar.f19284h != null) {
                    this.f19284h = new HashMap();
                    this.f19284h.putAll(cVar.f19284h);
                }
                this.j = cVar.j;
                this.i.addAll(cVar.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a */
        g f19285a;

        /* renamed from: b */
        Attributes f19286b;

        /* renamed from: c */
        Set<String> f19287c;

        /* synthetic */ d(Attributes attributes, com.larvalabs.svgandroid.c cVar) {
            this(attributes);
        }

        public void a(String str) {
            if (this.f19287c == null) {
                this.f19287c = new HashSet();
            }
            this.f19287c.add(str);
        }

        public String b(String str) {
            Set<String> set = this.f19287c;
            if (set != null && set.contains(str)) {
                return null;
            }
            g gVar = this.f19285a;
            String a2 = gVar != null ? gVar.a(str) : null;
            return a2 == null ? SVGParser.f(str, this.f19286b) : a2;
        }

        public Float c(String str) {
            String b2 = b(str);
            if (b2 == null) {
                return null;
            }
            try {
                return Float.valueOf(Float.parseFloat(b2));
            } catch (NumberFormatException unused) {
                return null;
            }
        }

        public Integer d(String str) {
            String b2 = b(str);
            if (b2 != null && b2.startsWith("#")) {
                try {
                    return Integer.valueOf(Integer.parseInt(b2.substring(1), 16));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }

        public String e(String str) {
            return b(str);
        }

        private d(Attributes attributes) {
            this.f19285a = null;
            this.f19287c = null;
            this.f19286b = attributes;
            String f2 = SVGParser.f(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, attributes);
            if (f2 != null) {
                this.f19285a = new g(f2, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends DefaultHandler {

        /* renamed from: a */
        Picture f19288a;

        /* renamed from: b */
        Canvas f19289b;

        /* renamed from: c */
        Paint f19290c;

        /* renamed from: d */
        RectF f19291d;

        /* renamed from: e */
        RectF f19292e;

        /* renamed from: f */
        RectF f19293f;

        /* renamed from: g */
        Deque<f> f19294g;

        /* renamed from: h */
        c f19295h;
        boolean i;
        HashMap<String, Shader> j;
        HashMap<String, a> k;
        a l;
        private boolean m;
        private int n;
        private boolean o;

        /* synthetic */ e(Picture picture, c cVar, com.larvalabs.svgandroid.c cVar2) {
            this(picture, cVar);
        }

        private void b() {
            if (this.i) {
                this.f19289b.restore();
            }
        }

        public c a() {
            return this.f19295h;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            a aVar;
            a aVar2;
            a aVar3;
            if (str2.equals("svg")) {
                this.f19288a.endRecording();
                return;
            }
            int i = 0;
            if (str2.equals("linearGradient")) {
                a aVar4 = this.l;
                if (aVar4.f19267a != null) {
                    String str4 = aVar4.f19268b;
                    if (str4 != null && (aVar3 = this.k.get(str4)) != null) {
                        this.l = aVar3.a(this.l);
                    }
                    int[] iArr = new int[this.l.l.size()];
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        iArr[i2] = this.l.l.get(i2).intValue();
                    }
                    float[] fArr = new float[this.l.k.size()];
                    while (i < fArr.length) {
                        fArr[i] = this.l.k.get(i).floatValue();
                        i++;
                    }
                    if (iArr.length == 0) {
                        Log.d("BAD", "BAD");
                    }
                    a aVar5 = this.l;
                    LinearGradient linearGradient = new LinearGradient(aVar5.f19270d, aVar5.f19271e, aVar5.f19272f, aVar5.f19273g, iArr, fArr, Shader.TileMode.CLAMP);
                    Matrix matrix = this.l.m;
                    if (matrix != null) {
                        linearGradient.setLocalMatrix(matrix);
                    }
                    this.j.put(this.l.f19267a, linearGradient);
                    HashMap<String, a> hashMap = this.k;
                    a aVar6 = this.l;
                    hashMap.put(aVar6.f19267a, aVar6);
                    return;
                }
                return;
            }
            if (str2.equals("radialGradient")) {
                a aVar7 = this.l;
                if (aVar7.f19267a != null) {
                    String str5 = aVar7.f19268b;
                    if (str5 != null && (aVar2 = this.k.get(str5)) != null) {
                        this.l = aVar2.a(this.l);
                    }
                    int[] iArr2 = new int[this.l.l.size()];
                    for (int i3 = 0; i3 < iArr2.length; i3++) {
                        iArr2[i3] = this.l.l.get(i3).intValue();
                    }
                    float[] fArr2 = new float[this.l.k.size()];
                    while (i < fArr2.length) {
                        fArr2[i] = this.l.k.get(i).floatValue();
                        i++;
                    }
                    String str6 = this.l.f19268b;
                    if (str6 != null && (aVar = this.k.get(str6)) != null) {
                        this.l = aVar.a(this.l);
                    }
                    a aVar8 = this.l;
                    RadialGradient radialGradient = new RadialGradient(aVar8.f19274h, aVar8.i, aVar8.j, iArr2, fArr2, Shader.TileMode.CLAMP);
                    Matrix matrix2 = this.l.m;
                    if (matrix2 != null) {
                        radialGradient.setLocalMatrix(matrix2);
                    }
                    this.j.put(this.l.f19267a, radialGradient);
                    HashMap<String, a> hashMap2 = this.k;
                    a aVar9 = this.l;
                    hashMap2.put(aVar9.f19267a, aVar9);
                    return;
                }
                return;
            }
            if (str2.equals("g")) {
                this.f19294g.pop();
                if (this.o) {
                    this.o = false;
                }
                this.f19289b.restore();
                if (this.m) {
                    this.n--;
                    if (this.n == 0) {
                        this.m = false;
                    }
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        /* JADX WARN: Code restructure failed: missing block: B:127:0x0286, code lost:            if (r5 == null) goto L327;     */
        /* JADX WARN: Removed duplicated region for block: B:109:0x02b6  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0335  */
        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void startElement(java.lang.String r22, java.lang.String r23, java.lang.String r24, org.xml.sax.Attributes r25) throws org.xml.sax.SAXException {
            /*
                Method dump skipped, instructions count: 1710
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.larvalabs.svgandroid.SVGParser.e.startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes):void");
        }

        private e(Picture picture, c cVar) {
            this.f19291d = new RectF();
            this.f19292e = null;
            this.f19293f = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            this.f19294g = new ArrayDeque();
            this.i = false;
            this.j = new HashMap<>();
            this.k = new HashMap<>();
            this.l = null;
            this.m = false;
            this.n = 0;
            this.o = false;
            this.f19288a = picture;
            this.f19290c = new Paint();
            this.f19290c.setAntiAlias(true);
            f fVar = new f();
            fVar.f19303h = true;
            this.f19294g.push(fVar);
            this.f19295h = new c(cVar);
        }

        private boolean a(d dVar, HashMap<String, Shader> hashMap, f fVar) {
            if (NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE.equals(dVar.e(ServerProtocol.DIALOG_PARAM_DISPLAY))) {
                return false;
            }
            String e2 = dVar.e("fill-rule");
            if (e2 != null) {
                if ("nonzero".equals(e2)) {
                    fVar.a(Path.FillType.WINDING);
                } else if ("evenodd".equals(e2)) {
                    fVar.a(Path.FillType.EVEN_ODD);
                }
            }
            if (this.f19295h.f19277a) {
                fVar.a(this.f19295h.f19278b);
                return true;
            }
            String e3 = dVar.e("fill");
            if (e3 != null && e3.startsWith("url(#")) {
                Shader shader = hashMap.get(e3.substring(5, e3.length() - 1));
                if (shader == null) {
                    return false;
                }
                fVar.a(shader);
                return true;
            }
            if (e3 != null && e3.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
                fVar.f19303h = false;
            } else {
                Integer d2 = dVar.d("fill");
                if (d2 != null) {
                    fVar.a(a(dVar, d2, true));
                    return true;
                }
                if (dVar.e("fill") == null && dVar.e("stroke") == null) {
                    new Integer(0);
                    return true;
                }
            }
            return false;
        }

        private boolean a(d dVar, f fVar) {
            if (NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE.equals(dVar.e(ServerProtocol.DIALOG_PARAM_DISPLAY))) {
                return false;
            }
            if (this.f19295h.f19279c) {
                fVar.b(this.f19295h.f19280d);
                fVar.a(this.f19295h.f19281e);
                return true;
            }
            String e2 = dVar.e("stroke");
            if (e2 != null && e2.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
                fVar.f19302g = false;
                return true;
            }
            Integer d2 = dVar.d("stroke");
            if (d2 == null) {
                return false;
            }
            fVar.b(a(dVar, d2, false));
            Float c2 = dVar.c("stroke-width");
            if (c2 != null) {
                fVar.a(c2.floatValue());
            }
            String e3 = dVar.e("stroke-linecap");
            if ("round".equals(e3)) {
                fVar.a(Paint.Cap.ROUND);
            } else if (MessengerShareContentUtility.IMAGE_RATIO_SQUARE.equals(e3)) {
                fVar.a(Paint.Cap.SQUARE);
            } else if ("butt".equals(e3)) {
                fVar.a(Paint.Cap.BUTT);
            }
            String e4 = dVar.e("stroke-linejoin");
            if ("miter".equals(e4)) {
                fVar.a(Paint.Join.MITER);
            } else if ("round".equals(e4)) {
                fVar.a(Paint.Join.ROUND);
            } else if ("bevel".equals(e4)) {
                fVar.a(Paint.Join.BEVEL);
            }
            return true;
        }

        private a a(boolean z, Attributes attributes) {
            a aVar = new a(null);
            aVar.f19267a = SVGParser.f("id", attributes);
            aVar.f19269c = z;
            Float valueOf = Float.valueOf(0.0f);
            if (z) {
                aVar.f19270d = SVGParser.b("x1", attributes, valueOf).floatValue();
                aVar.f19272f = SVGParser.b("x2", attributes, valueOf).floatValue();
                aVar.f19271e = SVGParser.b("y1", attributes, valueOf).floatValue();
                aVar.f19273g = SVGParser.b("y2", attributes, valueOf).floatValue();
            } else {
                aVar.f19274h = SVGParser.b("cx", attributes, valueOf).floatValue();
                aVar.i = SVGParser.b("cy", attributes, valueOf).floatValue();
                aVar.j = SVGParser.b("r", attributes, valueOf).floatValue();
            }
            String f2 = SVGParser.f("gradientTransform", attributes);
            if (f2 != null) {
                aVar.m = SVGParser.f(f2);
            }
            String f3 = SVGParser.f(ShareConstants.WEB_DIALOG_PARAM_HREF, attributes);
            if (f3 != null) {
                if (f3.startsWith("#")) {
                    f3 = f3.substring(1);
                }
                aVar.f19268b = f3;
            }
            return aVar;
        }

        private int a(d dVar, Integer num, boolean z) {
            if (z && this.f19295h.f19277a) {
                return this.f19295h.f19278b;
            }
            int intValue = (num.intValue() & ViewCompat.MEASURED_SIZE_MASK) | ViewCompat.MEASURED_STATE_MASK;
            if (this.f19295h.i != null) {
                this.f19295h.i.add(Integer.valueOf(intValue));
            }
            if (this.f19295h.f19282f == intValue) {
                intValue = this.f19295h.f19283g;
            }
            if (this.f19295h.f19284h != null) {
                intValue = this.f19295h.b(intValue);
            }
            Float c2 = dVar.c("opacity");
            if (c2 == null) {
                c2 = dVar.c(z ? "fill-opacity" : "stroke-opacity");
            }
            if (c2 != null) {
                return ((((int) (c2.floatValue() * 255.0f)) << 24) & ViewCompat.MEASURED_STATE_MASK) | (intValue & ViewCompat.MEASURED_SIZE_MASK);
            }
            return intValue;
        }

        private void a(float f2, float f3) {
            RectF rectF = this.f19293f;
            if (f2 < rectF.left) {
                rectF.left = f2;
            }
            RectF rectF2 = this.f19293f;
            if (f2 > rectF2.right) {
                rectF2.right = f2;
            }
            RectF rectF3 = this.f19293f;
            if (f3 < rectF3.top) {
                rectF3.top = f3;
            }
            RectF rectF4 = this.f19293f;
            if (f3 > rectF4.bottom) {
                rectF4.bottom = f3;
            }
        }

        private void a(float f2, float f3, float f4, float f5) {
            a(f2, f3);
            a(f2 + f4, f3 + f5);
        }

        private void a(Path path) {
            path.computeBounds(this.f19291d, false);
            RectF rectF = this.f19291d;
            a(rectF.left, rectF.top);
            RectF rectF2 = this.f19291d;
            a(rectF2.right, rectF2.bottom);
        }

        private void a(Attributes attributes) {
            String f2 = SVGParser.f("transform", attributes);
            this.i = f2 != null;
            if (this.i) {
                Matrix f3 = SVGParser.f(f2);
                this.f19289b.save();
                this.f19289b.concat(f3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a */
        private int f19296a;

        /* renamed from: b */
        private int f19297b;

        /* renamed from: c */
        private Shader f19298c;

        /* renamed from: d */
        private float f19299d;

        /* renamed from: e */
        private Paint.Cap f19300e;

        /* renamed from: f */
        private Paint.Join f19301f;

        /* renamed from: g */
        private boolean f19302g;

        /* renamed from: h */
        private boolean f19303h;
        private Path.FillType i;

        public f() {
            this.f19296a = ViewCompat.MEASURED_STATE_MASK;
            this.f19297b = ViewCompat.MEASURED_STATE_MASK;
            this.f19298c = null;
            this.f19299d = 1.0f;
            this.f19300e = Paint.Cap.BUTT;
            this.f19301f = Paint.Join.MITER;
            this.f19302g = false;
            this.f19303h = false;
        }

        public void a(int i) {
            this.f19296a = i;
            this.f19298c = null;
            this.f19303h = true;
        }

        public void b(int i) {
            this.f19297b = i;
            this.f19302g = true;
        }

        public boolean b(Paint paint) {
            if (!this.f19302g) {
                return false;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setShader(null);
            paint.setColor(this.f19297b);
            paint.setStrokeWidth(this.f19299d);
            paint.setStrokeCap(this.f19300e);
            paint.setStrokeJoin(this.f19301f);
            return true;
        }

        public boolean a(Paint paint) {
            if (!this.f19303h) {
                return false;
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(this.f19298c);
            paint.setColor(this.f19296a);
            return true;
        }

        public void a(float f2) {
            this.f19299d = f2;
        }

        public f(f fVar) {
            this.f19296a = ViewCompat.MEASURED_STATE_MASK;
            this.f19297b = ViewCompat.MEASURED_STATE_MASK;
            this.f19298c = null;
            this.f19299d = 1.0f;
            this.f19300e = Paint.Cap.BUTT;
            this.f19301f = Paint.Join.MITER;
            this.f19302g = false;
            this.f19303h = false;
            this.f19296a = fVar.f19296a;
            this.f19297b = fVar.f19297b;
            this.f19298c = fVar.f19298c;
            this.f19299d = fVar.f19299d;
            this.f19300e = fVar.f19300e;
            this.f19301f = fVar.f19301f;
            this.f19302g = fVar.f19302g;
            this.f19303h = fVar.f19303h;
        }

        public void a(Shader shader) {
            this.f19298c = shader;
            this.f19296a = ViewCompat.MEASURED_STATE_MASK;
            this.f19303h = true;
        }

        public void a(Paint.Cap cap) {
            this.f19300e = cap;
        }

        public void a(Paint.Join join) {
            this.f19301f = join;
        }

        public void a(Path.FillType fillType) {
            this.i = fillType;
        }

        public Path.FillType a() {
            Path.FillType fillType = this.i;
            return fillType == null ? Path.FillType.WINDING : fillType;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a */
        HashMap<String, String> f19304a;

        /* synthetic */ g(String str, com.larvalabs.svgandroid.c cVar) {
            this(str);
        }

        public String a(String str) {
            return this.f19304a.get(str);
        }

        private g(String str) {
            this.f19304a = new HashMap<>();
            for (String str2 : str.split(";")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    this.f19304a.put(split[0], split[1]);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a */
        private final String f19305a;

        /* renamed from: b */
        private Matrix f19306b = null;

        public h(String str) {
            this.f19305a = str;
        }

        private void b() {
            this.f19306b = new Matrix();
            int length = this.f19305a.length();
            int i = 0;
            while (i < length) {
                char charAt = this.f19305a.charAt(i);
                if (charAt >= 'a' && charAt <= 'z') {
                    int i2 = i;
                    for (Prefix prefix : Prefix.values()) {
                        String name = prefix.name();
                        if (this.f19305a.startsWith(name, i2) && this.f19305a.charAt(name.length() + i2) == '(') {
                            int length2 = i2 + name.length();
                            b e2 = SVGParser.e(this.f19305a.substring(length2 + 1));
                            i2 = length2 + e2.a();
                            Matrix b2 = SVGParser.b(prefix, e2);
                            if (b2 != null) {
                                this.f19306b.preConcat(b2);
                            }
                        }
                    }
                    i = i2;
                }
                i++;
            }
        }

        public Matrix a() {
            if (this.f19306b == null) {
                b();
            }
            return this.f19306b;
        }
    }

    private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i, int i2) {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0034. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x018a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Path d(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larvalabs.svgandroid.SVGParser.d(java.lang.String):android.graphics.Path");
    }

    public static b e(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 1; i2 < length; i2++) {
            if (z) {
                z = false;
            } else {
                char charAt = str.charAt(i2);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                        String substring = str.substring(i, i2);
                        if (substring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring)));
                            if (charAt == '-') {
                                i = i2;
                                break;
                            } else {
                                i = i2 + 1;
                                z = true;
                                break;
                            }
                        } else {
                            i++;
                            break;
                        }
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case 'M':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'V':
                    case 'Z':
                    case 'a':
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        String substring2 = str.substring(i, i2);
                        if (substring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring2)));
                        }
                        return new b(arrayList, i2);
                }
            }
        }
        String substring3 = str.substring(i);
        if (substring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(substring3)));
            } catch (NumberFormatException unused) {
            }
            i = str.length();
        }
        return new b(arrayList, i);
    }

    public static Matrix f(String str) {
        return new h(str).a();
    }

    public static Matrix b(Prefix prefix, b bVar) {
        float f2;
        switch (com.larvalabs.svgandroid.c.f19316a[prefix.ordinal()]) {
            case 1:
                if (bVar.f19275a.size() != 6) {
                    return null;
                }
                Matrix matrix = new Matrix();
                matrix.setValues(new float[]{((Float) bVar.f19275a.get(0)).floatValue(), ((Float) bVar.f19275a.get(2)).floatValue(), ((Float) bVar.f19275a.get(4)).floatValue(), ((Float) bVar.f19275a.get(1)).floatValue(), ((Float) bVar.f19275a.get(3)).floatValue(), ((Float) bVar.f19275a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                return matrix;
            case 2:
                if (bVar.f19275a.size() <= 0) {
                    return null;
                }
                float floatValue = ((Float) bVar.f19275a.get(0)).floatValue();
                r3 = bVar.f19275a.size() > 1 ? ((Float) bVar.f19275a.get(1)).floatValue() : 0.0f;
                Matrix matrix2 = new Matrix();
                matrix2.postTranslate(floatValue, r3);
                return matrix2;
            case 3:
                if (bVar.f19275a.size() <= 0) {
                    return null;
                }
                float floatValue2 = ((Float) bVar.f19275a.get(0)).floatValue();
                r3 = bVar.f19275a.size() > 1 ? ((Float) bVar.f19275a.get(1)).floatValue() : 0.0f;
                Matrix matrix3 = new Matrix();
                matrix3.postScale(floatValue2, r3);
                return matrix3;
            case 4:
                if (bVar.f19275a.size() <= 0) {
                    return null;
                }
                float floatValue3 = ((Float) bVar.f19275a.get(0)).floatValue();
                Matrix matrix4 = new Matrix();
                matrix4.postSkew((float) Math.tan(floatValue3), 0.0f);
                return matrix4;
            case 5:
                if (bVar.f19275a.size() <= 0) {
                    return null;
                }
                float floatValue4 = ((Float) bVar.f19275a.get(0)).floatValue();
                Matrix matrix5 = new Matrix();
                matrix5.postSkew(0.0f, (float) Math.tan(floatValue4));
                return matrix5;
            case 6:
                if (bVar.f19275a.size() <= 0) {
                    return null;
                }
                float floatValue5 = ((Float) bVar.f19275a.get(0)).floatValue();
                if (bVar.f19275a.size() > 2) {
                    r3 = ((Float) bVar.f19275a.get(1)).floatValue();
                    f2 = ((Float) bVar.f19275a.get(2)).floatValue();
                } else {
                    f2 = 0.0f;
                }
                Matrix matrix6 = new Matrix();
                matrix6.postTranslate(r3, f2);
                matrix6.postRotate(floatValue5);
                matrix6.postTranslate(-r3, -f2);
                return matrix6;
            default:
                return null;
        }
    }

    public static String f(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        String f19267a;

        /* renamed from: b */
        String f19268b;

        /* renamed from: c */
        boolean f19269c;

        /* renamed from: d */
        float f19270d;

        /* renamed from: e */
        float f19271e;

        /* renamed from: f */
        float f19272f;

        /* renamed from: g */
        float f19273g;

        /* renamed from: h */
        float f19274h;
        float i;
        float j;
        ArrayList<Float> k;
        ArrayList<Integer> l;
        Matrix m;

        private a() {
            this.k = new ArrayList<>();
            this.l = new ArrayList<>();
            this.m = null;
        }

        public a a(a aVar) {
            a aVar2 = new a();
            aVar2.f19267a = aVar.f19267a;
            aVar2.f19268b = this.f19267a;
            aVar2.f19269c = aVar.f19269c;
            aVar2.f19270d = aVar.f19270d;
            aVar2.f19272f = aVar.f19272f;
            aVar2.f19271e = aVar.f19271e;
            aVar2.f19273g = aVar.f19273g;
            aVar2.f19274h = aVar.f19274h;
            aVar2.i = aVar.i;
            aVar2.j = aVar.j;
            aVar2.k = this.k;
            aVar2.l = this.l;
            aVar2.m = this.m;
            Matrix matrix = aVar.m;
            if (matrix != null) {
                Matrix matrix2 = this.m;
                if (matrix2 == null) {
                    aVar2.m = matrix;
                } else {
                    Matrix matrix3 = new Matrix(matrix2);
                    matrix3.preConcat(aVar.m);
                    aVar2.m = matrix3;
                }
            }
            return aVar2;
        }

        /* synthetic */ a(com.larvalabs.svgandroid.c cVar) {
            this();
        }
    }

    public static com.larvalabs.svgandroid.b a(InputStream inputStream) throws SVGParseException {
        return a(inputStream, (c) null);
    }

    public static com.larvalabs.svgandroid.b a(InputStream inputStream, Map<Integer, Integer> map, int i) throws SVGParseException {
        c cVar = new c();
        cVar.a(map, i);
        return a(inputStream, cVar);
    }

    public static com.larvalabs.svgandroid.b a(Resources resources, int i) throws SVGParseException {
        return a(resources.openRawResource(i), (c) null);
    }

    public static com.larvalabs.svgandroid.b a(Resources resources, int i, c cVar) throws SVGParseException {
        return a(resources.openRawResource(i), cVar);
    }

    private static com.larvalabs.svgandroid.b a(InputStream inputStream, c cVar) throws SVGParseException {
        try {
            System.currentTimeMillis();
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Picture picture = new Picture();
            e eVar = new e(picture, cVar, null);
            xMLReader.setContentHandler(eVar);
            xMLReader.parse(new InputSource(inputStream));
            com.larvalabs.svgandroid.b bVar = new com.larvalabs.svgandroid.b(picture, eVar.f19292e, eVar.a().i);
            if (!Float.isInfinite(eVar.f19293f.top)) {
                bVar.a(eVar.f19293f);
            }
            return bVar;
        } catch (Exception e2) {
            throw new SVGParseException(e2);
        }
    }

    public static b e(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return e(attributes.getValue(i));
            }
        }
        return null;
    }

    public static Float b(String str, Attributes attributes, Float f2) {
        String f3 = f(str, attributes);
        if (f3 == null) {
            return f2;
        }
        if (f3.endsWith("%")) {
            return Float.valueOf(Float.parseFloat(f3.substring(0, f3.length() - 1)) / 100.0f);
        }
        if (f3.endsWith("px")) {
            f3 = f3.substring(0, f3.length() - 2);
        }
        return Float.valueOf(Float.parseFloat(f3));
    }

    public static Float d(String str, Attributes attributes) {
        return b(str, attributes, null);
    }
}
