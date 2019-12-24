package in.ac.sharda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext;

    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;

        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.WHAT_IS_JAVA);
        titleArrayList.add(Constants.HISTORY_OF_JAVA);
        titleArrayList.add(Constants.FEATURE_OF_JAVA);
        titleArrayList.add(Constants.C_vs_JAVA);
        titleArrayList.add(Constants.HELLO_JAVA_PROGRAM);
        titleArrayList.add(Constants.PROGRAM_INTERNAL);
        titleArrayList.add(Constants.HOW_TO_SET_PATH);
        titleArrayList.add(Constants.JDK_JRE_JVM);
        titleArrayList.add(Constants.INTERNAL_DETAIL_OF_JVM);
        titleArrayList.add(Constants.JAVA_VARIABLE);
        titleArrayList.add(Constants.JAVA_DATATYPE);
        titleArrayList.add(Constants.UNICODE_SYSTEMS);
        titleArrayList.add(Constants.OPERATIONS);


        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemclick(View v, int position) {

                Intent desIntent = new Intent(mContext, DescriptionActivity.class);
                desIntent.putExtra("titles", titleArrayList.get(position));
                startActivity(desIntent);

                Toast.makeText(mContext, "Clicked "+ titleArrayList.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        mRecyclerView.setAdapter(adapter);
    }
}
