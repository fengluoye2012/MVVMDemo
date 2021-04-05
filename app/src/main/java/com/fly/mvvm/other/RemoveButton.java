package com.fly.mvvm.other;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.HashMap;

//删除所有frameLayout中直接、间接的button
class RemoveButton {

    private HashMap<ViewGroup, Integer> hashMap = new HashMap<>();

    //这种做法效率不高，会存在同一个FrameLayout 查询多次的情况；可以考虑使用HashMap将ViewGroup记录，是否查找过，避免查找多次；
    public void removeButton(ViewGroup root) {
        if (root == null) {
            return;
        }

        //如果根View是FrameLayout；
        if (root instanceof FrameLayout) {
            remoteButtonFromFrameLayout(root);
            return;
        }

        //从根View 找到所有的FrameLayout；
        int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = root.getChildAt(i);

            if (!(child instanceof ViewGroup)) {
                continue;
            }

            //同一个ViewGroup只遍历一次即可
            Integer integer = hashMap.get(child);
            if (integer != null) {
                continue;
            }
            hashMap.put((ViewGroup) child, 1);

            if (child instanceof FrameLayout) {
                remoteButtonFromFrameLayout((FrameLayout) child);
            }
        }
    }


    /**
     * 删除FrameLayout中直接、间接的Button；
     *
     * @param frameLayout 本身是FrameLayout 或者其父容器是FrameLayout
     */
    private void remoteButtonFromFrameLayout(ViewGroup frameLayout) {
        if (frameLayout == null) {
            return;
        }

        int count = frameLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = frameLayout.getChildAt(i);


            if (child instanceof ViewGroup) {
                //同一个ViewGroup只遍历一次即可
                Integer integer = hashMap.get(child);
                if (integer != null) {
                    continue;
                }
                remoteButtonFromFrameLayout(frameLayout);
            }

            if (!(child instanceof Button)) {
                continue;
            }

            frameLayout.removeView(child);
        }
    }

}
