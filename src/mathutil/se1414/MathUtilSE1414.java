/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathutil.se1414;

import mathutil.util.MathUtil;

/**
 *
 * @author Cyrus
 */
public class MathUtilSE1414 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //5! hy vọng máy sẽ in ra 120
        System.out.println("5!=  "+ MathUtil.computeFactorial(5));
        
        //6! hy vọng (expected) máy sẽ in ra 720
        //thực tế nó ra bao nhiêu thì phải chạy mới biết
        //thực tế kết quả trả về lúc chạy app gọi là ACTUAL
        System.out.println("6! = "+MathUtil.computeFactorial(6));
        //actual: 720, expected: 720 -> đúng rồi
        //actual: 1000, expected: 720 -> toang hàm chạy sai, viết sai
        
        //expected: 1 if cF(0), chạy hàm cF(0) hy vọng nhận về 1
        //nếu ko về 1, tức là actual khác expected, hàm viết code sai
        System.out.println("0! = "+MathUtil.computeFactorial(0));
        
        System.out.println("1! = "+MathUtil.computeFactorial(1));
        
        //chạy F6, nhìn kết quả, luận đúng sai bằng mắt trên từng hàm sout()
        System.out.println("-5! = "+MathUtil.computeFactorial(-5));
        //tao kì vọng mày/hmaf cF() mình đang chơi, phải ném về ngoại lệ
        //do tao đưa vào dữ liệu cà chớn
        //-5! tính thế mẹ nào đc, do ! chơi vs 0,1,2,3,...
        
        //do ta chơi trờ sout() nên sai đúng cứ in ra kết qwuar, ta phải 
        //luận đúng sai = mắt
        //-5! = 1, thì phải nhìn kq in khi chạy -> luận đúng sai
        //HỢP LÍ NHƯNG NHÌN BẰNG MẮT, SO SÁNH TRONG ĐẦU, DỄ BỊ SAI SÓT
        
        //giang hồ độ ta 1 bộ thư viện, giúp ta test các hàm dùng màu sắc
        //xanh -> code chạy đúng kỳ vọng
        //đỏ -> code chạy sai kì vọng
        //viết thêm đoạn code tự so sánh giùm giữa expected và actual để
        //ném ra màu, mình chỉ cần nhìn màu, ko cần tự so sánh và kết luận
        //kĩ thuật này gọi là TDD kết hợp với UnitTesting xài các thư viện
        //phụ trợ JUnit, NUnit, TestNG, PHPUnit, CPPUnit, xUnit, MSTest,...
        
        
    }
    
}
