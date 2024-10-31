package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class CaseFormat extends Enum<CaseFormat> {
    private final CharMatcher wordBoundary;
    private final String wordSeparator;
    public static final CaseFormat LOWER_HYPHEN = new CaseFormat("LOWER_HYPHEN", 0, CharMatcher.b('-'), "-") { // from class: com.google.common.base.CaseFormat.1
        AnonymousClass1(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.b(str.replace('-', '_'));
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.a(str);
        }
    };
    public static final CaseFormat LOWER_UNDERSCORE = new CaseFormat("LOWER_UNDERSCORE", 1, CharMatcher.b('_'), io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR) { // from class: com.google.common.base.CaseFormat.2
        AnonymousClass2(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.b(str);
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.a(str);
        }
    };
    public static final CaseFormat LOWER_CAMEL = new CaseFormat("LOWER_CAMEL", 2, CharMatcher.a('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.3
        AnonymousClass3(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return CaseFormat.a(str);
        }
    };
    public static final CaseFormat UPPER_CAMEL = new CaseFormat("UPPER_CAMEL", 3, CharMatcher.a('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.4
        AnonymousClass4(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return CaseFormat.a(str);
        }
    };
    public static final CaseFormat UPPER_UNDERSCORE = new CaseFormat("UPPER_UNDERSCORE", 4, CharMatcher.b('_'), io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR) { // from class: com.google.common.base.CaseFormat.5
        AnonymousClass5(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return Ascii.a(str.replace('_', '-'));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return Ascii.a(str);
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.b(str);
        }
    };
    private static final /* synthetic */ CaseFormat[] $VALUES = {LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.base.CaseFormat$1 */
    /* loaded from: classes2.dex */
    public enum AnonymousClass1 extends CaseFormat {
        AnonymousClass1(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.b(str.replace('-', '_'));
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.a(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$2 */
    /* loaded from: classes2.dex */
    enum AnonymousClass2 extends CaseFormat {
        AnonymousClass2(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.b(str);
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.a(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$3 */
    /* loaded from: classes2.dex */
    enum AnonymousClass3 extends CaseFormat {
        AnonymousClass3(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return CaseFormat.a(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$4 */
    /* loaded from: classes2.dex */
    enum AnonymousClass4 extends CaseFormat {
        AnonymousClass4(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return CaseFormat.a(str);
        }
    }

    /* renamed from: com.google.common.base.CaseFormat$5 */
    /* loaded from: classes2.dex */
    enum AnonymousClass5 extends CaseFormat {
        AnonymousClass5(String str, int i, CharMatcher charMatcher, String str2) {
            super(str, i, charMatcher, str2);
        }

        @Override // com.google.common.base.CaseFormat
        String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return Ascii.a(str.replace('_', '-'));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return Ascii.a(str);
            }
            return super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String normalizeWord(String str) {
            return Ascii.b(str);
        }
    }

    /* loaded from: classes2.dex */
    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            Preconditions.a(caseFormat);
            this.sourceFormat = caseFormat;
            Preconditions.a(caseFormat2);
            this.targetFormat = caseFormat2;
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }
    }

    /* synthetic */ CaseFormat(String str, int i, CharMatcher charMatcher, String str2, AnonymousClass1 anonymousClass1) {
        this(str, i, charMatcher, str2);
    }

    public static String a(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.d(str.charAt(0)) + Ascii.a(str.substring(1));
    }

    private String b(String str) {
        return this == LOWER_CAMEL ? Ascii.a(str) : normalizeWord(str);
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    String convert(CaseFormat caseFormat, String str) {
        int i = 0;
        StringBuilder sb = null;
        int i2 = -1;
        while (true) {
            i2 = this.wordBoundary.a(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb.append(caseFormat.b(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i, i2)));
            }
            sb.append(caseFormat.wordSeparator);
            i = this.wordSeparator.length() + i2;
        }
        if (i == 0) {
            return caseFormat.b(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i)));
        return sb.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        Preconditions.a(caseFormat);
        Preconditions.a(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }

    private CaseFormat(String str, int i, CharMatcher charMatcher, String str2) {
        super(str, i);
        this.wordBoundary = charMatcher;
        this.wordSeparator = str2;
    }
}
