package tw.chikuo.idoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomActivity extends AppCompatActivity {

    private GridView gridView;
    private SimpleAdapter adapter;

    private List<Map<String, Object>> items ;

    private int[] image = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    private String[] imgText = {
            "小便燒痛灼熱", "急尿(忍不住尿)", "夜間多次小便", "頻尿", "尿色改變", "血尿", "尿道分泌物"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);

            actionBar.setTitle("症狀查詢-泌尿系統");
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        items = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < image.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
//            item.put("image", image[i]);
            item.put("text", imgText[i]);
            items.add(item);
        }

        adapter = new SimpleAdapter(SymptomActivity.this,
                items, R.layout.grid_symptom_item, new String[]{"image", "text"},
                new int[]{R.id.image, R.id.text});

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setNumColumns(2);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SymptomActivity.this, DoctorListActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
