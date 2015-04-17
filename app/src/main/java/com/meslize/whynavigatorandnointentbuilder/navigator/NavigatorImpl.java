package com.meslize.whynavigatorandnointentbuilder.navigator;

import android.app.Activity;
import android.content.Intent;

import com.meslize.whynavigatorandnointentbuilder.next.MyNextActivity_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class NavigatorImpl implements Navigator {

    @RootContext Activity mActivity;

    @Override
    public void finishView() {
        mActivity.finish();
    }

    @Override
    public void startMyNextActivity(String text) {
        Intent intent = new Intent(mActivity, MyNextActivity_.class);
        intent.putExtra(MyNextActivity_.M_TEXT_EXTRA, text);

        mActivity.startActivity(intent);
    }
}
