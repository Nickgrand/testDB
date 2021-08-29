import com.qyf.pojo.User;
import com.qyf.pojo.dao.userDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        //把beans.xml的类加载到容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        //从容器获取目标对象
        userDao dao = (userDao) applicationContext.getBean("userDao");

        String selectSql = "select * from testtable";
        List<User> userList = dao.query(selectSql, null);
        List<Integer> ids = new ArrayList<>();
        List<String> names = new ArrayList<>();
//        for (User user : userList) {
//            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getAge() + '\t' + user.getCreateTime() + "\t" + user.getDeleted());
//        }
        for(User user : userList) {
            ids.add(user.getId());
            String name = user.getName();
            if (!name.equals("")) {
                StringBuilder stars = new StringBuilder();
                int len = name.length();
                for (int i = 0; i < len - 1; i++) {
                    stars.append("*");
                }
                String newName = name.charAt(0) + stars.toString();
                names.add(newName);
            } else {
                names.add(name);
            }
            if (user.getName().equals("")) System.out.println("HAHA");
        }

        System.out.println(ids);
        System.out.println(names);

//        String insertSql = "insert into testtable(id, name, age, createTime, deleted) values(?,?,?,?,?)";
        String updateSql = "update testtable set name = ?, createTime = ? where id = ?";
        for (int i = 0; i < ids.size(); i++) {
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Object[] param = {names.get(i), currentTime, ids.get(i)};
            dao.update(updateSql, param);
        }
//        Object[] param = {"7", "", "62", currentTime, "1"};
//        dao.update(insertSql, param);

        List<User> userList1 = dao.query(selectSql, null);
        for (User user : userList1) {
            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getAge() + '\t' + user.getCreateTime() + "\t" + user.getDeleted());
        }
    }
}