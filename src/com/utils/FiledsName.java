package com.utils;

import com.Bean.Meeting;
import com.Bean.MemberInfo;

import java.lang.reflect.Field;

public class FiledsName {

    private static  String[] memberName;
    private static  String[] meetName;



    public static String[] getMemberName(){
        if(memberName==null){
            synchronized (MemberInfo.class){
                if(memberName==null){
                    Field[] fields=MemberInfo.class.getDeclaredFields();
                    memberName=new String[fields.length];
                    for (int i = 0; i < memberName.length; i++) {
                        memberName[i]=fields[i].getName();

                    }
                }

            }
        }

        return memberName;
    }



    public static String[] getMeetName(){
        if(meetName==null){
            synchronized (Meeting.class){
                if(meetName==null){
                    Field[] fields=Meeting.class.getDeclaredFields();
                    meetName=new String[fields.length];
                    for (int i = 0; i < meetName.length; i++) {
                        meetName[i]=fields[i].getName();
                    }
                }

            }
        }
        return meetName;
    }
}
