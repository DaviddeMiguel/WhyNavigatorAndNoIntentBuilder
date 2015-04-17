package com.meslize.whynavigatorandnointentbuilder.next;

import android.test.AndroidTestCase;
import android.widget.TextView;

import com.meslize.whynavigatorandnointentbuilder.navigator.Navigator;
import com.meslize.whynavigatorandnointentbuilder.util.DexmakerDexcache;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class MyNextActivityTest extends AndroidTestCase {

    private static final String TEXT = "text";
    private MyNextActivity mActivity;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        DexmakerDexcache dexmakerDexcache = new DexmakerDexcache();
        dexmakerDexcache.prepareEnvironment(getContext());

        mActivity = new MyNextActivity();
        mActivity.mNavigator = mock(Navigator.class);
        mActivity.mTextView = mock(TextView.class);
        mActivity.mText = TEXT;
    }

    public void testAfterViews() {
        mActivity.afterViews();

        verify(mActivity.mTextView).setText(eq(TEXT), any(TextView.BufferType.class));
    }

    public void testClickBackInvokesNavigatorFinishView() {
        mActivity.clickBack();

        verify(mActivity.mNavigator).finishView();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mActivity.mNavigator, mActivity.mTextView);
    }
}
