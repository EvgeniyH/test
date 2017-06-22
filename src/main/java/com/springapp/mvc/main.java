package com.springapp.mvc;

import beans.SingletonBean;

/**
 * Created by Jenya on 07.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        SingletonBean singletonBean = new SingletonBean();
        singletonBean.start();
        singletonBean.addUser(0,"123");
        System.out.println(singletonBean.getUser(0));
        singletonBean.addUser(1,"1234");
        System.out.println(singletonBean.getUser(1));
    }

}
