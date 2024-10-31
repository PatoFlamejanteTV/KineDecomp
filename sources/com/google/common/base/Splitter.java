package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* loaded from: classes.dex */
public final class Splitter {

    /* renamed from: a, reason: collision with root package name */
    private final CharMatcher f2585a;
    private final boolean b;
    private final b c;
    private final int d;

    @Beta
    /* loaded from: classes2.dex */
    public static final class MapSplitter {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        Iterator<String> b(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(b bVar) {
        this(bVar, false, CharMatcher.m, Integer.MAX_VALUE);
    }

    private Splitter(b bVar, boolean z, CharMatcher charMatcher, int i) {
        this.c = bVar;
        this.b = z;
        this.f2585a = charMatcher;
        this.d = i;
    }

    public static Splitter a(char c) {
        return a(CharMatcher.a(c));
    }

    public static Splitter a(CharMatcher charMatcher) {
        Preconditions.a(charMatcher);
        return new Splitter(new w(charMatcher));
    }

    @CheckReturnValue
    public Splitter a() {
        return b(CharMatcher.o);
    }

    @CheckReturnValue
    public Splitter b(CharMatcher charMatcher) {
        Preconditions.a(charMatcher);
        return new Splitter(this.c, this.b, charMatcher, this.d);
    }

    public Iterable<String> a(CharSequence charSequence) {
        Preconditions.a(charSequence);
        return new y(this, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> b(CharSequence charSequence) {
        return this.c.b(this, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class a extends AbstractIterator<String> {
        final CharSequence b;
        final CharMatcher c;
        final boolean d;
        int e = 0;
        int f;

        abstract int a(int i);

        abstract int b(int i);

        /* JADX INFO: Access modifiers changed from: protected */
        public a(Splitter splitter, CharSequence charSequence) {
            this.c = splitter.f2585a;
            this.d = splitter.b;
            this.f = splitter.d;
            this.b = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String a() {
            int i = this.e;
            while (this.e != -1) {
                int a2 = a(this.e);
                if (a2 == -1) {
                    a2 = this.b.length();
                    this.e = -1;
                } else {
                    this.e = b(a2);
                }
                if (this.e == i) {
                    this.e++;
                    if (this.e >= this.b.length()) {
                        this.e = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < a2 && this.c.c(this.b.charAt(i2))) {
                        i2++;
                    }
                    int i3 = a2;
                    while (i3 > i2 && this.c.c(this.b.charAt(i3 - 1))) {
                        i3--;
                    }
                    if (this.d && i2 == i3) {
                        i = this.e;
                    } else {
                        if (this.f == 1) {
                            i3 = this.b.length();
                            this.e = -1;
                            while (i3 > i2 && this.c.c(this.b.charAt(i3 - 1))) {
                                i3--;
                            }
                        } else {
                            this.f--;
                        }
                        return this.b.subSequence(i2, i3).toString();
                    }
                }
            }
            return b();
        }
    }
}
