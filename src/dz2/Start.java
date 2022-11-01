package dz2;


import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Start {
    public static final String USER_AGENT = "<Mozilla/5.0 (Macintosh; Intel Mac OS X 13_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36>";

    public void print(int n, String href,String parent,int li,int glub) throws IOException, InterruptedException {
        if(glub==3)
            return;

        Document doc = Jsoup.connect(href).userAgent(USER_AGENT).timeout(0).get();
        Elements test = doc.getElementsByClass("_38ce9a85 link db ph4 fw6");
        String adress =test.get(2).absUrl("href");
        doc=Jsoup.connect(adress).get();

        Element body = doc.body();
        Element bodymain = body.getElementById("main");
        Element sec = bodymain.getElementById("tabpanel-dependencies");
        Thread.sleep((long) ((Math.random() * ((2000 - 500) + 1)) + 500));
        ArrayList mas = new ArrayList(sec.child(1).children().size());
        int num=0;


        for (int i=li;i<sec.child(1).children().size();i++){
            /*do {
                num = (int) ((Math.random() * (((sec.child(1).children().size()-1) - 0) + 1)) + 0);
            }while (mas.contains(num));
            mas.add(num);*/
            Element e=sec.child(1).child(i);
            for(int j=0;j<n;j++){
                System.out.print("    ");

            }
            System.out.print(parent);
            System.out.print("  --->  ");
            System.out.println(e.child(0).text());
            Thread.sleep((long) ((Math.random() * ((1000 - 500) + 1)) + 500));
            print(n+1,e.child(0).absUrl("href"),e.child(0).text(),0,glub+1);


        }
        return;

    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Start start= new Start();
        start.print(0,"https://www.npmjs.com/package/npm","npm",60,0);
        /*Document doc = Jsoup.connect("https://www.npmjs.com/package/npm").get();
        Elements test = doc.getElementsByClass("_38ce9a85 link db ph4 fw6");
        String adress =test.get(2).absUrl("href");
        doc=Jsoup.connect(adress).get();

        Element body = doc.body();
        Element bodymain = body.getElementById("main");
        Element sec1 = bodymain.getElementById("tabpanel-dependencies");

        for (Element e : sec1.child(1).children()){
            System.out.println(e.child(0).absUrl("href"));

        }
*/


    }



        //System.out.println(sec.toString());
        //System.out.println(sec.child(1).toString());



}
