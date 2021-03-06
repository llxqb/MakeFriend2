package cn.liliu.marry.servlet;
/**
 * 首页selvlet
 */

import cn.liliu.marry.dao.indexDao;
import cn.liliu.marry.daoimpl.indexDaoImpl;
import cn.liliu.marry.entity.Constant;
import cn.liliu.marry.entity.User;
import cn.liliu.marry.utils.RSATools;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class homeServlet extends HttpServlet {
    indexDao dao = new indexDaoImpl();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        try {
            String mGroupId = req.getParameter("group_id");
            String mMimeName = req.getParameter("mime_name");
            String mMimeYear = req.getParameter("mime_year");
            String mMimeArea = req.getParameter("mime_area");
            String mMimeSex = req.getParameter("mime_sex");
            String mMimeWXNum = req.getParameter("mime_wx_num");
            String mMimeInterest = req.getParameter("mime_interest");
            String mYourYear = req.getParameter("your_year");
            String mYourArea = req.getParameter("year_area");
            String mYourInterest = req.getParameter("your_interest");

            User user = new User(mGroupId, mMimeName, mMimeYear, mMimeArea, mMimeSex, mMimeWXNum, mMimeInterest, mYourYear, mYourArea, mYourInterest);
            boolean userFlag = dao.insertUserInfo(user);
            System.out.println("userFlag:" + userFlag);
            if (userFlag) {//插入成功
                RSATools rsaTools= new RSATools();
                Cookie cookie0 = new Cookie("group_id", rsaTools.encodeValue(user.group_id));
                Cookie cookie1 = new Cookie("mime_name", rsaTools.encodeValue(user.mime_name));
                Cookie cookie2 = new Cookie("mime_year", rsaTools.encodeValue(user.mime_year));
                Cookie cookie3 = new Cookie("mime_area", rsaTools.encodeValue(user.mime_area));
                Cookie cookie4 = new Cookie("mime_sex", rsaTools.encodeValue(user.mime_sex));
                Cookie cookie5 = new Cookie("mime_wx_num", rsaTools.encodeValue(user.mime_wx_num));
                Cookie cookie6 = new Cookie("mime_interest", rsaTools.encodeValue(user.mime_interest));
                Cookie cookie7 = new Cookie("your_year", rsaTools.encodeValue(user.your_year));
                Cookie cookie8 = new Cookie("your_area", rsaTools.encodeValue(user.your_area));
                Cookie cookie9 = new Cookie("your_interest", rsaTools.encodeValue(user.your_interest));
                //设置保存时间
                int keepTime = 20 * 24 * 60 * 60;
                cookie0.setMaxAge(keepTime);
                cookie1.setMaxAge(keepTime);
                cookie2.setMaxAge(keepTime);
                cookie3.setMaxAge(keepTime);
                cookie4.setMaxAge(keepTime);
                cookie5.setMaxAge(keepTime);
                cookie6.setMaxAge(keepTime);
                cookie7.setMaxAge(keepTime);
                cookie8.setMaxAge(keepTime);
                cookie9.setMaxAge(keepTime);
                //设置保存路径
                cookie0.setPath(req.getContextPath() + "/");
                //添加到响应头
                resp.addCookie(cookie0);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                resp.addCookie(cookie3);
                resp.addCookie(cookie4);
                resp.addCookie(cookie5);
                resp.addCookie(cookie6);
                resp.addCookie(cookie7);
                resp.addCookie(cookie8);
                resp.addCookie(cookie9);

                req.setAttribute("msg", 2);
                resp.sendRedirect("matchingHuman.jsp");
//                req.getRequestDispatcher("matchingHuman.jsp").forward(req, resp);//转发
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

