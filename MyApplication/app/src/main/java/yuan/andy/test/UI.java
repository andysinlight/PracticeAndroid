package yuan.andy.test;


import android.app.ExpandableListActivity;
import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import yuan.andy.test.ui.*;



public class UI extends ExpandableListActivity {
    String [] groupname ;
    String [][] items ;
    Intent intent ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent();
        groupname = getResources().getStringArray(R.array.chapter2);
        String [] item1 = getResources().getStringArray(R.array.child2_1);
        String [] item2 = getResources().getStringArray(R.array.child2_2);
        String [] item3 = getResources().getStringArray(R.array.child2_3);
        String [] item4 = getResources().getStringArray(R.array.child2_4);
        String [] item5 = getResources().getStringArray(R.array.child2_5);
        String [] item6 = getResources().getStringArray(R.array.child2_6);
        String [] item7 = getResources().getStringArray(R.array.child2_7);
        String [] item8 = getResources().getStringArray(R.array.child2_8);
        String [] item9 = getResources().getStringArray(R.array.child2_9);

        items =new String[][] {
                item1,item2,   item3,item4,   item5,item6,   item7,item8,   item9
        };

        BaseExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return groupname.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return items[groupPosition].length;

            }

            @Override
            public Object getGroup(int groupPosition) {
                return groupname[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return items[groupPosition][childPosition];
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
                LinearLayout root =(LinearLayout)(getLayoutInflater().inflate(R.layout.simplelist,null));
                TextView view = (TextView)root.findViewById(R.id.list_textview);
                view.setText(getGroup(groupPosition).toString());
                view.setSelected(true);
                return  root ;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                LinearLayout root =(LinearLayout)(getLayoutInflater().inflate(R.layout.simplelist,null));
                TextView view = (TextView)root.findViewById(R.id.list_textview);
                view.setText(getChild(groupPosition, childPosition).toString());
                view.setSelected(true);
                view.setBackgroundColor(getResources().getColor(R.color.myBlue));
                return  root ;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        setListAdapter(adapter);



        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(UI.this,groupPosition+"  "+childPosition,Toast.LENGTH_SHORT).show();
                switch (groupPosition){
                    case 0:
                        switch (childPosition){
                            case 0:
                                intent.setAction("andy.launchcodeview");
                                startActivity(intent);
                                break;
                            case 1:
                                intent.setAction("andy.launchcustomview");
                                startActivity(intent);
                                break;
                            case 2:
                                intent.setAction("andy.launchcumixview");
                                startActivity(intent);
                                break;
                        }
                        break;

                    case 1:
                        switch (childPosition){
                            case 0:
                                intent.setAction("andy.launchabsolutelayout");
                                startActivity(intent);
                                        break;

                            case 1:
                                intent.setAction("andy.launchframe");
                                startActivity(intent);
                                break;

                            case 2:
                                intent.setAction("andy.gridlayout");
                                startActivity(intent);
                                break;

                            case 3:
                                intent.setAction("andy.linearlayout");
                                startActivity(intent);
                                break;

                            case 4:
                                intent.setAction("andy.relativelayout");
                                startActivity(intent);
                                break;

                            case 5:
                                intent.setAction("andy.tablelayout");
                                startActivity(intent);
                                break;
                        }
                        break;

                    //第三节
                    case 2:
                        switch (childPosition){
                            case 0 :
                                intent.setAction("andy.buttontest");
                                startActivity(intent);
                                break ;
                            case 1 :
                                intent.setAction("andy.checkbutton");
                                startActivity(intent);
                                break ;

                            case 2 :
                                intent.setAction("andy.chronometer");
                                startActivity(intent);
                                break ;

                            case 3 :
                                intent.setAction("andy.clocktest");
                                startActivity(intent);
                                break ;
                            case 4 :
                                intent.setAction("andy.input");
                                startActivity(intent);
                                break ;

                            case 5 :
                                intent.setAction("andy.ninepath");
                                startActivity(intent);
                                break ;

                            case 6 :
                                intent.setAction("andy.textview");
                                startActivity(intent);
                                break ;
                            case 8 :
                                intent.setAction("andy.ToggleButtonTest");
                                startActivity(intent);
                                break ;
                        }
                        break;

//                    第四节
                    case 3:
                        switch (childPosition){
                            case 0 :
                                intent.setAction("andy.ImageButton");
                                startActivity(intent);
                                break;

                            case 1 :
                                intent.setAction("andy.ImageViewTest");
                                startActivity(intent);
                                break;

                            case 2 :
                                intent.setAction("andy.QuickContactBadgeTest");
                                startActivity(intent);
                                break;
                        }
                        break ;

//                 第五节
                    case 4:
                        switch (childPosition){
                            case 0 :
                                intent.setAction("andy.AdapterViewFlipperTest");
                                startActivity(intent);
                                break;

                            case 1 :
                                intent.setAction("andy.ArrayAdapterTest");
                                startActivity(intent);
                                break;

                            case 2 :
                                intent.setAction("andy.AutoCompleteTextViewTest");
                                startActivity(intent);
                                break;

                            case 3 :
                                intent.setAction("andy.BaseAdapterTest");
                                startActivity(intent);
                                break;
                            case 4 :
                                intent.setAction("andy.ExpandableListViewTest");
                                startActivity(intent);
                                break;

                            case 5 :
                                intent.setAction("andy.GallaryTest");
                                startActivity(intent);
                                break;

                            case 6 :
                                intent.setAction("andy.GridViewTest");
                                startActivity(intent);
                                break;
                        }
                        break;
                }
                return false;
            }
        });
    }

}
