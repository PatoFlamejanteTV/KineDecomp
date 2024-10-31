package com.mixpanel.android.surveys;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.a;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.m;
import com.mixpanel.android.mpmetrics.n;
import com.mixpanel.android.surveys.CardCarouselLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
/* loaded from: classes.dex */
public class SurveyActivity extends Activity {
    private static final int k = Color.argb(255, 90, 90, 90);

    /* renamed from: a, reason: collision with root package name */
    private AlertDialog f3060a;
    private CardCarouselLayout b;
    private n c;
    private View d;
    private View e;
    private TextView f;
    private UpdateDisplayState g;
    private boolean h = false;
    private int i = 0;
    private int j = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = getIntent().getIntExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", Integer.MAX_VALUE);
        this.g = UpdateDisplayState.b(this.j);
        if (this.g == null) {
            Log.e("MixpanelAPI.SrvyActvty", "SurveyActivity intent received, but nothing was found to show.");
            finish();
            return;
        }
        this.c = n.a(this, this.g.e());
        if (e()) {
            a(bundle);
        } else if (d()) {
            b(bundle);
        } else {
            finish();
        }
    }

    private void a(Bundle bundle) {
        setContentView(a.d.com_mixpanel_android_activity_notification_full);
        View view = (ImageView) findViewById(a.c.com_mixpanel_android_notification_gradient);
        FadingImageView fadingImageView = (FadingImageView) findViewById(a.c.com_mixpanel_android_notification_image);
        TextView textView = (TextView) findViewById(a.c.com_mixpanel_android_notification_title);
        TextView textView2 = (TextView) findViewById(a.c.com_mixpanel_android_notification_subtext);
        Button button = (Button) findViewById(a.c.com_mixpanel_android_notification_button);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.c.com_mixpanel_android_button_exit_wrapper);
        InAppNotification c = ((UpdateDisplayState.DisplayState.InAppNotificationState) this.g.c()).c();
        getWindowManager().getDefaultDisplay().getSize(new Point());
        if (getResources().getConfiguration().orientation == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, (int) (r3.y * 0.06f));
            linearLayout.setLayoutParams(layoutParams);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-446668676, -448247715, -451405793, -451405793});
        gradientDrawable.setGradientType(1);
        if (getResources().getConfiguration().orientation == 2) {
            gradientDrawable.setGradientCenter(0.25f, 0.5f);
            gradientDrawable.setGradientRadius(Math.min(r3.x, r3.y) * 0.8f);
        } else {
            gradientDrawable.setGradientCenter(0.5f, 0.33f);
            gradientDrawable.setGradientRadius(Math.min(r3.x, r3.y) * 0.7f);
        }
        a(view, gradientDrawable);
        textView.setText(c.e());
        textView2.setText(c.f());
        Bitmap l = c.l();
        fadingImageView.setBackgroundResource(a.b.com_mixpanel_android_square_dropshadow);
        if (l.getWidth() < 100 || l.getHeight() < 100) {
            fadingImageView.setBackgroundResource(a.b.com_mixpanel_android_square_nodropshadow);
        } else {
            int height = l.getHeight() / 100;
            int width = l.getWidth() / 100;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(l, width, height, false);
            int i = 0;
            loop0: while (true) {
                if (i >= width) {
                    break;
                }
                for (int i2 = 0; i2 < height; i2++) {
                    if (Color.alpha(createScaledBitmap.getPixel(i, i2)) < 255) {
                        fadingImageView.setBackgroundResource(a.b.com_mixpanel_android_square_nodropshadow);
                        break loop0;
                    }
                }
                i++;
            }
        }
        fadingImageView.setImageBitmap(l);
        String k2 = c.k();
        if (k2 != null && k2.length() > 0) {
            button.setText(c.j());
        }
        button.setOnClickListener(new e(this, c));
        button.setOnTouchListener(new f(this));
        linearLayout.setOnClickListener(new g(this));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(200L);
        fadingImageView.startAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(200L);
        textView.startAnimation(translateAnimation);
        textView2.startAnimation(translateAnimation);
        button.startAnimation(translateAnimation);
        linearLayout.startAnimation(AnimationUtils.loadAnimation(this, a.C0054a.com_mixpanel_android_fade_in));
    }

    private void b(Bundle bundle) {
        g();
        if (bundle != null) {
            this.i = bundle.getInt("com.mixpanel.android.surveys.SurveyActivity.CURRENT_QUESTION_BUNDLE_KEY", 0);
            this.h = bundle.getBoolean("com.mixpanel.android.surveys.SurveyActivity.SURVEY_BEGIN_BUNDLE_KEY");
        }
        if (this.g.d() == null) {
            Log.i("MixpanelAPI.SrvyActvty", "Can't show a survey to a user with no distinct id set");
            finish();
            return;
        }
        setContentView(a.d.com_mixpanel_android_activity_survey);
        Bitmap b = c().b();
        if (b == null) {
            findViewById(a.c.com_mixpanel_android_activity_survey_id).setBackgroundColor(k);
        } else {
            getWindow().setBackgroundDrawable(new BitmapDrawable(getResources(), b));
        }
        this.d = findViewById(a.c.com_mixpanel_android_button_previous);
        this.e = findViewById(a.c.com_mixpanel_android_button_next);
        this.f = (TextView) findViewById(a.c.com_mixpanel_android_progress_text);
        this.b = (CardCarouselLayout) findViewById(a.c.com_mixpanel_android_question_card_holder);
        this.b.setOnQuestionAnsweredListener(new h(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        UpdateDisplayState.DisplayState c = this.g.c();
        if (c != null && c.a() == "SurveyState") {
            a();
        }
    }

    private void a() {
        if (!this.h) {
            if (!m.a(this).j()) {
                f();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(a.e.com_mixpanel_android_survey_prompt_dialog_title);
            builder.setMessage(a.e.com_mixpanel_android_survey_prompt_dialog_message);
            builder.setPositiveButton(a.e.com_mixpanel_android_sure, new i(this));
            builder.setNegativeButton(a.e.com_mixpanel_android_no_thanks, new j(this));
            builder.setCancelable(false);
            this.f3060a = builder.create();
            this.f3060a.show();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f3060a != null) {
            this.f3060a.dismiss();
            this.f3060a = null;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (d()) {
            b();
        }
        super.onDestroy();
    }

    @SuppressLint({"SimpleDateFormat"})
    private void b() {
        int i;
        if (this.c != null) {
            if (this.g != null) {
                UpdateDisplayState.DisplayState.SurveyState c = c();
                Survey d = c.d();
                List<Survey.a> d2 = d.d();
                int i2 = 0;
                n.c d3 = this.c.c().d(this.g.d());
                d3.b("$responses", Integer.valueOf(d.c()));
                UpdateDisplayState.AnswerMap c2 = c.c();
                Iterator<Survey.a> it = d2.iterator();
                while (true) {
                    i = i2;
                    if (it.hasNext()) {
                        Survey.a next = it.next();
                        String a2 = c2.a(Integer.valueOf(next.a()));
                        if (a2 != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("$survey_id", d.b());
                                jSONObject.put("$collection_id", d.c());
                                jSONObject.put("$question_id", next.a());
                                jSONObject.put("$question_type", next.d().toString());
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                jSONObject.put("$time", simpleDateFormat.format(new Date()));
                                jSONObject.put("$value", a2);
                                d3.b("$answers", jSONObject);
                                i++;
                            } catch (JSONException e) {
                                Log.e("MixpanelAPI.SrvyActvty", "Couldn't record user's answer.", e);
                            }
                        }
                        i2 = i;
                    } else {
                        try {
                            break;
                        } catch (JSONException e2) {
                            Log.e("MixpanelAPI.SrvyActvty", "Couldn't record survey shown.", e2);
                        }
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("survey_id", d.b());
                jSONObject2.put("collection_id", d.c());
                jSONObject2.put("$answer_count", i);
                jSONObject2.put("$survey_shown", this.h);
                this.c.a("$show_survey", jSONObject2);
            }
            this.c.a();
        }
        UpdateDisplayState.a(this.j);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (d()) {
            c(bundle);
        }
    }

    private void c(Bundle bundle) {
        bundle.putBoolean("com.mixpanel.android.surveys.SurveyActivity.SURVEY_BEGIN_BUNDLE_KEY", this.h);
        bundle.putInt("com.mixpanel.android.surveys.SurveyActivity.CURRENT_QUESTION_BUNDLE_KEY", this.i);
        bundle.putParcelable("com.mixpanel.android.surveys.SurveyActivity.SURVEY_STATE_BUNDLE_KEY", this.g);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (d() && this.i > 0) {
            goToPreviousQuestion();
            return;
        }
        if (e()) {
            UpdateDisplayState.a(this.j);
        }
        super.onBackPressed();
    }

    public void goToPreviousQuestion(View view) {
        goToPreviousQuestion();
    }

    public void goToNextQuestion(View view) {
        goToNextQuestion();
    }

    public void completeSurvey(View view) {
        completeSurvey();
    }

    private UpdateDisplayState.DisplayState.SurveyState c() {
        return (UpdateDisplayState.DisplayState.SurveyState) this.g.c();
    }

    private boolean d() {
        if (this.g == null) {
            return false;
        }
        return "SurveyState".equals(this.g.c().a());
    }

    private boolean e() {
        if (this.g == null) {
            return false;
        }
        return "InAppNotificationState".equals(this.g.c().a());
    }

    private void f() {
        Survey d = c().d();
        n.c d2 = this.c.c().d(this.g.d());
        d2.b("$surveys", Integer.valueOf(d.b()));
        d2.b("$collections", Integer.valueOf(d.c()));
    }

    private void goToPreviousQuestion() {
        if (this.i > 0) {
            a(this.i - 1);
        } else {
            completeSurvey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToNextQuestion() {
        if (this.i < c().d().d().size() - 1) {
            a(this.i + 1);
        } else {
            completeSurvey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        UpdateDisplayState.DisplayState.SurveyState c = c();
        List<Survey.a> d = c.d().d();
        if (i == 0 || d.size() == 0) {
            this.d.setEnabled(false);
        } else {
            this.d.setEnabled(true);
        }
        if (i >= d.size() - 1) {
            this.e.setEnabled(false);
        } else {
            this.e.setEnabled(true);
        }
        int i2 = this.i;
        this.i = i;
        Survey.a aVar = d.get(i);
        String a2 = c.c().a(Integer.valueOf(aVar.a()));
        try {
            if (i2 < i) {
                this.b.a(aVar, a2, CardCarouselLayout.Direction.FORWARD);
            } else if (i2 > i) {
                this.b.a(aVar, a2, CardCarouselLayout.Direction.BACKWARD);
            } else {
                this.b.a(aVar, a2);
            }
            if (d.size() > 1) {
                this.f.setText("" + (i + 1) + " of " + d.size());
            } else {
                this.f.setText("");
            }
        } catch (CardCarouselLayout.UnrecognizedAnswerTypeException e) {
            goToNextQuestion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Survey.a aVar, String str) {
        c().c().a(Integer.valueOf(aVar.a()), str.toString());
    }

    @SuppressLint({"NewApi"})
    private void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @SuppressLint({"NewApi"})
    private void g() {
        if (Build.VERSION.SDK_INT >= 18) {
            setRequestedOrientation(14);
            return;
        }
        int i = getResources().getConfiguration().orientation;
        if (i == 2) {
            setRequestedOrientation(0);
        } else if (i == 1) {
            setRequestedOrientation(1);
        }
    }

    private void completeSurvey() {
        finish();
    }
}
