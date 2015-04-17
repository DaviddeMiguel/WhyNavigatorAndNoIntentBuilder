package com.meslize.whynavigatorandnointentbuilder.next;

import android.app.Activity;
import android.widget.TextView;

import com.meslize.whynavigatorandnointentbuilder.R;
import com.meslize.whynavigatorandnointentbuilder.navigator.Navigator;
import com.meslize.whynavigatorandnointentbuilder.navigator.NavigatorImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity (R.layout.activity_my_next)
public class MyNextActivity extends Activity {

    @Extra String mText;

    @Bean (NavigatorImpl.class) Navigator mNavigator;

    @ViewById (R.id.text) TextView mTextView;

    @AfterViews
    void afterViews() {
        mTextView.setText(mText);
    }

    @Click (R.id.btn_back)
    void clickBack() {
        mNavigator.finishView();
    }
}
