package kr.co.tjeit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {

    boolean isWorkerMode = false;
    private TextView modeTxt;
    private android.widget.Button loginBtn;
    private android.widget.EditText idEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        bindViews();

        isWorkerMode = getIntent().getBooleanExtra("workerMode", false);
        Log.d("isWorkerMode", isWorkerMode + "");
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        // loginBtn 눌리면
        // MainActivity로 이동 => LoginActivity 종료

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;

                if (isWorkerMode) {
                    String inputId = idEdt.getText().toString();

                    if(inputId.equals("admin")) {
                        myIntent = new Intent(mConText, AdminMainActivity.class);
                    }
                    else {
                        myIntent = new Intent(mConText, WorkerMainActivity.class);
                    }

                }
                else {
                    myIntent = new Intent(mConText, MainActivity.class);
                }


                startActivity(myIntent);
                finish();
                SelectLoginModeActivity.activity.finish();
                // 로그인모드 선택화면도 종료
            }
        });

    }

    @Override
    public void setValues() {
        super.setValues();

        if (isWorkerMode) {
            // 직원로그인 버튼을 눌러서 들어왔다면
            modeTxt.setVisibility(View.VISIBLE);
            // 직원모드라고 적힌 텍스트뷰를 표시해라
            // setVisibility -> 표시 모드 설정 메쏘드
            // View.VISIBLE -> 표시
        }
        else {
            modeTxt.setVisibility(View.GONE);
            // 사라지게 하기
        }

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);


    }
}
