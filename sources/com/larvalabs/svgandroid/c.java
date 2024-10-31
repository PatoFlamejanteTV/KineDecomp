package com.larvalabs.svgandroid;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f2983a;
        String b;
        boolean c;
        float d;
        float e;
        float f;
        float g;
        float h;
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
            aVar2.f2983a = aVar.f2983a;
            aVar2.b = this.f2983a;
            aVar2.c = aVar.c;
            aVar2.d = aVar.d;
            aVar2.f = aVar.f;
            aVar2.e = aVar.e;
            aVar2.g = aVar.g;
            aVar2.h = aVar.h;
            aVar2.i = aVar.i;
            aVar2.j = aVar.j;
            aVar2.k = this.k;
            aVar2.l = this.l;
            aVar2.m = this.m;
            if (aVar.m != null) {
                if (this.m == null) {
                    aVar2.m = aVar.m;
                } else {
                    Matrix matrix = new Matrix(this.m);
                    matrix.preConcat(aVar.m);
                    aVar2.m = matrix;
                }
            }
            return aVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<Float> f2984a;
        private int b;

        public b(ArrayList<Float> arrayList, int i) {
            this.f2984a = arrayList;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.larvalabs.svgandroid.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0053c {

        /* renamed from: a, reason: collision with root package name */
        e f2985a;
        Attributes b;

        private C0053c(Attributes attributes) {
            this.f2985a = null;
            this.b = attributes;
            String e = c.e(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, attributes);
            if (e != null) {
                this.f2985a = new e(e);
            }
        }

        public String a(String str) {
            String a2 = this.f2985a != null ? this.f2985a.a(str) : null;
            return a2 == null ? c.e(str, this.b) : a2;
        }

        public String b(String str) {
            return a(str);
        }

        public Integer c(String str) {
            String a2 = a(str);
            if (a2 == null || !a2.startsWith("#")) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(a2.substring(1), 16));
            } catch (NumberFormatException e) {
                return null;
            }
        }

        public Float d(String str) {
            String a2 = a(str);
            if (a2 == null) {
                return null;
            }
            try {
                return Float.valueOf(Float.parseFloat(a2));
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends DefaultHandler {

        /* renamed from: a, reason: collision with root package name */
        Picture f2986a;
        Canvas b;
        Paint c;
        RectF d;
        RectF e;
        RectF f;
        Integer g;
        Integer h;
        boolean i;
        boolean j;
        HashMap<String, Shader> k;
        HashMap<String, a> l;
        a m;
        private boolean n;
        private int o;
        private boolean p;

        private d(Picture picture) {
            this.d = new RectF();
            this.e = null;
            this.f = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            this.g = null;
            this.h = null;
            this.i = false;
            this.j = false;
            this.k = new HashMap<>();
            this.l = new HashMap<>();
            this.m = null;
            this.n = false;
            this.o = 0;
            this.p = false;
            this.f2986a = picture;
            this.c = new Paint();
            this.c.setAntiAlias(true);
        }

        private a a(boolean z, Attributes attributes) {
            a aVar = new a();
            aVar.f2983a = c.e(ShareConstants.WEB_DIALOG_PARAM_ID, attributes);
            aVar.c = z;
            if (z) {
                aVar.d = c.b("x1", attributes, Float.valueOf(0.0f)).floatValue();
                aVar.f = c.b("x2", attributes, Float.valueOf(0.0f)).floatValue();
                aVar.e = c.b("y1", attributes, Float.valueOf(0.0f)).floatValue();
                aVar.g = c.b("y2", attributes, Float.valueOf(0.0f)).floatValue();
            } else {
                aVar.h = c.b("cx", attributes, Float.valueOf(0.0f)).floatValue();
                aVar.i = c.b("cy", attributes, Float.valueOf(0.0f)).floatValue();
                aVar.j = c.b("r", attributes, Float.valueOf(0.0f)).floatValue();
            }
            String e = c.e("gradientTransform", attributes);
            if (e != null) {
                aVar.m = c.d(e);
            }
            String e2 = c.e(ShareConstants.WEB_DIALOG_PARAM_HREF, attributes);
            if (e2 != null) {
                if (e2.startsWith("#")) {
                    e2 = e2.substring(1);
                }
                aVar.b = e2;
            }
            return aVar;
        }

        private void a() {
            if (this.j) {
                this.b.restore();
            }
        }

        private void a(float f, float f2) {
            if (f < this.f.left) {
                this.f.left = f;
            }
            if (f > this.f.right) {
                this.f.right = f;
            }
            if (f2 < this.f.top) {
                this.f.top = f2;
            }
            if (f2 > this.f.bottom) {
                this.f.bottom = f2;
            }
        }

        private void a(float f, float f2, float f3, float f4) {
            a(f, f2);
            a(f + f3, f2 + f4);
        }

        private void a(Path path) {
            path.computeBounds(this.d, false);
            a(this.d.left, this.d.top);
            a(this.d.right, this.d.bottom);
        }

        private void a(C0053c c0053c, Integer num, boolean z) {
            int intValue = (16777215 & num.intValue()) | (-16777216);
            if (this.g != null && this.g.intValue() == intValue) {
                intValue = this.h.intValue();
            }
            this.c.setColor(intValue);
            Float d = c0053c.d("opacity");
            if (d == null) {
                d = c0053c.d(z ? "fill-opacity" : "stroke-opacity");
            }
            if (d == null) {
                this.c.setAlpha(255);
            } else {
                this.c.setAlpha((int) (d.floatValue() * 255.0f));
            }
        }

        private void a(Attributes attributes) {
            String e = c.e("transform", attributes);
            this.j = e != null;
            if (this.j) {
                Matrix d = c.d(e);
                this.b.save();
                this.b.concat(d);
            }
        }

        private boolean a(C0053c c0053c) {
            Integer c;
            if (this.i || "none".equals(c0053c.b(ServerProtocol.DIALOG_PARAM_DISPLAY)) || (c = c0053c.c("stroke")) == null) {
                return false;
            }
            a(c0053c, c, false);
            Float d = c0053c.d("stroke-width");
            if (d != null) {
                this.c.setStrokeWidth(d.floatValue());
            }
            String b = c0053c.b("stroke-linecap");
            if ("round".equals(b)) {
                this.c.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(b)) {
                this.c.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(b)) {
                this.c.setStrokeCap(Paint.Cap.BUTT);
            }
            String b2 = c0053c.b("stroke-linejoin");
            if ("miter".equals(b2)) {
                this.c.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(b2)) {
                this.c.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(b2)) {
                this.c.setStrokeJoin(Paint.Join.BEVEL);
            }
            this.c.setStyle(Paint.Style.STROKE);
            return true;
        }

        private boolean a(C0053c c0053c, HashMap<String, Shader> hashMap) {
            if ("none".equals(c0053c.b(ServerProtocol.DIALOG_PARAM_DISPLAY))) {
                return false;
            }
            if (this.i) {
                this.c.setStyle(Paint.Style.FILL);
                this.c.setColor(-1);
                return true;
            }
            String b = c0053c.b("fill");
            if (b != null && b.startsWith("url(#")) {
                Shader shader = hashMap.get(b.substring("url(#".length(), b.length() - 1));
                if (shader == null) {
                    return false;
                }
                this.c.setShader(shader);
                this.c.setStyle(Paint.Style.FILL);
                return true;
            }
            this.c.setShader(null);
            Integer c = c0053c.c("fill");
            if (c != null) {
                a(c0053c, c, true);
                this.c.setStyle(Paint.Style.FILL);
                return true;
            }
            if (c0053c.b("fill") != null || c0053c.b("stroke") != null) {
                return false;
            }
            this.c.setStyle(Paint.Style.FILL);
            this.c.setColor(-16777216);
            return true;
        }

        public void a(Integer num, Integer num2) {
            this.g = num;
            this.h = num2;
        }

        public void a(boolean z) {
            this.i = z;
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
            int i = 0;
            if (str2.equals("svg")) {
                this.f2986a.endRecording();
                return;
            }
            if (str2.equals("linearGradient")) {
                if (this.m.f2983a != null) {
                    if (this.m.b != null && (aVar2 = this.l.get(this.m.b)) != null) {
                        this.m = aVar2.a(this.m);
                    }
                    int[] iArr = new int[this.m.l.size()];
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        iArr[i2] = this.m.l.get(i2).intValue();
                    }
                    float[] fArr = new float[this.m.k.size()];
                    while (i < fArr.length) {
                        fArr[i] = this.m.k.get(i).floatValue();
                        i++;
                    }
                    if (iArr.length == 0) {
                        Log.d("BAD", "BAD");
                    }
                    LinearGradient linearGradient = new LinearGradient(this.m.d, this.m.e, this.m.f, this.m.g, iArr, fArr, Shader.TileMode.CLAMP);
                    if (this.m.m != null) {
                        linearGradient.setLocalMatrix(this.m.m);
                    }
                    this.k.put(this.m.f2983a, linearGradient);
                    this.l.put(this.m.f2983a, this.m);
                    return;
                }
                return;
            }
            if (!str2.equals("radialGradient")) {
                if (str2.equals("g")) {
                    if (this.p) {
                        this.p = false;
                    }
                    if (this.n) {
                        this.o--;
                        if (this.o == 0) {
                            this.n = false;
                        }
                    }
                    this.k.clear();
                    return;
                }
                return;
            }
            if (this.m.f2983a != null) {
                int[] iArr2 = new int[this.m.l.size()];
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    iArr2[i3] = this.m.l.get(i3).intValue();
                }
                float[] fArr2 = new float[this.m.k.size()];
                while (i < fArr2.length) {
                    fArr2[i] = this.m.k.get(i).floatValue();
                    i++;
                }
                if (this.m.b != null && (aVar = this.l.get(this.m.b)) != null) {
                    this.m = aVar.a(this.m);
                }
                RadialGradient radialGradient = new RadialGradient(this.m.h, this.m.i, this.m.j, iArr2, fArr2, Shader.TileMode.CLAMP);
                if (this.m.m != null) {
                    radialGradient.setLocalMatrix(this.m.m);
                }
                this.k.put(this.m.f2983a, radialGradient);
                this.l.put(this.m.f2983a, this.m);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            this.c.setAlpha(255);
            if (this.p) {
                if (str2.equals("rect")) {
                    Float f = c.f("x", attributes);
                    if (f == null) {
                        f = Float.valueOf(0.0f);
                    }
                    Float f2 = c.f("y", attributes);
                    if (f2 == null) {
                        f2 = Float.valueOf(0.0f);
                    }
                    Float f3 = c.f("width", attributes);
                    c.f("height", attributes);
                    this.e = new RectF(f.floatValue(), f2.floatValue(), f.floatValue() + f3.floatValue(), f2.floatValue() + f3.floatValue());
                    return;
                }
                return;
            }
            if (str2.equals("svg")) {
                this.b = this.f2986a.beginRecording((int) Math.ceil(c.f("width", attributes).floatValue()), (int) Math.ceil(c.f("height", attributes).floatValue()));
                return;
            }
            if (str2.equals("defs")) {
                return;
            }
            if (str2.equals("linearGradient")) {
                this.m = a(true, attributes);
                return;
            }
            if (str2.equals("radialGradient")) {
                this.m = a(false, attributes);
                return;
            }
            if (str2.equals("stop")) {
                if (this.m != null) {
                    float floatValue = c.f("offset", attributes).floatValue();
                    e eVar = new e(c.e(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, attributes));
                    String a2 = eVar.a("stop-color");
                    int parseInt = a2 != null ? a2.startsWith("#") ? Integer.parseInt(a2.substring(1), 16) : Integer.parseInt(a2, 16) : -16777216;
                    String a3 = eVar.a("stop-opacity");
                    int round = a3 != null ? parseInt | (Math.round(Float.parseFloat(a3) * 255.0f) << 24) : parseInt | (-16777216);
                    this.m.k.add(Float.valueOf(floatValue));
                    this.m.l.add(Integer.valueOf(round));
                    return;
                }
                return;
            }
            if (str2.equals("g")) {
                if ("bounds".equalsIgnoreCase(c.e(ShareConstants.WEB_DIALOG_PARAM_ID, attributes))) {
                    this.p = true;
                }
                if (this.n) {
                    this.o++;
                }
                if (!"none".equals(c.e(ServerProtocol.DIALOG_PARAM_DISPLAY, attributes)) || this.n) {
                    return;
                }
                this.n = true;
                this.o = 1;
                return;
            }
            if (!this.n && str2.equals("rect")) {
                Float f4 = c.f("x", attributes);
                Float valueOf = f4 == null ? Float.valueOf(0.0f) : f4;
                Float f5 = c.f("y", attributes);
                Float valueOf2 = f5 == null ? Float.valueOf(0.0f) : f5;
                Float f6 = c.f("width", attributes);
                Float f7 = c.f("height", attributes);
                a(attributes);
                C0053c c0053c = new C0053c(attributes);
                if (a(c0053c, this.k)) {
                    a(valueOf.floatValue(), valueOf2.floatValue(), f6.floatValue(), f7.floatValue());
                    this.b.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + f6.floatValue(), valueOf2.floatValue() + f7.floatValue(), this.c);
                }
                if (a(c0053c)) {
                    this.b.drawRect(valueOf.floatValue(), valueOf2.floatValue(), valueOf.floatValue() + f6.floatValue(), valueOf2.floatValue() + f7.floatValue(), this.c);
                }
                a();
                return;
            }
            if (!this.n && str2.equals("line")) {
                Float f8 = c.f("x1", attributes);
                Float f9 = c.f("x2", attributes);
                Float f10 = c.f("y1", attributes);
                Float f11 = c.f("y2", attributes);
                if (a(new C0053c(attributes))) {
                    a(attributes);
                    a(f8.floatValue(), f10.floatValue());
                    a(f9.floatValue(), f11.floatValue());
                    this.b.drawLine(f8.floatValue(), f10.floatValue(), f9.floatValue(), f11.floatValue(), this.c);
                    a();
                    return;
                }
                return;
            }
            if (!this.n && str2.equals("circle")) {
                Float f12 = c.f("cx", attributes);
                Float f13 = c.f("cy", attributes);
                Float f14 = c.f("r", attributes);
                if (f12 == null || f13 == null || f14 == null) {
                    return;
                }
                a(attributes);
                C0053c c0053c2 = new C0053c(attributes);
                if (a(c0053c2, this.k)) {
                    a(f12.floatValue() - f14.floatValue(), f13.floatValue() - f14.floatValue());
                    a(f12.floatValue() + f14.floatValue(), f13.floatValue() + f14.floatValue());
                    this.b.drawCircle(f12.floatValue(), f13.floatValue(), f14.floatValue(), this.c);
                }
                if (a(c0053c2)) {
                    this.b.drawCircle(f12.floatValue(), f13.floatValue(), f14.floatValue(), this.c);
                }
                a();
                return;
            }
            if (!this.n && str2.equals("ellipse")) {
                Float f15 = c.f("cx", attributes);
                Float f16 = c.f("cy", attributes);
                Float f17 = c.f("rx", attributes);
                Float f18 = c.f("ry", attributes);
                if (f15 == null || f16 == null || f17 == null || f18 == null) {
                    return;
                }
                a(attributes);
                C0053c c0053c3 = new C0053c(attributes);
                this.d.set(f15.floatValue() - f17.floatValue(), f16.floatValue() - f18.floatValue(), f15.floatValue() + f17.floatValue(), f16.floatValue() + f18.floatValue());
                if (a(c0053c3, this.k)) {
                    a(f15.floatValue() - f17.floatValue(), f16.floatValue() - f18.floatValue());
                    a(f15.floatValue() + f17.floatValue(), f16.floatValue() + f18.floatValue());
                    this.b.drawOval(this.d, this.c);
                }
                if (a(c0053c3)) {
                    this.b.drawOval(this.d, this.c);
                }
                a();
                return;
            }
            if (this.n || !(str2.equals("polygon") || str2.equals("polyline"))) {
                if (this.n || !str2.equals("path")) {
                    if (this.n) {
                        return;
                    }
                    Log.d("SVGAndroid", "UNRECOGNIZED SVG COMMAND: " + str2);
                    return;
                }
                Path e = c.e(c.e("d", attributes));
                a(attributes);
                C0053c c0053c4 = new C0053c(attributes);
                if (a(c0053c4, this.k)) {
                    a(e);
                    this.b.drawPath(e, this.c);
                }
                if (a(c0053c4)) {
                    this.b.drawPath(e, this.c);
                }
                a();
                return;
            }
            b d = c.d("points", attributes);
            if (d != null) {
                Path path = new Path();
                ArrayList arrayList = d.f2984a;
                if (arrayList.size() > 1) {
                    a(attributes);
                    C0053c c0053c5 = new C0053c(attributes);
                    path.moveTo(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
                    int i = 2;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        path.lineTo(((Float) arrayList.get(i2)).floatValue(), ((Float) arrayList.get(i2 + 1)).floatValue());
                        i = i2 + 2;
                    }
                    if (str2.equals("polygon")) {
                        path.close();
                    }
                    if (a(c0053c5, this.k)) {
                        a(path);
                        this.b.drawPath(path, this.c);
                    }
                    if (a(c0053c5)) {
                        this.b.drawPath(path, this.c);
                    }
                    a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        HashMap<String, String> f2987a;

        private e(String str) {
            this.f2987a = new HashMap<>();
            for (String str2 : str.split(";")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    this.f2987a.put(split[0], split[1]);
                }
            }
        }

        public String a(String str) {
            return this.f2987a.get(str);
        }
    }

    public static com.larvalabs.svgandroid.b a(Resources resources, int i) throws SVGParseException {
        return a(resources.openRawResource(i), 0, 0, false);
    }

    private static com.larvalabs.svgandroid.b a(InputStream inputStream, Integer num, Integer num2, boolean z) throws SVGParseException {
        try {
            System.currentTimeMillis();
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Picture picture = new Picture();
            d dVar = new d(picture);
            dVar.a(num, num2);
            dVar.a(z);
            xMLReader.setContentHandler(dVar);
            xMLReader.parse(new InputSource(inputStream));
            com.larvalabs.svgandroid.b bVar = new com.larvalabs.svgandroid.b(picture, dVar.e);
            if (!Float.isInfinite(dVar.f.top)) {
                bVar.a(dVar.f);
            }
            return bVar;
        } catch (Exception e2) {
            throw new SVGParseException(e2);
        }
    }

    private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float b(String str, Attributes attributes, Float f) {
        String e2 = e(str, attributes);
        if (e2 == null) {
            return f;
        }
        if (e2.endsWith("px")) {
            e2 = e2.substring(0, e2.length() - 2);
        }
        return Float.valueOf(Float.parseFloat(e2));
    }

    private static b c(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        int i = 0;
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
                    case '-':
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
            } catch (NumberFormatException e2) {
            }
            i = str.length();
        }
        return new b(arrayList, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Matrix d(String str) {
        float f;
        if (str.startsWith("matrix(")) {
            b c = c(str.substring("matrix(".length()));
            if (c.f2984a.size() == 6) {
                Matrix matrix = new Matrix();
                matrix.setValues(new float[]{((Float) c.f2984a.get(0)).floatValue(), ((Float) c.f2984a.get(2)).floatValue(), ((Float) c.f2984a.get(4)).floatValue(), ((Float) c.f2984a.get(1)).floatValue(), ((Float) c.f2984a.get(3)).floatValue(), ((Float) c.f2984a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                return matrix;
            }
        } else if (str.startsWith("translate(")) {
            b c2 = c(str.substring("translate(".length()));
            if (c2.f2984a.size() > 0) {
                float floatValue = ((Float) c2.f2984a.get(0)).floatValue();
                float floatValue2 = c2.f2984a.size() > 1 ? ((Float) c2.f2984a.get(1)).floatValue() : 0.0f;
                Matrix matrix2 = new Matrix();
                matrix2.postTranslate(floatValue, floatValue2);
                return matrix2;
            }
        } else if (str.startsWith("scale(")) {
            b c3 = c(str.substring("scale(".length()));
            if (c3.f2984a.size() > 0) {
                float floatValue3 = ((Float) c3.f2984a.get(0)).floatValue();
                r1 = c3.f2984a.size() > 1 ? ((Float) c3.f2984a.get(1)).floatValue() : 0.0f;
                Matrix matrix3 = new Matrix();
                matrix3.postScale(floatValue3, r1);
                return matrix3;
            }
        } else if (str.startsWith("skewX(")) {
            b c4 = c(str.substring("skewX(".length()));
            if (c4.f2984a.size() > 0) {
                float floatValue4 = ((Float) c4.f2984a.get(0)).floatValue();
                Matrix matrix4 = new Matrix();
                matrix4.postSkew((float) Math.tan(floatValue4), 0.0f);
                return matrix4;
            }
        } else if (str.startsWith("skewY(")) {
            b c5 = c(str.substring("skewY(".length()));
            if (c5.f2984a.size() > 0) {
                float floatValue5 = ((Float) c5.f2984a.get(0)).floatValue();
                Matrix matrix5 = new Matrix();
                matrix5.postSkew(0.0f, (float) Math.tan(floatValue5));
                return matrix5;
            }
        } else if (str.startsWith("rotate(")) {
            b c6 = c(str.substring("rotate(".length()));
            if (c6.f2984a.size() > 0) {
                float floatValue6 = ((Float) c6.f2984a.get(0)).floatValue();
                if (c6.f2984a.size() > 2) {
                    float floatValue7 = ((Float) c6.f2984a.get(1)).floatValue();
                    r1 = ((Float) c6.f2984a.get(2)).floatValue();
                    f = floatValue7;
                } else {
                    f = 0.0f;
                }
                Matrix matrix6 = new Matrix();
                matrix6.postTranslate(f, r1);
                matrix6.postRotate(floatValue6);
                matrix6.postTranslate(-f, -r1);
                return matrix6;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b d(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return c(attributes.getValue(i));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Path e(String str) {
        boolean z;
        float f;
        float f2;
        int length = str.length();
        com.larvalabs.svgandroid.a aVar = new com.larvalabs.svgandroid.a(str, 0);
        aVar.a();
        Path path = new Path();
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        while (true) {
            float f7 = f6;
            float f8 = f5;
            float f9 = f4;
            float f10 = f3;
            if (aVar.f2981a >= length) {
                return path;
            }
            char charAt = str.charAt(aVar.f2981a);
            aVar.c();
            switch (charAt) {
                case 'A':
                case 'a':
                    float e2 = aVar.e();
                    float e3 = aVar.e();
                    float e4 = aVar.e();
                    int e5 = (int) aVar.e();
                    int e6 = (int) aVar.e();
                    float e7 = aVar.e();
                    float e8 = aVar.e();
                    a(path, f10, f9, e7, e8, e2, e3, e4, e5, e6);
                    z = false;
                    f6 = f7;
                    f5 = f8;
                    f3 = e7;
                    f4 = e8;
                    break;
                case 'C':
                case 'c':
                    float e9 = aVar.e();
                    float e10 = aVar.e();
                    float e11 = aVar.e();
                    float e12 = aVar.e();
                    float e13 = aVar.e();
                    float e14 = aVar.e();
                    if (charAt == 'c') {
                        e11 += f10;
                        e13 += f10;
                        e12 += f9;
                        e14 += f9;
                        f = e10 + f9;
                        f2 = e9 + f10;
                    } else {
                        f = e10;
                        f2 = e9;
                    }
                    path.cubicTo(f2, f, e11, e12, e13, e14);
                    f6 = e12;
                    f5 = e11;
                    f4 = e14;
                    f3 = e13;
                    z = true;
                    break;
                case 'H':
                case 'h':
                    float e15 = aVar.e();
                    if (charAt != 'h') {
                        path.lineTo(e15, f9);
                        f6 = f7;
                        f4 = f9;
                        f3 = e15;
                        z = false;
                        f5 = f8;
                        break;
                    } else {
                        path.rLineTo(e15, 0.0f);
                        float f11 = f10 + e15;
                        z = false;
                        f4 = f9;
                        f3 = f11;
                        f6 = f7;
                        f5 = f8;
                        break;
                    }
                case 'L':
                case 'l':
                    float e16 = aVar.e();
                    float e17 = aVar.e();
                    if (charAt != 'l') {
                        path.lineTo(e16, e17);
                        f6 = f7;
                        f5 = f8;
                        f4 = e17;
                        f3 = e16;
                        z = false;
                        break;
                    } else {
                        path.rLineTo(e16, e17);
                        float f12 = f10 + e16;
                        z = false;
                        f4 = f9 + e17;
                        f3 = f12;
                        f6 = f7;
                        f5 = f8;
                        break;
                    }
                case 'M':
                case 'm':
                    float e18 = aVar.e();
                    float e19 = aVar.e();
                    if (charAt != 'm') {
                        path.moveTo(e18, e19);
                        f6 = f7;
                        f5 = f8;
                        f4 = e19;
                        f3 = e18;
                        z = false;
                        break;
                    } else {
                        path.rMoveTo(e18, e19);
                        float f13 = f10 + e18;
                        z = false;
                        f4 = f9 + e19;
                        f3 = f13;
                        f6 = f7;
                        f5 = f8;
                        break;
                    }
                case 'S':
                case 's':
                    float e20 = aVar.e();
                    float e21 = aVar.e();
                    float e22 = aVar.e();
                    float e23 = aVar.e();
                    if (charAt == 's') {
                        e20 += f10;
                        e22 += f10;
                        e21 += f9;
                        e23 += f9;
                    }
                    path.cubicTo((f10 * 2.0f) - f8, (f9 * 2.0f) - f7, e20, e21, e22, e23);
                    f6 = e21;
                    f5 = e20;
                    f4 = e23;
                    f3 = e22;
                    z = true;
                    break;
                case 'V':
                case 'v':
                    float e24 = aVar.e();
                    if (charAt != 'v') {
                        path.lineTo(f10, e24);
                        z = false;
                        f5 = f8;
                        f4 = e24;
                        f3 = f10;
                        f6 = f7;
                        break;
                    } else {
                        path.rLineTo(0.0f, e24);
                        z = false;
                        f4 = f9 + e24;
                        f3 = f10;
                        f6 = f7;
                        f5 = f8;
                        break;
                    }
                case 'Z':
                case 'z':
                    path.close();
                    z = false;
                    f4 = f9;
                    f3 = f10;
                    f6 = f7;
                    f5 = f8;
                    break;
                default:
                    z = false;
                    f4 = f9;
                    f3 = f10;
                    f6 = f7;
                    f5 = f8;
                    break;
            }
            if (!z) {
                f6 = f4;
                f5 = f3;
            }
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float f(String str, Attributes attributes) {
        return b(str, attributes, null);
    }
}
