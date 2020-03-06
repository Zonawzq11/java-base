package com.study.collections.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap();
        /**
         * 源码解析
         *    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
         *    static final float DEFAULT_LOAD_FACTOR = 0.75f;
         *
         */
        getStudentBySex();
    }

    /**
     * 获取学生List By 　性别
     * @return
     */
    public static  Map getStudentBySex() {
        //1.测试数据准备
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            if (i%2 == 0) {
                Student student = new Student();
                student.setSex("0");
                student.setName("wangzhiqiang"+i);
                students.add(student);
            }else {
                Student student = new Student();
                student.setSex("1");
                student.setName("wangzhiqiang"+i);
                students.add(student);
            }
        }
        //2.开始测试
        Map<String, List<Student>> studentsMap = new HashMap<>();
        for (Student student : students) {
            List<Student> studentList = studentsMap.getOrDefault(student.getSex(), new ArrayList<>());
            studentList.add(student);
            studentsMap.put(student.getSex(), studentList);
        }
        return studentsMap;
    }
}
