package com.kingyal.useproxy;

public class FangDongProxy implements FangDongService{
    private FangDongService fangDongService = new FangDongServiceImpl();
    public void zufang() {
        // 辅助功能，额外功能
        System.out.println("发布租房信息");
        System.out.println("带租客看房");
        // 核心业务
        fangDongService.zufang();
    }
}
