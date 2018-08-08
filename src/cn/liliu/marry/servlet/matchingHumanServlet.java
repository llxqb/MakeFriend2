package cn.liliu.marry.servlet;
/**
 * 首页selvlet
 */

import cn.liliu.marry.dao.indexDao;
import cn.liliu.marry.daoimpl.indexDaoImpl;
import cn.liliu.marry.entity.User;
import cn.liliu.marry.utils.RSATools;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.PrivateKey;
import java.util.Base64;
import java.util.List;

import static cn.liliu.marry.utils.RSATools.decrypt;
import static cn.liliu.marry.utils.RSATools.encrypt;

public class matchingHumanServlet extends HttpServlet {
    //获取私钥，并以base64格式打印出来
//    PrivateKey privateKey = RSATools.keyStrToPrivate(RSATools.PRIVATE_RSA);
    indexDao dao = new indexDaoImpl();
    List<User> mList;
    User user = null;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));


        Cookie[] cookies = req.getCookies();
        String groupId = null;
        String mimeName = null;
        String mimeYear = null;
        String mimeArea = null;
        String mimeSex = null;
        String mimeWXNum = null;
        String mimeInterest = null;
        String yourYear = null;
        String yourArea = null;
        String yourInterest = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                if ("group_id".equals(name)) {//如果是中文，cookies需要解码
                    groupId = cookies[i].getValue();
                } else if ("mime_name".equals(name)) {
                    mimeName = cookies[i].getValue();
                } else if ("mime_year".equals(name)) {
                    mimeYear = cookies[i].getValue();
                } else if ("mime_area".equals(name)) {
                    mimeArea = cookies[i].getValue();
                } else if ("mime_sex".equals(name)) {
                    mimeSex = cookies[i].getValue();
                } else if ("mime_wx_num".equals(name)) {
                    mimeWXNum = cookies[i].getValue();
                } else if ("mime_interest".equals(name)) {
                    mimeInterest = cookies[i].getValue();
                } else if ("your_year".equals(name)) {
                    yourYear = cookies[i].getValue();
                } else if ("your_area".equals(name)) {
                    yourArea = cookies[i].getValue();
                } else if ("your_interest".equals(name)) {
                    yourInterest = cookies[i].getValue();
                }
            }
            user = new User(groupId, mimeName, mimeYear, mimeArea, mimeSex, mimeWXNum, mimeInterest, yourYear, yourArea, yourInterest);
        }

        try {
            if (user != null) {
                mList = dao.findUserInfo(user);
                if (mList != null) {
                    if (mList.size() > 0) {
                        req.setAttribute("userList", mList);
                        req.setAttribute("msg", 0);
                    } else {
                        req.setAttribute("msg", 1);
                    }
                    req.getRequestDispatcher("matchingHuman.jsp").forward(req, resp);//转发
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //私钥解密
    private String dencodeValue(String value) {
        String dencode = "";
//        if (value != null && !value.equals("")) {
//            //公钥加密
//            try {
//                byte[] encryptedBytes = encrypt(value.getBytes(), homeServlet.publicKey);
//                //私钥解密
//                byte[] decryptedBytes = decrypt(encryptedBytes, privateKey);
//                dencode = new String(decryptedBytes);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return dencode;
    }
}

