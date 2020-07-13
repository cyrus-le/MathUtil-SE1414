/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import static junit.framework.Assert.assertEquals;
//import mathutil.util.MathUtil;

import static mathutil.util.MathUtil.computeFactorial;
import org.junit.Test;

/**
 *
 * @author Cyrus
 */
public class UnitTestTest {

    //đây là class truyền thống, dùng để test code chính của mình ở bên
    //MathUtil
    //nhưng ta ko xài sout() mà ta xài màu sắc xanh đỏ
    //class này chứa rất nhiều hàm main()
    //muốn có hàm bk trong này thành main() bạn chỉ việc xài annotation
    //@Test, JVM sẽ tự động hiểu hàm này là main() và Shift F6 chạy từ đó
    //nếu có nhiều @Tes tức là nhiều main() trong này, các main() sẽ
    //chạy tuần tự theo mặc định từ trên xuống
    @Test
    //hàm main() này dùng để test các tình huống hàm cF() nhận đúng
    //tham số và mày phải chạy đúng kì vọng
    public void testSuccessfulCases() {

//  hy vọng 5! trả về 120 không thế, màu đỏ nha bạn
        assertEquals(120, computeFactorial(5));

//hy vọng trả về 720 là của 6!, ko như thếm đỏ nha bạn
        assertEquals(720, computeFactorial(6));
        
        assertEquals(1, computeFactorial(0)); //hy vọng 0! là 1 heng
        assertEquals(1, computeFactorial(1)); //hy vọng 1! là 1 heng
        assertEquals(2, computeFactorial(2)); //hy vọng 1! là 1 heng

        //xanh chỉ xảy ra khi tất cả xanh, hàm ý hàm chạy đúng kì vọng mọi t/hợp
        //đỏ thì chỉ cần 1 thằng đỏ trong cả đám xanh
        //hàm ý: mày xanh gần hết, còn vài case màu đỏ
        //chứng tỏ xử lí hàm ko tốt, ko chạy tốt cho mọi trường hợp
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFailedCases(){
        computeFactorial(-5);
        //hàm này dùng để test các tình huống cà chớn đến từ người dùng
        //ví dụ người dùng mún tính -5! thì tính thế mẹ nào đc
        //khi đó trong thiết kế của hàm cF() ta phải dự liệu tình huống cà
        //chớn này, tức là người dùng đưa data cà chớn vào thì mình
        //ném ra cái ngoại lệ, hok thèm xử lí
        //cF(-5) đạp vào mặt cái ngoại lệ
        //và ngoại lệ là 1 thứ bất thường, ko như dự tính, ko phải là 1 loại
        //value có thể so sánh, tức là ko thể assertEquals(một-cái-ngoại-lệ)
        //tức là phải có value để so, mà ngoại lệ Exception thì ko phải là value
        //ta phải dùng chiêu
    }
    //dù code bạn viết có đỏ hay xanh miễn ko bị lỗi cú pháp khi gõ, lỗi import
    //thì CLEAN & BUILD LUÔN RA ĐC FILE .JAR .WAR
    //lí do là cái thằng Clean và Build nó chỉ kiểm tra code ko sai cú pháp
    //nó ko care cide cí sai logic xử lí hay ko
    
    
    //MÌNH CHƠI LỚN:
    //NẾU CODE ĐANG MÀU ĐỎ, HOK PHẢI XANH, CẦN CLEAN & BUILD ĐỂ ĐẢM BẢO RẰNG
    //CODE PHẢI CHẠY ĐÚNG (MÀU XANH) CHO CÁC TÌNH HUỐNG XÀI THỬ QUA ASSERT()
    //TỨC LÀ ĐÚNG VỀ XỬ LÍ THÌ MỚI CHO RA FILE .JAR .WAR
    //TỨC LÀ ĐÈN XANH THÌ THÔNG THƯỜNG
    //ĐỎ, VỊN LẠI, HOK CHO RA .JAR .WAR
    //PLEASE, NHỚ 2 CON SỐ
    //NETBEAN 8X, 1005
    //NETBEAN 10X TRỞ LÊN, 1204
    
}
