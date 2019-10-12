package com.changmi.tagflowlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.changmi.tagflowlayout.flowlayout.FlowLayout;
import com.changmi.tagflowlayout.flowlayout.TagAdapter;
import com.changmi.tagflowlayout.flowlayout.TagFlowLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TagFlowLayout myViewGroup;
    private TagAdapter<String> adapter;
    private ArrayList mList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewGroup = (TagFlowLayout) findViewById(R.id.my_view);
        final ArrayList<String> mList = new ArrayList();
        mList.add("Android");
        mList.add("FlowLayout");
        mList.add("IOS");
        mList.add("WINDOWS");
        mList.add("AppCompatActivity");
        mList.add("TagFlowLayout");
        mList.add("MainActivity");
        mList.add("Bundle");
        mList.add("savedInstanceState");
        mList.add("onCreate");
        mList.add("dddddddddddddddddddddddddddddddddddddddfffffffffffffffffffffffffffffff");

        mList2 = new ArrayList();
        mList2.add("Android2");
        mList2.add("FlowLayout2");
        mList2.add("IOS2");
        mList2.add("WINDOWS2");
        mList2.add("AppCompatActivity2");
        mList2.add("TagFlowLayout2");
        mList2.add("MainActivity2");
        mList2.add("Bundle2");
        mList2.add("savedInstanceState2");
        mList2.add("onCreate2");
        mList2.add("dddddddddddddddddddddddddddddddddddddddfffffffffffffffffffffffffffffff");

        adapter = new TagAdapter<String>(mList) {
            @Override
            public View getView(FlowLayout parent, final int position, String msg) {
                FrameLayout mTag = (FrameLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.item_tv,
                        myViewGroup, false);
                TextView textView = (TextView) mTag.findViewById(R.id.tv);
                ImageView imageView = (ImageView) mTag.findViewById(R.id.img);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mList.remove(position);
                        adapter.refreshTags(mList);
//                        myViewGroup.setMaxLine(100);
                    }
                });
                textView.setText(msg);
                return mTag;
            }
        };

        myViewGroup.setAdapter(adapter);
//
//        myViewGroup.setmItemClickListener(new TagFlowLayout.onTagItemClickListener() {
//            @Override
//            public void onItemClick(int pos, Object data) {
//                Toast.makeText(MainActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
//            }
//        });
//        myViewGroup.setmLongClickListener(new TagFlowLayout.onTagItemLongClickListener() {
//            @Override
//            public void onLongItemClick(int pos, Object data) {
//                Toast.makeText(MainActivity.this, "Longclick" + pos, Toast.LENGTH_SHORT).show();
//            }
//        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList a = new ArrayList(mList2);
                adapter.refreshTags(a);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addTagsItem("AAAAA");
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeTagsItem(4);
            }
        });
    }


}
