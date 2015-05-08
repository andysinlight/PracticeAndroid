package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import yuan.andy.test.R;

public class ExpandableListViewTest extends Activity {
    ExpandableListView listView;

    int[] logos = new int[]
            {
                    R.drawable.ap,
                    R.drawable.az,
                    R.drawable.at
            };
    private String[] armTypes = new String[]
            { "神族兵种", "虫族兵种", "人族兵种"};
    private String[][] arms = new String[][]
            {
                    { "狂战士", "龙骑士", "黑暗圣堂", "电兵" },
                    { "小狗", "刺蛇", "飞龙", "自爆飞机" },
                    { "机枪兵", "护士MM" , "幽灵" }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view_test);
        listView=(ExpandableListView)findViewById(R.id.expandList);
        BaseExpandableListAdapter adapter = new BaseExpandableListAdapter() {


            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms.length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);
                ImageView imageView = new ImageView(ExpandableListViewTest.this);
                TextView view = getTextView();
                imageView.setImageResource(logos[groupPosition]);
                view.setText(getGroup(groupPosition).toString());
                ll.addView(imageView);
                ll.addView(view);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                     View convertView, ViewGroup parent) {
                TextView view = getTextView();
                view.setText(getChild(groupPosition,childPosition).toString());
                return view;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        listView.setAdapter(adapter);
    }
    private TextView getTextView(){
        TextView view = new TextView(this);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        view.setTextSize(20);
        return view ;

    }


}
