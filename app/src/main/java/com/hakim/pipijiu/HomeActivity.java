package com.hakim.pipijiu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import timber.log.Timber;

/**
 * Author: Shi Haijun <br/>
 * Email : hakim.shi@qq.com <br/>
 * Date  : 2017/1/6 <br/>
 * Desc  :
 */
public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();

    private static final int[] TAB_NAME = new int[]{
            R.string.tab_home,
            R.string.tab_trade,
            R.string.tab_order,
            R.string.tab_person
    };

    private static final int[] TAB_ICON = new int[]{
            R.drawable.tab_home,
            R.drawable.tab_trade,
            R.drawable.tab_order,
            R.drawable.tab_person
    };

    private static final Class[] FRAGMENTS = new Class[]{
            FragmentHome.class,
            FragmentTrade.class,
            FragmentOrder.class,
            FragmentPerson.class
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTabHost();
    }

    private void initTabHost() {
        final FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        if (tabHost != null) {
            tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

            for (int i = 0, k = TAB_ICON.length; i < k; i++) {
                View tabView = new View(this);
                tabView.setBackgroundResource(TAB_ICON[i]);
                tabHost.addTab(tabHost.newTabSpec(getString(TAB_NAME[i])).setIndicator(tabView), FRAGMENTS[i], null);
            }

            final int tabSize = tabHost.getTabWidget().getTabCount();
            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    Timber.tag(TAG).d("TabChanged , tabId = %s", tabId);
                    for (int i = 0; i < tabSize; i++) {
                        View view = tabHost.getCurrentTabView();
                        view.setSelected(i == tabHost.getCurrentTab());
                    }
                }
            });
        } else {
            throw new NullPointerException("Fail to find FragmentTabHost view");
        }
    }
}
