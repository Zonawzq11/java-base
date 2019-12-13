package com.study.luckylottery;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 选号程序
 * 程序中根据用户要选的红球或者篮球，不要选的篮球或者红球 选出用户想要的出球结果
 * 最近两次是大概率事件，将最近两次的概率事件从排除中去掉
 */
public class SelectNo {
    public static void main(String[] args) {
        int BlueBallCount = 0;
        ArrayList blueArray = new ArrayList<Integer>();
        //2.生成出球序列
        HashMap<String, Object> ballMap = new HashMap<String, Object>();
        for (int i = 0; i < 16; i++) {
            general(ballMap);
            //生成篮球组
            int buleRound = new Random().nextInt(17);
            if (buleRound == 0 ||
            buleRound == 4 ||
            buleRound == 5 ||
            buleRound == 6 ||
            buleRound == 8 ||
            buleRound == 10 ||
            buleRound == 13 ||
            buleRound == 14 ||
            buleRound == 15){
                 continue;
            }
            if (blueArray.contains(buleRound)){
               continue;
            }
            ballMap.put("blueBall",buleRound);
            blueArray.add(buleRound);
            System.out.println(JSONObject.toJSONString(ballMap));
            ++ BlueBallCount;
            if (BlueBallCount >= 5){
                return;
            }
        }

    }

    private static void general(HashMap<String, Object> ballMap) {
        int RedBallCount = 0;
        ArrayList<Integer> redArrayList = new ArrayList<Integer>();
        for (int j = 0; j < 32 ; j++) {
            int redRound = new Random().nextInt(34);
            if (redRound == 0
                    ||redRound == 1
                    || redRound ==5
                    ||redRound == 7
                    ||redRound == 10
                    ||redRound == 18
                    ||redRound == 20
                    ||redRound == 21
                    ||redRound == 23
                    ||redRound == 25
                    ||redRound == 27
                    ||redRound == 28){
                continue;
            }
            if (redArrayList.contains(redRound)){
                continue;
            }
            redArrayList.add(redRound);
            ++ RedBallCount ;
            if (RedBallCount >= 6){
                break;
            }
        }
        redArrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o1.compareTo(o2);
            }
       });
        ballMap.put("redBallArray",redArrayList);
        return;
    }
}
