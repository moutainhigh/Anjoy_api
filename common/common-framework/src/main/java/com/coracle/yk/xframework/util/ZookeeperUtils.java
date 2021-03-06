package com.coracle.yk.xframework.util;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ZookeeperUtils implements Watcher {

    private static ZookeeperUtils INSTANCE = new ZookeeperUtils();

    private ZooKeeper zk = null;
    private String connectionUrl = null;
    private int sessionTimeout = 3000;
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static final String PATH = "/config/properties/";

    /*private static final String APP_ID_PATH = "/config/properties/app.id";
    private static final String APP_SECRET_PATH = "/config/properties/app.secret";

    private static final String YTXIM_APP_ID = "/config/properties/app.AppId";
    private static final String YTXIM_APP_SECRET = "/config/properties/app.appToken";
    private static final String YTXIM_AGENTFROM = "/config/properties/app.agentFrom";

    private static final String NETEASE_APP_KEY_PATH = "/config/properties/netease.app.key";
    private static final String NETEASE_APP_SECRET_PATH = "/config/properties/netease.app.secret";*/

    private String zookeeperValue = null;

    private ZookeeperUtils() {

    }

    public static ZookeeperUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZookeeperUtils();
        }
        return INSTANCE;
    }

    /**
     * 创建ZK连接
     */
    private void createConnection(String zooConnectString) {
        releaseConnection();
        try {
            Properties pps = new Properties();
            //pps.load(ZookeeperUtils.class.getClassLoader().getResourceAsStream(("config/application-xweb.properties")));
            pps.load(ZookeeperUtils.class.getClassLoader().getResourceAsStream(("config/application-xframework.properties")));
            //connectionUrl = pps.getProperty("zoo.connectString");  //因为云端和165用同一个xframework，故zookeeper要传进来
            connectionUrl = zooConnectString;
            sessionTimeout = Integer.parseInt(pps.getProperty("zoo.baseSleepTimems"));
            zk = new ZooKeeper(connectionUrl, sessionTimeout, this);
            System.out.println("createConnection，正常===");
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            System.out.println("连接创建失败，发生 InterruptedException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("连接创建失败，发生 IOException");
            e.printStackTrace();
        }
    }

    /**
     * 关闭ZK连接
     */
    private void releaseConnection() {
        if (zk != null) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取指定节点数据
     *
     * @param path
     * @return
     */
    private String readData(String path, String zooConnectString) {
        System.out.println("path：" + path);
        byte[] bytes = null;
        try {
            createConnection(zooConnectString);
            bytes = zk.getData(path, false, null);
            System.out.println("获取数据成功，path：" + path);
        } catch (KeeperException e) {
            System.out.println("读取数据失败，发生KeeperException，path: " + path);
            e.printStackTrace();
            return "";
        } catch (InterruptedException e) {
            System.out.println("读取数据失败，发生 InterruptedException，path: " + path);
            e.printStackTrace();
            return "";
        } finally {
            releaseConnection();
        }

        return new String(bytes);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("收到事件通知：" + event.getState() + "\n");
        if (KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }

    }

    public String getZookeeperValue(String key, String zooConnectString) {
        System.out.println("PATH+key==" + PATH + key);
        System.out.println("zooConnectString==" + zooConnectString);
        zookeeperValue = ZookeeperUtils.getInstance().readData(PATH + key, zooConnectString);

        System.out.println("zookeeperValue:" + zookeeperValue);
        return zookeeperValue;
    }

	/*public String getAppSecret() {
		if (appSecret == null) {
			appSecret = ZookeeperUtils.getInstance().readData(APP_SECRET_PATH);
		}
		System.out.println("appSecret:"+appSecret);
		return appSecret;
	}

    public String getYtxAppId() {
        if (ytxAppId == null) {
            ytxAppId = ZookeeperUtils.getInstance().readData(YTXIM_APP_ID);
        }
        System.out.println("ytxAppId:"+ytxAppId);
        return ytxAppId;
    }

    public String getYtxAppToken() {
        if (ytxAppToken == null) {
            ytxAppToken = ZookeeperUtils.getInstance().readData(YTXIM_APP_SECRET);
        }
        System.out.println("ytxAppToken:"+ytxAppToken);
        return ytxAppToken;
    }

    public String getYtxAgentFrom() {
        if (ytxAgentFrom == null) {
            ytxAgentFrom = ZookeeperUtils.getInstance().readData(YTXIM_AGENTFROM);
        }
        System.out.println("ytxAgentFrom:"+ytxAgentFrom);
        return ytxAgentFrom;
    }

    public String getNeteaseAppKey() {
		if (neteaseAppKey == null) {
			neteaseAppKey = ZookeeperUtils.getInstance().readData(NETEASE_APP_KEY_PATH);
		}
		System.out.println("netease.app.key:"+neteaseAppKey);
		return neteaseAppKey;
	}

	public String getNeteaseAppSecret() {
		if (neteaseAppSecret == null) {
			neteaseAppSecret = ZookeeperUtils.getInstance().readData(NETEASE_APP_SECRET_PATH);
		}
		System.out.println("netease.app.secret:"+neteaseAppSecret);
		return neteaseAppSecret;
	}*/

}
