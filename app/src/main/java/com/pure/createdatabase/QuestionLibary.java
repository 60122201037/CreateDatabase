package com.pure.createdatabase;


import android.widget.Button;

public class QuestionLibary {

    private String mQuestion []={
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            "เสียงนี้คือเสียงใคร",
            ""
    };
    private String mChoices [] [] ={
            {"เสกโลโซ","แอด คาราบาว","ดา เอนโนดฟิน"},
            {"หนุ่ย อำพล","อัสนี วสัน","หฟกฟหกฟ"},
            {"น้ำอุ่น","น้ำร้อน","น้ำแข้ง"},
            {"ให้ผู้ที่แขนหักกินยา เพื่อลดอาการปวด","ใช้น้ำอุ่นประคบตรงที่แขนหัก","ใช้ประคบน้ำแข็ง หรือยกแขนขึ้นเหนือหัวใจ"},
            {"ใช้การประคบน้ำแข็ง หรือยกแขนขึ้นเหนือหัวใจ","ใช้ทายาตรงที่แขนหัก เพื่อลดอาการบวม","ใช้ถุงน้ำอุ่นมาประคบ เเล้วทายาตรงที่แขนหัก"},
            {"ใช้ผ้าพันแผล พันไปที่แผลเลย","ใช้ผ้าสะอาดกดแผลไว้ให้แน่น 15 นาที","ใช้ถุงน้ำอุ่นประคบไปตรงที่แผล"},
            {"CRV","CPR","ROV"},
            {"ปลดเครื่องแต่งกายที่มันรัดแน่นออก","เขย่าตัวคนที่ชักเพื่อเรียกให้เขาได้สติ","ไปยืนมุงดูคนที่เกิดอาการชัก"},
            {"ปิดแผลด้วยพลาสเตอร์ปิดแผลเพื่อกันเชื้อโรค","ใช้เข็มขัด หรือผ้ารัดเหนือบริเวรที่ถูกงูกัด","ใช้ปากดูดพิษงูออกมาให้หมด"},
            {"","",""}
    };
    private String mCorrectAnser [] ={"เสกโลโซ","หนุ่ย อำพล","น้ำแข้ง","ใช้ประคบน้ำแข็ง หรือยกแขนขึ้นเหนือหัวใจ","ใช้การประคบน้ำแข็ง หรือยกแขนขึ้นเหนือหัวใจ","ใช้ผ้าสะอาดกดแผลไว้ให้แน่น 15 นาที","CPR","ปลดเครื่องแต่งกายที่มันรัดแน่นออก","ปิดแผลด้วยพลาสเตอร์ปิดแผลเพื่อกันเชื้อโรค"};

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }
    public String getChoicel(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;

    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnser[a];
        return answer;
    }


}