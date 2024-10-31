package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.support.v7.widget.AppCompatCheckBox;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import java.io.File;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;

/* compiled from: SongAdapter.kt */
/* loaded from: classes.dex */
public final class x extends BaseAdapter implements SectionIndexer {

    /* renamed from: c */
    private String[] f21495c;

    /* renamed from: d */
    private int[] f21496d;

    /* renamed from: e */
    private int[] f21497e;

    /* renamed from: f */
    private int f21498f = -1;

    /* renamed from: g */
    private int f21499g = -1;

    /* renamed from: h */
    private List<? extends u> f21500h;
    private final b i;
    private boolean j;

    /* renamed from: b */
    public static final a f21494b = new a(null);

    /* renamed from: a */
    private static final String f21493a = x.class.getSimpleName();

    /* compiled from: SongAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SongAdapter.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a(x xVar, u uVar, int i);

        void b(x xVar, u uVar, int i);
    }

    /* compiled from: SongAdapter.kt */
    /* loaded from: classes.dex */
    private final class c {

        /* renamed from: a */
        private ImageView f21501a;

        /* renamed from: b */
        private TextView f21502b;

        /* renamed from: c */
        private TextView f21503c;

        /* renamed from: d */
        private LinearLayout f21504d;

        /* renamed from: e */
        private ImageButton f21505e;

        /* renamed from: f */
        private AppCompatCheckBox f21506f;

        public c() {
        }

        public final void a(ImageView imageView) {
            this.f21501a = imageView;
        }

        public final void b(TextView textView) {
            this.f21502b = textView;
        }

        public final ImageView c() {
            return this.f21501a;
        }

        public final LinearLayout d() {
            return this.f21504d;
        }

        public final TextView e() {
            return this.f21503c;
        }

        public final TextView f() {
            return this.f21502b;
        }

        public final void a(TextView textView) {
            this.f21503c = textView;
        }

        public final ImageButton b() {
            return this.f21505e;
        }

        public final void a(LinearLayout linearLayout) {
            this.f21504d = linearLayout;
        }

        public final void a(ImageButton imageButton) {
            this.f21505e = imageButton;
        }

        public final AppCompatCheckBox a() {
            return this.f21506f;
        }

        public final void a(AppCompatCheckBox appCompatCheckBox) {
            this.f21506f = appCompatCheckBox;
        }
    }

    public x(List<? extends u> list, b bVar, boolean z) {
        this.f21500h = list;
        this.i = bVar;
        this.j = z;
        c();
    }

    private final String d(int i) {
        if (i < 0) {
            return "?:??";
        }
        int i2 = i % 3600000;
        int i3 = i2 / 60000;
        int i4 = (i2 % 60000) / 1000;
        if (i3 == 0 && i4 == 0 && i > 0) {
            i4 = 1;
        }
        kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f28544a;
        Locale locale = Locale.US;
        kotlin.jvm.internal.h.a((Object) locale, "Locale.US");
        Object[] objArr = {Integer.valueOf(i3), Integer.valueOf(i4)};
        String format = String.format(locale, "%d:%02d", Arrays.copyOf(objArr, objArr.length));
        kotlin.jvm.internal.h.a((Object) format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public final int b() {
        return this.f21498f;
    }

    public final void c(int i) {
        this.f21498f = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends u> list = this.f21500h;
        if (list != null) {
            return list.size();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        int[] iArr = this.f21496d;
        if (iArr != null && i >= 0) {
            if (iArr == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (i < iArr.length) {
                if (iArr != null) {
                    return iArr[i];
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        if (this.f21496d == null) {
            return -1;
        }
        String[] strArr = this.f21495c;
        if (strArr != null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.f21496d;
                if (iArr == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (iArr[i2] < i) {
                    return i2 - 1;
                }
            }
            String[] strArr2 = this.f21495c;
            if (strArr2 != null) {
                return strArr2.length;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.audiobrowser.x.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private final void c() {
        char charAt;
        List<? extends u> list = this.f21500h;
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            this.f21495c = new String[0];
            return;
        }
        List<? extends u> list2 = this.f21500h;
        if (list2 != null) {
            char[] cArr = new char[list2.size()];
            List<? extends u> list3 = this.f21500h;
            if (list3 != null) {
                this.f21496d = new int[list3.size()];
                List<? extends u> list4 = this.f21500h;
                if (list4 != null) {
                    this.f21497e = new int[list4.size()];
                    List<? extends u> list5 = this.f21500h;
                    if (list5 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    int size = list5.size();
                    int i = 0;
                    int i2 = 0;
                    char c2 = 0;
                    while (true) {
                        String str = "";
                        if (i < size) {
                            List<? extends u> list6 = this.f21500h;
                            if (list6 != null) {
                                String b2 = list6.get(i).b();
                                if (b2 == null) {
                                    List<? extends u> list7 = this.f21500h;
                                    if (list7 == null) {
                                        kotlin.jvm.internal.h.a();
                                        throw null;
                                    }
                                    String e2 = list7.get(i).e();
                                    boolean z = e2 == null;
                                    if (!z) {
                                        if (z) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str = new File(e2).getName();
                                        kotlin.jvm.internal.h.a((Object) str, "File(path).name");
                                    }
                                } else {
                                    String normalize = Normalizer.normalize(b2, Normalizer.Form.NFD);
                                    kotlin.jvm.internal.h.a((Object) normalize, "Normalizer.normalize(dis…ame, Normalizer.Form.NFD)");
                                    if (normalize == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    str = normalize.toUpperCase();
                                    kotlin.jvm.internal.h.a((Object) str, "(this as java.lang.String).toUpperCase()");
                                }
                                boolean z2 = str.length() == 0;
                                if (z2) {
                                    charAt = '?';
                                } else if (!z2) {
                                    charAt = str.charAt(0);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                if (c2 != charAt) {
                                    if (c2 != 0) {
                                        i2++;
                                    }
                                    int[] iArr = this.f21496d;
                                    if (iArr != null) {
                                        iArr[i2] = i;
                                        cArr[i2] = charAt;
                                        c2 = charAt;
                                    } else {
                                        kotlin.jvm.internal.h.a();
                                        throw null;
                                    }
                                }
                                int[] iArr2 = this.f21497e;
                                if (iArr2 == null) {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                                int[] iArr3 = this.f21496d;
                                if (iArr3 == null) {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                                iArr2[i] = iArr3[i2];
                                i++;
                            } else {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                        } else {
                            int i3 = i2 + 1;
                            String[] strArr = new String[i3];
                            for (int i4 = 0; i4 < i3; i4++) {
                                strArr[i4] = "";
                            }
                            this.f21495c = strArr;
                            for (int i5 = 0; i5 < i3; i5++) {
                                String[] strArr2 = this.f21495c;
                                if (strArr2 == null) {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                                String ch = Character.toString(cArr[i5]);
                                kotlin.jvm.internal.h.a((Object) ch, "Character.toString(storeHead[i])");
                                strArr2[i5] = ch;
                            }
                            return;
                        }
                    }
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    public final int a() {
        return this.f21499g;
    }

    public final void b(int i) {
        this.f21499g = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public u getItem(int i) {
        List<? extends u> list = this.f21500h;
        if (list != null) {
            return list.get(i);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.SectionIndexer
    public String[] getSections() {
        return this.f21495c;
    }

    public final void a(List<? extends u> list) {
        kotlin.jvm.internal.h.b(list, "trackInfoList");
        this.f21500h = list;
        c();
        notifyDataSetChanged();
    }

    public final void a(int i) {
        b bVar = this.i;
        if (bVar != null) {
            List<? extends u> list = this.f21500h;
            if (list != null) {
                bVar.b(this, list.get(i), i);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    public final void a(boolean z) {
        this.j = z;
    }
}
