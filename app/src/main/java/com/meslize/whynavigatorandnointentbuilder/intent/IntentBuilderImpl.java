package com.meslize.whynavigatorandnointentbuilder.intent;

import android.app.Activity;
import android.content.Intent;

import com.meslize.whynavigatorandnointentbuilder.next.MyNextActivity_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class IntentBuilderImpl implements IntentBuilder {
    @RootContext Activity mActivity;

    @Override
    public Intent buildMyNextIntent(String text) {
        Intent intent = new Intent(mActivity, MyNextActivity_.class);
        intent.putExtra(MyNextActivity_.M_TEXT_EXTRA, text);

        return intent;
    }
}
