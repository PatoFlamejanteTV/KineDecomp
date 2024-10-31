package com.mixpanel.android.surveys;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.mixpanel.android.a;
import com.mixpanel.android.mpmetrics.Survey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CardCarouselLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private static int f3053a = 45;
    private static float b = 0.8f;
    private static float c = 0.5f;
    private static float d = 0.5f;
    private final List<View> e;
    private c f;
    private c g;
    private b h;

    /* loaded from: classes.dex */
    public enum Direction {
        FORWARD,
        BACKWARD
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Survey.a aVar, String str);
    }

    /* loaded from: classes.dex */
    public static class UnrecognizedAnswerTypeException extends Exception {
        private static final long serialVersionUID = -6040399928243560328L;

        /* synthetic */ UnrecognizedAnswerTypeException(String str, com.mixpanel.android.surveys.a aVar) {
            this(str);
        }

        private UnrecognizedAnswerTypeException(String str) {
            super(str);
        }
    }

    public CardCarouselLayout(Context context) {
        super(context);
        this.e = new ArrayList(1);
        this.h = null;
        a(context);
    }

    public CardCarouselLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList(1);
        this.h = null;
        a(context);
    }

    public CardCarouselLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ArrayList(1);
        this.h = null;
        a(context);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setOnQuestionAnsweredListener(b bVar) {
        this.h = bVar;
    }

    public void a(Survey.a aVar, String str, Direction direction) throws UnrecognizedAnswerTypeException {
        Animation b2;
        Animation animation = null;
        c cVar = this.g;
        this.g = this.f;
        this.f = cVar;
        this.f.a(aVar, str);
        View a2 = this.g.a();
        View a3 = this.f.a();
        a2.setVisibility(0);
        a3.setVisibility(0);
        switch (direction) {
            case FORWARD:
                b2 = d();
                animation = a();
                break;
            case BACKWARD:
                b2 = b();
                animation = c();
                break;
            default:
                b2 = null;
                break;
        }
        b2.setAnimationListener(new com.mixpanel.android.surveys.a(this, a2));
        a2.startAnimation(b2);
        a3.startAnimation(animation);
        invalidate();
    }

    public void a(Survey.a aVar, String str) throws UnrecognizedAnswerTypeException {
        this.f.a(aVar, str);
        removeAllViews();
        addView(this.f.a());
        addView(this.g.a());
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        int childCount = getChildCount();
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        this.e.clear();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, 0, layoutParams.width), getChildMeasureSpec(i2, 0, layoutParams.height));
                i3 = Math.max(i3, childAt.getMeasuredWidth());
                i4 = Math.max(i4, childAt.getMeasuredHeight());
                if (z && (layoutParams.width == -1 || layoutParams.height == -1)) {
                    this.e.add(childAt);
                }
            }
        }
        setMeasuredDimension(resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
        for (View view : this.e) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2.width == -1) {
                childMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            } else {
                childMeasureSpec = getChildMeasureSpec(i, 0, layoutParams2.width);
            }
            if (layoutParams2.height == -1) {
                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            } else {
                childMeasureSpec2 = getChildMeasureSpec(i2, 0, layoutParams2.height);
            }
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        View a2 = this.f.a();
        if (a2.getVisibility() != 8) {
            i5 = a2.getMeasuredWidth();
            a2.layout(0, 0, i5, a2.getMeasuredHeight());
        } else {
            i5 = 0;
        }
        View a3 = this.g.a();
        if (a3.getVisibility() != 8) {
            a3.layout(i5, 0, a3.getMeasuredWidth() + i5, a3.getMeasuredHeight());
        }
    }

    private void a(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(a.d.com_mixpanel_android_question_card, (ViewGroup) this, false);
        this.f = new c(inflate);
        View inflate2 = from.inflate(a.d.com_mixpanel_android_question_card, (ViewGroup) this, false);
        this.g = new c(inflate2);
        addView(inflate);
        addView(inflate2);
    }

    private Animation a() {
        AnimationSet animationSet = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation(f3053a, 0.0f, 1, c, 1, d);
        rotateAnimation.setDuration(198L);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(b, 1.0f, b, 1.0f, 1, c, 1, d);
        scaleAnimation.setDuration(198L);
        animationSet.addAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.3f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(330L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    private Animation b() {
        AnimationSet animationSet = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f3053a, 1, c, 1, d);
        rotateAnimation.setDuration(198L);
        rotateAnimation.setStartOffset(132L);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, b, 1.0f, b, 1, c, 1, d);
        scaleAnimation.setDuration(198L);
        scaleAnimation.setStartOffset(132L);
        animationSet.addAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.3f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(330L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    private Animation c() {
        AnimationSet animationSet = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation(-f3053a, 0.0f, 1, c, 1, d);
        rotateAnimation.setDuration(198L);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(b, 1.0f, b, 1.0f, 1, c, 1, d);
        scaleAnimation.setDuration(198L);
        animationSet.addAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.3f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(330L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    private Animation d() {
        AnimationSet animationSet = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -f3053a, 1, c, 1, d);
        rotateAnimation.setDuration(330L);
        rotateAnimation.setStartOffset(132L);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, b, 1.0f, b, 1, c, 1, d);
        scaleAnimation.setDuration(330L);
        scaleAnimation.setStartOffset(132L);
        animationSet.addAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, -2.3f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(330L);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ListAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f3055a;
        private final LayoutInflater b;

        public a(List<String> list, LayoutInflater layoutInflater) {
            this.f3055a = list;
            this.b = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f3055a.size();
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getItem(int i) {
            return this.f3055a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == this.f3055a.size() - 1) {
                return 1;
            }
            return 2;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = -1;
            if (view == null) {
                switch (getItemViewType(i)) {
                    case 0:
                        i2 = a.d.com_mixpanel_android_first_choice_answer;
                        break;
                    case 1:
                        i2 = a.d.com_mixpanel_android_last_choice_answer;
                        break;
                    case 2:
                        i2 = a.d.com_mixpanel_android_middle_choice_answer;
                        break;
                }
                view = this.b.inflate(i2, viewGroup, false);
            }
            ((TextView) view.findViewById(a.c.com_mixpanel_android_multiple_choice_answer_text)).setText(this.f3055a.get(i));
            return view;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return this.f3055a.isEmpty();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        private Survey.a b;
        private final View c;
        private final TextView d;
        private final TextView e;
        private final ListView f;

        public c(View view) {
            this.c = view;
            this.d = (TextView) view.findViewWithTag("com_mixpanel_android_TAG_prompt_text");
            this.e = (EditText) view.findViewWithTag("com_mixpanel_android_TAG_text_answer");
            this.f = (ListView) view.findViewWithTag("com_mixpanel_android_TAG_choice_list");
            this.e.setText("");
            this.e.setOnEditorActionListener(new com.mixpanel.android.surveys.b(this, CardCarouselLayout.this));
            this.f.setOnItemClickListener(new com.mixpanel.android.surveys.c(this, CardCarouselLayout.this));
        }

        public View a() {
            return this.c;
        }

        public void a(Survey.a aVar, String str) throws UnrecognizedAnswerTypeException {
            this.b = aVar;
            this.d.setText(this.b.b());
            InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
            Survey.QuestionType d = aVar.d();
            if (Survey.QuestionType.TEXT == d) {
                this.f.setVisibility(8);
                this.e.setVisibility(0);
                if (str != null) {
                    this.e.setText(str);
                }
                if (CardCarouselLayout.this.getResources().getConfiguration().orientation == 1) {
                    this.e.requestFocus();
                    inputMethodManager.showSoftInput(this.e, 0);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
                }
            } else if (Survey.QuestionType.MULTIPLE_CHOICE == d) {
                inputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
                this.f.setVisibility(0);
                this.e.setVisibility(8);
                a aVar2 = new a(aVar.c(), LayoutInflater.from(CardCarouselLayout.this.getContext()));
                this.f.setAdapter((ListAdapter) aVar2);
                this.f.clearChoices();
                if (str != null) {
                    for (int i = 0; i < aVar2.getCount(); i++) {
                        if (aVar2.getItem(i).equals(str)) {
                            this.f.setItemChecked(i, true);
                        }
                    }
                }
            } else {
                throw new UnrecognizedAnswerTypeException("No way to display question type " + d, null);
            }
            this.c.invalidate();
        }
    }
}
