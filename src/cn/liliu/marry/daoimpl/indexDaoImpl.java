package cn.liliu.marry.daoimpl;

import cn.liliu.marry.dao.indexDao;
import cn.liliu.marry.entity.User;
import cn.liliu.marry.web.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class indexDaoImpl implements indexDao {
    @Override
    public boolean insertUserInfo(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.connectDB();
            ps = conn.prepareStatement("insert into [dbo].[user] values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, user.mime_name);
            if (user.mime_year != null) {
                ps.setInt(2, Integer.parseInt(user.mime_year));
            } else {
                ps.setInt(2, 0);
            }
            ps.setString(3, "");//mime_height
            ps.setString(4, user.mime_area);
            ps.setString(5, user.mime_sex);
            ps.setString(6, user.mime_wx_num);
            ps.setString(7, user.mime_interest);
            ps.setString(8, "");//mime_phone
            ps.setString(9, "");//your_name
            ps.setString(10, user.your_year);
            ps.setString(11, "");//your_height
            ps.setString(12, user.your_area);//your_area
            ps.setString(13, "");//your_sex
            ps.setString(14, "");//your_wx_num
            ps.setString(15, user.your_interest);
            ps.setString(16, "");//your_phone
            ps.setString(17, user.group_id);
            //执行更新
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource(conn, ps, null);
        }
        return false;
    }

    @Override
    public List<User> findUserInfo(User user) {
        List<User> userList;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sex = null;
        try {
            conn = DBUtil.connectDB();
            if (user != null) {
                if (user.getMime_sex().equals("男")) {
                    sex = "女";
                } else if (user.getMime_sex().equals("女")) {
                    sex = "男";
                }
                ps = conn.prepareStatement("  select * from [dbo].[user] where group_id=? and mime_year >=? and mime_year<=? and mime_area like ? and mime_sex=?");
                int startYear = 0;
                int endYear = 100;
                ps.setString(1, user.group_id);
                System.out.println("your_year:"+user.your_year);
                if (user.your_year != null && !user.your_year.equals("")) {
                    startYear = Integer.parseInt(user.your_year.split("-")[0]);
                    endYear = Integer.parseInt(user.your_year.split("-")[1]);
                }
                ps.setInt(2, startYear);
                ps.setInt(3, endYear);
                ps.setString(4, "%"+user.your_area+"%");
                ps.setString(5, sex);
                rs = ps.executeQuery();
                userList = new ArrayList<>();
                while (rs.next()) {
                    //获取其他人的信息
                    int id = rs.getInt("id");
                    String f_mime_name = rs.getString("mime_name").trim();//不去空格的话，导致后面ajax显示不出select下拉数据   ****
                    String f_group_id = rs.getString("group_id").trim();
                    int f_mime_year = rs.getInt("mime_year");
                    String f_mime_area = rs.getString("mime_area").trim();
                    String f_mime_sex = rs.getString("mime_sex").trim();
                    String f_mime_wx_num = rs.getString("mime_wx_num").trim();
                    String f_mime_interest = rs.getString("mime_interest").trim();
                    String f_your_year = rs.getString("your_year").trim();
                    String f_your_area = rs.getString("your_area").trim();
                    String f_your_interest = rs.getString("your_interest").trim();
                    User user1 = new User(f_group_id, f_mime_name, String.valueOf(f_mime_year), f_mime_area, f_mime_sex, f_mime_wx_num, f_mime_interest, f_your_year, f_your_area, f_your_interest);
                    userList.add(user1);
                }
                return userList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(conn, ps, rs);
        }
        return null;
    }

    private void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
