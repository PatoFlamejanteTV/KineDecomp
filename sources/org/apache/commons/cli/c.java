package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: HelpFormatter.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public int f29281a = 74;

    /* renamed from: b */
    public int f29282b = 1;

    /* renamed from: c */
    public int f29283c = 3;

    /* renamed from: d */
    public String f29284d = "usage: ";

    /* renamed from: e */
    public String f29285e = System.getProperty("line.separator");

    /* renamed from: f */
    public String f29286f = "-";

    /* renamed from: g */
    public String f29287g = "--";

    /* renamed from: h */
    public String f29288h = "arg";
    protected Comparator i = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HelpFormatter.java */
    /* loaded from: classes3.dex */
    public static class b implements Comparator {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Option) obj).getKey().compareToIgnoreCase(((Option) obj2).getKey());
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public int a() {
        return this.f29283c;
    }

    public int b() {
        return this.f29282b;
    }

    public Comparator c() {
        return this.i;
    }

    public int d() {
        return this.f29281a;
    }

    public void a(PrintWriter printWriter, int i, Options options, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer, i, options, i2, i3);
        printWriter.println(stringBuffer.toString());
    }

    protected StringBuffer a(StringBuffer stringBuffer, int i, Options options, int i2, int i3) {
        String a2 = a(i2);
        String a3 = a(i3);
        ArrayList arrayList = new ArrayList();
        List<Option> helpOptions = options.helpOptions();
        Collections.sort(helpOptions, c());
        int i4 = 0;
        int i5 = 0;
        for (Option option : helpOptions) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.getOpt() == null) {
                stringBuffer2.append(a2);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.f29287g);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.getLongOpt());
            } else {
                stringBuffer2.append(a2);
                stringBuffer2.append(this.f29286f);
                stringBuffer2.append(option.getOpt());
                if (option.hasLongOpt()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.f29287g);
                    stringBuffer2.append(option.getLongOpt());
                }
            }
            if (option.hasArg()) {
                if (option.hasArgName()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.getArgName());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i5) {
                i5 = stringBuffer2.length();
            }
        }
        Iterator it = helpOptions.iterator();
        while (it.hasNext()) {
            Option option2 = (Option) it.next();
            int i6 = i4 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i4).toString());
            if (stringBuffer4.length() < i5) {
                stringBuffer4.append(a(i5 - stringBuffer4.length()));
            }
            stringBuffer4.append(a3);
            int i7 = i5 + i3;
            if (option2.getDescription() != null) {
                stringBuffer4.append(option2.getDescription());
            }
            a(stringBuffer, i, i7, stringBuffer4.toString());
            if (it.hasNext()) {
                stringBuffer.append(this.f29285e);
            }
            i4 = i6;
        }
        return stringBuffer;
    }

    protected StringBuffer a(StringBuffer stringBuffer, int i, int i2, String str) {
        int a2 = a(str, i, 0);
        if (a2 == -1) {
            stringBuffer.append(a(str));
            return stringBuffer;
        }
        stringBuffer.append(a(str.substring(0, a2)));
        stringBuffer.append(this.f29285e);
        if (i2 >= i) {
            i2 = 1;
        }
        String a3 = a(i2);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(a3);
            stringBuffer2.append(str.substring(a2).trim());
            str = stringBuffer2.toString();
            a2 = a(str, i, 0);
            if (a2 == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i && a2 == i2 - 1) {
                a2 = i;
            }
            stringBuffer.append(a(str.substring(0, a2)));
            stringBuffer.append(this.f29285e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int a(java.lang.String r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = 10
            int r1 = r7.indexOf(r0, r9)
            r2 = -1
            if (r1 == r2) goto Lb
            if (r1 <= r8) goto L15
        Lb:
            r1 = 9
            int r1 = r7.indexOf(r1, r9)
            if (r1 == r2) goto L18
            if (r1 > r8) goto L18
        L15:
            int r1 = r1 + 1
            return r1
        L18:
            int r8 = r8 + r9
            int r1 = r7.length()
            if (r8 < r1) goto L20
            return r2
        L20:
            r1 = r8
        L21:
            r3 = 13
            r4 = 32
            if (r1 < r9) goto L34
            char r5 = r7.charAt(r1)
            if (r5 == r4) goto L34
            if (r5 == r0) goto L34
            if (r5 == r3) goto L34
            int r1 = r1 + (-1)
            goto L21
        L34:
            if (r1 <= r9) goto L37
            return r1
        L37:
            int r9 = r7.length()
            if (r8 > r9) goto L4a
            char r9 = r7.charAt(r8)
            if (r9 == r4) goto L4a
            if (r9 == r0) goto L4a
            if (r9 == r3) goto L4a
            int r8 = r8 + 1
            goto L37
        L4a:
            int r7 = r7.length()
            if (r8 != r7) goto L51
            r8 = -1
        L51:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.c.a(java.lang.String, int, int):int");
    }

    protected String a(int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    protected String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }
}
