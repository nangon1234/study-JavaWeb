package com.bo.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @ClassName CheckServlet
 * @Description TODO
 * @Author nangon1234
 * @Date 2019/10/1
 * @Version 1.0
 **/
@WebServlet (urlPatterns = "/CheckServlet")
public class CheckServlet extends HttpServlet
{
    private static int WIDTH = 60; //验证码图片宽度
    private static int HEIGHT = 20; //验证码图片高度

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        resp.setContentType("image/jpeg");
        ServletOutputStream sos =  resp.getOutputStream();
        //设置浏览器不缓存此图片
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);
        //创建内存图片并获得图像上下文
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //产生随机验证码
        char[] rands = this.generateCheckCode();
        //产生图像
        this.drawBackground(g);
        this.drawRands(g,rands);
        //结束图像的绘制过程，完成图像
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image,"JPEG",bos);
        byte[] buf = bos.toByteArray();
        resp.setContentLength(buf.length);
        sos.write(buf);
        bos.close();
        sos.close();
        //从 sos.write(buf);bos.close(); 到sos.close();可以合并写成  bos.writeTo(sos);

        //将当前验证码存入到Session 对象中
        session.setAttribute("check_code",new String(rands));

    }

    //定义生成一个4字符的验证码
    private char[] generateCheckCode()
    {
        //定义生成验证码的字符表
        String chars ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] rands = new char[4];
        for(int i=0;i<4;i++)
           {
               int rand = (int)(Math.random()*62);
               rands[i] = chars.charAt(rand);
           }
        return rands;
    }

    private void drawBackground(Graphics g)
    {
        //画背景
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0,0,WIDTH,HEIGHT);
        //随机产生120个干扰点
        for(int i=0;i<120;i++)
           {
               int x=(int)(Math.random()*WIDTH);
               int y=(int)(Math.random()*HEIGHT);
               int red=(int)(Math.random()*255);
               int green=(int)(Math.random()*255);
               int blue=(int)(Math.random()*255);
               g.setColor(new Color(red,green,blue));
               g.drawOval(x,y,1,0);
           }
    }

    private void drawRands(Graphics g,char[] rands)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,18));
        //在不同高度上输出验证码的每个字符
        g.drawString(""+rands[0],1,17);
        g.drawString(""+rands[1],16,15);
        g.drawString(""+rands[2],31,18);
        g.drawString(""+rands[3],46,16);

    }
}

    