package kr.co.tjeit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.function.LongToIntFunction;

public class SelectLoginModeActivity extends BaseActivity {

    public static SelectLoginModeActivity activity;
    // 어느 클래스나 접근 가능
    // static => 객체화 하지 않아도 접근 가능하게
    // => 자료형 자체한테 접근 허가 하려고.
    // 자료형 : SelectLoginModeActivity.
    // 변수명 : activity

    private TextView workerLoginBtn;
    private android.widget.Button userLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_mode);
        activity = this;
        bindViews();
        setupEvents();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // userLoginBtn 이 눌리면 실행 될 일
                // LoginActivity로 넘겨주기
                // Intent 활용 -> SplashActivity 사용
                Intent myIntent = new Intent(mConText, LoginActivity.class);
                // Intent를 만들어서 출발점과 목적지를 설정한다.
                // 목적지를 적을때는 반드시 액티비티이름.class

                myIntent.putExtra("workerMode", false);
                // 직원모드가 아님을 알려줌.

                startActivity(myIntent);
                // 설정된 목적지로 출발~
            }
        });  // 클릭시 할일 설정의 종료

        workerLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myItent = new Intent(mConText, LoginActivity.class);
                myItent.putExtra("workerMode", true);
                startActivity(myItent);
            }
        });

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.workerLoginBtn = (Button) findViewById(R.id.workerLoginBtn);
        this.userLoginBtn = (Button) findViewById(R.id.userLoginBtn);
    }
}
