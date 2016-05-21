import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Thread;
import java.net.*;
import java.io.*;
class crawlerThread extends Thread {
    private static BlockingQueue<String> queue= new LinkedBlockingQueue<String>();
    private static Map<String, Boolean> map = new HashMap<String, Boolean>();
    private static List<String> result = new ArrayList<>();
    public static void setFirstUrl(String url) {
        try {
            queue.put(url);
        } catch(InterruptedException e) {
            
        }
    }
    public static List<String> getResult() {
        return result;
    }
    @Override
    public void run() {
        while(true) {
            String url = "";
            try {
                url = queue.take();
            } catch(Exception e) {
                break;
            }
            if (!map.containsKey(url) && url.contains("wikipedia")) {
                map.put(url, true);
                result.add(url);
                List<String> prepareUrl = HtmlHelper.parseUrls(url);
                for (String rawurl : prepareUrl) {
                    try {
                        queue.put(rawurl);
                    } catch (InterruptedException e) {
                        
                    }
                }
            }
            
        }
    }
}
public class Solution {
    /**
     * @param url a url of root page
     * @return all urls
     */
    public List<String> crawler(String url) {
        // Write your code here
        crawlerThread.setFirstUrl(url);
        crawlerThread[] thread_pools = new crawlerThread[7];
        for (int i = 0; i < 7; i++) {
            thread_pools[i] = new crawlerThread();
            thread_pools[i].start();
        }
        try {
            Thread.sleep(900);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 7; i++) {
            thread_pools[i].stop();
        }
        List<String> result = crawlerThread.getResult();
        return result;
    }
    
}
