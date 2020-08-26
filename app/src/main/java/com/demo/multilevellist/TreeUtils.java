package com.demo.multilevellist;

import android.util.Log;


import com.demo.multilevellist.bean.TreePoint;

import java.util.HashMap;


public class TreeUtils {
    //第一级别为0
    public static int getLevel(TreePoint treePoint, HashMap<String, TreePoint> map) {
        if ("0".equals(treePoint.getPARENTID())) {
            return 0;
        } else {
            return 1 + getLevel(getTreePoint(treePoint.getPARENTID(), map), map);
        }
    }


    public static TreePoint getTreePoint(String ID, HashMap<String, TreePoint> map) {
        if (map.containsKey(ID)) {
            return map.get(ID);
        }
        Log.e("xlc", "ID:" + ID);
        return null;
    }
}
