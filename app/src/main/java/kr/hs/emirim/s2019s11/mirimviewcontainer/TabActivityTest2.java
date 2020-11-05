package kr.hs.emirim.s2019s11.mirimviewcontainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabActivityTest2 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test2);
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabSpecCat.setContent(R.id.linear_cat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecPuppy = tabHost.newTabSpec("PUPPY").setIndicator("강아지");
        tabSpecPuppy.setContent(R.id.linear_puppy);
        tabHost.addTab(tabSpecPuppy);

        TabHost.TabSpec tabSpecRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tabSpecRabbit.setContent(R.id.linear_rabbit);
        tabHost.addTab(tabSpecRabbit);

        TabHost.TabSpec tabSpecWinwin = tabHost.newTabSpec("WINWIN").setIndicator("윈윈");
        tabSpecWinwin.setContent(R.id.linear_winwin);
        tabHost.addTab(tabSpecWinwin);

        tabHost.setCurrentTab(0); // 첫번째 tab이 보여짐
    }
}