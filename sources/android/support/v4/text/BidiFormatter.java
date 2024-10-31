package android.support.v4.text;

import android.text.SpannableStringBuilder;
import com.umeng.commonsdk.proguard.ap;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BidiFormatter {

    /* renamed from: a */
    private static TextDirectionHeuristicCompat f1662a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;

    /* renamed from: b */
    private static final String f1663b = Character.toString(8206);

    /* renamed from: c */
    private static final String f1664c = Character.toString(8207);

    /* renamed from: d */
    private static final BidiFormatter f1665d = new BidiFormatter(false, 2, f1662a);

    /* renamed from: e */
    private static final BidiFormatter f1666e = new BidiFormatter(true, 2, f1662a);

    /* renamed from: f */
    private final boolean f1667f;

    /* renamed from: g */
    private final int f1668g;

    /* renamed from: h */
    private final TextDirectionHeuristicCompat f1669h;

    /* loaded from: classes.dex */
    public static class DirectionalityEstimator {

        /* renamed from: a */
        private static final byte[] f1673a = new byte[1792];

        /* renamed from: b */
        private final CharSequence f1674b;

        /* renamed from: c */
        private final boolean f1675c;

        /* renamed from: d */
        private final int f1676d;

        /* renamed from: e */
        private int f1677e;

        /* renamed from: f */
        private char f1678f;

        static {
            for (int i = 0; i < 1792; i++) {
                f1673a[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.f1674b = charSequence;
            this.f1675c = z;
            this.f1676d = charSequence.length();
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f1673a[c2] : Character.getDirectionality(c2);
        }

        private byte e() {
            char c2;
            int i = this.f1677e;
            do {
                int i2 = this.f1677e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1674b;
                int i3 = i2 - 1;
                this.f1677e = i3;
                this.f1678f = charSequence.charAt(i3);
                c2 = this.f1678f;
                if (c2 == '&') {
                    return (byte) 12;
                }
            } while (c2 != ';');
            this.f1677e = i;
            this.f1678f = ';';
            return ap.k;
        }

        private byte f() {
            char charAt;
            do {
                int i = this.f1677e;
                if (i >= this.f1676d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f1674b;
                this.f1677e = i + 1;
                charAt = charSequence.charAt(i);
                this.f1678f = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte g() {
            char charAt;
            int i = this.f1677e;
            while (true) {
                int i2 = this.f1677e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1674b;
                int i3 = i2 - 1;
                this.f1677e = i3;
                this.f1678f = charSequence.charAt(i3);
                char c2 = this.f1678f;
                if (c2 == '<') {
                    return (byte) 12;
                }
                if (c2 == '>') {
                    break;
                }
                if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f1678f;
                    do {
                        int i4 = this.f1677e;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f1674b;
                            int i5 = i4 - 1;
                            this.f1677e = i5;
                            charAt = charSequence2.charAt(i5);
                            this.f1678f = charAt;
                        }
                    } while (charAt != c3);
                }
            }
            this.f1677e = i;
            this.f1678f = '>';
            return ap.k;
        }

        private byte h() {
            char charAt;
            int i = this.f1677e;
            while (true) {
                int i2 = this.f1677e;
                if (i2 < this.f1676d) {
                    CharSequence charSequence = this.f1674b;
                    this.f1677e = i2 + 1;
                    this.f1678f = charSequence.charAt(i2);
                    char c2 = this.f1678f;
                    if (c2 == '>') {
                        return (byte) 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f1678f;
                        do {
                            int i3 = this.f1677e;
                            if (i3 < this.f1676d) {
                                CharSequence charSequence2 = this.f1674b;
                                this.f1677e = i3 + 1;
                                charAt = charSequence2.charAt(i3);
                                this.f1678f = charAt;
                            }
                        } while (charAt != c3);
                    }
                } else {
                    this.f1677e = i;
                    this.f1678f = '<';
                    return ap.k;
                }
            }
        }

        byte b() {
            this.f1678f = this.f1674b.charAt(this.f1677e);
            if (Character.isHighSurrogate(this.f1678f)) {
                int codePointAt = Character.codePointAt(this.f1674b, this.f1677e);
                this.f1677e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f1677e++;
            byte a2 = a(this.f1678f);
            if (!this.f1675c) {
                return a2;
            }
            char c2 = this.f1678f;
            if (c2 == '<') {
                return h();
            }
            return c2 == '&' ? f() : a2;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        int c() {
            this.f1677e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f1677e < this.f1676d && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f1677e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        i3--;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        i3--;
                    case 18:
                        i3++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        int d() {
            this.f1677e = this.f1676d;
            int i = 0;
            int i2 = 0;
            while (this.f1677e > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i == 0) {
                            i = i2;
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i != 0) {
                                    break;
                                } else {
                                    i = i2;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i == 0) {
                        i = i2;
                    }
                }
            }
            return 0;
        }

        byte a() {
            this.f1678f = this.f1674b.charAt(this.f1677e - 1);
            if (Character.isLowSurrogate(this.f1678f)) {
                int codePointBefore = Character.codePointBefore(this.f1674b, this.f1677e);
                this.f1677e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1677e--;
            byte a2 = a(this.f1678f);
            if (!this.f1675c) {
                return a2;
            }
            char c2 = this.f1678f;
            if (c2 == '>') {
                return g();
            }
            return c2 == ';' ? e() : a2;
        }
    }

    /* synthetic */ BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat, AnonymousClass1 anonymousClass1) {
        this(z, i, textDirectionHeuristicCompat);
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public boolean getStereoReset() {
        return (this.f1668g & 2) != 0;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.f1667f;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f1670a;

        /* renamed from: b */
        private int f1671b;

        /* renamed from: c */
        private TextDirectionHeuristicCompat f1672c;

        public Builder() {
            b(BidiFormatter.b(Locale.getDefault()));
        }

        private static BidiFormatter a(boolean z) {
            return z ? BidiFormatter.f1666e : BidiFormatter.f1665d;
        }

        private void b(boolean z) {
            this.f1670a = z;
            this.f1672c = BidiFormatter.f1662a;
            this.f1671b = 2;
        }

        public BidiFormatter build() {
            if (this.f1671b == 2 && this.f1672c == BidiFormatter.f1662a) {
                return a(this.f1670a);
            }
            return new BidiFormatter(this.f1670a, this.f1671b, this.f1672c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f1672c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.f1671b |= 2;
            } else {
                this.f1671b &= -3;
            }
            return this;
        }

        public Builder(boolean z) {
            b(z);
        }

        public Builder(Locale locale) {
            b(BidiFormatter.b(locale));
        }
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f1667f = z;
        this.f1668g = i;
        this.f1669h = textDirectionHeuristicCompat;
    }

    private String b(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (this.f1667f || !(isRtl || a(charSequence) == 1)) {
            return this.f1667f ? (!isRtl || a(charSequence) == -1) ? f1664c : "" : "";
        }
        return f1663b;
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.f1669h.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.f1667f) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    private String a(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (this.f1667f || !(isRtl || b(charSequence) == 1)) {
            return this.f1667f ? (!isRtl || b(charSequence) == -1) ? f1664c : "" : "";
        }
        return f1663b;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static boolean b(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).c();
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.f1669h, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.f1669h, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.f1669h, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.f1669h, true);
    }
}
