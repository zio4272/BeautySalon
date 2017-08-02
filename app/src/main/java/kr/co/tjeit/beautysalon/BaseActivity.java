package kr.co.tjeit.beautysalon;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-07-26.
 */

public class BaseActivity extends AppCompatActivity {



    public Context mConText = this;

    public void bindViews() {
        // findViewById => XML, JAVA의 컴포넌트 연결
        // 한곳에 몰아넣고 안읽어봐도 되도록 치워주기


    }

    public  void setupEvents() {
        // onClick , onLongClick, onItemClick 등
        // 이벤트 처리를 몰아넣기 위한 메쏘드

    }

    public void setValues() {
        // TextView, EditText, ImageView 등에
        // 적절한 데이터를 set 해주기 위한 공간
        // nameTxt.setText
    }
}
