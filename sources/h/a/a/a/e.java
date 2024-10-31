package h.a.a.a;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalligraphyFactory.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a */
    private final int f26795a;

    public e(int i) {
        this.f26795a = i;
    }

    protected static int[] a(TextView textView) {
        int[] iArr = {-1, -1};
        if (c(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843512;
        } else if (b(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843513;
        }
        if (iArr[0] == -1) {
            iArr[0] = b.a().c().containsKey(textView.getClass()) ? b.a().c().get(textView.getClass()).intValue() : R.attr.textAppearance;
        }
        return iArr;
    }

    @SuppressLint({"NewApi"})
    protected static boolean b(TextView textView) {
        if (a(textView, "action_bar_subtitle")) {
            return true;
        }
        if (a((View) textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getSubtitle(), textView.getText());
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    protected static boolean c(TextView textView) {
        if (a(textView, "action_bar_title")) {
            return true;
        }
        if (a((View) textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getTitle(), textView.getText());
        }
        return false;
    }

    void b(View view, Context context, AttributeSet attributeSet) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (m.b(textView.getTypeface())) {
                return;
            }
            String c2 = i.c(context, attributeSet, this.f26795a);
            if (TextUtils.isEmpty(c2)) {
                c2 = i.a(context, attributeSet, this.f26795a);
            }
            if (TextUtils.isEmpty(c2)) {
                c2 = i.b(context, attributeSet, this.f26795a);
            }
            if (TextUtils.isEmpty(c2)) {
                int[] a2 = a(textView);
                if (a2[1] != -1) {
                    c2 = i.a(context, a2[0], a2[1], this.f26795a);
                } else {
                    c2 = i.a(context, a2[0], this.f26795a);
                }
            }
            i.a(context, textView, b.a(), c2, a(view, "action_bar_title") || a(view, "action_bar_subtitle"));
        }
        if (i.a() && (view instanceof Toolbar)) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, viewGroup, context));
        }
    }

    protected static boolean a(View view) {
        return i.a() && view.getParent() != null && (view.getParent() instanceof Toolbar);
    }

    protected static boolean a(View view, String str) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(str);
    }

    public View a(View view, Context context, AttributeSet attributeSet) {
        if (view != null && view.getTag(k.calligraphy_tag_id) != Boolean.TRUE) {
            b(view, context, attributeSet);
            view.setTag(k.calligraphy_tag_id, Boolean.TRUE);
        }
        return view;
    }
}
