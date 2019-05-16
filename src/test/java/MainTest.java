import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

    public static void main(String[] args) throws Exception {
//        System.out.println("1,2".split(",").length);

        //2019-05-11T12:15
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        Date date = df.parse("2019-05-11 12:15");
//        System.out.println(date);

//        String[] split = "1|2".split("\\|");
//        System.out.println(Arrays.toString(split));


//        Pattern p = Pattern.compile("^g\\[(.+?)\\]$");
//        Matcher m = p.matcher("g[g1]");
//        if (m.find()) {
//            System.out.println(m.group(1));
//        }


//        String item = "ggg|g2|g3|$";
//        System.out.println(item.endsWith("|&"));
//        System.out.println(Arrays.toString(item.substring(0, item.length() - 2).split("\\|")));

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse("2019-05-06 00:00:00");
////        Date date_1 = sdf.parse("2019-05-05 00:00:00");
////        System.out.println(date.getTime()-date_1.getTime());
//        System.out.println(sdf.format(new Date(date.getTime()-(1000*60*60*24*5))));


        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<7; i++) {
            map.put(i+"",i);
        }

        HashMap<String, Integer> clone = (HashMap<String, Integer>) ((HashMap<String, Integer>) map).clone();
        System.out.println(1);
        map.put("1",111);
        clone.put("7",777);
        System.out.println(1);

    }
}
