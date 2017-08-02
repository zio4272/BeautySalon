package kr.co.tjeit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

import kr.co.tjeit.beautysalon.adapters.DesignerAdapter;
import kr.co.tjeit.beautysalon.datas.DesignCase;
import kr.co.tjeit.beautysalon.datas.Designer;
import kr.co.tjeit.beautysalon.datas.Person;
import kr.co.tjeit.beautysalon.utils.GeneralUtil;

public class MainActivity extends BaseActivity {


    private android.widget.ListView designerListView;

    private DesignerAdapter designerAdapter;

    // 일반 사용자가 로그인 했을때 나타나는 화면

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setValues();
        setupEvents();
    }


    @Override
    public void setupEvents() {
        super.setupEvents();

        designerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Designer tempDesigner = GeneralUtil.designers.get(position);

//                Toast.makeText(mConText, tempDesigner.getName(), Toast.LENGTH_SHORT).show();
                // 각 줄을 클릭하면, 클릭된 줄의 디자이너의 본명 -> 토스트로 출력

                // 아이템을 누르면 디자이너 상세화면으로 넘겨주기
                Intent myIntent = new Intent(mConText, ViewDesignerDetailActivity.class);
                myIntent.putExtra("designer", tempDesigner); // Intent로 넘겨줄때 소포 하나 보낸다.... designer라는 꼬리표에 tempDesigner를 넣어보낸다~
                // 디자이너 데이터 첨부해서 넘기기
                startActivity(myIntent);


                // 받는 화면에서 로그로 디자이너의 이름과 닉네임 찍어보기


            }
        });

    }

    @Override
    public void setValues() {
        super.setValues();

        designerAdapter = new DesignerAdapter(mConText, GeneralUtil.designers);
        designerListView.setAdapter(designerAdapter);

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.designerListView = (ListView) findViewById(R.id.designerListView);

    }


}
