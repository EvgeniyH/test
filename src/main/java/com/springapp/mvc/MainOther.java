package com.springapp.mvc;

import beans.SingletonBean;

/**
 * Created by Jenya on 07.06.2017.
 */
public class MainOther {

    public static void main(String[] args) {
        SingletonBean singletonBean = new SingletonBean();
        singletonBean.start();
        System.out.println(singletonBean.getUser(0));
        System.out.println(singletonBean.getUser(1));
    }
}
