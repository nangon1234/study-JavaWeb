package com.bo.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName CaptchaUtil
 * @Description 产生验证码工具类
 * @Author nangon1234
 * @Date 2019/10/4
 * @Version 1.0
 **/
public class CaptchaUtil
{
    private static int WIDTH = 60;  //验证码图片宽度
    private static int HEIGHT = 20; //验证码图片高度
    private BufferedImage image;    //图像
    private String str;
    public CaptchaUtil()
    {
        init();//初始化。

    }
    /**
     * 取得RandomNumUtil实例
     * @return
     */
    public static CaptchaUtil Instance()
    {
        return  new CaptchaUtil();
    }
    private void init()
    {
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //产生随机验证码
        char[] rands = this.generateCheckCode();
        //产生图像
        this.drawBackground(g);
        this.drawRands(g,rands);
        //结束图像的绘制过程，完成图像
       g.dispose();
    }

    /**
     * @description 取得图片的验证码
     * @return
     */
    public BufferedImage getImage()
    {
        return this.image;
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
        g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
        //在不同高度上输出验证码的每个字符
        g.drawString(""+rands[0],1,17);
        g.drawString(""+rands[1],16,15);
        g.drawString(""+rands[2],31,18);
        g.drawString(""+rands[3],46,16);
        System.out.println(rands);
    }
}

    