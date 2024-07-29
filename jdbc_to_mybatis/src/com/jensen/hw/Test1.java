package com.jensen.hw;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();


        ClassLoader classLoader = ArrayList.class.getClassLoader();

        Class<?>[] interfaces = ArrayList.class.getInterfaces();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnResult = method.invoke(list, args);

                if("remove".equals(method.getName())){
                    //迭代器
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()){
                        String str = it.next();
                        if(args[0].equals(str)) {
                            it.remove();
                        }
                    }
                }

                return returnResult;
            }
        };

        List proxyList = (List)Proxy.newProxyInstance(classLoader, interfaces, handler);

        proxyList.add("abc");
        proxyList.add("cba");
        proxyList.add("abc");
        proxyList.add("abc");

        proxyList.remove("abc");

        System.out.println(list);
    }
}
