package com.lfxfs.tools.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkUtils {
    /**
     * 获取主机名
     * @return
     */
    public static String getHostName(){
        //get the hostName
        String hostName = null;
        try {
            InetAddress addr  = InetAddress.getLocalHost();
            hostName =addr.getHostName().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }
}
