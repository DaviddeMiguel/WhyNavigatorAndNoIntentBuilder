package com.meslize.whynavigatorandnointentbuilder.main;

import android.app.Activity;

import com.meslize.whynavigatorandnointentbuilder.R;
import com.meslize.whynavigatorandnointentbuilder.navigator.Navigator;
import com.meslize.whynavigatorandnointentbuilder.navigator.NavigatorImpl;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity (R.layout.activity_main)
public class MainActivity extends Activity {

    String mExtraText = "Extra text";

    @Bean (NavigatorImpl.class) Navigator mNavigator;

    @Click (R.id.btn_next)
    void clickNext() {
        mNavigator.startMyNextActivity(mExtraText);
    }
}
