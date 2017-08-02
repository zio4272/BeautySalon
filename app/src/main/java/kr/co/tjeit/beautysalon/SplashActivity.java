package kr.co.tjeit.beautysalon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.tjeit.beautysalon.datas.DesignCase;
import kr.co.tjeit.beautysalon.datas.Designer;
import kr.co.tjeit.beautysalon.datas.User;
import kr.co.tjeit.beautysalon.utils.GeneralUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        addDesigners();
        addUsers();
        addDesignCase();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(mConText, SelectLoginModeActivity.class);
                startActivity(myIntent);
                finish();

            }
        }, 2000);
        // postDelayed => 어떤 할 일을 재료 1, 몇초 후에 (millisecond) 재료 2.
        // 할일을 만드는 방법 new runnable
        // 재료2 만큼의 시간이 지나면 할일을 실행
    }

    private void addDesignCase() {
        GeneralUtil.globalDesignCase.clear();
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 5, GeneralUtil.designers.get(0),GeneralUtil.users.get(0), 10000, "5점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 4, GeneralUtil.designers.get(0),GeneralUtil.users.get(1), 20000, "4점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 3, GeneralUtil.designers.get(0),GeneralUtil.users.get(2), 30000, "3점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 2, GeneralUtil.designers.get(0),GeneralUtil.users.get(3), 40000, "2점 드릴게요"));
        GeneralUtil.globalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 1, GeneralUtil.designers.get(0),GeneralUtil.users.get(4), 50000, "내가 왜 여기서 머리를 했나 자괴감들어.."));

        Designer leekj = GeneralUtil.designers.get(0);

        for (DesignCase dc : GeneralUtil.globalDesignCase) {
            leekj.getPortfolio().add(dc);
        }





    }

    private void addUsers() {

        GeneralUtil.users.clear();
        GeneralUtil.users.add(new User("보영", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://image.fmkorea.com/files/attach/new/20150804/1121272/7745856/202992308/4066ad265f6cb7554bd63e4e81479d81.png"));
        GeneralUtil.users.add(new User("도봉순", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://image.fmkorea.com/files/attach/new/20161112/1121272/49157116/507975988/67f7830d82108d213576950c860a93ef.png"));
        GeneralUtil.users.add(new User("힘쎈여자", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://image.fmkorea.com/files/attach/new/20161112/1121272/49157116/507975988/e2dabe075cbe54b8ca089102045e2699.png"));
        GeneralUtil.users.add(new User("네~쉐프", 0, Calendar.getInstance(),new ArrayList<Designer>(), "http://upload2.inven.co.kr/upload/2016/05/04/bbs/i11215477929.png"));
        GeneralUtil.users.add(new User("박근혜", 0, Calendar.getInstance(),new ArrayList<Designer>(), "http://img.sbs.co.kr/newimg/news/20161213/201004498.png"));
    }

    private void addDesigners() {
        GeneralUtil.designers.clear();
        GeneralUtil.designers.add(new Designer("이가자", 1, "KAJA", 40, 4.5f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("박승철", 0, "PSC", 20, 4.0f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("김정남", 1, "KJN", 30, 3.8f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("이승철", 0, "LSC", 50, 2.5f, new ArrayList<DesignCase>()));
        GeneralUtil.designers.add(new Designer("박준", 0, "PJ", 10, 4.8f, new ArrayList<DesignCase>()));



    }
}
