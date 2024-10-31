package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.a('-'), "-"),
    LOWER_UNDERSCORE(CharMatcher.a('_'), "_"),
    LOWER_CAMEL(CharMatcher.a('A', 'Z'), ""),
    UPPER_CAMEL(CharMatcher.a('A', 'Z'), ""),
    UPPER_UNDERSCORE(CharMatcher.a('_'), "_");

    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    CaseFormat(CharMatcher charMatcher, String str) {
        this.wordBoundary = charMatcher;
        this.wordSeparator = str;
    }

    public String to(CaseFormat caseFormat, String str) {
        if (caseFormat == null) {
            throw new NullPointerException();
        }
        if (str == null) {
            throw new NullPointerException();
        }
        if (caseFormat != this) {
            switch (this) {
                case LOWER_UNDERSCORE:
                    switch (caseFormat) {
                        case UPPER_UNDERSCORE:
                            return Ascii.b(str);
                        case LOWER_HYPHEN:
                            return str.replace('_', '-');
                    }
                case UPPER_UNDERSCORE:
                    switch (caseFormat) {
                        case LOWER_UNDERSCORE:
                            return Ascii.a(str);
                        case LOWER_HYPHEN:
                            return Ascii.a(str.replace('_', '-'));
                    }
                case LOWER_HYPHEN:
                    switch (caseFormat) {
                        case LOWER_UNDERSCORE:
                            return str.replace('-', '_');
                        case UPPER_UNDERSCORE:
                            return Ascii.b(str.replace('-', '_'));
                    }
            }
            int i = 0;
            StringBuilder sb = null;
            int i2 = -1;
            while (true) {
                i2 = this.wordBoundary.a(str, i2 + 1);
                if (i2 != -1) {
                    if (i == 0) {
                        sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                        sb.append(caseFormat.a(str.substring(i, i2)));
                    } else {
                        sb.append(caseFormat.b(str.substring(i, i2)));
                    }
                    sb.append(caseFormat.wordSeparator);
                    i = this.wordSeparator.length() + i2;
                } else {
                    if (i == 0) {
                        return caseFormat.a(str);
                    }
                    sb.append(caseFormat.b(str.substring(i)));
                    return sb.toString();
                }
            }
        } else {
            return str;
        }
    }

    private String a(String str) {
        switch (this) {
            case LOWER_CAMEL:
                return Ascii.a(str);
            default:
                return b(str);
        }
    }

    private String b(String str) {
        switch (this) {
            case LOWER_UNDERSCORE:
                return Ascii.a(str);
            case UPPER_UNDERSCORE:
                return Ascii.b(str);
            case LOWER_HYPHEN:
                return Ascii.a(str);
            case LOWER_CAMEL:
                return c(str);
            case UPPER_CAMEL:
                return c(str);
            default:
                throw new RuntimeException("unknown case: " + this);
        }
    }

    private static String c(String str) {
        int length = str.length();
        return length == 0 ? str : new StringBuilder(length).append(Ascii.b(str.charAt(0))).append(Ascii.a(str.substring(1))).toString();
    }
}
