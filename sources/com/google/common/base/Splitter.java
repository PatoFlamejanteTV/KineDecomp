package com.google.common.base;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.annotations.Beta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Splitter {

    /* renamed from: a */
    private final CharMatcher f15109a;

    /* renamed from: b */
    private final boolean f15110b;

    /* renamed from: c */
    private final b f15111c;

    /* renamed from: d */
    private final int f15112d;

    @Beta
    /* loaded from: classes2.dex */
    public static final class MapSplitter {
    }

    /* loaded from: classes2.dex */
    public static abstract class a extends AbstractIterator<String> {

        /* renamed from: c */
        final CharSequence f15113c;

        /* renamed from: d */
        final CharMatcher f15114d;

        /* renamed from: e */
        final boolean f15115e;

        /* renamed from: f */
        int f15116f = 0;

        /* renamed from: g */
        int f15117g;

        public a(Splitter splitter, CharSequence charSequence) {
            this.f15114d = splitter.f15109a;
            this.f15115e = splitter.f15110b;
            this.f15117g = splitter.f15112d;
            this.f15113c = charSequence;
        }

        abstract int a(int i);

        abstract int b(int i);

        @Override // com.google.common.base.AbstractIterator
        public String b() {
            int b2;
            int i = this.f15116f;
            while (true) {
                int i2 = this.f15116f;
                if (i2 != -1) {
                    b2 = b(i2);
                    if (b2 == -1) {
                        b2 = this.f15113c.length();
                        this.f15116f = -1;
                    } else {
                        this.f15116f = a(b2);
                    }
                    int i3 = this.f15116f;
                    if (i3 == i) {
                        this.f15116f = i3 + 1;
                        if (this.f15116f >= this.f15113c.length()) {
                            this.f15116f = -1;
                        }
                    } else {
                        while (i < b2 && this.f15114d.d(this.f15113c.charAt(i))) {
                            i++;
                        }
                        while (b2 > i && this.f15114d.d(this.f15113c.charAt(b2 - 1))) {
                            b2--;
                        }
                        if (!this.f15115e || i != b2) {
                            break;
                        }
                        i = this.f15116f;
                    }
                } else {
                    return c();
                }
            }
            int i4 = this.f15117g;
            if (i4 == 1) {
                b2 = this.f15113c.length();
                this.f15116f = -1;
                while (b2 > i && this.f15114d.d(this.f15113c.charAt(b2 - 1))) {
                    b2--;
                }
            } else {
                this.f15117g = i4 - 1;
            }
            return this.f15113c.subSequence(i, b2).toString();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        Iterator<String> a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(b bVar) {
        this(bVar, false, CharMatcher.m(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private Splitter(b bVar, boolean z, CharMatcher charMatcher, int i) {
        this.f15111c = bVar;
        this.f15110b = z;
        this.f15109a = charMatcher;
        this.f15112d = i;
    }

    public Iterator<String> c(CharSequence charSequence) {
        return this.f15111c.a(this, charSequence);
    }

    public Splitter b() {
        return b(CharMatcher.o());
    }

    public static Splitter a(char c2) {
        return a(CharMatcher.b(c2));
    }

    public Splitter b(CharMatcher charMatcher) {
        Preconditions.a(charMatcher);
        return new Splitter(this.f15111c, this.f15110b, charMatcher, this.f15112d);
    }

    public static Splitter a(CharMatcher charMatcher) {
        Preconditions.a(charMatcher);
        return new Splitter(new o(charMatcher));
    }

    @Beta
    public List<String> b(CharSequence charSequence) {
        Preconditions.a(charSequence);
        Iterator<String> c2 = c(charSequence);
        ArrayList arrayList = new ArrayList();
        while (c2.hasNext()) {
            arrayList.add(c2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Splitter a(String str) {
        Preconditions.a(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return a(str.charAt(0));
        }
        return new Splitter(new q(str));
    }

    public Splitter a() {
        return new Splitter(this.f15111c, true, this.f15109a, this.f15112d);
    }

    public Splitter a(int i) {
        Preconditions.a(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.f15111c, this.f15110b, this.f15109a, i);
    }

    public Iterable<String> a(CharSequence charSequence) {
        Preconditions.a(charSequence);
        return new r(this, charSequence);
    }
}
