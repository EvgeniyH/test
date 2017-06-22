package beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jenya on 07.06.2017.
 */
@Singleton
@Startup
public class SingletonBean {
    private Map<Integer,String> myCache;

    @PostConstruct
    public void start() {
        myCache = new HashMap<Integer, String>();
    }

    public void addUser(Integer id, String name) {
        myCache.put(id, name);
    }

    public String getUser(Integer id) {
        return myCache.get(id);
    }
}
